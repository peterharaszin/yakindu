/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.codegen.c.codefragments

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.damos.mscript.InputParameterDeclaration
import org.eclipse.damos.mscript.ParameterDeclaration
import org.eclipse.damos.mscript.VariableDeclaration
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IFunctionContextFactory
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IInitializeFunctionFactory
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IUpdateFunctionFactory
import org.eclipse.damos.mscript.function.FunctionInstance
import org.eclipse.damos.mscript.function.util.FunctionModelUtil
import org.eclipse.damos.mscript.util.MscriptUtil

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory

/**
 * @author Andreas Unger
 *
 */
class ComputeFunction extends AbstractCodeFragment implements IComputeFunction {

	@Inject
	IInitializeFunctionFactory initializeFunctionFactory
	
	@Inject
	IUpdateFunctionFactory updateFunctionFactory

	@Inject
	ICompoundStatementGenerator compoundStatementGenerator
	
	@Inject
	IFunctionContextFactory functionContextFactory
	
	@Inject
	MachineDataTypeFactory machineDataTypeFactory
	
	val IMscriptGeneratorContext generatorContext
	
	String name
	
	FunctionInstance functionInstance
	CharSequence functionSignature
	CharSequence functionBody

	InitializeFunction initializeFunction	
	UpdateFunction updateFunction
	ContextStruct contextStruct

	new(IMscriptGeneratorContext generatorContext) {
		this.generatorContext = generatorContext
	}
	
	/**
	 * @return the name
	 */
	override String getName() {
		return name
	}
	
	override ContextStruct getContextStruct() {
		return contextStruct
	}
	
	override InitializeFunction getInitializeFunction() {
		initializeFunction
	}

	override UpdateFunction getUpdateFunction() {
		updateFunction
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		functionInstance = generatorContext.functionInfo.functionInstance

		val codeFragmentCollector = context.codeFragmentCollector
		
		name = context.globalNameProvider.newGlobalName(generatorContext.functionInfo.functionDescription.declaration.name)

		if (generatorContext.functionInfo.functionDescription.stateful) {
			contextStruct = new ContextStruct(generatorContext.functionInfo, false)
			contextStruct = codeFragmentCollector.addCodeFragment(contextStruct, new NullProgressMonitor())
			val functionContextDeclaration = functionContextFactory.create(generatorContext)
			contextStruct.addMember(functionContextDeclaration)
			addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it == contextStruct])
			
			updateFunction = codeFragmentCollector.addCodeFragment(updateFunctionFactory.create(generatorContext, this), new NullProgressMonitor()) as UpdateFunction
			initializeFunction = codeFragmentCollector.addCodeFragment(initializeFunctionFactory.create(generatorContext, this), new NullProgressMonitor()) as InitializeFunction
		}

		functionSignature = generateFunctionSignature(codeFragmentCollector)
		functionBody = '''
			{
				«generateDataType(generatorContext.codeFragmentCollector, functionInstance.declaration.outputParameterDeclarations.head)»;
				«FOR compound : functionInstance.computationCompounds»
					«IF compound.derivatives.empty && !compound.outputs.empty»
						«compoundStatementGenerator.generate(generatorContext, compound.statements)»
					«ENDIF»
				«ENDFOR»
				«FOR inputParameterDeclaration : FunctionModelUtil::getDirectFeedthroughInputs(functionInstance)»
					«IF generatorContext.functionInfo.getCircularBufferSize(inputParameterDeclaration) > 1»
						«generateUpdateContextStatement(inputParameterDeclaration)»
					«ENDIF»
				«ENDFOR»
				«FOR outputParameterDeclaration : functionInstance.declaration.outputParameterDeclarations»
					«IF generatorContext.functionInfo.getCircularBufferSize(outputParameterDeclaration) > 1»
						«generateUpdateContextStatement(outputParameterDeclaration)»
					«ENDIF»
				«ENDFOR»
				return «functionInstance.declaration.outputParameterDeclarations.head.name»;
			}
		'''
	}

	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature» «functionBody»
	'''
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		val functionDeclaration = generatorContext.functionInfo.functionDescription.declaration
		val inputParameterDeclarations = inputParameterDeclarations
		'''«generateParameterDeclaration(codeFragmentCollector, functionDeclaration.outputParameterDeclarations.head)» «name»(«IF generatorContext.functionInfo.functionDescription.stateful»«contextStruct.name» *context«IF !inputParameterDeclarations.empty», «ENDIF»«ENDIF»«FOR inputParameter : inputParameterDeclarations SEPARATOR ", "»«generateParameterDeclaration(codeFragmentCollector, inputParameter)»«ENDFOR»)'''
	}
	
	def private getInputParameterDeclarations() {
		FunctionModelUtil::getDirectFeedthroughInputs(generatorContext.functionInfo.functionInstance)
	}
	
	def private CharSequence generateParameterDeclaration(ICodeFragmentCollector codeFragmentCollector, ParameterDeclaration parameterDeclaration) {
		val variableName = if (parameterDeclaration instanceof InputParameterDeclaration) {
			parameterDeclaration.name
		}
		generateDataType(codeFragmentCollector, parameterDeclaration, variableName)
	}
	
	def private CharSequence generateDataType(ICodeFragmentCollector codeFragmentCollector, ParameterDeclaration parameterDeclaration) {
		val dataType = generatorContext.functionInfo.getValue(parameterDeclaration).dataType
		machineDataTypeFactory.create(generatorContext.configuration, dataType).generateDataType(parameterDeclaration.name, codeFragmentCollector, this)
	}

	def private CharSequence generateDataType(ICodeFragmentCollector codeFragmentCollector, ParameterDeclaration parameterDeclaration, String variableName) {
		val dataType = generatorContext.functionInfo.getValue(parameterDeclaration).dataType
		machineDataTypeFactory.create(generatorContext.configuration, dataType).generateDataType(variableName, codeFragmentCollector, this)
	}
	
	def private CharSequence generateUpdateContextStatement(ParameterDeclaration inputParameterDeclaration) '''
		«generatorContext.variableAccessStrategy.generateContextMemberAccess(false, inputParameterDeclaration.name)»[«generateIndexVariable(inputParameterDeclaration)»] = «generatorContext.variableAccessStrategy.generateVariableReference(MscriptUtil::createVariableReference(generatorContext.functionInfo, inputParameterDeclaration, 0, false))»;
	'''

	def private CharSequence generateIndexVariable(VariableDeclaration variableDeclaration) {
		generatorContext.variableAccessStrategy.generateContextMemberAccess(false, variableDeclaration.name + "_index")
	}

	override int hashCode() {
		return ^class.hashCode.bitwiseXor(generatorContext.functionInfo.hashCode).bitwiseXor(generatorContext.configuration.computationModel.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof ComputeFunction) {
			val other = obj as ComputeFunction
			return other.generatorContext.functionInfo == generatorContext.functionInfo && other.generatorContext.configuration.computationModel == generatorContext.configuration.computationModel
		}
		return false
	}

}

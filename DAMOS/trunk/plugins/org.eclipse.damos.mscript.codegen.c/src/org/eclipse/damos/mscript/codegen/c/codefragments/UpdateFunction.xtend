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

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.damos.mscript.InputParameterDeclaration
import org.eclipse.damos.mscript.MscriptPackage
import org.eclipse.damos.mscript.ParameterDeclaration
import org.eclipse.damos.mscript.VariableDeclaration
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipse.damos.mscript.codegen.c.CompoundStatementGenerator
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipse.damos.mscript.codegen.c.LiteralGenerator
import org.eclipse.damos.mscript.codegen.c.OperationGeneratorProvider
import org.eclipse.damos.mscript.codegen.c.StatementGenerator
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipse.damos.mscript.codegen.c.internal.VariableReferenceGenerator
import org.eclipse.damos.mscript.function.FunctionInstance
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo
import org.eclipse.damos.mscript.util.MscriptUtil

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*
import org.eclipse.damos.mscript.function.util.FunctionModelUtil

/**
 * @author Andreas Unger
 *
 */
class UpdateFunction extends AbstractCodeFragment {

	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()
	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator()
	val VariableReferenceGenerator variableAccessGenerator = new VariableReferenceGenerator(expressionGenerator, new LiteralGenerator(dataTypeGenerator))
	val VariableDeclarationGenerator variableDeclarationGenerator = new VariableDeclarationGenerator(new DataTypeGenerator())
	val IOperationGeneratorProvider operationGeneratorProvider = new OperationGeneratorProvider()
	val ICompoundStatementGenerator compoundStatementGenerator = new CompoundStatementGenerator(new StatementGenerator(expressionGenerator, dataTypeGenerator, variableDeclarationGenerator, variableAccessGenerator, operationGeneratorProvider), variableDeclarationGenerator)

	val IMscriptGeneratorContext generatorContext
	val ComputeFunction computeFunction
	
	String name
	
	StaticFunctionInfo functionInfo
	FunctionInstance functionInstance
	CharSequence functionSignature
//	CharSequence functionBody
	ContextStruct contextStruct
	
	new(IMscriptGeneratorContext generatorContext, ComputeFunction computeFunction) {
		this.generatorContext = generatorContext
		this.computeFunction = computeFunction
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it == computeFunction])

		functionInfo = generatorContext.functionInfo
		functionInstance = functionInfo.functionInstance

		val codeFragmentCollector = context.codeFragmentCollector
		
		name = context.globalNameProvider.newGlobalName(generatorContext.functionInfo.functionDescription.declaration.name + "_update")
		
		contextStruct = if (functionInfo.getFunctionDescription().getDeclaration().eClass() != MscriptPackage::eINSTANCE.getStandardFunctionDeclaration()) {
			codeFragmentCollector.addCodeFragment(new ContextStruct(false /* TODO */), new NullProgressMonitor());
		} else {
			codeFragmentCollector.addCodeFragment(new ContextStruct(functionInfo, false /* TODO */), new NullProgressMonitor());
		}

		functionSignature = generateFunctionSignature(codeFragmentCollector)
//		functionBody = '''
//			{
//				«FOR compound : functionInstance.computationCompounds»
//					«IF compound.derivatives.empty && compound.outputs.empty»
//						«compoundStatementGenerator.generate(generatorContext, compound.statements)»
//					«ENDIF»
//				«ENDFOR»
//				«FOR updateCall : structContext.updateCalls»
//					«updateCall»
//				«ENDFOR»
//			}
//		'''
	}

	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) {
		val computeOutputsCodeInputs = FunctionModelUtil::getDirectFeedthroughInputs(functionInstance)
		'''
			«IF internal»static «ENDIF»«functionSignature» {
				«FOR compound : functionInstance.computationCompounds»
					«IF compound.derivatives.empty && compound.outputs.empty»
						«compoundStatementGenerator.generate(generatorContext, compound.statements)»
					«ENDIF»
				«ENDFOR»
				«FOR inputParameterDeclaration : functionInstance.declaration.nonConstantInputParameterDeclarations»
					«IF generatorContext.functionInfo.getCircularBufferSize(inputParameterDeclaration) > 1 && !computeOutputsCodeInputs.contains(inputParameterDeclaration)»
						«generateUpdateInputContextStatement(inputParameterDeclaration)»
					«ENDIF»
				«ENDFOR»
				«FOR variableDeclaration : statefulVariables»
					«variableDeclaration.generateIndexVariable()» = («variableDeclaration.generateIndexVariable()» + 1) % «functionInfo.getCircularBufferSize(variableDeclaration)»;
				«ENDFOR»
				«FOR updateCall : contextStruct.updateCalls»
					«updateCall»
				«ENDFOR»
			}
		'''
	}
	
	def private getStatefulVariables() {
		val functionDeclaration = functionInfo.getFunctionInstance().getDeclaration()
		(functionDeclaration.nonConstantInputParameterDeclarations
			+ functionDeclaration.outputParameterDeclarations
			+ functionDeclaration.stateVariableDeclarations).filter([functionInfo.getCircularBufferSize(it) > 1])
	}
	
	def private CharSequence generateUpdateInputContextStatement(InputParameterDeclaration inputParameterDeclaration) '''
		«generatorContext.variableAccessStrategy.generateContextMemberAccess(false, inputParameterDeclaration.name)»[«generateIndexVariable(inputParameterDeclaration)»] = «generatorContext.variableAccessStrategy.generateVariableReference(MscriptUtil::createVariableReference(generatorContext.functionInfo, inputParameterDeclaration, 0, false))»;
	'''

	def private CharSequence generateIndexVariable(VariableDeclaration variableDeclaration) {
		generatorContext.variableAccessStrategy.generateContextMemberAccess(false, variableDeclaration.name + "_index")
	}
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		val inputParameterDeclarations = inputParameterDeclarations
		'''void «name»(«IF generatorContext.functionInfo.functionDescription.stateful»«computeFunction.contextStruct.name» *context«IF !inputParameterDeclarations.empty», «ENDIF»«ENDIF»«FOR inputParameter : inputParameterDeclarations SEPARATOR ", "»«generateParameterDeclaration(codeFragmentCollector, inputParameter)»«ENDFOR»)'''
	}
	
	def private CharSequence generateParameterDeclaration(ICodeFragmentCollector codeFragmentCollector, ParameterDeclaration parameterDeclaration) {
		val variableName = if (parameterDeclaration instanceof InputParameterDeclaration) {
			parameterDeclaration.name
		}
		generateDataType(codeFragmentCollector, parameterDeclaration, variableName)
	}
	
	def private CharSequence generateDataType(ICodeFragmentCollector codeFragmentCollector, ParameterDeclaration parameterDeclaration, String variableName) {
		val dataType = generatorContext.functionInfo.getValue(parameterDeclaration).dataType
		MachineDataTypes::create(generatorContext.configuration, dataType).generateDataType(variableName, codeFragmentCollector, this)
	}
	
	def private getInputParameterDeclarations() {
		generatorContext.functionInfo.functionDescription.declaration.nonConstantInputParameterDeclarations//.filter([!FunctionModelUtil::isDirectFeedthrough(generatorContext.functionInfo.functionInstance, it)])
	}

	override int hashCode() {
		return ^class.hashCode.bitwiseXor(generatorContext.functionInfo.hashCode).bitwiseXor(generatorContext.configuration.computationModel.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof UpdateFunction) {
			val other = obj as UpdateFunction
			return other.functionInfo == functionInfo && other.generatorContext.configuration.computationModel == generatorContext.configuration.computationModel
		}
		return false
	}

}

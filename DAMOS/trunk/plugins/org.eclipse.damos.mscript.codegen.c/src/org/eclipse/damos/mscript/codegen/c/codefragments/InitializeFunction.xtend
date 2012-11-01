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
import org.eclipse.damos.mscript.MscriptPackage
import org.eclipse.damos.mscript.VariableDeclaration
import org.eclipse.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.function.FunctionInstance
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory

/**
 * @author Andreas Unger
 *
 */
class InitializeFunction extends AbstractCodeFragment {

	@Inject
	ICompoundStatementGenerator compoundStatementGenerator
	
	@Inject
	IContextStructFactory contextStructFactory

	val IMscriptGeneratorContext generatorContext
	val IComputeFunction computeFunction
	
	String name
	
	StaticFunctionInfo functionInfo
	FunctionInstance functionInstance
	CharSequence functionSignature
	ContextStruct contextStruct
	
	new(IMscriptGeneratorContext generatorContext, IComputeFunction computeFunction) {
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
		
		name = context.globalNameProvider.newGlobalName(generatorContext.functionInfo.functionDescription.declaration.name + "_initialize")
		
		contextStruct = if (functionInfo.getFunctionDescription().getDeclaration().eClass() != MscriptPackage::eINSTANCE.getStandardFunctionDeclaration()) {
			codeFragmentCollector.addCodeFragment(contextStructFactory.create(null, null, false /* TODO */) as ContextStruct, new NullProgressMonitor());
		} else {
			codeFragmentCollector.addCodeFragment(contextStructFactory.create(functionInfo, null, false /* TODO */) as ContextStruct, new NullProgressMonitor());
		}

		functionSignature = generateFunctionSignature(codeFragmentCollector)
	}

	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature» {
			«FOR variableDeclaration : statefulVariables»
				«variableDeclaration.generateIndexVariable()» = 0;
			«ENDFOR»
			«compoundStatementGenerator.generate(generatorContext, functionInstance.initializationCompound.statements)»
			«FOR initializeCall : contextStruct.initializeCalls»
				«initializeCall»
			«ENDFOR»
		}
	'''
	
	def private CharSequence generateIndexVariable(VariableDeclaration variableDeclaration) {
		generatorContext.variableAccessStrategy.generateContextMemberAccess(false, variableDeclaration.name + "_index")
	}

	def private getStatefulVariables() {
		val functionDeclaration = functionInfo.getFunctionInstance().getDeclaration()
		(functionDeclaration.nonConstantInputParameterDeclarations
			+ functionDeclaration.outputParameterDeclarations
			+ functionDeclaration.stateVariableDeclarations).filter([functionInfo.getCircularBufferSize(it) > 1])
	}

	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		'''void «name»(«IF generatorContext.functionInfo.functionDescription.stateful»«computeFunction.contextStruct.name» *context«ENDIF»)'''
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(generatorContext.functionInfo.hashCode).bitwiseXor(generatorContext.configuration.computationModel.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof InitializeFunction) {
			val other = obj as InitializeFunction
			return other.functionInfo == functionInfo && other.generatorContext.configuration.computationModel == generatorContext.configuration.computationModel
		}
		return false
	}

}

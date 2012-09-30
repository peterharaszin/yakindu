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

package org.eclipselabs.damos.mscript.codegen.c.codefragments

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipselabs.damos.mscript.MscriptPackage
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.CompoundStatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.StatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator
import org.eclipselabs.damos.mscript.function.FunctionInstance
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*
import org.eclipselabs.damos.mscript.VariableDeclaration

/**
 * @author Andreas Unger
 *
 */
class InitializeFunction extends AbstractCodeFragment {

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
		
		name = context.globalNameProvider.newGlobalName(generatorContext.functionInfo.functionDescription.declaration.name + "_initialize")
		
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

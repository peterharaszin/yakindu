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

import java.util.Iterator
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.OperatorKind
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineNumericType

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class ArrayScalarMultiplyFunction extends AbstractCodeFragment {
	
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	val MachineNumericType scalarType
	val MachineArrayType arrayType
	val MachineArrayType resultType

	CharSequence scalarTypeText
	CharSequence elementTypeText
	CharSequence resultTypeText
	
	String name
	
	String functionBody
	
	new(MachineNumericType scalarType, MachineArrayType arrayType, MachineArrayType resultType) {
		this.scalarType = scalarType
		this.arrayType = arrayType
		this.resultType = resultType
	}
	
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])
		
		val codeFragmentCollector = context.codeFragmentCollector

		scalarTypeText = scalarType.generateDataType(codeFragmentCollector, this)
		elementTypeText = arrayType.elementType.generateDataType(codeFragmentCollector, this)
		resultTypeText = resultType.generateDataType(codeFragmentCollector, this)
		
		name = context.globalNameProvider.newGlobalName("multiply");
		
		val leftOperand = new TextualNumericExpressionOperand("scalar", scalarType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand(arrayVariableName + indexVariables.map(["[" + it + "]"]).join(), arrayType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		functionBody = '''
			{
				«resultTypeText» result;
				int «FOR indexVariable : indexVariables SEPARATOR ", "»«indexVariable»«ENDFOR»;
				«generateLoop(0, indexVariables.iterator, multiplyExpression)»
				return result;
			}
		'''
	}
	
	def private generateLoop(int dimension, Iterator<String> indexVariableIt, CharSequence multiplyExpression) '''
		«IF dimension < arrayType.dimensionality»
			«var indexVariable = indexVariableIt.next»
			for («indexVariable» = 0; «indexVariable» < «arrayType.getDimensionSize(dimension)»; ++«indexVariable») {
				«generateLoop(dimension + 1, indexVariableIt, multiplyExpression)»
			}
		«ELSE»
			result.data«FOR indexVariable : indexVariables»[«indexVariable»]«ENDFOR» = «multiplyExpression»;
		«ENDIF»
	'''
	
	def private getIndexVariables() {
		if (arrayType.dimensionality <= 4) {
			return newArrayList("i", "j", "k", "l").take(arrayType.dimensionality);
		}
		return (0 .. arrayType.dimensionality - 1).map(["i" + it])
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«generateFunctionSignature(internal)»;
	'''

	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«generateFunctionSignature(internal)» «functionBody»
	'''
	
	def private CharSequence generateFunctionSignature(boolean internal) '''
		«IF internal»static «ENDIF»«resultTypeText» «name»(«scalarTypeText» scalar, «elementTypeText» «arrayVariableName»«FOR size : arrayType.dimensionSizes»[«size»]«ENDFOR»)'''

	def private getArrayVariableName() {
		switch (arrayType.dimensionality) {
		case 1:
			"vector"
		case 2:
			"matrix"
		default:
			"array"
		}
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(scalarType.hashCode).bitwiseXor(arrayType.hashCode).bitwiseXor(resultType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof ArrayScalarMultiplyFunction) {
			val other = obj as ArrayScalarMultiplyFunction
			return other.scalarType == scalarType
					&& other.arrayType == arrayType
					&& other.resultType == resultType
		}
		return false
	}
	
}

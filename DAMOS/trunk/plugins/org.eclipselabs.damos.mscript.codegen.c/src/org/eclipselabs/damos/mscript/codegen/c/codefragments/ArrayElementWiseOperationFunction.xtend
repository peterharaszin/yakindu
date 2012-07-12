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
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class ArrayElementWiseOperationFunction extends AbstractCodeFragment {
	
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	val OperatorKind operator
	val MachineArrayType leftArrayType
	val MachineArrayType rightArrayType
	val MachineArrayType resultType

	CharSequence leftArrayElementTypeText
	CharSequence rightArrayElementTypeText
	CharSequence resultTypeText
	
	String name
	
	String functionBody
	
	new(OperatorKind operator, MachineArrayType leftArrayType, MachineArrayType rightArrayType, MachineArrayType resultType) {
		this.operator = operator
		this.leftArrayType = leftArrayType
		this.rightArrayType = rightArrayType
		this.resultType = resultType
	}
	
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])
		
		val codeFragmentCollector = context.codeFragmentCollector

		leftArrayElementTypeText = leftArrayType.elementType.generateDataType(codeFragmentCollector, this)
		rightArrayElementTypeText = rightArrayType.elementType.generateDataType(codeFragmentCollector, this)
		resultTypeText = resultType.generateDataType(codeFragmentCollector, this)
		
		name = context.globalNameProvider.newGlobalName(preferredName);
		
		var CharSequence multiplyExpression = getMultiplicativeExpression(codeFragmentCollector)
		
		functionBody = '''
			{
				«resultTypeText» result;
				int «FOR indexVariable : indexVariables SEPARATOR ", "»«indexVariable»«ENDFOR»;
				«generateLoop(0, indexVariables.iterator, multiplyExpression)»
				return result;
			}
		'''
	}
	
	def private getPreferredName() {
		switch (operator) {
		case OperatorKind::ADD:
			"add"
		case OperatorKind::SUBTRACT:
			"subtract"
		case OperatorKind::MULTIPLY:
			"multiply"
		case OperatorKind::DIVIDE:
			"divide"
		case OperatorKind::MODULO:
			"modulo"
		}
	}
	
	def private getMultiplicativeExpression(ICodeFragmentCollector codeFragmentCollector) {
		val leftOperandText = "left" + arrayVariableName + indexVariables.map(["[" + it + "]"]).join()
		val rightOperandText = "right" + arrayVariableName + indexVariables.map(["[" + it + "]"]).join()

		if (operator == OperatorKind::ADD || operator == OperatorKind::SUBTRACT) {
			val operatorSymbol = switch (operator) {
			case OperatorKind::ADD:
				"+"
			case OperatorKind::SUBTRACT:
				"-"
			}
			
			val leftOperand = NumericExpressionCaster::INSTANCE.cast(leftOperandText, leftArrayType.numericElementType.numberFormat, resultType.numericElementType.numberFormat)
			val rightOperand = NumericExpressionCaster::INSTANCE.cast(rightOperandText, rightArrayType.numericElementType.numberFormat, resultType.numericElementType.numberFormat)
			
			return '''«leftOperand» «operatorSymbol» «rightOperand»'''
		}

		val leftOperand = new TextualNumericExpressionOperand(leftOperandText, leftArrayType.numericElementType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand(rightOperandText, rightArrayType.numericElementType.numberFormat);
		return multiplicativeExpressionGenerator.generate(codeFragmentCollector, operator, resultType.numericElementType.numberFormat, leftOperand, rightOperand)
	}
	
	def private generateLoop(int dimension, Iterator<String> indexVariableIt, CharSequence multiplyExpression) '''
		«IF dimension < rightArrayType.dimensionality»
			«var indexVariable = indexVariableIt.next»
			for («indexVariable» = 0; «indexVariable» < «leftArrayType.getDimensionSize(dimension)»; ++«indexVariable») {
				«generateLoop(dimension + 1, indexVariableIt, multiplyExpression)»
			}
		«ELSE»
			result.data«FOR indexVariable : indexVariables»[«indexVariable»]«ENDFOR» = «multiplyExpression»;
		«ENDIF»
	'''
	
	def private getIndexVariables() {
		if (rightArrayType.dimensionality <= 4) {
			return newArrayList("i", "j", "k", "l").take(rightArrayType.dimensionality);
		}
		return (0 .. rightArrayType.dimensionality - 1).map(["i" + it])
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
		«IF internal»static «ENDIF»«resultTypeText» «name»(«leftArrayElementTypeText» left«arrayVariableName»«FOR size : leftArrayType.dimensionSizes»[«size»]«ENDFOR», «rightArrayElementTypeText» right«arrayVariableName»«FOR size : rightArrayType.dimensionSizes»[«size»]«ENDFOR»)'''

	def private getArrayVariableName() {
		switch (leftArrayType.dimensionality) {
		case 1:
			"Vector"
		case 2:
			"Matrix"
		default:
			"Array"
		}
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(operator.hashCode).bitwiseXor(leftArrayType.hashCode).bitwiseXor(rightArrayType.hashCode).bitwiseXor(resultType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof ArrayElementWiseOperationFunction) {
			val other = obj as ArrayElementWiseOperationFunction
			return other.operator == operator
					&& other.leftArrayType == leftArrayType
					&& other.rightArrayType == rightArrayType
					&& other.resultType == resultType
		}
		return false
	}
	
}

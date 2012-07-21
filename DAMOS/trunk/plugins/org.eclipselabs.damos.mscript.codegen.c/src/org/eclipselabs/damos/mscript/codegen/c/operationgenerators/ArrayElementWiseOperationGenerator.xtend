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

package org.eclipselabs.damos.mscript.codegen.c.operationgenerators

import java.util.Iterator
import org.eclipselabs.damos.mscript.ArrayType
import org.eclipselabs.damos.mscript.BinaryExpression
import org.eclipselabs.damos.mscript.Expression
import org.eclipselabs.damos.mscript.OperatorKind
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionCaster
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipselabs.damos.mscript.util.TypeUtil
import org.eclipselabs.damos.mscript.Type

/**
 * @author Andreas Unger
 *
 */
class ArrayElementWiseOperationGenerator implements IOperationGenerator {
	
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (!(expression instanceof BinaryExpression)) {
			return false
		}
		val binaryExpression = expression as BinaryExpression
		if (binaryExpression.operator != OperatorKind::ADD && binaryExpression.operator != OperatorKind::SUBTRACT) {
			return false
		}
		return TypeUtil::isNumericArray(resultDataType)
				&& TypeUtil::isNumericArray(context.staticEvaluationResult.getValue(binaryExpression.leftOperand).dataType)
				&& TypeUtil::isNumericArray(context.staticEvaluationResult.getValue(binaryExpression.rightOperand).dataType)
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val binaryExpression = expression as BinaryExpression
		val codeFragmentCollector = context.codeFragmentCollector

		val leftArrayType = MachineDataTypes::create(context.configuration, context.staticEvaluationResult.getValue(binaryExpression.leftOperand).dataType as ArrayType);
		val rightArrayType = MachineDataTypes::create(context.configuration, context.staticEvaluationResult.getValue(binaryExpression.rightOperand).dataType as ArrayType);
		val resultType = MachineDataTypes::create(context.configuration, resultDataType as ArrayType);

		var CharSequence multiplyExpression = getMultiplicativeExpression(context, codeFragmentCollector, binaryExpression, leftArrayType, rightArrayType, resultType)
		
		'''
			{
				int «FOR indexVariable : getIndexVariables(resultType) SEPARATOR ", "»«indexVariable»«ENDFOR»;
				«generateLoop(0, getIndexVariables(resultType).iterator, multiplyExpression, target, resultType)»
			}
		'''
	}
	
	def private getMultiplicativeExpression(IMscriptGeneratorContext context, ICodeFragmentCollector codeFragmentCollector, BinaryExpression binaryExpression, MachineArrayType leftArrayType, MachineArrayType rightArrayType, MachineArrayType resultType) {
		val leftOperandText = expressionGenerator.generate(context, binaryExpression.leftOperand) + getIndexVariables(resultType).map(["[" + it + "]"]).join()
		val rightOperandText = expressionGenerator.generate(context, binaryExpression.rightOperand) + getIndexVariables(resultType).map(["[" + it + "]"]).join()

		if (binaryExpression.operator == OperatorKind::ADD || binaryExpression.operator == OperatorKind::SUBTRACT) {
			val operatorSymbol = switch (binaryExpression.operator) {
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
		return multiplicativeExpressionGenerator.generate(codeFragmentCollector, binaryExpression.operator, resultType.numericElementType.numberFormat, leftOperand, rightOperand)
	}
	
	def private generateLoop(int dimension, Iterator<String> indexVariableIt, CharSequence multiplyExpression, CharSequence target, MachineArrayType resultType) '''
		«IF dimension < resultType.dimensionality»
			«var indexVariable = indexVariableIt.next»
			for («indexVariable» = 0; «indexVariable» < «resultType.getDimensionSize(dimension)»; ++«indexVariable») {
				«generateLoop(dimension + 1, indexVariableIt, multiplyExpression, target, resultType)»
			}
		«ELSE»
			«target»«FOR indexVariable : getIndexVariables(resultType)»[«indexVariable»]«ENDFOR» = «multiplyExpression»;
		«ENDIF»
	'''
	
	def private getIndexVariables(MachineArrayType resultType) {
		if (resultType.dimensionality <= 4) {
			return newArrayList("i", "j", "k", "l").take(resultType.dimensionality);
		}
		return (0 .. resultType.dimensionality - 1).map(["i" + it])
	}
	
}

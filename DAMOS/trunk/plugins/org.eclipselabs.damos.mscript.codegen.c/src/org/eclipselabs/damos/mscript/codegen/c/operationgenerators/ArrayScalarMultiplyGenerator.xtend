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
import org.eclipselabs.damos.mscript.NumericType
import org.eclipselabs.damos.mscript.OperatorKind
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipselabs.damos.mscript.util.TypeUtil
import org.eclipselabs.damos.mscript.Type

/**
 * @author Andreas Unger
 *
 */
class ArrayScalarMultiplyGenerator implements IOperationGenerator {
	
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (!(expression instanceof BinaryExpression)) {
			return false
		}
		val binaryExpression = expression as BinaryExpression
		if (binaryExpression.operator != OperatorKind::MULTIPLY) {
			return false
		}
		return TypeUtil::isNumericArray(resultDataType)
				&& (context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType instanceof NumericType
				&& TypeUtil::isNumericArray(context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType)
				|| TypeUtil::isNumericArray(context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType)
				&& context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType instanceof NumericType)
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val binaryExpression = expression as BinaryExpression
		val codeFragmentCollector = context.codeFragmentCollector

		val scalarOperand = if (context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType instanceof NumericType) {
			binaryExpression.leftOperand
		} else {
			binaryExpression.rightOperand
		}
		
		val arrayOperand = if (context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType instanceof NumericType) {
			binaryExpression.rightOperand
		} else {
			binaryExpression.leftOperand
		}
		
		val scalarType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(scalarOperand).dataType as NumericType)
		val arrayType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(arrayOperand).dataType as ArrayType)

		val resultType = MachineDataTypes::create(context.configuration, resultDataType as ArrayType);

		val leftOperand = new TextualNumericExpressionOperand(expressionGenerator.generate(context, scalarOperand), scalarType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand(expressionGenerator.generate(context, arrayOperand) + getIndexVariables(resultType).map(["[" + it + "]"]).join(), arrayType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		'''
			{
				int «FOR indexVariable : getIndexVariables(resultType) SEPARATOR ", "»«indexVariable»«ENDFOR»;
				«generateLoop(0, getIndexVariables(resultType).iterator, multiplyExpression, target, resultType)»
			}
		'''
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

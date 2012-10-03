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

package org.eclipse.damos.mscript.codegen.c.operationgenerators

import org.eclipse.damos.mscript.ArrayType
import org.eclipse.damos.mscript.BinaryExpression
import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.OperatorKind
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipse.damos.mscript.util.TypeUtil
import org.eclipse.damos.mscript.Type

/**
 * @author Andreas Unger
 *
 */
class VectorMatrixMultiplyGenerator implements IOperationGenerator {
	
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
				&& TypeUtil::isNumericVector(context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType)
				&& TypeUtil::isNumericMatrix(context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType)
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val binaryExpression = expression as BinaryExpression
		val codeFragmentCollector = context.codeFragmentCollector

		val vectorType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType as ArrayType);
		val matrixType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType as ArrayType);
		val resultType = MachineDataTypes::create(context.configuration, resultDataType as ArrayType);

		val leftOperand = new TextualNumericExpressionOperand(expressionGenerator.generate(context, binaryExpression.leftOperand) + "[j]", vectorType.numericElementType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand(expressionGenerator.generate(context, binaryExpression.rightOperand) + "[j][i]", matrixType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		'''
			{
				int i, j;
				for (i = 0; i < «matrixType.columnSize»; ++i) {
					for (j = 0; j < «matrixType.rowSize»; ++j) {
						«target»[i] += «multiplyExpression»;
					}
				}
			}
		'''
	}
	
}

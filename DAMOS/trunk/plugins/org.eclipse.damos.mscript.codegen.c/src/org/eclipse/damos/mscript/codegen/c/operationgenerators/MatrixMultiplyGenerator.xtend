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

import com.google.inject.Inject
import org.eclipse.damos.mscript.ArrayType
import org.eclipse.damos.mscript.BinaryExpression
import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.OperatorKind
import org.eclipse.damos.mscript.Type
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipse.damos.mscript.util.TypeUtil
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory

/**
 * @author Andreas Unger
 *
 */
class MatrixMultiplyGenerator implements IOperationGenerator {
	
	@Inject
	IExpressionGenerator expressionGenerator
	
	@Inject
	IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator

	@Inject
	MachineDataTypeFactory machineDataTypeFactory

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (!(expression instanceof BinaryExpression)) {
			return false
		}
		val binaryExpression = expression as BinaryExpression
		if (binaryExpression.operator != OperatorKind::MULTIPLY) {
			return false
		}
		return TypeUtil::isNumericArray(resultDataType)
				&& TypeUtil::isNumericMatrix(context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType)
				&& TypeUtil::isNumericMatrix(context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType)
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val binaryExpression = expression as BinaryExpression
		val codeFragmentCollector = context.codeFragmentCollector

		val leftMatrixType = machineDataTypeFactory.create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType as ArrayType);
		val rightMatrixType = machineDataTypeFactory.create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType as ArrayType);
		val resultType = machineDataTypeFactory.create(context.configuration, resultDataType as ArrayType);

		val leftOperand = new TextualNumericExpressionOperand(expressionGenerator.generate(context, binaryExpression.leftOperand) + "[i][j]", leftMatrixType.numericElementType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand(expressionGenerator.generate(context, binaryExpression.rightOperand) + "[j][k]", rightMatrixType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		'''
			{
				int k, i, j;
				for (k = 0; k < «rightMatrixType.columnSize»; ++k) {
					for (i = 0; i < «leftMatrixType.rowSize»; ++i) {
						for (j = 0; j < «leftMatrixType.columnSize»; ++j) {
							«target»[i][k] += «multiplyExpression»;
						}
					}
				}
			}
		'''
	}
	
}

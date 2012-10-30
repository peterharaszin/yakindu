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
import org.eclipse.damos.mscript.codegen.c.NumericExpressionCaster
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory
import org.eclipse.damos.mscript.util.TypeUtil

/**
 * @author Andreas Unger
 *
 */
class MatrixVectorMultiplyGenerator implements IOperationGenerator {
	
	@Inject
	IExpressionGenerator expressionGenerator
	
	@Inject
	IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator

	@Inject
	MachineDataTypeFactory machineDataTypeFactory

	@Inject
	NumericExpressionCaster numericExpressionCaster

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
				&& TypeUtil::isNumericVector(context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType)
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val binaryExpression = expression as BinaryExpression
		val codeFragmentCollector = context.codeFragmentCollector

		val matrixType = machineDataTypeFactory.create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType as ArrayType);
		val vectorType = machineDataTypeFactory.create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType as ArrayType);
		val resultType = machineDataTypeFactory.create(context.configuration, resultDataType as ArrayType);

		val leftOperand = new TextualNumericExpressionOperand(numericExpressionCaster, expressionGenerator.generate(context, binaryExpression.leftOperand) + "[i][j]", matrixType.numericElementType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand(numericExpressionCaster, expressionGenerator.generate(context, binaryExpression.rightOperand) + "[j]", vectorType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		'''
			{
				int i, j;
				for (i = 0; i < «matrixType.rowSize»; ++i) {
					for (j = 0; j < «matrixType.columnSize»; ++j) {
						«target»[i] += «multiplyExpression»;
					}
				}
			}
		'''
	}
	
}

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
import java.util.Iterator
import org.eclipse.damos.mscript.ArrayType
import org.eclipse.damos.mscript.BinaryExpression
import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.OperatorKind
import org.eclipse.damos.mscript.Type
import org.eclipse.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.NumericExpressionCaster
import org.eclipse.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipse.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipse.damos.mscript.util.TypeUtil

/**
 * @author Andreas Unger
 *
 */
class ArrayElementWiseOperationGenerator implements IOperationGenerator {
	
	@Inject
	IExpressionGenerator expressionGenerator
	
	@Inject
	IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (!(expression instanceof BinaryExpression)) {
			return false
		}
		val binaryExpression = expression as BinaryExpression
		if (binaryExpression.operator != OperatorKind::ADD && binaryExpression.operator != OperatorKind::SUBTRACT) {
			return false
		}
		return TypeUtil::isNumericArray(resultDataType)
				&& TypeUtil::isNumericArray(context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType)
				&& TypeUtil::isNumericArray(context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType)
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val binaryExpression = expression as BinaryExpression
		val codeFragmentCollector = context.codeFragmentCollector

		val leftArrayType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.leftOperand).dataType as ArrayType);
		val rightArrayType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(binaryExpression.rightOperand).dataType as ArrayType);
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

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

import org.eclipselabs.damos.mscript.ArrayType
import org.eclipselabs.damos.mscript.BuiltinFunctionDeclaration
import org.eclipselabs.damos.mscript.Expression
import org.eclipselabs.damos.mscript.FunctionCall
import org.eclipselabs.damos.mscript.LambdaExpression
import org.eclipselabs.damos.mscript.Type
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipselabs.damos.mscript.util.TypeUtil
import org.eclipselabs.damos.mscript.util.MscriptUtil

/**
 * @author Andreas Unger
 *
 */
class MapFunctionGenerator implements IOperationGenerator {
	
	val IOperationGeneratorProvider operationGeneratorProvider = new OperationGeneratorProvider()
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (expression instanceof FunctionCall) {
			val functionCall = expression as FunctionCall
			return functionCall.feature instanceof BuiltinFunctionDeclaration && functionCall.feature.name == BuiltinFunctionKind::MAP.getName()
		}
		return false
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val functionCall = expression as FunctionCall
		val lambdaExpression = functionCall.arguments.get(1) as LambdaExpression
		
		val codeFragmentCollector = context.codeFragmentCollector

		val vectorType = MachineDataTypes::create(context.configuration, context.staticEvaluationResult.getValue(functionCall.arguments.get(0)).dataType as ArrayType);
		val elementType = MachineDataTypes::create(context.configuration, (resultDataType as ArrayType).elementType);
		val subType = if ((resultDataType as ArrayType).dimensionality > 1) {
			TypeUtil::createArrayType((resultDataType as ArrayType).elementType, (resultDataType as ArrayType).dimensions.map([TypeUtil::getArrayDimensionSize(it)]))
		} else {
			(resultDataType as ArrayType).elementType
		}
		
		val indexName = MscriptUtil::findAvailableLocalVariableName(lambdaExpression.expression, "i")

		'''
			{
				int «indexName»;
				for («indexName» = 0; «indexName» < «vectorType.size»; ++«indexName») {
					«elementType.generateDataType(lambdaExpression.parameters.get(0).name, codeFragmentCollector, null)» = «expressionGenerator.generate(context, functionCall.arguments.get(0))»[«indexName»];
					«operationGeneratorProvider.getGenerator(context, subType, lambdaExpression.expression).generate(context, subType, target + "[" + indexName + "]", lambdaExpression.expression)»
				}
			}
		'''
	}
	
}

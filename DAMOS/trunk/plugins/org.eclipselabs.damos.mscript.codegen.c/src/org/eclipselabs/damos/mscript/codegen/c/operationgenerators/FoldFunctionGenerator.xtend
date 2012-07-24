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
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind

/**
 * @author Andreas Unger
 *
 */
class FoldFunctionGenerator implements IOperationGenerator {
	
	val IOperationGeneratorProvider operationGeneratorProvider = new OperationGeneratorProvider()
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		if (expression instanceof FunctionCall) {
			val functionCall = expression as FunctionCall
			return functionCall.feature instanceof BuiltinFunctionDeclaration && functionCall.feature.name == BuiltinFunctionKind::FOLD.getName()
		}
		return false
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val functionCall = expression as FunctionCall
		val lambdaExpression = functionCall.arguments.get(2) as LambdaExpression
		
		val codeFragmentCollector = context.codeFragmentCollector

		val vectorType = MachineDataTypes::create(context.configuration, context.staticEvaluationResult.getValue(functionCall.arguments.get(0)).dataType as ArrayType);
		val resultType = MachineDataTypes::create(context.configuration, resultDataType);

		'''
			{
				«resultType.generateDataType(lambdaExpression.parameters.get(0).name, codeFragmentCollector, null)» = «expressionGenerator.generate(context, functionCall.arguments.get(1))»;
				int i;
				for (i = 0; i < «vectorType.size»; ++i) {
					«resultType.generateDataType(lambdaExpression.parameters.get(1).name, codeFragmentCollector, null)» = «expressionGenerator.generate(context, functionCall.arguments.get(0))»[i];
					«operationGeneratorProvider.getGenerator(context, resultDataType, lambdaExpression.expression).generate(context, resultDataType, lambdaExpression.parameters.get(0).name, lambdaExpression.expression)»
				}
				«target» = «lambdaExpression.parameters.get(0).name»;
			}
		'''
	}
	
}

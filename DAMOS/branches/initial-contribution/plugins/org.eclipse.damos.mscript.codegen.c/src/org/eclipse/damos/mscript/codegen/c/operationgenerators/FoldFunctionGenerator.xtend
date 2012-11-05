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
import org.eclipse.damos.mscript.BuiltinFunctionDeclaration
import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.FunctionCall
import org.eclipse.damos.mscript.LambdaExpression
import org.eclipse.damos.mscript.Type
import org.eclipse.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipse.damos.mscript.codegen.c.OperationGeneratorProvider
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypes
import org.eclipse.damos.mscript.builtin.BuiltinFunctionKind
import org.eclipse.damos.mscript.util.MscriptUtil

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

		val vectorType = MachineDataTypes::create(context.configuration, context.getFunctionInfo.getValue(functionCall.arguments.get(0)).dataType as ArrayType);
		val resultType = MachineDataTypes::create(context.configuration, resultDataType);

		val indexName = MscriptUtil::findAvailableLocalVariableName(lambdaExpression.expression, "i")

		'''
			{
				«resultType.generateDataType(lambdaExpression.parameters.get(0).name, codeFragmentCollector, null)» = «expressionGenerator.generate(context, functionCall.arguments.get(1))»;
				int «indexName»;
				for («indexName» = 0; «indexName» < «vectorType.size»; ++«indexName») {
					«resultType.generateDataType(lambdaExpression.parameters.get(1).name, codeFragmentCollector, null)» = «expressionGenerator.generate(context, functionCall.arguments.get(0))»[«indexName»];
					«operationGeneratorProvider.getGenerator(context, resultDataType, lambdaExpression.expression).generate(context, resultDataType, lambdaExpression.parameters.get(0).name, lambdaExpression.expression)»
				}
				«target» = «lambdaExpression.parameters.get(0).name»;
			}
		'''
	}
	
}

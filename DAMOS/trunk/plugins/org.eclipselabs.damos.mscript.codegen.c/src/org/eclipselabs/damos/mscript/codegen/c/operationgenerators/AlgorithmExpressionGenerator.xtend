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

import org.eclipselabs.damos.mscript.AlgorithmExpression
import org.eclipselabs.damos.mscript.Expression
import org.eclipselabs.damos.mscript.Type
import org.eclipselabs.damos.mscript.codegen.c.CompoundStatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.IStatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.LiteralGenerator
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.StatementGenerator
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator
import org.eclipselabs.damos.mscript.ReturnStatement

/**
 * @author Andreas Unger
 *
 */
class AlgorithmExpressionGenerator implements IOperationGenerator {

	val IOperationGeneratorProvider operationGeneratorProvider = new OperationGeneratorProvider()
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()
	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator()
	val VariableDeclarationGenerator variableDeclarationGenerator = new VariableDeclarationGenerator(dataTypeGenerator)
	val IStatementGenerator statementGenerator = new StatementGenerator(expressionGenerator, dataTypeGenerator, variableDeclarationGenerator, new VariableReferenceGenerator(new LiteralGenerator(dataTypeGenerator)), new OperationGeneratorProvider())
	val ICompoundStatementGenerator compoundStatementGenerator = new CompoundStatementGenerator(statementGenerator, variableDeclarationGenerator)

	override boolean canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		return expression instanceof AlgorithmExpression
	}

	override CharSequence generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val algorithmExpression = expression as AlgorithmExpression
		val returnStatement = algorithmExpression.body.statements.last as ReturnStatement
		
		'''
		{
			«compoundStatementGenerator.generate(context, algorithmExpression.body.statements.filter([!(it instanceof ReturnStatement)]))»
			«operationGeneratorProvider.getGenerator(context, resultDataType, returnStatement.expression).generate(context, resultDataType, target, returnStatement.expression)»
		}
		'''
	}

}

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
import org.eclipse.damos.mscript.AlgorithmExpression
import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.ReturnStatement
import org.eclipse.damos.mscript.Type
import org.eclipse.damos.mscript.codegen.c.ICompoundStatementGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider

/**
 * @author Andreas Unger
 *
 */
class AlgorithmExpressionGenerator implements IOperationGenerator {

	@Inject
	IOperationGeneratorProvider operationGeneratorProvider
	
	@Inject
	ICompoundStatementGenerator compoundStatementGenerator

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

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

import org.eclipselabs.damos.mscript.Expression
import org.eclipselabs.damos.mscript.InspectExpression
import org.eclipselabs.damos.mscript.Type
import org.eclipselabs.damos.mscript.UnionType
import org.eclipselabs.damos.mscript.codegen.c.ExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipselabs.damos.mscript.codegen.c.IOperationGenerator
import org.eclipselabs.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipselabs.damos.mscript.codegen.c.OperationGeneratorProvider

/**
 * @author Andreas Unger
 *
 */
class InspectExpressionGenerator implements IOperationGenerator {
	
	val IOperationGeneratorProvider operationGeneratorProvider = new OperationGeneratorProvider()
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		return expression instanceof InspectExpression
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val inspectExpression = expression as InspectExpression
		
		val unionType = context.getFunctionInfo.getValue(inspectExpression.unionExpression).dataType as UnionType
		val whenClauses = inspectExpression.whenClauses.sortBy([unionType.getMemberIndex(it.name)])
		
		if (whenClauses.empty) {
			return ""
		}
		
		'''
			switch («expressionGenerator.generate(context, inspectExpression.unionExpression)».tag) {
			«FOR i : 0..whenClauses.size - 1»
				case «i»:
					«operationGeneratorProvider.getGenerator(context, resultDataType, whenClauses.get(i).expression).generate(context, resultDataType, target, whenClauses.get(i).expression)»
					break;
			«ENDFOR»
			}
		'''
	}
	
}

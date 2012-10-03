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
import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.Type
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.util.MscriptGeneratorUtil

/**
 * @author Andreas Unger
 *
 */
class DefaultOperationGenerator implements IOperationGenerator {

	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator()

	override boolean canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		return true
	}

	override CharSequence generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		return generateAssignment(context, resultDataType, target, expression)
	}

	def private dispatch generateAssignment(IMscriptGeneratorContext context, Type targetDataType, CharSequence target, Expression assignedExpression) '''
		«target» = «generateAssignedExpression(context, targetDataType, assignedExpression)»;
	'''
	
	def private dispatch generateAssignment(IMscriptGeneratorContext context, ArrayType targetDataType, CharSequence target, Expression assignedExpression) '''
		memcpy(«target», «generateAssignedExpression(context, targetDataType, assignedExpression)», sizeof («dataTypeGenerator.generateDataType(context.configuration, null, context.codeFragmentCollector, targetDataType, null)»));
	'''

	def generateAssignedExpression(IMscriptGeneratorContext context, Type targetDataType, Expression expression) {
		return MscriptGeneratorUtil::cast(context, expression, targetDataType);
	}

}

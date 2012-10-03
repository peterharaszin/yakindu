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

import org.eclipse.damos.mscript.Expression
import org.eclipse.damos.mscript.Type
import org.eclipse.damos.mscript.UnionConstructionOperator
import org.eclipse.damos.mscript.UnionType
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.IOperationGenerator
import org.eclipse.damos.mscript.codegen.c.IOperationGeneratorProvider
import org.eclipse.damos.mscript.codegen.c.OperationGeneratorProvider

/**
 * @author Andreas Unger
 *
 */
class UnionConstructionOperatorGenerator implements IOperationGenerator {
	
	val IOperationGeneratorProvider operationGeneratorProvider = new OperationGeneratorProvider()

	override canHandle(IMscriptGeneratorContext context, Type resultDataType, Expression expression) {
		return expression instanceof UnionConstructionOperator
	}
	
	override generate(IMscriptGeneratorContext context, Type resultDataType, CharSequence target, Expression expression) {
		val unionConstructionOperator = expression as UnionConstructionOperator
		val member = unionConstructionOperator.member
		val type = unionConstructionOperator.typeSpecifier.type as UnionType

		'''
			«target».tag = «type.members.indexOf(member)»;
			«operationGeneratorProvider.getGenerator(context, member.type, unionConstructionOperator.value).generate(context, member.type, target + ".value." + member.name, unionConstructionOperator.value)»
		'''
	}
	
}

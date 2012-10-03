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

package org.eclipse.damos.mscript.codegen.c

import org.eclipse.damos.mscript.Evaluable
import org.eclipse.damos.mscript.LocalVariableDeclaration
import org.eclipse.damos.mscript.Statement
import com.google.inject.Inject

class CompoundStatementGenerator implements ICompoundStatementGenerator {
	
	val IStatementGenerator statementGenerator
	val VariableDeclarationGenerator variableDeclarationGenerator
	
	@Inject
	new(IStatementGenerator statementGenerator, VariableDeclarationGenerator variableDeclarationGenerator) {
		this.statementGenerator = statementGenerator
		this.variableDeclarationGenerator = variableDeclarationGenerator
	}
	
	override generate(IMscriptGeneratorContext context, Iterable<Statement> statements) '''
		«FOR localVariableDeclaration : statements.filter(typeof(LocalVariableDeclaration))»
			«variableDeclarationGenerator.generateVariableDeclaration(context.configuration, context.codeFragmentCollector, getDataType(context, localVariableDeclaration), localVariableDeclaration.name, false, null)»;
		«ENDFOR»
		«FOR statement : statements»
			«statementGenerator.generate(context, statement)»
		«ENDFOR»
	'''

	def private getDataType(IMscriptGeneratorContext context, Evaluable evaluable) {
		return context.getFunctionInfo.getValue(evaluable)?.dataType
	}
	
}

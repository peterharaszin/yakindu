/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c

import org.eclipselabs.damos.mscript.ArrayType
import org.eclipselabs.damos.mscript.Assignment
import org.eclipselabs.damos.mscript.Compound
import org.eclipselabs.damos.mscript.DataType
import org.eclipselabs.damos.mscript.Evaluable
import org.eclipselabs.damos.mscript.Expression
import org.eclipselabs.damos.mscript.ForStatement
import org.eclipselabs.damos.mscript.IfStatement
import org.eclipselabs.damos.mscript.LocalVariableDeclaration
import org.eclipselabs.damos.mscript.Statement
import org.eclipselabs.damos.mscript.VariableDeclaration
import org.eclipselabs.damos.mscript.VariableReference
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableAccessGenerator
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil
import org.eclipselabs.damos.mscript.util.TypeUtil

/**
 * @author Andreas Unger
 *
 */
class CompoundGenerator implements ICompoundGenerator {
	
	val IExpressionGenerator expressionGenerator = new ExpressionGenerator()

	override CharSequence generate(IMscriptGeneratorContext context, Compound compound) {
		doGenerate(context, compound)
	}
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, Compound compound) '''
		«generateCompound(context, compound)»
	'''
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, Assignment assignment) {
		if (!(assignment.target instanceof VariableReference)) {
			throw new IllegalArgumentException()
		}
		val variableReference = assignment.target as VariableReference
		
		if (!(variableReference.feature instanceof VariableDeclaration)) {
			throw new IllegalArgumentException()
		}
		val target = variableReference.feature as VariableDeclaration
		
		generateAssignment(context, getDataType(context, target), new VariableAccessGenerator(context, variableReference).generate(), assignment.assignedExpression);
	}
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, LocalVariableDeclaration localVariableDeclaration) {
		if (localVariableDeclaration.initializer != null) {
			return generateAssignment(context, getDataType(context, localVariableDeclaration), localVariableDeclaration.name, localVariableDeclaration.initializer);
		}
		return ""
	}
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, ForStatement forStatement) {
		val iterationVariableDeclaration = forStatement.iterationVariable
		val collectionDataType = getDataType(context, forStatement.collectionExpression)
		if (!(collectionDataType instanceof ArrayType)) {
			throw new RuntimeException("Collection type must be array type")
		}
		val collectionArrayType = collectionDataType as ArrayType
		if (collectionArrayType.dimensionality != 1) {
			throw new RuntimeException("Array dimensionality must be 1")
		}
		
		val itVarName = iterationVariableDeclaration.name
		val itVarDecl = MscriptGeneratorUtil::getCVariableDeclaration(context, getDataType(context, iterationVariableDeclaration), itVarName, false, null)
		val size = TypeUtil::getArraySize(collectionArrayType)
		
		'''
			{
				«MscriptGeneratorUtil::getIndexCDataType(context.computationModel, size)» «itVarName»_i;
				for («itVarName»_i = 0; «itVarName»_i < «size»; ++«itVarName»_i) {
					«itVarDecl» = («expressionGenerator.generate(context, forStatement.collectionExpression)»).data[«itVarName»_i];
					«doGenerate(context, forStatement.body)»
				}
			}
		'''
	}

	def private dispatch doGenerate(IMscriptGeneratorContext context, IfStatement ifStatement) '''
		if («expressionGenerator.generate(context, ifStatement.condition)») «generateThenStatement(context, ifStatement.thenStatement)» else «doGenerate(context, ifStatement.elseStatement)»
	'''
	
	def private dispatch generateThenStatement(IMscriptGeneratorContext context, Statement statement) {
		doGenerate(context, statement)
	}

	def private dispatch generateThenStatement(IMscriptGeneratorContext context, Compound compound) {
		generateCompound(context, compound)
	}

	def private generateCompound(IMscriptGeneratorContext context, Compound compound) '''
		{
			«FOR localVariableDeclaration : compound.localVariableDeclarations»
				«MscriptGeneratorUtil::getCVariableDeclaration(context, getDataType(context, localVariableDeclaration), localVariableDeclaration.name, false, null)»;
			«ENDFOR»
			«FOR statement : compound.statements»
				«doGenerate(context, statement)»
			«ENDFOR»
		}'''

	def private generateAssignment(IMscriptGeneratorContext context, DataType targetDataType, CharSequence target, Expression assignedExpression) '''
		«target» = «cast(context, targetDataType, assignedExpression)»;
	'''
	
	def cast(IMscriptGeneratorContext context, DataType targetDataType, Expression expression) {
		return MscriptGeneratorUtil::cast(context, expression, targetDataType)
	}
	
	def getDataType(IMscriptGeneratorContext context, Evaluable evaluable) {
		return context.staticEvaluationContext.getValue(evaluable)?.dataType
	}
	
}

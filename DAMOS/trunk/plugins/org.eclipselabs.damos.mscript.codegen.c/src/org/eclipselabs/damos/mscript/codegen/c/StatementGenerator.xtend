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

import com.google.inject.Inject
import org.eclipselabs.damos.mscript.ArrayType
import org.eclipselabs.damos.mscript.Assignment
import org.eclipselabs.damos.mscript.CompoundStatement
import org.eclipselabs.damos.mscript.Evaluable
import org.eclipselabs.damos.mscript.Expression
import org.eclipselabs.damos.mscript.ForStatement
import org.eclipselabs.damos.mscript.IfStatement
import org.eclipselabs.damos.mscript.LocalVariableDeclaration
import org.eclipselabs.damos.mscript.ReturnStatement
import org.eclipselabs.damos.mscript.Statement
import org.eclipselabs.damos.mscript.Type
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableReferenceGenerator
import org.eclipselabs.damos.mscript.util.TypeUtil
import org.eclipselabs.damos.mscript.codegen.c.IStatementGenerator

/**
 * @author Andreas Unger
 *
 */
class StatementGenerator implements IStatementGenerator {
	
	val IExpressionGenerator expressionGenerator

	val DataTypeGenerator dataTypeGenerator
	val VariableDeclarationGenerator variableDeclarationGenerator
	val VariableReferenceGenerator variableReferenceGenerator
	val IOperationGeneratorProvider operationGeneratorProvider
	val ICompoundStatementGenerator compoundStatementGenerator
	
	@Inject
	new(IExpressionGenerator expressionGenerator, DataTypeGenerator dataTypeGenerator, VariableDeclarationGenerator variableDeclarationGenerator, VariableReferenceGenerator variableAccessGenerator, IOperationGeneratorProvider operationGeneratorProvider) {
		this.expressionGenerator = expressionGenerator
		this.dataTypeGenerator = dataTypeGenerator
		this.variableDeclarationGenerator = variableDeclarationGenerator
		this.variableReferenceGenerator = variableAccessGenerator
		this.operationGeneratorProvider = operationGeneratorProvider
		this.compoundStatementGenerator = new CompoundStatementGenerator(this, variableDeclarationGenerator)
	}
	
	override CharSequence generate(IMscriptGeneratorContext context, Statement statement) {
		doGenerate(context, statement)
	}
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, CompoundStatement compoundStatement) '''
		«generateCompound(context, compoundStatement)»
	'''
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, Assignment assignment) {
		val target = expressionGenerator.generate(context, assignment.target)
		val dataType = getDataType(context, assignment.target)
		if (dataType != null) {
			return generateAssignment(context, dataType, target, assignment.assignedExpression);
		}
		return ""
	}
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, LocalVariableDeclaration localVariableDeclaration) {
		if (localVariableDeclaration.initializer != null) {
			val dataType = getDataType(context, localVariableDeclaration)
			if (dataType != null) {
				return generateAssignment(context, dataType, localVariableDeclaration.name, localVariableDeclaration.initializer);
			}
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
		val itVarDecl = variableDeclarationGenerator.generateVariableDeclaration(context.configuration, context.codeFragmentCollector, getDataType(context, iterationVariableDeclaration), itVarName, false, null)
		val size = TypeUtil::getArraySize(collectionArrayType)
		
		'''
			{
				«dataTypeGenerator.generateIndexDataType(context.configuration.computationModel, size)» «itVarName»_i;
				for («itVarName»_i = 0; «itVarName»_i < «size»; ++«itVarName»_i) {
					«itVarDecl» = («expressionGenerator.generate(context, forStatement.collectionExpression)»)[«itVarName»_i];
					«doGenerate(context, forStatement.body)»
				}
			}
		'''
	}

	def private dispatch doGenerate(IMscriptGeneratorContext context, IfStatement ifStatement) '''
		if («expressionGenerator.generate(context, ifStatement.condition)») «generateThenStatement(context, ifStatement.thenStatement)» else «doGenerate(context, ifStatement.elseStatement)»
	'''
	
	def private dispatch doGenerate(IMscriptGeneratorContext context, ReturnStatement returnStatement) '''
		return «expressionGenerator.generate(context, returnStatement.expression)»;
	'''
	
	def private dispatch generateThenStatement(IMscriptGeneratorContext context, Statement statement) {
		doGenerate(context, statement)
	}

	def private dispatch generateThenStatement(IMscriptGeneratorContext context, CompoundStatement compoundStatement) {
		generateCompound(context, compoundStatement)
	}

	def private generateCompound(IMscriptGeneratorContext context, CompoundStatement compoundStatement) '''
		{
			«compoundStatementGenerator.generate(context, compoundStatement.statements)»
		}'''

	def private generateAssignment(IMscriptGeneratorContext context, Type targetDataType, CharSequence target, Expression assignedExpression) {
		val operationGenerator = operationGeneratorProvider.getGenerator(context, targetDataType, assignedExpression)
		if (operationGenerator != null) {
			return operationGenerator.generate(context, targetDataType, target, assignedExpression)
		}
		return ""
	}
		
	def private getDataType(IMscriptGeneratorContext context, Evaluable evaluable) {
		return context.getStaticEvaluationResult.getValue(evaluable)?.dataType
	}
	
}

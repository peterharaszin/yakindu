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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import java.util.Collections;

import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.LetExpression;
import org.eclipselabs.damos.mscript.LetExpressionAssignment;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class LetExpressionExpander implements IExpressionTransformStrategy {

	public boolean canHandle(Expression expression) {
		return expression instanceof LetExpression;
	}
	
	public Expression transform(ITransformerContext context, IExpressionTransformer transformer, Expression expression) {
		LetExpression letExpression = (LetExpression) expression;
		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), "temp"));
		IValue expressionValue = context.getStaticEvaluationResult().getValue(letExpression);
		context.getStaticEvaluationResult().setValue(localVariableDeclaration, expressionValue);
		context.getCompound().getStatements().add(localVariableDeclaration);

		Compound compoundStatement = MscriptFactory.eINSTANCE.createCompound();
		context.getCompound().getStatements().add(compoundStatement);
		
		context.enterScope();
		context.setCompound(compoundStatement);

		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LocalVariableDeclaration localVariable = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
			VariableDeclaration variable = assignment.getVariables().get(0);
			
			context.addVariableDeclarationMapping(variable, localVariable);
			
			IValue partValue = context.getStaticEvaluationResult().getValue(variable);
			context.getStaticEvaluationResult().setValue(localVariable, partValue);
			localVariable.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), variable.getName()));
			Expression assignedExpression = transformer.transformNext(assignment.getAssignedExpression());
			localVariable.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(localVariable);
		}

		transformer.transform(
				letExpression.getTarget(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		
		context.leaveScope();
		
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
		variableReference.setFeature(localVariableDeclaration);
		return variableReference;
	}

}

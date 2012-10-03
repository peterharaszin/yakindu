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

package org.eclipse.damos.mscript.function.transform;

import java.util.List;

import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.IfExpression;
import org.eclipse.damos.mscript.IfStatement;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class IfExpressionExpander extends AbstractExpressionTransformStrategy {

	public boolean canTransform(ITransformerContext context, Expression expression) {
		return expression instanceof IfExpression;
	}

	public void transform(ExpressionTransformResult result, Expression expression) {
		List<? extends IExpressionTarget> targets = result.getTargets();
		// First check if we can statically evaluate the condition
		IfExpression ifExpression = (IfExpression) expression;
		IValue ifConditionValue = result.getContext().getFunctionInfo().getValue(ifExpression.getCondition());
		if (ifConditionValue instanceof IBooleanValue) {
			boolean condition = ((IBooleanValue) ifConditionValue).booleanValue();
			Expression resultExpression = condition ? ifExpression.getThenExpression() : ifExpression.getElseExpression();
			result.getTransformer().transform(result.getContext(), resultExpression, targets);
			return;
		}
		
		IValue ifExpressionValue = result.getContext().getFunctionInfo().getValue(ifExpression);
		targets = targets.get(0).toVariableExpressionTarget(ifExpressionValue.getDataType()).asList();

		InlineExpressionTarget conditionTarget = new InlineExpressionTarget(result.getContext());
		result.getTransformer().transform(result.getContext(), ifExpression.getCondition(), conditionTarget.asList());
		Expression conditionExpression = conditionTarget.getAssignedExpression();

		IfStatement ifStatement = MscriptFactory.eINSTANCE.createIfStatement();
		ifStatement.setCondition(conditionExpression);
		result.getContext().getCompound().getStatements().add(ifStatement);
		
		CompoundStatement thenStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		ifStatement.setThenStatement(thenStatement);
		result.getContext().enterScope();
		result.getContext().setCompound(thenStatement);
		result.getTransformer().transform(result.getContext(), ifExpression.getThenExpression(), targets);
		result.getContext().leaveScope();
		
		CompoundStatement elseStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		ifStatement.setElseStatement(elseStatement);
		result.getContext().enterScope();
		result.getContext().setCompound(elseStatement);
		result.getTransformer().transform(result.getContext(), ifExpression.getElseExpression(), targets);
		result.getContext().leaveScope();
	}

}

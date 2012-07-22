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

import java.util.List;

import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class IfExpressionExpander implements IExpressionTransformStrategy {

	public boolean canHandle(ITransformerContext context, Expression expression) {
		return expression instanceof IfExpression;
	}

	public void transform(ITransformerContext context, Expression expression, List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		// First check if we can statically evaluate the condition
		IfExpression ifExpression = (IfExpression) expression;
		IValue ifConditionValue = context.getStaticEvaluationResult().getValue(ifExpression.getCondition());
		if (ifConditionValue instanceof IBooleanValue) {
			boolean condition = ((IBooleanValue) ifConditionValue).booleanValue();
			Expression resultExpression = condition ? ifExpression.getThenExpression() : ifExpression.getElseExpression();
			transformer.transform(resultExpression, targets);
			return;
		}
		
		InlineExpressionTarget conditionTarget = new InlineExpressionTarget(context);
		transformer.transform(ifExpression.getCondition(), conditionTarget.asList());
		Expression conditionExpression = conditionTarget.getAssignedExpression();

		IfStatement ifStatement = MscriptFactory.eINSTANCE.createIfStatement();
		ifStatement.setCondition(conditionExpression);
		context.getCompound().getStatements().add(ifStatement);
		
		CompoundStatement thenStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		ifStatement.setThenStatement(thenStatement);
		context.enterScope();
		context.setCompound(thenStatement);
		transformer.transform(ifExpression.getThenExpression(), targets);
		context.leaveScope();
		
		CompoundStatement elseStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		ifStatement.setElseStatement(elseStatement);
		context.enterScope();
		context.setCompound(elseStatement);
		transformer.transform(ifExpression.getElseExpression(), targets);
		context.leaveScope();
	}

}

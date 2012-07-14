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
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class IfExpressionExpander implements IExpressionTransformStrategy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategy#canHandle(org.eclipselabs.damos.mscript.Expression)
	 */
	public boolean canHandle(Expression expression) {
		return expression instanceof IfExpression;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategy#transform(org.eclipselabs.damos.mscript.functionmodel.transform.ITransformerContext, org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformer, org.eclipselabs.damos.mscript.Expression)
	 */
	public Expression transform(ITransformerContext context, IExpressionTransformer transformer, Expression expression) {
		IfExpression ifExpression = (IfExpression) expression;
		IValue ifConditionValue = context.getStaticEvaluationResult().getValue(ifExpression.getCondition());
		if (ifConditionValue instanceof IBooleanValue) {
			boolean condition = ((IBooleanValue) ifConditionValue).booleanValue();
			Expression resultExpression = condition ? ifExpression.getThenExpression() : ifExpression.getElseExpression();
			return transformer.transformNext(resultExpression);
		}
		
		Expression conditionExpression = transformer.transformNext(ifExpression.getCondition());

		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		localVariableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), "ifresult"));
		
		IValue ifExpressionValue = context.getStaticEvaluationResult().getValue(ifExpression);
		context.getStaticEvaluationResult().setValue(localVariableDeclaration, ifExpressionValue);
		
		context.getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = MscriptFactory.eINSTANCE.createIfStatement();
		ifStatement.setCondition(conditionExpression);
		context.getCompound().getStatements().add(ifStatement);
		
		Compound thenStatement = MscriptFactory.eINSTANCE.createCompound();
		ifStatement.setThenStatement(thenStatement);
		context.enterScope();
		context.setCompound(thenStatement);
		transformer.transform(
				ifExpression.getThenExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		
		Compound elseStatement = MscriptFactory.eINSTANCE.createCompound();
		ifStatement.setElseStatement(elseStatement);
		context.enterScope();
		context.setCompound(elseStatement);
		transformer.transform(
				ifExpression.getElseExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
		variableReference.setFeature(localVariableDeclaration);
		return variableReference;
	}

}

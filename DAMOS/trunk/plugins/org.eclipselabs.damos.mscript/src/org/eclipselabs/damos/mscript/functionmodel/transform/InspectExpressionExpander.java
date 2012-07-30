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

import org.eclipselabs.damos.mscript.AlgorithmExpression;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.InspectExpression;
import org.eclipselabs.damos.mscript.InspectWhenClause;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.ReturnStatement;

/**
 * @author Andreas Unger
 *
 */
public class InspectExpressionExpander implements IExpressionTransformStrategy {

	private final ExpressionTransformHelper helper = new ExpressionTransformHelper();

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategy#canHandle(org.eclipselabs.damos.mscript.functionmodel.transform.ITransformerContext, org.eclipselabs.damos.mscript.Expression)
	 */
	public boolean canHandle(ITransformerContext context, Expression expression) {
		return expression instanceof InspectExpression;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategy#transform(org.eclipselabs.damos.mscript.functionmodel.transform.ITransformerContext, org.eclipselabs.damos.mscript.Expression, java.util.List, org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformer)
	 */
	public void transform(ITransformerContext context, Expression expression,
			List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		InspectExpression inspectExpression = (InspectExpression) expression;
		
		InspectExpression transformedInspectExpression = MscriptFactory.eINSTANCE.createInspectExpression();
		transformedInspectExpression.setUnionExpression(helper.transformToVariableReference(context, inspectExpression.getUnionExpression(), "unionval", transformer));
		context.getStaticEvaluationResult().setValue(transformedInspectExpression, context.getStaticEvaluationResult().getValue(inspectExpression));

		for (InspectWhenClause whenClause : inspectExpression.getWhenClauses()) {
			AlgorithmExpression algorithmExpression = MscriptFactory.eINSTANCE.createAlgorithmExpression();
			context.getStaticEvaluationResult().setValue(algorithmExpression, context.getStaticEvaluationResult().getValue(whenClause.getExpression()));
			
			CompoundStatement body = MscriptFactory.eINSTANCE.createCompoundStatement();
			algorithmExpression.setBody(body);
			
			context.enterScope();
			context.setCompound(body);
			
			InspectWhenClause transformedWhenClause = MscriptFactory.eINSTANCE.createInspectWhenClause();
			transformedWhenClause.setName(whenClause.getName());
			transformedWhenClause.setExpression(algorithmExpression);
			context.getStaticEvaluationResult().setValue(transformedWhenClause, context.getStaticEvaluationResult().getValue(whenClause));
			
			context.addVariableDeclarationMapping(whenClause, transformedWhenClause);
			transformedInspectExpression.getWhenClauses().add(transformedWhenClause);

			InlineExpressionTarget bodyTarget = new InlineExpressionTarget(context);
			transformer.transform(whenClause.getExpression(), bodyTarget.asList());
			
			ReturnStatement returnStatement = MscriptFactory.eINSTANCE.createReturnStatement();
			returnStatement.setExpression(bodyTarget.getAssignedExpression());
			context.getCompound().getStatements().add(returnStatement);
			
			context.leaveScope();
		}
		
		targets.get(0).assignExpression(transformedInspectExpression);
	}

}

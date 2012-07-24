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
import org.eclipselabs.damos.mscript.LambdaExpression;
import org.eclipselabs.damos.mscript.LambdaExpressionParameter;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.ReturnStatement;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class LambdaExpressionExpander implements IExpressionTransformStrategy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategy#canHandle(org.eclipselabs.damos.mscript.functionmodel.transform.ITransformerContext, org.eclipselabs.damos.mscript.Expression)
	 */
	public boolean canHandle(ITransformerContext context, Expression expression) {
		return expression instanceof LambdaExpression;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformStrategy#transform(org.eclipselabs.damos.mscript.functionmodel.transform.ITransformerContext, org.eclipselabs.damos.mscript.Expression, java.util.List, org.eclipselabs.damos.mscript.functionmodel.transform.IExpressionTransformer)
	 */
	public void transform(ITransformerContext context, Expression expression,
			List<? extends IExpressionTarget> targets, IExpressionTransformer transformer) {
		LambdaExpression lambdaExpression = (LambdaExpression) expression;
		
		AlgorithmExpression algorithmExpression = MscriptFactory.eINSTANCE.createAlgorithmExpression();
		context.getStaticEvaluationResult().setValue(algorithmExpression, context.getStaticEvaluationResult().getValue(lambdaExpression.getExpression()));
		
		CompoundStatement body = MscriptFactory.eINSTANCE.createCompoundStatement();
		algorithmExpression.setBody(body);
		
		context.enterScope();
		context.setCompound(body);
		
		InlineExpressionTarget bodyTarget = new InlineExpressionTarget(context);
		transformer.transform(lambdaExpression.getExpression(), bodyTarget.asList());
		
		ReturnStatement returnStatement = MscriptFactory.eINSTANCE.createReturnStatement();
		returnStatement.setExpression(bodyTarget.getAssignedExpression());
		context.getCompound().getStatements().add(returnStatement);
		
		context.leaveScope();

		LambdaExpression transformedLambdaExpression = MscriptFactory.eINSTANCE.createLambdaExpression();
		transformedLambdaExpression.setExpression(algorithmExpression);
		context.getStaticEvaluationResult().setValue(transformedLambdaExpression, context.getStaticEvaluationResult().getValue(lambdaExpression));
		
		transformedLambdaExpression.setExpression(algorithmExpression);
		for (LambdaExpressionParameter parameter : lambdaExpression.getParameters()) {
			LambdaExpressionParameter transformedParameter = MscriptFactory.eINSTANCE.createLambdaExpressionParameter();
			transformedParameter.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), parameter.getName()));
			context.addVariableDeclarationMapping(parameter, transformedParameter);
			transformedLambdaExpression.getParameters().add(transformedParameter);
		}
		
		targets.get(0).assignExpression(transformedLambdaExpression);
	}

}

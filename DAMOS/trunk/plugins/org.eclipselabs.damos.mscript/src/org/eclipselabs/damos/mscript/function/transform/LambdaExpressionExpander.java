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

package org.eclipselabs.damos.mscript.function.transform;


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
public class LambdaExpressionExpander extends AbstractExpressionTransformStrategy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.function.transform.IExpressionTransformStrategy#canHandle(org.eclipselabs.damos.mscript.function.transform.ITransformerContext, org.eclipselabs.damos.mscript.Expression)
	 */
	public boolean canTransform(ITransformerContext context, Expression expression) {
		return expression instanceof LambdaExpression;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.function.transform.IExpressionTransformStrategy#transform(org.eclipselabs.damos.mscript.function.transform.ITransformerContext, org.eclipselabs.damos.mscript.Expression, java.util.List, org.eclipselabs.damos.mscript.function.transform.IExpressionTransformer)
	 */
	public void transform(ExpressionTransformResult result, Expression expression) {
		LambdaExpression lambdaExpression = (LambdaExpression) expression;
		
		AlgorithmExpression algorithmExpression = MscriptFactory.eINSTANCE.createAlgorithmExpression();
		result.getContext().getFunctionInfo().setValue(algorithmExpression, result.getContext().getFunctionInfo().getValue(lambdaExpression.getExpression()));
		
		CompoundStatement body = MscriptFactory.eINSTANCE.createCompoundStatement();
		algorithmExpression.setBody(body);
		
		LambdaExpression transformedLambdaExpression = MscriptFactory.eINSTANCE.createLambdaExpression();
		transformedLambdaExpression.setExpression(algorithmExpression);
		result.getContext().getFunctionInfo().setValue(transformedLambdaExpression, result.getContext().getFunctionInfo().getValue(lambdaExpression));
		
		for (LambdaExpressionParameter parameter : lambdaExpression.getParameters()) {
			LambdaExpressionParameter transformedParameter = MscriptFactory.eINSTANCE.createLambdaExpressionParameter();
			transformedParameter.setName(MscriptUtil.findAvailableLocalVariableName(result.getContext().getCompound(), parameter.getName()));
			result.getContext().addVariableDeclarationMapping(parameter, transformedParameter);
			transformedLambdaExpression.getParameters().add(transformedParameter);
		}
		
		result.getContext().enterScope();
		result.getContext().setCompound(body);
		
		InlineExpressionTarget bodyTarget = new InlineExpressionTarget(result.getContext());
		result.getTransformer().transform(result.getContext(), lambdaExpression.getExpression(), bodyTarget.asList());
		
		ReturnStatement returnStatement = MscriptFactory.eINSTANCE.createReturnStatement();
		returnStatement.setExpression(bodyTarget.getAssignedExpression());
		result.getContext().getCompound().getStatements().add(returnStatement);
		
		result.getContext().leaveScope();

		result.getTargets().get(0).assignExpression(transformedLambdaExpression);
	}

}

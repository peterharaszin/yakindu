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


import org.eclipse.damos.mscript.AlgorithmExpression;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.InspectExpression;
import org.eclipse.damos.mscript.InspectWhenClause;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.ReturnStatement;

/**
 * @author Andreas Unger
 *
 */
public class InspectExpressionExpander extends AbstractExpressionTransformStrategy {

	private final ExpressionTransformHelper helper = new ExpressionTransformHelper();

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.function.transform.IExpressionTransformStrategy#canHandle(org.eclipse.damos.mscript.function.transform.ITransformerContext, org.eclipse.damos.mscript.Expression)
	 */
	public boolean canTransform(ITransformerContext context, Expression expression) {
		return expression instanceof InspectExpression;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.function.transform.IExpressionTransformStrategy#transform(org.eclipse.damos.mscript.function.transform.ITransformerContext, org.eclipse.damos.mscript.Expression, java.util.List, org.eclipse.damos.mscript.function.transform.IExpressionTransformer)
	 */
	public void transform(ExpressionTransformResult result, Expression expression) {
		InspectExpression inspectExpression = (InspectExpression) expression;
		
		InspectExpression transformedInspectExpression = MscriptFactory.eINSTANCE.createInspectExpression();
		transformedInspectExpression.setUnionExpression(helper.transformToVariableReference(result.getContext(), inspectExpression.getUnionExpression(), "unionval", result.getTransformer()));
		result.getContext().getFunctionInfo().setValue(transformedInspectExpression, result.getContext().getFunctionInfo().getValue(inspectExpression));

		for (InspectWhenClause whenClause : inspectExpression.getWhenClauses()) {
			AlgorithmExpression algorithmExpression = MscriptFactory.eINSTANCE.createAlgorithmExpression();
			result.getContext().getFunctionInfo().setValue(algorithmExpression, result.getContext().getFunctionInfo().getValue(whenClause.getExpression()));
			
			CompoundStatement body = MscriptFactory.eINSTANCE.createCompoundStatement();
			algorithmExpression.setBody(body);
			
			result.getContext().enterScope();
			result.getContext().setCompound(body);
			
			InspectWhenClause transformedWhenClause = MscriptFactory.eINSTANCE.createInspectWhenClause();
			transformedWhenClause.setName(whenClause.getName());
			transformedWhenClause.setExpression(algorithmExpression);
			result.getContext().getFunctionInfo().setValue(transformedWhenClause, result.getContext().getFunctionInfo().getValue(whenClause));
			
			result.getContext().addVariableDeclarationMapping(whenClause, transformedWhenClause);
			transformedInspectExpression.getWhenClauses().add(transformedWhenClause);

			InlineExpressionTarget bodyTarget = new InlineExpressionTarget(result.getContext());
			result.getTransformer().transform(result.getContext(), whenClause.getExpression(), bodyTarget.asList());
			
			ReturnStatement returnStatement = MscriptFactory.eINSTANCE.createReturnStatement();
			returnStatement.setExpression(bodyTarget.getAssignedExpression());
			result.getContext().getCompound().getStatements().add(returnStatement);
			
			result.getContext().leaveScope();
		}
		
		result.getTargets().get(0).assignExpression(transformedInspectExpression);
	}

}

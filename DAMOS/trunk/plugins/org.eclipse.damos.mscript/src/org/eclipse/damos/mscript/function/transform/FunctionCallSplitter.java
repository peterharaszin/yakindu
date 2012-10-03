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


import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.Assignment;
import org.eclipse.damos.mscript.BuiltinFunctionDeclaration;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class FunctionCallSplitter extends AbstractExpressionTransformStrategy {

	private final ExpressionTransformHelper helper = new ExpressionTransformHelper();
	
	public boolean canTransform(ITransformerContext context, Expression expression) {
		if (expression instanceof FunctionCall) {
			FunctionCall functionCall = (FunctionCall) expression;
			if (functionCall.getFeature() instanceof BuiltinFunctionDeclaration) {
				if (getDataType(context, functionCall) instanceof ArrayType) {
					return true;
				}
				for (Expression argument : functionCall.getArguments()) {
					if (getDataType(context, argument) instanceof ArrayType) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void transform(ExpressionTransformResult result, Expression expression) {
		FunctionCall functionCall = (FunctionCall) expression;

		IValue functionCallValue = result.getContext().getFunctionInfo().getValue(functionCall);

		FunctionCall transformedFunctionCall = MscriptFactory.eINSTANCE.createFunctionCall();
		FeatureReference featureReference = MscriptFactory.eINSTANCE.createFeatureReference();
		featureReference.setFeature(functionCall.getFeature());
		transformedFunctionCall.setTarget(featureReference);
		result.getContext().getFunctionInfo().setValue(transformedFunctionCall, functionCallValue);

		for (Expression argument : functionCall.getArguments()) {
			// TODO: Find a generic way to handle function types
			if (argument instanceof LambdaExpression) {
				InlineExpressionTarget lambdaExpressionTarget = new InlineExpressionTarget(result.getContext());
				result.getTransformer().transform(result.getContext(), argument, lambdaExpressionTarget.asList());
				transformedFunctionCall.getArguments().add(lambdaExpressionTarget.getAssignedExpression());
			} else {
				transformedFunctionCall.getArguments().add(helper.transformToVariableReference(result.getContext(), argument, "arg", result.getTransformer()));
			}
		}
		
		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
		assignment.setTarget(result.getTargets().get(0).createVariableReference(functionCallValue.getDataType()));
		assignment.setAssignedExpression(transformedFunctionCall);
		
		result.getContext().getCompound().getStatements().add(assignment);
	}

	private Type getDataType(ITransformerContext context, Expression expression) {
		return context.getFunctionInfo().getValue(expression).getDataType();
	}

}

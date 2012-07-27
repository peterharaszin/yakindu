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

package org.eclipselabs.damos.mscript.internal.builtin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.LambdaExpression;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorHelper;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.IteratorVariable;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class MapFunction extends AbstractBuiltinFunction {

	private final ExpressionEvaluatorHelper expressionEvaluatorHelper = new ExpressionEvaluatorHelper();

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.internal.builtin.IBuiltinFunction#call(org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext, org.eclipselabs.damos.mscript.FunctionCall)
	 */
	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall) {
		if (functionCall.getArguments().size() != 2) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Map function expects 2 arguments", functionCall, MscriptPackage.eINSTANCE.getFeatureCall_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		
		IValue targetValue = evaluate(context, functionCall.getArguments().get(0));
		if (targetValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(targetValue.getDataType() instanceof ArrayType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Map function target must be array type", functionCall, MscriptPackage.eINSTANCE.getFeatureCall_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		
		ArrayType arrayType = (ArrayType) targetValue.getDataType();

		if (arrayType.getDimensionality() != 1) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Map function target array type must have dimensionality of 1", functionCall, MscriptPackage.eINSTANCE.getFeatureCall_Feature()));
			}
			return InvalidValue.SINGLETON;
		}

		// TODO: Evaluate all array sizes ahead of time
		Expression sizeExpression = arrayType.getDimensions().get(0).getSize();
		IValue sizeValue = evaluate(context, sizeExpression);
		if (!(sizeValue instanceof ISimpleNumericValue) || !(sizeValue.getDataType() instanceof IntegerType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Array size expression must be integer", sizeExpression));
			}
			return InvalidValue.SINGLETON;
		}

		if (!(functionCall.getArguments().get(1) instanceof LambdaExpression)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Argument 1 of map function must be lambda expression", functionCall.getArguments().get(2)));
			}
			return InvalidValue.SINGLETON;
		}

		LambdaExpression lambdaExpression = (LambdaExpression) functionCall.getArguments().get(1);
		
		if (lambdaExpression.getParameters().size() != 1) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Lambda expression must have 1 parameter", lambdaExpression));
			}
			return InvalidValue.SINGLETON;
		}
		
		evaluate(context, functionCall.getArguments().get(1));

		context.processValue(lambdaExpression.getParameters().get(0), new AnyValue(context.getComputationContext(), arrayType.getElementType()));
	
		boolean anyValue = false;
		IValue[] elements = null;

		if (targetValue instanceof VectorValue) {
			// Try to evaluate concrete value
			VectorValue vectorValue = (VectorValue) targetValue;
			elements = new IValue[vectorValue.getSize()];
			for (int i = 0; i < elements.length; ++i) {
				context.enterVariableScope();
				context.addVariable(new IteratorVariable(lambdaExpression.getParameters().get(0), vectorValue.get(i)));
				elements[i] = evaluate(context, lambdaExpression.getExpression());
				context.leaveVariableScope();
				if (elements[i] instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}
				if (elements[i] instanceof AnyValue) {
					anyValue = true;
				}
			}
		} else {
			elements = new IValue[TypeUtil.getArraySize(arrayType)];
			for (int i = 0; i < elements.length; ++i) {
				context.enterVariableScope();
				context.addVariable(new IteratorVariable(lambdaExpression.getParameters().get(0), new AnyValue(context.getComputationContext(), EcoreUtil.copy(arrayType.getElementType()))));
				elements[i] = evaluate(context, lambdaExpression.getExpression());
				context.leaveVariableScope();
				if (elements[i] instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}
				if (elements[i] instanceof AnyValue) {
					anyValue = true;
				}
			}
		}

		return expressionEvaluatorHelper.createArrayValue(context, elements, anyValue, lambdaExpression.getExpression());
	}

}

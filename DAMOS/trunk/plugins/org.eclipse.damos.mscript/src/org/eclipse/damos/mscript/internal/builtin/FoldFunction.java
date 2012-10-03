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

package org.eclipse.damos.mscript.internal.builtin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.IteratorVariable;
import org.eclipse.damos.mscript.interpreter.value.AnyValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.interpreter.value.VectorValue;
import org.eclipse.damos.mscript.util.SyntaxStatus;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class FoldFunction extends AbstractBuiltinFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, boolean staticOnly) {
		if (functionCall.getArguments().size() != 3) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Fold function expects 3 arguments", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		
		IValue targetValue = evaluate(context, functionCall.getArguments().get(0));
		if (targetValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(targetValue.getDataType() instanceof ArrayType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Fold function target must be array type", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}

		ArrayType arrayType = (ArrayType) targetValue.getDataType();

		if (arrayType.getDimensionality() != 1) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Fold function target array type must have dimensionality of 1", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
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

		IValue resultValue = evaluate(context, functionCall.getArguments().get(1));
		if (resultValue instanceof InvalidValue) {
			return InvalidValue.SINGLETON;
		}

		if (!(functionCall.getArguments().get(2) instanceof LambdaExpression)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Argument 3 of fold function must be lambda expression", functionCall.getArguments().get(2)));
			}
			return InvalidValue.SINGLETON;
		}

		LambdaExpression lambdaExpression = (LambdaExpression) functionCall.getArguments().get(2);
		
		if (lambdaExpression.getParameters().size() != 2) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Lambda expression must have 2 parameters", lambdaExpression));
			}
			return InvalidValue.SINGLETON;
		}
		
		evaluate(context, functionCall.getArguments().get(2));

		context.processValue(lambdaExpression.getParameters().get(0), new AnyValue(context.getComputationContext(), resultValue.getDataType()));
		context.processValue(lambdaExpression.getParameters().get(1), new AnyValue(context.getComputationContext(), arrayType.getElementType()));
		
		if (!staticOnly && targetValue instanceof VectorValue && !(resultValue instanceof AnyValue)) {
			// Try to evaluate concrete value
			VectorValue vectorValue = (VectorValue) targetValue;
			for (int i = 0; i < vectorValue.getSize(); ++i) {
				context.enterVariableScope();
				context.addVariable(new IteratorVariable(lambdaExpression.getParameters().get(0), resultValue));
				context.addVariable(new IteratorVariable(lambdaExpression.getParameters().get(1), vectorValue.get(i)));
				resultValue = evaluate(context, lambdaExpression.getExpression());
				context.leaveVariableScope();
				if (resultValue instanceof InvalidValue) {
					return InvalidValue.SINGLETON;
				}
			}
		} else {
			IValue expressionValue = evaluate(context, lambdaExpression.getExpression());
			if (expressionValue instanceof InvalidValue) {
				return InvalidValue.SINGLETON;
			}

			Type resultingDataType = TypeUtil.getLeftHandDataType(resultValue.getDataType(), expressionValue.getDataType());
			if (resultingDataType == null) {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Result type is incompatabile with expression type", functionCall));
				}
				return InvalidValue.SINGLETON;
			}

			if (!resultValue.getDataType().isAssignableFrom(resultingDataType)) {
				resultValue = new AnyValue(context.getComputationContext(), resultingDataType);
				context.processValue(lambdaExpression.getParameters().get(0), resultValue);
			}

			resultValue = new AnyValue(context.getComputationContext(), resultingDataType);
		}

		return resultValue;
	}

}

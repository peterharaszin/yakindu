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
import org.eclipse.damos.mscript.ArrayDimension;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.internal.MscriptPlugin;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.util.SyntaxStatus;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.common.util.EList;

/**
 * @author Andreas Unger
 *
 */
public class SizeFunction extends AbstractBuiltinFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, boolean staticOnly) {
		if (functionCall.getArguments().isEmpty()) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Missing input parameter", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}
		
		if (functionCall.getArguments().size() > 2) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Maximum two input parameter expected", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}

		IValue argument = evaluate(context, functionCall.getArguments().get(0));
		if (!(argument.getDataType() instanceof ArrayType)) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "First input parameter must be array value", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}

		int dimension = 0;
		if (functionCall.getArguments().size() == 2) {
			IValue dimensionValue = evaluate(context, functionCall.getArguments().get(1));
			if (dimensionValue.getDataType() instanceof IntegerType && dimensionValue instanceof ISimpleNumericValue) {
				ISimpleNumericValue value = (ISimpleNumericValue) dimensionValue;
				if (!value.getDataType().getUnit().isEquivalentTo(TypeUtil.createUnit(), false)) {
					if (context.getStatusCollector() != null) {
						context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Dimension value must be dimensionless", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
					}
					return InvalidValue.SINGLETON;
				}
				dimension = (int) value.longValue();
			} else {
				if (context.getStatusCollector() != null) {
					context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Dimension value must be constant integer value", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
				}
				return InvalidValue.SINGLETON;
			}
		}
		
		EList<ArrayDimension> dimensions = ((ArrayType) argument.getDataType()).getDimensions();
		if (dimension >= dimensions.size()) {
			if (context.getStatusCollector() != null) {
				context.getStatusCollector().collectStatus(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Specified dimension out of range", functionCall, MscriptPackage.eINSTANCE.getFeatureReference_Feature()));
			}
			return InvalidValue.SINGLETON;
		}

		Expression sizeExpression = dimensions.get(dimension).getSize();
		return evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationContext(new StaticEvaluationResult())), sizeExpression);
	}

}

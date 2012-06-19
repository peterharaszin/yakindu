/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.builtin;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public class SizeFunction extends AbstractBuiltinFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall) {
		if (functionCall.getArguments().isEmpty()) {
			return InvalidValue.SINGLETON;
		}
		
		if (functionCall.getArguments().size() > 2) {
			return InvalidValue.SINGLETON;
		}

		IValue argument = evaluate(context, functionCall.getArguments().get(0));
		if (argument.getDataType() instanceof ArrayType) {
			return InvalidValue.SINGLETON;
		}

		int dimension = 0;
		if (functionCall.getArguments().size() == 2) {
			IValue dimensionValue = evaluate(context, functionCall.getArguments().get(1));
			if (dimensionValue.getDataType() instanceof IntegerType && dimensionValue instanceof ISimpleNumericValue) {
				dimension = (int) ((ISimpleNumericValue) dimensionValue).longValue();
			} else {
				return InvalidValue.SINGLETON;
			}
		}
		
		EList<ArrayDimension> dimensions = ((ArrayType) argument.getDataType()).getDimensions();
		if (dimension >= dimensions.size()) {
			return InvalidValue.SINGLETON;
		}

		Expression sizeExpression = dimensions.get(dimension).getSize();
		return evaluate(new StaticExpressionEvaluationContext(new StaticEvaluationResult()), sizeExpression);
	}

}

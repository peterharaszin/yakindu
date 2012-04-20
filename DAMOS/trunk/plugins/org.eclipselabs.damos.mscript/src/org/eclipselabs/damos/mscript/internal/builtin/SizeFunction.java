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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public class SizeFunction implements IBuiltinFunction {

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		IValue argument = arguments.get(0);
		if (argument.getDataType() instanceof ArrayType) {
			int dimension = 0;
			if (arguments.size() == 2) {
				IValue dimensionValue = arguments.get(1);
				if (dimensionValue instanceof ISimpleNumericValue) {
					dimension = (int) ((ISimpleNumericValue) dimensionValue).longValue();
				}
			}
			
			EList<ArrayDimension> dimensions = ((ArrayType) argument.getDataType()).getDimensions();
			if (dimension >= dimensions.size()) {
				// TODO: throw EvaluationException
				return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
			}

			Expression sizeExpression = dimensions.get(dimension).getSize();
			IStaticEvaluationContext staticEvaluationContext = new StaticEvaluationContext();
			
			IStatus result = new StaticExpressionEvaluator().evaluate(staticEvaluationContext, sizeExpression);
			if (!result.isOK()) {
				// TODO: throw EvaluationException
				return Collections.<IValue>singletonList(InvalidValue.SINGLETON);
			}
			
			return Collections.singletonList(staticEvaluationContext.getValue(sizeExpression));
		}
		throw new IllegalArgumentException();
	}
	
}

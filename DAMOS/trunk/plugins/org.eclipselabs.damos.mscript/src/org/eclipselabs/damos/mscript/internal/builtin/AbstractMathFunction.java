/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.builtin;

import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractMathFunction extends AbstractSingleParameterFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, IValue argument, boolean staticOnly) {
		if (!(argument.getDataType() instanceof RealType || argument.getDataType() instanceof IntegerType)) {
			return InvalidValue.SINGLETON;
		}
		
		if (!((NumericType) argument.getDataType()).getUnit().isEquivalentTo(TypeUtil.createUnit(), true)) {
			return InvalidValue.SINGLETON;
		}

		RealType dataType = TypeUtil.createRealType();

		if (argument instanceof AnyValue) {
			return new AnyValue(context.getComputationContext(), dataType);
		}

		argument = argument.convert(dataType);

		if (argument instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) argument;
			return compute(numericValue);
		}
		
		return InvalidValue.SINGLETON;
	}
	
	protected abstract IValue compute(ISimpleNumericValue x);

}

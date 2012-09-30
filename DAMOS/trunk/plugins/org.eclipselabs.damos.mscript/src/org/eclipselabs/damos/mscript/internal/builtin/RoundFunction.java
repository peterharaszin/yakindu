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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunction extends AbstractSingleParameterFunction {

	@Override
	protected IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, IValue argument, boolean staticOnly) {
		if (!(argument.getDataType() instanceof RealType || argument.getDataType() instanceof IntegerType)) {
			return InvalidValue.SINGLETON;
		}
		if (argument instanceof AnyValue) {
			IntegerType outputDataType = MscriptFactory.eINSTANCE.createIntegerType();
			outputDataType.setUnit(EcoreUtil.copy(((NumericType) argument.getDataType()).getUnit()));
			return new AnyValue(context.getComputationContext(), outputDataType);
		}
		if (argument instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) argument;
			return numericValue.round();
		}
		throw new IllegalArgumentException();
	}

}

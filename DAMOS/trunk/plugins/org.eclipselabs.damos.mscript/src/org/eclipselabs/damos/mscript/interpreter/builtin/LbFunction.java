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

package org.eclipselabs.damos.mscript.interpreter.builtin;

import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.Binary64Value;
import org.eclipselabs.damos.mscript.interpreter.value.FixedPointValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class LbFunction implements IFunction {

	private static final double LOG_2 = Math.log(2);

	private static final int LB_0_TO_1[] = {
		0x00000000, 0x0B31FB7D, 0x15C01A3A, 0x1FBC16B9,
		0x2934F098, 0x32377512,	0x3ACEA7C0, 0x43041403,
		0x4AE00D1D,	0x5269E12F,	0x59A80239, 0x60A02757,
		0x675767F5, 0x6DD2523D, 0x7414FDB5, 0x7A231ACE };

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		RealType dataType = TypeUtil.createRealType();
		
		IValue argument = arguments.get(0);
		if (argument instanceof AnyValue) {
			return Collections.<IValue>singletonList(new AnyValue(context, dataType));
		}

		argument = argument.convert(dataType);
		
		if (argument instanceof Binary64Value) {
			Binary64Value binary64Value = (Binary64Value) argument;
			return Collections.<IValue>singletonList(Values.valueOf(context, dataType, Math.log(binary64Value.doubleValue()) / LOG_2));
		}
		
		if (argument instanceof FixedPointValue) {
			FixedPointValue fixedPointValue = (FixedPointValue) argument;
			FixedPointFormat numberFormat = (FixedPointFormat) context.getComputationModel().getNumberFormat(dataType);
			
			long rawValue = fixedPointValue.getRawValue();

			if (numberFormat.getWordSize() > 32) {
				return lbfix64(context, dataType, numberFormat, rawValue);
			}

			return lbfix32(context, dataType, numberFormat, rawValue);
		}
		
		throw new IllegalArgumentException();
	}
	
	private List<IValue> lbfix32(IComputationContext context, NumericType dataType, FixedPointFormat numberFormat, long rawValue) {
		int shift;
		for (shift = 1; (rawValue & 0x80000000) == 0; rawValue <<= 1, ++shift);

		int integer = numberFormat.getIntegerLength() - shift;
		int index = (int) (rawValue >> 27 & 0xf);

		int resultRawValue = integer << numberFormat.getFractionLength() | LB_0_TO_1[index] >> numberFormat.getIntegerLength() - 1;
		
		return Collections.<IValue>singletonList(new FixedPointValue(context, dataType, numberFormat, resultRawValue));
	}

	private List<IValue> lbfix64(IComputationContext context, NumericType dataType, FixedPointFormat numberFormat, long rawValue) {
		int shift;
		for (shift = 1; (rawValue & 0x8000000000000000L) == 0; rawValue <<= 1, ++shift);

		int integer = numberFormat.getIntegerLength() - shift;
		int index = (int) (rawValue >> 59 & 0xf);

		int resultRawValue = integer << numberFormat.getFractionLength() | LB_0_TO_1[index] >> numberFormat.getIntegerLength() - 33;
		
		return Collections.<IValue>singletonList(new FixedPointValue(context, dataType, numberFormat, resultRawValue));
	}

}

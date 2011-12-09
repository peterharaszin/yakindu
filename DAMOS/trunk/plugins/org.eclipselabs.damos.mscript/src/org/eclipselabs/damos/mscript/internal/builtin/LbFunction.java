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

import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.util.FixMath;
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

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		RealType dataType = TypeUtil.createRealType();

		IValue argument = arguments.get(0);
		if (argument instanceof AnyValue) {
			return Collections.<IValue> singletonList(new AnyValue(context, dataType));
		}

		argument = argument.convert(dataType);

		if (argument instanceof Binary64Value) {
			Binary64Value binary64Value = (Binary64Value) argument;
			return Collections.<IValue> singletonList(Values.valueOf(context, dataType,
					Math.log(binary64Value.doubleValue()) / LOG_2));
		}

		if (argument instanceof FixedPointValue) {
			FixedPointValue fixedPointValue = (FixedPointValue) argument;
			long rawValue;

			FixedPointFormat numberFormat = (FixedPointFormat) context.getComputationModel().getNumberFormat(dataType);
			if (numberFormat.getWordSize() > 32) {
				rawValue = FixMath.lbfix64(fixedPointValue.getRawValue(), numberFormat.getFractionLength(), context.getOverflowMonitor());
			} else {
				rawValue = FixMath.lbfix32((int) fixedPointValue.getRawValue(), numberFormat.getFractionLength(), context.getOverflowMonitor());
			}
			IValue result = new FixedPointValue(context, dataType, numberFormat, rawValue);
	
			return Collections.singletonList(result);
		}
		
		throw new IllegalArgumentException();
	}

}

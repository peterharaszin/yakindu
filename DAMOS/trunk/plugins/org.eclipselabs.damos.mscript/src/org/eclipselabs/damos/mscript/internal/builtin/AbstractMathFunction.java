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

import java.util.Collections;
import java.util.List;

import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractMathFunction implements IBuiltinFunction {

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		RealType dataType = TypeUtil.createRealType();

		IValue argument = arguments.get(0);
		if (argument instanceof AnyValue) {
			return Collections.<IValue> singletonList(new AnyValue(context, dataType));
		}

		argument = argument.convert(dataType);

		if (argument instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) argument;
			return Collections.singletonList(compute(numericValue));
		}
		
		throw new IllegalArgumentException();
	}
	
	protected abstract IValue compute(ISimpleNumericValue x);

}

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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunction implements IBuiltinFunction {

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		IValue argument = arguments.get(0);
		if (argument instanceof AnyValue) {
			IntegerType outputDataType = MscriptFactory.eINSTANCE.createIntegerType();
			outputDataType.setUnit(EcoreUtil.copy(((NumericType) argument.getDataType()).getUnit()));
			return Collections.<IValue>singletonList(new AnyValue(context, outputDataType));
		}
		if (argument instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) argument;
			return Collections.singletonList(numericValue.round());
		}
		throw new IllegalArgumentException();
	}
	
}

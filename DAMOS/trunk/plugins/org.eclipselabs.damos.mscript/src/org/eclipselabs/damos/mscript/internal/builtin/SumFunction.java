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

import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class SumFunction implements IBuiltinFunction {

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		IValue argument = arguments.get(0);
		if (argument instanceof VectorValue) {
			VectorValue vectorValue = (VectorValue) argument;
			IValue result = null;
			int arraySize = TypeUtil.getArraySize(vectorValue.getDataType());
			for (int i = 0; i < arraySize; ++i) {
				if (result == null) {
					result = vectorValue.get(i);
				} else {
					result = result.add(vectorValue.get(i));
				}
			}
			if (result == null) {
				throw new IllegalArgumentException();
			}
			return Collections.singletonList(result);
		}
		throw new IllegalArgumentException();
	}
	
}

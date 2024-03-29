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

package org.eclipselabs.mscript.language.interpreter.builtin;

import java.util.Collections;
import java.util.List;

import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.VectorValue;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class SumFunction implements IFunction {

	public List<IValue> call(IComputationContext context, List<? extends IValue> arguments) {
		IValue argument = arguments.get(0);
		if (argument instanceof VectorValue) {
			VectorValue vectorValue = (VectorValue) argument;
			IValue result = null;
			int arraySize = TypeSystemUtil.getArraySize(vectorValue.getDataType());
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

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

import org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunction implements IFunction {

	public List<IValue> call(IInterpreterContext context, List<? extends IValue> arguments) {
		IValue argument = arguments.get(0);
		if (argument instanceof ISimpleNumericValue) {
			IValue result = ((ISimpleNumericValue) argument).round();
			return Collections.singletonList(result);
		}
		throw new IllegalArgumentException();
	}
	
}

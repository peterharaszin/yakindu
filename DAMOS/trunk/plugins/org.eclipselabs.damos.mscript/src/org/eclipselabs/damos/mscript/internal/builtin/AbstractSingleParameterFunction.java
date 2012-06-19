/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
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
import org.eclipselabs.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSingleParameterFunction extends AbstractBuiltinFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall) {
		if (functionCall.getArguments().size() != 1) {
			return InvalidValue.SINGLETON;
		}
		IValue value = evaluate(context, functionCall.getArguments().get(0));
		return call(context, functionCall, value);
	}
	
	protected abstract IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, IValue argument);

}

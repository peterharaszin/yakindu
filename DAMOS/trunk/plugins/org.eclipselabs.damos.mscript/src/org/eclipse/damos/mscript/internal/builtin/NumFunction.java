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

package org.eclipse.damos.mscript.internal.builtin;

import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.interpreter.IExpressionEvaluationContext;
import org.eclipse.damos.mscript.interpreter.value.INumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.InvalidValue;
import org.eclipse.damos.mscript.interpreter.value.UnitValue;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class NumFunction extends AbstractBuiltinFunction {

	public IValue call(IExpressionEvaluationContext context, FunctionCall functionCall, boolean staticOnly) {
		if (functionCall.getArguments().size() != 2) {
			return InvalidValue.SINGLETON;
		}

		IValue argument1 = evaluate(context, functionCall.getArguments().get(0));
		
		if (!(argument1 instanceof INumericValue)) {
			return InvalidValue.SINGLETON;
		}
		
		context.enterStaticScope();
		IValue argument2 = evaluate(context, functionCall.getArguments().get(1));
		context.leaveStaticScope();
		if (!(argument2 instanceof UnitValue)) {
			return InvalidValue.SINGLETON;
		}
		
		INumericValue argument = (INumericValue) argument1;
		UnitValue unitValue = (UnitValue) argument2;
		return argument.convertUnit(EcoreUtil.copy(unitValue.getValue()));
	}

}

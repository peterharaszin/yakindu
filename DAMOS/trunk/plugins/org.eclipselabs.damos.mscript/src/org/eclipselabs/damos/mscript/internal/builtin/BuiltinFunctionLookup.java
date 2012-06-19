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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionLookup implements IBuiltinFunctionLookup {

	private final Map<String, IBuiltinFunction> functions = new HashMap<String, IBuiltinFunction>();
	
	{
		functions.put(BuiltinFunctionKind.UNIT.getName(), new UnitFunction());
		functions.put(BuiltinFunctionKind.SIZE.getName(), new SizeFunction());
		functions.put(BuiltinFunctionKind.ROUND.getName(), new RoundFunction());
		functions.put(BuiltinFunctionKind.NUM.getName(), new NumFunction());
		functions.put(BuiltinFunctionKind.LN.getName(), new LnFunction());
		functions.put(BuiltinFunctionKind.LG.getName(), new LgFunction());
		functions.put(BuiltinFunctionKind.LB.getName(), new LbFunction());
		functions.put(BuiltinFunctionKind.EXP.getName(), new ExpFunction());
		functions.put(BuiltinFunctionKind.SIN.getName(), new SinFunction());
		functions.put(BuiltinFunctionKind.COS.getName(), new CosFunction());
		functions.put(BuiltinFunctionKind.TAN.getName(), new TanFunction());
	}
	
	public IBuiltinFunction getFunction(FunctionCall functionCall) {
		return functions.get(functionCall.getFeature().getName());
	}
	
}

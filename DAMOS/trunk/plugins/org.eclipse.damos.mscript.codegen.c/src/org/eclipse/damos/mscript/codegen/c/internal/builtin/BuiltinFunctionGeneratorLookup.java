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

package org.eclipse.damos.mscript.codegen.c.internal.builtin;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.builtin.BuiltinFunctionKind;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionGeneratorLookup implements IBuiltinFunctionGeneratorLookup {
	
	private final Map<String, IBuiltinFunctionGenerator> functions = new HashMap<String, IBuiltinFunctionGenerator>();
	
	{
		functions.put(BuiltinFunctionKind.ROUND.getName(), new RoundFunctionGenerator());
		functions.put(BuiltinFunctionKind.LN.getName(), new LnFunctionGenerator());
		functions.put(BuiltinFunctionKind.LG.getName(), new LgFunctionGenerator());
		functions.put(BuiltinFunctionKind.LB.getName(), new LbFunctionGenerator());
		functions.put(BuiltinFunctionKind.EXP.getName(), new ExpFunctionGenerator());
		functions.put(BuiltinFunctionKind.SIN.getName(), new SinFunctionGenerator());
		functions.put(BuiltinFunctionKind.COS.getName(), new CosFunctionGenerator());
		functions.put(BuiltinFunctionKind.TAN.getName(), new TanFunctionGenerator());
	}
	
	public IBuiltinFunctionGenerator getFunctionGenerator(FunctionCall functionCall) {
		return functions.get(functionCall.getFeature().getName());
	}

}

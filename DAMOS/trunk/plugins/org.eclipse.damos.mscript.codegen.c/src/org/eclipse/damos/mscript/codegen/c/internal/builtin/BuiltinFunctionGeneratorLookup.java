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
	
	private Map<String, IBuiltinFunctionGenerator> cachedFunctions;
	
	public IBuiltinFunctionGenerator getFunctionGenerator(FunctionCall functionCall) {
		if (cachedFunctions == null) {
			cachedFunctions = new HashMap<String, IBuiltinFunctionGenerator>();
			cachedFunctions.put(BuiltinFunctionKind.ROUND.getName(), new RoundFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.LN.getName(), new LnFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.LG.getName(), new LgFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.LB.getName(), new LbFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.EXP.getName(), new ExpFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.SIN.getName(), new SinFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.COS.getName(), new CosFunctionGenerator());
			cachedFunctions.put(BuiltinFunctionKind.TAN.getName(), new TanFunctionGenerator());
		}
		return cachedFunctions.get(functionCall.getFeature().getName());
	}

}

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

package org.eclipse.damos.mscript.codegen.c.builtin;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.builtin.BuiltinFunctionKind;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Andreas Unger
 *
 */
@Singleton
public class BuiltinFunctionGeneratorLookup implements IBuiltinFunctionGeneratorLookup {
	
	private Map<String, IBuiltinFunctionGenerator> cachedFunctions;
	
	@Inject
	private RoundFunctionGenerator roundFunctionGenerator;
	
	@Inject
	private LnFunctionGenerator lnFunctionGenerator;
	
	@Inject
	private LgFunctionGenerator lgFunctionGenerator;
	
	@Inject
	private LbFunctionGenerator lbFunctionGenerator;
	
	@Inject
	private ExpFunctionGenerator expFunctionGenerator;
	
	@Inject
	private SinFunctionGenerator sinFunctionGenerator;
	
	@Inject
	private CosFunctionGenerator cosFunctionGenerator;
	
	@Inject
	private TanFunctionGenerator tanFunctionGenerator;
	
	public IBuiltinFunctionGenerator getFunctionGenerator(FunctionCall functionCall) {
		if (cachedFunctions == null) {
			cachedFunctions = new HashMap<String, IBuiltinFunctionGenerator>();
			cachedFunctions.put(BuiltinFunctionKind.ROUND.getName(), roundFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.LN.getName(), lnFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.LG.getName(), lgFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.LB.getName(), lbFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.EXP.getName(), expFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.SIN.getName(), sinFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.COS.getName(), cosFunctionGenerator);
			cachedFunctions.put(BuiltinFunctionKind.TAN.getName(), tanFunctionGenerator);
		}
		return cachedFunctions.get(functionCall.getFeature().getName());
	}

}

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

package org.eclipselabs.damos.mscript.builtin;

import java.util.List;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.internal.builtin.CosSignature;
import org.eclipselabs.damos.mscript.internal.builtin.ExpSignature;
import org.eclipselabs.damos.mscript.internal.builtin.LbSignature;
import org.eclipselabs.damos.mscript.internal.builtin.LgSignature;
import org.eclipselabs.damos.mscript.internal.builtin.LnSignature;
import org.eclipselabs.damos.mscript.internal.builtin.NumSignature;
import org.eclipselabs.damos.mscript.internal.builtin.RoundSignature;
import org.eclipselabs.damos.mscript.internal.builtin.SinSignature;
import org.eclipselabs.damos.mscript.internal.builtin.SizeSignature;
import org.eclipselabs.damos.mscript.internal.builtin.TanSignature;
import org.eclipselabs.damos.mscript.internal.builtin.UnitSignature;

/**
 * @author Andreas Unger
 *
 */
public enum BuiltinFunctionKind {
	
	UNIT("unit", new UnitSignature()),
	SIZE("size", new SizeSignature()),
	ROUND("round", new RoundSignature()),
	NUM("num", new NumSignature()),
	LN("ln", new LnSignature()),
	LG("lg", new LgSignature()),
	LB("lb", new LbSignature()),
	EXP("exp", new ExpSignature()),
	SIN("sin", new SinSignature()),
	COS("cos", new CosSignature()),
	TAN("tan", new TanSignature());
	
	private String name;
	private IBuiltinFunctionSignature builtinFunctionSignature;

	BuiltinFunctionKind(String name, IBuiltinFunctionSignature builtinFunctionSignature) {
		this.name = name;
		this.builtinFunctionSignature = builtinFunctionSignature;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the signature
	 */
	public IBuiltinFunctionSignature getSignature() {
		return builtinFunctionSignature;
	}
	
	/**
	 * 
	 */
	public static BuiltinFunctionKind get(String name, List<DataType> inputParameterDataTypes) {
		for (BuiltinFunctionKind kind : values()) {
			if (kind.name.equals(name) && kind.builtinFunctionSignature.accepts(inputParameterDataTypes)) {
				return kind;
			}
		}
		return null;
	}
	
}

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

package org.eclipselabs.damos.mscript.il.builtin;

import java.util.List;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.internal.il.builtin.ExpSignature;
import org.eclipselabs.damos.mscript.internal.il.builtin.LbSignature;
import org.eclipselabs.damos.mscript.internal.il.builtin.LgSignature;
import org.eclipselabs.damos.mscript.internal.il.builtin.LnSignature;
import org.eclipselabs.damos.mscript.internal.il.builtin.NumSignature;
import org.eclipselabs.damos.mscript.internal.il.builtin.RoundSignature;
import org.eclipselabs.damos.mscript.internal.il.builtin.UnitSignature;

/**
 * @author Andreas Unger
 *
 */
public enum BuiltinFunctionDescriptor {
	
	UNIT("unit", new UnitSignature()),
	ROUND("round", new RoundSignature()),
	NUM("num", new NumSignature()),
	LN("ln", new LnSignature()),
	LG("lg", new LgSignature()),
	LB("lb", new LbSignature()),
	EXP("exp", new ExpSignature());
	
	private String name;
	private ISignature signature;

	BuiltinFunctionDescriptor(String name, ISignature signature) {
		this.name = name;
		this.signature = signature;
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
	public ISignature getSignature() {
		return signature;
	}
	
	/**
	 * 
	 */
	public static BuiltinFunctionDescriptor get(String name, List<DataType> inputParameterDataTypes) {
		for (BuiltinFunctionDescriptor descriptor : values()) {
			if (descriptor.name.equals(name) && descriptor.signature.accepts(inputParameterDataTypes)) {
				return descriptor;
			}
		}
		return null;
	}
	
}

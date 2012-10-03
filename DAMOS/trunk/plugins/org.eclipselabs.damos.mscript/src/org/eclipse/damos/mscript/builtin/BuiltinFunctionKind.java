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

package org.eclipse.damos.mscript.builtin;

/**
 * @author Andreas Unger
 *
 */
public enum BuiltinFunctionKind {
	
	UNIT("unit"),
	SIZE("size"),
	ROUND("round"),
	NUM("num"),
	LN("ln"),
	LG("lg"),
	LB("lb"),
	EXP("exp"),
	SIN("sin"),
	COS("cos"),
	TAN("tan"),
	FOLD("fold"),
	MAP("map");
	
	private String name;

	BuiltinFunctionKind(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}

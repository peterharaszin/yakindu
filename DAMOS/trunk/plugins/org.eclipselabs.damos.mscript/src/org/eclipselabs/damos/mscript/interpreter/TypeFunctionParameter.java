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

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipselabs.damos.mscript.Type;

public class TypeFunctionParameter extends FunctionParameter {

	private final Type type;

	/**
	 * @param type
	 */
	TypeFunctionParameter(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return TypeFunctionParameter.class.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TypeFunctionParameter) {
			TypeFunctionParameter other = (TypeFunctionParameter) obj;
			return other.type.isEquivalentTo(type);
		}
		return false;
	}
	
}
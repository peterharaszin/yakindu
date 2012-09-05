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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Andreas Unger
 *
 */
public class FunctionSignature {

	private final List<FunctionParameter> parameters;
	private int cachedHashCode;
	
	/**
	 * 
	 */
	private FunctionSignature(List<FunctionParameter> parameters) {
		this.parameters = new ArrayList<FunctionParameter>(parameters);
	}
	
	public static FunctionSignature create(List<FunctionParameter> parameters) {
		return new FunctionSignature(Collections.unmodifiableList(new ArrayList<FunctionParameter>(parameters)));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (cachedHashCode == 0) {
			cachedHashCode = 17 + parameters.hashCode();
			if (cachedHashCode == 0) { 
				cachedHashCode = 1;
			}
		}
		return cachedHashCode;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FunctionSignature) {
			FunctionSignature other = (FunctionSignature) obj;
			return other.parameters.equals(parameters);
		}
		return false;
	}
		
}

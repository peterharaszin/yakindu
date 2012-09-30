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

import org.eclipselabs.damos.mscript.FunctionDeclaration;

/**
 * @author Andreas Unger
 *
 */
public class FunctionSignature { // TODO

	private final FunctionDeclaration functionDeclaration;
	private final List<FunctionParameter> parameters;
	private int cachedHashCode;
	
	private FunctionSignature(FunctionDeclaration functionDeclaration, List<FunctionParameter> parameters) {
		this.functionDeclaration = functionDeclaration;
		this.parameters = parameters;
	}
	
	/**
	 * @return the parameters
	 */
	public List<FunctionParameter> getParameters() {
		return parameters;
	}
	
	public static FunctionSignature create(FunctionDeclaration functionDeclaration, List<FunctionParameter> parameters) {
		if (functionDeclaration == null || parameters == null) {
			throw new NullPointerException();
		}
		return new FunctionSignature(functionDeclaration, Collections.unmodifiableList(new ArrayList<FunctionParameter>(parameters)));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (cachedHashCode == 0) {
			cachedHashCode = 17 + parameters.hashCode() + functionDeclaration.hashCode();
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
		if (this == obj) {
			return true;
		}
		if (obj instanceof FunctionSignature) {
			FunctionSignature other = (FunctionSignature) obj;
			return other.functionDeclaration == functionDeclaration && other.parameters.equals(parameters);
		}
		return false;
	}
		
}

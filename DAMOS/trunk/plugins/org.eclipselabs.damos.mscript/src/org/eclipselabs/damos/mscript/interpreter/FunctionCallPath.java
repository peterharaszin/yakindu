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

import java.util.Arrays;

import org.eclipselabs.damos.mscript.FunctionCall;

/**
 * @author Andreas Unger
 *
 */
public class FunctionCallPath {

	public static final FunctionCallPath EMPTY = new FunctionCallPath(new FunctionCall[0]);
	
	private final FunctionCall[] functionCalls;
	
	private FunctionCallPath(FunctionCall[] functionCalls) {
		this.functionCalls = functionCalls;
	}
	
	public FunctionCallPath append(FunctionCall functionCall) {
		FunctionCall[] newFunctionCalls = Arrays.copyOf(this.functionCalls, this.functionCalls.length + 1);
		newFunctionCalls[newFunctionCalls.length - 1] = functionCall;
		return new FunctionCallPath(newFunctionCalls);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Arrays.hashCode(functionCalls);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FunctionCallPath) {
			FunctionCallPath other = (FunctionCallPath) obj;
			return Arrays.equals(other.functionCalls, functionCalls);
		}
		return false;
	}
	
}

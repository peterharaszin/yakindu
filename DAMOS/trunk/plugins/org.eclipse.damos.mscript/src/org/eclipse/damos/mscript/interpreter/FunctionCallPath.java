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

package org.eclipse.damos.mscript.interpreter;

import java.util.Arrays;

import org.eclipse.damos.mscript.CallableElement;
import org.eclipse.damos.mscript.FunctionCall;
import org.eclipse.damos.mscript.function.transform.TransformAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
	
	public boolean contains(FunctionCall functionCall) {
		functionCall = getActualFunctionCall(functionCall);
		for (FunctionCall nextFunctionCall : functionCalls) {
			if (getActualFunctionCall(nextFunctionCall) == functionCall) {
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = 31;
		for (FunctionCall functionCall : functionCalls) {
			hashCode += getActualFunctionCall(functionCall).hashCode();
		}
		return hashCode;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FunctionCallPath) {
			FunctionCallPath other = (FunctionCallPath) obj;
			if (other.functionCalls.length != functionCalls.length) {
				return false;
			}
			for (int i = 0; i < functionCalls.length; ++i) {
				FunctionCall functionCall = getActualFunctionCall(functionCalls[i]);
				FunctionCall otherFunctionCall = getActualFunctionCall(other.functionCalls[i]);
				if (functionCall != otherFunctionCall) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("/");
		for (FunctionCall functionCall : functionCalls) {
			if (sb.length() > 1) {
				sb.append("/");
			}
			String name = "<UNKNOWN>";
			CallableElement feature = functionCall.getFeature();
			if (feature != null && feature.getName() != null) {
				name = feature.getName();
			}
			sb.append(name);
		}
		return sb.toString();
	}
	
	private FunctionCall getActualFunctionCall(FunctionCall functionCall) {
		@SuppressWarnings("unchecked")
		TransformAdapter<FunctionCall> adapter = (TransformAdapter<FunctionCall>) EcoreUtil.getAdapter(functionCall.eAdapters(), TransformAdapter.class);
		if (adapter != null) {
			return adapter.getOriginalElement();
		}
		return functionCall;
	}
	
}

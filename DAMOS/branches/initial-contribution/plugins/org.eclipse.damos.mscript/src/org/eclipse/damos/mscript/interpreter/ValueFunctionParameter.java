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

import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.damos.mscript.interpreter.value.INumericValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;

public class ValueFunctionParameter extends FunctionParameter {
	
	private final IValue value;
	
	ValueFunctionParameter(IValue value) {
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public IValue getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = ValueFunctionParameter.class.hashCode();
		if (value instanceof INumericValue) {
			hashCode += Double.toString(((ISimpleNumericValue) value).doubleValue()).hashCode();
		}
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ValueFunctionParameter) {
			ValueFunctionParameter other = (ValueFunctionParameter) obj;
			IValue otherValue = other.value;
			if (!otherValue.getDataType().isEquivalentTo(value.getDataType())) {
				return false;
			}
			IValue result = otherValue.equalTo(value);
			return result instanceof IBooleanValue && ((IBooleanValue) result).booleanValue();
		}
		return false;
	}
	
}
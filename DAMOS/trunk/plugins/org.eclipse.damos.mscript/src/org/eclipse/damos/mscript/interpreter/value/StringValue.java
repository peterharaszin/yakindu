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

package org.eclipse.damos.mscript.interpreter.value;

import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.IComputationContext;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class StringValue extends AbstractValue {
	
	private final String value;

	/**
	 * 
	 */
	public StringValue(IComputationContext context, String value) {
		super(context);
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.execution.value.IValue#getDataType()
	 */
	public Type getDataType() {
		return TypeUtil.STRING_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doAdd(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doAdd(IValue other, Type resultDataType) {
		IValue otherValue = other.convert(getDataType());
		if (otherValue instanceof InvalidValue) {
			return otherValue;
		}
		return new StringValue(getContext(), value + otherValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, Type resultDataType) {
		return new BooleanValue(getContext(), value.equals(other.toString()));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		return new BooleanValue(getContext(), !value.equals(other.toString()));
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return value;
	}
		
}

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
public class BooleanValue extends AbstractValue implements IBooleanValue {
	
	private boolean value;

	/**
	 * 
	 */
	public BooleanValue(IComputationContext context, boolean value) {
		super(context);
		this.value = value;
	}
	
	public boolean booleanValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.execution.value.IValue#getDataType()
	 */
	public Type getDataType() {
		return TypeUtil.BOOLEAN_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.IValue#convert(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	public IValue doConvert(Type type) {
		return this;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, Type resultDataType) {
		return new BooleanValue(getContext(), value == ((BooleanValue) other).value);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipse.damos.mscript.interpreter.value.IValue, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		return new BooleanValue(getContext(), value != ((BooleanValue) other).value);
	}

}

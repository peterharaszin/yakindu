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

package org.eclipselabs.damos.mscript.interpreter.value;

import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.util.TypeUtil;


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
	 * @see org.eclipselabs.mscript.execution.value.IValue#getDataType()
	 */
	public Type getDataType() {
		return TypeUtil.BOOLEAN_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#convert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	public IValue doConvert(Type type) {
		return this;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, Type resultDataType) {
		return new BooleanValue(getContext(), value == ((BooleanValue) other).value);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		return new BooleanValue(getContext(), value != ((BooleanValue) other).value);
	}

}

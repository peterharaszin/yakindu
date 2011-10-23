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

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class StringValue extends AbstractValue {
	
	private String value;

	/**
	 * 
	 */
	public StringValue(IComputationContext context, String value) {
		super(context);
		this.value = value;
	}
	
	public String stringValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.value.IValue#getDataType()
	 */
	public DataType getDataType() {
		return TypeUtil.STRING_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return this;
	}
		
}

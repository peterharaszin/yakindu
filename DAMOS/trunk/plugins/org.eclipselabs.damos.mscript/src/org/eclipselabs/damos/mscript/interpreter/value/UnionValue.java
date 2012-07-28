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

package org.eclipselabs.damos.mscript.interpreter.value;

import org.eclipselabs.damos.mscript.UnionType;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;

/**
 * @author Andreas Unger
 *
 */
public class UnionValue extends AbstractExplicitDataTypeValue {

	private final int tag;
	private final IValue value;
	
	/**
	 * @param context
	 * @param type
	 */
	public UnionValue(IComputationContext context, UnionType type, int tag, IValue value) {
		super(context, type);
		this.tag = tag;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public UnionType getDataType() {
		return (UnionType) super.getDataType();
	}
	
	/**
	 * @return the tag
	 */
	public int getTag() {
		return tag;
	}
	
	/**
	 * @return the value
	 */
	public IValue getValue() {
		return value;
	}

}

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


/**
 * @author Andreas Unger
 *
 */
public class UninitializedValue extends AbstractValue {

	/**
	 * @param context
	 */
	public UninitializedValue(IComputationContext context) {
		super(context);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#getDataType()
	 */
	public Type getDataType() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(Type type) {
		return this;
	}
	
}

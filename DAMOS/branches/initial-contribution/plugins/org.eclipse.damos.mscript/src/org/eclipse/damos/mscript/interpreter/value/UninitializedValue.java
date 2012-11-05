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
	 * @see org.eclipse.damos.mscript.interpreter.value.IValue#getDataType()
	 */
	public Type getDataType() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.interpreter.value.AbstractValue#doConvert(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(Type type) {
		return this;
	}
	
}

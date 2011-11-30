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

package org.eclipselabs.damos.mscript.interpreter.builtin;

import org.eclipselabs.damos.mscript.il.builtin.BuiltinFunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionLookupTable implements IBuiltinFunctionLookupTable {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.builtin.IBuiltinFunctionLookupTable#getFunction(org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor)
	 */
	public IFunction getFunction(BuiltinFunctionDescriptor descriptor) {
		switch (descriptor) {
		case UNIT:
			return new UnitFunction();
		case ROUND:
			return new RoundFunction();
		case NUM:
			return new NumFunction();
		case LB:
			return new LbFunction();
		}
		return null;
	}
	
}

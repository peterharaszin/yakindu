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

package org.eclipselabs.damos.mscript.internal.builtin;

import org.eclipselabs.damos.mscript.builtin.BuiltinFunctionKind;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionLookupTable implements IBuiltinFunctionLookupTable {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.builtin.IBuiltinFunctionLookupTable#getFunction(org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor)
	 */
	public IBuiltinFunction getFunction(BuiltinFunctionKind descriptor) {
		switch (descriptor) {
		case UNIT:
			return new UnitFunction();
		case SIZE:
			return new SizeFunction();
		case ROUND:
			return new RoundFunction();
		case NUM:
			return new NumFunction();
		case LN:
			return new LnFunction();
		case LG:
			return new LgFunction();
		case LB:
			return new LbFunction();
		case EXP:
			return new ExpFunction();
		case SIN:
			return new SinFunction();
		case COS:
			return new CosFunction();
		case TAN:
			return new TanFunction();
		}
		return null;
	}
	
}

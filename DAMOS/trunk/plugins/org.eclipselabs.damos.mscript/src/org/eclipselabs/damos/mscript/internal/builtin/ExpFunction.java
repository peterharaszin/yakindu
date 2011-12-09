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

import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 * 
 */
public class ExpFunction extends AbstractExpLogFunction {
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.internal.builtin.AbstractExpLogFunction#compute(org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue)
	 */
	@Override
	protected IValue compute(ISimpleNumericValue x) {
		return x.exp();
	}
	
}

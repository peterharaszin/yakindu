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

package org.eclipse.damos.mscript.internal.builtin;

import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class LgFunction extends AbstractMathFunction {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.internal.builtin.AbstractExpLogFunction#compute(org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue)
	 */
	@Override
	protected IValue compute(ISimpleNumericValue x) {
		return x.lg();
	}

}

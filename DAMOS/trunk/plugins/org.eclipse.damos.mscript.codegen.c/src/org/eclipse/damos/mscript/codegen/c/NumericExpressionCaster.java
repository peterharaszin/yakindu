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

package org.eclipse.damos.mscript.codegen.c;

import org.eclipse.damos.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipse.damos.mscript.codegen.c.internal.util.CastToFloatingPointHelper;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionCaster {
	
	@Inject
	private CastToFloatingPointHelper castToFloatingPointHelper;
	
	@Inject
	private CastToFixedPointHelper castToFixedPointHelper;

	public CharSequence cast(CharSequence expression, NumberFormat numberFormat, NumberFormat targetNumberFormat) {
		if (targetNumberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) targetNumberFormat;
			return castToFloatingPointHelper.cast(expression, numberFormat, floatingPointFormat);
		}
		if (targetNumberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) targetNumberFormat;
			return castToFixedPointHelper.cast(expression, numberFormat, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength());
		}
		throw new IllegalArgumentException();
	}
	
}

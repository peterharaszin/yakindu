/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipselabs.damos.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.damos.mscript.codegen.c.internal.util.CastToFloatingPointHelper;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionCaster {
	
	public static final NumericExpressionCaster INSTANCE = new NumericExpressionCaster();
	
	public CharSequence cast(CharSequence expression, NumberFormat numberFormat, NumberFormat targetNumberFormat) {
		if (targetNumberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) targetNumberFormat;
			return CastToFloatingPointHelper.INSTANCE.cast(expression, numberFormat, floatingPointFormat);
		}
		if (targetNumberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) targetNumberFormat;
			return CastToFixedPointHelper.INSTANCE.cast(expression, numberFormat, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength());
		}
		throw new IllegalArgumentException();
	}
	
}

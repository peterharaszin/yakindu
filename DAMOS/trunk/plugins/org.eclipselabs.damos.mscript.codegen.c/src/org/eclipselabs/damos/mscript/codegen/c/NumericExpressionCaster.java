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
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionCaster {
	
	public static final NumericExpressionCaster INSTANCE = new NumericExpressionCaster();
	
	public CharSequence cast(NumberFormat targetNumberFormat, NumericExpressionInfo expression) {
		if (targetNumberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) targetNumberFormat;
			return CastToFloatingPointHelper.INSTANCE.cast(floatingPointFormat, expression);
		}
		if (targetNumberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) targetNumberFormat;
			return CastToFixedPointHelper.INSTANCE.cast(fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength(), expression);
		}
		throw new IllegalArgumentException();
	}
	
}

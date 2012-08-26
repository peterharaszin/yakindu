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

package org.eclipselabs.damos.mscript.codegen.c.internal.util;

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;

public class CastToFloatingPointHelper {
	
	public static final CastToFloatingPointHelper INSTANCE = new CastToFloatingPointHelper();

	public CharSequence cast(CharSequence expression, NumberFormat numberFormat, FloatingPointFormat targetFloatingPointFormat) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			if (floatingPointFormat.getKind() == targetFloatingPointFormat.getKind()) {
				out.print(expression);
			} else {
				out.printf("((%s) (", getCDataType(targetFloatingPointFormat));
				out.print(expression);
				out.print("))");
			}
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			if (fixedPointFormat.getFractionLength() > 0) {
				out.printf("((%s) ((", getCDataType(targetFloatingPointFormat));
				out.print(expression);
				out.printf(") * pow(2, -%d)))", fixedPointFormat.getFractionLength());
			} else {
				out.printf("((%s) (", getCDataType(targetFloatingPointFormat));
				out.print(expression);
				out.print("))");
			}
		}
		return sb;
	}
	
	private String getCDataType(FloatingPointFormat floatingPointFormat) {
		switch (floatingPointFormat.getKind()) {
		case BINARY32:
			return "float";
		case BINARY64:
			return "double";
		default:
			throw new IllegalArgumentException();
		}
	}
	
}
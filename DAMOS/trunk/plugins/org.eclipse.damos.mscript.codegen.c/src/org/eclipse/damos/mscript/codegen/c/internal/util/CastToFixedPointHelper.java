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

package org.eclipse.damos.mscript.codegen.c.internal.util;

import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;

public class CastToFixedPointHelper {

	public static final CastToFixedPointHelper INSTANCE = new CastToFixedPointHelper();
	
	public CharSequence cast(CharSequence expression, NumberFormat numberFormat, int targetWordSize, int targetFractionLength) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (numberFormat instanceof FloatingPointFormat) {
			if (targetFractionLength > 0) {
				out.printf("((%s) floor((", getCDataType(targetWordSize));
				out.print(expression);
				out.printf(") * pow(2, %d) + 0.5))", targetFractionLength);
			} else {
				out.printf("((%s) (", getCDataType(targetWordSize));
				out.print(expression);
				out.print("))");
			}
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			if (targetWordSize != fixedPointFormat.getWordSize()) {
				if (targetFractionLength < fixedPointFormat.getFractionLength()) {
					out.printf("(%s) ((", getCDataType(targetWordSize));
				} else {
					out.printf("((%s) (", getCDataType(targetWordSize));
				}
			}
			if (targetFractionLength != fixedPointFormat.getFractionLength()) {
				if (targetWordSize == fixedPointFormat.getWordSize()) {
					out.print("((");
				}
				out.print(expression);
				if (targetFractionLength > fixedPointFormat.getFractionLength()) {
					out.printf(") << %d)", targetFractionLength - fixedPointFormat.getFractionLength());
				} else {
					out.printf(") >> %d)", fixedPointFormat.getFractionLength() - targetFractionLength);
				}
			} else {
				out.print(expression);
				if (targetWordSize != fixedPointFormat.getWordSize()) {
					out.print("))");
				}
			}
		}
		return sb;
	}
	
	private String getCDataType(int wordSize) {
		return String.format("int%d_t", wordSize);
	}
	
}
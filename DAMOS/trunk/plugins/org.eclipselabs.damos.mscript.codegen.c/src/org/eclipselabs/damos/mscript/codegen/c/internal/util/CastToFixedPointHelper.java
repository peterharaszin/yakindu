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
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;

public class CastToFixedPointHelper {

	public static final CastToFixedPointHelper INSTANCE = new CastToFixedPointHelper();
	
	public CharSequence cast(int wordSize, int fractionLength, NumericExpressionInfo expression) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (expression.getNumberFormat() instanceof FloatingPointFormat) {
			if (fractionLength > 0) {
				out.printf("((%s) floor((", getCDataType(wordSize));
				out.print(expression.getText());
				out.printf(") * pow(2, %d) + 0.5))", fractionLength);
			} else {
				out.printf("((%s) (", getCDataType(wordSize));
				out.print(expression.getText());
				out.print("))");
			}
		} else if (expression.getNumberFormat() instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) expression.getNumberFormat();
			if (wordSize != fixedPointFormat.getWordSize()) {
				if (fractionLength < fixedPointFormat.getFractionLength()) {
					out.printf("(%s) ((", getCDataType(wordSize));
				} else {
					out.printf("((%s) (", getCDataType(wordSize));
				}
			}
			if (fractionLength != fixedPointFormat.getFractionLength()) {
				if (wordSize == fixedPointFormat.getWordSize()) {
					out.print("((");
				}
				out.print(expression.getText());
				if (fractionLength > fixedPointFormat.getFractionLength()) {
					out.printf(") << %d)", fractionLength - fixedPointFormat.getFractionLength());
				} else {
					out.printf(") >> %d)", fixedPointFormat.getFractionLength() - fractionLength);
				}
			} else {
				out.print(expression.getText());
				if (wordSize != fixedPointFormat.getWordSize()) {
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
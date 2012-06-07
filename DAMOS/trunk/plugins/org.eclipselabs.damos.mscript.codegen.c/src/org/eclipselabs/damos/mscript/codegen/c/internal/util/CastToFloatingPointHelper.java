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

public class CastToFloatingPointHelper {
	
	public static final CastToFloatingPointHelper INSTANCE = new CastToFloatingPointHelper();

	public CharSequence cast(FloatingPointFormat targetFloatingPointFormat, NumericExpressionInfo expression) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (expression.getNumberFormat() instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) expression.getNumberFormat();
			if (floatingPointFormat.getKind() == targetFloatingPointFormat.getKind()) {
				out.print(expression.getText());
			} else {
				out.printf("((%s) (", getCDataType(targetFloatingPointFormat));
				out.print(expression.getText());
				out.print("))");
			}
		} else if (expression.getNumberFormat() instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) expression.getNumberFormat();
			if (fixedPointFormat.getFractionLength() > 0) {
				out.printf("((%s) ((", getCDataType(targetFloatingPointFormat));
				out.print(expression.getText());
				out.printf(") * pow(2, -%d)))", fixedPointFormat.getFractionLength());
			} else {
				out.printf("((%s) (", getCDataType(targetFloatingPointFormat));
				out.print(expression.getText());
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
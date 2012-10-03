/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.library.common.util;

/**
 * @author Andreas Unger
 *
 */
public class PolynomialExpressionUtil {

	public static String createPolynomialExpression(double[] coefficients, String variableName, boolean inverse) {
		StringBuilder sb = new StringBuilder();
		int n = coefficients.length - 1;
		for (double coefficient : coefficients) {
			String coefficientString = Double.toString(coefficient).replaceAll("\\.0*\\z", "");
			if (coefficient != 0) {
				if (sb.length() > 0 && coefficient > 0) {
					sb.append("+");
				}
				if (Math.abs(coefficient) != 1 || n == 0) {
					sb.append(coefficientString);
				}
				if (n != 0) {
					if (coefficient == -1) {
						sb.append("-");
					}
					sb.append(variableName);
					if (n != 1 || inverse) {
						sb.append("^{");
						if (inverse) {
							sb.append("-");
						}
						sb.append(n);
						sb.append("}");
					}
				}
			}
			--n;
		}
		return sb.length() > 0 ? sb.toString() : "0";
	}

}

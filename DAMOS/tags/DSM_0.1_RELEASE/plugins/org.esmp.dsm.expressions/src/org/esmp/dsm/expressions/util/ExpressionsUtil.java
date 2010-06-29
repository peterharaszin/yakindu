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

package org.esmp.dsm.expressions.util;

import org.esmp.dsm.expressions.BooleanDataType;
import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.expressions.DoubleDataType;
import org.esmp.dsm.expressions.FixedPointDataType;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionsUtil {

	public static DataType parseDataTypeExpression(String expression) {
		expression = expression.trim();
		if ("Inherit".equals(expression)) {
			return null;
		}
		if ("boolean".equals(expression)) {
			return new BooleanDataType();
		}
		if ("double".equals(expression)) {
			return new DoubleDataType();
		}
		if (expression.matches("u?fix\\d+\\.\\d+")) {
			boolean signed = true;
			if (expression.charAt(0) == 'u') {
				signed = false;
			}
			expression = expression.substring(signed ? 3 : 4);
			String[] params = expression.split("\\.");
			return new FixedPointDataType(
					signed,
					Integer.parseInt(params[0]),
					Integer.parseInt(params[1]));
		}
		return null;
	}

	public static double[] parseListExpression(String expression) {
		if (!expression.matches("\\A\\s*\\[.*\\]\\s*\\z")) {
			throw new IllegalArgumentException("Illegal expression");
		}
		String[] elements = expression.replaceAll("\\A.*\\[|\\].*\\z|\\s\\s+", " ").trim().split("\\s");
		double[] result = new double[elements.length];
		try {
			for (int i = 0; i < elements.length; ++i) {
				result[i] = Double.parseDouble(elements[i]);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
		return result != null ? result : new double[0];
	}

}

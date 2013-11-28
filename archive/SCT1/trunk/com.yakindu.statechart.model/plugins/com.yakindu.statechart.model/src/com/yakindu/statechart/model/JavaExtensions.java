/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model;

public class JavaExtensions {

	public static final String extractGuardExpressionString(
			final String expression) {
		if (expression == null || "".equals(expression)) {
			return null;
		}

		int begin, end = 0;
		begin = expression.indexOf("[");
		end = expression.indexOf("]");
		if (begin == -1 || end == -1)
			return null;

		return expression.substring(begin + 1, end);
	}

	public static final String extractActionExpressionString(
			final String expression) {

		if (expression == null || "".equals(expression))
			return null;

		int slash = expression.indexOf("/");
		if (slash == -1)
			return null;

		return expression.substring(slash + 1);
	}

	public static final String extractTriggerExpressionString(
			final String expression) {

		if (expression == null || "".equals(expression))
			return null;

		int endIndex = expression.indexOf("[");
		if (endIndex == -1)
			endIndex = expression.indexOf("/");
		if (endIndex == -1)
			endIndex = expression.length();

		return expression.substring(0, endIndex);
	}
}

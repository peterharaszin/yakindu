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

package org.eclipselabs.damos.diagram.core.internal.util;

import java.math.BigDecimal;

/**
 * @author Andreas Unger
 *
 */
public class MathUtil {

	public static int normalizeAngle(int angle) {
		angle %= 360;
		if (angle < 0) {
			angle += 360;
		}
		return angle;
	}

	public static double gcd(double a, double b) {
		return gcd(BigDecimal.valueOf(a), BigDecimal.valueOf(b));
	}

	private static double gcd(BigDecimal a, BigDecimal b) {
		if (BigDecimal.ZERO.compareTo(b) == 0) {
			return a.doubleValue();
		}
		return gcd(b, a.remainder(b));
	}

}

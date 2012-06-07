/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.common.math;

import java.math.BigInteger;

/**
 * @author Andreas Unger
 *
 */
public class BigIntegerUtil {

	public static BigInteger clearBits(BigInteger value, int n, int count) {
		byte[] result = value.toByteArray();
		int l = result.length - 1;
		while (count != 0) {
			int i = l - n / 8;
			if (i < 0) {
				return new BigInteger(1, result);
			}
			result[i] &= ~(1 << n % 8);
			++n;
			--count;
		}
		return new BigInteger(result);
	}
	
	public static BigInteger setBits(BigInteger value, int n, int count) {
		byte[] result = value.toByteArray();
		int l = result.length - 1;
		while (count != 0) {
			int i = l - n / 8;
			if (i < 0) {
				break;
			}
			result[i] |= 1 << n % 8;
			++n;
			--count;
		}
		return new BigInteger(result);
	}

}

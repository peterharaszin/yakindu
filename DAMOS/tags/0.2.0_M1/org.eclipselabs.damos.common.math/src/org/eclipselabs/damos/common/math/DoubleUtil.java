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

package org.eclipselabs.damos.common.math;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Andreas Unger
 *
 */
public class DoubleUtil {
	
	public static BigDecimal getFractionPart(double value) {
		BigDecimal bdv = BigDecimal.valueOf(value);
		return bdv.subtract(new BigDecimal(bdv.toBigInteger()));
	}
	
	public static BigInteger toBigInteger(double value) {
		return BigDecimal.valueOf(value).toBigInteger();
	}
	
}

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

package org.esmp.dsm.expressions.util;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.esmp.dsm.common.math.DoubleUtil;
import org.esmp.dsm.expressions.FixedPointDataType;

/**
 * @author Andreas Unger
 *
 */
public class FixedPointDataTypeUtil {

	public static BigInteger toFixedPoint(double value, FixedPointDataType type) {
		BigInteger fractionPart = DoubleUtil.getFractionPart(value).multiply(new BigDecimal(type.scalingFactor())).toBigInteger();
		BigInteger maxFractionPart = type.scalingFactor().subtract(BigInteger.ONE);
		if (fractionPart.compareTo(maxFractionPart) > 0) {
			fractionPart = maxFractionPart;
		}
		return DoubleUtil.toBigInteger(value).shiftLeft(type.getFractionLength()).or(fractionPart);
	}

}

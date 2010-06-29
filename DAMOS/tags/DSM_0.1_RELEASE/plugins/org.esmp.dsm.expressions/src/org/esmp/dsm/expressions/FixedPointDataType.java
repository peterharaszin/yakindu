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

package org.esmp.dsm.expressions;

import java.math.BigInteger;


/**
 * @author Andreas Unger
 *
 */
public class FixedPointDataType implements DataType {

	private boolean signed;
	private int wordLength;
	private int fractionLength;
	
	private BigInteger cachedScalingFactor;
	private BigInteger cachedMaxValue;
	private BigInteger cachedMinValue;

	public FixedPointDataType(boolean signed, int wordLength, int fractionLength) {
		this.signed = signed;
		if (wordLength <= 8) {
			this.wordLength = 8;
		} else if (wordLength <= 16) {
			this.wordLength = 16;
		} else if (wordLength <= 32) {
			this.wordLength = 32;
		} else {
			this.wordLength = 64;
		}
		this.fractionLength = fractionLength;
	}

	/**
	 * @return the signed
	 */
	public boolean isSigned() {
		return signed;
	}

	/**
	 * @return the wordLength
	 */
	public int getWordLength() {
		return wordLength;
	}

	/**
	 * @return the fractionLength
	 */
	public int getFractionLength() {
		return fractionLength;
	}
	
	public BigInteger scalingFactor() {
		if (cachedScalingFactor == null) {
			cachedScalingFactor = BigInteger.ONE.shiftLeft(fractionLength);
		}
		return cachedScalingFactor;
	}
	
	public BigInteger minValue() {
		if (cachedMinValue == null) {
			cachedMinValue = signed ? BigInteger.ONE.shiftLeft(wordLength - 1).negate() : BigInteger.ZERO;
		}
		return  cachedMinValue;
	}

	public BigInteger maxValue() {
		if (cachedMaxValue == null) {
			cachedMaxValue = signed ? BigInteger.ONE.shiftLeft(wordLength - 1).subtract(BigInteger.ONE) : BigInteger.ONE.shiftLeft(wordLength).subtract(BigInteger.ONE);
		}
		return cachedMaxValue;
	}
	
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}
		if (obj instanceof FixedPointDataType) {
			FixedPointDataType other = (FixedPointDataType) obj;
			return other.signed == signed
					&& other.wordLength == wordLength
					&& other.fractionLength == fractionLength;
		}
		return false;
	}

}

/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/

package org.eclipse.damos.mscript.util;

import java.math.BigDecimal;

/**
 * @author Andreas Unger
 *
 */
public class SampleTime implements ISampleInterval {

	private final double value;
	
	public SampleTime(double value) {
		this.value = value;
	}
	
	public double sampleTime() {
		return value;
	}
	
	public ISampleInterval getFundamental(ISampleInterval other) {
		if (other == null) {
			return this;
		}
		double otherSampleTime = other.sampleTime();
		if (value == otherSampleTime) {
			return this;
		}
		double fundamental = gcd(value, otherSampleTime);
		if (fundamental == value) {
			return this;
		}
		if (fundamental == otherSampleTime) {
			return other;
		}
		return new SampleTime(fundamental);
	}

	private double gcd(double a, double b) {
		return gcd(BigDecimal.valueOf(a), BigDecimal.valueOf(b));
	}

	private double gcd(BigDecimal a, BigDecimal b) {
		if (BigDecimal.ZERO.compareTo(b) == 0) {
			return a.doubleValue();
		}
		return gcd(b, a.remainder(b));
	}
	
	@Override
	public int hashCode() {
		long v = Double.doubleToLongBits(value);
		return (int) (v ^ (v >>> 32));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SampleTime) {
			return ((SampleTime) obj).value == value;
		}
		return false;
	}

}

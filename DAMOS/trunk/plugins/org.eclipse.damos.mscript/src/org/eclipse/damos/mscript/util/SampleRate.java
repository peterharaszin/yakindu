/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.util;

/**
 * @author Andreas Unger
 *
 */
public class SampleRate implements ISampleInterval {

	private long value;
	
	public SampleRate(long value) {
		this.value = value;
	}

	public double sampleTime() {
		return 1.0 / value;
	}
	
	public long longValue() {
		return value;
	}
	
	public ISampleInterval getFundamental(ISampleInterval other) {
		if (other == null) {
			return this;
		}
		if (other instanceof SampleRate) {
			SampleRate otherSampleRate = (SampleRate) other;
			if (value == otherSampleRate.value) {
				return this;
			}
			long fundamental = gcd(value, otherSampleRate.value);
			if (fundamental == value) {
				return this;
			}
			if (fundamental == otherSampleRate.value) {
				return other;
			}
			return new SampleRate(fundamental);
		}
		return new SampleTime(sampleTime()).getFundamental(this);
	}

	private long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	
}

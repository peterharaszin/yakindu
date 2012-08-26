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

package org.eclipselabs.damos.mscript.interpreter.value;

import java.math.BigInteger;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.OverflowInfo;
import org.eclipselabs.damos.mscript.interpreter.util.FixMath;

/**
 * @author Andreas Unger
 *
 */
public class FixedPointValue extends AbstractNumericValue implements ISimpleNumericValue {

	private long rawValue;
	
	private static final BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
	private static final BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
	
	public FixedPointValue(IComputationContext context, NumericType dataType, FixedPointFormat numberFormat, long rawValue) {
		super(context, dataType, numberFormat);
		this.rawValue = rawValue;
	}

	public long getRawValue() {
		return rawValue;
	}

	public double doubleValue() {
		return rawValue * Math.pow(2, -getNumberFormat().getFractionLength());
	}
	
	public long longValue() {
		return rawValue >> getNumberFormat().getFractionLength();
	}
	
	@Override
	protected FixedPointFormat getNumberFormat() {
		return (FixedPointFormat) super.getNumberFormat();
	}

	@Override
	protected IValue doConvert(Type type) {
		if (type instanceof StringType) {
			if (getDataType() instanceof IntegerType) {
				return new StringValue(getContext(), Long.toString(longValue()));
			}
			return InvalidValue.SINGLETON;
		}
		NumberFormat numberFormat = getContext().getComputationModel().getNumberFormat(type);
		if (getNumberFormat().isEquivalentTo(numberFormat)) {
			return new FixedPointValue(getContext(), (NumericType) type, getNumberFormat(), rawValue);
		}
		return doCast((NumericType) type, numberFormat);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.AbstractNumericValue#doAdd(org.eclipselabs.damos.mscript.interpreter.value.IValue, org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	protected IValue doAdd(IValue other, Type resultDataType) {
		if (resultDataType instanceof StringType) {
			return new StringValue(getContext(), Long.toString(longValue()) + other);
		}
		return super.doAdd(other, resultDataType);
	}
	
	@Override
	protected AbstractNumericValue basicAdd(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger result = BigInteger.valueOf(rawValue).add(BigInteger.valueOf(otherFixedPointValue.rawValue));
			return createValue(resultDataType, result);
		}

		long result = rawValue + otherFixedPointValue.rawValue;
		return createValue(resultDataType, result);
	}

	@Override
	protected AbstractNumericValue basicSubtract(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger result = BigInteger.valueOf(rawValue).subtract(BigInteger.valueOf(otherFixedPointValue.rawValue));
			return createValue(resultDataType, result);
		}

		long result = rawValue - otherFixedPointValue.rawValue;
		return createValue(resultDataType, result);
	}
	
	@Override
	protected AbstractNumericValue basicMultiply(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		long result;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger bigResult = BigInteger.valueOf(rawValue).multiply(BigInteger.valueOf(otherFixedPointValue.rawValue));
			if (bigResult.compareTo(LONG_MIN_VALUE) < 0 || bigResult.compareTo(LONG_MAX_VALUE) > 0) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
			result = bigResult.longValue();
		} else {
			result = rawValue * otherFixedPointValue.rawValue;
		}

		long truncatedResult = truncate(result, getIntermediateWordSize());
		if (truncatedResult != result) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		truncatedResult >>= getNumberFormat().getFractionLength();
		
		return createValue(resultDataType, truncatedResult);
	}
	
	@Override
	protected AbstractNumericValue basicDivide(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;

		long result;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger bigResult = BigInteger.valueOf(rawValue).shiftLeft(getNumberFormat().getFractionLength());
			if (bigResult.compareTo(LONG_MIN_VALUE) < 0 || bigResult.compareTo(LONG_MAX_VALUE) > 0) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
			result = bigResult.longValue();
		} else {
			result = rawValue << getNumberFormat().getFractionLength();
		}

		long truncatedResult = truncate(result, getIntermediateWordSize());
		if (truncatedResult != result) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		truncatedResult /= otherFixedPointValue.rawValue;
		
		return createValue(resultDataType, truncatedResult);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.AbstractNumericValue#basicModulo(org.eclipselabs.damos.mscript.interpreter.value.AbstractNumericValue, org.eclipselabs.damos.mscript.NumericType)
	 */
	@Override
	protected AbstractNumericValue basicModulo(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		long result = rawValue % otherFixedPointValue.rawValue;
		return new FixedPointValue(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicNegate(NumericType resultDataType) {
		return new FixedPointValue(getContext(), getDataType(), getNumberFormat(), -rawValue);
	}
	
	@Override
	protected AbstractNumericValue basicPower(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		long result;
		if (getNumberFormat().getWordSize() > 32) {
			result = FixMath.powfix64(rawValue, otherFixedPointValue.rawValue, getNumberFormat().getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.powfix32((int) rawValue, (int) otherFixedPointValue.rawValue, getNumberFormat().getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected IValue basicLessThan(AbstractNumericValue other, Type resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue < otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicLessThanOrEqualTo(AbstractNumericValue other, Type resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue <= otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicGreaterThan(AbstractNumericValue other, Type resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue > otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicGreaterThanOrEqualTo(AbstractNumericValue other, Type resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue >= otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicEqualTo(AbstractNumericValue other, Type resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue == otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicNotEqualTo(AbstractNumericValue other, Type resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue != otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue#round()
	 */
	public IValue round() {
		/*
		 *  TODO: This needs to be reworked
		 */
		
		IntegerType resultDataType = MscriptFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(getDataType().getUnit()));
		
		FixedPointValue value;

		int fractionLength = getNumberFormat().getFractionLength();
		if (fractionLength == 0) {
			value = this;
		} else {
			long resultRawValue = rawValue + (1L << fractionLength - 1); // + 0.5
			long truncatedResult = truncate(resultRawValue, getNumberFormat().getWordSize());
			if (truncatedResult != resultRawValue) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
			value = new FixedPointValue(getContext(), resultDataType, getNumberFormat(), truncatedResult >> fractionLength << fractionLength);
		}
		
		return value.cast(getContext().getComputationModel().getNumberFormat(resultDataType));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#exp()
	 */
	public IValue exp() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.expfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.expfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#ln()
	 */
	public IValue ln() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.lnfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.lnfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#lg()
	 */
	public IValue lg() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.lgfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.lgfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#lb()
	 */
	public IValue lb() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.lbfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.lbfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#sin()
	 */
	public IValue sin() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.sinfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.sinfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#cos()
	 */
	public IValue cos() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.cosfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.cosfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#tan()
	 */
	public IValue tan() {
		long result;

		FixedPointFormat numberFormat = getNumberFormat();
		if (numberFormat.getWordSize() > 32) {
			result = FixMath.tanfix64(rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		} else {
			result = FixMath.tanfix32((int) rawValue, numberFormat.getFractionLength(), getContext().getOverflowMonitor());
		}
		return new FixedPointValue(getContext(), getDataType(), numberFormat, result);
	}

	protected AbstractNumericValue cast(NumberFormat numberFormat) {
		if (getNumberFormat().isEquivalentTo(numberFormat)) {
			return this;
		}
		return doCast(getDataType(), numberFormat);
	}
	
	private AbstractNumericValue doCast(NumericType numericType, NumberFormat numberFormat) {
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				return castToBinary32(numericType, floatingPointFormat);
			case BINARY64:
				return castToBinary64(numericType, floatingPointFormat);
			default:
				break;
			}
		}
		
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return castToFixedPoint(numericType, fixedPointFormat);
		}

		return null;
	}

	private AbstractNumericValue castToBinary32(NumericType numericType, FloatingPointFormat floatingPointFormat) {
		float value = rawValue * (float) Math.pow(2, -getNumberFormat().getFractionLength());
		return new Binary32Value(getContext(), numericType, floatingPointFormat, value);
	}

	private AbstractNumericValue castToBinary64(NumericType numericType, FloatingPointFormat floatingPointFormat) {
		double value = rawValue * Math.pow(2, -getNumberFormat().getFractionLength());
		return new Binary64Value(getContext(), numericType, floatingPointFormat, value);
	}

	/**
	 * @param fixedPointFormat
	 * @return
	 */
	private AbstractNumericValue castToFixedPoint(NumericType numericType, FixedPointFormat fixedPointFormat) {
		long truncatedRawValue = truncate(rawValue, getIntermediateWordSize(fixedPointFormat));
		
		if (truncatedRawValue != rawValue) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		long shiftedRawValue;

		int shift = fixedPointFormat.getFractionLength() - getNumberFormat().getFractionLength();
		if (shift < 0) {
			shiftedRawValue = truncatedRawValue >> -shift;
		} else if (shift > 0) {
			shiftedRawValue = truncatedRawValue << shift;
		} else {
			shiftedRawValue = truncatedRawValue;
		}
		
		long truncatedShiftedRawValue = truncate(shiftedRawValue, getIntermediateWordSize(fixedPointFormat));

		if (truncatedShiftedRawValue != shiftedRawValue) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		long minValue = -(1L << fixedPointFormat.getWordSize() - 1);
		long maxValue = (1L << fixedPointFormat.getWordSize() - 1) - 1;
		
		long newRawValue;
		
		if (fixedPointFormat.isSaturate()) {
			if (truncatedShiftedRawValue < minValue) {
				newRawValue = minValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else if (truncatedShiftedRawValue > maxValue) {
				newRawValue = maxValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else {
				newRawValue = truncatedShiftedRawValue;
			}
		} else {
			newRawValue = truncate(truncatedShiftedRawValue, fixedPointFormat.getWordSize());
			if (newRawValue != truncatedShiftedRawValue) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
		}
		
		return new FixedPointValue(getContext(), numericType, fixedPointFormat, newRawValue);
	}

	private long truncate(long value, int wordSize) {
		int shift = Long.SIZE - wordSize;
		return value << shift >> shift;
	}
	
	private AbstractNumericValue createValue(NumericType dataType, BigInteger rawValue) {
		if (rawValue.compareTo(LONG_MIN_VALUE) < 0 || rawValue.compareTo(LONG_MAX_VALUE) > 0) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		return createValue(dataType, rawValue.longValue());
	}
	
	private AbstractNumericValue createValue(NumericType dataType, long rawValue) {
		long truncatedRawValue = truncate(rawValue, getIntermediateWordSize());
		
		if (truncatedRawValue != rawValue) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		long minValue = -(1L << getNumberFormat().getWordSize() - 1);
		long maxValue = (1L << getNumberFormat().getWordSize() - 1) - 1;
		
		long newRawValue;
		
		if (getNumberFormat().isSaturate()) {
			if (truncatedRawValue < minValue) {
				newRawValue = minValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else if (truncatedRawValue > maxValue) {
				newRawValue = maxValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else {
				newRawValue = truncatedRawValue;
			}
		} else {
			newRawValue = truncate(truncatedRawValue, getNumberFormat().getWordSize());
			if (newRawValue != truncatedRawValue) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
		}

		return new FixedPointValue(getContext(), dataType, getNumberFormat(), newRawValue);
	}

	/**
	 * @return
	 */
	private int getIntermediateWordSize() {
		return getIntermediateWordSize(getNumberFormat());
	}
	
	/**
	 * @param fixedPointFormat
	 * @return
	 */
	private int getIntermediateWordSize(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getFractionLength() != 0) {
			return 2 * fixedPointFormat.getWordSize();
		}
		return fixedPointFormat.getWordSize();
	}

	static void initializeValue(IComputationContext context, FixedPointValue fixedPointValue, double value) {
		FixedPointFormat fixedPointFormat = fixedPointValue.getNumberFormat();
		int wordSize = fixedPointFormat.getWordSize();
		
		double scalingFactor;
		if (fixedPointFormat.getFractionLength() > 0) {
			scalingFactor = Math.pow(2, fixedPointFormat.getFractionLength());
		} else {
			scalingFactor = 1.0;
		}
		
		double scaledValue = Math.round(value * scalingFactor);
		
		double minValue = -Math.pow(2, wordSize - 1);
		double maxValue = Math.pow(2, wordSize - 1) - 1;
		
		long rawValue;

		if (scaledValue < minValue) {
			context.getOverflowMonitor().handleOverflow(new OverflowInfo());
			rawValue = -(1L << wordSize - 1);
		} else if (scaledValue > maxValue) {
			context.getOverflowMonitor().handleOverflow(new OverflowInfo());
			rawValue = (1L << wordSize - 1) - 1;
		} else {
			rawValue = (long) scaledValue;
		}
		
		fixedPointValue.rawValue = rawValue;
	}
	
}

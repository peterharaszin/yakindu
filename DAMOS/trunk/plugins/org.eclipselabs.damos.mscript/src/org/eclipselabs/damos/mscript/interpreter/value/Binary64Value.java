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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;

/**
 * @author Andreas Unger
 *
 */
public class Binary64Value extends AbstractNumericValue implements ISimpleNumericValue {

	private static final double LOG_2 = Math.log(2);

	private final double value;
	
	public Binary64Value(IComputationContext context, NumericType dataType, FloatingPointFormat numberFormat, double value) {
		super(context, dataType, numberFormat);
		this.value = value;
	}
	
	public double doubleValue() {
		return value;
	}
	
	public long longValue() {
		return (long) value;
	}
	
	@Override
	protected FloatingPointFormat getNumberFormat() {
		return (FloatingPointFormat) super.getNumberFormat();
	}

	@Override
	protected IValue doConvert(Type type) {
		NumberFormat numberFormat = getContext().getComputationModel().getNumberFormat(type);
		if (getNumberFormat().isEquivalentTo(numberFormat)) {
			return new Binary64Value(getContext(), (NumericType) type, getNumberFormat(), value);
		}
		return doCast((NumericType) type, numberFormat);
	}
	
	@Override
	protected AbstractNumericValue basicAdd(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value + otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}

	@Override
	protected AbstractNumericValue basicSubtract(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value - otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicMultiply(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value * otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicDivide(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value / otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.AbstractNumericValue#basicModulo(org.eclipselabs.damos.mscript.interpreter.value.AbstractNumericValue, org.eclipselabs.damos.mscript.NumericType)
	 */
	@Override
	protected AbstractNumericValue basicModulo(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value % otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicNegate(NumericType resultDataType) {
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), -value);
	}
	
	@Override
	protected AbstractNumericValue basicPower(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), Math.pow(value, otherBinary64Value.value));
	}

	@Override
	protected IValue basicLessThan(AbstractNumericValue other, Type resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value < otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicLessThanOrEqualTo(AbstractNumericValue other, Type resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value <= otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicGreaterThan(AbstractNumericValue other, Type resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value > otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicGreaterThanOrEqualTo(AbstractNumericValue other, Type resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value >= otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicEqualTo(AbstractNumericValue other, Type resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value == otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicNotEqualTo(AbstractNumericValue other, Type resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value != otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.ISimpleNumericValue#round()
	 */
	public IValue round() {
		IntegerType resultDataType = MscriptFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(getDataType().getUnit()));
		
		NumberFormat numberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), Math.round(value)).cast(numberFormat);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#exp()
	 */
	public IValue exp() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.exp(value));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#ln()
	 */
	public IValue ln() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.log(value));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#lg()
	 */
	public IValue lg() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.log10(value));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#lb()
	 */
	public IValue lb() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.log(value) / LOG_2);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#sin()
	 */
	public IValue sin() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.sin(value));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#cos()
	 */
	public IValue cos() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.cos(value));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue#tan()
	 */
	public IValue tan() {
		return new Binary64Value(getContext(), getDataType(), getNumberFormat(), Math.tan(value));
	}
	
	protected AbstractNumericValue cast(NumberFormat numberFormat) {
		if (getNumberFormat().isEquivalentTo(numberFormat)) {
			return this;
		}
		return doCast(getDataType(), numberFormat);
	}

	protected AbstractNumericValue doCast(NumericType numericType, NumberFormat numberFormat) {
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				return new Binary32Value(getContext(), numericType, floatingPointFormat, (float) value);
			default:
				break;
			}
		}

		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue fixedPointValue = new FixedPointValue(getContext(), numericType, fixedPointFormat, 0);
			FixedPointValue.initializeValue(getContext(), fixedPointValue, value);
			return fixedPointValue;
		}
		
		return null;
	}

}

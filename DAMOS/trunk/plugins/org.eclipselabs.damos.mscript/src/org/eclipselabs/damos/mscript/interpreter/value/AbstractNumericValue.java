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
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractNumericValue extends AbstractExplicitDataTypeValue implements INumericValue {

	private NumberFormat numberFormat;
	
	public AbstractNumericValue(IComputationContext context, NumericType dataType, NumberFormat numberFormat) {
		super(context, dataType);
		this.numberFormat = numberFormat;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public NumericType getDataType() {
		return (NumericType) super.getDataType();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.INumericValue#convertUnit(org.eclipselabs.mscript.typesystem.Unit)
	 */
	public INumericValue convertUnit(Unit unit) {
		NumericType numericType = EcoreUtil.copy(getDataType());
		numericType.setUnit(unit);
		return (INumericValue) doConvert(numericType);
	}

	protected NumberFormat getNumberFormat() {
		return numberFormat;
	}
	
	protected IValue doAdd(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicAdd(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicAdd(AbstractNumericValue other, NumericType resultDataType);
	
	protected IValue doSubtract(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicSubtract(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicSubtract(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doMultiply(IValue other, Type resultDataType) {
		if (other.getDataType() instanceof ArrayType) {
			return other.multiply(this);
		}
		
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicMultiply(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicMultiply(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doDivide(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicDivide(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicDivide(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doModulo(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicModulo(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicModulo(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doNegate(Type resultDataType) {
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue operand = cast(resultNumberFormat);
		
		return operand.basicNegate((NumericType) resultDataType);
	}
	
	protected abstract AbstractNumericValue basicNegate(NumericType resultDataType);
	
	@Override
	public IValue power(IValue other) {
		if (!(other.getDataType() instanceof NumericType)) {
			return InvalidValue.SINGLETON;
		}

		NumericType operandType = (NumericType) getDataType();
		NumericType exponentType = (NumericType) other.getDataType();
		
		boolean constantIntegerExponent = exponentType instanceof IntegerType && other instanceof ISimpleNumericValue;

		Unit dimensionlessUnit = TypeUtil.createUnit();
		
		if (!dimensionlessUnit.isEquivalentTo(operandType.getUnit(), true) && !constantIntegerExponent) {
			return InvalidValue.SINGLETON;
		}
		
		if (!dimensionlessUnit.isEquivalentTo(exponentType.getUnit(), true)) {
			return InvalidValue.SINGLETON;
		}

		Type resultDataType;
		if (constantIntegerExponent) {
			resultDataType = operandType.evaluate(OperatorKind.POWER, (int) ((ISimpleNumericValue) other).longValue());
		} else {
			RealType realType = MscriptFactory.eINSTANCE.createRealType();
			realType.setUnit(EcoreUtil.copy(operandType.getUnit()));
			resultDataType = realType;
		}

		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicPower(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicPower(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doLessThan(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicLessThan(rightOperand, resultDataType);
	}

	protected abstract IValue basicLessThan(AbstractNumericValue other, Type resultDataType);

	protected IValue doLessThanOrEqualTo(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicLessThanOrEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicLessThanOrEqualTo(AbstractNumericValue other, Type resultDataType);

	protected IValue doGreaterThan(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicGreaterThan(rightOperand, resultDataType);
	}

	protected abstract IValue basicGreaterThan(AbstractNumericValue other, Type resultDataType);

	protected IValue doGreaterThanOrEqualTo(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicGreaterThanOrEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicGreaterThanOrEqualTo(AbstractNumericValue other, Type resultDataType);

	protected IValue doEqualTo(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicEqualTo(AbstractNumericValue other, Type resultDataType);

	protected IValue doNotEqualTo(IValue other, Type resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicNotEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicNotEqualTo(AbstractNumericValue other, Type resultDataType);

	protected abstract AbstractNumericValue cast(NumberFormat numberFormat);

	/**
	 * @param other
	 * @return
	 */
	private NumberFormat getWidestNumberFormat(IValue other) {
		Type dataType1 = TypeUtil.getLeftHandDataType(getDataType(), other.getDataType());
		Type dataType2 = TypeUtil.getLeftHandDataType(other.getDataType(), getDataType());
		
		NumberFormat numberFormat1 = getContext().getComputationModel().getNumberFormat(dataType1);
		NumberFormat numberFormat2 = getContext().getComputationModel().getNumberFormat(dataType2);
	
		return ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);
	}
	
}

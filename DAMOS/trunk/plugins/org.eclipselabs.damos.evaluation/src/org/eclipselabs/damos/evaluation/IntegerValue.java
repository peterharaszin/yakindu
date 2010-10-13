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

package org.eclipselabs.damos.evaluation;

import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;

/**
 * @author Andreas Unger
 *
 */
public class IntegerValue extends AbstractValue implements INumericValue {

	private long value;
	
	/**
	 * @param dataType
	 */
	public IntegerValue(DataType dataType, long value) {
		super(dataType);
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.INumericalValue#doubleValue()
	 */
	public double doubleValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#add(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue add(IValue other) {
		DataType dataType = getDataType().evaluate(OperatorKind.ADD, other.getDataType());
		if (!(dataType instanceof InvalidDataType)) {
			if (other instanceof IntegerValue) {
				return new IntegerValue(dataType, value + ((IntegerValue) other).value);
			} else if (other instanceof RealValue) {
				return new RealValue(dataType, value + ((RealValue) other).doubleValue());
			}
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#subtract(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue subtract(IValue other) {
		DataType dataType = getDataType().evaluate(OperatorKind.SUBTRACT, other.getDataType());
		if (!(dataType instanceof InvalidDataType)) {
			if (other instanceof IntegerValue) {
				return new IntegerValue(dataType, value - ((IntegerValue) other).value);
			} else if (other instanceof RealValue) {
				return new RealValue(dataType, value - ((RealValue) other).doubleValue());
			}
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#multiply(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue multiply(IValue other) {
		DataType dataType = getDataType().evaluate(OperatorKind.MULTIPLY, other.getDataType());
		if (!(dataType instanceof InvalidDataType)) {
			if (other instanceof IntegerValue) {
				return new IntegerValue(dataType, value * ((IntegerValue) other).value);
			} else if (other instanceof RealValue) {
				return new RealValue(dataType, value * ((RealValue) other).doubleValue());
			}
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#divide(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue divide(IValue other) {
		if (other instanceof INumericValue) {
			DataType dataType = getDataType().evaluate(OperatorKind.DIVIDE, other.getDataType());
			if (!(dataType instanceof InvalidDataType)) {
				return new RealValue(dataType, value / ((INumericValue) other).doubleValue());
			}
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#elementWiseMultiply(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue elementWiseMultiply(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#elementWiseDivide(org.eclipselabs.damos.evaluation.IValue)
	 */
	public IValue elementWiseDivide(IValue other) {
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IValue#unaryMinus()
	 */
	public IValue unaryMinus() {
		DataType dataType = getDataType().evaluate(OperatorKind.UNARY_MINUS, null);
		if (!(dataType instanceof InvalidDataType)) {
			return new IntegerValue(dataType, -value);
		}
		return InvalidValue.SINGLETON;
	}
	
}

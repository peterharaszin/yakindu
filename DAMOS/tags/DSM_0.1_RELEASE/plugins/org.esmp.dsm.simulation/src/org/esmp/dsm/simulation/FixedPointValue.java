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

package org.esmp.dsm.simulation;

import java.math.BigInteger;

import org.esmp.dsm.common.math.BigIntegerUtil;
import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.expressions.FixedPointDataType;
import org.esmp.dsm.expressions.util.FixedPointDataTypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class FixedPointValue implements Value {

	private FixedPointDataType type;
	private BigInteger value;

	private FixedPointValue(SimulationModel simulationModel, FixedPointDataType type, BigInteger value) {
		this.type = type;
		this.value = truncate(simulationModel, value);
	}
		
	/**
	 * @return the value
	 */
	public BigInteger getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#doubleValue()
	 */
	public double toDouble() {
		return value.shiftRight(type.getFractionLength()).doubleValue() + BigIntegerUtil.clearBits(value, type.getFractionLength(), -1).doubleValue() / type.scalingFactor().doubleValue();
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.execution.datatype.Value#cast(org.esmp.dsm.execution.datatype.DataType)
	 */
	public Value cast(SimulationModel simulationModel, DataType dataType) {
		if (dataType.equals(type)) {
			return this;
		}
		if (dataType instanceof FixedPointDataType) {
			FixedPointDataType targetType = (FixedPointDataType) dataType;
			return new FixedPointValue(simulationModel, targetType, value.shiftLeft(targetType.getFractionLength() - type.getFractionLength()));
		}
		return ValueFactory.INSTANCE.newValue(simulationModel, dataType, toDouble());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Double.toString(toDouble());
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#add(org.esmp.dsm.common.math.Value)
	 */
	public FixedPointValue add(SimulationModel simulationModel, Value value) {
		BigInteger otherValue = ((FixedPointValue) value.cast(simulationModel, type)).value;
		return new FixedPointValue(simulationModel, type, this.value.add(otherValue));
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#subtract(org.esmp.dsm.common.math.Value)
	 */
	public FixedPointValue subtract(SimulationModel simulationModel, Value value) {
		BigInteger otherValue = ((FixedPointValue) value.cast(simulationModel, type)).value;
		return new FixedPointValue(simulationModel, type, this.value.subtract(otherValue));
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#multiply(org.esmp.dsm.common.math.Value)
	 */
	public FixedPointValue multiply(SimulationModel simulationModel, Value value) {
		BigInteger otherValue = ((FixedPointValue) value.cast(simulationModel, type)).value;
		return new FixedPointValue(simulationModel, type, truncate(simulationModel, this.value.multiply(otherValue)).shiftRight(type.getFractionLength()));
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#divide(org.esmp.dsm.common.math.Value)
	 */
	public FixedPointValue divide(SimulationModel simulationModel, Value value) {
		BigInteger otherValue = ((FixedPointValue) value.cast(simulationModel, type)).value;
		return new FixedPointValue(simulationModel, type, truncate(simulationModel, this.value.shiftLeft(type.getFractionLength())).divide(otherValue));
	}

	private BigInteger truncate(SimulationModel simulationModel, BigInteger value) {
		return truncate(simulationModel, value, type);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Value value) {
		assert value instanceof FixedPointValue;
		FixedPointValue otherValue = (FixedPointValue) value;
		assert type.equals(otherValue.type);
		return this.value.compareTo(otherValue.value);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}
		if (obj instanceof FixedPointValue) {
			FixedPointValue other = (FixedPointValue) obj;
			return other.value == value && other.type.equals(type);
		}
		return false;
	}
	
	public static FixedPointValue valueOf(SimulationModel simulationModel, FixedPointDataType type, long longValue) {
		BigInteger value = BigInteger.valueOf(longValue).shiftLeft(type.getFractionLength());
		return new FixedPointValue(simulationModel, type, value);
	}

	public static FixedPointValue valueOf(SimulationModel simulationModel, FixedPointDataType type, double doubleValue) {
		return new FixedPointValue(simulationModel, type, FixedPointDataTypeUtil.toFixedPoint(doubleValue, type));
	}
	
	public static FixedPointValue valueOf(SimulationModel simulationModel, FixedPointDataType type, String s) throws NumberFormatException {
		return valueOf(simulationModel, type, Double.parseDouble(s));
	}

	private static BigInteger truncate(SimulationModel simulationModel, BigInteger value, FixedPointDataType type) {		
		if (value.compareTo(type.minValue()) < 0 || value.compareTo(type.maxValue()) > 0) {
			simulationModel.getContext().getOverflowMonitor().overflowOccurred(new OverflowEvent());
		}
		if (type.isSigned() && value.testBit(type.getWordLength() - 1)) {
			value = BigIntegerUtil.setBits(value, type.getWordLength(), -1);
		} else {
			value = BigIntegerUtil.clearBits(value, type.getWordLength(), -1);
		}
		return value;
	}

}

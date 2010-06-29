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

import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.expressions.DoubleDataType;

/**
 * @author Andreas Unger
 *
 */
public class DoubleValue implements Value {

	private double value;
	
	/**
	 * 
	 */
	private DoubleValue(double value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#doubleValue()
	 */
	public double toDouble() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.execution.datatype.Value#cast(org.esmp.dsm.execution.datatype.DataType)
	 */
	public Value cast(SimulationModel simulationModel, DataType dataType) {
		return dataType instanceof DoubleDataType ? this : ValueFactory.INSTANCE.newValue(simulationModel, dataType, value);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Double.toString(value);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#add(org.esmp.dsm.common.math.Value)
	 */
	public DoubleValue add(SimulationModel simulationModel, Value value) {
		return new DoubleValue(this.value + value.toDouble());
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#subtract(org.esmp.dsm.common.math.Value)
	 */
	public DoubleValue subtract(SimulationModel simulationModel, Value value) {
		return new DoubleValue(this.value - value.toDouble());
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#multiply(org.esmp.dsm.common.math.Value)
	 */
	public DoubleValue multiply(SimulationModel simulationModel, Value value) {
		return new DoubleValue(this.value * value.toDouble());
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#divide(org.esmp.dsm.common.math.Value)
	 */
	public DoubleValue divide(SimulationModel simulationModel, Value value) {
		return new DoubleValue(this.value / value.toDouble());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Value value) {
		assert value instanceof DoubleValue;
		DoubleValue otherValue = (DoubleValue) value;
		return Double.compare(this.value, otherValue.value);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}
		return obj instanceof DoubleValue && ((DoubleValue) obj).value == value;
	}
	
	public static DoubleValue valueOf(double value) {
		return new DoubleValue(value);
	}

}

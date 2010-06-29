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

import org.esmp.dsm.expressions.BooleanDataType;
import org.esmp.dsm.expressions.DataType;

/**
 * @author Andreas Unger
 *
 */
public class BooleanValue implements Value {

	private boolean value;
	
	/**
	 * 
	 */
	private BooleanValue(boolean value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#doubleValue()
	 */
	public double toDouble() {
		return value ? 1 : 0;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.execution.datatype.Value#cast(org.esmp.dsm.execution.datatype.DataType)
	 */
	public Value cast(SimulationModel simulationModel, DataType dataType) {
		return dataType instanceof BooleanDataType ? this : ValueFactory.INSTANCE.newValue(simulationModel, dataType, value);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Boolean.toString(value);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#add(org.esmp.dsm.common.math.Value)
	 */
	public BooleanValue add(SimulationModel simulationModel, Value value) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#subtract(org.esmp.dsm.common.math.Value)
	 */
	public BooleanValue subtract(SimulationModel simulationModel, Value value) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#multiply(org.esmp.dsm.common.math.Value)
	 */
	public BooleanValue multiply(SimulationModel simulationModel, Value value) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.common.math.Value#divide(org.esmp.dsm.common.math.Value)
	 */
	public BooleanValue divide(SimulationModel simulationModel, Value value) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Value value) {
		assert value instanceof BooleanValue;
		BooleanValue otherValue = (BooleanValue) value;
		return (this.value ? 1 : 0) - (otherValue.value ? 1 : 0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			return true;
		}
		return obj instanceof BooleanValue && ((BooleanValue) obj).value == value;
	}
	
	public static BooleanValue valueOf(boolean value) {
		return new BooleanValue(value);
	}

}

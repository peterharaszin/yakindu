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

package org.esmp.dsm.simulation.internal;

import org.esmp.dsm.expressions.BooleanDataType;
import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.expressions.DoubleDataType;
import org.esmp.dsm.expressions.FixedPointDataType;
import org.esmp.dsm.simulation.BooleanValue;
import org.esmp.dsm.simulation.DoubleValue;
import org.esmp.dsm.simulation.FixedPointValue;
import org.esmp.dsm.simulation.SimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

/**
 * @author Andreas Unger
 *
 */
public class ValueFactoryImpl implements ValueFactory {

	public Value newValue(SimulationModel simulationModel, DataType dataType, boolean value) {
		if (dataType instanceof BooleanDataType) {
			return BooleanValue.valueOf(value);
		}
		if (dataType instanceof DoubleDataType) {
			return DoubleValue.valueOf(value ? 1 : 0);
		}
		if (dataType instanceof FixedPointDataType) {
			return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, value ? 1 : 0);
		}
		throw new IllegalArgumentException();
	}

	public Value newValue(SimulationModel simulationModel, DataType dataType, int value) {
		if (dataType instanceof BooleanDataType) {
			return BooleanValue.valueOf(value != 0);
		}
		if (dataType instanceof DoubleDataType) {
			return DoubleValue.valueOf(value);
		}
		if (dataType instanceof FixedPointDataType) {
			return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, value);
		}
		throw new IllegalArgumentException();
	}

	public Value newValue(SimulationModel simulationModel, DataType dataType, long value) {
		if (dataType instanceof BooleanDataType) {
			return BooleanValue.valueOf(value != 0);
		}
		if (dataType instanceof DoubleDataType) {
			return DoubleValue.valueOf(value);
		}
		if (dataType instanceof FixedPointDataType) {
			return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, value);
		}
		throw new IllegalArgumentException();
	}

	public Value newValue(SimulationModel simulationModel, DataType dataType, double value) {
		if (dataType instanceof BooleanDataType) {
			return BooleanValue.valueOf(value != 0);
		}
		if (dataType instanceof DoubleDataType) {
			return DoubleValue.valueOf(value);
		}
		if (dataType instanceof FixedPointDataType) {
			return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, value);
		}
		throw new IllegalArgumentException();
	}

	public Value newValue(SimulationModel simulationModel, DataType dataType, String value) {
		if (dataType instanceof BooleanDataType) {
			return BooleanValue.valueOf(Double.parseDouble(value) != 0);
		}
		if (dataType instanceof DoubleDataType) {
			return DoubleValue.valueOf(Double.parseDouble(value));
		}
		if (dataType instanceof FixedPointDataType) {
			return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, Double.parseDouble(value));
		}
		throw new IllegalArgumentException();
	}

	public Value newValue(SimulationModel simulationModel, DataType dataType, String value, int defaultValue) {
		if (dataType instanceof BooleanDataType) {
			try {
				return BooleanValue.valueOf(Double.parseDouble(value) != 0);
			} catch (NumberFormatException e) {
				return BooleanValue.valueOf(defaultValue != 0);
			}
		}
		if (dataType instanceof DoubleDataType) {
			try {
				return DoubleValue.valueOf(Double.parseDouble(value));
			} catch (NumberFormatException e) {
				return DoubleValue.valueOf(defaultValue);
			}
		}
		if (dataType instanceof FixedPointDataType) {
			try {
				return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, Double.parseDouble(value));
			} catch (NumberFormatException e) {
				return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, defaultValue);
			}
		}
		throw new IllegalArgumentException();
	}

	public Value newValue(SimulationModel simulationModel, DataType dataType, String value, long defaultValue) {
		if (dataType instanceof BooleanDataType) {
			try {
				return BooleanValue.valueOf(Double.parseDouble(value) != 0);
			} catch (NumberFormatException e) {
				return BooleanValue.valueOf(defaultValue != 0);
			}
		}
		if (dataType instanceof DoubleDataType) {
			try {
				return DoubleValue.valueOf(Double.parseDouble(value));
			} catch (NumberFormatException e) {
				return DoubleValue.valueOf(defaultValue);
			}
		}
		if (dataType instanceof FixedPointDataType) {
			try {
				return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, Double.parseDouble(value));
			} catch (NumberFormatException e) {
				return FixedPointValue.valueOf(simulationModel, (FixedPointDataType) dataType, defaultValue);
			}
		}
		throw new IllegalArgumentException();
	}

}

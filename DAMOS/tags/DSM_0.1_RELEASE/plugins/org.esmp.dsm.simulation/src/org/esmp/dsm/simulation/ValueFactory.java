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
import org.esmp.dsm.simulation.internal.ValueFactoryImpl;

/**
 * @author Andreas Unger
 *
 */
public interface ValueFactory {
	
	ValueFactory INSTANCE = new ValueFactoryImpl();
	
	Value newValue(SimulationModel simulationModel, DataType dataType, boolean value);
	Value newValue(SimulationModel simulationModel, DataType dataType, int value);
	Value newValue(SimulationModel simulationModel, DataType dataType, long value);
	Value newValue(SimulationModel simulationModel, DataType dataType, double value);
	Value newValue(SimulationModel simulationModel, DataType dataType, String s);
	Value newValue(SimulationModel simulationModel, DataType dataType, String s, int defaultValue);
	Value newValue(SimulationModel simulationModel, DataType dataType, String s, long defaultValue);

}

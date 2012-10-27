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

package org.eclipse.damos.simulation.simulator.internal.simulationobjects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.AbstractSimulationObject;
import org.eclipse.damos.simulation.simulator.internal.SimulatorPlugin;

/**
 * @author Andreas Unger
 *
 */
public class MemorySimulationObject extends AbstractSimulationObject {

	private IValue value;
	private IValue nextValue;
	private IValue outputValue;
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		if (inputIndex == 0) {
			this.value = value; 
		} else {
			this.nextValue = value;
		}
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		if (value == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "Missing input value for component '" + getComponent().getName() + "'"));
		}
		outputValue = value;
	}
	
	@Override
	public void update(double t) {
		value = nextValue;
	}
	
}

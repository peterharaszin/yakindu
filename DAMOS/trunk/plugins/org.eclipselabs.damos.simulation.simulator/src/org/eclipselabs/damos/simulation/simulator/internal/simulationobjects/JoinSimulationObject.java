/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.simulator.internal.simulationobjects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;

/**
 * @author Andreas Unger
 *
 */
public class JoinSimulationObject extends AbstractSimulationObject {

	private IValue outputValue;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		outputValue = value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues(double, org.eclipselabs.damos.simulation.ISimulationMonitor)
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		if (outputValue == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "No Join input available"));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getOutputValue(int, int)
	 */
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
}

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

package org.eclipselabs.damos.simulation.engine.internal.simulationobjects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.simulation.engine.AbstractComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;
import org.eclipselabs.mscript.computation.engine.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class MemorySimulationObject extends AbstractComponentSimulationObject {

	private IValue value;
	private IValue nextValue;
	private IValue outputValue;
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) throws CoreException {
		if (inputIndex == 0) {
			this.value = value; 
		} else {
			this.nextValue = value;
		}
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) throws CoreException {
		if (outputValue == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Missing input value for component '" + getComponent().getName() + "'"));
		}
		return outputValue;
	}
	
	@Override
	public void computeOutputValues(double t) throws CoreException {
		outputValue = value;
	}
	
	@Override
	public void update() throws CoreException {
		value = nextValue;
	}
	
}

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

package org.eclipse.damos.library.base.simulation;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.Input;
import org.eclipse.emf.common.util.EList;

/**
 * @author Andreas Unger
 *
 */
public class XYScopeSimulationObject extends AbstractScopeSimulationObject {

	private double xValue;
	private double[] yValues;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		EList<Input> inputs = getComponent().getInputs();
		if (inputs.size() < 2) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Invalid X-Y scope"));
		}
		yValues = new double[inputs.get(1).getPorts().size()];
		super.initialize(monitor);
	}
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, double value) {
		if (inputIndex == 0) {
			xValue = value;
		} else {
			yValues[portIndex] = value;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getXValue(double)
	 */
	@Override
	protected double getXValue(double t) {
		return xValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getYValueCount()
	 */
	@Override
	protected int getYValueCount() {
		return yValues.length;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getYValue(double, int)
	 */
	@Override
	protected double getYValue(double t, int index) {
		return yValues[index];
	}
	
}

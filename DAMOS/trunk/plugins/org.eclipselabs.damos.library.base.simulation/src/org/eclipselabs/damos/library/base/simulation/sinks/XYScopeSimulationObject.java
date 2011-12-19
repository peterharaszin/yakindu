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

package org.eclipselabs.damos.library.base.simulation.sinks;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.library.base.simulation.LibraryBaseSimulationPlugin;

/**
 * @author Andreas Unger
 *
 */
public class XYScopeSimulationObject extends AbstractScopeSimulationObject {

	private double xValue;
	private double[] yValues;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		super.initialize(monitor);
		EList<Input> inputs = getComponent().getInputs();
		if (inputs.size() < 2) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Invalid X-Y scope"));
		}
		int portCount = inputs.get(1).getPorts().size();
		yValues = new double[portCount];
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
	 * @see org.eclipselabs.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getXValue(double)
	 */
	@Override
	protected double getXValue(double t) {
		return xValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getYValue(double, int)
	 */
	@Override
	protected double getYValue(double t, int index) {
		return yValues[index];
	}
	
}

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

package org.eclipse.damos.library.base.simulation.sinks;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Andreas Unger
 *
 */
public class ScopeSimulationObject extends AbstractScopeSimulationObject {

	private double[] inputValues;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		inputValues = new double[getComponent().getPrimaryInputPorts().size()];
		super.initialize(monitor);
	}
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, double value) {
		inputValues[portIndex] = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getXValue(double)
	 */
	@Override
	protected double getXValue(double t) {
		return t;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getYValueCount()
	 */
	@Override
	protected int getYValueCount() {
		return inputValues.length;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.library.base.simulation.sinks.AbstractScopeSimulationObject#getYValue(double, int)
	 */
	@Override
	protected double getYValue(double t, int index) {
		return inputValues[index];
	}
	
}

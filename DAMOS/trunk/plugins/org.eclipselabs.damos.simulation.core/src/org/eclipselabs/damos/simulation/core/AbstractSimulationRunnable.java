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

package org.eclipselabs.damos.simulation.core;

import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractSimulationRunnable implements ISimulationRunnable {

	private ISimulation simulation;
	
	private Component component;

	/**
	 * 
	 */
	public AbstractSimulationRunnable(ISimulation simulation, Component component) {
		this.simulation = simulation;
		this.component = component;
	}
	
	/**
	 * @return the simulation
	 */
	protected ISimulation getSimulation() {
		return simulation;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.core.ISimulationRunnable#getComponent()
	 */
	public Component getComponent() {
		return component;
	}

}

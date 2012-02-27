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

package org.eclipselabs.damos.simulation.simulator.internal;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.mscript.interpreter.IOverflowMonitor;
import org.eclipselabs.damos.mscript.interpreter.OverflowInfo;
import org.eclipselabs.damos.simulation.ISimulation;
import org.eclipselabs.damos.simulation.SimulationEvent;
import org.eclipselabs.damos.simulation.SimulationManager;

/**
 * @author Andreas Unger
 *
 */
public class ComponentOverflowMonitor implements IOverflowMonitor {

	private ISimulation simulation;
	private Component component;
	
	/**
	 * 
	 */
	public ComponentOverflowMonitor(ISimulation simulation, Component component) {
		this.simulation = simulation;
		this.component = component;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.IOverflowMonitor#handleOverflow(org.eclipselabs.mscript.computation.core.OverflowInfo)
	 */
	public void handleOverflow(OverflowInfo info) {
		SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(component, simulation, SimulationEvent.OVERFLOW));
	}

}

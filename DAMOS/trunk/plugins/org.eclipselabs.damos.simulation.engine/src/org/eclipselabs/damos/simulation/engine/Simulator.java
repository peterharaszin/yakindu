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

package org.eclipselabs.damos.simulation.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.simulation.engine.internal.registry.SimulationListenerRegistry;

/**
 * @author Andreas Unger
 *
 */
public class Simulator implements ISimulator {

	private ISimulationEngine simulationEngine = new SimulationEngine();
	
	private ISimulationListener simulationListener = new ISimulationListener() {
		
		public void handleSimulationEvent(SimulationEvent event) {
			for (ISimulationListener listener : SimulationListenerRegistry.getInstance().getListeners()) {
				listener.handleSimulationEvent(event);
			}
		}
		
	};
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulator#simulate(org.eclipselabs.damos.simulation.engine.ISimulationContext, org.eclipselabs.damos.simulation.engine.ISimulationMonitor)
	 */
	public void simulate(ISimulationContext context, ISimulationMonitor monitor) throws CoreException {
		monitor.addSimulationListener(simulationListener);
		simulationEngine.run(context, monitor);
		monitor.removeSimulationListener(simulationListener);
	}
	
}

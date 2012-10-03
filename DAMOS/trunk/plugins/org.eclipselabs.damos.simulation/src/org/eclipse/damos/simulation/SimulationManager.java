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

package org.eclipse.damos.simulation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.damos.simulation.internal.registry.SimulationListenerRegistry;

/**
 * @author Andreas Unger
 *
 */
public class SimulationManager {
	
	private static final SimulationManager INSTANCE = new SimulationManager();
	
	private final List<ISimulationListener> simulationListeners = new ArrayList<ISimulationListener>();
	
	private final List<ISimulation> runningSimulations = new ArrayList<ISimulation>();
	
	private SimulationManager() {
		// hide constructor
	}
	
	/**
	 * @return the instance
	 */
	public static SimulationManager getInstance() {
		return INSTANCE;
	}
	
	/**
	 * @return the runningSimulations
	 */
	public Collection<ISimulation> getRunningSimulations() {
		synchronized (runningSimulations) {
			return new ArrayList<ISimulation>(runningSimulations);
		}
	}
	
	public void addSimulationListener(ISimulationListener l) {
		synchronized (simulationListeners) {
			if (!simulationListeners.contains(l)) {
				simulationListeners.add(l);
			}
		}
	}

	public void removeSimulationListener(ISimulationListener l) {
		synchronized (simulationListeners) {
			simulationListeners.remove(l);
		}
	}
	
	public void fireSimulationEvent(SimulationEvent event) {
		synchronized (event.getSimulation()) {
			switch (event.getKind()) {
			case SimulationEvent.START:
				synchronized (runningSimulations) {
					runningSimulations.add(event.getSimulation());
				}
				break;
			case SimulationEvent.FINISH:
			case SimulationEvent.CANCEL:
				synchronized (runningSimulations) {
					runningSimulations.remove(event.getSimulation());
				}
				break;
			}
			
			ISimulationListener[] ls;
			synchronized (simulationListeners) {
				ls = simulationListeners.toArray(new ISimulationListener[simulationListeners.size()]);
			}
			for (ISimulationListener l : SimulationListenerRegistry.getInstance().getListeners()) {
				l.handleSimulationEvent(event);
			}		
			for (ISimulationListener l : ls) {
				l.handleSimulationEvent(event);
			}
		}
	}

}

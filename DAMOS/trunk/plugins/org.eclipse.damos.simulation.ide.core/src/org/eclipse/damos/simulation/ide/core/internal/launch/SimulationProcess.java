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

package org.eclipse.damos.simulation.ide.core.internal.launch;

import org.eclipse.damos.simulation.ISimulationListener;
import org.eclipse.damos.simulation.SimulationEvent;
import org.eclipse.damos.simulation.SimulationManager;
import org.eclipse.damos.simulation.simulator.ISimulationEngine;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

/**
 * @author Andreas Unger
 *
 */
public class SimulationProcess implements IProcess {

	private final ILaunch launch;
	private final String name;
	
	private ISimulationEngine simulationEngine;

	private SimulationThread simulationThread;
	private volatile boolean terminated;
	
	private final ISimulationListener simulationListener = new ISimulationListener() {
		
		public void handleSimulationEvent(SimulationEvent event) {
			if (event.getSimulation() == simulationEngine.getSimulation() && event.isDone()) {
				doTerminate();
			}
		}
		
	};

	/**
	 * 
	 */
	public SimulationProcess(ILaunch launch, String name) {
		this.launch = launch;
		this.name = name;
		
		launch.addProcess(this);
		fireCreationEvent();
	}

	public ILaunch getLaunch() {
		return launch;
	}
	
	public String getLabel() {
		return name;
	}

	/**
	 * @return the simulationJob
	 */
	public SimulationThread getSimulationJob() {
		return simulationThread;
	}
	
	public void run(ISimulationEngine simulationEngine) {
		this.simulationEngine = simulationEngine;
		simulationThread = new SimulationThread(simulationEngine);
		SimulationManager.getInstance().addSimulationListener(simulationListener);
		simulationThread.start();
	}
	
	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		if (!isTerminated()) {
			simulationEngine.getSimulation().getMonitor().setCanceled(true);
			doTerminate();
		}
	}

	private void doTerminate() {
		SimulationManager.getInstance().removeSimulationListener(simulationListener);
		simulationThread = null;
		simulationEngine = null;
		terminated = true;
		fireTerminateEvent();
	}

	public String getAttribute(String key) {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	/**
	 * Fires a creation event.
	 */
	protected void fireCreationEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
	}

	/**
	 * Fires a terminate event.
	 */
	protected void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	/**
	 * Fires the given debug event.
	 * 
	 * @param event debug event to fire
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin manager = DebugPlugin.getDefault();
		if (manager != null) {
			manager.fireDebugEventSet(new DebugEvent[] { event });
		}
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		return null;
	}
	
}

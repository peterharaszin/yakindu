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

package org.eclipselabs.damos.simulation.ide.core.internal.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.simulation.engine.ISimulationMonitor;
import org.eclipselabs.damos.simulation.engine.SimulationEngine;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public class SimulationThread extends Thread {
	
	private SimulationModel simulationModel;
	private ExecutionGraph executionGraph;
	private ISimulationMonitor simulationMonitor;
		
	private SimulationEngine simulationEngine = new SimulationEngine();

	/**
	 * 
	 */
	public SimulationThread(SimulationModel simulationModel, ExecutionGraph executionGraph, ISimulationMonitor monitor) {
		super("Simulating block diagram");
		this.simulationModel = simulationModel;
		this.executionGraph = executionGraph;
		this.simulationMonitor = monitor;
	}
	
	/**
	 * @return the executionGraph
	 */
	public ExecutionGraph getExecutionGraph() {
		return executionGraph;
	}
	
	/**
	 * @return the monitor
	 */
	public ISimulationMonitor getSimulationMonitor() {
		return simulationMonitor;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			simulationEngine.simulate(simulationModel, executionGraph, simulationMonitor);
		} catch (CoreException e) {
			SimulationEnginePlugin.getDefault().getLog().log(e.getStatus());
		}
	}
	
}

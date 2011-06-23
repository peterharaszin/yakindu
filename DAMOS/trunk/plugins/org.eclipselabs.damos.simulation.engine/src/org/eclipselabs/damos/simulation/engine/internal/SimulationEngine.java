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

package org.eclipselabs.damos.simulation.engine.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.simulation.core.ISimulation;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.core.SimulationEvent;
import org.eclipselabs.damos.simulation.core.SimulationManager;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.ISimulationClock;
import org.eclipselabs.damos.simulation.engine.ISimulationEngine;
import org.eclipselabs.damos.simulation.engine.solver.ISolver;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;

public class SimulationEngine implements ISimulationEngine {

	private Simulation simulation;
	private ISimulationClock clock;
	private ISolver solver;
	
	private IStatus status = Status.OK_STATUS;
	
	/**
	 * 
	 */
	public SimulationEngine(Simulation simulation, ISimulationClock clock, ISolver solver) {
		this.simulation = simulation;
		this.clock = clock;
		this.solver = solver;
	}
	
	public ISimulation getSimulation() {
		return simulation;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulationEngine#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		ISimulationContext context = simulation.getContext();
		Graph graph = context.getExecutionFlow().getGraph();

		double simulationTime;
		if (context.getSimulationModel().isSetSimulationTime()) {
			simulationTime = context.getSimulationModel().getSimulationTime();
		} else {
			simulationTime = -1;
		}
		
		ISimulationMonitor monitor = simulation.getMonitor();
		
		int simulationEventKind = SimulationEvent.CANCEL;
		try {
			double nextTime = 0;
			clock.start(monitor);
			
			SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, SimulationEvent.START));
			while (!monitor.isCanceled()) {
				SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, SimulationEvent.BEFORE_STEP, nextTime));
				solver.computeStep(monitor);
				SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, SimulationEvent.AFTER_STEP, nextTime));

				nextTime = solver.getTime();
				if (simulationTime > 0 && nextTime > simulationTime) {
					break;
				}
				
				if (simulationTime == -1) {
					long nextTimeNanos = (long) (nextTime * 1e9);
					long currentTime = clock.getNanoTime();
					if (nextTimeNanos > currentTime) {
						long d = nextTimeNanos - currentTime;
						try {
							Thread.sleep(d / 1000000, (int) (d % 1000000));
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					}
				}
			}

			if (!monitor.isCanceled()) {
				simulationEventKind = SimulationEvent.FINISH;
			}
		} catch (CoreException e) {
			status = new Status(e.getStatus().getSeverity(), SimulationEnginePlugin.PLUGIN_ID, "Simulation failed", e);
		} finally {
			SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, simulationEventKind));
			dispose(graph);
		}
	}

	private void dispose(Graph graph) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(componentNode);
				if (simulationObject != null) {
					simulationObject.dispose();
				}
			} else if (node instanceof Graph) {
				dispose((Graph) node); 
			}
		}
	}

}
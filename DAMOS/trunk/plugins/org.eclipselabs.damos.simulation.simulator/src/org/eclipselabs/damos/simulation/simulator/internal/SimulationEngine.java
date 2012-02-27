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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.TaskGraph;
import org.eclipselabs.damos.simulation.ISimulation;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.SimulationEvent;
import org.eclipselabs.damos.simulation.SimulationManager;
import org.eclipselabs.damos.simulation.simulator.ISimulationClock;
import org.eclipselabs.damos.simulation.simulator.ISimulationEngine;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.solver.ISolver;
import org.eclipselabs.damos.simulation.simulator.util.SimulationUtil;
import org.eclipselabs.damos.simulation.util.SimulationConfigurationUtil;

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
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationEngine#getStatus()
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

		double simulationTime = SimulationConfigurationUtil.getSimulationTime(context.getSimulationModel());
		ISimulationMonitor monitor = simulation.getMonitor();
		
		int simulationEventKind = SimulationEvent.CANCEL;
		try {
			double nextTime = 0;
			
			SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, SimulationEvent.START));
			
			// Start tasks
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				Task task = (Task) EcoreUtil.getAdapter(taskGraph.eAdapters(), Task.class);
				if (task != null) {
					task.start();
				}
			}
			
			clock.start(monitor);

			while (!monitor.isCanceled()) {
				for (Runnable runnable : simulation.takeRunnables()) {
					runnable.run();
				}
				
				solver.computeStep(monitor);
				SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, SimulationEvent.STEP, nextTime));

				nextTime = solver.getTime();
				if (simulationTime > 0 && nextTime > simulationTime) {
					break;
				}
				
				if (simulationTime == -1) {
					long nextTimeNanos = (long) (nextTime * 1e9);
					long currentTime;
					while (nextTimeNanos > (currentTime = clock.getNanoTime())) {
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
			status = new Status(e.getStatus().getSeverity(), SimulatorPlugin.PLUGIN_ID, "Simulation failed", e);
		} finally {
			simulation.takeRunnables();
			
			// Stop tasks
			for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
				Task task = (Task) EcoreUtil.getAdapter(taskGraph.eAdapters(), Task.class);
				if (task != null) {
					task.interrupt();
				}
			}
			dispose(graph);

			SimulationManager.getInstance().fireSimulationEvent(new SimulationEvent(this, simulation, simulationEventKind));
		}
	}

	static void dispose(Graph graph) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				ISimulationObject simulationObject = SimulationUtil.getSimulationObject(componentNode);
				if (simulationObject != null) {
					simulationObject.dispose();
				}
			} else if (node instanceof Graph) {
				dispose((Graph) node); 
			}
		}
	}

}
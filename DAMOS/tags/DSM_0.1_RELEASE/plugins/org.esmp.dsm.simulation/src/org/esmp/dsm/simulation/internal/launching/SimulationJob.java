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

package org.esmp.dsm.simulation.internal.launching;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.simulation.DSMSimulationPlugin;
import org.esmp.dsm.simulation.SimulationContext;
import org.esmp.dsm.simulation.SimulationException;
import org.esmp.dsm.simulation.SimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.internal.services.SimulationListenerService;
import org.esmp.dsm.simulation.internal.util.SimulationUtil;

/**
 * @author Andreas Unger
 *
 */
public class SimulationJob extends Job {
	
	private static final long PROGRESS_FACTOR = 100;

	private ExecutionGraph executionGraph;
	private SimulationContext context;

	private ISchedulingRule acquireRule = new ISchedulingRule() {

		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}

		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}
		
	};
	
	private IJobChangeListener listener = new JobChangeAdapter() {
		
		public void done(IJobChangeEvent event) {
			if (event.getResult().isOK()) {
				SimulationListenerService.getInstance().fireSimulationEvent(new SimulationEvent(
						this,
						executionGraph,
						context));
			}
		}
		
	};

	/**
	 * 
	 */
	public SimulationJob(ExecutionGraph executionGraph, SimulationContext context) {
		super("Simulating block diagram");
		this.executionGraph = executionGraph;
		this.context = context;
		setRule(acquireRule);
		addJobChangeListener(listener);
	}
	
	/**
	 * @return the executionGraph
	 */
	public ExecutionGraph getExecutionGraph() {
		return executionGraph;
	}
	
	/**
	 * @return the context
	 */
	public SimulationContext getSimulationContext() {
		return context;
	}
	
	protected IStatus run(IProgressMonitor monitor) {
		long sampleCount = context.getSampleCount();
		
		monitor.beginTask("Running main simulation loop", (int) (sampleCount / PROGRESS_FACTOR));
		
		try {
			for (ExecutionNode node : executionGraph.getNodes()) {
				SimulationModel simulationModel = SimulationUtil.getSimulationModel(node.getBlock());
				simulationModel.initialize();
			}
			long n;
			for (n = 0; n < sampleCount; ++n) {
				for (ExecutionNode node : executionGraph.getNodes()) {
					SimulationModel simulationModel = SimulationUtil.getSimulationModel(node.getBlock());
					simulationModel.computeOutputValues();
					for (OutputPort outputPort : node.getBlock().getOutputPorts()) {
						Value value = simulationModel.getOutputValue(outputPort);
						for (Connection connection : outputPort.getOutgoingConnections()) {
							InputPort inputPort = connection.getTargetPort();
							SimulationModel targetSimulationModel = SimulationUtil.getSimulationModel(inputPort.getBlock());
							targetSimulationModel.consumeInputValue(inputPort, value);
						}
					}
				}
				for (ExecutionNode node : executionGraph.getNodes()) {
					SimulationModel simulationModel = SimulationUtil.getSimulationModel(node.getBlock());
					simulationModel.update();
				}
				if (n > 0 && n % PROGRESS_FACTOR == 0) {
					monitor.worked(1);
				}
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
			}
		} catch (SimulationException e) {
			return new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID, e.getMessage());
		}
		return Status.OK_STATUS;
	}

}

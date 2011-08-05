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

package org.eclipselabs.damos.simulation.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.core.DataTypeResolver;
import org.eclipselabs.damos.execution.core.DataTypeResolverResult;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.execution.executionflow.construct.ExecutionFlowBuilder;
import org.eclipselabs.damos.simulation.core.ISimulation;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulator.internal.ComponentOverflowMonitor;
import org.eclipselabs.damos.simulation.simulator.internal.DefaultSimulationClock;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.Simulation;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEngine;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationObjectContext;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverDescriptor;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverRegistry;
import org.eclipselabs.damos.simulation.simulator.solver.ISolver;
import org.eclipselabs.damos.simulation.simulator.util.SimulationUtil;

/**
 * @author Andreas Unger
 *
 */
public class Simulator {
	
	private final ExecutionFlowBuilder executionFlowBuilder = new ExecutionFlowBuilder();
	
	private final SimulationObjectAdaptor simulationObjectAdaptor = new SimulationObjectAdaptor();

	private final DataTypeResolver dataTypeResolver = new DataTypeResolver();
	
	private SimulationEngine simulationEngine;
	
	public void initialize(SimulationModel simulationModel, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Initializing simulator", 5);
		
		ExecutionFlow executionFlow = executionFlowBuilder.build(simulationModel.getTopLevelFragment(), subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}

		ISimulationContext context = new SimulationContext(simulationModel, executionFlow);
		Simulation simulation = new Simulation(context);

		simulationObjectAdaptor.adaptSimulationObjects(context, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}

		ISolverDescriptor solverDescriptor = ISolverRegistry.INSTANCE.getSolver(simulationModel.getSolverId());
		if (solverDescriptor == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "Solver '" + simulationModel.getSolverId() + "' not found"));
		}
		
		Graph graph = executionFlow.getGraph();
		
		ISolver solver = solverDescriptor.createSolver();
		
		Map<Component, IComponentSignature> signatures = resolveDataTypes(context);
		initialize(simulation, graph, signatures, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}
		
		solver.initialize(context, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}
		
		List<ISimulationClock> clocks = new ArrayList<ISimulationClock>();
		getClocks(graph, clocks);
		
		ISimulationClock clock;
		if (clocks.isEmpty()) {
			clock = new DefaultSimulationClock();
		} else {
			clock = clocks.get(0);
		}
		
		if (subMonitor.isCanceled()) {
			return;
		}
		subMonitor.worked(1);

		simulationEngine = new SimulationEngine(simulation, clock, solver);
	}
	
	/**
	 * @param context
	 * @return
	 * @throws CoreException
	 */
	private Map<Component, IComponentSignature> resolveDataTypes(ISimulationContext context) throws CoreException {
		DataTypeResolverResult dataTypeResolverResult = dataTypeResolver.resolve(context.getExecutionFlow().getTopLevelFragment(), true);
		if (!dataTypeResolverResult.getStatus().isOK()) {
			throw new CoreException(dataTypeResolverResult.getStatus());
		}
		return dataTypeResolverResult.getSignatures();
	}

	private void initialize(ISimulation simulation, Graph graph, Map<Component, IComponentSignature> signatures, IProgressMonitor monitor) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (monitor.isCanceled()) {
				break;
			}
			
			if (node instanceof Graph) {
				initialize(simulation, (Graph) node, signatures, monitor);
			} else if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				ISimulationObject simulationObject = SimulationUtil.getSimulationObject(node);
				if (simulationObject != null) {
					IComponentSignature signature = signatures.get(componentNode.getComponent());
					simulationObject.initialize(new SimulationObjectContext(componentNode, signature, simulation.getModel(), new ComponentOverflowMonitor(simulation, componentNode.getComponent())), monitor);
				}
			}
		}
	}

	/**
	 * @param graph
	 * @param clockedComponentNodes
	 */
	private void getClocks(Graph graph, List<ISimulationClock> simulationClocks) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				ISimulationObject simulationObject = SimulationUtil.getSimulationObject(componentNode);
				if (simulationObject != null && simulationObject.getClock() != null) {
					simulationClocks.add(simulationObject.getClock());
				}
			} else if (node instanceof Graph) {
				getClocks((Graph) node, simulationClocks); 
			}
		}
	}

	/**
	 * @return
	 */
	public ISimulationEngine getSimulationEngine() {
		return simulationEngine;
	}
	
}

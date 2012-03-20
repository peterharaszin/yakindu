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
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.execution.datatype.DataTypeResolver;
import org.eclipselabs.damos.execution.datatype.DataTypeResolverResult;
import org.eclipselabs.damos.execution.datatype.IComponentSignature;
import org.eclipselabs.damos.execution.transform.ExecutionFlowBuilder;
import org.eclipselabs.damos.simulation.ISimulation;
import org.eclipselabs.damos.simulation.simulator.internal.ComponentOverflowMonitor;
import org.eclipselabs.damos.simulation.simulator.internal.DefaultSimulationClock;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.Simulation;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEngine;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationObjectContext;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;
import org.eclipselabs.damos.simulation.simulator.internal.Task;
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
	
	public void initialize(Configuration configuration, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Initializing simulator", 5);
		
		Fragment contextFragment = configuration.getContextFragment();
		if (contextFragment == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "No root system specification found in configuration"));
		}
		
		ExecutionFlow executionFlow = executionFlowBuilder.build(contextFragment, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}

		ISimulationContext context = new SimulationContext(configuration, executionFlow);
		Simulation simulation = new Simulation(context);

		simulationObjectAdaptor.adaptSimulationObjects(context, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}
		
		for (TaskGraph taskGraph : executionFlow.getTaskGraphs()) {
			taskGraph.eAdapters().add(new Task(simulation, taskGraph));
		}

		String solverQualifiedName = configuration.getPropertySelectionName("damos.simulation.solver");
		if (solverQualifiedName == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "No solver specification found in configuration"));
		}
		ISolverDescriptor solverDescriptor = ISolverRegistry.INSTANCE.getSolver(solverQualifiedName);
		if (solverDescriptor == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, "Solver '" + solverQualifiedName + "' not found"));
		}
		
		ISolver solver = solverDescriptor.createSolver();
		
		Map<Component, IComponentSignature> signatures = resolveDataTypes(context);
		initialize(simulation, executionFlow, signatures, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}
		
		solver.initialize(context, subMonitor.newChild(1));
		if (subMonitor.isCanceled()) {
			return;
		}
		
		Graph graph = executionFlow.getGraph();
		
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

	private void initialize(ISimulation simulation, ExecutionFlow executionFlow, Map<Component, IComponentSignature> signatures, IProgressMonitor monitor) throws CoreException {
		for (TaskGraph taskGraph : executionFlow.getTaskGraphs()) {
			initialize(simulation, taskGraph, signatures, monitor);
		}
		initialize(simulation, executionFlow.getGraph(), signatures, monitor);
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
					simulationObject.initialize(new SimulationObjectContext(componentNode, signature, simulation.getConfiguration(), new ComponentOverflowMonitor(simulation, componentNode.getComponent())), monitor);
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

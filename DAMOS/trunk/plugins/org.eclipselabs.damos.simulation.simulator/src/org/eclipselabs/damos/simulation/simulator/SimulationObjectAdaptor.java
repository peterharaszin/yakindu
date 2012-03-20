/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.ExecutionFlow;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.TaskGraph;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationObjectAdapter;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationObjectStatus;
import org.eclipselabs.damos.simulation.simulator.internal.registry.SimulationObjectProviderRegistry;

/**
 * @author Andreas Unger
 *
 */
public class SimulationObjectAdaptor {

	public void adaptSimulationObjects(ISimulationContext context, IProgressMonitor progressMonitor) throws CoreException {
		List<Component> missingSimulationObjectComponents = new ArrayList<Component>();
		
		ExecutionFlow executionFlow = context.getExecutionFlow();
		for (TaskGraph taskGraph : executionFlow.getTaskGraphs()) {
			adaptSimulationObjects(context, taskGraph, missingSimulationObjectComponents);
		}
		adaptSimulationObjects(context, executionFlow.getGraph(), missingSimulationObjectComponents);
		
		if (!missingSimulationObjectComponents.isEmpty()) {
			StringBuilder sb = new StringBuilder("Missing simulation object for ");
			boolean first = true;
			for (Component component : missingSimulationObjectComponents) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append("'");
				sb.append(component.getName());
				sb.append("'");
			}
			throw new CoreException(new SimulationObjectStatus(
					IStatus.ERROR, SimulatorPlugin.PLUGIN_ID, 0, sb.toString(), null, missingSimulationObjectComponents));
		}
	}

	/**
	 * @param context
	 * @param signatures
	 * @param overflowMonitor
	 * @param missingSimulationObjectComponents
	 */
	private void adaptSimulationObjects(ISimulationContext context, Graph graph, List<Component> missingSimulationObjectComponents) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				Component component = componentNode.getComponent();
				if (!(component instanceof Choice)) {
					ISimulationObject simulationObject;
					simulationObject = SimulationObjectProviderRegistry.getInstance().createSimulationObject(component);
					if (simulationObject != null) {
						node.eAdapters().add(new SimulationObjectAdapter(simulationObject));
					} else {
						missingSimulationObjectComponents.add(component);
					}
				}
			} else if (node instanceof CompoundNode) {
				adaptSimulationObjects(context, (CompoundNode) node, missingSimulationObjectComponents);
			}
		}
	}
	
}

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

package org.eclipselabs.damos.simulation.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.CompoundNode;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.simulation.engine.internal.ComponentSimulationObjectAdapter;
import org.eclipselabs.damos.simulation.engine.internal.ComponentSimulationObjectStatus;
import org.eclipselabs.damos.simulation.engine.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.engine.internal.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.engine.internal.registry.ComponentSimulationObjectProviderRegistry;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSimulationObjectAdaptor {

	public void adaptSimulationObjects(ISimulationContext context, IProgressMonitor progressMonitor) throws CoreException {
		List<Component> missingSimulationObjectComponents = new ArrayList<Component>();
		
		adaptSimulationObjects(context, context.getExecutionFlow().getGraph(), missingSimulationObjectComponents);
		
		if (!missingSimulationObjectComponents.isEmpty()) {
			StringBuilder sb = new StringBuilder("Missing component simulation object for ");
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
			throw new CoreException(new ComponentSimulationObjectStatus(
					IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, 0, sb.toString(), null, missingSimulationObjectComponents));
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
				if (!(component instanceof Choice || component instanceof Join)) {
					IComponentSimulationObject simulationObject;
					simulationObject = ComponentSimulationObjectProviderRegistry.getInstance().createSimulationObject(component);
					if (simulationObject != null) {
						node.eAdapters().add(new ComponentSimulationObjectAdapter(simulationObject));
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

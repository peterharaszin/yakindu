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

package org.eclipse.damos.simulation.simulator.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.damos.simulation.ISimulation;
import org.eclipse.damos.simulation.ISimulationAgent;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.ISimulationRunnable;
import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.damos.simulation.simulator.util.SimulationUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class Simulation implements ISimulation {

	private volatile Map<URI, ComponentNode> cachedNodes;
	
	private volatile Map<URI, ISimulationAgent> cachedAgents;

	private final ISimulationContext context;

	private final ISimulationMonitor monitor;
	
	private final List<ISimulationRunnable> runnables = new ArrayList<ISimulationRunnable>();
	
	/**
	 * 
	 */
	public Simulation(ISimulationContext context) {
		this.context = context;
		this.monitor = new SimulationMonitor();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulation#getMonitor()
	 */
	public ISimulationMonitor getMonitor() {
		return monitor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.ISimulation#getModel()
	 */
	public Configuration getConfiguration() {
		return context.getSimulationModel();
	}
	
	/**
	 * @return the context
	 */
	public ISimulationContext getContext() {
		return context;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.ISimulation#getAgent(org.eclipse.emf.common.util.URI)
	 */
	public ISimulationAgent getAgent(Component component) {
		URI componentURI = EcoreUtil.getURI(component);
		cache();
		return cachedAgents.get(componentURI);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.ISimulation#getAgents()
	 */
	public Collection<ISimulationAgent> getAgents() {
		cache();
		return Collections.unmodifiableCollection(cachedAgents.values());
	}
	
	/**
	 * @return the runnables
	 */
	public List<ISimulationRunnable> takeRunnables() {
		synchronized (this) {
			List<ISimulationRunnable> runnablesCopy = new ArrayList<ISimulationRunnable>(runnables);
			runnables.clear();
			return runnablesCopy;
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulation#execute(java.lang.Runnable)
	 */
	public void execute(ISimulationRunnable runnable) {
		cache();
		Task task = getTaskFor(runnable);
		if (task != null) {
			task.execute(runnable);
		} else {
			synchronized (this) {
				runnables.add(runnable);
			}
		}
	}

	/**
	 * @param runnable
	 * @return
	 */
	private Task getTaskFor(ISimulationRunnable runnable) {
		if (runnable.getComponent() != null) {
			URI componentURI = EcoreUtil.getURI(runnable.getComponent());
			ComponentNode componentNode = cachedNodes.get(componentURI);
			if (componentNode != null && componentNode.getGraph() instanceof TaskGraph) {
				TaskGraph taskGraph = (TaskGraph) componentNode.getGraph();
				return (Task) EcoreUtil.getAdapter(taskGraph.eAdapters(), Task.class);
			}
		}
		return null;
	}
	
	/**
	 * 
	 */
	private void cache() {
		if (cachedNodes == null) {
			synchronized (this) {
				if (cachedNodes == null) {
					cachedNodes = new HashMap<URI, ComponentNode>();
					cachedAgents = new HashMap<URI, ISimulationAgent>();
					for (TaskGraph taskGraph : context.getExecutionFlow().getTaskGraphs()) {
						cache(taskGraph);
					}
					cache(context.getExecutionFlow().getGraph());
				}
			}
		}
	}
	
	private void cache(Graph graph) {
		for (Node node : graph.getNodes()) {
			if (node instanceof ComponentNode) {
				ComponentNode componentNode = (ComponentNode) node;
				ISimulationObject  simulationObject = SimulationUtil.getSimulationObject(node);
				if (simulationObject != null) {
					ISimulationAgent agent = simulationObject.getAgent();
					if (agent != null) {
						URI uri = EcoreUtil.getURI(componentNode.getComponent());
						if (!cachedNodes.containsKey(uri)) {
							cachedNodes.put(uri, componentNode);
						}
						if (!cachedAgents.containsKey(uri)) {
							cachedAgents.put(uri, agent);
						}
					}
				}
			} else if (node instanceof Graph) {
				cache((Graph) node);
			}
		}
	}

}

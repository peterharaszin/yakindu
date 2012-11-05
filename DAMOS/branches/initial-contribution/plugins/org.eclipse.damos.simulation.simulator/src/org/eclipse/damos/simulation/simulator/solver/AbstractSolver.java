/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.simulation.simulator.solver;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.damos.simulation.simulator.internal.DiscreteStateComputationHelper;
import org.eclipse.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipse.damos.simulation.simulator.util.SimulationUtil;

/**
 * Base class managing common boilerplate for all solvers.
 */
public abstract class AbstractSolver implements ISolver {
	
	private final DiscreteStateComputationHelper discreteStateComputationHelper = new DiscreteStateComputationHelper() {
		
		protected boolean canExecute(ComponentNode componentNode, double t) {
			return AbstractSolver.this.canExecute(componentNode, t);
		}
		
	};
	
	protected ISimulationContext context;

	/**
	 * @param graph
	 * @param monitor
	 * @throws CoreException
	 */
	protected void computeDiscreteStates(Graph graph, double t, ISimulationMonitor monitor) throws CoreException {
		discreteStateComputationHelper.computeDiscreteStates(graph, t, monitor);
	}

	protected abstract void configure(Configuration configuration);
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.solver.ISolver#initialize(org.eclipse.damos.simulation.simulator.internal.ISimulationContext, org.eclipse.damos.simulation.ISimulationMonitor)
	 */
	public void initialize(ISimulationContext context, IProgressMonitor monitor) throws CoreException {
		this.context = context;
		configure(context.getSimulationModel());
		initializeIntegrationData(context.getExecutionFlow().getGraph(), monitor);
	}

	private void initializeIntegrationData(Graph graph, IProgressMonitor monitor) throws CoreException {
		for (Node node : graph.getNodes()) {
			if (monitor.isCanceled()) {
				break;
			}
			
			if (node instanceof Graph) {
				initializeIntegrationData((Graph) node, monitor);
			} else if (node instanceof ComponentNode) {
				ISimulationObject simulationObject = SimulationUtil.getSimulationObject(node);
				if (simulationObject != null) {
					double[] stateVector = simulationObject.getStateVector();
					if (stateVector != null && stateVector.length > 0) {
						node.eAdapters().add(createIntegrationData(simulationObject));
					}
				}
			}
		}
	}
	
	protected abstract IIntegrationData createIntegrationData(ISimulationObject simulationObject);

	protected final void propagateComponentOutputValues(ComponentNode node, ISimulationObject simulationObject)
			throws CoreException {
		discreteStateComputationHelper.propagateComponentOutputValues(node, simulationObject);
	}

	protected boolean canExecute(ComponentNode componentNode, double t) {
		return true;
	}

}

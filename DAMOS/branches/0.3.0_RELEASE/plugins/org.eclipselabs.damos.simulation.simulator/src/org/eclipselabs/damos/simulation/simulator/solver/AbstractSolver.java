/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.eclipselabs.damos.simulation.simulator.solver;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.DiscreteStateComputationHelper;
import org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext;
import org.eclipselabs.damos.simulation.simulator.util.SimulationUtil;

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
	 * @see org.eclipselabs.damos.simulation.simulator.solver.ISolver#initialize(org.eclipselabs.damos.simulation.simulator.internal.ISimulationContext, org.eclipselabs.damos.simulation.ISimulationMonitor)
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

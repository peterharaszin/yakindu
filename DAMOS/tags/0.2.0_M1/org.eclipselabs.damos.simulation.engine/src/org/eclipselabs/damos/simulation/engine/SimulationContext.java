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

import org.eclipselabs.damos.execution.executiongraph.ExecutionGraph;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public class SimulationContext implements ISimulationContext {
	
	private SimulationModel simulationModel;
	private ExecutionGraph executionGraph;

	/**
	 * 
	 */
	public SimulationContext(SimulationModel simulationModel, ExecutionGraph executionGraph) {
		this.simulationModel = simulationModel;
		this.executionGraph = executionGraph;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationContext#getSimulationModel()
	 */
	public SimulationModel getSimulationModel() {
		return simulationModel;
	}

	/**
	 * @return the executionGraph
	 */
	public ExecutionGraph getExecutionGraph() {
		return executionGraph;
	}
	
}

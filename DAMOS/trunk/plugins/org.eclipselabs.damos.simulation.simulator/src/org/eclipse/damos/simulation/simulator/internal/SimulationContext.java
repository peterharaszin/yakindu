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

package org.eclipse.damos.simulation.simulator.internal;

import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ExecutionFlow;

/**
 * @author Andreas Unger
 *
 */
public class SimulationContext implements ISimulationContext {
	
	private Configuration configuration;
	private ExecutionFlow executionFlow;

	/**
	 * 
	 */
	public SimulationContext(Configuration configuration, ExecutionFlow executionFlow) {
		this.configuration = configuration;
		this.executionFlow = executionFlow;
	}
	
	public Configuration getSimulationModel() {
		return configuration;
	}

	/**
	 * @return the executionFlow
	 */
	public ExecutionFlow getExecutionFlow() {
		return executionFlow;
	}
	
}

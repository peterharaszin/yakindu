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

import java.util.EventObject;

import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.simulation.SimulationContext;

/**
 * @author Andreas Unger
 *
 */
public class SimulationEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ExecutionGraph executionGraph;
	private SimulationContext context;

	/**
	 * @param source
	 */
	public SimulationEvent(Object source, ExecutionGraph executionGraph, SimulationContext context) {
		super(source);
		this.executionGraph = executionGraph;
		this.context = context;
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
	public SimulationContext getContext() {
		return context;
	}

}

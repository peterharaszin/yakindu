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

package org.eclipselabs.damos.simulation.simulator.internal;

import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectContext;
import org.eclipselabs.mscript.computation.core.IOverflowMonitor;

/**
 * @author Andreas Unger
 *
 */
public class SimulationObjectContext implements ISimulationObjectContext {

	private ComponentNode node;
	private IComponentSignature componentSignature;
	private SimulationModel simulationModel;
	private IOverflowMonitor overflowMonitor;
	
	/**
	 * @param component
	 * @param componentSignature
	 */
	public SimulationObjectContext(ComponentNode node, IComponentSignature componentSignature, SimulationModel simulationModel, IOverflowMonitor overflowMonitor) {
		this.node = node;
		this.componentSignature = componentSignature;
		this.simulationModel = simulationModel;
		this.overflowMonitor = overflowMonitor;
	}
	
	/**
	 * @return the node
	 */
	public ComponentNode getNode() {
		return node;
	}
	
	/**
	 * @return the componentSignature
	 */
	public IComponentSignature getComponentSignature() {
		return componentSignature;
	}
	
	/**
	 * @return the simulationModel
	 */
	public SimulationModel getSimulationModel() {
		return simulationModel;
	}
	
	/**
	 * @return the overflowMonitor
	 */
	public IOverflowMonitor getOverflowMonitor() {
		return overflowMonitor;
	}

}

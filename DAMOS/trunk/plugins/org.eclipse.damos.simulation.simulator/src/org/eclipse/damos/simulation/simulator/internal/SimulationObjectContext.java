/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
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
import org.eclipse.damos.execution.ComponentNode;
import org.eclipse.damos.execution.datatype.IComponentSignature;
import org.eclipse.damos.mscript.interpreter.IOverflowMonitor;
import org.eclipse.damos.simulation.simulator.ISimulationObjectContext;

/**
 * @author Andreas Unger
 *
 */
public class SimulationObjectContext implements ISimulationObjectContext {

	private ComponentNode node;
	private IComponentSignature componentSignature;
	private Configuration configuration;
	private IOverflowMonitor overflowMonitor;
	
	/**
	 * @param component
	 * @param componentSignature
	 */
	public SimulationObjectContext(ComponentNode node, IComponentSignature componentSignature, Configuration configuration, IOverflowMonitor overflowMonitor) {
		this.node = node;
		this.componentSignature = componentSignature;
		this.configuration = configuration;
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
	 * @return the configuration
	 */
	public Configuration getConfiguration() {
		return configuration;
	}
	
	/**
	 * @return the overflowMonitor
	 */
	public IOverflowMonitor getOverflowMonitor() {
		return overflowMonitor;
	}

}

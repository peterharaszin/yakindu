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

package org.eclipselabs.damos.simulation.engine;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.ComponentExecutionInfo;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.mscript.computation.engine.IOverflowMonitor;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSimulationInfo extends ComponentExecutionInfo implements IComponentSimulationInfo {

	private SimulationModel simulationModel;
	private IOverflowMonitor overflowMonitor;
	
	/**
	 * @param component
	 * @param componentSignature
	 */
	public ComponentSimulationInfo(Component component, IComponentSignature componentSignature, SimulationModel simulationModel, IOverflowMonitor overflowMonitor) {
		super(component, componentSignature);
		this.simulationModel = simulationModel;
		this.overflowMonitor = overflowMonitor;
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

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

package org.eclipselabs.damos.simulation.engine.internal;

import org.eclipselabs.damos.simulation.engine.ISimulationContext;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;

/**
 * @author Andreas Unger
 *
 */
public class SimulationContext implements ISimulationContext {
	
	private SimulationModel simulationModel;

	/**
	 * 
	 */
	public SimulationContext(SimulationModel simulationModel) {
		this.simulationModel = simulationModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationContext#getSimulationModel()
	 */
	public SimulationModel getSimulationModel() {
		return simulationModel;
	}
	
	/**
	 * @param simulationModel the simulationModel to set
	 */
	public void setSimulationModel(SimulationModel simulationModel) {
		this.simulationModel = simulationModel;
	}
	
}

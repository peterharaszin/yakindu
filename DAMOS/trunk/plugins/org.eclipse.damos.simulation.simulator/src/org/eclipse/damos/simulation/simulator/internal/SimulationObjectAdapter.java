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

import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author Andreas Unger
 *
 */
public class SimulationObjectAdapter extends AdapterImpl {

	private ISimulationObject simulationObject;
	
	/**
	 * 
	 */
	public SimulationObjectAdapter(ISimulationObject simulationObject) {
		this.simulationObject = simulationObject;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == SimulationObjectAdapter.class;
	}
	
	/**
	 * @return the simulationObject
	 */
	public ISimulationObject getSimulationObject() {
		return simulationObject;
	}
	
	/**
	 * @param simulationObject the simulationObject to set
	 */
	public void setSimulationObject(ISimulationObject simulationObject) {
		this.simulationObject = simulationObject;
	}
	
}

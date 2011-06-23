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

package org.eclipselabs.damos.simulation.simulator.internal;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipselabs.damos.simulation.simulator.IComponentSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSimulationObjectAdapter extends AdapterImpl {

	private IComponentSimulationObject simulationObject;
	
	/**
	 * 
	 */
	public ComponentSimulationObjectAdapter(IComponentSimulationObject simulationObject) {
		this.simulationObject = simulationObject;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ComponentSimulationObjectAdapter.class;
	}
	
	/**
	 * @return the simulationObject
	 */
	public IComponentSimulationObject getSimulationObject() {
		return simulationObject;
	}
	
	/**
	 * @param simulationObject the simulationObject to set
	 */
	public void setSimulationObject(IComponentSimulationObject simulationObject) {
		this.simulationObject = simulationObject;
	}
	
}

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

package org.esmp.dsm.simulation;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author Andreas Unger
 *
 */
public class SimulationAdapter extends AdapterImpl {

	private SimulationModel simulationModel;
	
	/**
	 * 
	 */
	public SimulationAdapter(SimulationModel simulationModel) {
		this.simulationModel = simulationModel;
	}
	
	/**
	 * @return the simulationModel
	 */
	public SimulationModel getSimulationModel() {
		return simulationModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return type == SimulationAdapter.class;
	}

}

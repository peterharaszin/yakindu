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

package org.eclipse.damos.simulation.simulator.solver;

import org.eclipse.damos.simulation.simulator.ISimulationObject;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author  Andreas Unger
 */
public abstract class AbstractIntegrationData extends AdapterImpl implements IIntegrationData {

	public ISimulationObject simulationObject;
	
	/**
	 * 
	 */
	public AbstractIntegrationData(ISimulationObject simulationObject) {
		this.simulationObject = simulationObject;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == IIntegrationData.class;
	}
	
}
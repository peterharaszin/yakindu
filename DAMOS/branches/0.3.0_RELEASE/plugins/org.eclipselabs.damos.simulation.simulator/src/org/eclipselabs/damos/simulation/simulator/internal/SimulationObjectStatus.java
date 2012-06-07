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

import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectStatus;

/**
 * @author Andreas Unger
 *
 */
public class SimulationObjectStatus extends Status implements ISimulationObjectStatus {

	private List<Component> affectedComponents;
	
	/**
	 * 
	 */
	public SimulationObjectStatus(int severity, String pluginId, int code, String message, Throwable exception, List<Component> affectedComponents) {
		super(severity, pluginId, code, message, exception);
		this.affectedComponents = affectedComponents;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationObjectStatus#getAffectedComponents()
	 */
	public List<Component> getAffectedComponents() {
		return affectedComponents;
	}

}

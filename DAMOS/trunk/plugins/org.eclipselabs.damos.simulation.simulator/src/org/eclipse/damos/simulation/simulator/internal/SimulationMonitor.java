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

import org.eclipse.damos.simulation.ISimulationMonitor;

/**
 * @author Andreas Unger
 *
 */
public class SimulationMonitor implements ISimulationMonitor {

	private volatile boolean canceled;
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulationMonitor#isCanceled()
	 */
	public boolean isCanceled() {
		return canceled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.ISimulationMonitor#setCanceled(boolean)
	 */
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
}

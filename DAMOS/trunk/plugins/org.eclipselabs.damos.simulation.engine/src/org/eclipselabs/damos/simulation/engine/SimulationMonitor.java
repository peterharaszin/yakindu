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

package org.eclipselabs.damos.simulation.engine;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andreas Unger
 *
 */
public class SimulationMonitor implements ISimulationMonitor {

	private volatile boolean canceled;
	
	private List<ISimulationListener> listeners = new ArrayList<ISimulationListener>();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#isCanceled()
	 */
	public boolean isCanceled() {
		return canceled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#setCanceled(boolean)
	 */
	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#addSimulationListener(org.eclipselabs.damos.simulation.ISimulationListener)
	 */
	public void addSimulationListener(ISimulationListener l) {
		synchronized (listeners) {
			if (!listeners.contains(l)) {
				listeners.add(l);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#removeSimulationListener(org.eclipselabs.damos.simulation.ISimulationListener)
	 */
	public void removeSimulationListener(ISimulationListener l) {
		synchronized (listeners) {
			listeners.remove(l);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.ISimulationMonitor#fireSimulationListener(org.eclipselabs.damos.simulation.SimulationEvent)
	 */
	public void fireSimulationEvent(SimulationEvent event) {
		ISimulationListener[] ls;
		synchronized (listeners) {
			ls = listeners.toArray(new ISimulationListener[listeners.size()]);
		}
		for (ISimulationListener l : ls) {
			l.handleSimulationEvent(event);
		}
	}
	
}

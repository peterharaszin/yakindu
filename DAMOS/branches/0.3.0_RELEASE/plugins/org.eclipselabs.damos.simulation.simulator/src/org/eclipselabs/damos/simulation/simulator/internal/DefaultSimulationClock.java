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

package org.eclipselabs.damos.simulation.simulator.internal;

import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.ISimulationClock;

/**
 * @author Andreas Unger
 *
 */
public class DefaultSimulationClock implements ISimulationClock {

	private long nanoTimeOffset;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationClock#start()
	 */
	public void start(ISimulationMonitor monitor) {
		nanoTimeOffset = System.nanoTime();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.ISimulationClock#getTime()
	 */
	public long getNanoTime() {
		return System.nanoTime() - nanoTimeOffset;
	}

}

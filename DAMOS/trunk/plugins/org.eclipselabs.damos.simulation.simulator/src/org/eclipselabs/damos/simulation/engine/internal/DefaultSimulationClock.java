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

package org.eclipselabs.damos.simulation.engine.internal;

import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.engine.ISimulationClock;

/**
 * @author Andreas Unger
 *
 */
public class DefaultSimulationClock implements ISimulationClock {

	private long nanoTimeOffset;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulationClock#start()
	 */
	public void start(ISimulationMonitor monitor) {
		nanoTimeOffset = System.nanoTime();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulationClock#getTime()
	 */
	public long getNanoTime() {
		return System.nanoTime() - nanoTimeOffset;
	}

}

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

package org.esmp.dsm.simulation.internal;

import org.esmp.dsm.simulation.OverflowEvent;
import org.esmp.dsm.simulation.OverflowMonitor;

/**
 * @author Andreas Unger
 *
 */
public class OverflowMonitorImpl implements OverflowMonitor {

	private boolean overflowed;
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.simulation.OverflowMonitor#overflowOccurred(org.esmp.dsm.simulation.OverflowEvent)
	 */
	public void overflowOccurred(OverflowEvent event) {
		overflowed = true;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.simulation.OverflowMonitor#hasOverflowed()
	 */
	public boolean hasOverflowed() {
		return overflowed;
	}
	
}

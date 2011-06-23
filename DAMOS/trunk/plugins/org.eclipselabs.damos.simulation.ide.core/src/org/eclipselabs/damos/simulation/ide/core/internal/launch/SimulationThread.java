/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.ide.core.internal.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipselabs.damos.simulation.engine.ISimulationEngine;
import org.eclipselabs.damos.simulation.ide.core.SimulationIDECorePlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationThread extends Thread {
	
	private ISimulationEngine simulationEngine;

	/**
	 * 
	 */
	public SimulationThread(ISimulationEngine simulationEngine) {
		super("Simulating block diagram");
		this.simulationEngine = simulationEngine;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		simulationEngine.run();
		if (!simulationEngine.getStatus().isOK()) {
			IStatusHandler prompter = DebugPlugin.getDefault().getStatusHandler(IStatuses.GENERIC_STATUS);
			if (prompter != null) {
				try {
					prompter.handleStatus(simulationEngine.getStatus(), null);
				} catch (CoreException e) {
					SimulationIDECorePlugin.getDefault().getLog().log(e.getStatus());
				}
			}
		}
	}
	
}

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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipselabs.damos.simulation.engine.ISimulationContext;
import org.eclipselabs.damos.simulation.engine.ISimulationMonitor;
import org.eclipselabs.damos.simulation.engine.ISimulator;
import org.eclipselabs.damos.simulation.engine.Simulator;
import org.eclipselabs.damos.simulation.ide.core.SimulationIDECorePlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationThread extends Thread {
	
	private ISimulationContext context;
	private ISimulationMonitor simulationMonitor;
		
	private ISimulator simulator = new Simulator();

	/**
	 * 
	 */
	public SimulationThread(ISimulationContext context, ISimulationMonitor simulationMonitor) {
		super("Simulating block diagram");
		this.context = context;
		this.simulationMonitor = simulationMonitor;
	}
	
	/**
	 * @return the monitor
	 */
	public ISimulationMonitor getSimulationMonitor() {
		return simulationMonitor;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		IStatus status = Status.OK_STATUS;

		try {
			simulator.simulate(context, simulationMonitor);
		} catch (CoreException e) {
			status = e.getStatus();
		}
		
		if (!status.isOK()) {
			IStatusHandler prompter = DebugPlugin.getDefault().getStatusHandler(IStatuses.GENERIC_STATUS);
			if (prompter != null) {
				try {
					prompter.handleStatus(status, null);
				} catch (CoreException e) {
					SimulationIDECorePlugin.getDefault().getLog().log(e.getStatus());
				}
			}
		}
	}
	
}

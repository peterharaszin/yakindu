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

package org.esmp.dsm.simulation.ui.internal.views;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.esmp.dsm.simulation.internal.launching.SimulationEvent;
import org.esmp.dsm.simulation.services.ISimulationListener;
import org.esmp.dsm.simulation.ui.DSMSimulatorUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListener implements ISimulationListener {

	public void simulationChanged(final SimulationEvent event) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			
			public void run() {
				try {
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IViewPart viewPart = activePage.showView(SimulationView.ID, null, IWorkbenchPage.VIEW_VISIBLE);
					if (viewPart instanceof SimulationView) {
						SimulationView simulationView = (SimulationView) viewPart;
						simulationView.setExecutionGraph(event.getExecutionGraph());
					}
					if (event.getContext().getOverflowMonitor().hasOverflowed()) {
						MessageDialog.openWarning(
								PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
								"Simulation Problem Occurred",
								"Numeric overflow occurred during simulation");
					}
				} catch (PartInitException e) {
					DSMSimulatorUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, DSMSimulatorUIPlugin.PLUGIN_ID,
							"Opening simulation results view failed", e));
				}
			}
		
		});
	}

}

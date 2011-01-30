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

package org.eclipselabs.damos.simulation.ui.internal.part;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.damos.simulation.engine.ISimulationListener;
import org.eclipselabs.damos.simulation.engine.SimulationEvent;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;
import org.eclipselabs.damos.simulation.ui.SimulationUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListener implements ISimulationListener {

	int step;
	int progress;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulationListener#handleSimulationEvent(org.eclipselabs.damos.simulation.engine.SimulationEvent)
	 */
	public void handleSimulationEvent(final SimulationEvent event) {
		if (event.getKind() == SimulationEvent.STEP) {
			int newProgress = (int) Math.round(100.0 * step++ / SimulationUtil.getStepCount(event.getContext().getSimulationModel()));
			if (newProgress == progress) {
				return;
			}
			progress = newProgress;
		}
		
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			
			public void run() {
				try {
					IWorkbenchPage workbenchPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					SimulationView viewPart;
					switch (event.getKind()) {
					case SimulationEvent.START:
						viewPart = (SimulationView) workbenchPage.showView(SimulationView.ID);
						viewPart.setProgress(0);
						viewPart.clear();
						step = 0;
						progress = 0;
						break;
					case SimulationEvent.STEP:
						viewPart = (SimulationView) workbenchPage.findView(SimulationView.ID);
						if (viewPart != null) {
							viewPart.setProgress(progress);
						}
						break;
					case SimulationEvent.FINISH:
					case SimulationEvent.CANCEL:
						viewPart = (SimulationView) workbenchPage.findView(SimulationView.ID);
						if (viewPart != null) {
							viewPart.setProgress(-1);
							if (event.getKind() == SimulationEvent.FINISH) {
								viewPart.setExecutionGraph(event.getContext().getExecutionGraph());
							}
						}
						break;
					}
				} catch (PartInitException e) {
					SimulationUIPlugin.getDefault().getLog().log(e.getStatus());
				}
			}
			
		});
	}

}

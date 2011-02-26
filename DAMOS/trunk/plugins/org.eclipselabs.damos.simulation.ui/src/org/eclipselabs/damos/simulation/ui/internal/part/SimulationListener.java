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

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.simulation.engine.ISimulationListener;
import org.eclipselabs.damos.simulation.engine.SimulationEvent;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;
import org.eclipselabs.damos.simulation.ui.SimulationUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListener implements ISimulationListener {

	private int step;
	private int progress;
	private Set<Component> overflowedComponents = new LinkedHashSet<Component>();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.engine.ISimulationListener#handleSimulationEvent(org.eclipselabs.damos.simulation.engine.SimulationEvent)
	 */
	public void handleSimulationEvent(final SimulationEvent event) {
		switch (event.getKind()) {
		case SimulationEvent.START:
			overflowedComponents.clear();
			break;
		case SimulationEvent.OVERFLOW:
			overflowedComponents.add((Component) event.getSource());
			break;
		case SimulationEvent.STEP:
			int newProgress = (int) Math.round(100.0 * step++ / SimulationUtil.getStepCount(event.getContext().getSimulationModel()));
			if (newProgress == progress) {
				return;
			}
			progress = newProgress;
			break;
		}
		
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			
			public void run() {
				try {
					IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
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
								viewPart.setExecutionFlow(event.getContext().getExecutionFlow());
							}
						}
						if (!overflowedComponents.isEmpty()) {
							StringBuilder sb = new StringBuilder("Numeric overflow occurred in ");
							boolean first = true;
							for (Component overflowedComponent : overflowedComponents) {
								if (first) {
									first = false;
								} else {
									sb.append(", ");
								}
								sb.append(overflowedComponent.getName());
							}
							overflowedComponents.clear();
							MessageDialog.openWarning(workbenchWindow.getShell(), "Simulation", sb.toString());
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

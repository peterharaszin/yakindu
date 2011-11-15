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

package org.eclipselabs.damos.simulation.ui.internal.parts;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.simulation.core.ISimulationListener;
import org.eclipselabs.damos.simulation.core.SimulationEvent;
import org.eclipselabs.damos.simulation.simulationmodel.util.SimulationModelUtil;
import org.eclipselabs.damos.simulation.ui.SimulationUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListener implements ISimulationListener {

	private boolean realtime;
	private long progress;
	private Set<Component> overflowedComponents = new LinkedHashSet<Component>();
	
	public void handleSimulationEvent(final SimulationEvent event) {
		switch (event.getKind()) {
		case SimulationEvent.START:
			realtime = event.getSimulation().getModel().getSimulationTime() == null;
			progress = 0;
			overflowedComponents.clear();
			break;
		case SimulationEvent.OVERFLOW:
			overflowedComponents.add((Component) event.getSource());
			break;
		case SimulationEvent.STEP:
			if (realtime) {
				long newTime = (long) event.getTime();
				if (newTime == progress) {
					return;
				}
				progress = newTime;
			} else {
				long newProgress = Math.round(100.0 * event.getTime() / SimulationModelUtil.getSimulationTime(event.getSimulation().getModel()));
				if (newProgress == progress) {
					return;
				}
				progress = newProgress;
			}
			break;
		}
		
		Display.getDefault().asyncExec(new Runnable() {
			
			public void run() {
				try {
					IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
					if (workbenchWindow == null) {
						return;
					}
					IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
					SimulationView viewPart;
					switch (event.getKind()) {
					case SimulationEvent.START:
						viewPart = (SimulationView) workbenchPage.showView(SimulationView.ID);
						viewPart.setRealtime(realtime);
						viewPart.setProgress(progress);
						viewPart.clear();
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
								viewPart.setSimulation(event.getSimulation());
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

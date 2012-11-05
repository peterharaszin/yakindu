/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.ui.internal.parts;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.simulation.ISimulationListener;
import org.eclipse.damos.simulation.SimulationEvent;
import org.eclipse.damos.simulation.ui.SimulationUIPlugin;
import org.eclipse.damos.simulation.util.SimulationConfigurationUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListener implements ISimulationListener {

	private double simulationTime;
	private long progress;
	private Set<Component> overflowedComponents = new LinkedHashSet<Component>();
	
	public void handleSimulationEvent(final SimulationEvent event) {
		switch (event.getKind()) {
		case SimulationEvent.START:
			simulationTime = SimulationConfigurationUtil.getSimulationTime(event.getSimulation().getConfiguration());
			progress = 0;
			overflowedComponents.clear();
			break;
		case SimulationEvent.OVERFLOW:
			overflowedComponents.add((Component) event.getSource());
			break;
		case SimulationEvent.STEP:
			if (simulationTime <= 0) {
				long newTime = (long) event.getTime();
				if (newTime == progress) {
					return;
				}
				progress = newTime;
			} else {
				long newProgress = Math.round(100.0 * event.getTime() / simulationTime);
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
						viewPart.setRealtime(simulationTime <= 0);
						viewPart.setProgress(progress);
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
							viewPart.setSimulation(event.getSimulation());
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

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

package org.esmp.dsm.simulation.internal.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.esmp.dsm.simulation.DSMSimulationPlugin;
import org.esmp.dsm.simulation.internal.launching.SimulationEvent;
import org.esmp.dsm.simulation.services.ISimulationListener;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListenerService {

	private static final String EXTENSION_POINT_NAME = "simulationListeners";
	private static final String LISTENER_ELEMENT = "listener";
	private static final String CLASS_NAME_ATTRIBUTE = "class";

	private static SimulationListenerService instance;
	private List<ISimulationListener> listeners;
	
	private ISchedulingRule acquireRule = new ISchedulingRule() {

		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}

		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}
		
	};

	/**
	 * 
	 */
	private SimulationListenerService() {
	}
	
	public static SimulationListenerService getInstance() {
		synchronized (SimulationListenerService.class) {
			if (instance == null) {
				instance = new SimulationListenerService();
			}
			return instance;
		}
	}
	
	public void fireSimulationEvent(SimulationEvent event) {
		Job job;
		synchronized (this) {
			if (listeners == null) {
				loadListeners();
			}
			job = new FireSimulationEventJob(listeners.toArray(new ISimulationListener[listeners.size()]), event);
		}
		job.schedule();
	}
	
	private void loadListeners() {
		listeners = new ArrayList<ISimulationListener>();

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				DSMSimulationPlugin.PLUGIN_ID, EXTENSION_POINT_NAME);

		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				if (LISTENER_ELEMENT.equals(configurationElement.getName())) {
					try {
						String className = getRequiredAttribute(configurationElement, CLASS_NAME_ATTRIBUTE);
						String nsid = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
						Class<?> clazz = Platform.getBundle(nsid).loadClass(className);
						ISimulationListener listener = (ISimulationListener) clazz.newInstance();
						listeners.add(listener);
					} catch (Exception e) {
						DSMSimulationPlugin.getDefault().getLog().log(
								new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID,
										"Failed to load simulation listener in plug-in '"
										+ extension.getContributor().getName()
										+ "' in extension of '"
										+ extensionPoint.getUniqueIdentifier()
										+ "'", e));
					}
				}
			}
		}

	}
	
	private String getRequiredAttribute(IConfigurationElement configurationElement, String name) {
		String value = configurationElement.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException("Missing '" + name + "' attribute");
		}
		return value;
	}
	
	private class FireSimulationEventJob extends Job {
		
		private ISimulationListener[] listeners;
		private SimulationEvent event;
		
		/**
		 * 
		 */
		public FireSimulationEventJob(ISimulationListener[] listeners, SimulationEvent event) {
			super("Fire simulation events");
			this.listeners = listeners;
			this.event = event;
			setRule(acquireRule);
		}
		
		protected IStatus run(IProgressMonitor monitor) {
			for (ISimulationListener l : listeners) {
				l.simulationChanged(event);
			}
			return Status.OK_STATUS;
		}

	}
	
}

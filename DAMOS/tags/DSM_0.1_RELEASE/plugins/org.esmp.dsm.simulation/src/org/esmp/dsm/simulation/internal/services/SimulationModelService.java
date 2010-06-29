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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.esmp.dsm.simulation.DSMSimulationPlugin;
import org.esmp.dsm.simulation.SimulationModel;
import org.esmp.dsm.simulation.services.SimulationModelProvider;

/**
 * @author Andreas Unger
 *
 */
public class SimulationModelService {
	
	private static final String EXTENSION_POINT_NAME = "simulationModelProviders";
	private static final String SIMULATION_MODEL_PROVIDER_ELEMENT = "simulationModelProvider";
	private static final String CLASS_NAME_ATTRIBUTE = "class";

	private static SimulationModelService instance;
	private List<SimulationModelProvider> providers;
	
	/**
	 * 
	 */
	private SimulationModelService() {
	}
	
	/**
	 * @return the instance
	 */
	public static SimulationModelService getInstance() {
		if (instance == null) {
			instance = new SimulationModelService();
		}
		return instance;
	}
	
	public SimulationModel createSimulationModel(URI blockTypeURI) {
		if (providers == null) {
			loadProviders();
		}
		for (SimulationModelProvider p : providers) {
			SimulationModel simulationModel = p.createSimulationModel(blockTypeURI);
			if (simulationModel != null) {
				return simulationModel;
			}
		}
		return null;
	}
	
	private void loadProviders() {
		providers = new ArrayList<SimulationModelProvider>();

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				DSMSimulationPlugin.PLUGIN_ID, EXTENSION_POINT_NAME);

		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				if (SIMULATION_MODEL_PROVIDER_ELEMENT.equals(configurationElement.getName())) {
					try {
						String className = getRequiredAttribute(configurationElement, CLASS_NAME_ATTRIBUTE);
						String nsid = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
						Class<?> clazz = Platform.getBundle(nsid).loadClass(className);
						SimulationModelProvider provider = (SimulationModelProvider) clazz.newInstance();
						providers.add(provider);
					} catch (Exception e) {
						DSMSimulationPlugin.getDefault().getLog().log(
								new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID,
										"Failed to load simulation model provider in plug-in '"
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
	
}

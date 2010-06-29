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

import java.util.HashMap;
import java.util.Map;

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
public class DeclarativeSimulationModelProvider implements SimulationModelProvider {

	private static final String EXTENSION_POINT_NAME = "simulationModels";
	private static final String ELEMENT_NAME = "simulationModel";
	
	private static final String BLOCK_TYPE_URI_ATTRIBUTE = "blockTypeURI";
	private static final String CLASS_NAME_ATTRIBUT = "class";
	
	private Map<URI, Mapping> mappings;
	
	public SimulationModel createSimulationModel(URI blockTypeURI) {
		if (mappings == null) {
			loadMappings();
		}
		Mapping mapping = mappings.get(blockTypeURI);
		if (mapping != null) {
			return mapping.createSimulationModel();
		}
		return null;
	}
	
	private void loadMappings() {
		mappings = new HashMap<URI, Mapping>();
		
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				DSMSimulationPlugin.PLUGIN_ID, EXTENSION_POINT_NAME);

		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				if (ELEMENT_NAME.equals(configurationElement.getName())) {
					try {
						loadBlockTypeElement(configurationElement);
					} catch (Exception e) {
						DSMSimulationPlugin.getDefault().getLog().log(
								new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID,
										"Failed to load block type in plug-in '"
										+ extension.getContributor().getName()
										+ "' in extension of '"
										+ extensionPoint.getUniqueIdentifier()
										+ "'", e));
					}
				}
			}
		}
	}
	
	private void loadBlockTypeElement(IConfigurationElement blockTypeElement) {
		String uriString = getRequiredAttribute(blockTypeElement, BLOCK_TYPE_URI_ATTRIBUTE);
		String className = getRequiredAttribute(blockTypeElement, CLASS_NAME_ATTRIBUT);
		
		URI uri;
		try {
			uri = URI.createURI(uriString);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid block type URI specified: " + uriString, e);
		}
		
		Mapping blockTypeMapping = new Mapping(uri, blockTypeElement, className);
		mappings.put(uri, blockTypeMapping);
	}

	private String getRequiredAttribute(IConfigurationElement configurationElement, String name) {
		String value = configurationElement.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException("Missing '" + name + "' attribute");
		}
		return value;
	}

	private static class Mapping {
		
		private URI blockTypeURI;
		private IConfigurationElement configurationElement;
		private String className;
		private Class<?> clazz;
		
		/**
		 * 
		 */
		public Mapping(URI blockTypeURI, IConfigurationElement configurationElement, String className) {
			this.blockTypeURI = blockTypeURI;
			this.configurationElement = configurationElement;
			this.className = className;
		}
		
		public SimulationModel createSimulationModel() {
			if (clazz == null) {
				loadClass();
			}
			try {
				return (SimulationModel) clazz.newInstance();
			} catch (InstantiationException e) {
				log(e.getMessage());
			} catch (IllegalAccessException e) {
				log(e.getMessage());
			}
			return null;
		}
		
		private void loadClass() {
			if (className == null) {
				return;
			}
			try {
				String nsid = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
				Class<?> clazz = Platform.getBundle(nsid).loadClass(className);
				if (!SimulationModel.class.isAssignableFrom(clazz)) {
					log("Class must implement 'SimulationModel' interface");
					return;
				}
				clazz.getConstructor();
				this.clazz = clazz;
			} catch (ClassNotFoundException e) {
				log(e.getMessage());
			} catch (NoSuchMethodException e) {
				log(e.getMessage());
			}
		}
		
		private void log(String msg) {
			DSMSimulationPlugin.getDefault().getLog().log(
					new Status(IStatus.ERROR, DSMSimulationPlugin.PLUGIN_ID,
							"Failed to load class '"
							+ className
							+ "' in plug-in '"
							+ configurationElement.getDeclaringExtension().getNamespaceIdentifier()
							+ "' in extension of '"
							+ configurationElement.getDeclaringExtension().getExtensionPointUniqueIdentifier()
							+ "' block type URI '"
							+ blockTypeURI
							+ "': " + msg));
		}
		
	}

}

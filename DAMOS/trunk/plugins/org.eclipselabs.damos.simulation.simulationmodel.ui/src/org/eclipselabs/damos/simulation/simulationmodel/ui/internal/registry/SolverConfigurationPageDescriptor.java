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

package org.eclipselabs.damos.simulation.simulationmodel.ui.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.DMLPlugin;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverConfigurationDescriptor;
import org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage;

/**
 * @author Andreas Unger
 *
 */
public class SolverConfigurationPageDescriptor {

	private String id;
	private ISolverConfigurationDescriptor solverConfiguration;
	private String className;
	private IConfigurationElement configurationElement;
	private Class<?> clazz;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @param solverConfiguration the solverConfiguration to set
	 */
	public void setSolverConfiguration(ISolverConfigurationDescriptor solverConfiguration) {
		this.solverConfiguration = solverConfiguration;
	}
	
	/**
	 * @return the configurationElement
	 */
	public IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}
	
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	/**
	 * @return the solverConfiguration
	 */
	public ISolverConfigurationDescriptor getSolverConfiguration() {
		return solverConfiguration;
	}

	/**
	 * @param configurationElement the configurationElement to set
	 */
	public void setConfigurationElement(IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
	}
	
	public ISolverConfigurationPage createPage() {
		if (clazz == null) {
			loadClass();
		}
		try {
			return (ISolverConfigurationPage) clazz.newInstance();
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
			if (!ISolverConfigurationPage.class.isAssignableFrom(clazz)) {
				log("Class must implement 'ISolverConfigurationPage' interface");
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
		DMLPlugin.getPlugin().getLog().log(
				new Status(IStatus.ERROR, DMLPlugin.PLUGIN_ID,
						"Failed to load class '"
						+ className
						+ "' in plug-in '"
						+ configurationElement.getDeclaringExtension().getNamespaceIdentifier()
						+ "' in extension of '"
						+ configurationElement.getDeclaringExtension().getExtensionPointUniqueIdentifier()
						+ "' solverConfigurationPage'"
						+ id
						+ "': " + msg));
	}

}

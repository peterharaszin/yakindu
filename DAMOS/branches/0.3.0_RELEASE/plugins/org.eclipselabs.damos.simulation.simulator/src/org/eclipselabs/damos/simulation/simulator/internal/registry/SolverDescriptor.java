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

package org.eclipselabs.damos.simulation.simulator.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.simulation.simulator.internal.SimulatorPlugin;
import org.eclipselabs.damos.simulation.simulator.registry.ISolverDescriptor;
import org.eclipselabs.damos.simulation.simulator.solver.ISolver;

/**
 * @author Andreas Unger
 *
 */
public class SolverDescriptor implements ISolverDescriptor {

	private String id;
	private String name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the configurationElement
	 */
	public IConfigurationElement getConfigurationElement() {
		return configurationElement;
	}
	
	/**
	 * @param configurationElement the configurationElement to set
	 */
	public void setConfigurationElement(IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
	}
	
	public ISolver createSolver() {
		if (clazz == null) {
			loadClass();
		}
		try {
			return (ISolver) clazz.newInstance();
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
			if (!ISolver.class.isAssignableFrom(clazz)) {
				log("Class must implement 'ISolver' interface");
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
		SimulatorPlugin.getDefault().getLog().log(
				new Status(IStatus.ERROR, SimulatorPlugin.PLUGIN_ID,
						"Failed to load class '"
						+ className
						+ "' in plug-in '"
						+ configurationElement.getDeclaringExtension().getNamespaceIdentifier()
						+ "' in extension of '"
						+ configurationElement.getDeclaringExtension().getExtensionPointUniqueIdentifier()
						+ "' solver '"
						+ name
						+ "': " + msg));
	}

}

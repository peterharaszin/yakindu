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

package org.eclipselabs.damos.codegen.targets.arduino.internal.registry;


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.codegen.c.CodegenCPlugin;
import org.eclipselabs.damos.codegen.targets.arduino.IShieldGenerator;

/**
 * @author Andreas Unger
 *
 */
public class ShieldGeneratorDescriptor {

	private String shieldId;
	private String className;
	private IConfigurationElement configurationElement;
	private Class<?> clazz;

	/**
	 * @return the id
	 */
	public String getShieldId() {
		return shieldId;
	}
	
	/**
	 * @param shieldId the shield ID to set
	 */
	public void setShieldId(String shieldId) {
		this.shieldId = shieldId;
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
	
	public IShieldGenerator createGenerator() {
		if (clazz == null) {
			loadClass();
		}
		try {
			return (IShieldGenerator) clazz.newInstance();
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
			if (!IShieldGenerator.class.isAssignableFrom(clazz)) {
				log("Class must implement 'IShieldGenerator' interface");
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
		CodegenCPlugin.getDefault().getLog().log(
				new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID,
						"Failed to load class '"
						+ className
						+ "' in plug-in '"
						+ configurationElement.getDeclaringExtension().getNamespaceIdentifier()
						+ "' in extension of '"
						+ configurationElement.getDeclaringExtension().getExtensionPointUniqueIdentifier()
						+ "' shield generator '"
						+ shieldId
						+ "': " + msg));
	}

}

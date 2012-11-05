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

package org.eclipse.damos.codegen.c.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.dml.DMLPlugin;

public class BlockGeneratorDescriptor {
	
	private String blockTypeQualifiedName;
	private String className;
	private IConfigurationElement configurationElement;
	private Class<?> clazz;
	
	/**
	 * @return the blockType
	 */
	public String getBlockTypeQualifiedName() {
		return blockTypeQualifiedName;
	}
	
	/**
	 * @param blockTypeQualifiedName the blockTypeQualifiedName to set
	 */
	public void setBlockTypeQualifiedName(String blockTypeQualifiedName) {
		this.blockTypeQualifiedName = blockTypeQualifiedName;
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
		
	public IComponentGenerator createObject() {
		if (clazz == null) {
			loadClass();
		}
		try {
			return (IComponentGenerator) clazz.newInstance();
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
			if (!IComponentGenerator.class.isAssignableFrom(clazz)) {
				log("Class must implement 'IGenerator' interface");
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
						+ "' block type '"
						+ blockTypeQualifiedName
						+ "': " + msg));
	}
	
}
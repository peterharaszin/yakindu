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

package org.eclipse.damos.codegen.internal.registry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.damos.codegen.IGenerator;
import org.eclipse.damos.codegen.internal.CodegenPlugin;
import org.eclipse.damos.codegen.registry.IGeneratorDescriptor;
import org.eclipse.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorDescriptor implements IGeneratorDescriptor {

	private String id;
	private String name;
	private IConfigurationElement configurationElement;

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
	
	public IGenerator createGenerator() {
		try {
			return (IGenerator) configurationElement.createExecutableExtension(IRegistryConstants.ATT_CLASS);
		} catch (CoreException e) {
			CodegenPlugin.getDefault().getLog().log(e.getStatus());
		}
		return null;
	}
	
}

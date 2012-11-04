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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.damos.codegen.c.CodegenCPlugin;
import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.common.registry.IRegistryConstants;

public class BlockGeneratorDescriptor {
	
	private String blockTypeQualifiedName;
	private IConfigurationElement configurationElement;
	
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
		
	public IComponentGenerator createGenerator() {
		try {
			return (IComponentGenerator) configurationElement.createExecutableExtension(IRegistryConstants.ATT_CLASS);
		} catch (CoreException e) {
			CodegenCPlugin.getDefault().getLog().log(e.getStatus());
		}
		return null;
	}
	
}
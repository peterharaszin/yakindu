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
import org.eclipse.damos.codegen.c.ITargetGenerator;
import org.eclipse.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class TargetGeneratorDescriptor {

	private String targetId;
	private IConfigurationElement configurationElement;

	/**
	 * @return the id
	 */
	public String getTargetId() {
		return targetId;
	}
	
	/**
	 * @param targetId the target ID to set
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId;
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
	
	public ITargetGenerator createGenerator() {
		try {
			return (ITargetGenerator) configurationElement.createExecutableExtension(IRegistryConstants.ATT_CLASS);
		} catch (CoreException e) {
			CodegenCPlugin.getDefault().getLog().log(e.getStatus());
		}
		return null;
	}
	
}

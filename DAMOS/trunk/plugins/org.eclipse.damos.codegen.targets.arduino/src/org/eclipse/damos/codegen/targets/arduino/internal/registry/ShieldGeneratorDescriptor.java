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

package org.eclipse.damos.codegen.targets.arduino.internal.registry;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.damos.codegen.targets.arduino.ArduinoPlugin;
import org.eclipse.damos.codegen.targets.arduino.IShieldGenerator;
import org.eclipse.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class ShieldGeneratorDescriptor {

	private String shieldId;
	private IConfigurationElement configurationElement;

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
		try {
			return (IShieldGenerator) configurationElement.createExecutableExtension(IRegistryConstants.ATT_CLASS);
		} catch (CoreException e) {
			ArduinoPlugin.getDefault().getLog().log(e.getStatus());
		}
		return null;
	}

}

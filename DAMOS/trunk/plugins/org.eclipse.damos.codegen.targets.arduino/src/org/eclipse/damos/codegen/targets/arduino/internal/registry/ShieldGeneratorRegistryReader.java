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


import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.codegen.targets.arduino.ArduinoPlugin;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class ShieldGeneratorRegistryReader extends AbstractRegistryReader implements IRegistryConstants {

	private static final String EXTENSION_POINT_NAME = "shieldGenerators";

	private static final String TAG = "generator";
	
	private static final String ATT_TARGET_ID = "shield";

	private ShieldGeneratorRegistry registry;
	
	public void registerProviders(ShieldGeneratorRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return ArduinoPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return ArduinoPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG)) {
			return false;
		}

		String id = getRequiredAttribute(element, ATT_TARGET_ID);
		
		ShieldGeneratorDescriptor generator = new ShieldGeneratorDescriptor();
		generator.setShieldId(id);
		generator.setConfigurationElement(element);
		registry.register(generator);
		
		return true;
	}

}

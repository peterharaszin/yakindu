/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.codegen.c.CodegenCPlugin;
import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class RuntimeEnvironmentAPIRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "runtimeEnvironmentAPIs";

	private static final String TAG = "runtimeEnvironmentAPI";
	private static final String ATT_RUNTIME_ENVIRONMENT = "runtimeEnvironment";

	private RuntimeEnvironmentAPIRegistry registry;
	
	public void registerProviders(RuntimeEnvironmentAPIRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return CodegenCPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return CodegenCPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG)) {
			return false;
		}

        String runtimeEnvironmentId = getRequiredAttribute(element, ATT_RUNTIME_ENVIRONMENT);
        IRuntimeEnvironmentAPI runtimeEnvironmentAPI = createExecutableExtension(element, IRegistryConstants.ATT_CLASS, IRuntimeEnvironmentAPI.class);
        if (runtimeEnvironmentAPI != null) {
        	registry.register(runtimeEnvironmentId, runtimeEnvironmentAPI);
        }
        
        return true;
	}

}

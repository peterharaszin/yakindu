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

package org.eclipselabs.damos.simulation.engine.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObjectProvider;
import org.eclipselabs.damos.simulation.engine.SimulationEnginePlugin;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSimulationObjectProviderRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "componentSimulationObjectProviders";

	private static final String TAG_PROVIDER = "provider";

	private ComponentSimulationObjectProviderRegistry registry;
	
	public void registerProviders(ComponentSimulationObjectProviderRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return SimulationEnginePlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return SimulationEnginePlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_PROVIDER)) {
			return false;
		}

        IComponentSimulationObjectProvider provider = createExecutableExtension(element, IRegistryConstants.ATT_CLASS, IComponentSimulationObjectProvider.class);
        if (provider != null) {
        	registry.register(provider);
        }
        
        return true;
	}

}

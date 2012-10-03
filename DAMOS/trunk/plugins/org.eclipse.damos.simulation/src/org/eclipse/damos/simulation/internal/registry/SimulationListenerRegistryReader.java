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

package org.eclipse.damos.simulation.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.common.registry.IRegistryConstants;
import org.eclipse.damos.simulation.ISimulationListener;
import org.eclipse.damos.simulation.internal.SimulationPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListenerRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "simulationListeners";

	private static final String TAG_PROVIDER = "listener";

	private SimulationListenerRegistry registry;
	
	public void registerListeners(SimulationListenerRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return SimulationPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return SimulationPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_PROVIDER)) {
			return false;
		}

        ISimulationListener listener = createExecutableExtension(element, IRegistryConstants.ATT_CLASS, ISimulationListener.class);
        if (listener != null) {
        	registry.register(listener);
        }
        
        return true;
	}

}

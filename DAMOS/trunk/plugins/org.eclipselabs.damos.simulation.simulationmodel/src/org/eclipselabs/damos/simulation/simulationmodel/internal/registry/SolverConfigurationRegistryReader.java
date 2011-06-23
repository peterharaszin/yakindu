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

package org.eclipselabs.damos.simulation.simulationmodel.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;
import org.eclipselabs.damos.simulation.simulationmodel.internal.SimulationModelPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SolverConfigurationRegistryReader extends AbstractRegistryReader implements IRegistryConstants {

	private static final String EXTENSION_POINT_NAME = "solverConfigurations";

	private static final String TAG = "solverConfiguration";
	private static final String ATT_URI = "uri";

	private SolverConfigurationRegistry registry;
	
	public void registerProviders(SolverConfigurationRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return SimulationModelPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return SimulationModelPlugin.getPlugin().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG)) {
			return false;
		}

		String id = getRequiredAttribute(element, ATT_ID);
		String uriString = getRequiredAttribute(element, ATT_URI);
		
		SolverConfigurationDescriptor solverConfiguration = new SolverConfigurationDescriptor();
		solverConfiguration.setId(id);

		try {
			solverConfiguration.setURI(URI.createURI(uriString));
			registry.register(solverConfiguration);
		} catch (IllegalArgumentException e) {
			logError(element, "Invalid URI '" + uriString + "' specified");
		}
		
		return true;
	}

}

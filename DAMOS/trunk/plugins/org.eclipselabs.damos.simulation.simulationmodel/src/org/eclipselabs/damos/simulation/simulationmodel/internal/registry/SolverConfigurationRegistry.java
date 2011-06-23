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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverConfigurationDescriptor;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverConfigurationRegistry;

/**
 * @author Andreas Unger
 *
 */
public class SolverConfigurationRegistry implements ISolverConfigurationRegistry {

	private Map<String, ISolverConfigurationDescriptor> solverConfigurations = new HashMap<String, ISolverConfigurationDescriptor>();
	
	/**
	 * 
	 */
	public SolverConfigurationRegistry() {
		initializeFromStorage();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.internal.registry.ISolverConfigurationRegistry#getSolverConfiguration(java.lang.String)
	 */
	public ISolverConfigurationDescriptor getSolverConfiguration(String id) {
		return solverConfigurations.get(id);
	}

	public void register(ISolverConfigurationDescriptor solverConfiguration) {
		solverConfigurations.put(solverConfiguration.getId(), solverConfiguration);
	}
	
	public void unregister(ISolverConfigurationDescriptor solverConfiguration) {
		solverConfigurations.remove(solverConfiguration.getId());
	}

	private void initializeFromStorage() {
		SolverConfigurationRegistryReader reader = new SolverConfigurationRegistryReader();
		reader.registerProviders(this);
	}
	
}

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

package org.eclipselabs.damos.simulation.simulationmodel.ui.internal.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.simulation.simulationmodel.ui.ISolverConfigurationPage;
import org.eclipselabs.damos.simulation.simulationmodel.ui.registry.ISolverConfigurationPageRegistry;

/**
 * @author Andreas Unger
 *
 */
public class SolverConfigurationPageRegistry implements ISolverConfigurationPageRegistry {

	private Map<String, SolverConfigurationPageDescriptor> pages = new HashMap<String, SolverConfigurationPageDescriptor>();
	
	/**
	 * 
	 */
	public SolverConfigurationPageRegistry() {
		initializeFromStorage();
	}
	
	public ISolverConfigurationPage createPage(String solverConfigurationId) {
		SolverConfigurationPageDescriptor page = pages.get(solverConfigurationId);
		if (page != null) {
			return page.createPage();
		}
		return null;
	}
	
	public void register(SolverConfigurationPageDescriptor solver) {
		pages.put(solver.getSolverConfiguration().getQualifiedName(), solver);
	}
	
	public void unregister(SolverConfigurationPageDescriptor solver) {
		pages.remove(solver.getSolverConfiguration().getQualifiedName());
	}

	private void initializeFromStorage() {
		SolverConfigurationPageRegistryReader reader = new SolverConfigurationPageRegistryReader();
		reader.registerProviders(this);
	}
	
}

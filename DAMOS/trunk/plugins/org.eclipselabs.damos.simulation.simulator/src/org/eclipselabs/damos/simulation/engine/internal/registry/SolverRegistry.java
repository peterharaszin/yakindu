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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.simulation.engine.registry.ISolverDescriptor;
import org.eclipselabs.damos.simulation.engine.registry.ISolverRegistry;

/**
 * @author Andreas Unger
 *
 */
public class SolverRegistry implements ISolverRegistry {

	private Map<String, ISolverDescriptor> solvers = new HashMap<String, ISolverDescriptor>();
	
	/**
	 * 
	 */
	public SolverRegistry() {
		initializeFromStorage();
	}
	
	public Collection<ISolverDescriptor> getSolvers() {
		return solvers.values();
	}
	
	public ISolverDescriptor getSolver(String id) {
		return solvers.get(id);
	}

	public void register(SolverDescriptor solver) {
		solvers.put(solver.getId(), solver);
	}
	
	public void unregister(SolverDescriptor solver) {
		solvers.remove(solver.getId());
	}

	private void initializeFromStorage() {
		SolverRegistryReader reader = new SolverRegistryReader();
		reader.registerProviders(this);
	}
	
}

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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeDescriptor;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeRegistry;

/**
 * @author Andreas Unger
 *
 */
public class SolverTypeRegistry implements ISolverTypeRegistry {

	private Map<String, ISolverTypeDescriptor> solverTypes = new HashMap<String, ISolverTypeDescriptor>();
	
	/**
	 * 
	 */
	public SolverTypeRegistry() {
		initializeFromStorage();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeRegistry#getSolverTypes()
	 */
	public Collection<ISolverTypeDescriptor> getSolverTypes() {
		return solverTypes.values();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.internal.registry.ISolverConfigurationRegistry#getSolverConfiguration(java.lang.String)
	 */
	public ISolverTypeDescriptor getSolverType(String qualifiedName) {
		return solverTypes.get(qualifiedName);
	}

	public void register(ISolverTypeDescriptor solverType) {
		solverTypes.put(solverType.getQualifiedName(), solverType);
	}
	
	public void unregister(ISolverTypeDescriptor solverType) {
		solverTypes.remove(solverType.getQualifiedName());
	}

	private void initializeFromStorage() {
		SolverTypeRegistryReader reader = new SolverTypeRegistryReader();
		reader.registerProviders(this);
	}
	
}

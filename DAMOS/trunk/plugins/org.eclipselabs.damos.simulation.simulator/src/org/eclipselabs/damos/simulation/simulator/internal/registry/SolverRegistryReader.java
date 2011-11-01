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

package org.eclipselabs.damos.simulation.simulator.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeDescriptor;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeRegistry;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEnginePlugin;

/**
 * @author Andreas Unger
 *
 */
public class SolverRegistryReader extends AbstractRegistryReader implements IRegistryConstants {

	private static final String EXTENSION_POINT_NAME = "solvers";

	private static final String TAG = "solver";
	private static final String ATT_SOLVER_TYPE = "solverType";

	private SolverRegistry registry;
	
	public void registerProviders(SolverRegistry registry) {
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
        if (!element.getName().equals(TAG)) {
			return false;
		}

		String solverTypeQualifiedName = getRequiredAttribute(element, ATT_SOLVER_TYPE);
		String name = getRequiredAttribute(element, ATT_NAME);
		String className = getRequiredAttribute(element, ATT_CLASS);
		
		ISolverTypeDescriptor solverType = ISolverTypeRegistry.INSTANCE.getSolverType(solverTypeQualifiedName);
		if (solverType != null) {
			SolverDescriptor solver = new SolverDescriptor();
			solver.setSolverType(solverType);
			solver.setName(name);
			solver.setClassName(className);
			solver.setConfigurationElement(element);
			registry.register(solver);
		} else {
			logError(element, "Solver type '" + solverTypeQualifiedName + "' not found");
		}
		
		return true;
	}

}

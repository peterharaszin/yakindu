/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.simulation.ide.core.internal.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipse.damos.simulation.ide.core.util.LaunchConfigurationUtil;
import org.eclipse.damos.simulation.simulator.Simulator;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

public class SimulationLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipse.damos.simulation.ide.core.simulation";
	
	public static final String ATTRIBUTE__BASE_CONFIGURATION_PATH = "baseConfigurationPath";
	public static final String ATTRIBUTE__OVERRIDE_CONFIGURATION = "overrideConfiguration";
	public static final String ATTRIBUTE__FRAGMENT = "fragment";
	public static final String ATTRIBUTE__SIMULATION_TIME = "simulationTime";
	public static final String ATTRIBUTE__REAL_TIME_SIMULATION = "realTimeSimulation";
	public static final String ATTRIBUTE__SOLVER = "solver";
	public static final String ATTRIBUTE__SOLVER_CONFIGURATION = "solverConfiguration";

	public static final String DEFAULT_SIMULATION_TIME = "10(s)";
	public static final String DEFAULT_SOLVER_ID = "damos.simulation.solvers.DormandPrince54";

	public void launch(ILaunchConfiguration launchConfiguration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		Configuration configuration = LaunchConfigurationUtil.createConfiguration(launchConfiguration, new PropertyEnumerationHelper("damos.simulation.solver"));
		Simulator simulator = new Simulator();
		simulator.initialize(configuration, progressMonitor);
		if (progressMonitor != null && progressMonitor.isCanceled()) {
			return;
		}
		
		String name = configuration.getContextFragment().getName();
		if (name == null) {
			name = "Unnamed";
		}
		
		new SimulationProcess(launch, name).run(simulator.getSimulationEngine());
	}

	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}
	
}

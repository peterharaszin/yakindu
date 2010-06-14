/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.ui.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.AbstractSimulationParameterSet;
import org.mda4e.simulation.core.ISimulationEngine;

import com.yakindu.simulation.launch.YakinduSimulationLauncher;
import com.yakindu.simulation.launch.debug.DebugTarget;
import com.yakindu.simulation.ui.launch.tabs.YakinduMainTab;

/**
 * The class <code>>YakinduLaunchConfigurationDelegate</code> extends the
 * eclipse launch configuration types (extension point:
 * <code>org.eclipse.debug.core.launchConfigurationTypes</code>) It provides a
 * type to set up a simulation with an arbitrary simulation engine which
 * implements the interface {@link ISimulationEngine}. Additionally, an
 * arbitrary number of simulation engine controllers,which implements the
 * interface {@link ISimulationController}, can be registered to control the
 * simulation or to represent the system state. For example, a controller can
 * provide controls to start and stop the engine.
 * 
 * @author Markus M�hlbrandt
 * @author Philipp Richter
 * @author Benjamin Schwertfeger
 * @author Dominik Schmidt
 */
public class YakinduLaunchConfigurationDelegate extends
		LaunchConfigurationDelegate {

	/**
	 * @see org.eclipse.debug.core.model.ILaunchConfigurationDelegate#launch(org.eclipse.debug.core.ILaunchConfiguration,
	 *      java.lang.String, org.eclipse.debug.core.ILaunch,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void launch(final ILaunchConfiguration configuration,
			final String mode, final ILaunch launch,
			final IProgressMonitor monitor) throws CoreException {

		// Get the index of the selected simulation engine
		int engineIndex = configuration.getAttribute(
				YakinduMainTab.SELECTED_ENGINE, 0);

		// Read the list of all registered extensions of the simulation engine
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		IConfigurationElement[] engineExtensionList = reg
				.getConfigurationElementsFor(ISimulationEngine.ENGINE_EXTENSION_POINT);

		// Creating the simulation parameter set
		AbstractSimulationParameterSet param = (AbstractSimulationParameterSet) engineExtensionList[engineIndex]
				.createExecutableExtension("ParameterSet");
		param.setEngineBaseParameters(configuration);
		param.setEngineSpecificParameters(configuration);
		DebugTarget target = new DebugTarget(monitor, launch);
		launch.addDebugTarget(target);

		// Instantiate the launcher who realizes the simulation environment
		YakinduSimulationLauncher simLauncher = new YakinduSimulationLauncher(
				target, param, engineIndex, monitor);
		Thread runner = new Thread(simLauncher);
		runner.start();
	}
}
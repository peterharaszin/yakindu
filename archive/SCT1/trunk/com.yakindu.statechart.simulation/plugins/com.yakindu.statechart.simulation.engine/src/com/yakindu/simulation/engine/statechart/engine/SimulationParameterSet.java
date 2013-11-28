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
package com.yakindu.simulation.engine.statechart.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.mda4e.simulation.statemachine.AbstractStatemachineParameterSet;

import com.yakindu.simulation.engine.statechart.nls.Messages;
import com.yakindu.simulation.engine.statechart.properties.PluginProperties;

/**
 * The class <code>SimulationParameterSet</code> allows the defining of all
 * required simulation parameters.
 * 
 * @author Philipp Richter
 */
public class SimulationParameterSet extends AbstractStatemachineParameterSet {

	/**
	 * Defines the constant to be able to read the time scaling with which the
	 * simulation shall be started.
	 * 
	 * @see #timeScaling
	 * @see ILaunchConfiguration
	 */
	public static final String TIME_SCALING = "TimeScaling";

	/**
	 * Defines the constant to be able to read the interval of the scheduler.
	 */
	public static final String SCHEDULER_INTERVAL = "SchedulerInterval";

	/** Defines the default time scaling of the simulation. */
	public static final String TIME_SCALING_DEFAULT = "1.0";

	/** Defines the default interval of the scheduler. */
	public static final String SCHEDULER_INTERVAL_DEFAULT = "0";

	/**
	 * Defines the simulation time scaling. With the help of this value it is
	 * possible to manipulate the simulation speed.
	 */
	private double timeScaling = 1.0;

	/**
	 * Defines the simulation scheduler interval. If this value is greater than
	 * 0.0 the simulation will be scheduled with the given interval. An interval
	 * smaller than 0.0 is not allowed.
	 */
	private long schedulerInterval = 0l;

	/**
	 * Default constructor.
	 */
	public SimulationParameterSet() {

	}

	/**
	 * @see org.mda4e.simulation.core.AbstractSimulationParameterSet#setEngineSpecificParameters(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public void setEngineSpecificParameters(
			final ILaunchConfiguration configuration) throws CoreException {

		try {
			timeScaling =
					Double.parseDouble(configuration.getAttribute(
						TIME_SCALING,
						TIME_SCALING_DEFAULT));

		} catch (final NumberFormatException e) {
			throw new CoreException(new Status(
				IStatus.ERROR,
				PluginProperties.plugin_id,
				Messages.SimulationParameterTab_timescalingerror,
				e));
		}

		try {
			schedulerInterval =
					Long.parseLong(configuration.getAttribute(
						SCHEDULER_INTERVAL,
						SCHEDULER_INTERVAL_DEFAULT));

		} catch (final NumberFormatException e) {
			throw new CoreException(new Status(
				IStatus.ERROR,
				PluginProperties.plugin_id,
				Messages.SimulationParameterTab_schedulerintervalerror,
				e));
		}
	}

	/**
	 * Provides the time scaling which shall be used for the simulation.
	 * 
	 * @return The time scaling.
	 */
	public double getTimeScaling() {

		return timeScaling;
	}

	
	/**
	 * Provides the scheduler interval.
	 * 
	 * @return The scheduler interval.
	 */
	public long getSchedulerInterval() {
	
		return schedulerInterval;
	}
}
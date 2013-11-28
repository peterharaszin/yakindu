/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.simulation.statemachine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.mda4e.simulation.core.AbstractSimulationParameterSet;
import org.mda4e.simulation.core.ISimulationParameterSet;

/**
 * The <code>AbstractStatemachineParameterSet</code> defines the
 * parameter set for the simulation engine. It extends the abstract
 * {@link AbstractSimulationParameterSet} and add different methods
 * which are specific to statemachines.
 * 
 * @see ISimulationParameterSet
 * @see AbstractSimulationParameterSet
 * 
 * @author Markus M�hlbrandt
 * @author Philipp Richter, Benjamin Schwertfeger
 */
public abstract class AbstractStatemachineParameterSet extends
		AbstractSimulationParameterSet implements IStatemachineParameterSet {

	/**
	 * Defines the constant to be able to read the property which defines
	 * whether the statechart must be simulated in real time.
	 * 
	 * @see #isRealtime
	 * @see ILaunchConfiguration
	 */
	public static final String IsRealtime = "IsRealTime";

	/**
	 * Defines whether the statechart must be simulated in real time.
	 */
	private boolean isRealtime = false;

	/*
	 * @see org.mda4e.simulation.statemachine.IStatemachineParameterSet#isRealtime()
	 */
	public boolean isRealtime() {
		return isRealtime;
	}

	/*
	 * @see org.mda4e.simulation.core.AbstractSimulationParameterSet#setEngineBaseParameters(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	public void setEngineBaseParameters(ILaunchConfiguration configuration)
			throws CoreException {
		isRealtime = configuration.getAttribute(IsRealtime, false);
		super.setEngineBaseParameters(configuration);
	}
}
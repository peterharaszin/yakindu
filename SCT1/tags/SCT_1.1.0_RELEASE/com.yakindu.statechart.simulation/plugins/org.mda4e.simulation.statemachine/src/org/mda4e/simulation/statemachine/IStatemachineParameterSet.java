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

import org.mda4e.simulation.core.ISimulationParameterSet;

/**
 * The interface <code>IStatemachineParameterSet</code> defines the required
 * methods of a parameter set for a {@link IStatemachineEngine}.
 * 
 * @author Markus M�hlbrandt, Philipp Richter, Benjamin Schwertfeger
 */
public interface IStatemachineParameterSet extends ISimulationParameterSet {
	
	/**
	 * Returns <code>true</code> if the statechart must be simulated in
	 * real time, otherwise the result is <code>false</code>.
	 * 
	 * @return 	The result is <code>true</code>, if the statechart must be
	 * 			simulated in real time.
	 */
	public boolean isRealtime();
	
}

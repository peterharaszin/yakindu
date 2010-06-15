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
package org.mda4e.simulation.core;

/**
 * <p>
 * The simulation states define the possible states of a {@link ISimulationEngine}.
 * </p>
 * <p>
 * <b>The right lifecycle:</b><br>
 * 
 * The initial state of the engine is {@link #STOPPED}. If the simulation is
 * started for the first time the following states are possible:
 * {@link #RUNNING}, {@link #PAUSED} and {@link #STOPPED}. If the simulation
 * engine is disposed the state {@link #DISPOSED} must be enabled, because
 * controllers often have a reference on the engine object and with the 
 * possibility to check the engine state (independent of state events) they
 * can remove this.
 * </p>
 * 
 * <p>
 * 	<b>Possible states:</b><br>
 * 	<ul>
 * 		<li>{@link #RUNNING}</li>
 * 		<li>{@link #PAUSED}</li>
 * 		<li>{@link #STOPPED}</li>
 * 		<li>{@link #DISPOSED}</li>
 * 	</ul>
 * </p>
 * 
 * @author Markus M�hlbrandt
 * @author Philipp Richter
 * 
 * @see ISimulationEngine#getSimulationState()
 */
public enum SimulationState {
	
	/**
	 * If the simulation is active and simulates the system this state must be
	 * choosen.
	 */
	RUNNING,
	
	/**
	 * If the simulation was active ({@link #RUNNING}) and is paused this state
	 * must be choosen.
	 */
	PAUSED,
	
	/**
	 * If the simulation is stopped or never started, so that the simulation must
	 * be initialized before the simulation can be started this state must be choosen.
	 */
	STOPPED,
	
	/**
	 * If the simulation engine is {@link #STOPPED} and shall be disposed now, so that
	 * all resources are cleared this state must be choosen. Note: The engine object
	 * can not be started again.
	 */
	DISPOSED
}

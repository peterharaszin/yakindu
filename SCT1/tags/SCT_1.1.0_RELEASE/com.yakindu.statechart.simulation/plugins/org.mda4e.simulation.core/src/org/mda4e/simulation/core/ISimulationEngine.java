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

import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.event.IEventListener;

/**
 * The interface <code>ISimulationEngine</code> defines the methods
 * of a simulation engine which allow to control the engine and to
 * read required engine informations.
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 * @author Benjamin Schwertfeger
 */
public interface ISimulationEngine extends IEventListener {
	
	/** The definition of the extension point. */
	public static final String ENGINE_EXTENSION_POINT = "org.mda4e.simulation.engine";
	
	/**
	 * Allows to set the simulation parameters which provide the needed informations for
	 * the engine. The parameters must be set before the engine can be initialized
	 * ({@link #initializeEngine()}).
	 * 
	 * @param simulationParameters	defines the required parameters of the engine for the simulation
	 * 
	 * @throws SimulationException	will be thrown, if the simulation engine is
	 * 								{@link SimulationState#DISPOSED DISPOSED}.
	 */
	public void setSimulationParameters(ISimulationParameterSet simulationParameters) throws SimulationException;
	
	/**
	 * Provides the defined simulation engine parameters by the method
	 * {@link #setSimulationParameters(ISimulationParameterSet)}.
	 * 
	 * @return 	The current simulation engine parameter set. If no parameter
	 * 			set could be found the result is <code>null</code>.
	 */
	public ISimulationParameterSet getSimulationParameters();
	
	/**
	 * Provides the name of this simulation engine. If the engine has
	 * no name the result is "".
	 * 
	 * @return The name of this engine.
	 */
	public String getEngineName();
	
	/**
	 * Provides the name of the system which is simulated by this simulation
	 * engine. In the normal case the name is only known when the simulation
	 * was initialized. 
	 * 
	 * @return  The name of the simulated system. If no name could be found
	 * 			the	result is "".
	 */
	public String getSystemName();
	
	/**
	 * Returns the instance number of the simulation engine. It is required, if more than
	 * one instance of the same system exists.
	 * 
	 * @return The instance number of the system if it exists, otherwise -1. 
	 */
	public int getInstanceNumber();
	
	/**
	 * Provides the current state of the simulation engine.
	 * 
	 * @return The result is the current state of the simulation engine.
	 * 
	 * @see SimulationState
	 */
	public SimulationState getSimulationState();
	
	/**
	 * Allows to add an event listener to receive all events which
	 * are sent by the simulation engine.
	 * 
	 * @param listener	defines the new listener of the simulation engine
	 */
	public void addEventListener(IEventListener listener);
	
	/**
	 * Removes the given <code>listener</code> from the listener list, so
	 * this listener gets no longer events of the simulation engine.
	 * 
	 * @param listener	defines the listener which shall be removed
	 */
	public void removeEventListener(IEventListener listener);
	
	/**
	 * Allows the simulation engine to initialize itself and the simulation
	 * system, so all needed resources can be reserved and all informations
	 * for {@link ISimulationController} can be loaded.
	 * 
	 * @throws SimulationException	will be thrown, if an error during the
	 * 								initialization occurs
	 */
	public void initializeEngine() throws SimulationException;
	
	/**
	 * Activates the simulation engine and the simulation is started
	 * continuously.
	 * 
	 * @throws SimulationException	will be thrown, if an error during
	 * 								the simulation occurs
	 */
	public void startSimulation() throws SimulationException;
	
	/**
	 * Activates the simulation engine and the simulation is started
	 * in the single step mode. In the single step mode the simulation
	 * engine starts only one step and holds
	 * ({@link SimulationState#PAUSED PAUSED}) after that.
	 * 
	 * @throws SimulationException	will be thrown, if an error during
	 * 								the simulation occurs
	 */
	public void singleStepForward() throws SimulationException;
	
	/**
	 * Signals the simulation engine that the simulation shall be paused.
	 * The simulation state will be changed to
	 * ({@link SimulationState#PAUSED PAUSED}).
	 * 
	 * @throws SimulationException	will be thrown, if an error during
	 * 								the measures to pause the simulation
	 * 								occurs
	 */
	public void pauseSimulation() throws SimulationException;
	
	/**
	 * Activates the simulation engine and the simulation is resumed
	 * continuously. This method is called, if the simulation is paused.
	 * 
	 * @throws SimulationException	will be thrown, if an error during
	 * 								the measures to resume the simulation
	 * 								occurs
	 */
	public void resumeSimulation() throws SimulationException;
	
	/**
	 * Stops the simulation. The simulation only can be restarted if the
	 * engine is initialized again.
	 *  
	 * @throws SimulationException	will be thrown, if an error during
	 * 								the measures to stop the simulation
	 * 								occurs
	 */
	public void stopSimulation() throws SimulationException;
	
	/**
	 * Clears all resources of the simulation engine and is called, if
	 * the engine is no longer needed.
	 * 
	 * @throws SimulationException	will be thrown, if an error occurs during
	 * 								the deletion of the engine
	 */
	public void disposeEngine() throws SimulationException;
	
} //ISimulationEngine

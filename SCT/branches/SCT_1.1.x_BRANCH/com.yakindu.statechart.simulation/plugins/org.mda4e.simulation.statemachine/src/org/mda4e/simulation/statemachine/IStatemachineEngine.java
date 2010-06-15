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

import java.util.List;
import java.util.Map;

import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;

import statemachine.Event;
import statemachine.State;
import statemachine.Statechart;
import statemachine.Variable;

/**
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 */
public interface IStatemachineEngine extends ISimulationEngine {
	
	/**
	 * Allows to define the statemachine engine specific parameters which provides
	 * the needed informations for the engine. The parameters must be set before
	 * the engine can be initialized ({@link #initializeEngine()}).
	 * 
	 * @param simulationParameters	defines the required parameters of the engine for the simulation
	 * 
	 * @throws SimulationException	will be thrown, if the simulation engine is
	 * 								{@link SimulationState#DISPOSED DISPOSED}.
	 */
	public void setSimulationParameters(IStatemachineParameterSet simulationParameters) throws SimulationException;
	
	/**
	 * Retrieves the UUID of the active statechart.
	 * 
	 * @return	The unique id of this statechart type. The uuid is the same for all statecharts
	 * 			from the same file. Returns "" if this statechart doesn't support any uuids.
	 */
	public String getUUID();
	
	/**
	 * Returns all active states of the current state configuration of the statemachine. It
	 * allows {@link ISimulationController} to synchronize their state. This method is
	 * analogical to {@link #sendActiveStates()} but it doesn't send events.
	 * 
	 * @return 	The list of all active states of the statemachine. If the statemachine is
	 * 			not available or not initialized the result is <code>null</code>.
	 * 
	 * @see State
	 */
	public List<State> getActiveStates();
	
	/**
	 * Retrieves all events of the statemachine which is simulated by this simulation
	 * engine. If the statemachine is not available or not initialized the result is
	 * <code>null</code>.
	 * 
	 * @return	Returns a <code>Map</code> with all events and their current state.
	 * 
	 * @see Event
	 */
	public Map<Event, Boolean> getEvents();
	
	/**
	 * Retrieves all variables of the statemachine which is simulated by this simulation
	 * engine. If the statemachine is not available or not initialized the result
	 * <code>null</code>.
	 * 
	 * @return	Returns a <code>Map</code> with all variables and their current value.
	 * 
	 * @see Variable
	 */
	public Map<Variable, Double> getVariables();
	
	/**
	 * Sends all events again which describe the current state of the statemachine. It allows
	 * {@link ISimulationController} to synchronize their state. This method is analogical to
	 * {@link #getActiveStates()} but it doesn't return the state configuration in form of a
	 * <code>Map</code>.
	 * 
	 * @return 	The result is <code>true</code>, if the sending was successful, if the engine
	 * 			is not ready the result is <code>false</code>. 
	 */
	public boolean sendActiveStates();
	
	/**
	 * Sets the given variable to the given value and returns <code>true</code>, if
	 * the update was successful. All variables can be queried before with the help
	 * of the method {@link #getVariables()}.
	 *  
	 * @param name		defines the name of the variable which shall be updated
	 * @param value		defines the new value of the given variable
	 * 
	 * @return	If the update was successful the result is <code>true</code>. If the engine is
	 * 			not ready, for example if the engine is disposed, the result is <code>false</code>.
	 * 
	 * @throws SimulationException	will be thrown, if an error occurs during the update of the
	 * 								variable. For example if the item could not be found.
	 */
	public boolean setItem(String name, Double value) throws SimulationException;
	
	/**
	 * Activates the given event returns <code>true</code>, if the process was successful. All
	 * events can be queried before with the help of the method {@link #getEvents()}.
	 * 
	 * @param name	defines the name of the event which shall be activated
	 * 
	 * @return	If the update was successful the result is <code>true</code>. The result is
	 * 			<code>false</code> if the item does not exist or cannot found.
	 * 
	 * @throws SimulationException	will be thrown, if an error occurs during the activation of the
	 * 								event. For example if the engine is disposed.
	 */
	public boolean fireEvent(String name) throws SimulationException;
	
	/**
	 * Provides the {@link Statechart} instance which is currently simulated by the simulation
	 * engine.
	 * 
	 * @return The <code>Statechart</code> instance which is currently simulated by the simulation
	 * 		   engine. For example, if the engine is not ready, the result is <code>null</code>. 
	 */
	public Statechart getStatechart();
	
} //IStatemachineEngine
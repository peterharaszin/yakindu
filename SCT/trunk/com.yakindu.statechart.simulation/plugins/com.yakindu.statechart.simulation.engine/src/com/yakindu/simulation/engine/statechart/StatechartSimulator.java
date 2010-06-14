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
package com.yakindu.simulation.engine.statechart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.IStatemachineEngine;
import org.mda4e.simulation.statemachine.IStatemachineParameterSet;

import statemachine.Event;
import statemachine.State;
import statemachine.Statechart;
import statemachine.Variable;

import com.yakindu.simulation.engine.statechart.engine.SCEngine;
import com.yakindu.simulation.engine.statechart.engine.SimulationParameterSet;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.nls.Messages;
import com.yakindu.simulation.engine.statechart.properties.PluginProperties;

/**
 * The class <code>StatechartSimulator</code> connects the simulator to the
 * mda4e project. All control statements of the coupled controllers and all
 * events for the coupled listeners are managed by this class.
 * 
 * @author Philipp Richter
 */
public class StatechartSimulator implements IStatemachineEngine {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(StatechartSimulator.class);

	/** Specifies the current simulation state. */
	private volatile SimulationState simulationState = null;

	/** Defines the dispatcher for simulation events. */
	private EventDispatcher eventDispatcher = null;

	/** Defines the engine for the simulation. */
	private SCEngine scEngine = null;

	/**
	 * Creates a new instance of this class.
	 */
	public StatechartSimulator() {

		eventDispatcher = new EventDispatcher();

		try {
			scEngine = new SCEngine(this);
		} catch (final ArgumentIsNullException e) {
			logException(e);
		}

		scEngine.addEventListener(this);

		setSimulationState(SimulationState.STOPPED);
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#addEventListener(org.mda4e.simulation.core.event.IEventListener)
	 */
	public void addEventListener(final IEventListener listener) {

		if (listener != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			eventDispatcher.addEventListener(listener);
		}
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#getActiveStates()
	 */
	public List<State> getActiveStates() {

		List<State> result = null;

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			result = scEngine.getActiveStates();
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#getEvents()
	 */
	public Map<Event, Boolean> getEvents() {

		Map<Event, Boolean> result = null;

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED
			&& scEngine.getEventList() != null) {

			result = new HashMap<Event, Boolean>();

			for (final Event event : scEngine.getEventList().keySet()) {
				result.put(event, scEngine.getEvent(event.getName()));
			}
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#getUUID()
	 */
	public String getUUID() {

		String result = null;

		if (scEngine != null && scEngine.getStatechart() != null
			&& getSimulationState() != SimulationState.DISPOSED) {

			result = scEngine.getStatechart().getUUID();
		}

		if (result == null) {
			result = "";
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#getEngineName()
	 */
	public String getEngineName() {

		String result = PluginProperties.project_name;

		if (result == null) {
			result = "";
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#getSimulationParameters()
	 */
	public ISimulationParameterSet getSimulationParameters() {

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			return scEngine.getSimulationParameterSet();
		}
		return null;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#getSimulationState()
	 */
	public SimulationState getSimulationState() {

		return simulationState;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#getSystemName()
	 */
	public String getSystemName() {

		String result = "";

		if (getSimulationState() != SimulationState.DISPOSED
			&& scEngine != null && scEngine.getStatechart() != null) {

			result = scEngine.getStatechart().getName();
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#getVariables()
	 */
	public Map<Variable, Double> getVariables() {

		Map<Variable, Double> result = null;

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED
			&& scEngine.getInputList() != null
			&& scEngine.getVariableList() != null
			&& scEngine.getOutputList() != null) {

			result = new HashMap<Variable, Double>();

			for (final Variable var : scEngine.getVariableList().keySet()) {
				result.put(var, scEngine.getVariable(var.getName()));
			}

			for (final Variable input : scEngine.getInputList().keySet()) {
				result.put(input, scEngine.getVariable(input.getName()));
			}

			for (final Variable output : scEngine.getOutputList().keySet()) {
				result.put(output, scEngine.getVariable(output.getName()));
			}
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#pauseSimulation()
	 */
	public void pauseSimulation() throws SimulationException {

		checkEngine();

		//setSimulationState(SimulationState.PAUSED);
		log.info("Pausing simulator...");

		scEngine.pause();
	}

	/**
	 * @see org.mda4e.simulation.core.event.IEventListener#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public void receiveEvent(final IEvent event) {

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED) {

			if (event != null) {

				if (event instanceof SimulationEvent) {
					final SimulationEvent simulationEvent = (SimulationEvent) event;
					if (simulationEvent.getEventType() == SimulationEventTypes.SimStart) {
						setSimulationState(SimulationState.RUNNING);
					} else if (simulationEvent.getEventType() == SimulationEventTypes.SimStop) {
						setSimulationState(SimulationState.STOPPED);
					} else if (simulationEvent.getEventType() == SimulationEventTypes.SimPause) {
						setSimulationState(SimulationState.PAUSED);
					} else if (simulationEvent.getEventType() == SimulationEventTypes.SimResume) {
						setSimulationState(SimulationState.RUNNING);
					} else if (simulationEvent.getEventType() == SimulationEventTypes.SimError) {

						// Stop the simulation
						setSimulationState(SimulationState.STOPPED);
						eventDispatcher.fireEvent(new SimulationEvent(
							SimulationEventTypes.SimStop,
							this));

						logException(simulationEvent.getException());
					}

					try {
						eventDispatcher.fireEvent(simulationEvent);
					} catch (final Exception e) {
						logException(e);
					}
				} else {

					try {
						eventDispatcher.fireEvent(event);
					} catch (final Exception e) {
						logException(e);
					}
				}
			} else {
				log.warn("An event was received which was \"null\"!");
			}
		} else {
			log.warn("The engine is disposed and no events can be fired: "
						+ event != null ? event.getClass().getSimpleName()
					: "event is null");
		}
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#removeEventListener(org.mda4e.simulation.core.event.IEventListener)
	 */
	public void removeEventListener(final IEventListener listener) {

		if (listener != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			eventDispatcher.removeEventListener(listener);
		}
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#resumeSimulation()
	 */
	public void resumeSimulation() throws SimulationException {

		checkEngine();

		setSimulationState(SimulationState.RUNNING);
		log.info("Starting simulator (resume)...");

		try {
			scEngine.startSimulation();
		} catch (final StatechartNotValid e) {
			createSimulationException(e);
		} catch (final ParserException e) {
			createSimulationException(e);
		} catch (final UnableToParseStatechart e) {
			createSimulationException(e);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		} catch (final SupportException e) {
			createSimulationException(e);
		}
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#sendActiveStates()
	 */
	public boolean sendActiveStates() {

		boolean result = false;

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			result = scEngine.sendActiveStates();
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#setSimulationParameters(org.mda4e.simulation.core.ISimulationParameterSet)
	 */
	public void setSimulationParameters(
			final ISimulationParameterSet simulationParameters)
			throws SimulationException {

		checkEngine();

		try {
			scEngine.setSimulationParameterSet((SimulationParameterSet) simulationParameters);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		} catch (final UnableToParseStatechart e) {
			createSimulationException(e);
		} catch (final Exception e) {
			createSimulationException(e);
		}
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#setSimulationParameters(org.mda4e.simulation.statemachine.IStatemachineParameterSet)
	 */
	public void setSimulationParameters(
			final IStatemachineParameterSet simulationParameters) {

		// TODO At the moment not needed
		// If engine specific parameter are required, this method have to be
		// implemented!
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#singleStepForward()
	 */
	public void singleStepForward() throws SimulationException {

		checkEngine();

		setSimulationState(SimulationState.RUNNING);
		log.info("Starting simulator (single step)...");

		try {
			scEngine.startSingleStep();
		} catch (final StatechartNotValid e) {
			createSimulationException(e);
		} catch (final ParserException e) {
			createSimulationException(e);
		} catch (final UnableToParseStatechart e) {
			createSimulationException(e);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		} catch (final SupportException e) {
			createSimulationException(e);
		}
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#startSimulation()
	 */
	public void startSimulation() throws SimulationException {

		checkEngine();

		setSimulationState(SimulationState.RUNNING);
		log.info("Starting simulator...");

		try {
			scEngine.startSimulation();
		} catch (final StatechartNotValid e) {
			createSimulationException(e);
		} catch (final ParserException e) {
			createSimulationException(e);
		} catch (final UnableToParseStatechart e) {
			createSimulationException(e);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		} catch (final SupportException e) {
			createSimulationException(e);
		}
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#stopSimulation()
	 */
	public void stopSimulation() throws SimulationException {

		checkEngine();

		scEngine.stop();
		// setSimulationState(SimulationState.STOPPED);
		log.info("Stopping simulator...");
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#fireEvent(java.lang.String)
	 */
	public boolean fireEvent(final String name) throws SimulationException {

		checkEngine();

		boolean result = false;

		try {
			result = scEngine.setEvent(name, true);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#setItem(java.lang.String,
	 *      java.lang.Double)
	 */
	public boolean setItem(final String name, final Double value)
			throws SimulationException {

		checkEngine();

		boolean result = false;

		try {
			result = scEngine.setItem(name, value);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#getInstanceNumber()
	 */
	public int getInstanceNumber() {

		int result = -1;

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			result = scEngine.getSCInstance();
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.statemachine.IStatemachineEngine#getStatechart()
	 */
	public Statechart getStatechart() {

		Statechart result = null;

		if (scEngine != null
			&& getSimulationState() != SimulationState.DISPOSED) {
			result = scEngine.getStatechart();
		}

		return result;
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#initializeEngine()
	 */
	public void initializeEngine() throws SimulationException {

		checkEngine();

		try {
			scEngine.initializeSimulator();
		} catch (final StatechartNotValid e) {
			createSimulationException(e);
		} catch (final ParserException e) {
			createSimulationException(e);
		} catch (final UnableToParseStatechart e) {
			createSimulationException(e);
		} catch (final ArgumentIsNullException e) {
			createSimulationException(e);
		} catch (final SupportException e) {
			createSimulationException(e);
		}
	}

	/**
	 * @see org.mda4e.simulation.core.ISimulationEngine#disposeEngine()
	 */
	public void disposeEngine() throws SimulationException {

		// TODO Correct disposing of all objects.

		checkEngine();

		// Clear resources
		scEngine.dispose();
		scEngine = null;

		eventDispatcher = null;

		// Marks as disposed
		setSimulationState(SimulationState.DISPOSED);
	}

	/**
	 * Changes the current simulation state to the given state.
	 * 
	 * @param state defines the new simulation state
	 */
	private void setSimulationState(final SimulationState state) {

		simulationState = state;
	}

	/**
	 * Allows to log the given exception and create a new
	 * <code>SimulationException</code> with the help of the given exception.
	 * Additionally, the event to stop the simulation will be sent at first.
	 * 
	 * @param exception defines the current occurred exception
	 * 
	 * @throws SimulationException this exception will be thrown at all time to
	 *             inform all listener
	 */
	private void createSimulationException(final Exception exception)
			throws SimulationException {

		receiveEvent(new SimulationEvent(SimulationEventTypes.SimStop, this));

		logException(exception);

		throw new SimulationException(this, exception.getMessage(), exception);
	}

	/**
	 * Allows to log an exception. If no appender for the logger can be found,
	 * the printStackTrace() method is called.
	 * 
	 * @param exception defines the exception which shall be logged
	 */
	private void logException(final Throwable exception) {

		if (!log.getAllAppenders().hasMoreElements()) {
			exception.printStackTrace();
		} else {
			log.error(exception.getMessage(), exception);
		}
	}

	/**
	 * Checks whether all resources are loaded, otherwise a
	 * {@link SimulationException} will be thrown.
	 * 
	 * @throws SimulationException will be thrown, if not all resources are
	 *             loaded
	 */
	private void checkEngine() throws SimulationException {

		if (getSimulationState() == SimulationState.DISPOSED
			|| scEngine == null) {
			throw new SimulationException(
				this,
				Messages.StatechartSimulator_enginedisposed);
		}
	}
}
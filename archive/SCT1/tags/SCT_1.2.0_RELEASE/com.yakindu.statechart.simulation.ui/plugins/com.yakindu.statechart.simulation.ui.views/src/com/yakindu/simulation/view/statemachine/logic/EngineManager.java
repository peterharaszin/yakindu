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
/**
 * 
 */
package com.yakindu.simulation.view.statemachine.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

import org.apache.log4j.Logger;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.statemachine.IStatemachineEngine;

import com.yakindu.simulation.view.statemachine.ViewController;

import statemachine.DataElement;
import statemachine.Event;
import statemachine.Variable;

/**
 * @author Philipp Richter
 * 
 */
public class EngineManager extends EventDispatcher implements IEventListener {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(EngineManager.class);

	/**
	 * 
	 * Defines the instance of the {@link ViewController} which provides events
	 * of all {@link ISimulationEngine}s.
	 */
	private ViewController controller = null;

	/**
	 * Defines the currently chosen engine.
	 */
	private IStatemachineEngine currentEngine = null;

	/**
	 * Indicates whether the active engine was changed since the last call of
	 * the method {@link #getActiveEngine()}.
	 */
	private boolean engineChanged = true;

	/** Needed to synchronize different methods of this class. */
	private Object syncObject = null;

	/**
	 * Creates an instance of this class.
	 */
	public EngineManager() {

		// Add this to view controller listeners to receive engine events
		controller = ViewController.getInstance();
		controller.addViewEventListener(this);

		syncObject = new Object();
	}

	/**
	 * Compares the given uuid and instance number with the uuid and instance
	 * number of the currently active engine.
	 * 
	 * @param uUID defines the unique identifier of the simulation system
	 * @param instance defines the instance number of the engine
	 * 
	 * @return The result is <code>true</code> if the both parameters are equal
	 *         to the parameters of the active engine, otherwise
	 *         <code>false</code>.
	 */
	public boolean compareEngines(String uUID, int instance) {

		boolean result = false;

		if (currentEngine != null && uUID.equals(currentEngine.getUUID())
			&& instance == currentEngine.getInstanceNumber()) {
			result = true;
		}

		return result;
	}

	public void receiveEvent(final IEvent event) {

		fireEvent(event);
	}

	/**
	 * Updates the value of the given <code>DataElement</code> of the currently
	 * active <code>ISimulationEngine</code>.
	 * 
	 * @param element defines the item of the engines simulation system
	 * @param value defines the new value of the item
	 * 
	 * @return The result is <code>true</code>, if the update was successful,
	 *         otherwise <code>false</code>.
	 * 
	 * @throws SimulationException will be thrown, if an error occurs during the
	 *             update of the variable. For example if the item could not be
	 *             found.
	 */
	public boolean setItem(final DataElement element, final Double value)
			throws SimulationException {

		if (currentEngine != null) {
			return currentEngine.setItem(element.getName(), value);
		}
		return false;
	}

	/**
	 * Returns the list with all currently known engines which are active and
	 * not disposed.
	 * 
	 * @return List with all currently known engines.
	 */
	private List<IStatemachineEngine> getEngineList() {

		synchronized (syncObject) {

			final SortedSet<IStatemachineEngine> engines =
					controller.getEngines();

			final List<IStatemachineEngine> result =
					new ArrayList<IStatemachineEngine>();

			for (final IStatemachineEngine statemachineEngine : engines) {
				result.add(statemachineEngine);
			}

			return result;
		}
	}

	/**
	 * Returns a list with the names of all currently known engines which are
	 * active and not disposed. The name is generated with the help of the
	 * method {@link ViewController#getEngineName(IStatemachineEngine)}.
	 * 
	 * @return List with all currently known engines.
	 */
	public List<String> getEngines() {

		synchronized (syncObject) {

			final SortedSet<IStatemachineEngine> engines =
					controller.getEngines();

			final List<String> result = new ArrayList<String>();

			for (final IStatemachineEngine engine : engines) {
				result.add(controller.getEngineName(engine));
			}

			return result;
		}
	}

	/**
	 * Changes the currently active engine to the given engine.
	 * 
	 * @param engineIndex defines the engine which is active. The index of all
	 *            engines is defined by the method {@link #getEngines()}.
	 * 
	 * @return The result is <code>false</code> if the <code>engineIndex</code>
	 *         is out of bounds.
	 */
	public boolean activateEngine(final int engineIndex) {

		boolean result = false;

		synchronized (syncObject) {

			currentEngine = null;

			if (engineIndex >= 0 && engineIndex < getEngineList().size()) {

				currentEngine = getEngineList().get(engineIndex);
				result = true;

			} else if (getEngineList().size() > 0) {
				currentEngine = getEngineList().get(0);
			}

			engineChanged = true;
		}

		return result;
	}

	/**
	 * Changes the currently active engine to the given engine.
	 * 
	 * @param engine defines the engine instance which shall be activated.
	 * 
	 * @return The result is <code>false</code> if the <code>engine</code>
	 *         does not exist.
	 */
	public boolean activateEngine(final IStatemachineEngine engine) {

		boolean result = false;

		synchronized (syncObject) {

			currentEngine = null;

			if (getEngineList().contains(engine)) {

				currentEngine = engine;
				result = true;

			} else if (getEngineList().size() > 0) {
				currentEngine = getEngineList().get(0);
			}

			engineChanged = true;
		}

		return result;
	}

	/**
	 * Provides <code>true</code> if the active engine was changed since the
	 * last call of the method {@link #getActiveEngine()}, otherwise
	 * <code>false</code>.
	 * 
	 * @return Returns <code>true</code> if another engine was selected.
	 */
	public boolean isEngineChanged() {

		synchronized (syncObject) {
			return engineChanged;
		}
	}

	/**
	 * Provides the engine instance which is currently active.
	 * 
	 * @return The index of the currently active engine. If currently no engine
	 *         is available or active the result is -1.
	 */
	public int getActiveEngine() {

		synchronized (syncObject) {

			int result = -1;

			checkEngine();

			if (currentEngine != null) {

				result = getEngineList().indexOf(currentEngine);

			} else {
				if (activateEngine(0)) {
					result = 0;
				}
			}

			return result;
		}
	}

	/**
	 * Checks if the currently active engine is not disposed. If the engine is
	 * disposed the field <code>currentEngine</code> is set to <code>null</code>
	 * .
	 */
	private void checkEngine() {

		if (currentEngine != null
			&& currentEngine.getSimulationState() == SimulationState.DISPOSED) {

			if (log.isDebugEnabled()) {
				log.debug("The currently active engine is disposed: "
							+ controller.getEngineName(currentEngine));
			}

			currentEngine = null;
		}
	}

	/**
	 * Reset the state of the method {@link #isEngineChanged()} to false.
	 */
	public void resetEngineChanged() {

		engineChanged = false;
	}

	/**
	 * Returns the <code>SimulationState</code> of the active engine.
	 * 
	 * @return The state of the simulation engine.
	 */
	public SimulationState getActiveEngineState() {

		synchronized (syncObject) {

			if (currentEngine != null) {
				return currentEngine.getSimulationState();
			}

			return SimulationState.DISPOSED;
		}
	}

	/**
	 * Retrieves all variables of the statemachine which is simulated by the
	 * active simulation engine. If the statemachine is not available or not
	 * initialized the result <code>null</code>.
	 * 
	 * @return Returns a <code>Map</code> with all variables and their current
	 *         value.
	 * 
	 * @see IStatemachineEngine#getVariables()
	 * @see Variable
	 */
	public Map<Variable, Double> getVariables() {

		Map<Variable, Double> result = null;

		synchronized (syncObject) {

			if (currentEngine != null) {
				result = currentEngine.getVariables();
			}

			if (result == null) {
				result = new HashMap<Variable, Double>();
			}

			return result;
		}
	}

	/**
	 * Retrieves all events of the statemachine which is simulated by the active
	 * simulation engine. If the statemachine is not available or not
	 * initialized the result is <code>null</code>.
	 * 
	 * @return Returns a <code>Map</code> with all events and their current
	 *         state.
	 * 
	 * @see Event
	 */
	public Map<Event, Boolean> getEvents() {

		Map<Event, Boolean> result = null;

		synchronized (syncObject) {

			if (currentEngine != null) {
				result = currentEngine.getEvents();
			}

			if (result == null) {
				result = new HashMap<Event, Boolean>();
			}

			return result;
		}
	}
}
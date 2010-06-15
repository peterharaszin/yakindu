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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;

import statemachine.DataElement;
import statemachine.Event;
import statemachine.State;
import statemachine.Statechart;
import statemachine.Variable;

import com.yakindu.simulation.engine.statechart.engine.utilities.DefaultEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ChangeConfigurationException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ObjectDisposedException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.PseudostateNotImplemented;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.SchedulerEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler;
import com.yakindu.simulation.engine.statechart.events.DynamicItemEvent;
import com.yakindu.simulation.engine.statechart.events.DynamicItemEvent.DynamicItemEventTypes;
import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * The class <code>SCSimulatorController</code> controls the life cycle of the
 * simulator ({@link SCSimulator}) and permits the initialization as well as the
 * starting in two different modes (continuous, single step). Furthermore, it is
 * possible to pause, stop and resume the simulation and change the mode of the
 * simulator during the simulation.
 * 
 * @author Philipp Richter
 */
public class SCSimulatorController extends EventDispatcher implements Runnable {

	/** Defines the instance to log informations and errors. */
	private static final Logger log =
			Logger.getLogger(SCSimulatorController.class);

	/** Instance of the <code>SCSimulator</code>, which realizes the simulation. */
	private SCSimulator simulator = null;

	/** Organizes all time based events. */
	private TimeEventScheduler scheduler = null;

	/** Used to implement the time based simulation with a specific interval. */
	private Condition schedulerCond = null;

	/** Helps to indicate whether the chosen scheduler interval is long enough. */
	private ReentrantLock schedulerLock = null;

	/**
	 * Specifies the mode of the simulation. If the variable is
	 * <code>true</code>, the simulation will be executed in single steps.
	 * Otherwise the simulation will be executed continuously to the end. A
	 * single step means that at most one state change will be performed.
	 */
	private volatile boolean singleStep = false;

	/** Indicates whether the simulator is initialized or not. */
	private volatile boolean initialized = false;

	/** Indicates that the simulation shall be paused. */
	private boolean pause = true;
	/** Indicates that the simulation is paused. */
	private volatile boolean paused = true;
	/** Indicates that the simulation is stopped. */
	private boolean stop = true;

	/** Defines the path to the statechart file. */
	private SimulationParameterSet parameterSet = null;

	/**
	 * Defines all time based events which are released to the ui. This allows
	 * the user to skip the time durations.
	 */
	private HashMap<DataElement, String> userTimeEvents = null;

	/**
	 * Defines the parent instance. It is required to instantiate an instance of
	 * the class {@link SimulationEvent} or {@link StatemachineEvent}.
	 */
	private ISimulationEngine parent = null;

	/** Defines the number of finished intervals during the simulation. */
	private long numberOfIntervals = 0;

	/**
	 * Defines the number of performance problems, if the
	 * <code>schedulerLock</code> was already locked.
	 */
	private long intervalProblems = 0;

	/**
	 * Creates an instance of this class with the given statechart file.
	 * 
	 * @param parent defines the parent engine which contains this object
	 * @param parameters defines the simulation parameter set which includes
	 *            informations about the state chart which shall be simulated
	 * 
	 * @throws ArgumentIsNullException will be thrown, if one of the arguments
	 *             is <code>null</code>
	 */
	public SCSimulatorController(final ISimulationEngine parent,
			final SimulationParameterSet parameters)
			throws ArgumentIsNullException {

		if (parent == null) {
			throw new ArgumentIsNullException(String.format(
				Messages.General_argumentisnull,
				"parent"));
		}

		if (parameters == null) {
			throw new ArgumentIsNullException(String.format(
				Messages.General_argumentisnull,
				"parent"));
		}

		if (parameters.getSimulationSystem() == null) {
			throw new ArgumentIsNullException(String.format(
				Messages.General_argumentisnull,
				"simulation system"));
		}

		this.parent = parent;
		this.parameterSet = parameters;

		scheduler = new TimeEventScheduler();
		scheduler.addEventListener(getSchedulerListener());
		schedulerLock = new ReentrantLock();
		schedulerCond = schedulerLock.newCondition();
		simulator = new SCSimulator(scheduler);
		userTimeEvents = new HashMap<DataElement, String>();
	}

	/**
	 * Checks whether the counter <code>intervalProblems</code> is greater than
	 * 0 and fires a particular warning message to the ui.
	 */
	private void checkIntervalProblems() {

		if (intervalProblems > 0) {

			fireEvent(new SimulationEvent(parent, String.format(
				Messages.SCSimulatorController_intervalproblem,
				intervalProblems,
				numberOfIntervals,
				NumberFormat.getPercentInstance().format(
					(double) intervalProblems / numberOfIntervals))));
		}
	}

	/**
	 * Provides a listener which notifies the object <code>notifyObj</code> if
	 * the current scheduler interval is left.
	 * 
	 * @return The scheduler listener.
	 */
	private IEventListener getSchedulerListener() {

		return new IEventListener() {

			public void receiveEvent(IEvent event) {

				if (event instanceof SchedulerEvent) {
					notifyConDiagnostic();
				}
			}
		};
	}

	/**
	 * Allows the adding of listeners.
	 * 
	 * @param listener defines the new listener
	 */
	@Override
	public void addEventListener(final IEventListener listener) {

		if (simulator != null) {
			super.addEventListener(listener);
			simulator.addEventListener(listener);
		}
	}

	/**
	 * Allows the remove an event listener from the controller.
	 * 
	 * @param listener defines the listener which shall be removed
	 */
	@Override
	public void removeEventListener(final IEventListener listener) {

		if (simulator != null) {
			super.removeEventListener(listener);
			simulator.removeEventListener(listener);
		}
	}

	/**
	 * This method calls the initialization method of the simulator. In this
	 * step, the simulator loads the statechart and verifies the support of the
	 * existing elements. Additional, the first state will defined.
	 * 
	 * @throws StatechartNotValid will be thrown, if the statechart is not valid
	 * @throws ParserException if an error occurs during the parsing or
	 *             interpreting of transition expressions, this exception will
	 *             be
	 * @throws UnableToParseStatechart will be thrown, if the statechart can not
	 *             be read or parsed
	 * @throws ArgumentIsNullException will be thrown, if the argument or a part
	 *             of it is "null"
	 * @throws SupportException if one or more elements of the statechart are
	 *             not supported, this exception will be thrown
	 * @throws ObjectDisposedException will be thrown, if the controller is
	 *             disposed
	 */
	public void init() throws StatechartNotValid, ParserException,
			UnableToParseStatechart, ArgumentIsNullException, SupportException,
			ObjectDisposedException {

		if (simulator == null) {
			throw new ObjectDisposedException(
				Messages.SCSimulatorController_disposed);
		}

		if (!simulator.isInitialized()) {

			// Initialize the simulator
			String path = parameterSet.getSimulationSystem().getAbsolutePath();
			if (path.endsWith("_diagram")){
				path = path.substring(0,path.length()-"_diagram".length());
			}
			simulator.initializeStatemachine(path);

			// Initialized the scheduler
			try {
				scheduler.setTimeScaling(parameterSet.getTimeScaling());
			} catch (IllegalArgumentException e) {
				throw new SupportException(e.getMessage(), e);
			}

			scheduler.setSchedulerInterval(parameterSet.getSchedulerInterval());

		} else {
			simulator.resetStatemachine();
		}

		initialized = true;
	}

	/**
	 * This method starts the simulation in the according mode.
	 */
	public void run() {

		if (simulator != null) {

			if (Thread.currentThread().getState() == Thread.State.RUNNABLE) {

				initializeSimulation();

				removeTimeEventTasks();

				// Differ the simulation mode
				if (singleStep) {

					try {

						// Resume all timers of time based event
						scheduler.startScheduler();

						// Next simulation step
						simulator.changeStateConfiguration();

						// Pause all timers of time based event
						scheduler.pauseScheduler();
						// simulator.pauseTimers();

						addTimeEventTasks();

					} catch (final ArgumentIsNullException e) {
						sendSimulationError(e);
					} catch (final PseudostateNotImplemented e) {
						sendSimulationError(e);
					} catch (final ChangeConfigurationException e) {
						sendSimulationError(e);
					} catch (final ParserException e) {
						sendSimulationError(e);
					} catch (final ObjectDisposedException e) {
						sendSimulationError(e);
					} finally {
						finalizeSimulation();
					}
				} else {

					try {

						// Starting the simulation
						simulation();

					} catch (final ArgumentIsNullException e) {
						sendSimulationError(e);
					} catch (final ParserException e) {
						sendSimulationError(e);
					} catch (final ChangeConfigurationException e) {
						sendSimulationError(e);
					} catch (final PseudostateNotImplemented e) {
						sendSimulationError(e);
					} catch (final ObjectDisposedException e) {
						sendSimulationError(e);
					} finally {
						finalizeSimulation();
					}
				}
			} else {
				log.warn("The simulation is already running! State: "
							+ Thread.currentThread().getState().toString());
			}
		} else {
			log
				.warn("The simulator is \"null\" and was disposed! The simulation cannot be started!");
			fireEvent(new SimulationEvent(parent, new ObjectDisposedException(
				Messages.SCSimulatorController_disposed)));
		}
	}

	/**
	 * If one or more time events are available, they are released as dynamic
	 * events. For example, if an time based event exist the user can fire this
	 * event and has not to wait until the duration is elapsed.
	 */
	private void addTimeEventTasks() {

		Set<String> timeEvents = scheduler.getTasks();

		for (String eventId : timeEvents) {

			StringBuffer eventName =
					new StringBuffer(Messages.SCSimulatorController_timeevent);
			eventName.append(" ");
			eventName.append(eventId);

			DataElement element = new DefaultEvent(eventName.toString());

			userTimeEvents.put(element, eventId);

			fireEvent(new DynamicItemEvent(
				DynamicItemEventTypes.Add,
				element,
				simulator.getUUID(),
				simulator.getInstance()));
		}
	}

	/**
	 * Removes all time events which were released as dynamic events.
	 */
	private void removeTimeEventTasks() {

		for (DataElement element : userTimeEvents.keySet()) {

			fireEvent(new DynamicItemEvent(
				DynamicItemEventTypes.Remove,
				element,
				simulator.getUUID(),
				simulator.getInstance()));
		}

		userTimeEvents.clear();
	}

	/**
	 * This method simulates the blocksystem over the hole time unless the
	 * simulation will be paused or stopped.
	 * 
	 * @throws PseudostateNotImplemented will be thrown, if a pseudo state has
	 *             not been implemented
	 * @throws ChangeConfigurationException if an error occurs during the state
	 *             configuration change process
	 * @throws ParserException if an error occurs during the parsing
	 * @throws ArgumentIsNullException if an argument is "null" this exception
	 *             will be thrown
	 * @throws ObjectDisposedException will be thrown, if the controller is
	 *             disposed
	 */
	private void simulation() throws ParserException, ArgumentIsNullException,
			ChangeConfigurationException, PseudostateNotImplemented,
			ObjectDisposedException {

		// Resume all timers of time based event
		scheduler.startScheduler();

		/*
		 * Carry out a continuous simulation till the final state is achieved or
		 * the simulation is interrupted.
		 */
		while (!simulator.isFinished() && !pause && !stop) {

			// Scheduler is used
			if (parameterSet.getSchedulerInterval() > 0) {

				try {

					schedulerLock.lock();

					try {

						simulator.changeStateConfiguration();
						// Thread.yield();

						if (!pause && !stop) {
							schedulerCond.await();
						}

					} finally {
						schedulerLock.unlock();
					}

				} catch (InterruptedException e) {
				}

				// Direct time event firing is used
			} else {
				simulator.changeStateConfiguration();
				Thread.yield();
			}
		}

		// Pause all timers of time based event
		if (pause) {
			scheduler.pauseScheduler();
			addTimeEventTasks();
		}
	}

	/**
	 * Sends simulation start or resume events.
	 */
	private void initializeSimulation() {

		if (simulator.isFinished() || stop) {
			fireEvent(new SimulationEvent(SimulationEventTypes.SimStart, parent));

			log.info("The simulation was started (single step = " + singleStep
						+ ").");
		} else {
			fireEvent(new SimulationEvent(
				SimulationEventTypes.SimResume,
				parent));

			log.info("The simulation is continued (single step = " + singleStep
						+ ").");
		}

		pause = false;
		paused = false;
		stop = false;
	}

	/**
	 * Sends simulation pause or simulation stop events.
	 */
	private void finalizeSimulation() {

		// If single step mode is active, the simulation will only paused.
		pause = true;

		if (simulator.isFinished() || stop) {

			// Report interval problems of the scheduler
			checkIntervalProblems();

			stop = true;
			initialized = false;
			fireEvent(new SimulationEvent(SimulationEventTypes.SimStop, parent));
			log.info("The simulation is stopped.");
		} else {
			fireEvent(new SimulationEvent(SimulationEventTypes.SimPause, parent));
			log.info("The simulation is paused (single step = " + singleStep
						+ ")!");
		}

		paused = true;
	}

	/**
	 * Sends and logs that an error is occurred during the simulation.
	 * 
	 * @param exception defines the the occurred exception which shall be sent
	 */
	private void sendSimulationError(final Exception exception) {

		// If an error is occurred the simulation will be stopped
		stop = true;

		fireEvent(new SimulationEvent(parent, exception));
	}

	/**
	 * @return The result is <code>true</code>, if the simulation mode is
	 *         active.
	 */
	public boolean isSimulationMode() {

		return !singleStep;
	}

	/**
	 * @return The result is <code>true</code>, if the single step mode is
	 *         active.
	 */
	public boolean isSingleStepMode() {

		return singleStep;
	}

	/**
	 * Pauses the simulation.
	 */
	public void pause() {

		if (simulator != null) {
			pause = true;
			simulator.notifySimulator();
			notifyController();

			if (log.isDebugEnabled()) {
				log.debug("Pause simulation...");
			}
		}
	}

	/**
	 * Notifies this engine controller instance and reports a performance
	 * problem, if the monitor of the <code>schedulerLock</code> already locked.
	 */
	private void notifyConDiagnostic() {

		numberOfIntervals++;

		if (schedulerLock.tryLock()) {

			try {
				schedulerCond.signal();
			} finally {
				schedulerLock.unlock();
			}
		} else {
			intervalProblems++;
		}
	}

	/**
	 * Notifies this engine controller instance with the help of the object
	 * <code>notifyObj</code>.
	 */
	private void notifyController() {

		schedulerLock.lock();

		try {
			schedulerCond.signal();
		} finally {
			schedulerLock.unlock();
		}
	}

	/**
	 * Stops the simulation.
	 */
	public void stop() {

		if (simulator != null) {

			stop = true;
			simulator.notifySimulator();
			notifyController();

			if (log.isDebugEnabled()) {
				log.debug("Stop simulation...");
			}

			// if paused -> send stop event
			if (paused) {
				finalizeSimulation();
			}
		}
	}

	/**
	 * Returns the instance number.
	 * 
	 * @return The instance number.
	 */
	public int getInstance() {

		if (simulator != null) {
			return simulator.getInstance();
		}
		return -1;
	}

	/**
	 * Sets the instance number.
	 * 
	 * @param instance defines instance number
	 * 
	 * @return The result is <code>true</code>, if the new instance number was
	 *         set, otherwise <code>false</code>.
	 */
	public boolean setInstance(final int instance) {

		if (simulator != null) {
			simulator.setInstance(instance);
			return true;
		}
		return false;
	}

	/**
	 * Set the simulation (continuous) mode.
	 */
	public void setSimulationMode() {

		singleStep = false;
		if (log.isDebugEnabled()) {
			log.debug("Simulation mode enabled");
		}
	}

	/**
	 * Sets the single step mode.
	 */
	public void setSingleStepMode() {

		singleStep = true;
		if (log.isDebugEnabled()) {
			log.debug("Single mode enabled");
		}
	}

	/**
	 * Returns a list with all active states of the current state configuration.
	 * 
	 * @return The result is a list with all active states of the current state
	 *         configuration.
	 */
	public List<State> getActiveStates() {

		if (simulator != null) {
			return simulator.getActiveStates();
		}
		return new ArrayList<State>();
	}

	/**
	 * This method provides the state of the simulator. If the simulator was
	 * already initialized the result is <code>true</code>.
	 * 
	 * @return <code>true</code> if the simulator is already initialized,
	 *         otherwise <code>false</code>.
	 */
	public boolean isInitialized() {

		return initialized;
	}

	/**
	 * @return Returns <code>true</code>, if the simulation is stopped. If the
	 *         simulation is stopped the simulation <b>can not be continued</b>.
	 */
	public boolean isStopped() {

		return stop && paused;
	}

	/**
	 * If the end state of the respective statemachine was activated, this
	 * method returns true.
	 * 
	 * @return The result is <code>true</code>, if the end state of the
	 *         statemachine is active, otherwise <code>false</code>.
	 */
	public boolean isFinished() {

		if (simulator != null) {
			return simulator.isFinished();
		}
		return false;
	}

	/**
	 * @return The result is <code>true</code>, if the simulation is paused.
	 */
	public boolean isPaused() {

		return paused;
	}

	/**
	 * Updates the value of the given item.
	 * 
	 * @param name defines the name of the item
	 * @param value defines the new value
	 * 
	 * @return The result is <code>true</code> if the update was successful,
	 *         otherwise <code>false</code>.
	 * 
	 * @throws ArgumentIsNullException this exception will be thrown, if an
	 *             argument or an attribute of it is <code>null</code>
	 */
	public boolean setItem(final String name, final Double value)
			throws ArgumentIsNullException {

		boolean result = false;
		DataElement element = null;

		for (DataElement dynamicElement : userTimeEvents.keySet()) {
			if (dynamicElement.getName().equals(name)) {
				element = dynamicElement;
			}
		}

		if (element != null) {

			result =
					scheduler.moveForwardTimeEvent(userTimeEvents.get(element));

			removeTimeEventTasks();

		} else {
			if (simulator != null) {
				result = simulator.setItem(name, value);
			}
		}
		return result;
	}

	/**
	 * Returns the value of the given variable of the current statemachine. The
	 * variable can be an input, output or a variable of the statechart.
	 * 
	 * @param name defines the name of the variable whose value shall be
	 *            returned
	 * 
	 * @return The value of the given variable, if the variable could not be
	 *         found, the result is <code>null</code>.
	 */
	public Double getVariable(final String name) {

		if (simulator != null) {
			return simulator.getVariable(name);
		}
		return null;
	}

	/**
	 * Returns the state of the given event of the current statemachine.
	 * 
	 * @param name defines the name of the event whose state shall be returned
	 * 
	 * @return The state of the given event, if the event could not be found,
	 *         the result is <code>false</code>.The result is <code>null</code>
	 *         if the controller is not initialized or is disposed.
	 */
	public Boolean getEvent(final String name) {

		if (simulator != null) {
			return simulator.getEvent(name);
		}
		return null;
	}

	/**
	 * Returns the list with all variables of the current statemachine.
	 * 
	 * @return The list of all inputs.
	 */
	public Map<Variable, Double> getVariableList() {

		if (simulator != null) {
			return simulator.getVariableList();
		}
		return new HashMap<Variable, Double>();
	}

	/**
	 * Returns the list with all inputs of the current statemachine.
	 * 
	 * @return The list of all inputs.
	 */
	public Map<Variable, Double> getInputList() {

		if (simulator != null) {
			return simulator.getInputList();
		}
		return new HashMap<Variable, Double>();
	}

	/**
	 * Returns the list with all outputs of the current statemachine.
	 * 
	 * @return The list of all outputs.
	 */
	public Map<Variable, Double> getOutputList() {

		if (simulator != null) {
			return simulator.getOutputList();
		}
		return new HashMap<Variable, Double>();
	}

	/**
	 * Returns the list with all events of the current statemachine.
	 * 
	 * @return The list of all inputs.
	 */
	public Map<Event, Boolean> getEventList() {

		if (simulator != null) {
			return simulator.getEventList();
		}
		return new HashMap<Event, Boolean>();
	}

	/**
	 * This method allows the de-/activation of an specific event of the current
	 * statemachine.
	 * 
	 * @param name defines the name of the event
	 * @param activate specifies whether the event shall be de-/activated
	 * 
	 * @return If the updating is successful the result is <code>true</code>. If
	 *         the event can't be found the result is <code>false</code>.
	 * 
	 * @throws ArgumentIsNullException this exception will be thrown, if an
	 *             argument or an attribute of it is <code>null</code>
	 */
	public boolean setEvent(final String name, final boolean activate)
			throws ArgumentIsNullException {

		if (simulator != null) {
			return simulator.setEvent(name, activate);
		}
		return false;
	}

	/**
	 * Provides the <code>Statechart</code> instance which is currently
	 * simulated by the simulation engine.
	 * 
	 * @return The <code>Statechart</code> instance which is currently simulated
	 *         by the simulation engine, if the instance is unknown the result
	 *         is <code>null</code>.
	 */
	public Statechart getStatechart() {

		if (simulator != null) {
			return simulator.getStatechart();
		}

		return null;
	}

	/**
	 * Clears all reserved resources.
	 */
	public void dispose() {

		if (simulator != null) {

			if (!isStopped()) {

				stop();

				while (!isStopped()) {
					Thread.yield();
				}
			}

			if (scheduler != null) {
				scheduler.dispose();
				scheduler = null;
			}

			simulator.dispose();
			simulator = null;
		}
	}
}
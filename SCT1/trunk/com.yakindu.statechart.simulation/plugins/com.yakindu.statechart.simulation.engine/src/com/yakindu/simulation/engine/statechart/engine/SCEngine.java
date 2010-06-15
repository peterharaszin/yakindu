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

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import statemachine.Event;
import statemachine.State;
import statemachine.Statechart;
import statemachine.Variable;

import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ObjectDisposedException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * The class <code>SCEngine</code> provides the methods to execute the simulator
 * in a separate daemon thread and secures the access of the simulator, so that
 * illegal accesses are not possible.
 * 
 * @author Philipp Richter
 */
public final class SCEngine extends EventDispatcher implements IEventListener {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(SCEngine.class);

	/**
	 * Defines the simulation parameters to configure the statechart simulator.
	 */
	private SimulationParameterSet parameterSet = null;
	/** Specifies whether a new parameter set was defined. */
	private boolean newParameterSet = false;

	/** Thread for the concurrent simulation. */
	private Thread simulatorThread = null;

	/**
	 * The instance of the <code>SCSimulatorController</code>, which realizes
	 * the simulation of the respective statechart.
	 */
	private SCSimulatorController simulator = null;

	/**
	 * Defines the parent instance. It is required to instantiate an instance of
	 * the class {@link SimulationEvent} or {@link StatemachineEvent}.
	 */
	private ISimulationEngine parent = null;

	/**
	 * Creates a new instance of <code>SCEngine</code>.
	 * 
	 * @param parent defines the parent of this object
	 * 
	 * @throws ArgumentIsNullException will be thrown, if the
	 *             <code>parent</code> is <code>null</code>
	 */
	public SCEngine(ISimulationEngine parent) throws ArgumentIsNullException {

		if (parent == null) {
			throw new ArgumentIsNullException(String.format(
				Messages.General_argumentisnull,
				"parent"));
		}

		this.parent = parent;
	}

	/**
	 * Method for accessing the instance of the underlying statechart.
	 * 
	 * @return The uuid of this kind of statecharts. For unique identification
	 *         the instance must be considered also. If the statechart doesn't
	 *         support any uuid, the value is "".
	 */
	public int getSCInstance() {

		if (simulator != null && parameterSet != null) {
			return parameterSet.getInstanceNumber();
		}

		return -1;
	}

	/**
	 * Provides the parameters of the current simulation which are defined by
	 * the user.
	 * 
	 * @return The parameter set of the simulation.
	 */
	public ISimulationParameterSet getSimulationParameterSet() {

		return parameterSet;
	}

	/**
	 * Sets the new simulation parameters.
	 * 
	 * @param simulationParameters defines the new parameter set
	 * 
	 * @throws ArgumentIsNullException will be thrown, if the parameter set or
	 *             an required parameter is <code>null</code>
	 * @throws UnableToParseStatechart if the statechart file does not exist
	 *             this exception will be thrown
	 */
	public void setSimulationParameterSet(
			final SimulationParameterSet simulationParameters)
			throws ArgumentIsNullException, UnableToParseStatechart {

		if (simulationParameters == null) {
			throw new ArgumentIsNullException(
				Messages.SCEngine_parametersnotset);
		}

		if (simulationParameters.getSimulationSystem() == null) {
			throw new ArgumentIsNullException(Messages.SCEngine_nostatechart);
		}
		
		File system = simulationParameters.getSimulationSystem();
		String path = system.getPath();
		if (path.endsWith("_diagram")){
			path = path.substring(0,path.length()-"_diagram".length());
			system = new File(path);
		}
		
		if (!system.exists()) {
			throw new UnableToParseStatechart(
				Messages.SCEngine_statechartfilenotexist
						+ " \""
						+ simulationParameters
							.getSimulationSystem()
							.getAbsolutePath() + "\".");
		}

		this.parameterSet = simulationParameters;
		newParameterSet = true;
	}

	/**
	 * Starts the simulation in the continuous mode.
	 * 
	 * @throws StatechartNotValid will be thrown, if the statechart is not valid
	 * @throws ParserException if an error occurs during the parsing or
	 *             interpreting of actions or expressions, this exception will
	 *             be thrown
	 * @throws UnableToParseStatechart will be thrown, if the statechart can not
	 *             be read or parsed
	 * @throws ArgumentIsNullException will be thrown, if the argument or a part
	 *             of it is "null"
	 * @throws SupportException if one or more elements of the statechart are
	 *             not supported, this exception will be thrown
	 */
	public void startSimulation() throws StatechartNotValid, ParserException,
			UnableToParseStatechart, ArgumentIsNullException, SupportException {

		initializeSimulator();

		if (simulator != null) {

			if (simulator.isPaused()) {

				if (simulatorThread != null && simulatorThread.isAlive()) {
					try {
						if (log.isDebugEnabled()) {
							log
								.debug("Wait until simulatorThread has been terminated (join): current time = "
										+ System.currentTimeMillis());
						}

						simulatorThread.join(2000);

						if (log.isDebugEnabled()) {
							log
								.debug("Waiting until simulatorThread has been terminated is finished: current time = "
										+ System.currentTimeMillis());
						}
					} catch (InterruptedException e) {
					}
				}

				// Change the mode if necessary
				if (simulator.isSingleStepMode()) {

					simulator.setSimulationMode();
					if (log.isDebugEnabled()) {
						log.debug("Changed to simulation mode");
					}
				}

				int threadPriority = Thread.currentThread().getPriority() - 1;
				if (threadPriority < 1) {
					threadPriority = 1;
				}

				simulatorThread =
						new Thread(simulator, SCSimulatorController.class
							.getSimpleName());
				simulatorThread.setDaemon(true);
				simulatorThread.setPriority(threadPriority);
				if (log.isDebugEnabled()) {
					log.debug("Starting the simulation...");
				}
				simulatorThread.start();

				/*
				 * Wait until the simulation is started to avoid wrong
				 * informations about the current state of the simulator, if the
				 * new created "simulatorThread" has not called the run() method
				 * of the simulator yet.
				 * 
				 * 
				 * ...simulatorThread.getState() != Thread.State.WAITING &&
				 * simulatorThread.getState() != Thread.State.BLOCKED... :
				 * 
				 * This condition is required to check that the thread is
				 * possibly waiting of this thread, so a dead lock is not
				 * possible.
				 */
				while (simulator.isPaused()
						&& simulatorThread.getState() != Thread.State.TERMINATED
						&& simulatorThread.getState() != Thread.State.WAITING
						&& simulatorThread.getState() != Thread.State.BLOCKED) {
					Thread.yield();
				}
			} else {
				log
					.warn("Simulation could not be started, because the simulation is not stopped or paused (Thread state: "
							+ simulatorThread.getState().toString() + ")!");
			}
		}
	}

	/**
	 * Starts the simulation in the specific mode.
	 * 
	 * @throws StatechartNotValid will be thrown, if the statechart is not valid
	 * @throws ParserException if an error occurs during the parsing or
	 *             interpreting of actions or expressions, this exception will
	 *             be thrown
	 * @throws UnableToParseStatechart will be thrown, if the statechart can not
	 *             be read or parsed
	 * @throws ArgumentIsNullException will be thrown, if the argument or a part
	 *             of it is "null"
	 * @throws SupportException if one or more elements of the statechart are
	 *             not supported, this exception will be thrown
	 */
	public void startSingleStep() throws StatechartNotValid, ParserException,
			UnableToParseStatechart, ArgumentIsNullException, SupportException {

		initializeSimulator();

		if (simulator != null) {

			if (simulator.isPaused()) {

				if (simulatorThread != null && simulatorThread.isAlive()) {
					try {
						if (log.isDebugEnabled()) {
							log
								.debug("Wait until simulatorThread has been terminated (join): current time = "
										+ System.currentTimeMillis());
						}

						simulatorThread.join(2000);

						if (log.isDebugEnabled()) {
							log
								.debug("Waiting until simulatorThread has been terminated is finished: current time = "
										+ System.currentTimeMillis());
						}
					} catch (InterruptedException e) {
					}
				}

				// Change the mode if necessary
				if (simulator.isSimulationMode()) {

					simulator.setSingleStepMode();
					if (log.isDebugEnabled()) {
						log.debug("Changed to single step mode");
					}
				}

				int threadPriority = Thread.currentThread().getPriority() - 1;
				if (threadPriority < 1) {
					threadPriority = 1;
				}

				simulatorThread =
						new Thread(simulator, SCSimulatorController.class
							.getSimpleName());
				simulatorThread.setDaemon(true);
				simulatorThread.setPriority(threadPriority);
				if (log.isDebugEnabled()) {
					log.debug("Starting single step simulation...");
				}
				simulatorThread.start();

				/*
				 * Wait until the simulation is started to avoid wrong
				 * informations about the current state of the simulator, if the
				 * new created "simulatorThread" has not called the run() method
				 * of the simulator yet.
				 * 
				 * 
				 * ...simulatorThread.getState() != Thread.State.WAITING &&
				 * simulatorThread.getState() != Thread.State.BLOCKED... :
				 * 
				 * This condition is required to check that the thread is
				 * possibly waiting of this thread, so a dead lock is not
				 * possible.
				 */
				while (simulator.isPaused()
						&& simulatorThread.getState() != Thread.State.TERMINATED
						&& simulatorThread.getState() != Thread.State.WAITING
						&& simulatorThread.getState() != Thread.State.BLOCKED) {
					Thread.yield();
				}
			} else {
				log
					.warn("Simulation could not be started, because the simulation is not stopped or paused (Thread state: "
							+ simulatorThread.getState().toString() + ")!");
			}
		}
	}

	/**
	 * Resets the simulator if it is required and initializes a new simulator.
	 * 
	 * @throws StatechartNotValid will be thrown, if the statechart is not valid
	 * @throws ParserException if an error occurs during the parsing or
	 *             interpreting of transition expressions, this exception will
	 *             be
	 * @throws UnableToParseStatechart will be thrown, if the statechart can not
	 *             be read or parsed
	 * @throws ArgumentIsNullException will be thrown, if the parameter set or a
	 *             part of it is <code>null</code>
	 * @throws SupportException if one or more elements of the statechart are
	 *             not supported, this exception will be thrown
	 */
	public void initializeSimulator() throws StatechartNotValid,
			ParserException, UnableToParseStatechart, ArgumentIsNullException,
			SupportException {

		if (parameterSet == null) {
			throw new ArgumentIsNullException(
				Messages.SCEngine_parametersnotset);
		}

		if (simulator == null || newParameterSet) {

			if (simulator != null && !simulator.isStopped()) {

				simulator.stop();

				while (!simulator.isStopped()) {
					Thread.yield();
				}
			}

			newParameterSet = false;

			simulator =
					new SCSimulatorController(parent, parameterSet);
			simulator.addEventListener(this);

			simulator.setInstance(parameterSet.getInstanceNumber());

			try {
				simulator.init();
			} catch (ObjectDisposedException e) {
				log
					.error("The simulator controller is disposed, but was new created (Exception is marked as not possible!)!");
				simulator = null;
			}
		}

		if (simulator.isFinished()
			|| (simulator.isStopped() && !simulator.isInitialized())) {

			try {
				simulator.init();
			} catch (ObjectDisposedException e) {
				log
					.error("The simulator controller is disposed, but is not null (Exception is marked as not possible!)!");
				simulator = null;
			}
		}
	}

	/**
	 * Indicates whether the simulation is stopped. In this case the simulation
	 * must be restarted and <b>cannot be continued</b>.
	 * 
	 * @return Returns <code>true</code> if the simulation is stopped, otherwise
	 *         <code>false</code>.
	 */
	public boolean isStopped() {

		if (simulator != null) {
			return simulator.isStopped();
		}

		return true;
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
	 * @return The result is <code>true</code>, if the simulation is paused or
	 *         the simulation was never started, otherwise <code>false</code>.
	 */
	public boolean isPaused() {

		if (simulator != null) {
			return simulator.isPaused();
		}

		return false;
	}

	/**
	 * @see org.mda4e.simulation.core.event.IEventListener#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public void receiveEvent(IEvent event) {

		if (simulator != null) {
			fireEvent(event);
		}
	}

	/**
	 * Pauses the simulation.
	 */
	public void pause() {

		if (simulator != null) {
			simulator.pause();
		}
	}

	/**
	 * Stops the simulation.
	 */
	public void stop() {

		if (simulator != null) {
			simulator.stop();
		}
	}

	/**
	 * Allows the synchronization of the active states. First, the simulation is
	 * paused before the active state events are sent. The simulation is then
	 * continued.
	 * 
	 * @return The result is <code>true</code> if all active states could be
	 *         sent, otherwise the result is <code>false</code>. Possibilities
	 *         are that the simulator is not initialized or the statechart is
	 *         not available.
	 */
	public boolean sendActiveStates() {

		boolean result = false;

		if (simulator != null && getStatechart() != null
			&& !simulator.isFinished() && !simulator.isStopped()) {

			Thread threadSendStates = new Thread("SendActiveStates") {

				public void run() {

					boolean resume = false;

					if (!simulator.isPaused()) {

						// After the synchronization the simulation has to be
						// continued
						resume = true;

						pause();
						if (log.isDebugEnabled()) {
							log
								.debug("SendActiveStates: Pausing the simulation...");
						}

						while (!simulator.isPaused()) {
							Thread.yield();
						}
					}

					if (log.isDebugEnabled()) {
						log
							.debug("SendActiveStates: Simulation is paused! Synchronize states...");
					}

					String uUID = simulator.getStatechart().getUUID();

					for (statemachine.State state : simulator.getActiveStates()) {
						fireEvent(new StatemachineEvent(
							StatemachineEventTypes.StateEnabled,
							state,
							uUID,
							parameterSet.getInstanceNumber()));
					}

					if (log.isDebugEnabled()) {
						log
							.debug("Synchronization finished. Continuing the simulation...");
					}

					if (simulator.isSimulationMode() && resume) {
						try {
							startSimulation();
						} catch (StatechartNotValid e) {
							receiveEvent(new SimulationEvent(parent, e));
						} catch (ParserException e) {
							receiveEvent(new SimulationEvent(parent, e));
						} catch (UnableToParseStatechart e) {
							receiveEvent(new SimulationEvent(parent, e));
						} catch (ArgumentIsNullException e) {
							receiveEvent(new SimulationEvent(parent, e));
						} catch (SupportException e) {
							receiveEvent(new SimulationEvent(parent, e));
						}
					}
				}
			};

			threadSendStates.setDaemon(true);
			threadSendStates.start();

			result = true;
		}

		return result;
	}

	/**
	 * Updates the value of the given item.
	 * 
	 * @param name defines the name of the item
	 * @param value defines the new value of the element
	 * 
	 * @return The result is <code>true</code> if the update was successful,
	 *         otherwise <code>false</code>.
	 * 
	 * @throws ArgumentIsNullException this exception will be thrown, if an
	 *             argument or an attribute of it is <code>null</code>
	 */
	public boolean setItem(String name, Double value)
			throws ArgumentIsNullException {

		if (simulator != null) {
			return simulator.setItem(name, value);
		}

		return false;
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
	public boolean setEvent(String name, boolean activate)
			throws ArgumentIsNullException {

		if (simulator != null) {
			return simulator.setEvent(name, activate);
		}

		return false;
	}

	/**
	 * Returns the list with all variables of the current statemachine.
	 * 
	 * @return The list of all variables. If the engine is not initialized or
	 *         already disposed the result is <code>null</code>.
	 */
	public Map<Variable, Double> getVariableList() {

		if (simulator != null) {
			return simulator.getVariableList();
		}

		return null;
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
	public Double getVariable(String name) {

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
	 *         the result is <code>false</code>. The result is <code>null</code>
	 *         if the engine is not initialized or is disposed.
	 */
	public Boolean getEvent(String name) {

		if (simulator != null) {
			return simulator.getEvent(name);
		}

		return null;
	}

	/**
	 * Returns the list with all inputs of the current statemachine.
	 * 
	 * @return The list of all inputs. If the engine is not initialized or
	 *         already disposed the result is <code>null</code>.
	 */
	public Map<Variable, Double> getInputList() {

		if (simulator != null) {
			return simulator.getInputList();
		}

		return null;
	}

	/**
	 * Returns the list with all outputs of the current statemachine.
	 * 
	 * @return The list of all outputs. If the engine is not initialized or
	 *         already disposed the result is <code>null</code>.
	 */
	public Map<Variable, Double> getOutputList() {

		if (simulator != null) {
			return simulator.getOutputList();
		}

		return null;
	}

	/**
	 * Returns the list with all events of the current statemachine.
	 * 
	 * @return The list of all events. If the engine is not initialized or
	 *         already disposed the result is <code>null</code>.
	 */
	public Map<Event, Boolean> getEventList() {

		if (simulator != null) {
			return simulator.getEventList();
		}

		return null;
	}

	/**
	 * Allows the synchronization of the active states. First, the simulation is
	 * paused before the active state events are sent. The simulation is then
	 * continued.
	 * 
	 * @return The result is a list with all active states in the current state
	 *         configuration. If the engine is not initialized or already
	 *         disposed the result is <code>null</code>.
	 */
	public List<State> getActiveStates() {

		if (simulator != null) {
			return simulator.getActiveStates();
		}

		return null;
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
					try {
						Thread.yield();
						Thread.sleep(20);
					} catch (InterruptedException e) {
					}
				}
			}

			simulator.dispose();
			simulator = null;
		}

	}
}
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
package org.mda4e.simulation.core.event;

import org.mda4e.simulation.core.ISimulationEngine;

/**
 * <p>
 * <code>SimulationEvent</code> makes types available which allow to describe
 * the simulation engine and the simulation state.
 * </p>
 * <p>
 * Note: All event types beginning with "Engine..." are sent by the instance
 * which instantiates the simulation engine. All "Sim..." types are sent by the
 * engine itself.
 * </p>
 * <p>
 * <ul>
 * <li>{@link SimulationEventTypes#EngineCreated EngineCreated}</li>
 * <li>{@link SimulationEventTypes#SubEngineCreated SubEngineCreated}</li>
 * <li>{@link SimulationEventTypes#EngineInitialized EngineInitialized}</li>
 * <li>{@link SimulationEventTypes#SubEngineInitialized SubEngineInitialized}</li>
 * <li>{@link SimulationEventTypes#SimStart SimStart}</li>
 * <li>{@link SimulationEventTypes#SimPause SimPause}</li>
 * <li>{@link SimulationEventTypes#SimResume SimResume}</li>
 * <li>{@link SimulationEventTypes#SimStop SimStop}</li>
 * <li>{@link SimulationEventTypes#SimError SimError}</li>
 * <li>{@link SimulationEventTypes#EngineDisposed EngineDisposed}</li>
 * <li>{@link SimulationEventTypes#SubEngineDisposed SubEngineDisposed}</li>
 * </ul>
 * </p>
 * <p>
 * The normal life cycle of an engine can be described as follows:
 * 
 * <ol>
 * <li><b>EngineCreated</b> or SubEngineCreated</li>
 * <li><b>EngineInitialized</b> or SubEngineInitialized</li>
 * <li><b>SimStart</b></li>
 * <li>e.g.: SimPause</li>
 * <li>e.g.: SimResume</li>
 * <li><b>SimStop</b></li>
 * <li><b>EngineDisposed</b> or SubEngineDisposed</li>
 * </ol>
 * </p>
 * <p>
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 */
public class SimulationEvent implements IEvent {

	/**
	 * Defines the possible event types of the <code>SimulationEvent</code>.
	 * <p>
	 * <ul>
	 * <li>{@link #EngineCreated}</li>
	 * <li>{@link #SubEngineCreated}</li>
	 * <li>{@link #EngineInitialized}</li>
	 * <li>{@link #SubEngineInitialized}</li>
	 * <li>{@link #SimStart}</li>
	 * <li>{@link #SimPause}</li>
	 * <li>{@link #SimResume}</li>
	 * <li>{@link #SimStop}</li>
	 * <li>{@link #SimWarn}</li>
	 * <li>{@link #SimError}</li>
	 * <li>{@link #EngineDisposed}</li>
	 * <li>{@link #SubEngineDisposed}</li>
	 * </ul>
	 * </p>
	 * 
	 * @author Markus M�hlbrandt
	 * @author Philipp Richter
	 * 
	 * @see SimulationEvent
	 */
	public enum SimulationEventTypes {
		/**
		 * Indicates that a simulation was started and the chosen engine was
		 * created, for example by the "Run Configurations..." dialog. The event
		 * is sent by the instance which instantiates the simulation engine.
		 */
		EngineCreated,

		/**
		 * Sub engines are needed, if the system which shall be simulated
		 * contains sub systems of other types. For example, if a blocksystem
		 * contains statecharts the topmost engine which simulates the
		 * blocksystem instantiates for all statecharts a sub engine which
		 * simulates only the respective statechart.
		 * 
		 * @see SimulationEventTypes#EngineCreated
		 */
		SubEngineCreated,

		/**
		 * After the engine was created, it gets the possibility of reserving
		 * resources and analyzing the system which shall be simulated (for
		 * example, to create the sub engines). If the engine is initialized,
		 * this event type can be sent.
		 */
		EngineInitialized,

		/**
		 * This type is sent, if the sub engine is initialized. For more
		 * informations see {@link SimulationEventTypes# EngineInitialized}.
		 */
		SubEngineInitialized,

		/**
		 * If the simulation was started by an instance of
		 * <code>ISimulationController</code> or by a higher engine the engine
		 * sends this event type.
		 */
		SimStart,

		/**
		 * If the simulation is paused by <code>ISimulationController
		 * </code> or a higher engine the engine
		 * sends this event type.
		 */
		SimPause,

		/**
		 * If the engine is paused and was started again, this event type is
		 * sent by the engine.
		 */
		SimResume,

		/**
		 * If the simulation is finished or a controller or a higher engine
		 * stops the simulation this event type is sent. If the simulation is
		 * stopped, it can not be continued. Before the simulation can be
		 * started once more, the engine must be initialized again.
		 */
		SimStop,

		/**
		 * This type allows an engine to create a warning message to inform the
		 * user about a problem which is not critical for the simulation. For
		 * example, it can be used if conditions which are configured by the
		 * user could not be kept.
		 */
		SimWarn,

		/**
		 * In some situations an exception throw is not possible, for example if
		 * the error occurs in a thread. In these situations an event with the
		 * event type <code>SimError</code> and the Exception can be sent. If a
		 * <code>SimError</code> event occurs the simulation must be stopped by
		 * the engine itself, because this event type signals that the
		 * simulation had to be stopped because of the error. So the simulation
		 * engine must send the {@link #SimStop} event at first and then the
		 * <code>SimError</code> event with the respective exception.
		 */
		SimError,

		/**
		 * After the simulation was finished or stopped, it can be disposed by
		 * the instance which has instantiated the simulation engine.
		 */
		EngineDisposed,

		/**
		 * If the topmost engine which was not instantiated by another engine is
		 * disposed, all sub engines of this engine are disposed, too. If a sub
		 * engine has again sub engines, this sub engine has to dispose its sub
		 * engines, and so on. In this case, the <code>SubEngineDisposed
		 * </code> event type will be sent
		 * by the respective higher engine.
		 */
		SubEngineDisposed
	}

	/**
	 * Defines the event type of this event.
	 * 
	 * @see SimulationEventTypes
	 */
	private SimulationEventTypes eventType = null;

	/**
	 * Indicates the simulation engine instance why this
	 * <code>SimulationEvent</code> is triggered.
	 * 
	 * @see ISimulationEngine
	 */
	private ISimulationEngine simulationEngine = null;

	/**
	 * Defines the exception, if the {@link SimulationEventTypes#SimError} event
	 * type is sent.
	 */
	private Exception exception = null;

	/**
	 * Instantiates a new <code>SimulationEvent</code> object with the specified
	 * <code>eventType</code> and without an exception declaration.
	 * 
	 * <p>
	 * <b>NOTE:</b> The parameters <b>must not</b> be <code>null</code>.
	 * </p>
	 * 
	 * @param eventType defines the type of this event (
	 *            {@link SimulationEventTypes})
	 * @param simulationEngine defines the instance to which the event refers
	 * 
	 * @throws NullPointerException will be thrown if one of the parameters is
	 *             <code>null</code>
	 */
	public SimulationEvent(SimulationEventTypes eventType,
			ISimulationEngine simulationEngine) {

		if (eventType == null) {
			throw new NullPointerException(
				"The argument \"eventType\" must not be \"null\"!");
		}

		if (simulationEngine == null) {
			throw new NullPointerException(
				"The argument \"simulationEngine\" must not be \"null\"!");
		}

		this.eventType = eventType;
		this.simulationEngine = simulationEngine;
	}

	/**
	 * Instantiates a new <code>SimulationEvent</code> object with the event
	 * type {@link SimulationEventTypes#SimError} and the specified exception
	 * declaration.
	 * 
	 * <p>
	 * <b>NOTE:</b> The parameters <b>must not</b> be <code>null</code> and the
	 * exception should include a <b>meaningful</b> message.
	 * </p>
	 * 
	 * @param simulationEngine defines the instance to which the event refers
	 * @param warning defines the warning message
	 * 
	 * @throws NullPointerException will be thrown if the engine is
	 *             <code>null</code>
	 */
	public SimulationEvent(ISimulationEngine simulationEngine, String warning) {

		if (simulationEngine == null) {
			throw new NullPointerException(
				"The argument \"simulationEngine\" must not be \"null\"!");
		}

		if (warning == null) {
			throw new NullPointerException(
				"The argument \"warning\" must not be \"null\"!");
		}

		this.simulationEngine = simulationEngine;
		this.eventType = SimulationEventTypes.SimWarn;
		this.exception = new Exception(warning);
	}

	/**
	 * Instantiates a new <code>SimulationEvent</code> object with the event
	 * type {@link SimulationEventTypes#SimError} and the specified exception
	 * declaration.
	 * 
	 * <p>
	 * <b>NOTE:</b> The parameters <b>must not</b> be <code>null</code> and the
	 * exception should include a <b>meaningful</b> message.
	 * </p>
	 * 
	 * @param simulationEngine defines the instance to which the event refers
	 * @param exception defines the thrown exception
	 * 
	 * @throws NullPointerException will be thrown if the engine is
	 *             <code>null</code>
	 */
	public SimulationEvent(ISimulationEngine simulationEngine,
			Exception exception) {

		if (simulationEngine == null) {
			throw new NullPointerException(
				"The argument \"simulationEngine\" must not be \"null\"!");
		}

		if (exception == null) {
			exception =
					new Exception(
						"An unknown error is occurred! The simulation engine could not specify the reason for the exception occurrence!");
		}

		this.eventType = SimulationEventTypes.SimError;
		this.simulationEngine = simulationEngine;
		this.exception = exception;
	}

	/*
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public ISimulationEngine getSource() {

		return simulationEngine;
	}

	/**
	 * Returns the specified {@link SimulationEventTypes} which indicates the
	 * kind of this event.
	 * 
	 * @return The <code>SimulationEventTypes</code> of this event.
	 */
	public SimulationEventTypes getEventType() {

		return eventType;
	}

	/**
	 * Provides the declared exception which is not <code>null</code>, if the
	 * event is {@link SimulationEventTypes#SimError}.
	 * 
	 * @return The declared exception which was thrown within the
	 *         {@link ISimulationEngine}.
	 */
	public Exception getException() {

		return exception;
	}
}
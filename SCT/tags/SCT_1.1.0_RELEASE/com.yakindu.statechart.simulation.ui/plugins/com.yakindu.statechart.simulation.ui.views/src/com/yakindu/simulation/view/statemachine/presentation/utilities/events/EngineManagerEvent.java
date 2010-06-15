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
package com.yakindu.simulation.view.statemachine.presentation.utilities.events;

import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.event.IEvent;

import com.yakindu.simulation.view.statemachine.logic.EngineManager;

/**
 * This event is used by the {@link EngineManager} to inform all listeners about
 * the change of the available {@link ISimulationEngine}s. The possible event
 * types are defined by {@link EngineManagerEventTypes}.
 * 
 * @author Philipp Richter
 */
public class EngineManagerEvent implements IEvent {

	/**
	 * Provides all possible event types of the {@link EngineManager}.
	 * 
	 * @author Philipp Richter
	 */
	public enum EngineManagerEventTypes {

		/** Indicates that an engine was started. */
		EngineStarted,
		/** Indicates that an engine was stopped. */
		EngineStopped,
		/**
		 * Indicates that the list with all currently available engines was
		 * changed.
		 */
		EngineListChanged
	}

	/**
	 * Defines the {@link EngineManager} which has sent this event.
	 */
	private EngineManager manager = null;

	/**
	 * Defines the type of this event.
	 * 
	 * @see EngineManagerEventTypes
	 */
	private EngineManagerEventTypes type = null;

	/**
	 * Creates a new event instance with the given event type.
	 * 
	 * @param type defines the type of this event.
	 * @param manager defines the {@link EngineManager} which sends this event
	 * 
	 * @see EngineManagerEventTypes
	 */
	public EngineManagerEvent(final EngineManagerEventTypes type,
			final EngineManager manager) {

		this.type = type;
		this.manager = manager;
	}

	/**
	 * Provides the type of this event which indicates why this event was sent.
	 * 
	 * @return The type of this event.
	 */
	public EngineManagerEventTypes getType() {

		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {

		return manager;
	}

}
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
package com.yakindu.simulation.engine.statechart.events;

import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

/**
 * This event provides additional possibilities to control the simulation
 * engine. A dynamic item means an event or variable which can be handled in
 * addition to the defined events and variables of the statechart. For example,
 * an event which represents a specific time event (after) can be publicized.
 * Now the user has the possibility to fire this event and has not to wait until
 * the event is fired by the simulation.
 * 
 * @author Philipp Richter
 */
public class DynamicItemEvent implements IEvent {

	/**
	 * Defines the possible types of the {@link DynamicItemEvent}.
	 * 
	 * <p>
	 * <b>Supported Types:</b>
	 * <ul>
	 * <li>{@link #Add}</li>
	 * <li>{@link #Remove}</li>
	 * </ul>
	 * <p>
	 * 
	 * @author Philipp Richter
	 */
	public enum DynamicItemEventTypes {

		/**
		 * Indicates that the given item shall be added to the existing items.
		 */
		Add,

		/**
		 * Indicates that the given item shall be removed.
		 */
		Remove
	};

	/**
	 * Defines the type of this event and indicates what shall be done with the
	 * given item ({@link #getSource()}).
	 */
	private final DynamicItemEventTypes eventType;

	/**
	 * Defines the object whose state was changed. For example, if a variable
	 * value was changed, the variable is source object.
	 */
	private final Object source;

	/**
	 * Indicates the unique identifier of the statechart which contains the
	 * current source object.
	 */
	protected String uUID = null;

	/**
	 * Indicates the instance number of the statechart. This is required, if
	 * more than one instance of the same statechart in one simulation engine
	 * exists.
	 */
	protected int instance = -1;

	/**
	 * Creates an instance of <code>StatemachineEvent</code> with the given
	 * properties.
	 * 
	 * @param eventType specifies the {@link StatemachineEventTypes}
	 * @param source defines the object whose state was changed. For example, if
	 *            a variable value was changed, the variable is source object.
	 * @param UUID defines the unique identifier of the statechart, which
	 *            contains the <code>source</code> object
	 * @param instance indicates the instance number, if more than one instance
	 *            of the same statechart in one simulation engine exists.
	 * 
	 * @throws NullPointerException will be thrown if one of the parameters is
	 *             <code>null</code>
	 */
	public DynamicItemEvent(final DynamicItemEventTypes eventType, final Object source,
			final String UUID, final int instance) {

		this.eventType = eventType;
		this.source = source;
		this.uUID = UUID;
		this.instance = instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {

		return source;
	}

	/**
	 * Provides the event type of this event.
	 * 
	 * @return The event type.
	 */
	public DynamicItemEventTypes getEventType() {

		return eventType;
	}

	/**
	 * Provides the unique identifier of the statechart which is simulated by
	 * the simulation engine.
	 * 
	 * @return The uuid of the simulation system.
	 */
	public String getUUID() {

		return uUID;
	}

	/**
	 * Provides the instance number of the simulation. It is needed, if more
	 * than one instances of the same statechart are simulated by the simulation
	 * engine.
	 * 
	 * @return The instance number of the simulation system.
	 */
	public int getInstance() {

		return instance;
	}
}
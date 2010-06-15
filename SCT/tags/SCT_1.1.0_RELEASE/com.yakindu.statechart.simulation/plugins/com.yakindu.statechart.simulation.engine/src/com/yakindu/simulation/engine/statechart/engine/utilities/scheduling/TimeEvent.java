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
package com.yakindu.simulation.engine.statechart.engine.utilities.scheduling;

import org.mda4e.simulation.core.event.IEvent;

/**
 * The <code>TimeEvent</code> is used to indicate that a time event task is
 * elapsed.
 * 
 * @author Philipp Richter
 */
public class TimeEvent implements IEvent {

	/** Defines the unique identifier of this task. */
	private String id = null;

	/**
	 * Creates an instance of this class with the specified parameters.
	 * 
	 * @param id defines the unique identifier of the time event
	 */
	public TimeEvent(final String id) {//, long duration) {

		this.id = id;

	}

	/**
	 * Provides the unique identifier of the time event.
	 * 
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {

		return id;
	}
}

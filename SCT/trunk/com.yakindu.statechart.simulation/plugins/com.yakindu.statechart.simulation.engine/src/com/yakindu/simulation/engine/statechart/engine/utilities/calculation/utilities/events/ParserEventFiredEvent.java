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
package com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events;

import org.mda4e.simulation.core.event.IEvent;

/**
 * This event allows to inform listeners about a event which was fired 
 * by <code>send()</code>.
 * 
 * @author Philipp Richter
 */
public class ParserEventFiredEvent implements IEvent {

	/** Defines the name of the fired event. */
	private String event = null;
	
	/**
	 * @param event		defines the fired event
	 */
	public ParserEventFiredEvent(String event) {
		this.event  = event;
	}
	
	/**
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {
		return event;
	}
}

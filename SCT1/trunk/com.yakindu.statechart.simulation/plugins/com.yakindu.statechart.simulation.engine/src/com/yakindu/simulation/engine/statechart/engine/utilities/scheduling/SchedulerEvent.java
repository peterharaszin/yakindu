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
 * The {@link TimeEventScheduler} use this event to signal that the one
 * scheduler interval is left and all time events which are activated during
 * this interval were fired. This event is the last event of one interval!
 * 
 * @author Philipp Richter
 */
public class SchedulerEvent implements IEvent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {

		return null;
	}

}

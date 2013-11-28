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

import org.mda4e.simulation.core.event.IEventListener;

/**
 * @author Philipp Richter
 * 
 */
public interface ITimeEventScheduler {

	/**
	 * Creates a new timer task with the given <code>id</code> and the defined
	 * <code>duration</code>.
	 * 
	 * @param id defines the unique identifier of the timer task
	 * @param duration defines the duration of the task in milliseconds
	 * 
	 * @return The result is <code>true</code> if the task does not already
	 *         exist.
	 * 
	 * @throws IllegalArgumentException will be thrown, if the duration with
	 *             respect to the time scaling is greater than
	 *             {@link Long#MAX_VALUE}
	 */
	public boolean addTimeEventTask(final String id, final double duration)
			throws IllegalArgumentException;

	/**
	 * Removes the timer task with the given <code>id</code>.
	 * 
	 * @param id defines the unique identifier of the timer task
	 * 
	 * @return The result is <code>true</code> if the task could be deleted,
	 *         otherwise for example if no task could be found or the task is
	 *         already elapsed, the result is <code>false</code>.
	 */
	public boolean removeTimeEventTask(final String id);

	/**
	 * Registers the <code>IEventListener</code> as an observer.
	 * 
	 * @param listener defines the new observer
	 */
	public void addEventListener(IEventListener listener);

	/**
	 * Removes the registered <code>IEventListener</code>. The listener The
	 * observer gets no more events.
	 * 
	 * @param listener defines the listener which shall be removed
	 */
	public void removeEventListener(IEventListener listener);
}

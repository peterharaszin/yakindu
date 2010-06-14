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

import java.util.TimerTask;

/**
 * Defines a task for a time event which has an unique identifier and a specific
 * duration. Additionally, this class references to the particular
 * <code>TimerTask</code> which executes this task. The start time allows to
 * restart this task with respect to the elapsed time.
 * 
 * @author Philipp Richter
 */
public class TimeEventTask {

	/** Defines the unique identifier of this task. */
	private String id = null;
	/** Defines the delay of the time event. */
	private double duration = 0;
	/** Defines the start time which indicates when the task was started. */
	private long startTime = -1;
	/**
	 * References to the <code>TimerTask</code> object which executes this time
	 * event.
	 */
	private TimerTask timerTask = null;

	/**
	 * Creates a new instance of this class with the given parameters.
	 * 
	 * @param id defines the unique identifier of the time event task
	 * @param duration defines the delay of the time event
	 * @param startTime defines the point in time when this time event was
	 *            defined. It is required if the <code>TimerTask</code> shall be
	 *            restarted with respect to the elapsed time.
	 */
	public TimeEventTask(final String id, final double duration, final long startTime) {

		this.id = id;
		this.duration = duration;
		this.startTime = startTime;
	}

	/**
	 * Provides the start time when this task was defined.
	 * 
	 * @return The defined start time of this time event.
	 */
	public long getStartTime() {

		return startTime;
	}

	/**
	 * Provides the unique identifier of this task.
	 * 
	 * @return The id of this time event.
	 */
	public String getId() {

		return id;
	}

	/**
	 * Provides the delay of this time event task.
	 * 
	 * @return The time event delay.
	 */
	public double getDuration() {

		return duration;
	}

	/**
	 * Defines the <code>TimerTask</code> of this time event which executes this
	 * time event.
	 * 
	 * @param timerTask defines the <code>TimerTask</code>
	 */
	public void setTimerTask(final TimerTask timerTask) {

		this.timerTask = timerTask;
	}

	/**
	 * Provides the <code>TimerTask</code> of this time event.
	 * 
	 * @return The <code>TimerTask</code> which executes this time event.
	 */
	public TimerTask getTimerTask() {

		return timerTask;
	}
}
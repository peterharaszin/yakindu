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

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.mda4e.simulation.core.event.EventDispatcher;

import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * The scheduler manage time event tasks and fires the particular event, if the
 * duration has passed (and the event is activated).
 * 
 * <p>
 * If an interval greater than zero is defined, the time events which are
 * activated during the scheduler waits are fired if the scheduler is activated
 * the next time (after the current interval is elapsed).
 * </p>
 * 
 * <p>
 * <b>Two modes are possible:</b>
 * <ul>
 * <li>With time scaling: It is possible to define a scaling factor which allows
 * to reduce or increase the time event durations. For more informations see
 * {@link #setTimeScaling(double)}.</li>
 * <li>Without time scaling: The default value of time scaling is 1.0 and the
 * durations are used how they were defined. It is therefore also possible to
 * define the scaling factor with the help of the duration of the outside.
 * </ul>
 * </p>
 * 
 * <p>
 * <b>Example of the use of the time scaling:</b>
 * 
 * <pre>
 * 1. Schedule 1ms in real-time as 1s in schedule time:
 * 
 *   time scaling = 0.001 (1ms real-time = 1s scheduler time)
 *   time event duration = 10ms (real-time)
 *   
 *   time event firing = time event duration / time scaling
 *                     = 10ms / 0.001
 *                     = 10000ms
 *                     = 10s
 *                     
 * 2. Schedule 1ms in real-time as 1 microsecond in schedule time:
 * 
 *   time scaling = 1000 (1ms real-time = 1 microsecond scheduler time)
 *   time event duration = 10ms (real-time)
 *   
 *   time event firing = time event duration / time scaling
 *                     = 10ms / 1000
 *                     = 0.01ms
 *                     = 10 microseconds
 * </pre>
 * 
 * </p>
 * 
 * @author Philipp Richter
 */
public class TimeEventScheduler extends EventDispatcher implements
		ITimeEventScheduler {

	/** Defines the instance to log informations and errors. */
	private static final Logger log =
			Logger.getLogger(TimeEventScheduler.class);

	/**
	 * Defines the scheduler timer, if an interval greater than zero is defined.
	 * In this case the time event tasks are queued, if they are activated by
	 * the task timer and are fired, if the next interval is elapsed.
	 */
	private Timer scheduler = null;

	/**
	 * Ensures that the scheduler only fires activated time events, if the
	 * scheduler is not currently restarted. For example, if the scheduler
	 * interval was changed.
	 */
	private ReentrantLock schedulerLock = null;

	/**
	 * Defines the timer to schedule all time event tasks.
	 */
	private Timer taskTimer = null;

	/**
	 * Contains all defined tasks.
	 */
	private HashMap<String, TimeEventTask> tasks = null;

	/**
	 * Executes the firing of time events.
	 */
	private ExecutorService executors = null;

	/**
	 * Defines the queue to manage all activated time events.
	 */
	private Queue<TimeEventTask> taskQueue = null;

	/** Defines the time scaling of the scheduler. */
	private Double scaling = 1.0;

	/** Defines the duration between two scheduler cycles. */
	private Long interval = 0l;

	/**
	 * Indicates the current state of the scheduler whether it is active
	 * (interval is enabled) or not (interval is equal to zero -> disabled).
	 */
	private boolean intervalEnabled = false;

	/** Stores the time on which the pause was started. */
	private long pauseStarted = -1;

	/** Stores the complete time in which the scheduler was paused. */
	private long wholePausedTime = 0;

	/**
	 * Creates a new time event scheduler with an initial task capacity of 100.
	 * The capacity is changed dynamically, if more tasks are available.
	 */
	public TimeEventScheduler() {

		schedulerLock = new ReentrantLock();

		tasks = new HashMap<String, TimeEventTask>();

		executors = Executors.newCachedThreadPool();

		restartTaskTimer(getTimeScaling());

		// Deque with start capacity of 100 events is not used here, because of
		// java 1.5 compatibility
		taskQueue = new LinkedList<TimeEventTask>();
	}

	/**
	 * Creates the task of the scheduler which polls all available activated
	 * time event tasks and fires the particular events.
	 * 
	 * @return The scheduler task which fires the time event tasks.
	 */
	private TimerTask getSchedulerTask() {

		return new TimerTask() {

			@Override
			public void run() {

				/*
				 * Fire the events only if the scheduler is not currently
				 * restarted
				 */
				if (schedulerLock.tryLock()) {

					try {

						// publicize all currently activated time events
						while (!taskQueue.isEmpty()) {
							fireTimeEvent(taskQueue.poll());
						}
						
						// Signal the end of this scheduler interval
						fireSchedulerEvent();
						
					} finally {
						schedulerLock.unlock();
					}
				}
			}
		};
	}

	/**
	 * Provides the unique identifiers of all available time event tasks.
	 * 
	 * @return All unique identifiers of all time event tasks.
	 */
	public Set<String> getTasks() {

		return tasks.keySet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.
	 * ITimeEventScheduler#addTimeEventTask(java.lang.String, double)
	 */
	public synchronized boolean addTimeEventTask(final String id,
			final double duration) throws IllegalArgumentException {

		final long startTime = getCurrentTime();
		boolean result = false;

		if (id != null && duration >= 0) {

			if (!tasks.containsKey(id)) {

				final TimeEventTask task =
						new TimeEventTask(id, duration, startTime);
				tasks.put(id, task);
				addTask(task, getTimeScaling());

				result = true;
			} else {
				log.warn("New timer task already exist: " + id + ", duration: "
							+ duration);
			}

		} else {
			log.warn("The id of a new time event task was \"null\" (" + id
						+ "or the duration was smaller than zero: " + duration);
		}

		return result;
	}

	/**
	 * Provides the time event task with the specified unique identifier.
	 * 
	 * @param id defines the unique identifier
	 * 
	 * @return The task with the given <code>id</code>. If no task with the
	 *         given id exist the result is <code>null</code>.
	 */
	public TimeEventTask getTimeEventTask(final String id) {

		return tasks.get(id);
	}

	/**
	 * Adds the given time event task to in respect of the elapsed time to the
	 * task timer.
	 * 
	 * @param task defines the time event task which shall be added
	 * @param newScaling defines the new scaling which is needed to calculate
	 *            the new durations of the time event tasks
	 * 
	 * @throws IllegalArgumentException will be thrown, if the duration with
	 *             respect to the time scaling is greater than
	 *             {@link Long#MAX_VALUE}
	 */
	private void addTask(final TimeEventTask task, final double newScaling)
			throws IllegalArgumentException {

		final TimerTask timerTask = getTimerTask(task);

		task.setTimerTask(timerTask);

		try {

			final long delay = getDelay(task, newScaling);

			// System.out
			// .println(String
			// .format(
			// "Add Task \"%s\" with delay of %sms (elapsed: %s, duration: %s).",
			// task.getId(),
			// delay,
			// getElapsedTime(task),
			// task.getDuration()));

			taskTimer.schedule(timerTask, delay);

			if (Level.DEBUG.equals(log.getLevel())) {

				final double elapsedTime = getElapsedTime(task);

				log
					.debug(String
						.format(
							"Add Task \"%s\" with delay of %sms (elapsed: %s, duration: %s).",
							task.getId(),
							delay,
							elapsedTime,
							task.getDuration()));
			}

		} catch (final IllegalArgumentException e) {

			final DecimalFormat df = new DecimalFormat("0.###E0");

			throw new IllegalArgumentException(String.format(
				Messages.TimeEventScheduler_wrongduration,
				df.format(scaling),
				df.format(scaling),
				task.getDuration(),
				df.format(getMaxTimeScaling(task.getDuration()))), e);
		}
	}

	/**
	 * Creates the <code>TimerTask</code> for the given time event task
	 * 
	 * @param task defines the time event task for which the
	 *            <code>TimerTask</code> shall be instantiated
	 * 
	 * @return The <code>TimerTask</code> of the given time event task.
	 */
	private TimerTask getTimerTask(final TimeEventTask task) {

		return new TimerTask() {

			@Override
			public void run() {

				if (!intervalEnabled) {

					/*
					 * Don't fire the event if the tasks are restarted, because,
					 * for example, the time scaling was changed. So no double
					 * calls are possible.
					 */
					if (schedulerLock.tryLock()) {

						try {
							fireTimeEvent(task);
						} finally {
							schedulerLock.unlock();
						}
					}

				} else {

					synchronized (taskQueue) {

						/*
						 * The ArrayDeque returns only "true", because it is not
						 * size restricted.
						 */
						if (!taskQueue.contains(task)) {

							if (!taskQueue.offer(task)) {
								log
									.warn("The task with id \""
											+ task.getId()
											+ "\" and duration of "
											+ task.getDuration()
											+ " could not be queued! The ArrayDeque returns illicitly \"false\"!");
							}
						}
					}
				}
			}
		};
	}

	/**
	 * Calculates the maximum time scaling with respect to the given duration.
	 * The scaling is chosen so that one hour still may pass.
	 * 
	 * @param duration defines the current duration in milliseconds
	 * 
	 * @return The maximum time scaling, so that one hour still may pass.
	 */
	private double getMaxTimeScaling(final double duration) {

		final long oneHourInMilli = 3600000;

		double result =
				duration
						/ (Double.valueOf(Long.MAX_VALUE) - getCurrentTime() - oneHourInMilli);

		if (result < 0.0) {
			result = 0.0;
		}

		// System.out.println("max factor: " + result);

		return result;
	}

	/**
	 * Creates a <code>TimeEvent</code> instance to notify all listeners about
	 * the elapsed time event.
	 * 
	 * @param task defines the task of the elapsed time event
	 */
	private void fireTimeEvent(final TimeEventTask task) {

		TimeEventTask removedTask = removeTask(task.getId());

		if (removedTask != null) {

			executors.execute(new Runnable() {

				public void run() {

					fireEvent(new TimeEvent(task.getId()));
				}

			});

			if (Level.DEBUG.equals(log.getLevel())) {
				log.debug("Time event " + task.getId() + " has passed after: "
							+ (getCurrentTime() - task.getStartTime())
							+ ", duration of " + task.getDuration()
							+ "ms / scaling of " + getTimeScaling() + " = "
							+ (task.getDuration() / getTimeScaling()));
			}

			// System.out.println("Time event " + task.getId()
			// + " has passed after: "
			// + (getCurrentTime() - task.getStartTime())
			// + ", duration of " + task.getDuration()
			// + "ms / scaling of " + getTimeScaling() + " = "
			// + (task.getDuration() / getTimeScaling()));

			removedTask = null;
		}

		taskTimer.purge();
	}

	/**
	 * Creates a <code>SchedulerEvent</code> instance to notify all listeners
	 * that the current scheduler interval is finished and all time event which
	 * are activated during this interval were fired. This event is the last
	 * event of one interval!
	 */
	private void fireSchedulerEvent() {

		executors.execute(new Runnable() {

			public void run() {

				fireEvent(new SchedulerEvent());
			}
		});

		if (Level.DEBUG.equals(log.getLevel())) {
			log.debug("Scheduler has finished interval! Current time: "
						+ getCurrentTime());
		}

	}

	/**
	 * Calculates the delay via time event duration and the defined time
	 * scaling.
	 * 
	 * @param task defines the time event task whose delay shall be defined
	 * @param newScaling defines the new scaling which is needed to calculate
	 *            the new durations of the time event tasks
	 * 
	 * @return The delay in milliseconds.
	 */
	private long getDelay(final TimeEventTask task, final double newScaling) {

		Double delay =
				Math.ceil((task.getDuration() - getElapsedTime(task))
							/ newScaling);

		if (delay < 0) {
			delay = 0d;

		} else if (delay > Long.MAX_VALUE) {
			log
				.warn("The duration ("
						+ delay
						+ ") of the time event is greater than Long.MAX_VALUE and the duration must be truncated to Long.MAX_VALUE");
		}

		return delay.longValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.
	 * ITimeEventScheduler#removeTimeEventTask(java.lang.String)
	 */
	public boolean removeTimeEventTask(final String id) {

		boolean result = false;

		final TimeEventTask task = removeTask(id);

		if (task != null) {

			result = task.getTimerTask().cancel();
			taskTimer.purge();
		}

		return result;
	}

	/**
	 * Removes the time event task with the given <code>id</code> synchronous.
	 * 
	 * @param id defines the unique identifier of the task
	 * 
	 * @return The removed time event task.
	 */
	private TimeEventTask removeTask(final String id) {

		synchronized (tasks) {
			return tasks.remove(id);
		}
	}

	/**
	 * Checks whether a timer task with the given <code>id</code> exist.
	 * 
	 * @param id defines the unique identifier of the timer task
	 * 
	 * @return The result is <code>true</code> if a task with the given
	 *         <code>id</code> exist, otherwise <code>false</code>.
	 */
	public boolean taskExist(final String id) {

		return tasks.containsKey(id);
	}

	/**
	 * Returns the scaling to schedule the time events. For more informations
	 * see {@link #setTimeScaling(double)}.
	 * 
	 * @return The currently used time scaling.
	 */
	public Double getTimeScaling() {

		return scaling;
	}

	/**
	 * Defines the time scaling of the scheduler. <code>scaling</code> refers to
	 * one millisecond in real-time and means how much milliseconds of the
	 * scheduler correspond to one millisecond in real-time. For example, if
	 * scaling is 1.0, it means that one millisecond of the scheduler is one
	 * millisecond in real-time. Scaling of 2.0 means that two milliseconds of
	 * the scheduler are one millisecond in real-time. The scaling must be
	 * greater than zero.
	 * 
	 * @param scaling defines the scaling of the scheduler time
	 * 
	 * @return The result is <code>true</code> if the scaling was changed
	 *         successfully. If the scaling is <= 0.0 the result is
	 *         <code>false</code>.
	 * 
	 * @throws IllegalArgumentException will be thrown, if the duration with
	 *             respect to the time scaling is greater than
	 *             {@link Long#MAX_VALUE}
	 */
	public boolean setTimeScaling(final double scaling)
			throws IllegalArgumentException {

		boolean result = false;

		try {

			if (scaling != this.scaling && scaling > 0.0) {

				restartTaskTimer(scaling);

				this.scaling = scaling;

				result = true;
			}
		} catch (final IllegalArgumentException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Renews all timer tasks. For example, it is needed if the scaling was
	 * changed.
	 * 
	 * @param newScaling defines the new scaling which is needed to calculate
	 *            the new durations of the time event tasks
	 * 
	 * 
	 * @throws IllegalArgumentException will be thrown, if the duration with
	 *             respect to the time scaling is greater than
	 *             {@link Long#MAX_VALUE}
	 */
	private void restartTaskTimer(final double newScaling)
			throws IllegalArgumentException {

		/*
		 * Ensure that no time event is fired currently. If an event is fired
		 * currently wait as long as the firing is finished.
		 */
		schedulerLock.lock();

		try {

			cancelTaskTimer();

			taskTimer =
					new Timer(TimeEventScheduler.class.getSimpleName()
								+ " - Task timer", true);

			if (Level.DEBUG.equals(log.getLevel())) {
				log.debug(new StringBuffer("Restart the task timer!"));
			}

			for (final TimeEventTask task : tasks.values()) {

				try {
					addTask(task, newScaling);
				} catch (final IllegalArgumentException e) {
					throw new IllegalArgumentException(e.getMessage(), e);
				}
			}
		} finally {
			schedulerLock.unlock();
		}
	}

	/**
	 * Calculates the elapsed time with respect to the elapsed scheduler time
	 * and the time scaling.
	 * 
	 * @param task defines the time event task whose elapsed time shall be
	 *            calculated
	 * 
	 * @return The elapsed time of the given time event task.
	 */
	private double getElapsedTime(final TimeEventTask task) {

		/* elapsed time = (current time - task start time) * time scaling */
		Double result =
				(getCurrentTime() - task.getStartTime()) * getTimeScaling();

		// System.out.println(task.getId() + ": elapsed = " + result +
		// ", long = " + result.longValue());

		if (result < 0) {
			result = 0d;
		}

		return result;
	}

	/**
	 * Renews all timer tasks. For example, it is needed if the scaling was
	 * changed.
	 */
	private void restartScheduler() {

		schedulerLock.lock();

		try {

			cancelScheduler();

			if (interval > 0) {

				intervalEnabled = true;

				scheduler =
						new Timer(
							TimeEventScheduler.class.getSimpleName(),
							true);

				scheduler.schedule(getSchedulerTask(), 0, interval);

			} else {

				intervalEnabled = false;
			}

		} finally {
			schedulerLock.unlock();
		}
	}

	/**
	 * Provides the currently used interval to check the time events. If the
	 * interval is zero, all time events are fired directly.
	 * 
	 * @return The currently used scheduler interval.
	 */
	public Long getSchedulerInterval() {

		return interval;
	}

	/**
	 * Defines the duration between two scheduler cycles in which all timer
	 * tasks are checked whether they are have to be activated. The interval is
	 * defined in milliseconds. <b>The scheduler must be restarted</b> with
	 * {@link #startScheduler()} to use the new interval.
	 * 
	 * @param interval defines the duration between two scheduler cycles <b>in
	 *            milliseconds</b>
	 * 
	 * @return The result is <code>true</code> if the interval is greater than
	 *         or equal to zero and the scheduler was restarted successfully,
	 *         otherwise the result is <code>false</code>.
	 */
	public boolean setSchedulerInterval(final long interval) {

		boolean result = false;

		if (interval >= 0) {
			this.interval = interval;

			result = true;
		}

		return result;
	}

	/**
	 * Cancels the scheduler timer.
	 */
	private void cancelScheduler() {

		if (scheduler != null) {
			scheduler.cancel();
			scheduler.purge();
			scheduler = null;
		}
	}

	/**
	 * Cancels the task timer.
	 */
	private void cancelTaskTimer() {

		if (taskTimer != null) {
			taskTimer.cancel();
			taskTimer.purge();
			taskTimer = null;
		}
	}

	/**
	 * Pause the scheduler and all time event tasks. To resume the scheduler use
	 * {@link #startScheduler()}.
	 */
	public void pauseScheduler() {

		schedulerLock.lock();

		try {

			// Pause only one time
			if (pauseStarted == -1) {
				pauseStarted = System.currentTimeMillis();

				cancelScheduler();
				cancelTaskTimer();
			}

		} finally {
			schedulerLock.unlock();
		}
	}

	/**
	 * Starts or resumes the scheduler after it was paused by
	 * {@link #pauseScheduler()}. All available time event tasks are resumed.
	 */
	public void startScheduler() {

		updateWholePausedTime();

		restartScheduler();
		restartTaskTimer(getTimeScaling());

	}

	/**
	 * Updates the whole paused time with respect to the last pause.
	 */
	private void updateWholePausedTime() {

		if (pauseStarted != -1) {

			wholePausedTime += System.currentTimeMillis() - pauseStarted;
			pauseStarted = -1;
		}
	}

	/**
	 * Provides the current scheduler time.
	 * 
	 * @return The current scheduler time.
	 */
	public long getCurrentTime() {

		return System.currentTimeMillis() - wholePausedTime;
	}

	/**
	 * Allows to skip the time left of the time based event with the given
	 * <code>id</code>.
	 * 
	 * @param id defines the unique identifier of the time event
	 * 
	 * @return The result is <code>false</code> if the <code>id</code> is
	 *         <code>null</code> or no time event with an unique identifier
	 *         equal to <code>id</code> exist.
	 */
	public boolean moveForwardTimeEvent(String id) {

		boolean result = false;

		if (id != null) {

			schedulerLock.lock();

			try {

				pauseScheduler();

				if (tasks.containsKey(id)) {

					TimeEventTask task = tasks.get(id);

					if (task != null) {

						updateWholePausedTime();

						long delay = getDelay(task, scaling);

						wholePausedTime -= delay;

						result = true;
					}
				}

				startScheduler();

			} finally {
				schedulerLock.unlock();
			}
		}

		return result;
	}

	/**
	 * Removes all allocated resources and all running timer tasks are canceled.
	 */
	public void dispose() {

		cancelScheduler();
		cancelTaskTimer();

		if (taskQueue != null) {
			taskQueue.clear();
			taskQueue = null;
		}

		if (tasks != null) {
			tasks.clear();
			tasks = null;
		}
	}
}
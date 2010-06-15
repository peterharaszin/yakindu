/**
 * Copyright (c) 2009 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.scheduling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.Before;
import org.junit.Test;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;

import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler;

/**
 * @author Philipp Richter
 * 
 */
public class Test_TimeEventScheduler {

	/** Defines the id of the first test time event. */
	private static final String TIME_EVENT_1_ID = "1";
	/** Defines the duration (ms) of the first test time event. */
	private static final long TIME_EVENT_1_DELAY = 50;
	/** Defines the id of the second test time event. */
	private static final String TIME_EVENT_2_ID = "2";
	/** Defines the duration (ms) of the second test time event. */
	private static final long TIME_EVENT_2_DELAY = 200;
	/** Defines the id of the third test time event. */
	private static final String TIME_EVENT_3_ID = "3";
	/** Defines the duration (ms) of the third test time event. */
	private static final long TIME_EVENT_3_DELAY = 300;
	/** Defines the id of the fourth test time event. */
	private static final String TIME_EVENT_4_ID = "4";
	/** Defines the duration (ms) of the fourth test time event. */
	private static final long TIME_EVENT_4_DELAY = 100;

	/** Defines the id of the fifth test time event. */
	private static final String TIME_EVENT_5_ID = "5";
	/** Defines the duration (ms) of the fifth test time event. */
	private static final double TIME_EVENT_5_DELAY = 0.05;
	/** Defines the id of the sixth test time event. */
	private static final String TIME_EVENT_6_ID = "6";
	/** Defines the duration (ms) of the sixth test time event. */
	private static final double TIME_EVENT_6_DELAY = 0.2;
	/** Defines the id of the seventh test time event. */
	private static final String TIME_EVENT_7_ID = "7";
	/** Defines the duration (ms) of the seventh test time event. */
	private static final double TIME_EVENT_7_DELAY = 0.3;
	/** Defines the id of the eighth test time event. */
	private static final String TIME_EVENT_8_ID = "8";
	/** Defines the duration (ms) of the eighth test time event. */
	private static final double TIME_EVENT_8_DELAY = 0.1;

	/** Defines the tolerance of the timing checks. */
	private static final long TIME_EVENT_TOLERANCE = 70;
	/**
	 * Defines the tolerance of the timing checks if the scheduler time or the
	 * scaling was changed.
	 */
	private static final long TIME_EVENT_CHANGE_TOLERANCE = 100;
	/**
	 * If a listener occurs an assertion error, the error is reported via this
	 * string.
	 */
	private AssertionError assertionError = null;

	/**
	 * If a listener has received all events this value is true.
	 */
	private boolean allEventsReceived = false;

	/** Defines class under test. */
	private TimeEventScheduler scheduler = null;

	/**
	 * Sets up the test environment.
	 */
	@Before
	public void setUp() throws Exception {

		scheduler = new TimeEventScheduler();
		
		setAllEventsReceived(false);
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#addTimerTask(java.lang.String, long, long)}
	 * .
	 */
	@Test
	public void testAddTimeEventTask() throws IllegalArgumentException {

		// --- Normal case ---

		assertTrue("A new time event task could not be added!", scheduler
			.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY));

		assertNotNull("The time event task could not be added!", scheduler
			.getTimeEventTask(TIME_EVENT_1_ID));
		assertEquals("The time event task id is wrong!", "1", scheduler
			.getTimeEventTask(TIME_EVENT_1_ID)
			.getId());
		assertEquals(
			"The time event duration is wrong!",
			TIME_EVENT_1_DELAY,
			scheduler.getTimeEventTask(TIME_EVENT_1_ID).getDuration(), 0.0);

		// --- Exceptional case ---

		// Id is null
		assertFalse(
			"addTimeEventTask() returns \"true\", but the id is \"null\"!",
			scheduler.addTimeEventTask(null, TIME_EVENT_1_DELAY));

		// Id already exist
		scheduler.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY);
		assertFalse(
			"The another time event task with the same id already exist, but the result was not \"false\"!",
			scheduler.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY));

		// Duration is smaller than 0
		assertFalse("The duration of the time event is smaller than zero, but the result is true!", scheduler.addTimeEventTask(TIME_EVENT_2_ID, -1));
		
		// Check overflow of the private method getDelay()
		try {
			scheduler.setTimeScaling(0.0000000000000000000001);
			fail("The scaling is to large, but no exception was occurred!");
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#removeTimeEventTask(String)}
	 * .
	 */
	@Test
	public void testRemoveTimeEventTask() {

		// --- Normal case ---

		assertTrue("A new time event task could not be added!", scheduler
			.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY));
		assertTrue("The task could not be removed!", scheduler
			.removeTimeEventTask(TIME_EVENT_1_ID));

		// Remove of running task
		assertTrue("A new time event task could not be added!", scheduler
			.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY));
		scheduler.setSchedulerInterval(20l);
		assertTrue(
			"The time event task could not be removed, after the scheduler was started with an interval of 20ms (time event duration = "
					+ TIME_EVENT_2_DELAY + "!",
			scheduler.removeTimeEventTask(TIME_EVENT_2_ID));

		// --- Exceptional case ---

		assertFalse(
			"removeTimeEventTask() returns \"true\", but the id is \"null\"!",
			scheduler.removeTimeEventTask(null));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#taskExist(String)}
	 * .
	 */
	@Test
	public void testTaskExist() {

		// --- Normal case ---

		// event does not exist
		assertFalse(
			"The task does not exist, but taskExist() returns \"true\"!",
			scheduler.taskExist("doesnotexist"));

		// event exist
		assertTrue("addTimeEventTask() returns \"false\"!", scheduler
			.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY));
		assertTrue(
			"The task was added, but taskExist() returns \"false\"!",
			scheduler.taskExist(TIME_EVENT_1_ID));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#getTimeScaling()}
	 * .
	 */
	@Test
	public void testGetTimeScaling() {

		// --- Normal case ---

		// Test default time scaling
		assertEquals("The default time scaling is wrong!", 1d, scheduler
			.getTimeScaling().doubleValue(), 0.0);
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#setTimeScaling(double, long)}
	 * .
	 */
	@Test
	public void testSetTimeScaling() {

		// --- Normal case ---

		assertTrue("The time scaling could not be set!", scheduler
			.setTimeScaling(2.0));

		assertEquals(
			"The time scaling was changed, but the new scaling is wrong!",
			2.0,
			scheduler.getTimeScaling().doubleValue(), 0.0);

		// --- Exceptional case ---

		// Scaling is smaller than 0
		assertFalse(
			"The time scaling is smaller than zero, but the result is \"true\"!",
			scheduler.setTimeScaling(-0.0));
		assertEquals(
			"The time scaling was changed, but the scaling update was not successful!",
			2.0,
			scheduler.getTimeScaling().doubleValue(), 0.0);
		assertFalse(
			"The time scaling is smaller than zero, but the result is \"true\"!",
			scheduler.setTimeScaling(-0.1));
		assertEquals(
			"The time scaling was changed, but the scaling update was not successful!",
			2.0,
			scheduler.getTimeScaling().doubleValue(), 0.0);
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#getSchedulerInterval()}
	 * .
	 */
	@Test
	public void testGetSchedulerInterval() {

		// --- Normal case ---

		// Check default interval
		assertEquals("The default scheduler interval wrong!", 0, scheduler
			.getSchedulerInterval().doubleValue(), 0.0);
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#setSchedulerInterval(long)}
	 * .
	 */
	@Test
	public void testSetSchedulerInterval() {

		// --- Normal case ---

		assertTrue("The scheduler interval could not be updated!", scheduler
			.setSchedulerInterval(42));

		assertEquals(
			"The scheduler interval was updated successfully, but the getter returns the wrong interval!",
			42,
			scheduler.getSchedulerInterval().doubleValue(), 0.0);

		// --- Exceptional case ---

		// Interval is negative
		assertFalse(
			"The interval is negative, but the result is not \"false\"!",
			scheduler.setSchedulerInterval(-42));
		assertEquals(
			"The interval was changed, but interval update was not successful!",
			42,
			scheduler.getSchedulerInterval().doubleValue(), 0.0);
	}

	/**
	 * Tests the scheduler timer without interval checking (interval = 0).
	 */
	@Test(timeout=10000)
	public void testSchedulingWithoutInterval() throws InterruptedException {

//		System.out
//			.println("Timing test without scheduler timer (firing events directly, if they are elapsed):");
		final long startTime = System.currentTimeMillis();

		// Add listener to check the time event durations
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				if (event instanceof TimeEvent) {

					final TimeEvent timeEvent = (TimeEvent) event;

					final long duration =
							(System.currentTimeMillis() - startTime);

					if (timeEvent.getSource().equals(TIME_EVENT_1_ID)) {

//						System.out.println("Duration without interval of "
//											+ TIME_EVENT_1_ID + ": exp. "
//											+ TIME_EVENT_1_DELAY + "ms => was "
//											+ duration + "ms");

						if (!isInRange(
							duration,
							TIME_EVENT_1_DELAY,
							TIME_EVENT_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the first time event was wrong! Duration was: "
										+ duration + ", expected: "
										+ TIME_EVENT_1_DELAY + ", tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_2_ID)) {

//						System.out.println("Duration without interval of "
//											+ TIME_EVENT_2_ID + ": exp. "
//											+ TIME_EVENT_2_DELAY + "ms => was "
//											+ duration + "ms");

						if (!isInRange(
							duration,
							TIME_EVENT_2_DELAY,
							TIME_EVENT_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the second time event was wrong! Duration was: "
										+ duration + ", expected: "
										+ TIME_EVENT_2_DELAY + ", tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_3_ID)) {

//						System.out.println("Duration without interval of "
//											+ TIME_EVENT_3_ID + ": exp. "
//											+ TIME_EVENT_3_DELAY + "ms => was "
//											+ duration + "ms");

						if (!isInRange(
							duration,
							TIME_EVENT_3_DELAY,
							TIME_EVENT_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the third time event was wrong! Duration was: "
										+ duration + ", expected: "
										+ TIME_EVENT_3_DELAY + ", tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

						setAllEventsReceived(true);
					}
				}
			}
		});

		scheduler.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_3_ID, TIME_EVENT_3_DELAY);

		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}
	}

	/**
	 * Tests the scheduler timer with interval.
	 */
	@Test(timeout=10000)
	public void testSchedulingWithInterval() throws InterruptedException {

//		System.out.println("Timing test with scheduler timer (interval != 0):");
		// Define a scheduler interval
		scheduler.setSchedulerInterval(250);

		final long startTime = System.currentTimeMillis();

		// Add listener to check the time event durations
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				if (event instanceof TimeEvent) {

					final TimeEvent timeEvent = (TimeEvent) event;

					final long duration =
							(System.currentTimeMillis() - startTime);

					if (timeEvent.getSource().equals(TIME_EVENT_1_ID)) {

//						System.out.println("Duration with interval of "
//											+ TIME_EVENT_1_ID + ": exp. "
//											+ (TIME_EVENT_1_DELAY + 200)
//											+ "ms => was " + duration + "ms");

						// The nearest time event check of the scheduler is
						// after 250ms, so the delay must be about 250ms
						if (!isInRange(
							duration,
							TIME_EVENT_1_DELAY + 200,
							TIME_EVENT_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the first time event was wrong! Duration was: "
										+ duration
										+ ", expected: "
										+ TIME_EVENT_1_DELAY
										+ " + 200 (scheduler interval = 250), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_2_ID)) {

//						System.out.println("Duration with interval of "
//											+ TIME_EVENT_2_ID + ": exp. "
//											+ (TIME_EVENT_2_DELAY + 50)
//											+ "ms => was " + duration + "ms");

						// The nearest time event check of the scheduler is
						// after 250ms, so the delay must be about 200ms
						if (!isInRange(
							duration,
							TIME_EVENT_2_DELAY + 50,
							TIME_EVENT_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the second time event was wrong! Duration was: "
										+ duration
										+ ", expected: "
										+ TIME_EVENT_2_DELAY
										+ " + 50 (scheduler interval = 250), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_3_ID)) {

//						System.out.println("Duration with interval of "
//											+ TIME_EVENT_3_ID + ": exp. "
//											+ (TIME_EVENT_3_DELAY + 200)
//											+ "ms => was " + duration + "ms");

						// The nearest time event check of the scheduler is
						// after 500ms, so the delay must be about 400ms
						if (!isInRange(
							duration,
							TIME_EVENT_3_DELAY + 200,
							TIME_EVENT_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the third time event was wrong! Duration was: "
										+ duration
										+ ", expected: "
										+ TIME_EVENT_3_DELAY
										+ " + 200 (scheduler interval = 250), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

						// Signal that all events are received
						setAllEventsReceived(true);
					}
				}
			}
		});

		scheduler.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_3_ID, TIME_EVENT_3_DELAY);

		scheduler.startScheduler();

		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}
	}

	/**
	 * Tests the scheduler timer with interval and with an interval change.
	 */
	@Test(timeout=10000)
	public void testSchedulingWithIntervalChange() throws InterruptedException {

//		System.out.println("Timing test with interval change:");
		// Define a scheduler interval
		scheduler.setSchedulerInterval(50);

		final long startTime = System.currentTimeMillis();

		// Add listener to check the time event durations
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				if (event instanceof TimeEvent) {

					final TimeEvent timeEvent = (TimeEvent) event;

					final long duration =
							(System.currentTimeMillis() - startTime);

					if (timeEvent.getSource().equals(TIME_EVENT_1_ID)) {

//						System.out.println("Duration with interval change of "
//											+ TIME_EVENT_1_ID + ": exp. "
//											+ TIME_EVENT_1_DELAY + "ms => was "
//											+ duration + "ms");

						if (!isInRange(
							duration,
							TIME_EVENT_1_DELAY,
							TIME_EVENT_TOLERANCE+10)) {
							setAssertionError(new AssertionError(
								"The duration of the first time event was wrong! Duration was: "
										+ duration
										+ ", expected: "
										+ TIME_EVENT_1_DELAY
										+ " (scheduler interval = 50), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_2_ID)) {

//						System.out.println("Duration with interval change of "
//											+ TIME_EVENT_2_ID + ": exp. "
//											+ (TIME_EVENT_2_DELAY + 50)
//											+ "ms => was " + duration + "ms");

						// The scheduler interval was changed!
						// The nearest time event check of the scheduler is
						// after 250ms
						if (!isInRange(
							duration,
							TIME_EVENT_2_DELAY + 50,
							TIME_EVENT_CHANGE_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the second time event was wrong! Duration was: "
										+ duration
										+ ", expected: "
										+ TIME_EVENT_2_DELAY
										+ " + 50 (scheduler intervals = 1. 50, 2. 50, 3. 150), tolerance: "
										+ TIME_EVENT_CHANGE_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_3_ID)) {

//						System.out.println("Duration with interval change of "
//											+ TIME_EVENT_3_ID + ": exp. "
//											+ (TIME_EVENT_3_DELAY + 100)
//											+ "ms => was " + duration + "ms");

						// The nearest time event check of the scheduler is
						// after 400ms
						if (!isInRange(
							duration,
							TIME_EVENT_3_DELAY + 100,
							TIME_EVENT_CHANGE_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the third time event was wrong! Duration was: "
										+ duration
										+ ", expected: "
										+ TIME_EVENT_3_DELAY
										+ " + 100 (scheduler intervals = 1. 50, 2. 50, 3. 150, 4. 150), tolerance: "
										+ TIME_EVENT_CHANGE_TOLERANCE));
						}

						// Signal that all events are received
						setAllEventsReceived(true);
					}
				}
			}
		});

		scheduler.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_3_ID, TIME_EVENT_3_DELAY);

		scheduler.startScheduler();

		final Timer changeTimer = new Timer(true);
		changeTimer.schedule(new TimerTask() {

			@Override
			public void run() {

				scheduler.setSchedulerInterval(150);
				scheduler.startScheduler();
			}

		}, 100);

		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}
	}

	/**
	 * Tests the scheduler timer with interval and with an interval change.
	 * 
	 * <p>
	 * The first time scaling is 0.5. The second time scaling is 2.0. The time
	 * scaling will be changed after 150ms.
	 */
	@Test(timeout=10000)
	public void testSchedulingWithScalingChange() throws InterruptedException {

//		System.out
//			.println("Timing test with time scaling change (milliseconds):");

		final double TIME_SCALING_1 = 0.5;
		final double TIME_SCALING_2 = 2.0;
		final long TIME_SCALING_2_DELAY = 150;

		// Define a time scaling
		scheduler.setTimeScaling(TIME_SCALING_1);

		final long startTime = System.currentTimeMillis();

		// Add listener to check the time event durations
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				if (event instanceof TimeEvent) {

					final TimeEvent timeEvent = (TimeEvent) event;

					final long duration =
							(System.currentTimeMillis() - startTime);

					if (timeEvent.getSource().equals(TIME_EVENT_1_ID)) {

//						System.out.println("Duration with scaling change of "
//											+ TIME_EVENT_1_ID + ": " + duration
//											+ ", expected: " + 100
//											+ "ms (time scaling is "
//											+ TIME_SCALING_1 + "), tolerance: "
//											+ TIME_EVENT_TOLERANCE);

						// The time scaling is 0.5 so the expected duration is
						// 100ms (50ms / 0.5).
						if (!isInRange(duration, 100, TIME_EVENT_TOLERANCE)) {

							setAssertionError(new AssertionError(
								"The duration of the first time event was wrong! Duration was: "
										+ duration + ", expected: " + 100
										+ "ms (time scaling is "
										+ TIME_SCALING_1 + "), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_2_ID)) {

//						System.out
//							.println("Duration with scaling change of "
//										+ TIME_EVENT_2_ID + ": " + duration
//										+ ", expected: " + 213
//										+ "ms (time scaling was changed from "
//										+ TIME_SCALING_1 + " to "
//										+ TIME_SCALING_2 + " after "
//										+ TIME_SCALING_2_DELAY
//										+ "ms), tolerance: "
//										+ TIME_EVENT_CHANGE_TOLERANCE);

						// The time scaling was changed to 2.0 after 150ms,
						// about 50ms remain!
						// The whole duration is now 150ms + 25ms (50ms / 2.0) =
						// 175ms
						if (!isInRange(
							duration,
							213,
							TIME_EVENT_CHANGE_TOLERANCE)) {

							setAssertionError(new AssertionError(
								"The duration of the second time event was wrong! Duration was: "
										+ duration + ", expected: " + 213
										+ "ms (time scaling was changed from "
										+ TIME_SCALING_1 + " to "
										+ TIME_SCALING_2 + " after "
										+ TIME_SCALING_2_DELAY
										+ "ms), tolerance: "
										+ TIME_EVENT_CHANGE_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_4_ID)) {

//						System.out.println("Duration with scaling change of "
//											+ TIME_EVENT_4_ID + ": " + duration
//											+ ", expected: " + 200
//											+ "ms (time scaling is "
//											+ TIME_SCALING_2 + "), tolerance: "
//											+ TIME_EVENT_TOLERANCE);

						// Event was added after the time scaling change,
						// about 100ms remain!
						// The whole duration is now 50ms (100ms / 2.0)
						if (!isInRange(duration, 200, TIME_EVENT_TOLERANCE)) {

							setAssertionError(new AssertionError(
								"The duration of the fourth time event was wrong! Duration was: "
										+ duration + ", expected: " + 200
										+ "ms (time scaling is "
										+ TIME_SCALING_2 + "), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_3_ID)) {

//						System.out
//							.println("Duration with scaling change of "
//										+ TIME_EVENT_3_ID + ": " + duration
//										+ ", expected: " + 263
//										+ "ms (time scaling was changed from "
//										+ TIME_SCALING_1 + " to "
//										+ TIME_SCALING_2 + " after "
//										+ TIME_SCALING_2_DELAY
//										+ "ms), tolerance: "
//										+ TIME_EVENT_CHANGE_TOLERANCE);

						// The time scaling was changed to 2.0 after 150ms,
						// about 150ms remain!
						// The whole duration is now 150ms + 75ms (150ms / 2.0)
						// = 225ms
						if (!isInRange(
							duration,
							263,
							TIME_EVENT_CHANGE_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the third time event was wrong! Duration was: "
										+ duration + ", expected: " + 263
										+ "ms (time scaling was changed from "
										+ TIME_SCALING_1 + " to "
										+ TIME_SCALING_2 + " after "
										+ TIME_SCALING_2_DELAY
										+ "ms), tolerance: "
										+ TIME_EVENT_CHANGE_TOLERANCE));
						}

						// Signal that all events are received
						setAllEventsReceived(true);
					}
				}
			}
		});

		scheduler.addTimeEventTask(TIME_EVENT_1_ID, TIME_EVENT_1_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_3_ID, TIME_EVENT_3_DELAY);

		final Timer changeTimer = new Timer(true);
		changeTimer.schedule(new TimerTask() {

			@Override
			public void run() {

				scheduler.setTimeScaling(TIME_SCALING_2);
				scheduler.addTimeEventTask(TIME_EVENT_4_ID, TIME_EVENT_4_DELAY);
			}

		},
			TIME_SCALING_2_DELAY);

		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}
	}

	/**
	 * Tests the scheduler timer with interval and with an interval change.
	 * 
	 * <p>
	 * The first time scaling is 0.5. The second time scaling is 2.0. The time
	 * scaling will be changed after 150ms.
	 */
	@Test(timeout=10000)
	public void testSchedulingWithScalingChange2() throws InterruptedException {

//		System.out
//			.println("Timing test with time scaling change 2 (microseconds):");

		final double TIME_SCALING_1 = 0.0005;
		final double TIME_SCALING_2 = 0.002;
		final long TIME_SCALING_2_DELAY = 150;

		// Define a time scaling
		scheduler.setTimeScaling(TIME_SCALING_1);

		final long startTime = System.currentTimeMillis();

		// Add listener to check the time event durations
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				if (event instanceof TimeEvent) {

					final TimeEvent timeEvent = (TimeEvent) event;

					final long duration =
							(System.currentTimeMillis() - startTime);

					if (timeEvent.getSource().equals(TIME_EVENT_5_ID)) {

//						System.out.println("Duration with scaling change of "
//											+ TIME_EVENT_5_ID + ": " + duration
//											+ ", expected: " + 100
//											+ "ms (time scaling is "
//											+ TIME_SCALING_1 + "), tolerance: "
//											+ TIME_EVENT_TOLERANCE);

						// The time scaling is 0.5 so the expected duration is
						// 100ms (50ms / 0.5).
						if (!isInRange(duration, 100, TIME_EVENT_TOLERANCE)) {

							setAssertionError(new AssertionError(
								"The duration of the fifth time event was wrong! Duration was: "
										+ duration + ", expected: " + 100
										+ "ms (time scaling is "
										+ TIME_SCALING_1 + "), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_6_ID)) {

//						System.out
//							.println("Duration with scaling change of "
//										+ TIME_EVENT_6_ID + ": " + duration
//										+ ", expected: " + 213
//										+ "ms (time scaling was changed from "
//										+ TIME_SCALING_1 + " to "
//										+ TIME_SCALING_2 + " after "
//										+ TIME_SCALING_2_DELAY
//										+ "ms), tolerance: "
//										+ TIME_EVENT_CHANGE_TOLERANCE);

						// The time scaling was changed to 2.0 after 150ms,
						// about 50ms remain!
						// The whole duration is now 150ms + 25ms (50ms / 2.0) =
						// 175ms
						if (!isInRange(
							duration,
							213,
							TIME_EVENT_CHANGE_TOLERANCE)) {

							setAssertionError(new AssertionError(
								"The duration of the sixth time event was wrong! Duration was: "
										+ duration + ", expected: " + 213
										+ "ms (time scaling was changed from "
										+ TIME_SCALING_1 + " to "
										+ TIME_SCALING_2 + " after "
										+ TIME_SCALING_2_DELAY
										+ "ms), tolerance: "
										+ TIME_EVENT_CHANGE_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_8_ID)) {

//						System.out.println("Duration with scaling change of "
//											+ TIME_EVENT_8_ID + ": " + duration
//											+ ", expected: " + 200
//											+ "ms (time scaling is "
//											+ TIME_SCALING_2 + "), tolerance: "
//											+ TIME_EVENT_TOLERANCE);

						// Event was added after the time scaling change,
						// about 100ms remain!
						// The whole duration is now 50ms (100ms / 2.0)
						if (!isInRange(duration, 200, TIME_EVENT_TOLERANCE)) {

							setAssertionError(new AssertionError(
								"The duration of the eighth time event was wrong! Duration was: "
										+ duration + ", expected: " + 200
										+ "ms (time scaling is "
										+ TIME_SCALING_2 + "), tolerance: "
										+ TIME_EVENT_TOLERANCE));
						}

					} else if (timeEvent.getSource().equals(TIME_EVENT_7_ID)) {

//						System.out
//							.println("Duration with scaling change of "
//										+ TIME_EVENT_7_ID + ": " + duration
//										+ ", expected: " + 263
//										+ "ms (time scaling was changed from "
//										+ TIME_SCALING_1 + " to "
//										+ TIME_SCALING_2 + " after "
//										+ TIME_SCALING_2_DELAY
//										+ "ms), tolerance: "
//										+ TIME_EVENT_CHANGE_TOLERANCE);

						// The time scaling was changed to 2.0 after 150ms,
						// about 150ms remain!
						// The whole duration is now 150ms + 75ms (150ms / 2.0)
						// = 225ms
						if (!isInRange(
							duration,
							263,
							TIME_EVENT_CHANGE_TOLERANCE)) {
							setAssertionError(new AssertionError(
								"The duration of the seventh time event was wrong! Duration was: "
										+ duration + ", expected: " + 263
										+ "ms (time scaling was changed from "
										+ TIME_SCALING_1 + " to "
										+ TIME_SCALING_2 + " after "
										+ TIME_SCALING_2_DELAY
										+ "ms), tolerance: "
										+ TIME_EVENT_CHANGE_TOLERANCE));
						}

						// Signal that all events are received
						setAllEventsReceived(true);
					}
				}
			}
		});

		scheduler.addTimeEventTask(TIME_EVENT_5_ID, TIME_EVENT_5_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_6_ID, TIME_EVENT_6_DELAY);
		scheduler.addTimeEventTask(TIME_EVENT_7_ID, TIME_EVENT_7_DELAY);

		final Timer changeTimer = new Timer(true);
		changeTimer.schedule(new TimerTask() {

			@Override
			public void run() {

				scheduler.setTimeScaling(TIME_SCALING_2);
				scheduler.addTimeEventTask(TIME_EVENT_8_ID, TIME_EVENT_8_DELAY);
			}

		},
			TIME_SCALING_2_DELAY);

		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#pauseScheduler()
	 * )} .
	 */
	@Test(timeout=10000)
	public void testPauseScheduler() throws Exception {

		// --- Normal case ---

		// interval = 0
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				assertionError =
						new AssertionError(
							"The scheduler was paused, but all the same an time event was received (interval = 0).");
			}
		});

		long startTime = System.currentTimeMillis();
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);

		scheduler.pauseScheduler();

		while ((System.currentTimeMillis() - startTime - 100) < TIME_EVENT_2_DELAY) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
			assertionError = null;
		}

		// interval != 0
		setUp();
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				assertionError =
						new AssertionError(
							"The scheduler was paused, but all the same an time event was received (interval > 0).");
			}
		});

		startTime = System.currentTimeMillis();
		scheduler.setSchedulerInterval(20);
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);

		scheduler.pauseScheduler();

		while ((System.currentTimeMillis() - startTime - 100) < TIME_EVENT_2_DELAY) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}

		// TODO Test whether the scheduler can be restarted
		
		// --- Exceptional case ---

		// pause a second time
		scheduler.pauseScheduler();
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#startScheduler()}
	 * .
	 */
	@Test(timeout=10000)
	public void testResumeScheduler() throws Exception {

		// --- Normal case ---

		final long startTime = System.currentTimeMillis();

		// interval = 0
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				final TimeEvent timeEvent = (TimeEvent) event;

				if (timeEvent.getSource().equals(TIME_EVENT_2_ID)) {

					final long duration = System.currentTimeMillis() - startTime;

					if (!isInRange(
						System.currentTimeMillis() - startTime,
						300,
						TIME_EVENT_TOLERANCE)) {
						assertionError =
								new AssertionError(
									"The scheduler was paused and resumed, but the duration of the time event is wrong: expected = "
											+ 300
											+ ", was = "
											+ duration
											+ ", tolerance = "
											+ TIME_EVENT_TOLERANCE);
					}

					setAllEventsReceived(true);
				}
			}
		});

		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);

		scheduler.pauseScheduler();

		while (System.currentTimeMillis() - 100 < startTime) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		scheduler.startScheduler();

		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
			assertionError = null;
		}

		// interval != 0
		setUp();
		
		final long startTime2 = System.currentTimeMillis();
		
		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				if(event instanceof TimeEvent) {
					
					final TimeEvent timeEvent = (TimeEvent) event;
	
					if (timeEvent.getSource().equals(TIME_EVENT_2_ID)) {
	
						final long duration = System.currentTimeMillis() - startTime2;
	
						if (!isInRange(
							System.currentTimeMillis() - startTime2,
							300,
							TIME_EVENT_TOLERANCE)) {
							assertionError =
									new AssertionError(
										"The scheduler was paused and resumed, but the duration of the time event is wrong: expected = "
												+ 300
												+ ", was = "
												+ duration
												+ ", tolerance = "
												+ TIME_EVENT_TOLERANCE);
						}
	
						setAllEventsReceived(true);
					}
				}
			}
		});

		scheduler.setSchedulerInterval(20);
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);

		scheduler.pauseScheduler();

		while (System.currentTimeMillis() - 100 < startTime2) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		scheduler.startScheduler();
		
		while (!isAllEventsReceived() && assertionError == null) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}

		// --- Exceptional case ---
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler#dispose()}
	 * .
	 */
	@Test
	public void testDispose() {

		// --- Normal case ---

		scheduler.addEventListener(new IEventListener() {

			public void receiveEvent(final IEvent event) {

				assertionError =
						new AssertionError(
							"The scheduler was disposed, but all the same an time event was received.");

			}

		});

		final long startTime = System.currentTimeMillis();
		scheduler.addTimeEventTask(TIME_EVENT_2_ID, TIME_EVENT_2_DELAY);

		scheduler.dispose();

		while ((System.currentTimeMillis() - startTime - 100) < TIME_EVENT_2_DELAY) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		if (assertionError != null) {
			fail(assertionError.getMessage());
		}

		// --- Exceptional case ---

		// Dispose a second time
		scheduler.dispose();
	}

	/**
	 * Checks if the given value is in valid number range.
	 * 
	 * @param valueToCheck defines the value to check
	 * @param expectedValue defines the expected value
	 * @param tolerance defines the tolerance
	 * 
	 * @return The result is <code>true</code> if the value is in the given
	 *         number range.
	 */
	private boolean isInRange(final long valueToCheck,
			final long expectedValue, final long tolerance) {

		boolean result = false;

		if (valueToCheck <= expectedValue + tolerance
			&& valueToCheck >= expectedValue - tolerance) {
			result = true;
		}

		return result;
	}

	/**
	 * @return the assertionError
	 */
	public AssertionError getAssertionError() {

		return assertionError;
	}

	/**
	 * @param assertionError the assertionError to set
	 */
	public void setAssertionError(final AssertionError assertionError) {

		this.assertionError = assertionError;
	}

	/**
	 * @return the allEventsReceived
	 */
	public boolean isAllEventsReceived() {

		return allEventsReceived;
	}

	/**
	 * @param allEventsReceived the allEventsReceived to set
	 */
	public void setAllEventsReceived(final boolean allEventsReceived) {

		this.allEventsReceived = allEventsReceived;
	}
}

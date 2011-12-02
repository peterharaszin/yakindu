/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_transition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerHandler;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class Test_TransitionCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private final ValuedEvent<Integer> EventEvent10 = new ValuedEvent<Integer>(
			"event10", 0);

	private static final TimeEvent State1_time_event_0 = new TimeEvent(
			"State1_time_event_0", false);
	private static final TimeEvent State1_time_event_1 = new TimeEvent(
			"State1_time_event_1", false);

	public enum State {
		State1, State2,
	};

	private InterfaceAImpl interfaceA;
	private DefaultInterfaceImpl defaultInterface;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final ArrayList<Event> occuredEvents;

	private final Collection<Event> outEvents;

	private ITimerHandler timerHandler;

	private long cycleStartTime;

	public Test_TransitionCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event>();
		outEvents = new HashSet<Event>();
		interfaceA = new InterfaceAImpl(this);
		defaultInterface = new DefaultInterfaceImpl(this);
		State1_time_event_0.setStatemachine(this);
		State1_time_event_1.setStatemachine(this);

	}

	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {

	}

	public void setTimerHandler(ITimerHandler timerHandler) {
		this.timerHandler = timerHandler;
	}

	public ITimerHandler getTimerHandler() {
		if (timerHandler == null) {
			throw new NullPointerException(
					"TimerHandler of statemachine \"+Test_Transition+\" not set!");
		}
		return timerHandler;
	}

	public void notify(Notification<?> notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getElement());
		}
	}

	public Set<State> getActiveStates() {
		return EnumSet.copyOf(activeStates);
	}

	public InterfaceA getInterfaceA() {
		return interfaceA;
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	private void raiseEvent10() {
		getOccuredEvents().add(EventEvent10);
	}

	private void raiseEvent10(int value) {
		EventEvent10.setValue(value);
		getOccuredEvents().add(EventEvent10);
	}

	private ValuedEvent<Integer> getEventEvent10() {
		return EventEvent10;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getTimerHandler().setTimer(State1_time_event_0, (10 * 1000),
				cycleStartTime);
		getTimerHandler().setTimer(State1_time_event_1, 100, cycleStartTime);

		activeStates.add(State.State1);

	}

	private void reactState1() {
		if ((occuredEvents.contains(interfaceA.getEventEvent1()) || occuredEvents
				.contains(interfaceA.getEventEvent2()))) {
			activeStates.remove(State.State1);
			getTimerHandler().resetTimer(State1_time_event_0);
			getTimerHandler().resetTimer(State1_time_event_1);

			activeStates.add(State.State2);

		} else {
			if ((defaultInterface.getVarI() == 5)) {
				activeStates.remove(State.State1);
				getTimerHandler().resetTimer(State1_time_event_0);
				getTimerHandler().resetTimer(State1_time_event_1);

				activeStates.add(State.State2);

			} else {
				if ((occuredEvents.contains(interfaceA.getEventEvent3()) && (defaultInterface
						.getVarJ() < 20))) {
					activeStates.remove(State.State1);
					getTimerHandler().resetTimer(State1_time_event_0);
					getTimerHandler().resetTimer(State1_time_event_1);

					activeStates.add(State.State2);

				} else {
					if (((occuredEvents.contains(interfaceA.getEventEvent3()) || occuredEvents
							.contains(interfaceA.getEventEvent4())) && (defaultInterface
							.getVarJ() > 30))) {
						activeStates.remove(State.State1);
						getTimerHandler().resetTimer(State1_time_event_0);
						getTimerHandler().resetTimer(State1_time_event_1);

						activeStates.add(State.State2);

					} else {
						if (occuredEvents.contains(defaultInterface
								.getEventEvent6())) {
							activeStates.remove(State.State1);
							getTimerHandler().resetTimer(State1_time_event_0);
							getTimerHandler().resetTimer(State1_time_event_1);

							defaultInterface.setVarI(15);

							activeStates.add(State.State2);

						} else {
							if (occuredEvents.contains(defaultInterface
									.getEventEvent7())) {
								activeStates.remove(State.State1);
								getTimerHandler().resetTimer(
										State1_time_event_0);
								getTimerHandler().resetTimer(
										State1_time_event_1);

								defaultInterface.setVarJ((defaultInterface
										.getVarI() * 9));

								activeStates.add(State.State2);

							} else {
								if (occuredEvents.contains(State1_time_event_0)) {
									activeStates.remove(State.State1);
									getTimerHandler().resetTimer(
											State1_time_event_0);
									getTimerHandler().resetTimer(
											State1_time_event_1);

									activeStates.add(State.State2);

								} else {
									if (occuredEvents
											.contains(State1_time_event_1)) {
										activeStates.remove(State.State1);
										getTimerHandler().resetTimer(
												State1_time_event_0);
										getTimerHandler().resetTimer(
												State1_time_event_1);

										activeStates.add(State.State2);

									} else {
										if (occuredEvents.contains(interfaceA
												.getEventEvent1())) {
											activeStates.remove(State.State1);
											getTimerHandler().resetTimer(
													State1_time_event_0);
											getTimerHandler().resetTimer(
													State1_time_event_1);

											activeStates.add(State.State2);

										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	private void reactState2() {
	}
	public void runCycle() {
		cycleStartTime = System.currentTimeMillis();
		outEvents.clear();
		for (State state : activeStates) {
			switch (state) {
				case State1 :
					reactState1();
					break;
				case State2 :
					reactState2();
					break;
				default :
					// no state found
			}
		}
		occuredEvents.clear();
	}
}

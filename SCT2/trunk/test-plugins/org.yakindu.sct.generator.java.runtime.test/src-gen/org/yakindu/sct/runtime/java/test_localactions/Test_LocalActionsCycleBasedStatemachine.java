/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_localactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.TimeEvent;
import org.yakindu.sct.runtime.java.ITimedStatemachine;
import org.yakindu.sct.runtime.java.ITimerService;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Notification;

public class Test_LocalActionsCycleBasedStatemachine
		implements
			ITimedStatemachine {

	private enum TimeEvents {
		State1_time_event_0, State2_time_event_0,
	}

	private static final TimeEvent<TimeEvents> State1_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.State1_time_event_0, true);
	private static final TimeEvent<TimeEvents> State2_time_event_0 = new TimeEvent<TimeEvents>(
			TimeEvents.State2_time_event_0, false);

	public enum State {
		State1, State2,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final ArrayList<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	private ITimerService timerService;

	private long cycleStartTime;

	public Test_LocalActionsCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event<? extends Enum<?>>>();
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceImpl(this);
		State1_time_event_0.setStatemachine(this);
		State2_time_event_0.setStatemachine(this);

	}

	protected Collection<Event<? extends Enum<?>>> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event<? extends Enum<?>>> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {

	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public void setTimerService(ITimerService timerService) {
		this.timerService = timerService;
	}

	public ITimerService getTimerService() {
		if (timerService == null) {
			throw new NullPointerException(
					"TimerService of statemachine \"+Test_LocalActions+\" not set!");
		}
		return timerService;
	}

	public void notify(Notification<?> notification) {
		if (notification instanceof EventNotification) {
			EventNotification eventNotification = (EventNotification) notification;
			getOccuredEvents().add(eventNotification.getElement());
		}
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void enter() {
		cycleStartTime = System.currentTimeMillis();
		getTimerService().setTimer(State1_time_event_0, 100, cycleStartTime);
		defaultInterface.setVarI(1);

		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void reactState1() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			stateVector[0] = null;

			getTimerService().resetTimer(State1_time_event_0);
			defaultInterface.setVarI(0);

			getTimerService()
					.setTimer(State2_time_event_0, 200, cycleStartTime);
			defaultInterface.setVarJ(1);

			nextStateIndex = 0;
			stateVector[0] = State.State2;

		} else {
			if (true) {
				defaultInterface.setVarI(2);

			}
			if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
				defaultInterface.setVarI(3);

			}
			if (occuredEvents.contains(State1_time_event_0)) {
				defaultInterface.setVarC(defaultInterface.getVarC() + (1));

			}

		}
	}
	private void reactState2() {
		if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
			stateVector[0] = null;

			getTimerService().resetTimer(State2_time_event_0);
			defaultInterface.setVarJ(0);

			getTimerService()
					.setTimer(State1_time_event_0, 100, cycleStartTime);
			defaultInterface.setVarI(1);

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if ((occuredEvents.contains(defaultInterface.getEventEvent2()) || occuredEvents
					.contains(defaultInterface.getEventEvent4()))) {
				defaultInterface.setVarJ(2);

			}
			if (occuredEvents.contains(State2_time_event_0)) {
				defaultInterface.setVarJ(3);

			}

		}
	}
	public void runCycle() {
		cycleStartTime = System.currentTimeMillis();
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			if (stateVector[nextStateIndex] != null) {
				switch (stateVector[nextStateIndex]) {
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
		}
		occuredEvents.clear();
	}
}

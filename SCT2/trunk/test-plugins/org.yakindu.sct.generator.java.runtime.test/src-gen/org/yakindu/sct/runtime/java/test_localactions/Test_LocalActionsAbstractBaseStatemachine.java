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
package org.yakindu.sct.runtime.java.test_localactions;

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

public abstract class Test_LocalActionsAbstractBaseStatemachine
		implements
			ITimedStatemachine {

	private static final TimeEvent State1_time_event_0 = new TimeEvent(
			"State1_time_event_0", true);
	private static final TimeEvent State2_time_event_0 = new TimeEvent(
			"State2_time_event_0", false);

	public enum State {
		State1, State2,
	};

	private InterfaceDefaultImpl interfaceDefault;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final Collection<Event> occuredEvents;

	private final Collection<Event> outEvents;

	private ITimerHandler timerHandler;

	private long cycleStartTime;

	public Test_LocalActionsAbstractBaseStatemachine(
			Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
		interfaceDefault = new InterfaceDefaultImpl(this);
	}

	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !getOccuredEvents().isEmpty();
	}

	public void init() {

	}

	public void setTimerHandler(ITimerHandler timerHandler) {
		this.timerHandler = timerHandler;
	}

	public ITimerHandler getTimerHandler() {
		if (timerHandler == null) {
			throw new NullPointerException(
					"TimerHandler of statemachine \"+Test_LocalActions+\" not set!");
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

	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}

	public void enterSequenceStatechartTest_LocalActions() {
		cycleStartTime = System.currentTimeMillis();
		enterSequenceState1();
	}

	private boolean conditionState1Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent1());
	}
	private boolean conditionState1Lr2(Collection<?> events) {
		return true;
	}
	private boolean conditionState1Lr3(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent2());
	}
	private boolean conditionState1Lr4(Collection<?> events) {
		return getOccuredEvents().contains(State1_time_event_0);
	}
	private boolean conditionState2Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent3());
	}
	private boolean conditionState2Lr2(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceDefault.getEventEvent2()) || getOccuredEvents()
				.contains(interfaceDefault.getEventEvent4()));
	}
	private boolean conditionState2Lr3(Collection<?> events) {
		return getOccuredEvents().contains(State2_time_event_0);
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Lr2() {
		interfaceDefault.setVarI(2);

	}
	private void actionsState1Lr3() {
		interfaceDefault.setVarI(3);

	}
	private void actionsState1Lr4() {
		interfaceDefault.setVarC(interfaceDefault.getVarC() + (1));

	}
	private void actionsState2Tr0() {
		exitSequenceState2();
		enterSequenceState1();

	}
	private void actionsState2Lr2() {
		interfaceDefault.setVarJ(2);

	}
	private void actionsState2Lr3() {
		interfaceDefault.setVarJ(3);

	}
	private void entryActionState1() {
		getTimerHandler().setTimer(State1_time_event_0, 100, cycleStartTime);
		interfaceDefault.setVarI(1);

	}
	private void entryActionState2() {
		getTimerHandler().setTimer(State2_time_event_0, 200, cycleStartTime);
		interfaceDefault.setVarJ(1);

	}
	private void exitActionState1() {
		getTimerHandler().resetTimer(State1_time_event_0);
		interfaceDefault.setVarI(0);

	}
	private void exitActionState2() {
		getTimerHandler().resetTimer(State2_time_event_0);
		interfaceDefault.setVarJ(0);

	}

	private void enterSequenceState1() {
		entryActionState1();
		activeStates.add(State.State1);
	}

	private void enterSequenceState2() {
		entryActionState2();
		activeStates.add(State.State2);
	}
	private void exitSequenceState1() {
		activeStates.remove(State.State1);
		exitActionState1();
	}
	private void exitSequenceState2() {
		activeStates.remove(State.State2);
		exitActionState2();
	}
	private void cycleState1(Collection<?> events) {
		if (conditionState1Tr0(events)) {
			actionsState1Tr0();
		} else {
			if (conditionState1Lr2(events)) {
				actionsState1Lr2();
			}
			if (conditionState1Lr3(events)) {
				actionsState1Lr3();
			}
			if (conditionState1Lr4(events)) {
				actionsState1Lr4();
			}

		}
	}
	private void cycleState2(Collection<?> events) {
		if (conditionState2Tr0(events)) {
			actionsState2Tr0();
		} else {
			if (conditionState2Lr2(events)) {
				actionsState2Lr2();
			}
			if (conditionState2Lr3(events)) {
				actionsState2Lr3();
			}

		}
	}
	protected void runCycle(Collection<?> events) {
		cycleStartTime = System.currentTimeMillis();
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
				case State1 :
					cycleState1(events);
					break;
				case State2 :
					cycleState2(events);
					break;
				default :
					// no state found
			}
		}
	}
}

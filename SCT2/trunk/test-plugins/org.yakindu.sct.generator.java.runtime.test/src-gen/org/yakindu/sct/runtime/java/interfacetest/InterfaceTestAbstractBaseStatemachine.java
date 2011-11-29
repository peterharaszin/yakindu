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
package org.yakindu.sct.runtime.java.interfacetest;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public abstract class InterfaceTestAbstractBaseStatemachine
		implements
			IStatemachine {

	public enum State {
		State1, State2, State3, State4,
	};

	private InterfaceDefaultImpl interfaceDefault;
	private InterfaceOtherImpl interfaceOther;
	private InterfaceThirdImpl interfaceThird;

	private final Set<State> activeStates = EnumSet.noneOf(State.class);

	private final Collection<Event> occuredEvents;

	private final Collection<Event> outEvents;

	public InterfaceTestAbstractBaseStatemachine(Collection<Event> occuredEvents) {
		this.occuredEvents = occuredEvents;
		this.outEvents = new HashSet<Event>();
		interfaceDefault = new InterfaceDefaultImpl(this);
		interfaceOther = new InterfaceOtherImpl(this);
		interfaceThird = new InterfaceThirdImpl(this);
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

	public Set<State> getActiveStates() {
		return EnumSet.copyOf(activeStates);
	}

	public InterfaceDefault getInterfaceDefault() {
		return interfaceDefault;
	}

	public InterfaceOther getInterfaceOther() {
		return interfaceOther;
	}

	public InterfaceThird getInterfaceThird() {
		return interfaceThird;
	}

	public void enterSequenceStatechartInterfaceTest() {
		enterSequenceState1();
	}

	private boolean conditionState1Tr0(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceDefault.getEventEvent1()) && (interfaceDefault
				.getVarVar2() > 0));
	}
	private boolean conditionState1Tr1(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceOther.getEventEvent3()) && (interfaceDefault
				.getVarVar3() == 1));
	}
	private boolean conditionState1Tr2(Collection<?> events) {
		return (getOccuredEvents().contains(interfaceThird.getEventEvent5()) && (interfaceDefault
				.getVarVar1() == true));
	}
	private boolean conditionState2Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceDefault.getEventEvent1());
	}
	private boolean conditionState3Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceOther.getEventEvent3());
	}
	private boolean conditionState4Tr0(Collection<?> events) {
		return getOccuredEvents().contains(interfaceThird.getEventEvent5());
	}
	private void actionsState1Tr0() {
		exitSequenceState1();
		enterSequenceState2();

	}
	private void actionsState1Tr1() {
		exitSequenceState1();
		enterSequenceState3();

	}
	private void actionsState1Tr2() {
		exitSequenceState1();
		enterSequenceState4();

	}
	private void actionsState2Tr0() {
		exitSequenceState2();
		enterSequenceState1();

	}
	private void actionsState3Tr0() {
		exitSequenceState3();
		enterSequenceState1();

	}
	private void actionsState4Tr0() {
		exitSequenceState4();
		enterSequenceState1();

	}
	private void entryActionState2() {
		interfaceDefault.raiseEvent2(22);

	}
	private void entryActionState3() {
		interfaceOther.raiseEvent4();

	}
	private void entryActionState4() {
		interfaceThird.raiseEvent6(true);

	}

	private void enterSequenceState1() {
		activeStates.add(State.State1);
	}

	private void enterSequenceState2() {
		entryActionState2();
		activeStates.add(State.State2);
	}

	private void enterSequenceState3() {
		entryActionState3();
		activeStates.add(State.State3);
	}

	private void enterSequenceState4() {
		entryActionState4();
		activeStates.add(State.State4);
	}
	private void exitSequenceState1() {
		activeStates.remove(State.State1);
	}
	private void exitSequenceState2() {
		activeStates.remove(State.State2);
	}
	private void exitSequenceState3() {
		activeStates.remove(State.State3);
	}
	private void exitSequenceState4() {
		activeStates.remove(State.State4);
	}
	private void cycleState1(Collection<?> events) {
		if (conditionState1Tr0(events)) {
			actionsState1Tr0();
		} else {
			if (conditionState1Tr1(events)) {
				actionsState1Tr1();
			} else {
				if (conditionState1Tr2(events)) {
					actionsState1Tr2();
				}
			}
		}
	}
	private void cycleState2(Collection<?> events) {
		if (conditionState2Tr0(events)) {
			actionsState2Tr0();
		}
	}
	private void cycleState3(Collection<?> events) {
		if (conditionState3Tr0(events)) {
			actionsState3Tr0();
		}
	}
	private void cycleState4(Collection<?> events) {
		if (conditionState4Tr0(events)) {
			actionsState4Tr0();
		}
	}
	protected void runCycle(Collection<?> events) {
		getOutEvents().clear();
		for (State state : activeStates) {
			switch (state) {
				case State1 :
					cycleState1(events);
					break;
				case State2 :
					cycleState2(events);
					break;
				case State3 :
					cycleState3(events);
					break;
				case State4 :
					cycleState4(events);
					break;
				default :
					// no state found
			}
		}
	}
}

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

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceDefaultImpl extends NotificationSender
		implements
			InterfaceDefault {

	private final Event EventEvent1 = new Event("event1");
	private final ValuedEvent<Integer> EventEvent2 = new ValuedEvent<Integer>(
			"event2", 0);

	private InterfaceTestAbstractBaseStatemachine statemachine;

	public InterfaceDefaultImpl(
			InterfaceTestAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}

	public Event getEventEvent1() {
		return EventEvent1;
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}

	public void raiseEvent2(int value) {
		EventEvent2.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}

	public ValuedEvent<Integer> getEventEvent2() {
		return EventEvent2;
	}

	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(EventEvent2);
	}

	private boolean varVar1;

	public boolean getVarVar1() {
		return varVar1;
	}

	public void setVarVar1(boolean value) {
		varVar1 = value;
	}
	private double varVar2 = 2.3;

	public double getVarVar2() {
		return varVar2;
	}

	public void setVarVar2(double value) {
		varVar2 = value;
	}
	private int varVar3 = 1;

	public int getVarVar3() {
		return varVar3;
	}

	public void setVarVar3(int value) {
		varVar3 = value;
	}
}

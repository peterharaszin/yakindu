/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.runtime.java.test_expression;

import org.yakindu.sct.runtime.java.EventNotification;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;

public class InterfaceDefaultImpl extends NotificationSender implements InterfaceDefault {
	
	private final Event<Integer> EventEvent1 = new Event<Integer>("event1", 0); 
	private final Event<Double> EventEvent2 = new Event<Double>("event2", 0D); 
	
	private Test_ExpressionAbstractBaseStatemachine statemachine; 
	
	public InterfaceDefaultImpl(Test_ExpressionAbstractBaseStatemachine statemachine) {
		this.statemachine = statemachine;
	}
	
	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(EventEvent1);
	}
	
	public void raiseEvent1(int value) {
		EventEvent1.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent1);
	}
	
	public Event<Integer> getEventEvent1() {
		return EventEvent1;
	}
	
	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}
	
	public void raiseEvent2(double value) {
		EventEvent2.setValue(value);
		statemachine.getOccuredEvents().add(EventEvent2);
		statemachine.getOutEvents().add(EventEvent2);
		notifyListeners(new EventNotification(EventEvent2));
	}
	
	public Event<Double> getEventEvent2() {
		return EventEvent2;
	}
	
	public boolean isRaisedEvent2() {
		return statemachine.getOutEvents().contains(EventEvent2);
	}
	
	private int varVar1 = 6;
	
	public int getVarVar1() {
		return varVar1;
	}
	
	public void setVarVar1(int value) {
		varVar1 = value;
	}	
	private int varVar2;
	
	public int getVarVar2() {
		return varVar2;
	}
	
	public void setVarVar2(int value) {
		varVar2 = value;
	}	
	private double varVar3 = 19.4;
	
	public double getVarVar3() {
		return varVar3;
	}
	
	public void setVarVar3(double value) {
		varVar3 = value;
	}	
	private double varVar4;
	
	public double getVarVar4() {
		return varVar4;
	}
	
	public void setVarVar4(double value) {
		varVar4 = value;
	}	
}

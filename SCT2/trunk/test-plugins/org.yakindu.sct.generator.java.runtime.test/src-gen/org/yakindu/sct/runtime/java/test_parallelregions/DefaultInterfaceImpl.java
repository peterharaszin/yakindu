/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_parallelregions;

import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.VariableNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class DefaultInterfaceImpl extends NotificationSender
		implements
			IDefaultInterfaceImpl {
	protected Map<String, Object> variableMap;
	protected Map<String, Event<Events>> inEventMap;

	protected Test_ParallelRegionsCycleBasedStatemachine statemachine;

	public DefaultInterfaceImpl(
			Test_ParallelRegionsCycleBasedStatemachine statemachine) {

		this.statemachine = statemachine;
		variableMap = new HashMap<String, Object>();
		variableMap.put("reg3", new Integer(0));
		variableMap.put("hierarchy", new Integer(0));

		inEventMap = new HashMap<String, Event<Events>>();

		inEventMap.put("event1", new Event<Events>(Events.Event1, 0));
		inEventMap.put("event2", new Event<Events>(Events.Event2, 0));
		inEventMap.put("event3", new Event<Events>(Events.Event3, 0));
		inEventMap.put("event4", new Event<Events>(Events.Event4, 0));
		inEventMap.put("event5", new Event<Events>(Events.Event5, 0));
		inEventMap.put("event6", new Event<Events>(Events.Event6, 0));
		inEventMap.put("event7", new Event<Events>(Events.Event7, 0));
		inEventMap.put("event8", new Event<Events>(Events.Event8, 0));
		inEventMap.put("event9", new Event<Events>(Events.Event9, 0));
		inEventMap.put("event10", new Event<Events>(Events.Event10, 0));
		inEventMap.put("event11", new Event<Events>(Events.Event11, 0));
		inEventMap.put("event12", new Event<Events>(Events.Event12, 0));
		inEventMap.put("event13", new Event<Events>(Events.Event13, 0));
		inEventMap.put("event14", new Event<Events>(Events.Event14, 0));
	}

	public void raiseEvent1() {
		statemachine.getOccuredEvents().add(getEventEvent1());
	}

	public Event<Events> getEventEvent1() {
		return inEventMap.get("event1");
	}

	public void raiseEvent2() {
		statemachine.getOccuredEvents().add(getEventEvent2());
	}

	public Event<Events> getEventEvent2() {
		return inEventMap.get("event2");
	}

	public void raiseEvent3() {
		statemachine.getOccuredEvents().add(getEventEvent3());
	}

	public Event<Events> getEventEvent3() {
		return inEventMap.get("event3");
	}

	public void raiseEvent4() {
		statemachine.getOccuredEvents().add(getEventEvent4());
	}

	public Event<Events> getEventEvent4() {
		return inEventMap.get("event4");
	}

	public void raiseEvent5() {
		statemachine.getOccuredEvents().add(getEventEvent5());
	}

	public Event<Events> getEventEvent5() {
		return inEventMap.get("event5");
	}

	public void raiseEvent6() {
		statemachine.getOccuredEvents().add(getEventEvent6());
	}

	public Event<Events> getEventEvent6() {
		return inEventMap.get("event6");
	}

	public void raiseEvent7() {
		statemachine.getOccuredEvents().add(getEventEvent7());
	}

	public Event<Events> getEventEvent7() {
		return inEventMap.get("event7");
	}

	public void raiseEvent8() {
		statemachine.getOccuredEvents().add(getEventEvent8());
	}

	public Event<Events> getEventEvent8() {
		return inEventMap.get("event8");
	}

	public void raiseEvent9() {
		statemachine.getOccuredEvents().add(getEventEvent9());
	}

	public Event<Events> getEventEvent9() {
		return inEventMap.get("event9");
	}

	public void raiseEvent10() {
		statemachine.getOccuredEvents().add(getEventEvent10());
	}

	public Event<Events> getEventEvent10() {
		return inEventMap.get("event10");
	}

	public void raiseEvent11() {
		statemachine.getOccuredEvents().add(getEventEvent11());
	}

	public Event<Events> getEventEvent11() {
		return inEventMap.get("event11");
	}

	public void raiseEvent12() {
		statemachine.getOccuredEvents().add(getEventEvent12());
	}

	public Event<Events> getEventEvent12() {
		return inEventMap.get("event12");
	}

	public void raiseEvent13() {
		statemachine.getOccuredEvents().add(getEventEvent13());
	}

	public Event<Events> getEventEvent13() {
		return inEventMap.get("event13");
	}

	public void raiseEvent14() {
		statemachine.getOccuredEvents().add(getEventEvent14());
	}

	public Event<Events> getEventEvent14() {
		return inEventMap.get("event14");
	}

	public int getVarReg3() {
		return (Integer) variableMap.get("reg3");
	}

	public void setVarReg3(int value) {
		int oldValue = getVarReg3();
		variableMap.put("reg3", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
				Variables.reg3, getVarReg3(), oldValue));
	}
	public int getVarHierarchy() {
		return (Integer) variableMap.get("hierarchy");
	}

	public void setVarHierarchy(int value) {
		int oldValue = getVarHierarchy();
		variableMap.put("hierarchy", new Integer(value));
		notifyListenersOnVariableChanged(new VariableNotification<Integer>(
				Variables.hierarchy, getVarHierarchy(), oldValue));
	}

	public boolean raiseEvent(String name) {
		if (inEventMap.get(name) != null) {
			return statemachine.getOccuredEvents().add(inEventMap.get(name));
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean raiseEvent(String name, Object value) {
		if (inEventMap.get(name) != null
				&& inEventMap.get(name) instanceof ValuedEvent) {
			ValuedEvent<?, ?> event = (ValuedEvent<?, ?>) inEventMap.get(name);
			if (event.getValue().getClass() == value.getClass()) {
				((ValuedEvent<Events, Object>) event).setValue(value);
				return statemachine.getOccuredEvents()
						.add(inEventMap.get(name));
			}
		}
		return false;
	}

	public boolean setVariable(String name, Object value) {
		if (variableMap.get(name) != null
				&& variableMap.get(name).getClass() == value.getClass()) {
			Object oldValue = variableMap.get(name);
			variableMap.put(name, value);
			notifyListenersOnVariableChanged(new VariableNotification<Object>(
					Variables.valueOf(name), variableMap.get(name), oldValue));
			return true;
		}
		return false;
	}

	public Object getVariable(String name) {
		return variableMap.get(name);
	}
}

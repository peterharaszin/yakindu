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
package org.yakindu.sct.simulation.core.runtime.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.simulation.core.runtime.ExecutionException;
import org.yakindu.sct.simulation.core.runtime.IEventSlot;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.ISlot;
import org.yakindu.sct.simulation.core.runtime.ISlotChangedEvent;
import org.yakindu.sct.simulation.core.runtime.ISlotContext;

import com.google.common.collect.Maps;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions and refactorings
 * 
 */
public class ExecutionContextImpl extends AbstractExecutionContext implements
		IExecutionContext, ISlotContext {

	private List<ExecutionVariable> variables;
	private List<ExecutionEvent> declaredEvents;
	protected List<ExecutionEvent> scheduledToRaiseEvents;
	protected List<ExecutionEvent> raisedEvents;
	private ExecutionState[] activeStateConfig;
	private Map<Integer, ExecutionState> historyStateConfig;

	public ExecutionContextImpl() {
		variables = new ArrayList<ExecutionVariable>();
		declaredEvents = new ArrayList<ExecutionEvent>();
		raisedEvents = new ArrayList<ExecutionEvent>();
		scheduledToRaiseEvents = new ArrayList<ExecutionEvent>();
		activeStateConfig = null;
		historyStateConfig = null;
	}

	public List<ExecutionEvent> getDeclaredEvents() {
		synchronized (declaredEvents) {
			return Collections.unmodifiableList(declaredEvents);
		}
	}

	public List<ExecutionEvent> getScheduledToRaiseEvents() {
		synchronized (scheduledToRaiseEvents) {
			return Collections.unmodifiableList(scheduledToRaiseEvents);
		}
	}

	public void declareEvent(ExecutionEvent event) {
		synchronized (declaredEvents) {
			event.setContext(this);
			declaredEvents.add(event);
		}
	}

	public List<ExecutionEvent> getRaisedEvents() {
		return Collections.unmodifiableList(raisedEvents);
	}

	public List<ExecutionEvent> getScheduledEvents() {
		return Collections.unmodifiableList(scheduledToRaiseEvents);
	}

	public void resetRaisedEvents() {
		synchronized (raisedEvents) {
			raisedEvents.clear();
		}
	}
	
	public void scheduleEvent(String eventName, Object value) {
		ExecutionEvent event = getDeclaredEvent(eventName);
		if (event == null)
			throw new ExecutionException("Event with name " + eventName
					+ " is undefined!");
		ExecutionEvent eventCopy = event.getCopy();
		if (value != null) {
			eventCopy.setValue(value);
		}
		synchronized (scheduledToRaiseEvents) {
			scheduledToRaiseEvents.add(eventCopy);
		}
	}

	public  void raiseEvent(String eventName, Object value) {
		synchronized (raisedEvents) {
			ExecutionEvent event = getDeclaredEvent(eventName);
			if (event == null)
				throw new ExecutionException("Event with name " + eventName
						+ " is undefined!");
			event.raise(value);
//			ExecutionEvent eventCopy = event.getCopy();
//			if (value != null) {
//				eventCopy.setValue(value);
//			}
//			raisedEvents.add(eventCopy);
//			notifyEventRaised(eventCopy);
		}
	}

	public void flush() {
		synchronized (scheduledToRaiseEvents) {
			for (IEventSlot event : scheduledToRaiseEvents) {
				raiseEvent(event.getName(), event.getValue());
			}
			scheduledToRaiseEvents.clear();
		}
	}

	@Override
	public ExecutionEvent getDeclaredEvent(String eventName) {
		synchronized (declaredEvents) {
			for (ExecutionEvent event : declaredEvents) {
				if (event.getName().equals(eventName))
					return event;
			}
		}
		return null;
	}

	public boolean isEventRaised(String eventName) {
		synchronized (raisedEvents) {
			return getDeclaredEvent(eventName).isRaised();
//			for (IEventSlot event : raisedEvents) {
//				if (eventName.equals(event.getName())) {
//					return true;
//				}
//			}
		}
//		return false;
	}

	public List<ExecutionVariable> getVariables() {
		return Collections.unmodifiableList(variables);
	}

	public ExecutionVariable getVariable(String varName) {
		synchronized (variables) {
			for (ExecutionVariable variable : variables) {
				if (varName.equals(variable.getName())) {
					return variable;
				}
			}
		}
		return null;
	}

	public void declareVariable(ExecutionVariable variable) {
		synchronized (variables) {
			variables.add(variable);
		}
	}

	public void setSlotValue(String name, Object value)
			throws ExecutionException {
		ISlot slot = getVariable(name);
		if(slot == null)
			slot = getDeclaredEvent(name);
		if (slot == null)
			throw new ExecutionException("Unknown slot " + name);
		slot.setValue(value);
	}

	public ExecutionState[] getStateConfiguration() {
		return activeStateConfig;
	}

	public ExecutionState getHistoryStateConfiguration(ExecutionRegion region) {
		return historyStateConfig.get(region.getHistoryVector().getOffset());
	}

	public void saveHistoryStateConfiguration(ExecutionRegion region) {
		historyStateConfig.put(region.getHistoryVector().getOffset(),
				getStateConfiguration()[region.getStateVector().getOffset()]);
	}

	public void initStateConfigurationVector(int size) {
		activeStateConfig = new ExecutionState[size];
		for (int i = 0; i < size; i++) {
			activeStateConfig[i] = null;
		}
		historyStateConfig = Maps.newHashMap();
	}

	public void call(String procedureId) {
		// TODO: Implement me
	}

	public Set<RegularState> getActiveLeafStates() {
		Set<RegularState> vertices = new HashSet<RegularState>();
		for (ExecutionState state : activeStateConfig) {
			if (state != null)
				vertices.add((RegularState) state.getSourceElement());
		}
		return vertices;
	}

	public Set<RegularState> getAllActiveStates() {
		Set<RegularState> vertices = new HashSet<RegularState>();
		for (ExecutionState state : activeStateConfig) {
			if (state != null)
				vertices.addAll(getActiveHierachy((RegularState) state
						.getSourceElement()));
		}
		return vertices;
	}

	private Collection<? extends RegularState> getActiveHierachy(
			RegularState vertex) {
		List<RegularState> result = new ArrayList<RegularState>();
		result.add(vertex);
		EObject container = vertex.eContainer();
		while (container != null) {
			if (container instanceof State) {
				result.add((State) container);
			}
			container = container.eContainer();
		}
		return result;
	}


	public void unraiseEvent(String eventName) {
		synchronized (raisedEvents) {
			getDeclaredEvent(eventName).unraise();
//			Iterator<ExecutionEvent> iterator = raisedEvents.iterator();
//			while (iterator.hasNext()) {
//				if (iterator.next().getName().equals(eventName)) {
//					iterator.remove();
//				}
//			}
		}
	}

	public void unscheduleEvent(String eventName) {
		synchronized (scheduledToRaiseEvents) {
			Iterator<ExecutionEvent> iterator = scheduledToRaiseEvents
					.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getName().equals(eventName)) {
					iterator.remove();
				}
			}
		}
	}

	public boolean isEventScheduled(String name) {
		synchronized (scheduledToRaiseEvents) {
			for (IEventSlot event : scheduledToRaiseEvents) {
				if (name.equals(event.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	
	public void slotChanged(ISlot slot, ISlotChangedEvent changeEvent) {
		if (changeEvent instanceof IEventSlot.SlotEventRaised) {
			raisedEvents.add((ExecutionEvent)slot);
			notifyEventRaised((ExecutionEvent)slot);			
		} else if ( changeEvent instanceof IEventSlot.SlotEventUnraised ) {
			raisedEvents.remove((ExecutionEvent)slot);
		} else if (changeEvent instanceof ISlot.SlotValueChanged) {
			notifyValueChanged(slot);
		}
	}
	
	
}

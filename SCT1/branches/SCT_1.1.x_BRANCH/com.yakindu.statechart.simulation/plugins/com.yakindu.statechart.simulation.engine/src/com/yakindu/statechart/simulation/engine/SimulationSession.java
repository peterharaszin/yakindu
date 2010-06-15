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
package com.yakindu.statechart.simulation.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;
import java.util.concurrent.BlockingQueue;

import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import statemachine.DataElement;

import com.yakindu.statechart.model.expressions.runtime.Variable;
import com.yakindu.statechart.runtime.Event;
import com.yakindu.statechart.runtime.SignalEvent;
import com.yakindu.statechart.runtime.State;
import com.yakindu.statechart.runtime.Statechart;
import com.yakindu.statechart.runtime.StatechartListener;
import com.yakindu.statechart.runtime.TimeEvent;
import com.yakindu.statechart.runtime.TimingService;
import com.yakindu.statechart.runtime.Transition;

public class SimulationSession implements Runnable, StatechartListener, TimingService {

	protected boolean terminate = false;
	protected boolean reschedule = true;
	protected Timer timer;
	
	protected BlockingQueue<Runnable> taskQueue;
	protected Queue<IEvent> eventQueue;
	protected Statechart statechart;
	protected String uuid;
	protected int instanceNumber;
	protected ISimulationEngine engine;

	protected Map<statemachine.Variable, Double> variableValueMap = new HashMap<statemachine.Variable, Double>();
	protected Map<statemachine.Event, Boolean> eventValueMap = new HashMap<statemachine.Event, Boolean>();

	/** Specifies the current simulation state. */
	private volatile SimulationState simulationState = null;

	
	public SimulationSession(ISimulationEngine engine, Statechart statechart, BlockingQueue<Runnable> taskQueue, Queue<IEvent> eventQueue, String uuid, int id) {
		super();
		this.engine = engine;
		this.statechart = statechart;
		statechart.setListener(this);
		statechart.setTimingService(this);
		
		this.uuid = uuid;
		this.instanceNumber = id;

		this.taskQueue = taskQueue;
		this.eventQueue = eventQueue;

		initialize();
	}

	
	private void initialize() {
		updateVariableList();
		updateSignalList(new HashMap<statemachine.Event, Boolean>());
	}


	public SimulationState getSimulationState() {
		return simulationState;
	}


	public void setSimulationState(SimulationState simulationState) {
		this.simulationState = simulationState;
	}


	public void start() throws SimulationException {
		if (simulationState == null) {
			simulationState = SimulationState.RUNNING;
			eventQueue.add(new SimulationEvent(SimulationEventTypes.SimStart, engine));
			enterStatechart();
		}
	}
	
	public void resume() throws SimulationException {
		if (getSimulationState() == SimulationState.PAUSED) {
			taskQueue.add(new Runnable(){ public void run(){ 
				simulationState = SimulationState.RUNNING;
				eventQueue.add(new SimulationEvent(SimulationEventTypes.SimResume, engine));
				reschedule = true;
				runCycle();
			}});
		}
	}

	public void pause() throws SimulationException {
		if (getSimulationState() == SimulationState.RUNNING) {
			taskQueue.add(new Runnable(){ public void run(){ 
				simulationState = SimulationState.PAUSED;
				eventQueue.add(new SimulationEvent(SimulationEventTypes.SimPause, engine));
				reschedule = false;
			}});
		}
	}

	public void singleStepForward() throws SimulationException {
		taskQueue.add(new Runnable(){ public void run(){ 
			eventQueue.add(new SimulationEvent(SimulationEventTypes.SimResume, engine));
			intenalRunCycle();
			eventQueue.add(new SimulationEvent(SimulationEventTypes.SimPause, engine));
		}});
	}


	public void stop() throws SimulationException {
		if (simulationState == SimulationState.RUNNING || simulationState == simulationState.PAUSED) {
			leaveStatechart();

			SynchronousTask task = new SynchronousTask(){ public void exec() {
				simulationState = SimulationState.STOPPED;
				eventQueue.add(new SimulationEvent(SimulationEventTypes.SimStop, engine));	
			}};
			taskQueue.add(task);
			
			task.waitForCompletion(500);
		}


	}

	
	public void terminate() {
		terminate=true;
		taskQueue.add(new Runnable(){ public void run() {terminate=true;}});
	}
	
	
	public void enterStatechart() {
		taskQueue.add(new Runnable(){ public void run() {
			statechart.enter();
			schedule();
		}});
	}

	
	public void runCycle() {
		taskQueue.add(new Runnable(){
			public void run() {
				intenalRunCycle();
				schedule();
			}
		});
	}

	public void leaveStatechart() {
		taskQueue.add(new Runnable(){ public void run() {
			List<State> states = new ArrayList<State>(statechart.getCurrentStateConfiguration());
			statechart.leave();
			for (State state : states) {
				stateLeft(state);
			}
		}});
	}

	public void setVariable(final statemachine.Variable variable, final Object value) {
		taskQueue.add(new Runnable(){ public void run() {
			Variable var = statechart.getVariable(variable.getName());
			var.setValue(value);
		}});
	}

	public void raiseEvent(final statemachine.Event event) {
		taskQueue.add(new Runnable(){ public void run() {
			Map<statemachine.Event, Boolean> snapshot = new HashMap<statemachine.Event, Boolean>(eventValueMap);
			statechart.raise(event.getName());
			updateSignalList(snapshot);
		}});
	}


	public void resetEvent(final statemachine.Event event) {
		taskQueue.add(new Runnable(){ public void run() {
			Map<statemachine.Event, Boolean> snapshot = new HashMap<statemachine.Event, Boolean>(eventValueMap);
			statechart.reset(event.getName());
			updateSignalList(snapshot);
		}});
	}

	protected void schedule() {
		if(reschedule) {
			timer.schedule(new TimerTask() {
				@Override
				public void run() { 
					runCycle(); 
				}
				
			}, 100);

		}
	}
	
	
	protected void intenalRunCycle() {
		Map<statemachine.Event, Boolean> snapshot = new HashMap<statemachine.Event, Boolean>(eventValueMap);
		statechart.runCycle();
		updateVariableList();
		updateSignalList(snapshot);
	}
	
	
	public void sendActiveStates() {
		taskQueue.add(new Runnable() { public void run(){
			for (statemachine.State state : getActiveStates()) {
				eventQueue.add(new StatemachineEvent(
					StatemachineEventTypes.StateEnabled,
					state,
					uuid, instanceNumber));
			
		}}});
	}
	
	
	public List<statemachine.State> getActiveStates() {
		List<statemachine.State> activeStates = new ArrayList<statemachine.State>();
		if (statechart != null ) {
			for (State state : statechart.getCurrentStateConfiguration()) {
				activeStates.add((statemachine.State)statechart.getAliasByElement(state));
			}
		}	
		return activeStates;
	}


	// TODO refactor with engine to differentiate between variables and events
	public boolean setItem(String name, Double value) {
		SignalEvent event = statechart.getSignalEvent(name);
		Variable variable = statechart.getVariable(name);
		if (event == null && variable == null) {
			return false;
		}
		if (event != null) {
			if(value == 1.0) raiseEvent((statemachine.Event)statechart.getAliasByElement(event));
			else resetEvent((statemachine.Event)statechart.getAliasByElement(event));
		}
		if (variable != null) {
			Object convertedValue = value;
			if (variable.getType() == Boolean.class) {
				convertedValue = value != 0.0;
			} else if (variable.getType() == Integer.class) {
				convertedValue = value.intValue();
			} else if (variable.getType() == Float.class) {
				convertedValue = value.floatValue();
			}
			setVariable((statemachine.Variable)statechart.getAliasByElement(variable), convertedValue);
		}
		return true;
	}

	
	private void updateSignalList(Map<statemachine.Event, Boolean> oldEventValues) {
		Map<statemachine.Event, Boolean> newEvents = new HashMap<statemachine.Event, Boolean>();
		Set<Event> raisedEvents = statechart.getRaisedEvents(); 
		for (SignalEvent e:statechart.getSignalEvents()) {
			newEvents.put((statemachine.Event)statechart.getAliasByElement(e), raisedEvents.contains(e));
		}
		
		synchronized (eventValueMap) {
			eventValueMap = newEvents;	
			newEvents = new HashMap<statemachine.Event, Boolean>();
		}
		
		for (statemachine.Event event : eventValueMap.keySet()) {
			Boolean oldValue = oldEventValues.get(event);
			if (oldValue == null 
				|| eventValueMap.get(event).booleanValue() != oldEventValues.get(event).booleanValue()) {
				eventQueue.add(new StatemachineEvent(
						StatemachineEventTypes.EventChanged,
						createEntry(event, eventValueMap.get(event)),
						uuid,instanceNumber));				
			}
		}
	}

	public Map<statemachine.Event, Boolean> getSignalEvents(){
		synchronized (eventValueMap) {
			return eventValueMap;	
		}
	}

	private void updateVariableList() {
		Map<statemachine.Variable, Double> variablesNew = new HashMap<statemachine.Variable, Double>();
		for (Variable v:statechart.getVariables()) {
			Object value = statechart.getValue(v.getName());
			Double origValue = variableValueMap.get(statechart.getAliasByElement(v));
			Double newValue = null;
			if (value == null) {
				newValue = 0.0;
			} else if (value instanceof Double) {
				newValue = (Double)value;
			} else if (value instanceof Integer) {
				newValue = new Double((Integer)value);
			} else if (value instanceof Boolean) {
				newValue = (Boolean)value==Boolean.FALSE?0.0:1.0;
			} else {
				throw new RuntimeException("Unknown Variable Type for "+v.getName()+ " received: "+value);
			}
			if (!newValue.equals(origValue)){
				eventQueue.add(new StatemachineEvent(
						StatemachineEventTypes.VariableChanged,
						createEntry((statemachine.Variable)statechart.getAliasByElement(v), newValue),
						uuid, instanceNumber));
			}
			variablesNew.put((statemachine.Variable)statechart.getAliasByElement(v), newValue);
		}
		synchronized (variableValueMap) {
			variableValueMap = variablesNew;	
		}
	}
	
	private Entry<DataElement, Object> createEntry(final DataElement element,
			final Object value) {
		return new Entry<DataElement, Object>() {
			public DataElement getKey() {
				return element;
			}
			public Object getValue() {
				return value;
			}
			public Object setValue(final Object value) {
				return value;
			}
		};
	}

	public Map<statemachine.Variable, Double> getVariables(){
		synchronized (variableValueMap) {
			return Collections.unmodifiableMap(variableValueMap);	
		}
	}

	
	//=========================================================================
	// StatechartListener implementation should not be called from outside
	//
	
	public void stateEntered(State state) {
		eventQueue.add(new StatemachineEvent(
				StatemachineEventTypes.StateEnabled,
				statechart.getAliasByElement(state),
				uuid, instanceNumber));		
	}

	public void stateLeft(State state) {
		eventQueue.add(new StatemachineEvent(
				StatemachineEventTypes.StateDisabled,
				statechart.getAliasByElement(state),
				uuid, instanceNumber));
		}


	public void transitionFired(Transition trans) {
		eventQueue.add(new StatemachineEvent(
				StatemachineEventTypes.TransitionFired,
				statechart.getAliasByElement(trans),
				uuid, instanceNumber));
	}


	//=========================================================================
	// TimingService implementation - should not be called from outside
	//
		

	private Set<TimeEvent> canceledRequestedEvents = new HashSet<TimeEvent>();

	synchronized public void requestTimeEvent(final TimeEvent timeEvent) {
		canceledRequestedEvents.remove(timeEvent);

		// run a timer (there is an own thread for this);
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (canceledRequestedEvents.contains(timeEvent)) {
					canceledRequestedEvents.remove(timeEvent);
				} else {
					statechart.setEvent(timeEvent);
				}
			}

		}, timeEvent.getDuration());
	}

	
	synchronized public void cancelTimeEvent(final TimeEvent timeEvent) {
		canceledRequestedEvents.add(timeEvent);
	}

	
	/**
	 * 
	 */
	public void run() {
		timer=new Timer();

		while(!terminate) {
			Runnable task = null;
			try {
				task = taskQueue.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (task!=null)
				try {
					task.run();
				} catch (Exception e) {
					eventQueue.add(new SimulationEvent(engine, e));
					e.printStackTrace();
				}
		}
		
		timer.cancel();
		timer=null;
	}



}

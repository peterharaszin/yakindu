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
package com.yakindu.simulation.engine.statechart.test.testclasses;

import static org.junit.Assert.assertEquals;

import java.util.Map.Entry;

import org.junit.Ignore;
import org.junit.Test;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import statemachine.DataElement;

/**
 * Test class to check the function of the statechart simulator with
 * the statechart "SendAfter.statemachine". ATTENTION: The used 
 * statechart will be identified by the uuid, if the statechart was
 * changed, it is necessary to change the uuid in the method
 * <code>receiveEvent()</code>, too.
 * 
 * @author Philipp Richter
 */
public class Test_SendAfter extends AFunctionalityTest implements IEventListener {
	
	/** Defines the test statechart file. */
	private String statechartFile = "com/yakindu/simulation/engine/statechart/test/resources/general/SendAfter.statemachine";
	
	/**
	 * This test case checks the simulator with the statechart "SendAfter.statemachine".
	 * Checked functions: after(), send().
	 */
	@Ignore
	@Test(timeout=10000)
	public void testSendAfter() throws SimulationException {
		
		String count = "count";
		String activeState = "activeState";
		String behavior = "behaviour";
		
		// Reset the number of received events
		numberOfEvents = 0;
		
		inputHistory.append("\nInput history of SendAfter:");
		eventHistory.append("\nEvent history of SendAfter:");
		
		setUpSimulator(statechartFile);
		
		// Positive tests	
		
		inputHistory.append("\nStart simulation. State 1 is active.");
		inputHistory.append("\nEntry: The event1 must be triggered by send() but no state change");
		inputHistory.append("\nDo: The event1 must be triggered by send() but no state change, because count is only 1");
		engine.singleStepForward();
		
		waitForNextStep();
		
		assertEquals("State 1 must be enabled, but it isn't!", 1, engine.getActiveStates().get(0).getId());
		assertEquals("State 1 is active, but the variable \"activeState\" is not \"1\" (entry action)!", 1.0, getVariable(activeState), 0.0);
		assertEquals("\"count\" is not 0.0.", 0.0, getVariable(count), 0.0);
		
		inputHistory.append("\nDo: The event must be triggered by send() but no state change, because count is only 0");
		engine.singleStepForward();
		
		waitForNextStep();
		
		assertEquals("\"count\" is not 1.0.", 1.0, getVariable(count), 0.0);
		
		inputHistory.append("\nDo: The event must be triggered by send() but no state change, because count is only 1");
		engine.singleStepForward();
		
		waitForNextStep();
		
		assertEquals("\"count\" is not 2.0.", 2.0, getVariable(count), 0.0);

		inputHistory.append("\nDo: The event must be triggered by send() but no state change since he is now only 2.");
		engine.singleStepForward();
		
		waitForNextStep();

		assertEquals("\"count\" is not 3.0.", 3.0, getVariable(count), 0.0);
		
		inputHistory.append("\nDo: The event must be triggered by send() and the state is changed, because count is 3");
		long start = System.currentTimeMillis();
		engine.singleStepForward();
		
		waitForNextStep();
		
		assertEquals("\"count\" is not 4.0.", 4.0, getVariable(count), 0.0);
		engine.singleStepForward();
		
		waitForNextStep();
		assertEquals("State 2 must be enabled, but it isn't!", 3, engine.getActiveStates().get(0).getId());
		assertEquals("State 2 is active, but the variable \"behaviour\" is not \"1\" (transition behaviour)!", 1.0, getVariable(behavior), 0.0);
		assertEquals("State 2 is active, but the variable \"activeState\" is not \"2\" (entry action)!", 2.0, getVariable(activeState), 0.0);
		
		long sleepDuration = 500;
		long end = 0;
		
		engine.startSimulation();
		
		engine.pauseSimulation();

		long starttime = System.currentTimeMillis();
		while(System.currentTimeMillis() - starttime < sleepDuration) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		engine.startSimulation();

		while(engine.getSimulationState() == SimulationState.RUNNING) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// Current time - start time - duration of the sleep
		end = System.currentTimeMillis() - start - sleepDuration;

		// after(1s)
		assertEquals("The delay of after(1s) was wrong (970 - 1170ms are allowed, but was " + end + "ms)! The simulation was paused and then resumed.", 1070d, end, 100d);
		System.out.println("Event time expected: 1000ms, was: " + end);
		
		assertEquals("House: The number of events is wrong (" + numberOfEvents + " instead of 24)! It can be that not all expected changes were done!\n\n" + inputHistory + "\n\n" + eventHistory, 24, numberOfEvents);
	}
	
	/**
	 * Checks the events which are sent during the simulation. It is a part of the method <code>startSendAfter()</code>.
	 * 
	 * @param event		defines the received event of the statechart simulator
	 */
	private void checkEventsSendAfter(StatemachineEvent event) {
		
		synchronized (syncObject) {

			String activeState = "activeState";
			String event1 = "event1";
			String count = "count";
			String behaviour = "behaviour";
			Entry<?, ?> entry = null;
			DataElement element = null;
			
			numberOfEvents++;
		
			eventHistory.append(String.format("\nEvent %s received: Event type = %s", numberOfEvents, event.getEventType().toString()));
				
			switch (numberOfEvents) {
			// Transition fired (From initial to state1)
			case 1:
				if(event.getEventType() != StatemachineEventTypes.TransitionFired)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.TransitionFired , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;
			// State1 enabled
			case 2:
				if(event.getEventType() != StatemachineEventTypes.StateEnabled)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.StateEnabled , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;
			// entry: activeState = 1
			case 3:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(activeState))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, activeState , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 1.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 1.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));				
				break;
			// entry: send(event1)
			case 4:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != true)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, true , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// deactivate event1
			case 5:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != false)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, false , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do: count=count+1 (count=1)
			case 6:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(count))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, count , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 1.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 1.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do: send(event1)
			case 7:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != true)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, true , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// deactivate event1
			case 8:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != false)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, false , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do 2: count=count+1 (count=2)
			case 9:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(count))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, count , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 2.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 2.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do 2: send(event1)
			case 10:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != true)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, true , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// deactivate event1
			case 11:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != false)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, false , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do 3: count=count+1 (count=3)
			case 12:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(count))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, count , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 3.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 3.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do 3: send(event1)
			case 13:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != true)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, true , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// deactivate event1
			case 14:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != false)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, false , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do 4: count=count+1 (count=4)
			case 15:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(count))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, count , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 4.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 4.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 do 4: send(event1)
			case 16:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != true)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, true , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// event1 disabled
			case 17:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.EventChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.EventChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(event1))
					simulationError = new AssertionError(String.format(message, "Event", numberOfEvents, event1 , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Boolean) entry.getValue()).booleanValue() != false)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, false , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state1 disabled
			case 18:
				if(event.getEventType() != StatemachineEventTypes.StateDisabled)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.StateDisabled , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;			
			// Transition behavior: behavior=1
			case 19:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(behaviour))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, behaviour , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 1.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 1.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// Transition fired (event1 [count==3] / behavior=1)
			case 20:
				if(event.getEventType() != StatemachineEventTypes.TransitionFired)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.TransitionFired , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state2 enabled
			case 21:
				if(event.getEventType() != StatemachineEventTypes.StateEnabled)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.StateEnabled , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state2 entry: activeState=2
			case 22:
				entry = (Entry<?, ?>) event.getSource();
				element = (DataElement) entry.getKey();
				if(event.getEventType() != StatemachineEventTypes.VariableChanged)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.VariableChanged , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				if(!element.getName().equals(activeState))
					simulationError = new AssertionError(String.format(message, "Variable", numberOfEvents, activeState , element.getName(), inputHistory.toString(), eventHistory.toString()));
				if(((Double) entry.getValue()).doubleValue() != 2.0)
					simulationError = new AssertionError(String.format(message, "Value", numberOfEvents, 2.0 , entry.getValue(), inputHistory.toString(), eventHistory.toString()));
				break;
			// state2 disabled
			case 23:
				if(event.getEventType() != StatemachineEventTypes.StateDisabled)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.StateDisabled , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;
			// Transition fired (after(3s))
			case 24:
				if(event.getEventType() != StatemachineEventTypes.TransitionFired)
					simulationError = new AssertionError(String.format(message2, numberOfEvents, StatemachineEventTypes.TransitionFired , event.getEventType().toString(), inputHistory.toString(), eventHistory.toString()));
				break;
			}
		}
	}

	/**
	 * @see com.yakindu.simulation.engine.statechart.test.testclasses.AFunctionalityTest#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public void receiveEvent(IEvent event) {

		if(event instanceof StatemachineEvent) {
			
			StatemachineEvent smEvent = (StatemachineEvent) event;
				
			checkEventsSendAfter(smEvent);
			
		}
		else if(event instanceof SimulationEvent &&
				((SimulationEvent) event).getEventType() == SimulationEventTypes.SimError) {
			
			Throwable thr = ((SimulationEvent)event).getException();
			simulationError = createAssertionError(thr);
		}
	}
}

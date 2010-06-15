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

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Ignore;
import org.junit.Test;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import statemachine.Variable;

/**
 * Test class to check the function of the statechart simulator with
 * the statechart "House.statemachine". ATTENTION: The used 
 * statechart will be identified by the uuid, if the statechart was
 * changed, it is necessary to change the uuid in the method
 * <code>receiveEvent()</code>, too.
 * 
 * @author Philipp Richter
 */
public class Test_House extends AFunctionalityTest implements IEventListener {
	
	/**
	 * This test method checks the simulator with the statechart "House.statemachine".
	 */
	@Ignore //timed out in build 294
	@Test(timeout=15000)
	public void testHouse() throws SimulationException {

		String loss = "Loss";
		
		// Reset the number of received events
		numberOfEvents = 0;
		
		inputHistory.append("\nInput history of House:");
		eventHistory.append("\nEvent history of House:");
		
		setUpSimulator("com/yakindu/simulation/engine/statechart/test/resources/general/House.statemachine");
		
		// Positive tests	
		
		inputHistory.append("\nInitialize inputs: TempDiff = 1.0");
		assertTrue("Input could not be set (TempDiff)!", engine.setItem("TempDiff", 1.0));
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 0.0 -> state Windows_closed is active");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 0.0));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 5.9 -> no state change");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 5.9));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 6.0 -> state Three_open_Windows is active");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 6.0));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 7.0 -> no state change");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 7.0));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 7.1 -> state Windows_closed is active");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 7.1));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 19.5 -> state Six_open_windows is active");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 19.5));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		inputHistory.append("\nStart time = 6.5 -> state Three_open_windows is active");
		assertTrue("Input could not be set (Time)!", engine.setItem("Time", 6.5));
		// Change to state Windows_closed
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		// Change to state Three_windows_open		
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(loss));
		
		// Waits until all events have been received.
		while(numberOfEvents < 6) {
			Thread.yield();
		}
		
		// Only for checking if an error was occurred
		waitForNextStep();
		
		assertEquals("House: The number of \"VariableChanged\" is wrong! It can be that not all expected changes were done!", 6, numberOfEvents);
	}
	
	/**
	 * Checks the events which are sent during the simulation. It is a part of the method <code>startHouse()</code>.
	 * 
	 * @param var 	defines the variable which was changed
	 * @param value 	defines the value of the changed variable
	 */
	private void checkEventsHouse(Variable var, Double value) {
		
		synchronized (syncObject) {

			String variable = "Loss";

			if(var.getName().toLowerCase().equals(variable.toLowerCase())) {
				
				numberOfEvents++;
				
				eventHistory.append(String.format("\nEvent %1$d received: Loss = %2$1.0f", numberOfEvents, value));
				
				switch (numberOfEvents) {
				case 1:
					if(!value.equals(2784876.0))
						simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 2784876, value, inputHistory.toString(), eventHistory.toString()));
					break;
				case 2:
					if(!value.equals(9621276.0))
						simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 9621276, value, inputHistory.toString(), eventHistory.toString()));
					break;
				case 3:
					if(!value.equals(2784876.0))
						simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 2784876, value, inputHistory.toString(), eventHistory.toString()));
					break;
				case 4:
					if(!value.equals(16457676.0))
						simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 16457676, value, inputHistory.toString(), eventHistory.toString()));
					break;
				case 5:
					if(!value.equals(2784876.0))
						simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 2784876, value, inputHistory.toString(), eventHistory.toString()));
					break;
				case 6:
					if(!value.equals(9621276.0))
						simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 9621276, value, inputHistory.toString(), eventHistory.toString()));
					break;
				}
			}
		}
	}

	/**
	 * @see com.yakindu.simulation.engine.statechart.test.testclasses.testclasses.engine.AFunctionalityTest#receiveEvent(org.mda4e.simulation.core.event.IEvent)
	 */
	public void receiveEvent(IEvent event) {

		if(event instanceof StatemachineEvent) {
			
			StatemachineEvent smEvent = (StatemachineEvent) event;
			
			if(smEvent.getEventType() == StatemachineEventTypes.VariableChanged) {
				
				Entry<?, ?> entry = ((Entry<?, ?>) smEvent.getSource());
				
				if(entry.getKey() instanceof Variable) {
					
					checkEventsHouse((Variable) entry.getKey(), (Double) entry.getValue());
				}
			}
		}
		else if(event instanceof SimulationEvent &&
				((SimulationEvent) event).getEventType() == SimulationEventTypes.SimError) {
			
			Throwable thr = ((SimulationEvent)event).getException();
			simulationError = createAssertionError(thr);
		}
	}
}

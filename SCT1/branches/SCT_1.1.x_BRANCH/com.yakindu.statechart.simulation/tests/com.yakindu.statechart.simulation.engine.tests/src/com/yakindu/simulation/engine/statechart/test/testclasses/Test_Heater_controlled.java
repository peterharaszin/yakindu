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

import statemachine.IOTypes;
import statemachine.Variable;

/**
 * Test class to check the function of the statechart simulator with
 * the statechart "Heater_controlled.statemachine". ATTENTION: The used 
 * statechart will be identified by the uuid, if the statechart was
 * changed, it is necessary to change the uuid in the method
 * <code>receiveEvent()</code>, too.
 * 
 * @author Philipp Richter
 */
public class Test_Heater_controlled extends AFunctionalityTest implements IEventListener {
	
	/**
	 * This test method checks the simulator with the statechart "Heater_controlled.statemachine".
	 */
	@Ignore //Timed out in build 297
	@Test(timeout=150000)
	public void testHeater_controlled() throws SimulationException {
		
		String variable = "Level";
		
		// Reset the number of received events
		numberOfEvents = 0;
		
		inputHistory.append("\nInput history of Heater_controlled:");
		eventHistory.append("\nEvent history of Heater_controlled:");
		
		setUpSimulator("com/yakindu/simulation/engine/statechart/test/resources/general/Heater_controlled.statemachine");
		
		// Positive tests
		
		inputHistory.append("\nInitialize inputs: WishTemp = 21.0, BurnerTemp = 50.0");
		assertTrue("Input could not be set (WishTemp)!", engine.setItem("WishTemp", 21.0));
		assertTrue("Input could not be set (BurnerTemp)!", engine.setItem("BurnerTemp", 50.0));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nStart room temperature = 20.0 -> level 1 of the heater has to be activated (Event 1)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 20.0));
		engine.singleStepForward();
		
		waitForNextStep();

		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 19.9 -> 0.1 °C is allowed");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 19.9));
		engine.singleStepForward();

		waitForNextStep();

		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 19.89 -> more than 0.1°C loss is not allowed -> level 2 has to be activated (Event 2)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 19.89));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 19.78 -> more than 0.1°C loss is not allowed -> level 3 has to be activated (Event 3)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 19.78));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 19.0 -> more than 0.1°C loss is not allowed -> level 4 has to be activated (Event 4)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 19.0));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 21.4 -> temperature is not over 0.4°C higher than the wish temperature -> nothing happens");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 21.4));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 21.41 -> temperature is over 0.4°C higher than the wish temperature -> the burner has to be deactivated (Event 5)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 21.41));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 20.0 -> more than 0.1°C loss is not allowed -> level 1 has to be activated (Event 6)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 20.0));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		inputHistory.append("\nRoom temperature = 21.41 -> temperature is over 0.4°C higher than the wish temperature -> the burner has to be deactivated (Event 7)");
		assertTrue("Input could not be set (RoomTemp)!", engine.setItem("RoomTemp", 21.41));
		engine.singleStepForward();
		
		waitForNextStep();
		
		inputHistory.append("\n\"Level\" is now: " + getVariable(variable));
		
		// Waits until all events have been received.
		while(numberOfEvents < 7) {
			Thread.yield();
		}
		
		// Only for checking if an error was occurred
		waitForNextStep();
		
		assertEquals("Heater_controlled: The number of \"VariableChanged\" is wrong! It can be that not all expected changes were done!", 7, numberOfEvents);
	}

	/**
	 * Checks the events which are sent during the simulation. It is a part of the method <code>startControlledHeater()</code>.
	 * 
	 * @param var		defines the variable which was sent by the simulator
	 * @param value		defines the value of of the variable 
	 */
	private void checkEventsHeater_controlled(Variable var, Double value) {
						
		synchronized (syncObject) {
			
			String variable = "Level";
		
			if(var.getIoType() == IOTypes.OUTPUT) {
			
				if(var.getName().toLowerCase().equals(variable.toLowerCase())) {
					
					numberOfEvents++;

					eventHistory.append(String.format("\nEvent %1$d received: Level = %2$1.0f", numberOfEvents, value));
					
					switch (numberOfEvents) {
					case 1:
						if(!value.equals(1.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 1, value, inputHistory.toString(), eventHistory.toString()));
						break;
					case 2:
						if(!value.equals(2.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 2, value, inputHistory.toString(), eventHistory.toString()));
						break;
					case 3:
						if(!value.equals(3.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 3, value, inputHistory.toString(), eventHistory.toString()));
						break;
					case 4:
						if(!value.equals(4.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 4, value, inputHistory.toString(), eventHistory.toString()));
						break;
					case 5:
						if(!value.equals(0.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 0, value, inputHistory.toString(), eventHistory.toString()));
						break;
					case 6:
						if(!value.equals(1.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 1, value, inputHistory.toString(), eventHistory.toString()));
						break;
					case 7:
						if(!value.equals(0.0))
							simulationError = new AssertionError(String.format(message, variable, numberOfEvents, 0, value, inputHistory.toString(), eventHistory.toString()));
						break;
					default:
						fail("The number of events is wrong! An unexpected number of events was received!");
						break;
					}
				}
			}
		}
	}

	/**
	 * @see com.yakindu.simulation.engine.statechart.test.testclasses.AFunctionalityTest#receiveEvent(IEvent)
	 */
	public void receiveEvent(IEvent event) {

		if(event instanceof StatemachineEvent) {
			
			StatemachineEvent smEvent = (StatemachineEvent) event;
			
			if(smEvent.getEventType() == StatemachineEventTypes.VariableChanged) {
				
				Entry<?, ?> entry = ((Entry<?, ?>) smEvent.getSource());
				
				if(entry.getKey() instanceof Variable) {
								
					checkEventsHeater_controlled((Variable) entry.getKey(), (Double) entry.getValue());
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

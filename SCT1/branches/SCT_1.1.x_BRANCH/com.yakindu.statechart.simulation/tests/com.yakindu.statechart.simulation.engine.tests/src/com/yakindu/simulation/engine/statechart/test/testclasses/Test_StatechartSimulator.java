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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import com.yakindu.simulation.engine.statechart.StatechartSimulator;

import statemachine.State;

/**
 * Test class to test all methods of {@link StatechartSimulator}.
 * 
 * @author Philipp Richter
 */
public class Test_StatechartSimulator extends AFunctionalityTest {

	/** Defines the first statechart to test the class. */
	private String statechartFile = "com/yakindu/simulation/engine/statechart/test/resources/general/SendAfter.statemachine";
	/** Defines the second statechart to test the class. */
	private String statechartFile2 = "com/yakindu/simulation/engine/statechart/test/resources/general/SendActiveStates.statemachine";
	
	/** Saves all received event types. */
	private List<IEvent> receivedEventTypes = null;
	
	/**
	 * Initializes the default {@link ISimulationEngine} instance "engine".
	 */
	@Before
	public void setUp() throws Exception {
		
		receivedEventTypes = new ArrayList<IEvent>();
		
		setUpSimulator(statechartFile);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#StatechartSimulator()}.
	 */
	@Test
	public void testStatechartSimulator() {
		
		// --- Normal case ---
		
		assertEquals("The initial state of the engine is not right!", SimulationState.STOPPED, engine.getSimulationState());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#addEventListener(org.mda4e.simulation.core.event.IEventListener)}.
	 */
	@Test
	public void testAddEventListener() throws SimulationException {
		
		// --- Normal case ---

		//not needed -> see test case (Test_Heater_controlled.java)
		
		// --- Exceptional case ---

		// Listener is null
		engine.addEventListener(null);
		
		// Listener is in the list
		IEventListener listener = new IEventListener() {
			public void receiveEvent(IEvent event) {}	
		};
		engine.addEventListener(listener);
		engine.addEventListener(listener);
		
		// Engine is disposed
		engine.disposeEngine();
		engine.addEventListener(listener);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getActiveStates()}.
	 */
	@Test(timeout=10000)
	public void testGetActiveStates() throws SimulationException {

		// --- Normal case ---

		engine.singleStepForward();
		
		waitForNextStep();
		
		assertEquals("The number of active states is wrong!", 1, engine.getActiveStates().size());
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		
		// Simulator is not initialized
		assertNull("The List is not \"null\", but the simulator is not initialized!", simulator.getActiveStates());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertNull("The List is not \"null\", but the simulator is disposed!", engine.getActiveStates());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getEvents()}.
	 */
	@Test
	public void testGetEvents() throws SimulationException {
		
		// --- Normal case ---

		// not needed -> see test case (Test_Heater_controlled.java)
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		
		// Simulator is not initialized
		assertNull("The Map is not \"null\", but the simulator is not initialized!", simulator.getEvents());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertNull("The Map is not \"null\", but the simulator is disposed!", engine.getEvents());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getUUID()}.
	 */
	@Test
	public void testGetUUID() throws SimulationException {
		
		// --- Normal case ---

		assertFalse("The uuid of the initialized statemachine could not be read!", engine.getUUID().equals(""));
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		// Simulator is not initialized
		assertEquals("The engine name is not \"\", but the simulator is not initialized!", "", simulator.getUUID());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertEquals("The engine name is not \"\", but the simulator is disposed!", "", engine.getUUID());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getEngineName()}.
	 */
	@Test
	public void testGetEngineName() throws SimulationException {

		// --- Normal case ---
		
		assertFalse("The engine name of the initialized statemachine could not be read!", engine.getEngineName().equals(""));
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		// Simulator is not initialized
		assertFalse("The engine name of the not initialized engine could not be read!", simulator.getEngineName().equals(""));
		
		// Simulator is disposed
		engine.disposeEngine();
		assertFalse("The engine name of the disposed engine could not be read!", engine.getEngineName().equals(""));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getSimulationParameters()}.
	 */
	@Test
	public void testGetSimulationParameters() throws SimulationException {
		
		// --- Normal case ---

		ISimulationParameterSet parameterset = engine.getSimulationParameters();
		
		assertNotNull("The simulation parameters are not set!", parameterset);
		assertEquals("The parameter is not the same which was set!", getDefaultParameterSet(statechartFile).getSimulationSystem(), parameterset.getSimulationSystem());
		assertEquals("The parameter is not the same which was set!", getDefaultParameterSet(statechartFile).getInstanceNumber(), parameterset.getInstanceNumber());
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		// Simulator is not initialized
		assertNull("The parameter set is not null, but it was not be set!", simulator.getSimulationParameters());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertNull("The parameter set is not null, but the simulator is disposed!", engine.getSimulationParameters());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getSimulationState()}.
	 */
	@Test(timeout=15000)
	public void testGetSimulationState() throws SimulationException, InterruptedException {
	
		// --- Normal case ---

		assertEquals("The engine state is wrong if the simulation is created!", SimulationState.STOPPED, engine.getSimulationState());
		
		engine.startSimulation();

		assertEquals("The engine state is wrong if the simulation was started!", SimulationState.RUNNING, engine.getSimulationState());

		engine.pauseSimulation();

		while(engine.getSimulationState() != SimulationState.PAUSED) {
			// Timeout: The engine state is wrong if the simulation was paused!
			Thread.sleep(25);
		}

		engine.resumeSimulation();
		
		assertEquals("The engine state is wrong if the simulation was resumed!", SimulationState.RUNNING, engine.getSimulationState());
		
		engine.stopSimulation();
		
		while(engine.getSimulationState() != SimulationState.STOPPED) {
			// Timeout: The engine state is wrong if the simulation was stopped!
			Thread.sleep(25);
		}
		
		engine.startSimulation();
		
		assertEquals("The engine state is wrong if the simulation was restarted!", SimulationState.RUNNING, engine.getSimulationState());
		
		engine.pauseSimulation();
		
		while(engine.getSimulationState() != SimulationState.PAUSED) {
			Thread.sleep(25);
		}
		
		engine.stopSimulation();
		
		while(engine.getSimulationState() != SimulationState.STOPPED) {
			// Timeout: The engine state is wrong if the simulation was stopped after the simulation was paused!
			Thread.sleep(25);
		}
		
		// Engine is disposed
		engine.disposeEngine();
		assertEquals("The simulation state is not DISPOSED, after the simulation was disposed!", SimulationState.DISPOSED, engine.getSimulationState());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getSystemName()}.
	 */
	@Test
	public void testGetSystemName() throws SimulationException {
		
		// --- Normal case ---

		assertFalse("The system name could not be read!", engine.getSystemName().equals(""));
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		// Simulator is not initialized
		assertEquals("The system name is not \"\", but the simulator is not initialized!", "", simulator.getSystemName());
		
		// Engine is disposed
		engine.disposeEngine();
		assertEquals("The system name is not \"\", but the simulator is disposed!", "", engine.getSystemName());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getVariables()}.
	 */
	@Test
	public void testGetVariables() throws SimulationException {
		
		// --- Normal case ---

		// not needed -> see test class Test_Heater_controlled.java
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		// Simulator is not initialized
		assertNull("The Map is not \"null\", but the simulator is not initialized!", simulator.getVariables());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertNull("The Map is not \"null\", but the simulator is disposed!", engine.getVariables());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#pauseSimulation()}.
	 */
	@Test
	public void testPauseSimulation() throws SimulationException {
		
		// --- Normal case ---

		// not needed -> see testGetSimulationState()
		
		// --- Exceptional case ---

		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		simulator.pauseSimulation();
		
		// Engine is disposed
		engine.disposeEngine();
		
		try {
			engine.pauseSimulation();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (SimulationException e) {}

	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#receiveEvent(org.mda4e.simulation.core.event.IEvent)}.
	 */
	@Test
	public void testReceiveEvent() throws Exception {

		Exception error = new Exception("Test");
		
		// --- Normal case ---

		// not needed
		
		// --- Exceptional case ---

		// Event is null
		engine.receiveEvent(null);
		
		// Source of the event is null
		engine.receiveEvent(new IEvent() {
			public Object getSource() {	return null; }
		});
		
		// Exception is null -> if the exception is null a default
		// exception is defined by the constructor of the SimulationEvent
//		engine.receiveEvent(new SimulationEvent(engine, null));
		
		// Engine is null
		try {
			engine.receiveEvent(new SimulationEvent(null, error));
			fail("One of the arguments is null, but exception is occurred");
		} catch (NullPointerException e) {}
		
		// Event type is null
		try {
			engine.receiveEvent(new SimulationEvent(null, engine));
			fail("One of the arguments is null, but exception is occurred");
		} catch (NullPointerException e) {}
		
		// Engine is null
		try {
			engine.receiveEvent(new SimulationEvent(SimulationEventTypes.SimStart, null));
			fail("One of the arguments is null, but exception is occurred");
		} catch (NullPointerException e) {}
		
		// StatemachineEvent
		// Event type is null
		try {
			engine.receiveEvent(new StatemachineEvent(null, engine, "", 1));
			fail("One of the arguments is null, but exception is occurred");
		} catch (NullPointerException e) {}	
		
		// Engine is null
		try {
			engine.receiveEvent(new StatemachineEvent(StatemachineEventTypes.StateDisabled, null, "", 1));
			fail("One of the arguments is null, but exception is occurred");
		} catch (NullPointerException e) {}
		
		// UUID is null
		try {
			engine.receiveEvent(new StatemachineEvent(StatemachineEventTypes.StateDisabled, engine, null, 1));
			fail("One of the arguments is null, but exception is occurred");
		} catch (NullPointerException e) {}
		
		// Engine is disposed
		engine.disposeEngine();
		engine.receiveEvent(new SimulationEvent(engine, error));
		
		// Engine is not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		simulator.receiveEvent(new SimulationEvent(engine, error));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#removeEventListener(org.mda4e.simulation.core.event.IEventListener)}.
	 */
	@Test(timeout=10000)
	public void testRemoveEventListener() throws SimulationException {
		
		// --- Normal case ---

		engine.removeEventListener(this);
		
		receivedEventTypes.clear();
		
		engine.startSimulation();
		
		while(engine.getSimulationState() != SimulationState.RUNNING) {
			Thread.yield();
		}
		
		engine.stopSimulation();
		
		while(engine.getSimulationState() != SimulationState.STOPPED) {
			Thread.yield();
		}
		
		assertEquals("After this class was removed of the listener list of the simulator this class has received events!", 0, receivedEventTypes.size());
		
		// --- Exceptional case ---

		setUpSimulator(statechartFile);
		
		// Listener is null
		engine.removeEventListener(null);
		
		// Listener is not in the list
		IEventListener listener = new IEventListener() {

			public void receiveEvent(IEvent event) {
			}	
		};
		engine.removeEventListener(listener);
		
		// Engine is disposed
		engine.disposeEngine();
		engine.removeEventListener(listener);
		
		// Engine is not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		simulator.removeEventListener(listener);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#resumeSimulation()}.
	 */
	@Test
	public void testResumeSimulation() throws SimulationException {

		// --- Normal case ---

		// not needed -> see testGetSimulationState()
		
		// --- Exceptional case ---

		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		
		try {
			simulator.resumeSimulation();
			fail("The simulation is not initialized, but no exception is occurred!");
		} catch (SimulationException e) {}
		
		// Engine is disposed
		engine.disposeEngine();
		
		try {
			engine.resumeSimulation();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (SimulationException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#sendActiveStates()}.
	 */
	@Test(timeout=20000)
	public void testSendActiveStates() throws SimulationException {
		
		// --- Normal case ---
		
		setUpSimulator(statechartFile2);
		
		// Simulation is stopped
		assertFalse("The simulation is stopped, but the result is true!", engine.sendActiveStates());
		
		// Start the first step
		engine.singleStepForward();
		while(engine.getSimulationState() == SimulationState.RUNNING) { Thread.yield(); }
		// Wait for all events
		long startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 100) { Thread.yield(); }
		// Only the active state events are interesting
		receivedEventTypes.clear();
		
		assertEquals("The active states could not be sent!", true, engine.sendActiveStates());
		
		// Wait for all events
		startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 100) { Thread.yield(); }
		// Check all received events whether the active states was sent and if the simulation states are right
		// StateEnabled (State 1)
		assertTrue("A wrong event type was found!", receivedEventTypes.get(0) instanceof StatemachineEvent);
		assertEquals("A wrong event type was found!", StatemachineEventTypes.StateEnabled.name(), ((StatemachineEvent) receivedEventTypes.get(0)).getEventType().name());
		assertTrue("A wrong active state was found!", ((State) ((StatemachineEvent) receivedEventTypes.get(0)).getSource()).getName().equals("State1"));
		// StateEnabled (State 2)
		assertTrue("A wrong event type was found!", receivedEventTypes.get(1) instanceof StatemachineEvent);
		assertEquals("A wrong event type was found!", StatemachineEventTypes.StateEnabled.name(), ((StatemachineEvent) receivedEventTypes.get(1)).getEventType().name());
		assertEquals("A wrong active state was found!", "State2", ((State) ((StatemachineEvent) receivedEventTypes.get(1)).getSource()).getName());
		// Number of events
		assertEquals("The number of events is wrong!", 2, receivedEventTypes.size());
		
		
		// Start the second step
		assertTrue("The input (\"mode\") variable could not be set", engine.setItem("mode", 1.0));
		engine.singleStepForward();
		while(engine.getSimulationState() == SimulationState.RUNNING) { Thread.yield(); }
		// Wait for all events
		startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 100) { Thread.yield(); }
		// Only the active state events are interesting
		receivedEventTypes.clear();
		
		assertEquals("The active states could not be sent!", true, engine.sendActiveStates());
		
		// Wait for all events
		startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 100) { Thread.yield(); }
		// Check all received events whether the active states was sent and if the simulation states are right
		// StateEnabled (State 1)
		assertEquals("A wrong event type was found!",  StatemachineEvent.class.getSimpleName(), receivedEventTypes.get(0).getClass().getSimpleName());
		assertEquals("A wrong event type was found!", StatemachineEventTypes.StateEnabled.name(), ((StatemachineEvent) receivedEventTypes.get(0)).getEventType().name());
		assertTrue("A wrong active state was found!", ((State) ((StatemachineEvent) receivedEventTypes.get(0)).getSource()).getName().equals("State1"));
		// StateEnabled (State 3)
		assertEquals("A wrong event type was found!",  StatemachineEvent.class.getSimpleName(), receivedEventTypes.get(1).getClass().getSimpleName());
		assertEquals("A wrong event type was found!", StatemachineEventTypes.StateEnabled.name(), ((StatemachineEvent) receivedEventTypes.get(1)).getEventType().name());
		assertEquals("A wrong active state was found!", "State3", ((State) ((StatemachineEvent) receivedEventTypes.get(1)).getSource()).getName());
		// Number of events
		assertEquals("The number of events is wrong!", 2, receivedEventTypes.size());
		
		
		// Start the third step
		assertTrue("The input (\"mode\") variable could not be set", engine.setItem("mode", 2.0));
		engine.singleStepForward();
		while(engine.getSimulationState() == SimulationState.RUNNING) { Thread.yield(); }
		engine.singleStepForward();
		while(engine.getSimulationState() == SimulationState.RUNNING) { Thread.yield(); }
		// Wait for all events
		startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 100) { Thread.yield(); }
		// Only the active state events are interesting
		receivedEventTypes.clear();
		
		assertEquals("The active states could not be sent!", true, engine.sendActiveStates());
		
		// Wait for all events
		startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() - startTime < 100) { Thread.yield(); }
		// Check all received events whether the active states was sent and if the simulation states are right
		// StateEnabled (State 1)
		assertEquals("A wrong event type was found!",  StatemachineEvent.class.getSimpleName(), receivedEventTypes.get(0).getClass().getSimpleName());
		assertEquals("A wrong event type was found!", StatemachineEventTypes.StateEnabled.name(), ((StatemachineEvent) receivedEventTypes.get(0)).getEventType().name());
		assertTrue("A wrong active state was found!", ((State) ((StatemachineEvent) receivedEventTypes.get(0)).getSource()).getName().equals("State1"));
		// Number of events
		assertEquals("The number of events is wrong!", 1, receivedEventTypes.size());
		
		// --- Exceptional case ---

		// Simulation is not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		assertFalse("The simulator is not initialized, but the result not false!", simulator.sendActiveStates());
		
		// Engine is disposed
		engine.disposeEngine();
		assertFalse("The simulator is disposed, but the result not false!", simulator.sendActiveStates());
		
		// Simulation is finished
		setUpSimulator(statechartFile);
		engine.startSimulation();
		
		while(engine.getSimulationState() != SimulationState.STOPPED) { Thread.yield();	}
		
		assertFalse("The simulation is finished, but the result is true!", engine.sendActiveStates());	
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#setSimulationParameters(org.mda4e.simulation.core.ISimulationParameterSet)}.
	 */
	@Test
	public void testSetSimulationParametersISimulationParameterSet() throws SimulationException {
		
		// --- Normal case ---

		// not needed see setUp()
		
		// --- Exceptional case ---

		// System is null!
		try {
			engine.setSimulationParameters(new ISimulationParameterSet() {
				public int getInstanceNumber() { return 1; }
				public File getSimulationSystem() { return null; } // <- System = null
			});
		} catch (SimulationException e) {}
		
		// The same test with a new not initialized simulator. System is null!
		StatechartSimulator simulator = new StatechartSimulator();
		
		try {
			simulator.setSimulationParameters(new ISimulationParameterSet() {
				public int getInstanceNumber() { return 1; }
				public File getSimulationSystem() { return null; } // <- System = null
			});
		} catch (SimulationException e) {}
		
		// Engine is disposed
		engine.disposeEngine();
		try {
			engine.setSimulationParameters(getDefaultParameterSet(statechartFile));
		} catch(SimulationException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#setSimulationParameters(org.mda4e.simulation.statemachine.IStatemachineParameterSet)}.
	 */
	@Test
	public void testSetSimulationParametersIStatemachineParameterSet() {
		
		// TODO the method is not implemented in StatechartSimulator.java
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#singleStepForward()}.
	 */
	@Test
	public void testSingleStepForward() throws SimulationException {

		// --- Normal case ---

		// not needed -> see testGetSimulationState()
		
		// --- Exceptional case ---

		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		
		try {
			simulator.singleStepForward();
			fail("The simulation is not initialized, but no exception is occurred!");
		} catch (SimulationException e) {}
		
		// Engine is disposed
		engine.disposeEngine();
		
		try {
			engine.resumeSimulation();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (SimulationException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#startSimulation()}.
	 */
	@Test
	public void testStartSimulation() throws SimulationException {

		// --- Normal case ---

		// not needed -> see testGetSimulationState()
		
		// --- Exceptional case ---

		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		
		try {
			simulator.startSimulation();
			fail("The simulation is not initialized, but no exception is occurred!");
		} catch (SimulationException e) {}
		
		// Engine is disposed
		engine.disposeEngine();
		
		try {
			engine.startSimulation();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (SimulationException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#stopSimulation()}. 
	 */
	@Test
	public void testStopSimulation() throws SimulationException {

		// --- Normal case ---

		// not needed -> see testGetSimulationState()
		
		// --- Exceptional case ---

		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();

		// No exception occurs
		simulator.stopSimulation();

		// Engine is disposed
		engine.disposeEngine();
		
		try {
			engine.resumeSimulation();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (SimulationException e) {}

	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#fireEvent(java.lang.String)}.
	 */
	@Test(timeout=10000)
	public void testFireEvent() throws SimulationException {
		
		// --- Normal case ---

		engine.singleStepForward();
		
		while(engine.getSimulationState() != SimulationState.PAUSED) {
			Thread.yield();
		}
		
		assertTrue("The event could not be fired!", engine.fireEvent("finish"));
		
		assertTrue("The event could be fired (event: finish) but not be read!", getEvent("finish"));
		
		engine.singleStepForward();
		
		while(engine.getSimulationState() != SimulationState.STOPPED) {
			Thread.yield();
		}
		
		assertEquals("The event (finish) was not fired by the simulator (the statemachine ought to have been completed)!", SimulationState.STOPPED, engine.getSimulationState());
		
		// --- Exceptional case ---

		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		assertFalse("The statechart was not set, but the result is \"true\"!", simulator.fireEvent("finish"));
		
		// Simulator is disposed
		engine.disposeEngine();
		try {
			engine.fireEvent("finish");
			fail("The simulator is disposed, but no exception is occurred when an event should be fired!");
		} catch (SimulationException e) {}
		
		// Parameter = null check
		setUpSimulator(statechartFile);
		engine.singleStepForward();
		while(engine.getSimulationState() != SimulationState.PAUSED) { Thread.yield(); }
		
		try {
			engine.fireEvent(null);
			fail("The event name is \"null\" but no exception is occurred!");
		} catch (SimulationException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#setItem(java.lang.String, java.lang.Double)}.
	 */
	@Test(timeout=10000)
	public void testSetItem() throws SimulationException {

		// --- Normal case ---

		engine.singleStepForward();
		
		while(engine.getSimulationState() != SimulationState.PAUSED) {
			Thread.yield();
		}
		
		assertTrue("The wrong state (\"state 1\") is activated)!", engine.getActiveStates().get(0).getName().equals("state 1"));
		
		assertTrue("The variable (count) could not be set!", engine.setItem("count", 5.0));
		
		assertEquals("The variable \"count\" could be set, but could not be read!", 5.0, getVariable("count"), 0.0);
		
		engine.singleStepForward();
		
		while(engine.getSimulationState() != SimulationState.PAUSED) {
			Thread.yield();
		}
		
		assertTrue("The variable (count) was not set by the simulator (the \"state 2\" ought to have been activated)!", engine.getActiveStates().get(0).getName().equals("state 2"));
		
		// --- Exceptional case ---
		
		// Not initialized
		StatechartSimulator simulator = new StatechartSimulator();
		assertFalse("The statechart was not set, but the result is not \"false\"!", simulator.setItem("count", 1.0));
		
		// Simulator is disposed
		engine.disposeEngine();
		try {
			engine.setItem("count", 1.0);
			fail("The simulator is disposed, but no exception is occurred when a variable should be updated!");
		} catch (SimulationException e) {}

		// Parameters = null check
		setUpSimulator(statechartFile);
		engine.singleStepForward();
		while(engine.getSimulationState() != SimulationState.PAUSED) { Thread.yield(); }
		
		try {
			engine.setItem(null, 0.0);
			fail("The item name is \"null\" but no exception is occurred!");
		} catch (SimulationException e) {}
		
		try {
			engine.setItem("count", null);
			fail("The item value is \"null\" but no exception is occurred!");
		} catch (SimulationException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getInstanceNumber()}.
	 */
	@Test
	public void testGetInstanceNumber() throws SimulationException {

		// --- Normal case ---
		
		assertEquals("The instance number was not be set or is wrong!", 1, engine.getInstanceNumber());
		
		// --- Exceptional case ---

		StatechartSimulator simulator = new StatechartSimulator();
		
		assertEquals("The statechart was not set, but the instance number is not \"-1\"!", -1, simulator.getInstanceNumber());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertEquals("The simulator is disposed, but the instance number is not -1!", -1, engine.getInstanceNumber());
		
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#getStatechart()}.
	 */
	@Test
	public void testGetStatechart() throws SimulationException {

		// --- Normal case ---

		assertEquals("The statechart is wrong!", "SendAfter", engine.getStatechart().getName());
		
		// --- Exceptional case ---
		
		StatechartSimulator simulator = new StatechartSimulator();
		
		assertNull("The statechart was not set, but the result is not \"null\"!", simulator.getStatechart());
		
		// Simulator is disposed
		engine.disposeEngine();
		assertNull("The simulator is disposed, but statechart is not null!", engine.getStatechart());
		
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#initializeEngine()}.
	 */
	@Test
	public void testInitializeEngine() throws SimulationException {

		// --- Normal case ---

		// not needed see setUp()
		
		// Two calls 
		engine.initializeEngine();
		engine.initializeEngine();
		
		// --- Exceptional case ---

		// All exceptional cases are in an own file. 
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.StatechartSimulator#disposeEngine()}.
	 */
	@Test
	public void testDisposeEngine() throws Exception {

		// --- Normal case ---

		// Engine is stopped
		engine.disposeEngine();
		assertEquals("The engine state is not \"DISPOSED\"!", SimulationState.DISPOSED, engine.getSimulationState());
		
		// Engine isn't stopped
		setUp();
		engine.startSimulation();
		engine.disposeEngine();
		assertEquals("The engine state is not \"DISPOSED\", if the simulation was running!", SimulationState.DISPOSED, engine.getSimulationState());
		
		// Exceptional case

		StatechartSimulator simulator = new StatechartSimulator();

		// Without setting the parameters and initialization
		simulator.disposeEngine();
		
		assertEquals("The engine state is not \"DISPOSED\"!", SimulationState.DISPOSED, engine.getSimulationState());
		
		// Calling the method a second time. 
		try {
			simulator.disposeEngine();
		} catch (SimulationException e) {}
		
		assertEquals("The engine state is not \"DISPOSED\"!", SimulationState.DISPOSED, engine.getSimulationState());
	}

	@Override
	public void receiveEvent(IEvent event) {
			
		receivedEventTypes.add(event);
	}

}

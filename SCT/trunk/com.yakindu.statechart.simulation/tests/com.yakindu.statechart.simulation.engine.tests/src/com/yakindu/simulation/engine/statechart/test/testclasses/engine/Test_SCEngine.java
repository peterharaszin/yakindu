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
package com.yakindu.simulation.engine.statechart.test.testclasses.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mda4e.simulation.statemachine.IStatemachineParameterSet;

import com.yakindu.simulation.engine.statechart.StatechartSimulator;
import com.yakindu.simulation.engine.statechart.engine.SCEngine;
import com.yakindu.simulation.engine.statechart.engine.SimulationParameterSet;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.test.Utilities;

import statemachine.Variable;

/**
 * Defines test cases to validate the functionality of the class {@link SCEngine}.
 * 
 * @author Philipp Richter
 */
public class Test_SCEngine {

	/** The class to test. */
	private SCEngine engine = null;
	
	/** Defines the test statechart model. */
	private static final String statechartfile = "com/yakindu/simulation/engine/statechart/test/resources/general/Heater_controlled.statemachine";
	
	/**
	 * Sets up the test environment.
	 */
	@Before
	public void setUp() throws Exception {
		
		engine = new SCEngine(new StatechartSimulator());
		
		if(engine == null) {
			fail("The engine could not be initialized!");
		}
		
		SimulationParameterSet parameterSet = getParameterSet(statechartfile);
		
		engine.setSimulationParameterSet(parameterSet);
	}

	/**
	 * Creates an instance of {@link IStatemachineParameterSet}.
	 * 
	 * @param path	defines the relative path of the statechart file
	 * 
	 * @return A default parameter set.
	 */
	private SimulationParameterSet getParameterSet(final String path) {
		
		return new SimulationParameterSet() {
			
			File system = new File(Utilities.getFile(getClass(), path));
			
			public File getSimulationSystem() {
				return system;
			}
		
			public int getInstanceNumber() {
				return 1;
			}

			public boolean isRealtime() {
				return false;
			}
		};
	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#SCEngine(org.mda4e.simulation.core.ISimulationEngine)}.
	 */
	@Test
	public void testSCEngine() {
		
		// --- Normal case ---

		// not needed , see setUp()
		
		// --- Exceptional case ---

		// Parent is null
		try {
			new SCEngine(null);
			fail("The parent is null, but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getSCInstance()}.
	 */
	@Test
	public void testGetSCInstance() throws IOException, StatechartNotValid, ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException {
		
		// --- Normal case ---

		engine.initializeSimulator();
		assertEquals("The instance number is wrong!", 1.0, Double.valueOf(engine.getSCInstance()).doubleValue(), 0.0);
		
		// --- Exceptional case ---
		
		// Engine is disposed
		engine.dispose();
		assertEquals("The instance number is not -1, if the engine is disposed!", -1.0, Double.valueOf(engine.getSCInstance()).doubleValue(), 0.0);
		
		// parameters not set
		engine = new SCEngine(new StatechartSimulator());
		assertEquals("The instance number is not -1, if the engine is not initialized!", -1.0, Double.valueOf(engine.getSCInstance()).doubleValue(), 0.0);
		
		// Engine is not initialized
		engine.setSimulationParameterSet(getParameterSet(statechartfile));
		assertEquals("The instance number is not -1, if the engine is not initialized!", -1.0, Double.valueOf(engine.getSCInstance()).doubleValue(), 0.0);
		
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getSimulationParameterSet()}.
	 */
	@Test
	public void testGetSimulationParameterSet() {

		// --- Normal case ---

		// Parameter set is defined 
		assertNotNull("The parameter set is null, but the parameters were set!", engine.getSimulationParameterSet());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#setSimulationParameterSet(org.mda4e.simulation.core.ISimulationParameterSet)}.
	 */
	@Test
	public void testSetSimulationParameterSet() throws UnableToParseStatechart, ArgumentIsNullException {
		
		// --- Normal case ---

		SimulationParameterSet parameterSet = getParameterSet(statechartfile);
		
		engine.setSimulationParameterSet(parameterSet);
		assertNotNull("The parameter were set, but the parameterset is null!", engine.getSimulationParameterSet());
		
		// --- Exceptional case ---

		// Parameter set is null
		try {
			engine.setSimulationParameterSet(null);
			fail("The parameter set is \"null\", but the method didn't throw an exception!");
		} catch (ArgumentIsNullException e) {}
		
		// statechart file is null
		parameterSet = new SimulationParameterSet() {
			
			public File getSimulationSystem() {
				return null;
			}
		
			public int getInstanceNumber() {
				return 1;
			}

			public boolean isRealtime() {
				return false;
			}
		};
		
		try {
			engine.setSimulationParameterSet(parameterSet);
			fail("The statechart file is null, but no error occurs!");
		} catch (ArgumentIsNullException e) { }
		
		// statechart file does not exist 
		parameterSet = new SimulationParameterSet() {
			
			public File getSimulationSystem() {
				return new File("wrongpath");
			}
		
			public int getInstanceNumber() {
				return 1;
			}

			public boolean isRealtime() {
				return false;
			}
		};
		
		try {
			engine.setSimulationParameterSet(parameterSet);
			fail("The statechart file does not exist, but no error occurs!");
		} catch (UnableToParseStatechart e) { }
	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#startSimulation()}.
	 */
	@Test(timeout=10000)
	public void testStartSimulation() throws StatechartNotValid, ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, IOException {
		
		// --- Normal case ---

		// Normal start
		engine.startSimulation();
		
		// Pause
		engine.pause();
		long start = System.currentTimeMillis();
		while(!engine.isPaused() && (System.currentTimeMillis()-start)<1000) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (!engine.isPaused()){
			fail("Engine pause took too long and was not realized under one second");
		}

		// Change simulation mode
		engine.startSingleStep();
		start = System.currentTimeMillis();
		while(!engine.isPaused() && (System.currentTimeMillis()-start)<1000) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		if (!engine.isPaused()){
			fail("Engine single step took too long and was not realized under one second");
		}
		// Resume
		engine.startSimulation();
		
		// Start two times
		engine.startSimulation();
		
		// Start in other mode
		engine.startSingleStep();
		
		engine.stop();
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		engine.startSingleStep();
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#startSingleStep()}.
	 */
	@Test(timeout=10000)
	public void testStartSingleStep() throws StatechartNotValid, ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, IOException {
		
		// --- Normal case ---

		// Normal start
		engine.startSingleStep();
		
		// Change simulation mode
		while(!engine.isPaused()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		engine.startSimulation();
		engine.pause();
		while(!engine.isPaused()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// Resume
		while(!engine.isPaused()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		engine.startSingleStep();
		
		// Start two times
		engine.startSingleStep();
		
		// Start in other mode
		engine.startSimulation();
		
		engine.stop();
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		engine.startSimulation();
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#initializeSimulator()}.
	 */
	@Test(timeout=10000)
	public void testInitializeSimulator() throws Exception {

		// --- Normal case ---

		engine.initializeSimulator();
		
		// --- Exceptional case ---

		// Parameters are not set
		engine = new SCEngine(new StatechartSimulator());
		try {
			engine.initializeSimulator();
		} catch(ArgumentIsNullException e) {}

		// All exceptions are only tested directly with the help of the class SCSimulator (method initializeStatemachine())
		
		// Simulation is running, but the parameter set is new
		setUp();
		engine.startSimulation();
		engine.setSimulationParameterSet(getParameterSet(statechartfile));
		engine.initializeSimulator();		
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#isStopped()}.
	 */
	@Test(timeout=10000)
	public void testIsStopped() throws Exception {
		
		// --- Normal case ---
		
		engine.initializeSimulator();
		assertTrue("The engine is intialized and was never started, but the result of isStopped() is \"false\"!", engine.isStopped());
		
		// Stopped system
		engine.startSimulation();
		engine.stop();
		while(!engine.isStopped()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertTrue("The engine is disposed, but the method isStopped() returns \"false\"!", engine.isStopped());
		
		// Engine is not initialized
		setUp();
		assertTrue("The engine was never initialized and started, but the result of isStopped() is \"false\"!", engine.isStopped());	
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#isFinished()}.
	 */
	@Test(timeout=10000)
	public void testIsFinished() throws Exception {
		
		// --- Normal case ---
		
		engine.initializeSimulator();
		assertFalse("The engine is intialized and was never started, but the result of isFinished() is \"true\"!", engine.isFinished());
		
		// Finished system
		engine = new SCEngine(new StatechartSimulator());
		SimulationParameterSet set = getParameterSet("com/yakindu/simulation/engine/statechart/test/resources/general/SendAfter.statemachine");
		engine.setSimulationParameterSet(set);
		engine.startSimulation();
		while(!engine.isFinished()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertFalse("The engine is disposed, but the method isFinished() returns \"true\"!", engine.isFinished());
		
		// Engine is not initialized
		setUp();
		assertFalse("The engine was never initialized and started, but the result of isFinished() is \"true\"!", engine.isFinished());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#isPaused()}.
	 */
	@Test(timeout=10000)
	public void testIsPaused() throws Exception {
		
		// --- Normal case ---
		
		engine.initializeSimulator();
		assertTrue("The engine is intialized and was never started, but the result of isPaused() is \"false\"!", engine.isPaused());
		
		engine.startSimulation();
		engine.pause();
		while(!engine.isPaused()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertFalse("The engine is disposed, but the method isPaused() returns \"true\"!", engine.isPaused());
		
		// Engine is not initialized
		setUp();
		assertFalse("The engine was never initialized and started, but the result of isPaused() is \"true\"!", engine.isPaused());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#receiveEvent(org.mda4e.simulation.core.event.IEvent)}.
	 */
	@Test
	public void testReceiveEvent() {
		// there are several others test cases which test it
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#pause()}.
	 */
	@Test(timeout=10000)
	public void testPause() throws Exception {
		
		// --- Normal case ---

		engine.startSimulation();

		engine.pause();
		
		while(!engine.isPaused()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		engine.pause();
		
		// Engine is not initialized
		setUp();
		engine.pause();
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#stop()}.
	 */
	@Test(timeout=10000)
	public void testStop() throws Exception {
		
		// --- Normal case ---

		engine.startSimulation();
		
		engine.stop();
		
		while(!engine.isStopped()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		engine.stop();
		
		// Engine is not initialized
		setUp();
		engine.stop();
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#sendActiveStates()}.
	 */
	@Test
	public void testSendActiveStates() throws Exception {
		
		// --- Normal case ---

		// see Test_StatechartSimulator.java
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertFalse("The item could be set, but the engine is disposed!", engine.sendActiveStates());
		
		// Engine is not initialized
		setUp();
		assertFalse("The event could be set, but the engine is not initialized!", engine.sendActiveStates());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#setItem(java.lang.String, java.lang.Double)}.
	 */
	@Test
	public void testSetItem() throws Exception {

		engine.initializeSimulator();

		Map<Variable, Double> inputs = engine.getInputList();
		Map<Variable, Double> variables = engine.getVariableList();
		
		Variable wishTemp = null;
		Variable roomTemp_old = null;
		
		// --- Normal case ---
		
		// Search the input "WishTemp"
		for (Variable variable : inputs.keySet()) {
			
			if(variable.getName().toLowerCase().equals("wishtemp")) {
				wishTemp = variable;
			}
		}

		// Search the input "RoomTemp_old"
		for (Variable variable : variables.keySet()) {
			
			if(variable.getName().toLowerCase().equals("roomtemp_old")) {
				roomTemp_old = variable;
			}
		}

		if(wishTemp == null || roomTemp_old == null) {
			fail("The WishTemp or the RoomTemp_old could not be found in the variable lists of the simulator!");
		}
		
		// Set the new values
		assertTrue("The variable " + wishTemp.getName() + " could not be set!", engine.setItem(wishTemp.getName(), 42.42));
		assertTrue("The variable " + roomTemp_old.getName() + " could not be set!", engine.setItem(roomTemp_old.getName(), 42.42));
		
		// Read current lists
		inputs = engine.getInputList();
		variables = engine.getVariableList();
		
		// Check the new values
		assertEquals("The new value of the input WishTemp is not right!", 42.42, inputs.get(wishTemp).doubleValue(), 0.0);
		assertEquals("The new value of the input RoomTemp_old is not right!", 42.42, variables.get(roomTemp_old).doubleValue(), 0.0);
		
		// --- Exceptional case ---

		// Item name is null
		try {
			engine.setItem(null, 1.0);
			fail("The item name is \"null\", but no exception is occurred!");	
		} catch (ArgumentIsNullException e) {}
		
		// Item value is null
		try {
			engine.setItem(wishTemp.getName(), null);
			fail("The item value is \"null\", but no exception is occurred!");	
		} catch (ArgumentIsNullException e) {}
		
		// Engine is disposed
		engine.dispose();
		assertFalse("The item could be set, but the engine is disposed!", engine.setItem(wishTemp.getName(), 0.42));
		
		// Engine is not initialized
		setUp();
		assertFalse("The event could be set, but the engine is not initialized!", engine.setItem(wishTemp.getName(), 0.42));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#setEvent(java.lang.String, boolean)}.
	 */
	@Test
	public void testSetEvent() throws Exception {

		// --- Normal case ---

		engine.initializeSimulator();
		
		assertTrue("The TestEvent could not be activated (setEvent)!", engine.setEvent("TestEvent", true));
		
		// --- Exceptional case ---

		// Event name is null
		try {
			engine.setEvent(null, true);
			fail("The event name is \"null\", but no exception is occurred!");	
		} catch (ArgumentIsNullException e) {}
		
		// Engine is disposed
		engine.dispose();
		assertFalse("The event could be set, but the engine is disposed!", engine.setEvent("TestEvent", true));
		
		// Engine is not initialized
		setUp();
		assertFalse("The event could be set, but the engine is not initialized!", engine.setEvent("TestEvent", true));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getVariableList()}.
	 */
	@Test
	public void testGetVariableList() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		assertEquals("The number of variables is wrong!", 4, engine.getVariableList().size());
		assertNotNull("The variable list of the statechart is null, its wrong!", engine.getVariableList());

		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertNull("The variable list is not \"null\", but the engine is disposed!", engine.getVariableList());
		
		// Engine is not initialized
		setUp();
		assertNull("The variable list is not \"null\", but the engine is not initialized!", engine.getVariableList());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getVariable(java.lang.String)}.
	 */
	@Test
	public void testGetVariable() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		
		// Variable is 0.0
		assertEquals("The variable was not set before, but it is not 0.0!", 0.0, engine.getVariable("WishTemp").doubleValue(), 0.0);

		// Event is not active
		assertTrue("The variable \"WishTemp\" could not be set!", engine.setItem("WishTemp", 1.0));
		assertEquals("The value of the variable could not be read!", 1.0, engine.getVariable("WishTemp").doubleValue(), 0.0);
		
		// --- Exceptional case ---

		// Variable name is null
		try {
			engine.setItem(null, 1.0);
			fail("The variable name is \"null\", but no exception is occurred!");	
		} catch (ArgumentIsNullException e) {}
		
		// Variable value is null
		try {
			engine.setItem("WishTemp", null);
			fail("The variable value is \"null\", but no exception is occurred!");	
		} catch (ArgumentIsNullException e) {}
		
		// The engine is disposed
		engine.dispose();
		assertNull("The variable value is not \"null\", but the engine is disposed!", engine.getVariable("WishTemp"));
		
		// The engine is not initialized
		setUp();
		assertNull("The variable value is not \"null\", but the engine is disposed!", engine.getVariable("WishTemp"));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getEvent(java.lang.String)}.
	 */
	@Test
	public void testGetEvent() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		
		// Event is not active
		assertFalse("The event was not activated before, but it is active (true)!", engine.getEvent("TestEvent"));

		// Event is not active
		assertTrue("The event \"TestEvent\" could not be set!", engine.setEvent("TestEvent", true));
		assertTrue("The state of the event could not be read!", engine.getEvent("TestEvent"));
		
		// --- Exceptional case ---

		// The engine is disposed
		engine.dispose();
		assertNull("The event is not \"null\", but the engine is disposed!", engine.getEvent("TestEvent"));
		
		// The engine is not initialized
		setUp();
		assertNull("The event is not \"null\", but the engine is disposed!", engine.getEvent("TestEvent"));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getInputList()}.
	 */
	@Test
	public void testGetInputList() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		assertEquals("The number of inputs is wrong!", 3, engine.getInputList().size());
		assertNotNull("The input list of the statechart is null, its wrong!", engine.getInputList());

		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertNull("The input list is not \"null\", but the engine is disposed!", engine.getInputList());
		
		// Engine is not initialized
		setUp();
		assertNull("The input list is not \"null\", but the engine is not initialized!", engine.getInputList());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getOutputList()}.
	 */
	@Test
	public void testGetOutputList() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		assertEquals("The number of outputs is wrong!", 2, engine.getOutputList().size());
		assertNotNull("The output list of the statechart is null, its wrong!", engine.getOutputList());

		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertNull("The output list is not \"null\", but the engine is disposed!", engine.getOutputList());
		
		// Engine is not initialized
		setUp();
		assertNull("The output list is not \"null\", but the engine is not initialized!", engine.getOutputList());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getEventList()}.
	 */
	@Test
	public void testGetEventList() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		assertEquals("The number of events is wrong!", 1, engine.getEventList().size());		
		assertNotNull("The event list of the statechart is null, its wrong!", engine.getEventList());
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertNull("The event list is not \"null\", but the engine is disposed!", engine.getEventList());
		
		// Engine is not initialized
		setUp();
		assertNull("The event list is not \"null\", but the engine is not initialized!", engine.getEventList());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getActiveStates()}.
	 */
	@Test
	public void testGetActiveStates() throws Exception {

		// --- Normal case ---

		engine.initializeSimulator();
		assertEquals("The number of active states is wrong!", 0, engine.getActiveStates().size());
		assertNotNull("The list of active states is null, but the engine is initialized!", engine.getActiveStates());
		
		// --- Exceptional case ---

		// Engine is disposed
		engine.dispose();
		assertNull("The list of active states is not \"null\", but the engine is disposed!", engine.getActiveStates());
		
		// Engine is not initialized
		setUp();
		assertNull("The list of active states is not \"null\", but the engine is not initialized!", engine.getActiveStates());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#getStatechart()}.
	 */
	@Test
	public void testGetStatechart() throws Exception {
		
		// --- Normal case ---

		engine.initializeSimulator();
		assertNotNull("The statechart is \"null\", but the engine is initialized!", engine.getStatechart());
		
		// --- Exceptional case ---

		engine.dispose();
		assertNull("The statechart is not \"null\", but the engine is disposed!", engine.getStatechart());
		
		setUp();
		assertNull("The statechart is not \"null\", but the engine is not initialized!", engine.getStatechart());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCEngine#dispose()}.
	 */
	@Test
	public void testDispose() throws IOException, StatechartNotValid, ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException {
		
		// --- Normal case ---

		// Without initialization
		engine.dispose();
		
		// With initialization
		engine.initializeSimulator();
		engine.dispose();
		
		// With started simulation
		engine.initializeSimulator();
		engine.startSimulation();
		engine.dispose();
		
		// --- Exceptional case ---

		// A second time
		engine.dispose();
	}
}

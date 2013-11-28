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

import org.junit.Before;
import org.junit.Test;

import com.yakindu.simulation.engine.statechart.engine.SCSimulator;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ChangeConfigurationException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ObjectDisposedException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.PseudostateNotImplemented;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler;
import com.yakindu.simulation.engine.statechart.test.Utilities;

import statemachine.Event;
import statemachine.Statechart;
import statemachine.Variable;

/**
 * Defines test cases to validate the functionality of the class {@link SCSimulator}.
 * 
 * @author Philipp Richter
 */
public class Test_SCSimulator {

	/** Class to test. */
	private SCSimulator simulator = null;
	
	/** Defines the statechart to test the class. */
	private String statechartFile = "com/yakindu/simulation/engine/statechart/test/resources/general/Substates.statemachine";

	/** Defines the name of the statechart which is defined by the <code>statechartFile</code>. */
	private String statechartName = "Substates";
	/** Defines the uuid of the statechart which is defined by the <code>statechartFile</code>. */
	private String statechartUUID = "e337e278-2ee4-4320-9795-03be5ebe8796";
	/** Defines the name of the event "leave". */
	private String event_leave = "leave";
	/** Defines the name of the variable "variable". */
	private String var_variable = "variable";
	/** Defines the name of the input "input". */
	private String in_input = "Input";
	/** Defines the name of the output "output". */
	private String out_output = "Output";
	
	/**
	 * Sets up the test environment.
	 */
	@Before
	public void setUp() throws Exception {
		
		simulator = new SCSimulator(new TimeEventScheduler());
		simulator.initializeStatemachine(Utilities.getFile(getClass(), statechartFile));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#SCSimulator()}.
	 */
	@Test
	public void testSCSimulator() {
		// not needed see setUp()
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#initializeStatemachine(java.lang.String)}.
	 */
	@Test
	public void testInitializeStatemachine() {
		
		// --- Normal case ---
		
		// Check the properties of the statemachine after the initialization.
		assertEquals("The number of active states is wrong!", 0, simulator.getActiveStates().size());
		assertEquals("The number of events is wrong!", 1, simulator.getEventList().size());
		assertEquals("The number of inputs is wrong!", 1, simulator.getInputList().size());
		// Is manually set
		//assertEquals("The instance number is wrong!", 1, simulator.getInstance());
		assertEquals("The name of the statechart is wrong!", statechartName, simulator.getName());
		assertEquals("The number of outputs is wrong!", 1, simulator.getOutputList().size());
		// Not possible
		//assertEquals("The statechart instance is not the same one!", statechart, simulator.getStatechart());
		assertEquals("The uuid was changed!", statechartUUID, simulator.getUUID());
		assertEquals("The number of variables is wrong!", 2, simulator.getVariableList().size());
		assertEquals("The isFinished() method provides the wrong state!", false, simulator.isFinished());
		assertEquals("The isInitialized() method provides the wrong state!", true, simulator.isInitialized());
		
		// --- Exceptional case ---

		// all exceptional cases are implemented in an own class
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#resetStatemachine()}.
	 */
	@Test(timeout=10000)
	public void testResetStatemachine() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---
		
		simulator.resetStatemachine();
		
		// Without changes
		assertEquals("The number of active states is wrong!", 0, simulator.getActiveStates().size());
		assertEquals("The number of events is wrong!", 1, simulator.getEventList().size());
		assertEquals("The number of inputs is wrong!", 1, simulator.getInputList().size());
		//assertEquals("The instance number is wrong!", 1, simulator.getInstance());
		assertEquals("The name of the statechart is wrong!", statechartName, simulator.getName());
		assertEquals("The number of outputs is wrong!", 1, simulator.getOutputList().size());
		// Not possible
		//assertEquals("The statechart instance is not the same one!", statechart, simulator.getStatechart());
		assertEquals("The uuid was changed!", statechartUUID, simulator.getUUID());
		assertEquals("The number of variables is wrong!", 2, simulator.getVariableList().size());
		assertEquals("The isFinished() method provides the wrong state!", false, simulator.isFinished());
		assertEquals("The isInitialized() method provides the wrong state!", true, simulator.isInitialized());
		
		// Initialize the simulation again
		setUp();
		
		// Save all properties
		int activeStates = simulator.getActiveStates().size();
		int eventList = simulator.getEventList().size();
		int inputList = simulator.getInputList().size();
		int instance = simulator.getInstance();
		String name = simulator.getName();
		int outputList = simulator.getOutputList().size();
		Statechart statechart = simulator.getStatechart();
		String uuid = simulator.getUUID();
		int variableList = simulator.getVariableList().size();
		boolean isFinished = simulator.isFinished();
		boolean isInitialized = simulator.isInitialized();
		
		// Two changes -> State1 and Substate1 are active
		simulator.changeStateConfiguration();
		simulator.changeStateConfiguration();
		
		simulator.resetStatemachine();
		
		assertEquals("The number of active states is wrong!", activeStates, simulator.getActiveStates().size());
		assertEquals("The number of events is wrong!", eventList, simulator.getEventList().size());
		assertEquals("The number of inputs is wrong!", inputList, simulator.getInputList().size());
		//assertEquals("The instance number is wrong!", instance, simulator.getInstance());
		assertEquals("The name of the statechart is wrong!", name, simulator.getName());
		assertEquals("The number of outputs is wrong!", outputList, simulator.getOutputList().size());
		assertEquals("The statechart instance is not the same one!", statechart, simulator.getStatechart());
		assertEquals("The uuid was changed!", uuid, simulator.getUUID());
		assertEquals("The number of variables is wrong!", variableList, simulator.getVariableList().size());
		assertEquals("The isFinished() method provides the wrong state!", isFinished, simulator.isFinished());
		assertEquals("The isInitialized() method provides the wrong state!", isInitialized, simulator.isInitialized());
		
		// Now let the simulation run until it is finished.
		setUp();
		
		// save the new instance
		statechart = simulator.getStatechart();
		
		while (!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		simulator.resetStatemachine();

		assertEquals("The number of active states is wrong!", activeStates, simulator.getActiveStates().size());
		assertEquals("The number of events is wrong!", eventList, simulator.getEventList().size());
		assertEquals("The number of inputs is wrong!", inputList, simulator.getInputList().size());
		assertEquals("The instance number is wrong!", instance, simulator.getInstance());
		assertEquals("The name of the statechart is wrong!", name, simulator.getName());
		assertEquals("The number of outputs is wrong!", outputList, simulator.getOutputList().size());
		assertEquals("The statechart instance is not the same one!", statechart, simulator.getStatechart());
		assertEquals("The uuid was changed!", uuid, simulator.getUUID());
		assertEquals("The number of variables is wrong!", variableList, simulator.getVariableList().size());
		assertEquals("The isFinished() method provides the wrong state!", isFinished, simulator.isFinished());
		assertEquals("The isInitialized() method provides the wrong state!", isInitialized, simulator.isInitialized());
		
		// --- Exceptional case ---

		// Simulator was not initialized
		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		try {
			sim.resetStatemachine();
			fail("The statemachine was not initialized, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
		
		// Simulator is disposed
		simulator.dispose();
		try {
			simulator.resetStatemachine();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (ObjectDisposedException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getUUID()}.
	 */
	@Test
	public void testGetUUID() {
		
		// --- Normal case ---

		assertEquals("The uuid of the statechart is not right! Was it updated?", statechartUUID, simulator.getUUID());
		
		// --- Exceptional case ---

		assertNotNull("The uuid is \"null\"!", simulator.getUUID());
		assertFalse("The uuid is empty!", simulator.getUUID().equals(""));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getName()}.
	 */
	@Test
	public void testGetName() {
		
		// --- Normal case ---

		assertEquals("The name of the statechart is not right!", statechartName, simulator.getName());
		
		// --- Exceptional case ---

		assertNotNull("The name is \"null\"!", simulator.getName());
		assertFalse("The name is empty!", simulator.getName().equals(""));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getVariable(java.lang.String)}.
	 */
	@Test
	public void testGetVariable() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---

		// Initial value
		assertEquals("The value of the variable \"variable\" is wrong!", 0.0, simulator.getVariable(var_variable).doubleValue(), 0.0);
		
		simulator.changeStateConfiguration();
		
		// Variable was changed by the simulation
		assertEquals("The value of the variable \"variable\" is wrong!", 2.0, simulator.getVariable(var_variable).doubleValue(), 0.0);
		
		// --- Exceptional case ---

		// Parameter is null
		assertNull("The parameter was \"null\" but the result not!" , simulator.getVariable(null));
		// Parameter doesn't exist in the lists
		assertNull("The variable is not in the list but the result was not \"null\"!" , simulator.getVariable("notinlist"));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getEvent(java.lang.String)}.
	 */
	@Test
	public void testGetEvent() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---

		// Initial state
		assertFalse("The state of the event \"leave\" is wrong!", simulator.getEvent(event_leave));
		
		simulator.changeStateConfiguration();
		
		// Variable was changed by the simulation
		assertTrue("The value of the event \"leave\" is wrong!", simulator.getEvent(event_leave));
		
		// --- Exceptional case ---

		// Parameter is null
		assertNull("The parameter was \"null\" but the result not!", simulator.getEvent(null));
		// Parameter doesn't exist in the lists
		assertNull("The variable is not in the list but the result was not \"null\"!", simulator.getEvent("notinlist"));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getEventList()}.
	 */
	@Test(timeout=10000)
	public void testGetEventList() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---

		// Check the number of events
		assertEquals("The number of events in the event list is wrong, if the simulation is initialized, but not started!",
				1,
				simulator.getEventList().size());
		
		// Check the event name
		assertNotNull("The name of the event in the list is wrong!", getItemOutOfList(event_leave));
		
		// Update the event and check the value in the list
		simulator.setEvent(event_leave, true);
		assertEquals("The value of the event in the list is wrong!", 1.0, getItemOutOfList(event_leave), 0.0);
		
		// Finish the simulation and check again
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		assertEquals("The number of events in the event list is wrong, if the simulation is initialized and the simulation is finished!",
				1,
				simulator.getEventList().size());
		
		// --- Exceptional case ---

		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		
		assertEquals("The number of events in the event list is wrong, if the simulator was not initialized!",
				0,
				sim.getEventList().size());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getVariableList()}.
	 */
	@Test(timeout=10000)
	public void testGetVariableList() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		// --- Normal case ---

		// Check the number of variables
		assertEquals("The number of variables in the variable list is wrong, if the simulation is initialized, but not started!",
				2,
				simulator.getVariableList().size());
		
		// Check the variable name
		assertNotNull("The name of the variable in the list is wrong!", getItemOutOfList(var_variable));
		
		// Update the variable and check the value in the list
		assertTrue("The item could not be set!", simulator.setItem(var_variable, 42.0));
		assertEquals("The value of the variable in the list is wrong!", 42.0, getItemOutOfList(var_variable), 0.0);
		
		// Finish the simulation and check again
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		assertEquals("The number of variables in the variable list is wrong, if the simulation is initialized and the simulation is finished!",
				2,
				simulator.getVariableList().size());
		
		// --- Exceptional case ---

		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		
		assertEquals("The number of variables in the variable list is wrong, if the simulator was not initialized!",
				0,
				sim.getVariableList().size());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getInputList()}.
	 */
	@Test(timeout=10000)
	public void testGetInputList() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		// --- Normal case ---

		// Number of inputs
		assertEquals("The number of inputs in the input list is wrong, if the simulation is initialized, but not started!",
				1,
				simulator.getInputList().size());
		
		// Check the input name
		assertNotNull("The name of the input in the list is wrong!", getItemOutOfList(in_input));
		
		// Update the input and check the value in the list
		assertTrue("The item could not be set!", simulator.setItem(in_input, 42.0));
		assertEquals("The value of the input in the list is wrong!", 42.0, getItemOutOfList(in_input),0.0);
		
		// Finish the simulation and check again
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		assertEquals("The number of inputs in the input list is wrong, if the simulation is initialized and the simulation is finished!",
				1,
				simulator.getInputList().size());
		
		// --- Exceptional case ---

		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		
		assertEquals("The number of inputs in the input list is wrong, if the simulator was not initialized!",
				0,
				sim.getInputList().size());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getOutputList()}.
	 */
	@Test(timeout=10000)
	public void testGetOutputList() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---

		// Check the number of outputs
		assertEquals("The number of outputs in the output list is wrong, if the simulation is initialized, but not started!",
				1,
				simulator.getOutputList().size());
		
		// Check the output name
		assertNotNull("The name of the output in the list is wrong!", getItemOutOfList(out_output));
		
		// Update the output and check the value in the list
		assertTrue("The item could not be set!", simulator.setItem(out_output, 42.0));
		assertEquals("The value of the output in the list is wrong!", 42.0, getItemOutOfList(out_output),0.0);
		
		// Finish the simulation and check again
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		assertEquals("The number of outputs in the output list is wrong, if the simulation is initialized and the simulation is finished!",
				1,
				simulator.getOutputList().size());
		
		// --- Exceptional case ---

		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		
		assertEquals("The number of outputs in the output list is wrong, if the simulator was not initialized!",
				0,
				sim.getOutputList().size());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#changeStateConfiguration()}.
	 */
	@Test(timeout=10000)
	public void testChangeStateConfiguration() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---

		// The functionality of the simulation of statemachines is tested in another test classes!
		
		// Simulator is initialized and was never started
		simulator.changeStateConfiguration();
		
		// --- Exceptional case ---

		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		// Simulator is finished
		simulator.changeStateConfiguration();
		
		// Simulator is not initialized
		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		try {
			sim.changeStateConfiguration();
			fail("The simulation is not initialized, but no exception is occurred!");
		} catch (ChangeConfigurationException e) {}
		
		// Simulator is disposed
		simulator.dispose();
		try {
			simulator.changeStateConfiguration();
			fail("The simulation is disposed, but no exception is occurred!");
		} catch (ObjectDisposedException e) {}
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#pauseTimers()}.
	 */
	@Test
	public void testPauseTimer() {
		// not needed; is tested by another functionality test
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#isInitialized()}.
	 */
	@Test(timeout=10000)
	public void testIsInitialized() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		// --- Normal case ---

		// Is initialized
		assertTrue("The simulator is initialized, but the function returns another state!", simulator.isInitialized());
		
		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		
		// Is not initialized
		assertFalse("The simulator is not initialized, but the function returns another state!", sim.isInitialized());
		
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		// Is initialized and finished
		assertTrue("The simulation was finished, but the function isInitialized() returns \"false\"!", simulator.isInitialized());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#isFinished()}.
	 */
	@Test(timeout=10000)
	public void testIsFinished() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {

		// --- Normal case ---

		// Is only initialized
		assertFalse("The simulation is initialized but not finished!", simulator.isFinished());
		
		simulator.changeStateConfiguration();
		
		// A single step of the simulation was done
		assertFalse("One single step was done but the simulation is not finished!", simulator.isFinished());
		
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		// The simulation is finished
		assertTrue("The simulation is finished!", simulator.isFinished());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#setItem(java.lang.String, java.lang.Double)}.
	 */
	@Test
	public void testSetItem() throws ArgumentIsNullException {
		
		// --- Normal case ---

		assertTrue("The item could not be set!", simulator.setItem(var_variable, 2.22));
		assertTrue("The item could not be set!", simulator.setItem(in_input, 1E1));
		assertTrue("The item could not be set!", simulator.setItem(out_output, -100000000000000000000.0));
		assertTrue("The item could not be set!", simulator.setItem(event_leave, 1.0));
		
		assertEquals("The variable could not be set or the value is not right!", 2.22, simulator.getVariable(var_variable).doubleValue(), 0.0);
		assertEquals("The input could not be set or the value is not right!", 10.0, simulator.getVariable(in_input).doubleValue(), 0.0);
		assertEquals("The output could not be set or the value is not right!", -100000000000000000000.0, simulator.getVariable(out_output).doubleValue(), 0.0);
		assertTrue("The event could not be set or the state is not right!", simulator.getEvent(event_leave));
		
		assertTrue("The item could not be set!", simulator.setItem(var_variable, -2.22));
		assertTrue("The item could not be set!", simulator.setItem(in_input, 1d));
		assertTrue("The item could not be set!", simulator.setItem(out_output, .00000000000000000000));
		assertTrue("The item could not be set!", simulator.setItem(event_leave, -1.0));
		
		assertEquals("The variable could not be set or the value is not right!", -2.22, simulator.getVariable(var_variable).doubleValue(), 0.0);
		assertEquals("The input could not be set or the value is not right!", 1.0, simulator.getVariable(in_input).doubleValue(), 0.0);
		assertEquals("The output could not be set or the value is not right!", 0.0, simulator.getVariable(out_output).doubleValue(), 0.0);
		assertTrue("The event could not be set or the state is not right!", simulator.getEvent(event_leave));
		
		assertTrue("The item could not be set!", simulator.setItem(var_variable, -0.0));
		assertTrue("The item could not be set!", simulator.setItem(in_input, 1.01));
		assertTrue("The item could not be set!", simulator.setItem(out_output, 0.0));
		assertTrue("The item could not be set!", simulator.setItem(event_leave, 0.0));
		
		// TODO The result is -0.0, too. Is it OK or not!?
		assertEquals("The variable could not be set or the value is not right!", -0.0, simulator.getVariable(var_variable).doubleValue(), 0.0);
		assertEquals("The input could not be set or the value is not right!", 1.01, simulator.getVariable(in_input).doubleValue(), 0.0);
		assertEquals("The output could not be set or the value is not right!", 0.0, simulator.getVariable(out_output).doubleValue(), 0.0);
		assertFalse("The event could not be set or the state is not right!", simulator.getEvent(event_leave));
		
		// --- Exceptional case ---

		// Variable/Event name is null
		try {
			assertTrue("The item could not be set!", simulator.setItem(null, 1.0));
			fail("The variable/event name is \"null\" but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}

		// Variable/Event name is null
		try {
			assertTrue("The item could not be set!", simulator.setItem(var_variable, null));
			fail("The variable/event value is \"null\" but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// Big value
		Double bigvalue = 1e154;
		assertTrue("The item could not be set!", simulator.setItem(out_output, bigvalue));
		
		assertEquals("The output could not be set or the value is not right!", bigvalue, simulator.getVariable(out_output));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		
		// --- Normal case ---

		assertEquals("The instance number is wrong!", 1, simulator.getInstance());

		// Not initialized
		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		assertEquals("The instance number is wrong!", 1, sim.getInstance());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#setInstance(int)}.
	 */
	@Test(timeout=10000)
	public void testSetInstance() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		// --- Normal case ---

		simulator.setInstance(2);
		
		assertEquals("The instance number could not be set or the value is wrong!", 2, simulator.getInstance());
		
		// Not initialized
		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		sim.setInstance(3);
		assertEquals("The instance number could not be set or the value is wrong!", 3, sim.getInstance());
		
		// Simulation is finished
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
			Thread.yield();
		}
		
		simulator.setInstance(1);
		assertEquals("The instance number could not be set or the value is wrong!", 1, simulator.getInstance());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getActiveStates()}.
	 */
	@Test
	public void testGetActiveStates() throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		// --- Normal case ---

		// Never started
		assertEquals("The simulation is never started, but the number of active states is not zero!", 0, simulator.getActiveStates().size());
		
		// A single step was done
		simulator.changeStateConfiguration();
		
		// There must be three active states
		assertEquals("A single step was calculated and the number of active states is wrong!", 3, simulator.getActiveStates().size());
		
		assertEquals("The first active state is not the expected one!", "State1", simulator.getActiveStates().get(0).getName());
		assertEquals("The second active state is not the expected one!", "Substate1", simulator.getActiveStates().get(1).getName());
		assertEquals("The third active state is not the expected one!", "SubSub1", simulator.getActiveStates().get(2).getName());
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#receiveEvent(org.mda4e.simulation.core.event.IEvent)}.
	 */
	@Test
	public void testReceiveEvent() {
		// Not needed; tested by the functionality tests
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#setInput(java.lang.String, double)}. 
	 */
	/*@Test
	public void testSetInput() throws ArgumentIsNullException {
		
		// --- Normal case ---

		simulator.setInput(in_input, 42.0);
		
		assertEquals("The input could not be set!", 42.0, simulator.getVariable(in_input));
		
		// --- Exceptional case ---

		// The name is "null"
		try {
			simulator.setInput(null, 0.0);
			fail("The input name is \"null\" but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// The variable is not an input
		assertFalse("The given variable is no input, but the result is \"true\"!", simulator.setInput(var_exit, 2.0));
	}*/

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#setVariable(java.lang.String, double)}.
	 */
	/*@Test
	public void testSetVariable() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#setEvent(java.lang.String, boolean)}.
	 */
	@Test
	public void testSetEvent() throws ArgumentIsNullException {
		
		// --- Normal case ---

		assertTrue("The event could not be activated!", simulator.setEvent(event_leave, true));
		assertTrue("The event was activated, but the retrieved state is wrong!", simulator.getEvent(event_leave));
		assertTrue("The event could not be deactivated!", simulator.setEvent(event_leave, false));
		assertFalse("The event was activated, but the retrieved state is wrong!", simulator.getEvent(event_leave));
		
		// --- Exceptional case ---

		// Name is "null"
		try {
			simulator.setEvent(null, true);
			fail("The event name is \"null\" but no exception is occurred!");
		} catch (ArgumentIsNullException e) {}
		
		// Event doesn't exist
		assertNull("The event doesn't exist in the current simulation system, but the result is not \"null\"!", simulator.getEvent("eventdoesnotexist"));
		
		// Simulator is not initialized
		SCSimulator sim = new SCSimulator(new TimeEventScheduler());
		assertFalse("The event could be activated, but the simulator is not initialized!", sim.setEvent(event_leave, true));
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#getStatechart()}.
	 */
	@Test
	public void testGetStatechart() {
		
		assertNotNull("The simulation is initialized, but the statechart instance is \"null\"!", simulator.getStatechart());
		
		assertEquals("The value of the statechart.getName() method is wrong!", statechartName, simulator.getStatechart().getName());
	}
	
	/**
	 * Returns the value of the variable/event with the given name. This method
	 * search the value by the lists.
	 * 
	 * @param name	defines the name of the variable/event which value shall be returned
	 * 
	 * @return	The value of the variable/event with the given name.
	 */
	protected double getItemOutOfList(String name) {
		
		Double result = null;
		boolean found = false;
		
		for (Variable var : simulator.getVariableList().keySet()) {
			if(var.getName().equals(name)) {
				result = simulator.getVariableList().get(var);
				found = true;
				break;
			}
		}
		
		if(!found) {
		
			for (Variable input : simulator.getInputList().keySet()) {
				if(input.getName().equals(name)) {
					result = simulator.getInputList().get(input);
					found = true;
					break;
				}
			}
		}
		
		if(!found) {
			
			for (Variable output : simulator.getOutputList().keySet()) {
				if(output.getName().equals(name)) {
					result = simulator.getOutputList().get(output);
					found = true;
					break;
				}
			}
		}
		
		if(!found) {
				
			for(Event event : simulator.getEventList().keySet()) {
				if(event.getName().equals(name)) {
					result = simulator.getEventList().get(event) ? 1.0 : 0.0;
					break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Test case which interrupts the simulator when it is waiting for a notification.
	 */
	@Test(timeout=10000)
	public void testInterruptWait() throws ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		simulator.initializeStatemachine(Utilities.getFile(Test_SCSimulator.class, "com/yakindu/simulation/engine/statechart/test/resources/changestateconf/TransitionTimer.statemachine"));

		// Achieve the right state configuration
		simulator.changeStateConfiguration();
		simulator.changeStateConfiguration();
		
		Thread thread = new Thread(new Runnable() {

			public void run() {
				try {
					simulator.changeStateConfiguration();
				} catch (ParserException e) {
					e.printStackTrace();
				} catch (ArgumentIsNullException e) {
					e.printStackTrace();
				} catch (ChangeConfigurationException e) {
					e.printStackTrace();
				} catch (PseudostateNotImplemented e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		
		// Wait until the simulator "wait" for notification by the timer
		while(!thread.getState().equals(Thread.State.WAITING)) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		// Interrupt the thread when it is waiting
		thread.interrupt();
		
		// Wait until the thread is interrupted
		while(!thread.getState().equals(Thread.State.TERMINATED)) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}

		// Check whether the simulation can be continued
		while(!simulator.isFinished()) {
			simulator.changeStateConfiguration();
		}
	}
}
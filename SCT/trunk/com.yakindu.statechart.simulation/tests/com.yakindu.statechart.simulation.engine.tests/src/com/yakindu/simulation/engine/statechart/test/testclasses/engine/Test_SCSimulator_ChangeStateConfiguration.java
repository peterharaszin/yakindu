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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.yakindu.simulation.engine.statechart.engine.SCSimulator;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ChangeConfigurationException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.PseudostateNotImplemented;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler;
import com.yakindu.simulation.engine.statechart.test.Utilities;

/**
 * @author Philipp Richter
 *
 */
public class Test_SCSimulator_ChangeStateConfiguration {

	/** Defines the instance of the class to test. */
	private SCSimulator simulator = null;
	
	/** Defines the file of the current statechart file. */
	private String statechartFile = null;
	
	/**
	 * Sets up the test environment.
	 * 
	 * @param path	defines the path of the statechart file
	 */
	private void setUp(String path) throws Exception {
		
		simulator = new SCSimulator(new TimeEventScheduler());
		simulator.initializeStatemachine(path);
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#changeStateConfiguration()}.
	 */
	@Test
	public void testChangeStateConfiguration() throws ChangeConfigurationException, PseudostateNotImplemented, Exception {

		statechartFile = "com/yakindu/simulation/engine/statechart/test/resources/changestateconf/ChangeStateConfiguration.statemachine";
		
		// --- Normal case --- 
		
		// Deactivate an event between two steps
		setUp(Utilities.getFile(getClass(), statechartFile));
		selectMode(1.0);
		assertTrue("The event \"event\" could not be set!", simulator.setEvent("event", false));
		simulator.changeStateConfiguration();
		assertEquals("The event was deactivated, but the state was  regardless changed!", "Event", simulator.getActiveStates().get(0).getName());
		
		// Check transition priority handling
		setUp(Utilities.getFile(getClass(), statechartFile));
		selectMode(2.0);
		simulator.changeStateConfiguration();
		assertEquals("The priority of the states was not respected by the simulator! State \"1\" and State \"2\" have smaller priorties as state \"0\", but state \"0\" is not active.", "0", simulator.getActiveStates().get(0).getName());
		
		// Check the validation of a variable which doesn't exist
		try {
			setUp(Utilities.getFile(getClass(), statechartFile));
			selectMode(3.0);
			fail("The variable \"notexist\" which is not defined as a variable, but is used in the action of the state \"NotExistV\" was not detected by the simulator!");
		} catch (ParserException e) {}
		
		// Check the validation of a event which doesn't exist
		try {
			setUp(Utilities.getFile(getClass(), statechartFile));
			selectMode(4.0);
			fail("The event \"notexistevent\" which is not defined as a event, but is used in the action of the state \"NotExistE\" was not detected by the simulator!");
		} catch (ParserException e) {}
		
		try {
			setUp(Utilities.getFile(getClass(), statechartFile));
			selectMode(5.0);
			fail("The region of the state \"InitialNoTarget\" has a initial state without a target, but no exception is occurred.");
		} catch (ChangeConfigurationException e) {}
		
		try {
			setUp(Utilities.getFile(getClass(), statechartFile));
			selectMode(6.0);
			fail("The region of the state \"NoInitialState\" has no initial state, but no exception is occurred.");
		} catch (ChangeConfigurationException e) {}
	}

	/**
	 * Allows to select a mode. The "mode" is an attribute of the diagram
	 * and will be set.
	 * 
	 * @param mode	defines the value of the variable "mode"
	 */
	private void selectMode(Double mode) throws ParserException, ArgumentIsNullException, ChangeConfigurationException, PseudostateNotImplemented, Exception {
		
		simulator.changeStateConfiguration();
		// selects the given mode
		assertTrue("The variable \"mode\" could not be set!", simulator.setItem("mode", mode));
		simulator.changeStateConfiguration();
	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSimulator#changeStateConfiguration()}.
	 */
	@Test
	public void testChangeStateConfiguration2() throws Exception {
		
		statechartFile = "com/yakindu/simulation/engine/statechart/test/resources/changestateconf/InitialWithExpression2.statemachine";
		
		simulator = new SCSimulator(new TimeEventScheduler());
		simulator.initializeStatemachine(Utilities.getFile(getClass(), statechartFile));
		
		// Transition of initial state has a guard
		try {
			setUp(Utilities.getFile(getClass(), statechartFile));
			selectMode(1.0);
			fail("The transistion of the initial state has a guard (state: \"State2\", but no exception is occurred.");
		} catch (ParserException e) {}
		
		// Transition of initial state has a trigger
		try {
			setUp(Utilities.getFile(getClass(), statechartFile));
			selectMode(2.0);
			fail("The transistion of the initial state has a trigger (state: \"State4\", but no exception is occurred.");
		} catch (ParserException e) {}
		
	}
}

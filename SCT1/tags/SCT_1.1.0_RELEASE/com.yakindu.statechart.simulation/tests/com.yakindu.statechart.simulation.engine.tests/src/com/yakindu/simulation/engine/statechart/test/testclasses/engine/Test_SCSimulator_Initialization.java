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


import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.yakindu.simulation.engine.statechart.engine.SCSimulator;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ObjectDisposedException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEventScheduler;
import com.yakindu.simulation.engine.statechart.test.Utilities;

/**
 * Defines test cases for the method {@link SCSimulator#initializeStatemachine(String)}.
 * 
 * @author Philipp Richter
 */
public class Test_SCSimulator_Initialization {

	/** Defines the instance of the class to test. */
	private SCSimulator simulator = null;
	
	/** Defines the file of the current statechart file. */
	private File statechartFile = null;
	
	/**
	 * Sets up the test environment.
	 */
	@Before
	public void setUp() throws Exception {
	
		simulator = new SCSimulator(new TimeEventScheduler());
	}

	/**
	 * Tests the verification of the initial states. 
	 */
	@Test(timeout=10000)
	public void test_InitialWithExpression() throws StatechartNotValid, ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, ObjectDisposedException {
		
		// --- Normal case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/InitialWithAction.statemachine"));
		simulator.initializeStatemachine(statechartFile.getAbsolutePath());

		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/InitialWithExpression.statemachine"));
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The initial state of the statechart has a guard, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart without an initial state.
	 */
	@Test(timeout=10000)
	public void test_WithoutInitialState() throws ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutInitialState.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart has no initial state, but no exception is occurred!");
		} catch (StatechartNotValid e) {}	
	}
	
	/**
	 * Tests the verification of a statechart without a name.
	 */
	@Test
	public void test_WithoutName() throws ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutName.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart has no name, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a name like "".
	 */
	@Test
	public void test_WithoutNameEmpty() throws ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutNameEmpty.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart name is empty, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart without a UUID. 
	 */
	@Test
	public void test_WithoutUUID() throws ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutUUID.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart has no UUID, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a UUID like "".
	 */
	@Test
	public void test_WithoutUUIDEmpty() throws ParserException, UnableToParseStatechart, ArgumentIsNullException, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutUUIDEmpty.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart UUID is empty, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart with more than one region.
	 */
	@Test
	public void test_TwoRegions() throws ParserException, UnableToParseStatechart, ArgumentIsNullException, StatechartNotValid, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/TwoRegions.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart has on a specific level more than one region, but no exception is occurred!");
		} catch (SupportException e) {}
	}
	
	/**
	 * Tests the initialization with a wrong path which does not exist.
	 */
	@Test
	public void test_WrongPath() throws ParserException, ArgumentIsNullException, StatechartNotValid, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File("com/yakindu/simulation/engine/statechart/test/resources/initialization/DoesNotExist.statemachine");
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart path does not exist, but no exception is occurred!");
		} catch (UnableToParseStatechart e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a initial state which is connected to another pseudo state.
	 */
	@Test
	public void test_InitialToPseudostate() throws ParserException, ArgumentIsNullException, StatechartNotValid, UnableToParseStatechart, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/InitialToPseudostate.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The initial state is connected to a pseudostate, but no exception is occurred!");
		} catch (SupportException e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a transition whose expression contains an unknown trigger.
	 */
	@Test
	public void test_TriggerIsNotDefined() throws ParserException, ArgumentIsNullException, UnableToParseStatechart, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/TriggerIsNotDefined.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The expression of one of the transitions contains a trigger which is not defined by the statechart, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a variable with an empty name or the name is <code>null</code>.
	 */
	@Test
	public void test_VariableWithoutName() throws ParserException, ArgumentIsNullException, UnableToParseStatechart, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/VariableWithoutName.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart definition contains a variable which has no name, but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a variable with an invalid name like "11".
	 * In this case the variable is not visible for a mathematical parser!
	 */
	@Test
	public void test_VariableNameNotValid() throws ParserException, ArgumentIsNullException, UnableToParseStatechart, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/VariableNameNotValid.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart definition contains a variable which has an invalid name (like \"11\"), but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
	
	/**
	 * Tests the verification of a statechart which has a variable with a name like the function "send()".
	 */
	@Test
	public void test_FunctionAsVariableName() throws ParserException, ArgumentIsNullException, UnableToParseStatechart, SupportException, ObjectDisposedException {
		
		// --- Exceptional case ---

		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/FunctionAsVariableName.statemachine"));
		
		try {
			simulator.initializeStatemachine(statechartFile.getAbsolutePath());
			fail("The statechart definition contains a variable which has a name like the function \"send()\", but no exception is occurred!");
		} catch (StatechartNotValid e) {}
	}
}

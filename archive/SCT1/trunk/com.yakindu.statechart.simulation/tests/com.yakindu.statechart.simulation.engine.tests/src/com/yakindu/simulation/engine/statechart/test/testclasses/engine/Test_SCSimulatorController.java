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
/**
 * 
 */
package com.yakindu.simulation.engine.statechart.test.testclasses.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.ISimulationParameterSet;
import org.mda4e.simulation.core.SimulationException;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;

import com.yakindu.simulation.engine.statechart.engine.SCSimulatorController;
import com.yakindu.simulation.engine.statechart.engine.SimulationParameterSet;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ObjectDisposedException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.test.Utilities;

/**
 * Defines exceptional cases to test the security of the class
 * {@link SCSimulatorController}.
 * 
 * @author Philipp Richter
 */
public class Test_SCSimulatorController {

	/** Defines the instance of the class to test. */
	private SCSimulatorController controller = null;

	/** Defines the statechart file to test the <code>controller</code>. */
	private static String statechartFile =
			"com/yakindu/simulation/engine/statechart/test/resources/general/Heater_controlled.statemachine";

	/**
	 * Creates the instance of the {@link SCSimulatorController}.
	 */
	@Before
	public void setUp() throws Exception {

		controller =
				new SCSimulatorController(
					getEngine(),
					getDefaultParameterset(new File(Utilities.getFile(
						getClass(),
						statechartFile))));
	}

	private SimulationParameterSet getDefaultParameterset(final File filePath) {

		return new SimulationParameterSet() {

			public int getInstanceNumber() {

				return 0;
			}

			public File getSimulationSystem() {

				return filePath;
			}

		};
	}

	/**
	 * Returns an engine instance with a minimum configuration.
	 * 
	 * @return The result is an instance of a {@link ISimulationEngine}.
	 */
	private ISimulationEngine getEngine() {

		ISimulationEngine engine = new ISimulationEngine() {

			public void addEventListener(IEventListener listener) {

			}

			public void disposeEngine() throws SimulationException {

			}

			public String getEngineName() {

				return null;
			}

			public int getInstanceNumber() {

				return 0;
			}

			public ISimulationParameterSet getSimulationParameters() {

				return null;
			}

			public SimulationState getSimulationState() {

				return null;
			}

			public String getSystemName() {

				return null;
			}

			public void initializeEngine() throws SimulationException {

			}

			public void pauseSimulation() throws SimulationException {

			}

			public void removeEventListener(IEventListener listener) {

			}

			public void resumeSimulation() throws SimulationException {

			}

			public void setSimulationParameters(
					ISimulationParameterSet simulationParameters)
					throws SimulationException {

			}

			public void singleStepForward() throws SimulationException {

			}

			public void startSimulation() throws SimulationException {

			}

			public void stopSimulation() throws SimulationException {

			}

			public void receiveEvent(IEvent event) {

			}
		};

		return engine;
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#addEventListener(org.mda4e.simulation.core.event.IEventListener)}
	 * .
	 */
	@Test
	public void testAddEventListener() {

		// --- Exceptional case ---

		// Listener is null
		controller.addEventListener(null);

		// Listener is in the list
		IEventListener listener = new IEventListener() {

			public void receiveEvent(IEvent event) {

			}
		};

		controller.addEventListener(listener);
		controller.addEventListener(listener);

		// Controller is disposed
		controller.dispose();
		controller.addEventListener(listener);
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#removeEventListener(org.mda4e.simulation.core.event.IEventListener)}
	 * .
	 */
	@Test
	public void testRemoveEventListener() {

		// --- Exceptional case ---

		// Listener is null
		controller.removeEventListener(null);

		IEventListener listener = new IEventListener() {

			public void receiveEvent(IEvent event) {

			}
		};

		// Listener is not in the list
		controller.removeEventListener(listener);

		// Controller is disposed
		controller.dispose();
		controller.removeEventListener(listener);
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#SCSimulatorController(org.mda4e.simulation.core.ISimulationEngine, java.lang.String)}
	 * .
	 */
	@Test
	public void testSCSimulatorController() {

		// --- Exceptional case ---

		// Engine is "null"
		try {
			controller =
					new SCSimulatorController(
						null,
						getDefaultParameterset(new File(statechartFile)));
			fail("The engine instance is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {
		}

		// Statechart file is "null"
		try {
			controller = new SCSimulatorController(getEngine(), null);
			fail("The statechart file is \"null\", but no exception is occurred!");
		} catch (ArgumentIsNullException e) {
		}
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#init()}
	 * .
	 */
	@Test
	public void testInit() throws StatechartNotValid, ParserException,
			UnableToParseStatechart, ArgumentIsNullException, SupportException,
			ObjectDisposedException {

		// --- Normal case ---

		// Two times
		controller.init();
		controller.init();

		// Tested by other test classes, too

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		try {
			controller.init();
			fail("The controller is disposed, but the init() didn't occur an exception!");
		} catch (ObjectDisposedException e) {
		}
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#run()}
	 * .
	 */
	@Test
	public void testRun() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		controller.run();
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#isSimulationMode()}
	 * .
	 */
	@Test
	public void testIsSimulationMode() {

		// --- Normal case ---

		assertTrue("The default simulation mode is wrong!", controller
			.isSimulationMode());
		assertFalse("The default single step mode is wrong!", controller
			.isSingleStepMode());

		controller.setSingleStepMode();

		assertFalse(
			"The simulation mode is wrong after it was changed!",
			controller.isSimulationMode());
		assertTrue(
			"The single step mode is wrong after it was changed!",
			controller.isSingleStepMode());

		controller.setSimulationMode();

		assertTrue(
			"The simulation mode is wrong after it was changed!",
			controller.isSimulationMode());
		assertFalse(
			"The single step mode is wrong after it was changed!",
			controller.isSingleStepMode());

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertTrue(
			"The simulation mode is wrong after it was changed!",
			controller.isSimulationMode());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#isSingleStepMode()}
	 * .
	 */
	@Test
	public void testIsSingleStepMode() {

		// see testIsSimulationMode()
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#pause()}
	 * .
	 */
	@Test
	public void testPause() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		controller.pause();
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#stop()}
	 * .
	 */
	@Test
	public void testStop() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		controller.stop();
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getInstance()}
	 * .
	 */
	@Test
	public void testGetInstance() {

		// --- Normal case ---

		assertEquals("The default instance number is wrong!", 1, controller
			.getInstance());

		assertTrue("The instance number could not be set!", controller
			.setInstance(42));

		assertEquals(
			"The instance number is wrong after it was changed!",
			42,
			controller.getInstance());

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertEquals(
			"The instance number is not -1 after the controller was disposed!",
			-1,
			controller.getInstance());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#setInstance(int)}
	 * .
	 */
	@Test
	public void testSetInstance() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)
		// see testGetInstance()

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertFalse(
			"The instance number could be set, but the controller is disposed!",
			controller.setInstance(42));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#setSimulationMode()}
	 * .
	 */
	@Test
	public void testSetSimulationMode() {

		// --- Normal case ---

		// see testIsSimulationMode()

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		controller.setSimulationMode();
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#setSingleStepMode()}
	 * .
	 */
	@Test
	public void testSetSingleStepMode() {

		// --- Normal case ---

		// see testIsSimulationMode()

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		controller.setSingleStepMode();
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getActiveStates()}
	 * .
	 */
	@Test
	public void testGetActiveStates() throws StatechartNotValid,
			ParserException, UnableToParseStatechart, ArgumentIsNullException,
			SupportException, ObjectDisposedException {

		// --- Normal case ---

		controller.init();
		assertEquals(
			"The simulator was never started, but the number of active states is not zero!",
			0,
			controller.getActiveStates().size());
		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertEquals(
			"The controller is disposed, but getActiveStates() returns more than 0 active states!",
			0,
			controller.getActiveStates().size());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#isInitialized()}
	 * .
	 */
	@Test
	public void testIsInitialized() throws StatechartNotValid, ParserException,
			UnableToParseStatechart, ArgumentIsNullException, SupportException,
			ObjectDisposedException {

		// --- Normal case ---

		assertFalse(
			"The controller was never initialized, but the result \"true\"!",
			controller.isInitialized());

		controller.init();

		assertTrue(
			"The controller was initialized, but the result \"false\"!",
			controller.isInitialized());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#isStopped()}
	 * .
	 */
	@Test
	public void testIsStopped() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#isFinished()}
	 * .
	 */
	@Test
	public void testIsFinished() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#isPaused()}
	 * .
	 */
	@Test
	public void testIsPaused() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#setItem(java.lang.String, java.lang.Double)}
	 * .
	 */
	@Test
	public void testSetItem() throws ArgumentIsNullException {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertFalse(
			"The controller is disposed, but a variable could be updated!",
			controller.setItem("c", 1.0));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getVariable(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetVariable() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertNull(
			"The controller is disposed, but a variable value could be read!",
			controller.getVariable("c"));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getEvent(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetEvent() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertNull(
			"The controller is disposed, but a event state could be read!",
			controller.getEvent("TestEvent"));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getVariableList()}
	 * .
	 */
	@Test
	public void testGetVariableList() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertEquals(
			"The controller is disposed, but a variable list is not empty!",
			0,
			controller.getVariableList().size());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getInputList()}
	 * .
	 */
	@Test
	public void testGetInputList() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertEquals(
			"The controller is disposed, but a input list is not empty!",
			0,
			controller.getInputList().size());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getOutputList()}
	 * .
	 */
	@Test
	public void testGetOutputList() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertEquals(
			"The controller is disposed, but a output list is not empty!",
			0,
			controller.getOutputList().size());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getEventList()}
	 * .
	 */
	@Test
	public void testGetEventList() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertEquals(
			"The controller is disposed, but a event list is not empty!",
			0,
			controller.getEventList().size());
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#setEvent(java.lang.String, boolean)}
	 * .
	 */
	@Test
	public void testSetEvent() throws ArgumentIsNullException {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertFalse(
			"The controller is disposed, but a event state could be changed!",
			controller.setEvent("TestEvent", true));
	}

	/**
	 * Test method for
	 * {@link com.yakindu.simulation.engine.statechart.engine.SCSimulatorController#getStatechart()}
	 * .
	 */
	@Test
	public void testGetStatechart() {

		// --- Normal case ---

		// tested by other test classes (see Test_StatechartSimulator.java)

		// --- Exceptional case ---

		// Controller is disposed
		controller.dispose();
		assertNull(
			"The controller is disposed, but a statechart instance could be read!",
			controller.getStatechart());

	}

}

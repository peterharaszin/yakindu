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
package com.yakindu.statechart.codegenerator.java.test;

import statestest.StatesTestStatechart;

import com.yakindu.statechart.Region;
import com.yakindu.statechart.State;

public class StatesTest extends AbstractStatechartTest {

	protected StatesTestStatechart statechart = null;
	protected Region region0 = null;
	protected State simpleState1 = null;
	protected State simpleState2 = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// initialize shortcuts to states and regions
		statechart = StatesTestStatechart.createInstance();

		region0 = getNestedRegionById(statechart,
				"STATECHART_StatesTest_REGION_0");

		simpleState1 = getStateById(region0,
				"STATECHART_StatesTest_REGION_0_STATE_SimpleState1");

		simpleState2 = getStateById(region0,
				"STATECHART_StatesTest_REGION_0_STATE_SimpleState2");

		assertNotNull(statechart);
		assertNotNull(region0);
		assertNotNull(simpleState1);
		assertNotNull(simpleState2);
	}

	public void testActionExecution() throws Exception {
		// enter statechart into simple state 1
		statechart.enter();
		State region0CurrentState = (State) getFieldValue(region0,
				"currentState");
		assertTrue(region0CurrentState == simpleState1);
		assertFalse(statechart.getEntryExecuted());
		assertFalse(statechart.getDoExecuted());
		assertFalse(statechart.getExitExecuted());

		// enter simple state 2;
		statechart.setEvent(StatesTestStatechart.EVENT1);
		statechart.runCycle();
		assertTrue(statechart.getEntryExecuted());
		assertFalse(statechart.getDoExecuted());
		assertFalse(statechart.getExitExecuted());

		// stay in simple state 2
		statechart.runCycle();
		assertTrue(statechart.getEntryExecuted());
		assertTrue(statechart.getDoExecuted());
		assertFalse(statechart.getExitExecuted());

		// exit simple state 2
		statechart.setEvent(StatesTestStatechart.EVENT2);
		statechart.runCycle();
		assertTrue(statechart.getEntryExecuted());
		assertTrue(statechart.getDoExecuted());
		assertTrue(statechart.getExitExecuted());
	}
}

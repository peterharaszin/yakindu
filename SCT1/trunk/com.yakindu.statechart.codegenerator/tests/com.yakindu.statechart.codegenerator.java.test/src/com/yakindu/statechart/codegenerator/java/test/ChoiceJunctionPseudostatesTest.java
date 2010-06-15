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

import choicejunctionpseudostatestest.ChoiceJunctionPseudostatesTestStatechart;

import com.yakindu.statechart.Region;
import com.yakindu.statechart.State;

public class ChoiceJunctionPseudostatesTest extends
		AbstractStatechartTest {

	protected ChoiceJunctionPseudostatesTestStatechart statechart;
	protected Region region0;
	protected State simpleState1;
	protected State simpleState2;
	protected State simpleState3;

	public ChoiceJunctionPseudostatesTest() {
		super();
	}

	public ChoiceJunctionPseudostatesTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		// initialize shortcuts to states and regions
		statechart = ChoiceJunctionPseudostatesTestStatechart.createInstance();
		
		region0 = getNestedRegionById(statechart,
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0");
		
		simpleState1 = getStateById(region0,
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState1");
		
		simpleState2 = getStateById(region0,
		"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState2");
		
		simpleState3 = getStateById(region0,
		"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState3");
		
			assertNotNull(statechart);
		assertNotNull(region0);
		assertNotNull(simpleState1);
		assertNotNull(simpleState2);
		assertNotNull(simpleState3);
	}

	public void testChoiceAndJunction() throws Exception {
		// enter and move to SimpleState1 
		statechart.enter();
		State region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == simpleState1);
		
		// take the choice (decision should be set to true, so we prolong to simple state 2
		statechart.setEvent(ChoiceJunctionPseudostatesTestStatechart.EVENT1);
		statechart.runCycle();
		region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == simpleState2);
		
		// go back to simple state 1 via junction, toggle decision value
		statechart.setEvent(ChoiceJunctionPseudostatesTestStatechart.EVENT2);
		statechart.runCycle();
		region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == simpleState1);
		
		// take the choice (decision should be set to false, so we prolong to simple state 2
		statechart.setEvent(ChoiceJunctionPseudostatesTestStatechart.EVENT1);
		statechart.runCycle();
		region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == simpleState3);		
		
		// go back to simple state 1 via junction, toggle decision value
		statechart.setEvent(ChoiceJunctionPseudostatesTestStatechart.EVENT2);
		statechart.runCycle();
		region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == simpleState1);
	}

}
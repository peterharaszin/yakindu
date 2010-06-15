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

import historypseudostatestest.HistoryPseudostatesTestStatechart;

import com.yakindu.statechart.CompoundState;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.State;

public class HistoryPseudostatesTest extends
		AbstractStatechartTest {

	protected HistoryPseudostatesTestStatechart statechart;
	protected Region region0;
	protected State simpleState1;
	protected CompoundState compoundState1;
	protected Region region1;
	protected State simpleState2;
	protected CompoundState compoundState2;
	protected Region region2;
	protected State simpleState3;
	protected State simpleState4;

	public HistoryPseudostatesTest() {
		super();
	}

	public HistoryPseudostatesTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		// initialize shortcuts to states and regions
		statechart = HistoryPseudostatesTestStatechart.createInstance();
		
		region0 = getNestedRegionById(statechart,
				"STATECHART_HistoryPseudostatesTest_REGION_0");
		
		simpleState1 = getStateById(region0,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1");
		
		compoundState1 = (CompoundState) getStateById(region0,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1");
	
		region1 = getNestedRegionById(compoundState1,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0");
		
		simpleState2 = getStateById(region1,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2");
		
		compoundState2 = (CompoundState) getStateById(
				region1,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2");
	
		region2 = getNestedRegionById(
				compoundState2,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0");
	
		simpleState3 = getStateById(
				region2,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState3");
	
		simpleState4 = getStateById(
				region2,
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState4");
	
		assertNotNull(statechart);
		assertNotNull(region0);
		assertNotNull(compoundState1);
		assertNotNull(simpleState1);
		assertNotNull(region1);
		assertNotNull(simpleState2);
		assertNotNull(compoundState2);
		assertNotNull(region2);
		assertNotNull(simpleState3);
		assertNotNull(simpleState4);
	}

	public void testDeepHistory() throws Exception {
	
		// enter and move to SimpleState4 of CompositeState2 within
		// CompositeState1
		statechart.enter();
		statechart.setEvent(HistoryPseudostatesTestStatechart.EVENT1);
		statechart.runCycle();
		statechart.setEvent(HistoryPseudostatesTestStatechart.EVENT2);
		statechart.runCycle();
	
		// confirm that the statechart resides within SimpleState4 of
		// CompoundState2 within CompoundState1
		State region0CurrentState = (State) getFieldValue(region0,
				"currentState");
		State region1CurrentState = (State) getFieldValue(region1,
				"currentState");
		State region2CurrentState = (State) getFieldValue(region2,
				"currentState");
	
		assertNotNull(region0CurrentState);
		assertNotNull(region1CurrentState);
		assertNotNull(region2CurrentState);
		assertTrue(region0CurrentState == compoundState1);
		assertTrue(region1CurrentState == compoundState2);
		assertTrue(region2CurrentState == simpleState4);
	
		// leave CompoundState1 to SimpleState1 on deephistory1 event
		statechart
				.setEvent(HistoryPseudostatesTestStatechart.COMPOUNDSTATE1TOSIMPLESTATE1);
		statechart.runCycle();
		// check that current state of Region0 is no longer CompoundState1, but
		// SimpleState1
	
		region0CurrentState = (State) getFieldValue(region0, "currentState");
		assertTrue(region0CurrentState == simpleState1);
	
		// now move into the deep history state via deephistory2 event
		statechart
				.setEvent(HistoryPseudostatesTestStatechart.SIMPLESTATE1TOCOMPOUNDSTATE1DEEPHISTORY);
		statechart.runCycle();
		// check that current state of Region0 is now CompoundState1 again, and
		// that the
		// statechart resides in SimpleState4 within CompoundState2
		region0CurrentState = (State) getFieldValue(region0, "currentState");
		assertTrue(region0CurrentState == compoundState1);
		region1CurrentState = (State) getFieldValue(region1, "currentState");
		assertTrue(region1CurrentState == compoundState2);
		region2CurrentState = (State) getFieldValue(region2, "currentState");
		assertTrue(region2CurrentState == simpleState4);
	}

	public void testShallowHistory() throws Exception {
	
		// setup states (move to simple state 4)
		statechart.enter();
		statechart.setEvent(HistoryPseudostatesTestStatechart.EVENT1);
		statechart.runCycle();
		statechart.setEvent(HistoryPseudostatesTestStatechart.EVENT2);
		statechart.runCycle();
	
		// confirm that the statechart resides within SimpleState4 of
		// CompoundState2 within CompoundState1
		State region0CurrentState = (State) getFieldValue(region0,
				"currentState");
		State region1CurrentState = (State) getFieldValue(region1,
				"currentState");
		State region2CurrentState = (State) getFieldValue(region2,
				"currentState");
	
		assertNotNull(region0CurrentState);
		assertNotNull(region1CurrentState);
		assertNotNull(region2CurrentState);
		assertTrue(region0CurrentState == compoundState1);
		assertTrue(region1CurrentState == compoundState2);
		assertTrue(region2CurrentState == simpleState4);
			
		// leave CompoundState1 to SimpleState1 
		statechart.setEvent(HistoryPseudostatesTestStatechart.COMPOUNDSTATE1TOSIMPLESTATE1);
		statechart.runCycle();
		// check that current state of Region0 is no longer CompoundState1, but SimpleState1
		State simpleState1 = getStateById(region0, "STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1");
		region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == simpleState1);
		
		// now move into the shallow history state of composite state 1
		statechart.setEvent(HistoryPseudostatesTestStatechart.SIMPLESTATE1TOCOMPOUNDSTATE1SHALLOWHISTORY);
		statechart.runCycle();
		// check that current state of Region0 is now CompoundState1 again, and that the 
		// statechart resides in SimpleState3 within CompoundState2
		region0CurrentState = (State) getFieldValue(region0,
		"currentState");
		assertTrue(region0CurrentState == compoundState1);		
		region1CurrentState = (State) getFieldValue(region1,
		"currentState");
		assertTrue(region1CurrentState == compoundState2);
		region2CurrentState = (State) getFieldValue(region2, "currentState");
		assertTrue(region2CurrentState == simpleState3);
	}

}
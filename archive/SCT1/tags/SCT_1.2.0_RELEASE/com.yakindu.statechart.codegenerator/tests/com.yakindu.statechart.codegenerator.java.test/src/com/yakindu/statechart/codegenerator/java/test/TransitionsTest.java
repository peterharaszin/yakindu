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

import transitionstest.TransitionsTestStatechart;

import com.yakindu.statechart.CompoundState;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.State;

public class TransitionsTest extends AbstractStatechartTest {

	protected TransitionsTestStatechart statechart = null;
	protected Region region0 = null;
	protected CompoundState compositeState1 = null;
	protected CompoundState compositeState2 = null;
	protected Region region1 = null;
	protected Region region2 = null;
	protected State simpleState1 = null;
	protected State simpleState2 = null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// initialize shortcuts to states and regions
		statechart = TransitionsTestStatechart.createInstance();

		region0 = getNestedRegionById(statechart,
				"STATECHART_TransitionsTest_REGION_0");

		compositeState1 = (CompoundState) getStateById(region0,
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1");

		compositeState2 = (CompoundState) getStateById(region0,
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2");

		region1 = getNestedRegionById(compositeState1,
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0");

		region2 = getNestedRegionById(compositeState2,
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0");

		simpleState1 = getStateById(
				region1,
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_STATE_SimpleState1");

		simpleState2 = getStateById(
				region2,
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_STATE_SimpleState2");

		assertNotNull(statechart);
		assertNotNull(region0);
		assertNotNull(compositeState1);
		assertNotNull(compositeState2);
		assertNotNull(region1);
		assertNotNull(region2);
		assertNotNull(simpleState1);
		assertNotNull(simpleState2);
	}

	public void testTransitionLeavingAndEnteredMultipleCompoundStates()
			throws Exception {
		// enter statechart
		statechart.enter();
		State region0CurrentState = (State) getFieldValue(region0,
				"currentState");
		assertTrue(region0CurrentState == compositeState1);
		State region1CurrentState = (State) getFieldValue(region1,
				"currentState");
		assertTrue(region1CurrentState == simpleState1);

		assertTrue(statechart.getComposite1Entered());
		assertFalse(statechart.getComposite1Exited());
		assertTrue(statechart.getSimple1Entered());
		assertFalse(statechart.getSimple1Exited());

		assertFalse(statechart.getComposite2Entered());
		assertFalse(statechart.getComposite2Exited());
		assertFalse(statechart.getSimple2Entered());
		assertFalse(statechart.getSimple2Exited());

		// take transition from simple state 1 to simple state 2
		statechart.setEvent(statechart.EVENT1);
		statechart.runCycle();
		region0CurrentState = (State) getFieldValue(region0,
				"currentState");
		assertTrue(region0CurrentState == compositeState2);
		State region2CurrentState = (State) getFieldValue(region2,
				"currentState");
		assertTrue(region2CurrentState == simpleState2);
		assertTrue(statechart.getComposite1Entered());
		assertTrue(statechart.getComposite1Exited());
		assertTrue(statechart.getSimple1Entered());
		assertTrue(statechart.getSimple1Exited());

		assertTrue(statechart.getComposite2Entered());
		assertFalse(statechart.getComposite2Exited());
		assertTrue(statechart.getSimple2Entered());
		assertFalse(statechart.getSimple2Exited());
	}
}

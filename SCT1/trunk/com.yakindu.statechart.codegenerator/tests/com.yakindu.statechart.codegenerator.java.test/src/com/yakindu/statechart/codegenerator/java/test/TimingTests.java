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

import java.util.ArrayList;
import java.util.List;

import timingtest.TimingTestStatechart;

import com.yakindu.statechart.Region;
import com.yakindu.statechart.State;
import com.yakindu.statechart.TimeEvent;
import com.yakindu.statechart.TimingService;

public class TimingTests extends AbstractStatechartTest {

	protected TimingTestStatechart statechart;
	protected TimingServiceTestStub timingService = null;
	protected Region region0;
	protected State simpleState1;
	protected State simpleState2;
	protected State finalState;
	protected TimeEvent timeEvent1 = null;
	protected TimeEvent timeEvent2 = null;

	private class TimingServiceTestStub implements TimingService {

		List<TimeEvent> requestedTimeEvents = new ArrayList<TimeEvent>();
		List<TimeEvent> cancelledTimeEvents = new ArrayList<TimeEvent>();
		
		public void cancelTimeEvent(TimeEvent timeEvent) {
			cancelledTimeEvents.add(timeEvent);
		}

		public void requestTimeEvent(TimeEvent timeEvent) {
			requestedTimeEvents.add(timeEvent);
		}

		protected List<TimeEvent> getRequestedTimeEvents() {
			return requestedTimeEvents;
		}

		protected List<TimeEvent> getCancelledTimeEvents() {
			return cancelledTimeEvents;
		}
		
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		timingService = new TimingServiceTestStub();
		
		// initialize shortcuts to states and regions
		statechart = TimingTestStatechart.createInstance(timingService);

		region0 = getNestedRegionById(statechart,
				"STATECHART_TimingTest_REGION_0");

		simpleState1 = getStateById(region0,
				"STATECHART_TimingTest_REGION_0_STATE_SimpleState1");

		simpleState2 = getStateById(region0,
				"STATECHART_TimingTest_REGION_0_STATE_SimpleState2");
		
		finalState = getStateById(region0,
		"STATECHART_TimingTest_REGION_0_STATE_FinalState");
		

		timeEvent1 = (TimeEvent)getFieldValue(statechart, "TIMER5");
		timeEvent2 = (TimeEvent)getFieldValue(statechart, "TIMER6");

		assertNotNull(statechart);
		assertNotNull(region0);
		assertNotNull(simpleState1);
		assertNotNull(simpleState2);
		assertNotNull(finalState);
		assertNotNull(timeEvent1);
		assertEquals(timeEvent1.getDuration(), 1000);
		assertNotNull(timeEvent2);
	}

	public void testTimeTriggeredTransitions() throws Exception {
		// enter into simple state 1
		assertTrue(timingService.getRequestedTimeEvents().isEmpty());
		assertTrue(timingService.getCancelledTimeEvents().isEmpty());
		
		statechart.enter();
		statechart.runCycle();
				
		assertTrue(timingService.getRequestedTimeEvents().contains(timeEvent1));
		assertTrue(timingService.getRequestedTimeEvents().size() == 1);
		assertTrue(timingService.getCancelledTimeEvents().isEmpty());
		
		timingService.getRequestedTimeEvents().clear();
		statechart.setEvent(timeEvent1);
		statechart.runCycle();
		
		assertTrue(timingService.getRequestedTimeEvents().contains(timeEvent2));
		assertTrue(timingService.getRequestedTimeEvents().size() == 1);
		// for the sake of simplicity, all time events are cancelled when leaving
		// the state, including the one that triggered the transition
		assertTrue(timingService.getCancelledTimeEvents().contains(timeEvent1));
		
		timingService.getCancelledTimeEvents().clear();
		timingService.getRequestedTimeEvents().clear();
		statechart.setEvent(statechart.ABORT);
		statechart.runCycle();
		assertTrue(timingService.getCancelledTimeEvents().contains(timeEvent2));
		assertTrue(timingService.getCancelledTimeEvents().size() == 1);
		assertTrue(timingService.getRequestedTimeEvents().isEmpty());
	}
}

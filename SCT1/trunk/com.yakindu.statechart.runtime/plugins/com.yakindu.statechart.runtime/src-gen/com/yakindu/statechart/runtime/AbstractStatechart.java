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
package com.yakindu.statechart.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractStatechart {

	protected Set<Event> raisedEvents = new HashSet<Event>();

	// ------------------------------------------------------------------------
	// (EXTERNAL) EVENT-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	public void setEvent(Event event) {

		synchronized (raisedEvents) {
			raisedEvents.add(event);
		}

	}

	// ------------------------------------------------------------------------
	// (INTERNAL) TIMING-SERVICE-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	protected void requestTimeEvent(TimeEvent event) {
		timingService.requestTimeEvent(event);
	}

	protected void cancelTimeEvent(TimeEvent event) {
		timingService.cancelTimeEvent(event);
	}

	// ------------------------------------------------------------------------
	// (EXTERNAL) EXECUTION-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	public void enter() {

		// enter all nested regions (in the order of their priority)
		for (Region region : regions) {
			region.enter();
		}

	}

	public void runCycle() {

		Set<Event> currentEvents = new HashSet<Event>();
		synchronized (raisedEvents) {
			currentEvents.addAll(raisedEvents);
			raisedEvents.clear();
		}
		reactOn(currentEvents);

	}

	public void leave() {

		// leave all nested regions (in the reverse order of their priority)
		for (ListIterator<Region> iterator = regions.listIterator(regions
				.size()); iterator.hasPrevious();) {
			iterator.previous().leave();
		}

	}

	// ------------------------------------------------------------------------
	// INITIALIZATION CODE
	// ------------------------------------------------------------------------

	// the unique id of this statechart instance
	private String id;

	// the nested regions of this state, sorted by priority
	private List<Region> regions = new ArrayList<Region>();

	private List<Transition> transitions = new ArrayList<Transition>();

	// used to request time events from environment
	protected TimingService timingService = null;

	protected AbstractStatechart(String id) {
		this.id = id;
		this.timingService = new DefaultTimingService(this);
	}

	protected AbstractStatechart(String id, TimingService timingService) {
		this.id = id;
		this.timingService = timingService;
	}

	public List<Region> getRegions() {
		return regions;
	}

	protected List<Transition> getTransitions() {

		return transitions;

	}

	// ------------------------------------------------------------------------
	// INTERNAL STATECHART BEHAVIOUR
	// ------------------------------------------------------------------------

	private void reactOn(Set<Event> events) {

		// pass events to our nested regions (in the order of their priority)
		for (Region region : regions) {
			region.reactOn(events);
		}

	}

}

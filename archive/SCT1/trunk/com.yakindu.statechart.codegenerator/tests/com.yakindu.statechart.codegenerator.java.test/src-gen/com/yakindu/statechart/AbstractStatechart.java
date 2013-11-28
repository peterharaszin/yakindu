package com.yakindu.statechart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Collections;
import java.util.Comparator;

public abstract class AbstractStatechart {

	// marker to indicate that initialization is done
	private boolean initialized = false;

	// marker to keep track if statechart was entered or not
	private boolean entered = false;

	protected Set<Event> raisedEvents = new HashSet<Event>();

	// ------------------------------------------------------------------------
	// (EXTERNAL) EVENT-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	public void setEvent(Event event) {

		assertInitialized();
		assertEntered();

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

		assertInitialized();
		assertNotEntered();

		// enter all nested regions (in the order of their priority)
		for (Region region : regions) {
			region.enter();
		}

		entered = true;

	}

	public void runCycle() {

		assertInitialized();
		assertEntered();

		Set<Event> currentEvents = new HashSet<Event>();
		synchronized (raisedEvents) {
			currentEvents.addAll(raisedEvents);
			raisedEvents.clear();
		}
		reactOn(currentEvents);

	}

	public void leave() {

		assertInitialized();
		assertEntered();

		// leave all nested regions (in the reverse order of their priority)
		for (ListIterator<Region> iterator = regions.listIterator(regions
				.size()); iterator.hasPrevious();) {
			iterator.previous().leave();
		}

		entered = false;

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

	protected List<Region> getRegions() {

		// after initialization has been finalized, modification 
		// of the nested regions list is no longer allowed	    
		if (!initialized) {
			return regions;
		}
		return Collections.unmodifiableList(regions);

	}

	protected List<Transition> getTransitions() {

		// after initialization has been finalized, modification 
		// of the transitions list is no longer allowed	    
		if (!initialized) {
			return transitions;
		}
		return Collections.unmodifiableList(transitions);

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

	protected void finalizeInitialization() {
		assertNotInitialized();

		// sort regions by priority
		assertRegionsSortedByPriority();

		for (Region region : regions) {
			region.finalizeInitialization();
		}

		for (Transition transition : transitions) {
			transition.finalizeInitialization();
		}

		initialized = true;
		assertInitialized();
	}

	private void assertRegionsSortedByPriority() {
		// check regions are sorted by priority
		List<Region> regionsCopy = new ArrayList<Region>();
		regionsCopy.addAll(regions);
		Collections.sort(regionsCopy, new Comparator<Region>() {
			public int compare(Region o1, Region o2) {
				return o1.getPriority() - o2.getPriority();
			}
		});
		if (!regionsCopy.equals(regions)) {
			throw new IllegalArgumentException("Regions not sorted by priority");
		}
	}

	private void assertInitialized() {
		if (!initialized) {
			throw new IllegalStateException("Statechart is not yet initialized");
		}
	}

	private void assertNotInitialized() {
		if (initialized) {
			throw new IllegalStateException(
					"Statechart was already initialized");
		}
	}

	private void assertEntered() {
		if (!entered) {
			throw new IllegalStateException("Statechart is not yet entered");
		}
	}

	private void assertNotEntered() {
		if (entered) {
			throw new IllegalStateException("Statechart was already entered");
		}
	}

}

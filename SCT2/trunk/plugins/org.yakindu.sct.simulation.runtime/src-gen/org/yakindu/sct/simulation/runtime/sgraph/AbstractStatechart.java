package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public abstract class AbstractStatechart {

	protected Set<RTEvent> raisedEvents = new HashSet<RTEvent>();

	// ------------------------------------------------------------------------
	// (EXTERNAL) EVENT-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	public void setEvent(RTEvent event) {

		synchronized (raisedEvents) {
			raisedEvents.add(event);
		}

	}

	// ------------------------------------------------------------------------
	// (INTERNAL) TIMING-SERVICE-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	protected void requestTimeEvent(RTTimeEvent event) {
		timingService.requestTimeEvent(event);
	}

	protected void cancelTimeEvent(RTTimeEvent event) {
		timingService.cancelTimeEvent(event);
	}

	// ------------------------------------------------------------------------
	// (EXTERNAL) EXECUTION-INTERFACE IMPLEMENTATION
	// ------------------------------------------------------------------------

	public void enter() {

		// enter all nested regions (in the order of their priority)
		for (RTRegion region : regions) {
			region.enter();
		}

	}

	public void runCycle() {

		Set<RTEvent> currentEvents = new HashSet<RTEvent>();
		synchronized (raisedEvents) {
			currentEvents.addAll(raisedEvents);
			raisedEvents.clear();
		}
		reactOn(currentEvents);

	}

	public void leave() {

		// leave all nested regions (in the reverse order of their priority)
		for (ListIterator<RTRegion> iterator = regions.listIterator(regions
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

	private List<RTRegion> regions = new ArrayList<RTRegion>();

	private List<RTTransition> transitions = new ArrayList<RTTransition>();

	// used to request time events from environment
	protected RTTimingService timingService = null;

	protected AbstractStatechart(String id) {
		this.id = id;
		this.timingService = new RTDefaultTimingService(this);
	}

	protected AbstractStatechart(String id, RTTimingService timingService) {
		this.id = id;
		this.timingService = timingService;
	}

	public List<RTRegion> getRegions() {
		return regions;
	}

	protected List<RTTransition> getTransitions() {

		return transitions;

	}

	// ------------------------------------------------------------------------
	// INTERNAL STATECHART BEHAVIOUR
	// ------------------------------------------------------------------------

	private void reactOn(Set<RTEvent> events) {

		// pass events to our nested regions (in the order of their priority)
		for (RTRegion region : regions) {
			region.reactOn(events);
		}
	}

	public String getId() {
		return id;
	}
	
	

}

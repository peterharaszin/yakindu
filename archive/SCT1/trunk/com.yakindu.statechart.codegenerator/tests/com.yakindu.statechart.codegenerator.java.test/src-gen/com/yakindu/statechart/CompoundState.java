package com.yakindu.statechart;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import java.util.Collections;
import java.util.Comparator;

/**
 * Representation of a state that contains nested regions with sub-states.
 * Composite states may have an arbitrary number of nested regions, which are
 * virtually executed in parallel (in fact, there execution is sequentialized
 * based on their priorities). As a composite state always is "in" its
 * sub-states, it may itself not contain a do action.
 */
public class CompoundState extends State {

	// the nested regions of this state, sorted by priority
	private List<Region> regions = new ArrayList<Region>();

	public CompoundState(String id, String name, Region container,
			Action entryAction, Action exitAction) {
		super(id, name, container, entryAction, exitAction);
	}

	protected List<Region> getRegions() {

		// if initialization is finalized, modifications to the nested regions
		// list are no longer allowed
		if (!initialized) {
			return regions;
		} else {
			return Collections.unmodifiableList(regions);
		}

	}

	protected void enter() {

		assertInitialized();
		assertNotEntered();

		shallowEnter();
		// now enter all nested regions (in the order of their priority)
		for (Region region : regions) {
			region.enter();
		}

		entered = true;

	}

	protected void shallowEnter() {

		assertInitialized();
		assertNotEntered();

		// let the super implementation request time events and execute the entry action of this state
		super.enter();

		entered = true;

	}

	protected void reenter(HistoryMode history) {

		shallowEnter();
		// let the nested regions re-enter their former states
		for (Region region : regions) {
			// if we have are in DEEP history mode, notify our nested regions 
			// to reenter into their former states as well
			if (history == HistoryMode.DEEP) {
				region.reenter(history);
			} else {
				region.enter();
			}
		}

	}

	protected void reactLocallyOn(Set<Event> events) {
		// as a compound state does not locally react on events (it may not
		// specify a do action), forward to the nested regions (in the order of
		// their priority)
		for (Region region : regions) {
			region.reactOn(events);
		}
	}

	protected void leave() {

		assertInitialized();
		assertEntered();

		// leave all nested regions (in the reverse order of their priority)
		for (ListIterator<Region> iterator = regions.listIterator(regions
				.size()); iterator.hasPrevious();) {
			iterator.previous().leave();
		}
		shallowLeave();

		entered = false;

	}

	protected void shallowLeave() {

		assertInitialized();
		assertEntered();

		// let the super implementation execute the exit action of this state
		super.leave();

		entered = false;

	}

	protected void finalizeInitialization() {

		// check regions are sorted by priority
		assertRegionsSortedByPriority();

		for (Region region : regions) {
			region.finalizeInitialization();
		}
		super.finalizeInitialization();
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

}

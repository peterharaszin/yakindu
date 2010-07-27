package com.yakindu.statechart;

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.util.Comparator;

/**
 * Representation of a node (which is the abstract super concept of State and
 * Pseudostate). A node may have incoming and outgoing transitions. As the
 * statechart may only reside "in" states, pseudostates will normally directly
 * trigger an outgoing transition when being entered.
 */
public abstract class Node {

	// marker to indicate that initialization is done
	protected boolean initialized = false;

	private String id;
	protected Region owningRegion;

	protected List<Transition> incomingTransitions = new ArrayList<Transition>();
	protected List<Transition> outgoingTransitions = new ArrayList<Transition>();

	public Node(String id, Region owner) {
		this.id = id;
		this.owningRegion = owner;
		this.owningRegion.getNodes().add(this);
	}

	public String getId() {
		return id;
	}

	protected Region getOwningRegion() {
		return owningRegion;
	}

	protected List<Transition> getIncomingTransitions() {

		if (!initialized) {
			return incomingTransitions;
		}
		return Collections.unmodifiableList(incomingTransitions);

	}

	protected List<Transition> getOutgoingTransitions() {

		if (!initialized) {
			return outgoingTransitions;
		}
		return Collections.unmodifiableList(outgoingTransitions);

	}

	protected Transition getEnabledOutgoingTransitionOfHighestPriority() {

		for (Transition transition : outgoingTransitions) {
			if (transition.isEnabled()) {
				return transition;
			}
		}
		return null;

	}

	protected abstract void enter();

	protected abstract void leave();

	protected void finalizeInitialization() {
		assertNotInitialized();

		// check outgoing transitions are sorted by priority
		assertOutgoingTransitionsSortedByPriority();

		initialized = true;
		assertInitialized();
	}

	private void assertOutgoingTransitionsSortedByPriority() {
		// check regions are sorted by priority
		List<Transition> outgoingTransitionsCopy = new ArrayList<Transition>();
		outgoingTransitionsCopy.addAll(outgoingTransitions);
		Collections.sort(outgoingTransitionsCopy, new Comparator<Transition>() {
			public int compare(Transition o1, Transition o2) {
				return o1.getPriority() - o2.getPriority();
			}
		});
		if (!outgoingTransitionsCopy.equals(outgoingTransitions)) {
			throw new IllegalArgumentException(
					"Outgoing transitions not sorted by priority");
		}
	}

	protected void assertInitialized() {
		if (!initialized) {
			throw new IllegalStateException("Node not yet initialized");
		}
	}

	protected void assertNotInitialized() {
		if (initialized) {
			throw new IllegalStateException("Node not yet initialized");
		}
	}

}

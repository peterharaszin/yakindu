package com.yakindu.statechart;

import java.util.HashSet;
import java.util.Set;

import java.util.Collections;

public class Region {

	// marker to indicate that initialization is done
	private boolean initialized = false;

	// marker to keep track if the region was entered or not
	private boolean entered = false;

	private String id;
	private int priority;
	private AbstractStatechart owningStatechart;
	private CompoundState owningState;

	private Set<Node> nodes = new HashSet<Node>();

	protected State currentState;

	public Region(String id, int priority, AbstractStatechart owner) {
		this.id = id;
		this.priority = priority;
		this.owningStatechart = owner;
		this.owningStatechart.getRegions().add(this);
	}

	public Region(String id, int priority, CompoundState owner) {
		this.id = id;
		this.priority = priority;
		this.owningState = owner;
		this.owningState.getRegions().add(this);
	}

	/** Returns the id of the region.
	 */
	public String getId() {
		return id;
	}

	/** Returns the priority of the region. Regions with lower priority value will be evaluated 
	 * before regions with higher priority value.
	 */
	public int getPriority() {
		return priority;
	}

	public AbstractStatechart getStatechart() {
		if (owningStatechart != null) {
			return owningStatechart;
		} else {
			return owningState.getStatechart();
		}
	}

	protected CompoundState getOwningState() {
		return owningState;
	}

	protected AbstractStatechart getOwningStatechart() {
		return owningStatechart;
	}

	protected Set<Node> getNodes() {

		if (!initialized) {
			return nodes;
		}
		return Collections.unmodifiableSet(nodes);

	}

	private Node getInitialNode() {
		for (Node node : nodes) {
			if (node instanceof Pseudostate
					&& ((Pseudostate) node).getKind() == PseudostateKind.INITIAL) {
				return node;
			}
		}
		throw new IllegalStateException("No initial state present");
	}

	protected void setCurrentState(State state) {
		this.currentState = state;
	}

	public State getCurrentState() {
		return currentState;
	}

	protected void enter() {

		assertInitialized();
		assertNotEntered();

		getInitialNode().enter();

		entered = true;

	}

	protected void reenter(HistoryMode history) {

		assertInitialized();
		assertNotEntered();

		currentState.reenter(history);

		entered = true;

	}

	protected void reactOn(Set<Event> events) {

		assertInitialized();
		assertEntered();

		currentState.reactOn(events);

	}

	protected void leave() {

		assertInitialized();
		assertEntered();

		currentState.leave();

		entered = false;

	}

	protected void finalizeInitialization() {
		assertNotInitialized();
		initialized = true;
		for (Node node : nodes) {
			node.finalizeInitialization();
		}
		assertInitialized();
	}

	private void assertInitialized() {
		if (!initialized) {
			throw new IllegalStateException("Region not yet initialized");
		}
	}

	private void assertNotInitialized() {
		if (initialized) {
			throw new IllegalStateException("Region not yet initialized");
		}
	}

	private void assertEntered() {
		if (!entered) {
			throw new IllegalStateException("Region was not entered");
		}
	}

	private void assertNotEntered() {
		if (entered) {
			throw new IllegalStateException("Region was already entered");
		}
	}

}

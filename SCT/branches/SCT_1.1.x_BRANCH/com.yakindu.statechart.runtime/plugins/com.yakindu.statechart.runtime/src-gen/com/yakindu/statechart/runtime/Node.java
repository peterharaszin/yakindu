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
import java.util.List;

/**
 * Representation of a node (which is the abstract super concept of State and
 * Pseudostate). A node may have incoming and outgoing transitions. As the
 * statechart may only reside "in" states, pseudostates will normally directly
 * trigger an outgoing transition when being entered.
 */
public abstract class Node {

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

	public List<Transition> getIncomingTransitions() {
		return incomingTransitions;
	}

	public List<Transition> getOutgoingTransitions() {
		return outgoingTransitions;
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

}

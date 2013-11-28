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
package com.yakindu.statechart;

import java.util.Set;

/**
 * Representation of a simple state without nested regions. A simple state may
 * specify a do action, which is executed when the statechart resides "in" this
 * state.
 */
public class SimpleState extends State {

	private Action doAction;

	public SimpleState(String id, String name, Region owningRegion,
			Action entryAction, Action doAction, Action exitAction) {
		super(id, name, owningRegion, entryAction, exitAction);
		this.doAction = doAction;
	}

	protected void reactLocallyOn(Set<Event> events) {
		if (doAction != null) {
			doAction.execute();
		}
	}

}

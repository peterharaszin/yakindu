/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.runtime.java.test_localactions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.yakindu.sct.runtime.java.Event;

public class Test_LocalActionsEventBasedStatemachine
		extends
			Test_LocalActionsAbstractBaseStatemachine {

	public Test_LocalActionsEventBasedStatemachine() {
		super(new LinkedList<Event>());
	}

	protected Queue<Event> getOccuredEvents() {
		return (Queue<Event>) super.getOccuredEvents();
	}

	public void runCycle() {
		if (eventOccured()) {
			Event event = getOccuredEvents().poll();
			runCycle(Collections.singletonList(event));
		}
	}
}

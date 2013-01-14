/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.trafficlightwaiting;

import java.util.LinkedList;

import org.yakindu.sct.runtime.java.Event;

import org.yakindu.sct.runtime.java.Notification;

public class TrafficLightWaitingEventBasedStatemachine
		extends
			TrafficLightWaitingCycleBasedStatemachine {

	private LinkedList<Event<? extends Enum<?>>> eventQueue;

	private DefaultInterfaceEventBasedImpl defaultInterface;

	public TrafficLightWaitingEventBasedStatemachine() {
		eventQueue = new LinkedList<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceEventBasedImpl(this);
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	protected IDefaultInterfaceImpl getDefaultInterfaceImpl() {
		return defaultInterface;
	}

	public void notify(Notification notification) {
		super.notify(notification);
		runCycle();
	}

	@Override
	protected LinkedList<Event<? extends Enum<?>>> getOccuredEvents() {
		return eventQueue;
	}

	@Override
	protected boolean eventOccured() {
		return !eventQueue.isEmpty();
	}

	@Override
	public void runCycle() {
		if (eventOccured()) {
			Event<? extends Enum<?>> event = getOccuredEvents().poll();
			super.getOccuredEvents().add(event);
			super.runCycle();
		}
	}
}

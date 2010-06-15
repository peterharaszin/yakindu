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

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class DefaultTimingService implements TimingService {

	private final AbstractStatechart statechart;

	public DefaultTimingService(AbstractStatechart statechart) {
		this.statechart = statechart;
	}

	private Set<TimeEvent> canceledRequestedEvents = new HashSet<TimeEvent>();

	public void requestTimeEvent(final TimeEvent timeEvent) {
		canceledRequestedEvents.remove(timeEvent);

		// run a timer (there is an own thread for this);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (canceledRequestedEvents.contains(timeEvent)) {
					canceledRequestedEvents.remove(timeEvent);
				} else {
					statechart.setEvent(timeEvent);
				}
			}

		}, timeEvent.getDuration());
	}

	public void cancelTimeEvent(final TimeEvent timeEvent) {
		canceledRequestedEvents.add(timeEvent);
	}

}

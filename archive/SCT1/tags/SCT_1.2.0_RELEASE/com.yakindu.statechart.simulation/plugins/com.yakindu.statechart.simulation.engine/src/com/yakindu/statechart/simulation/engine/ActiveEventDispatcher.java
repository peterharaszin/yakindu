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
package com.yakindu.statechart.simulation.engine;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;

public class ActiveEventDispatcher extends EventDispatcher implements Runnable {

	protected BlockingQueue<IEvent> eventQueue;
	
	protected boolean terminate;
	
	
	public ActiveEventDispatcher() {
		super();
	}

	public ActiveEventDispatcher(BlockingQueue<IEvent> eventQueue) {
		super();
		this.eventQueue = eventQueue;
	}

	
	public BlockingQueue<IEvent> getEventQueue() {
		return eventQueue;
	}

	public void setEventQueue(BlockingQueue<IEvent> eventQueue) {
		this.eventQueue = eventQueue;
	}

	public void run() {
		terminate = false;
		
		while (!terminate) {
			try {
				IEvent event = eventQueue.poll(100, TimeUnit.MILLISECONDS);
				if (event != null) {
					try {
						fireEvent(event);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void terminate() {
		terminate=true;
	}

}

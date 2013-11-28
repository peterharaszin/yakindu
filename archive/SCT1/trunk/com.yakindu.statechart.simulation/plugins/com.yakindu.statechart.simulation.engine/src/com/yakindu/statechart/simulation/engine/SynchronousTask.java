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

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public abstract class SynchronousTask implements Runnable {
	
	protected boolean completed = false;
	protected Throwable throwable;
	protected SynchronousQueue<Object> synchronizer = new SynchronousQueue<Object>();
	

	public void run() {
		
		try {
			exec();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		} finally {
			completed();
		}
	}
	
	abstract public void exec();

	protected void completed() {
		try {
			synchronizer.put(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public void waitForCompletion(long timeout) {
		try {
			synchronizer.poll(timeout, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

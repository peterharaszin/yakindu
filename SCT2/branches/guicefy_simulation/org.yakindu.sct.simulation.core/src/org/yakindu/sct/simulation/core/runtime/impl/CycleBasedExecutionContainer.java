/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.runtime.impl;

import java.util.Timer;
import java.util.TimerTask;

import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.runtime.IExecutionContainer;
import org.yakindu.sct.simulation.core.runtime.IStatechartInterpreter;

import com.google.inject.Inject;

/**
 * Cycle based implementation of {@link IExecutionContainer}.
 * 
 * runCycle is called on {@link IStatechartInterpreter} periodically, depending on the
 * cyclePeriod value.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CycleBasedExecutionContainer extends AbstractExecutionContainer {

	@Inject
	private Timer timer;

	private long cyclePeriod;

	public CycleBasedExecutionContainer(Statechart statechart, long cyclePeriod) {
		super(statechart);
		this.cyclePeriod = cyclePeriod;
	}

	protected void scheduleCycle() {
		if (!terminated && !suspended) {
			TimerTask virtualTimerTask = new TimerTask() {
				public void run() {
					runCycle();
					scheduleCycle();
				}
			};
			timer.schedule(virtualTimerTask, cyclePeriod);
		}
	}

	public void start() {
		super.start();
		scheduleCycle();
	}

	public void resume() {
		super.resume();
		scheduleCycle();
	}

	public void terminate() {
		super.terminate();
		timer.cancel();
	}

}

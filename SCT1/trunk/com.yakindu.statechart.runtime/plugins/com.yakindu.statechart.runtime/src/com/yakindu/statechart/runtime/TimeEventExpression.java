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

import com.yakindu.statechart.model.expressions.runtime.ExecutionScope;
import com.yakindu.statechart.model.expressions.runtime.Trigger;

public class TimeEventExpression extends com.yakindu.statechart.runtime.TimeEvent {

	protected Trigger.TimeEvent timeEvent;
	protected ExecutionScope scope;

	public TimeEventExpression(String id, Trigger.TimeEvent timeEvent, ExecutionScope scope) {
		super(id);
		this.timeEvent = timeEvent;
		this.scope = scope;
	}


		
	public Trigger.TimeEvent getTimeEvent() {
			return timeEvent;
		}



	public void setTimeEvent(Trigger.TimeEvent timeEvent) {
			this.timeEvent = timeEvent;
		}


	@Override
	public long getDuration() {
		return ((Integer)timeEvent.execute(scope)).longValue();
	}

	
}

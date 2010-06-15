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

public class ConstantTimeEvent extends TimeEvent {
	private long duration = -1;

	public ConstantTimeEvent(String id, long duration) {
		super(id);
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}
}

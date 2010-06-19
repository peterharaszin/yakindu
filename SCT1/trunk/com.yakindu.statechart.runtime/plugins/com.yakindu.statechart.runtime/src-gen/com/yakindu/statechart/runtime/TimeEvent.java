package com.yakindu.statechart.runtime;

public abstract class TimeEvent extends Event {

	public TimeEvent(String id) {
		super(id);
	}

	public abstract long getDuration();
}

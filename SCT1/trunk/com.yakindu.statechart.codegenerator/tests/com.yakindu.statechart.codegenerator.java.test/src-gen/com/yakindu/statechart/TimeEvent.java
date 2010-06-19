package com.yakindu.statechart;

public abstract class TimeEvent extends Event {

	public TimeEvent(String id) {
		super(id);
	}

	public abstract long getDuration();
}

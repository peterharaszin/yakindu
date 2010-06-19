package com.yakindu.statechart.runtime;

public interface TimingService {

	public void requestTimeEvent(TimeEvent timeEvent);

	public void cancelTimeEvent(TimeEvent timeEvent);

}

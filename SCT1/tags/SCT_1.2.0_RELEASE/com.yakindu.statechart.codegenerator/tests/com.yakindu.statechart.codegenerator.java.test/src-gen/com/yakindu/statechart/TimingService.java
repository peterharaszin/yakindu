package com.yakindu.statechart;

public interface TimingService {

	public void requestTimeEvent(TimeEvent timeEvent);

	public void cancelTimeEvent(TimeEvent timeEvent);

}

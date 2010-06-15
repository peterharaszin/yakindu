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
#include "timerServiceEvent.h"
#include "timerService.h"

using namespace TimerServiceEvent;

TimerService::TimerService(Scheduler& _scheduler, TrafficlightWaiting_Handle* _handle)
 : Task(_scheduler), handle(&_handle->ihandle)
{
	for(uint32 i(0); i<trigger_TrafficlightWaiting_MAX; ++i)
	  eventList[i] = Event(new Timeout(this));

}

TimerService::~TimerService()
{
}

void TimerService::setTimer(uint32 ID, uint64 duration)
{
	eventList[ID].setTimeout(getTics()+duration);
	((Timeout*)eventList[ID].ptr())->setID(ID);
	setEvent(eventList[ID]);

	}

void TimerService::resetTimer(uint32 ID)
{
	eventList[ID].setInactive();
}

void TimerService::handleTimeout(uint32 ID)
{
	trafficlightWaiting_Iface_raiseTrigger(handle,(TrafficlightWaiting_TrgType) ID);
}


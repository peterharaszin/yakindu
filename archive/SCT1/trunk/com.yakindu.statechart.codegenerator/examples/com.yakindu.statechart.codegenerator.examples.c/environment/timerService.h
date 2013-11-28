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
/*
 * timerService.h
 *
 *  Created on: Mar 23, 2009
 *      Author: seger
 */

#ifndef TIMERSERVICE_H_
#define TIMERSERVICE_H_

#include "task.h"
#include "event.h"
#include "trafficlightWaiting.h"

class TimerService: public Task {

public:

	Event eventList[trigger_TrafficlightWaiting_MAX];
	TrafficlightWaiting_IfaceHandle* handle;

	TimerService(Scheduler& _scheduler, TrafficlightWaiting_Handle* handle = 0);
	virtual ~TimerService();

	void setTimer(uint32 ID, uint64 duration);
	void resetTimer(uint32 ID);

	void handleTimeout(uint32 ID);
	void setIntfaceHandle(TrafficlightWaiting_Handle* _handle)
	{ handle = &_handle->ihandle; }

};

extern TimerService timerService;

#endif /* TIMERSERVICE_H_ */

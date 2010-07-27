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
 * timerServiceEvent.h
 *
 *  Created on: Mar 23, 2009
 *      Author: seger
 */

#ifndef TIMERSERVICEEVENT_H_
#define TIMERSERVICEEVENT_H_

#include "event.h"

class TimerService;

namespace TimerServiceEvent {

class Timeout: public EventHandle {

    TimerService* task;
    uint32 ID;

public:
	Timeout(TimerService* _task);
	virtual ~Timeout();

	virtual EventHandle* clone();
	virtual void runTask();
	virtual Task& getTask() const;

    void setID(uint32 ID);

};

}

#endif /* TIMERSERVICEEVENT_H_ */

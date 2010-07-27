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

Timeout::Timeout(TimerService* _task)
 : task(_task)
{
}

Timeout::~Timeout()
{
}

EventHandle* Timeout::clone()
{
	return(new Timeout(task));
}

void Timeout::runTask()
{
	task->handleTimeout(ID);
}

Task& Timeout::getTask() const
{
	return(*task);
}

void Timeout::setID(uint32 _ID)
{
	ID = _ID;
}

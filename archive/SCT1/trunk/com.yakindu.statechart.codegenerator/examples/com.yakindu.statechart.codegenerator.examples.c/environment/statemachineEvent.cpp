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
#include "statemachineEvent.h"
#include "statemachineTask.h"

using namespace StatemachineEvent;

Timeout::Timeout(StatemachineTask& _task)
 : task(&_task)
{
}

Timeout::~Timeout()
{
}

EventHandle* Timeout::clone()
{
  return(new Timeout(*this));
}

void Timeout::runTask()
{
	task->handleTimeout();
}

Task& Timeout::getTask() const
{
  return(*task);
}



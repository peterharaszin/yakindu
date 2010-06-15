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
#include "statemachineTask.h"
#include "statemachineEvent.h"
#include "trafficlightWaiting.h"

StatemachineTask::StatemachineTask(Scheduler& _scheduler, TrafficlightWaiting_Handle* _sm_handle)
 : Task(_scheduler), sm_handle(_sm_handle)
{
  timeout = Event(new StatemachineEvent::Timeout(*this));
  setEvent(timeout);
}

StatemachineTask::~StatemachineTask()
{
}

void StatemachineTask::handleTimeout()
{

	/* run one loop */
  trafficlightWaiting_runCycle(sm_handle);

  timeout.setTimeout(getTics()+(0.01*HZ));
  setEvent(timeout);

}

void StatemachineTask::setSMInterfaceHandle(TrafficlightWaiting_Handle* handle)
{
  sm_handle = handle;
}

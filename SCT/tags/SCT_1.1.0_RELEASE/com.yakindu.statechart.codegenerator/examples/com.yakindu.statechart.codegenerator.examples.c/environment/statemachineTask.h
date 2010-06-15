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
#ifndef STATEMACHINETASK_H
#define STATEMACHINETASK_H

#include "task.h"
#include "event.h"
#include "trafficlightWaiting.h"

class StatemachineTask : public Task {

protected:
  Event timeout;
  TrafficlightWaiting_Handle* sm_handle;

public:
  StatemachineTask(Scheduler& scheduler, TrafficlightWaiting_Handle* sm_handle = 0);
  virtual ~StatemachineTask();

  virtual void handleTimeout();

  void setSMInterfaceHandle(TrafficlightWaiting_Handle* sm_handle);

};


#endif

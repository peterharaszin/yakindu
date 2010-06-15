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
#ifndef TASTERTEST_H
#define TASTERTEST_H

#include "task.h"
#include "debounce.h"

#include "trafficlightWaiting.h"

class KeyTask : public Task {

  Event    timeout;
  Debounce debounce;
  uint8    oldValue;

  TrafficlightWaiting_Handle* tl_handle;

public:
  KeyTask(Scheduler& scheduler);
  virtual ~KeyTask();

  void handleTimeout();

  void setSMInterfaceHandle(TrafficlightWaiting_Handle* tl_handle);

};

#endif


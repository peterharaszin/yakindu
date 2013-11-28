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
#ifndef STATEMACHINEEVENT_H
#define STATEMACHINEEVENT_H

#include "event.h"

class StatemachineTask;

namespace StatemachineEvent {

class Timeout : public EventHandle {

protected:
	StatemachineTask* task;

public:
	Timeout(StatemachineTask& task);
	virtual ~Timeout();

	virtual EventHandle* clone();
	virtual void runTask();
	virtual Task& getTask() const;

};

}

#endif

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
#ifndef BLINKERTASK_H_
#define BLINKERTASK_H_

#include "task.h"
#include "trafficlightWaiting.h"

class OutputTask : public Task
{
private:
	uint32 outputDuration;
	Event  outputEvent;
	uint32 outputValue;
	uint32 addition;
	uint8  oldLight_Car;
	uint8  oldLight_Ped;

	TrafficlightWaiting_Handle* tl_handle;

	static const uint32 IDToValue[];

	void TrafficLight(uint8 ID, uint8 LightID);
	void initLCD();

public:
	OutputTask(Scheduler& scheduler, uint32 duration);
	virtual ~OutputTask();

	void handleTimeout();
	void handleOutput(const uint8& ID);

	void setSMInterfaceHandle(TrafficlightWaiting_Handle* _tl_handle) {tl_handle = _tl_handle;}

};

#endif /*BLINKERTASK_H_*/

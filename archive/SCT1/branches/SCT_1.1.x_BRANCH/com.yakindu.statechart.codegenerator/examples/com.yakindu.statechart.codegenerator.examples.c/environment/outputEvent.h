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
#ifndef BLINKEREVENT_H_
#define BLINKEREVENT_H_

#include "event.h"

class OutputTask;

namespace OutputEvent {

class Timeout : public EventHandle
{
protected:
	OutputTask* outputTask;

public:
	Timeout(OutputTask& task);
	virtual ~Timeout();

	virtual EventHandle* clone();
	virtual void runTask();
	virtual Task& getTask() const;

};

class Output : public EventHandle
{
protected:
	OutputTask* outputTask;
    uint8        outputID;

public:
	Output(OutputTask& task);
	virtual ~Output();

	virtual EventHandle* clone();
	virtual void runTask();
	virtual Task& getTask() const;

    void setOutput(uint8 outputID);

};

}

#endif /*BLINKEREVENT_H_*/

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
#include "outputEvent.h"
#include "outputTask.h"

using namespace OutputEvent;

Timeout::Timeout(OutputTask& task)
 : outputTask(&task)
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
	outputTask->handleTimeout();
}

Task& Timeout::getTask() const
{
  return(*outputTask);
}

//-------------------------------

Output::Output(OutputTask& task)
 : outputTask(&task), outputID(0)
{
}

Output::~Output()
{
}

EventHandle* Output::clone()
{
  return(new Output(*this));
}

void Output::runTask()
{
	outputTask->handleOutput(outputID);
}

Task& Output::getTask() const
{
  return(*outputTask);
}

void Output::setOutput(uint8 value)
{
	outputID = value;
}

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
#include "keyEvent.h"
#include "keyTask.h"

using namespace KeyEvent;

Timeout::Timeout(KeyTask& task)
 : keyTask(&task)
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
	keyTask->handleTimeout();
}

Task& Timeout::getTask() const
{
  return(*keyTask);
}

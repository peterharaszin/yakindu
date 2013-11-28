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
#include "event.h"

Event::Event()
{
  EventPtr = new DummyEventHandle;
  ref_counter = new (uint32);
  (*ref_counter) = 1;
}

Event::Event(const Event& _E)
{
  EventPtr = _E.EventPtr;
  ref_counter = _E.ref_counter;
  (*ref_counter)++;
}

/*
Event::Event(const int64 to, bool active)
{
  EventPtr = new EventHandler(to, task, ID, active);
  ref_counter = new (uint32);
  (*ref_counter) = 1;
}
*/

Event::Event(EventHandle* ePtr)
{
  EventPtr = ePtr;
  ref_counter = new (uint32);
  (*ref_counter) = 1; // hope this is the first one
}

Event::~Event()
{
  (*ref_counter)--;
  if (!(*ref_counter)) {
    delete EventPtr;
    delete ref_counter;
  }
}

Event Event::clone()
{
  Event cloneEvent(EventPtr->clone());
  return cloneEvent;
}

EventHandle* Event::ptr()
{
  return (EventPtr);
}

void Event::setTimeout(int64 to)
{
  EventPtr->active = true;
  EventPtr->timeout = to;
}

int64 Event::getTimeout() const
{
  return(EventPtr->timeout);
}

void Event::setInactive()
{
  EventPtr->active = false;
}

bool Event::isActive() const
{
  return(EventPtr->active);
}

Event& Event::operator=(const Event& _E)
{
  if (this != &_E) {
    (*ref_counter)--;
    if (!(*ref_counter)) {
      delete EventPtr;
      delete ref_counter;
    }

    EventPtr = _E.EventPtr;
    ref_counter = _E.ref_counter;
    (*ref_counter)++;
  }

  return (*this);
}

bool Event::isExpired(int64 tics) const
{
  return (EventPtr->timeout <= tics);
}

bool Event::operator==(const Event& _E) const
{
  return (EventPtr == _E.EventPtr);
}

void Event::runTask()
{
  EventPtr->runTask();
}

Task& Event::getTask() const
{
  return(EventPtr->getTask());
}

bool Event::empty()
{
  return(&EventPtr->getTask() == 0);
}

bool Event::operator<(const Event& _E) const
{
  if (EventPtr->timeout >= _E.getTimeout())
    return (true);
  return (false);
}

bool isEventEqual::operator()(Event a, Event b) const
{
  if (a.getTimeout() == b.getTimeout())
    return (true);
  return (false);
}

bool isEventLess::operator()(Event a, Event b) const
{
  if (a.getTimeout() > b.getTimeout())
    return (true);
  return (false);
}

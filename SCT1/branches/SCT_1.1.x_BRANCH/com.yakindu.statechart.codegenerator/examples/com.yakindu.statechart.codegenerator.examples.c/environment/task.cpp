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
#include "task.h"
#include "scheduler.h"

Task::Task(Scheduler& _scheduler)
  : schedulerTime(_scheduler.getTimePtr()), scheduler(&_scheduler),
    markedForKill(false)
{
}

Task::~Task()
{
}

void Task::setEvent(Event event)
{
  scheduler->addEvent(event);
}

uint64 Task::getTics() const
{
  return(*schedulerTime);
}

bool Task::isMarkedForKill() const
{
  return(markedForKill);
}

void Task::markForKill()
{
  markedForKill = true;
}

//Event Task::getEvent(uint32 eventID) const
//{
//  std::map<uint32, Event>::const_iterator eventIt;
//
//  if ((eventIt = eventlist.find(eventID)) != eventlist.end())
//    return(eventIt->second);
//
//  /* before you ask: No, dummy is not deleted by the end of this method
//   * as the Event creates an EventHandle (derived from that) on the heap. This object
//   * will only be deleted if there is no one, who uses this object any more */
//  Event dummy;
//  return(dummy);
//}
//
//void Task::installEvent(uint32 eventID, Event event)
//{
//
//  if (event.empty())
//    return;
//
//  eventlist[eventID] = event;
//}
//

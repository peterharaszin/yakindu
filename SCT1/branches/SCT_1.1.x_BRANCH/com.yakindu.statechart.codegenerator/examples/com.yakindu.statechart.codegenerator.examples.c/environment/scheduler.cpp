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
#include "scheduler.h"

extern volatile uint64 tics;

Scheduler::Scheduler() :
	timeTics(0), startTime(0), nextEventTime(0), running(false) {
}

Scheduler::~Scheduler() {
}

uint64* Scheduler::getTimePtr() {
	return (&timeTics);
}

void Scheduler::addEvent(Event event) {
	setAtomic();
	eventQueue.push(event);
	unsetAtomic();
}

void Scheduler::delEvents(Task& task) {
	setAtomic();
	eventQueue.disableEvents(task);
	unsetAtomic();
}

void Scheduler::killTask(Task& task) {

	if (task.isMarkedForKill())
		return;

	task.markForKill();

	// all open events must be disabled
	delEvents(task);

	// then the task is scheduled to be deleted
//	killTaskList.push_back(&task);

	// until the task is completely deleted, this is a zombie
}

void Scheduler::setAtomic() {
	// this method ensures, that there is no other working on the event queue
}

void Scheduler::unsetAtomic() {
	// this method ensures, that there is no other working on the event queue
}

void Scheduler::handleEvent(Event event) {
	if (event.isActive())
		event.runTask();
}

void Scheduler::setNextEvent() {
	setAtomic();

	// delete none active events
	while (!(eventQueue.empty()) && !(eventQueue.top().isActive()))
		eventQueue.pop();

	// if there is no open event, we only wait for descriptors
	if (eventQueue.empty()) {
		// ensures, that we wake up from time to time
		nextEventTime += maxWaitTime;
	} else {
		nextEventTime = eventQueue.top().getTimeout();
	}
	unsetAtomic();
}

void Scheduler::handleKillRequests() {
/*
	while (!killTaskList.empty()) {
		delete killTaskList.front();
		killTaskList.pop_front();
	}
*/
}

void Scheduler::schedule(uint64 maxTics) {

	bool handleTopEvent;
	Event nextEvent;

    while(1) {

	do {
		// List access must be atomic
		setAtomic();
		if (eventQueue.empty() || !eventQueue.top().isExpired(timeTics)) {
			handleTopEvent = false;
		} else {
			if (eventQueue.top().isActive())
			    handleTopEvent = true;
			else
				handleTopEvent = false;
			nextEvent = eventQueue.top();
			eventQueue.pop();
		}
		unsetAtomic();

		if (handleTopEvent)
			handleEvent(nextEvent);

	} while (handleTopEvent);

	// if there was a request for deleting tasks, we gonna do that now
	handleKillRequests();

	// set the time of the next event, if one
	setNextEvent();

	while (tics == timeTics){};
//    PORTA ^= 0x01;

    timeTics = tics;

//	static uint32 i=0;

//	if (i%1000 == 0)
//	    PORTA ^= 0x01;

    }
}

void Scheduler::timerHandler()
{
	//timeTics = ;

	if (running) {
//		std::cerr << "#";
		return;
	}

	running = true;

	schedule();

	running = false;

    // what about a watchdog?
}

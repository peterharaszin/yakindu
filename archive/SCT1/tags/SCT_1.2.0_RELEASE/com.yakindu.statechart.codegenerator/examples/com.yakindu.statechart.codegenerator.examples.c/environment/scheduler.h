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
#ifndef scheduler_h
#define scheduler_h

//#include <list>

#include "definitions.h"

#include "prioQueue.h"
#include "task.h"

class Scheduler {

protected:

	//! wait for 2 Seconds maximum, if no event is available
	static const uint64 maxWaitTime = 2*HZ;

	uint64 timeTics; //!< actual time tics

	uint64 startTime; //!< time when scheduling has started
	uint64 nextEventTime; //!< time when next event should be scheduled

	bool running; //!< scheduler is running actually

	/*! List of tasks, that should be deleted at the next opportunity */
//	std::list<Task*> killTaskList;

	/*! priority queue to manage the upcomming events */
	prioQueue eventQueue;

	void handleKillRequests();
	void handleEvent(Event event);
	void setNextEvent();

	/* Hardware dependent implmentation */
	void setAtomic();
	void unsetAtomic();

public:

	//! Constructor
	Scheduler();

	//! Destructor
	~Scheduler();

	/*! Method returns a pointer to the actual time tics
	 * This pointer is used by the task to have access to the actual time base.
	 * This method should be used carfully, as the value should not be changed
	 * in any way by any task. The task class usually hides the access to this
	 * pointer by a get method. */
	uint64* getTimePtr();

	/*! Method that adds a new event to the scheduler.
	 *  This event is placed into the priority queue list. The priority is actually only given by
	 *  the time, to wich the event should time out. The event is raised by the absolute time
	 * on which the timeout is set to. If there is no timeout set, 0 is taken and the event
	 * is called by the next opportunity */
	void addEvent(Event event);

	/*! Method that deletes all events associated with a given task.
	 *  This method is called by the task destructor. It is important, as the
	 *  tasks, that have been deleted should not be called by any event any more. */
	void delEvents(Task& task);

	/*! Method to mark a task as killed.
	 *  If a task is defined to by killed, it is switched from the running queue to the
	 *  killed queue. The delete (destructor) action may not be achieved directly, so
	 *  that you might have a zombie. */
	void killTask(Task& task);

	//! method should be called, after a timer interrupt
	/*! This method increments the timeTics counter and evaluates, if the scheduling
	 *  process is still running. If so, nothing happens, if not the scheduling is started. */
	void timerHandler();

	/*! Method to start the scheduling process
	 This method is called by the timerHandler() method */
	void schedule(uint64 time=0);

};

extern Scheduler scheduler;

#endif

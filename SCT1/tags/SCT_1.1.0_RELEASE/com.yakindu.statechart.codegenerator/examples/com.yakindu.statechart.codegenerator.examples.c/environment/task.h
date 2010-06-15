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
#ifndef task_h
#define task_h

class Scheduler;

#include "event.h"

//! Task is a basic class to derive tasks for special purposes
/*! A task must have a scheduler, in which context it runs.
 *  On startup it requests a pointer to the schedulers timer, which
 *  can be accessed by the method getTics().
 *
 *  After an event has been created, it must be handed to the scheduler
 *  by the method setEvent(). If an event should be set obsolete, it can be
 *  set inactive by calling the events method setInactive(). In that case,
 *  the event will never be raised. For better performance, the event is not
 *  erased within the schedulers queue.
 *
 *  On delete of a task, it must be deregistered by the scheduler with the
 *  method killTask(). The Task is not deleted immediately, but queued for delete.
 *  Therefor it is not called after the task method has been processed completely.
 *  At the next opportunity the task is deleted and all events registered with
 *  this task are set to be inactive.
 *
 *  How to create a task method, that is called every 10 ms:
 *
 *  Derive a class NewTask from Task and add a method void main(), which is the
 *  main method of your task. Then create a newEvent derived from EventHandle
 *  and let it call newTask->main() within it's run()-method. (See class
 *  EventHandle for more details).
 *
 *  Within your main method call create a NewEvent instance, and set it to the
 *  next timeout and set it.
 *  \code
 *  newEvent = Event(new NewEvent(*this));
 *  newEvent.setTimeout(getTics()+10*HZ);
 *  setEvent(newEvent);
 *  \endcode
 *
 *  Please not that Event is just a container to keep a reference and a reference
 *  counter to NewEvent. NewEvent itself is derived from EventHandle and will
 *  never be copied if not explicitly requested.
 *
 *  To have an initial start for an event, the same code can be used within the
 *  constructor. Even though, an event can be created from outside. The only
 *  condition is, that there is a pointer to the caller class is available as
 *  the constructor of NewEvent has to know about the instance of the class NewEvent.
 *  */
class Task {

private:
	uint64_t* schedulerTime;

protected:
	Scheduler* scheduler;
	bool markedForKill;

	friend class Scheduler;

	//! Standard constructor usage is prohibited
	/*! A task necessarily needs a Scheduler instance, therefor this constructor
	 *  can not be used. */
	Task();

	//! Method to set an event
	/*! This method enqueues an event into the scheduler event queue.
	 *  Please be sure, that this event is set to active.
	 *  There are two possibilities to create an event:
	 *  -# Without an external reference
	 * \code
	 * setEvent(new MyEvent(*this));
	 * \endcode
	 *  -# With external reference
	 * \code
	 * myEvent = Event(new MyEvent(*this));
	 * setEvent(myEvent);
	 * ...
	 * myEvent.setInactive();
	 * \endcode
	 *
	 * The advantage of the second possibility is that the event could be
	 * set inactive, which is quite nice, if you have a timeout for example,
	 * that has become obsolete.
	 * */
	void setEvent(Event event);


	uint64 getTics() const;

	bool isMarkedForKill() const;
	void markForKill();

public:

	//! Constructor to create a basic Task structure
	/*! Within the Constructor, the Task creates the access to*/
	Task(Scheduler& scheduler);
	virtual ~Task();

};

inline Task::Task() {
}

#endif

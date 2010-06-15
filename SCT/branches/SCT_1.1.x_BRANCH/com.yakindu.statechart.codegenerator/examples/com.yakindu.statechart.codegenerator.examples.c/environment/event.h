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
#ifndef Event_h
#define Event_h

#include "definitions.h"

class Task;

//! EventHandle keeps all neccessary information of the event
/*! This class can be very large, as it is not copied at any time */
class EventHandle {

 public:
  int64       timeout;
  bool        active;

  EventHandle(int64 _timeout=0, bool _active = true)
    : timeout(_timeout), active(_active) {}

  virtual ~EventHandle() {}

  virtual EventHandle* clone() = 0;
  virtual void runTask() = 0;

  //! Method returns the task object that belongs to the event
  /*!  */
  virtual Task& getTask() const = 0;

};

class DummyEventHandle : public EventHandle {

protected:
	  Task* taskPtr;

  public:
    DummyEventHandle()
     : EventHandle(0, false), taskPtr(0) {}

    virtual ~DummyEventHandle() {}

    virtual EventHandle* clone()
    { return(new DummyEventHandle); }

    virtual void runTask() {}
    virtual Task& getTask() const {return(*taskPtr); }

};

//! Event Class
class Event {
 private:
  uint32*       ref_counter;
  EventHandle*  EventPtr;

 public:

  Event();
  Event(const Event& _E);
  Event(EventHandle* ePtr);

  virtual ~Event();

  Event clone();

  void setTimeout(int64 to);
  void setInactive();

  bool isActive() const;
  bool isExpired(int64 time) const;
  int64 getTimeout() const;

  //! returns the corresponding Event
  /*! only for internal usage */
  EventHandle* ptr();

  // operators
  Event& operator=(const Event& _E);
  bool operator==(const Event& _E) const;

  void runTask();
  Task& getTask() const;

  bool empty();

  bool operator<(const Event& _E) const;

};

struct isEventEqual
{
  bool operator()(Event a, Event b) const;
};

struct isEventLess
{
  bool operator()(Event a, Event b) const;
};


#endif

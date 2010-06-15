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
#ifndef prioQueue_h
#define prioQueue_h

#include "event.h"
#include "task.h"

struct ListElem {

  Event event;
  ListElem* nextElem;

};

class prioQueue  {

  protected:
	ListElem first;
	ListElem last;
    uint16 _size;

 public:
  prioQueue();
  ~prioQueue(){};

  void disableEvents(const Task& task);

  bool empty() const { return(first.nextElem == &last); }
  uint16 size() const { return(_size); }

  const Event& top() const { return(first.nextElem->event); }

  void push(const Event& event);
  void pop();

};

inline prioQueue::prioQueue()
{
	first.nextElem = &last;
}

inline void prioQueue::push(const Event& event)
{
  bool found(false);
  // ok, this needs to be reworked, but it's ok for the moment

  // running through the list and try to find the last
  ListElem* actElem = first.nextElem;
  ListElem* prev = &first;

  ListElem* newElem = new ListElem;
  newElem->event = event;

  while((actElem != &last) &&(found == false)) {
  	if (event.getTimeout() <= actElem->event.getTimeout()) {
  	  newElem->nextElem = actElem;
  	  prev->nextElem = newElem;
  	  found = true;
  	}
  	prev = actElem;
  	actElem = actElem->nextElem;
  }

  if (found == false) {
    newElem->nextElem = &last;
    prev->nextElem = newElem;
  }

  _size++;
}

inline void prioQueue::disableEvents(const Task& task)
{
  ListElem* actElem = first.nextElem;

  while((actElem != &last)) {
  	if (&actElem->event.getTask() == &task) {
  	  actElem->event.setInactive();
  	}
  	actElem = actElem->nextElem;
  }

}

inline void prioQueue::pop()
{
	if (empty())
	 return;

	ListElem* delElem = first.nextElem;
	first.nextElem = delElem->nextElem;

    delete delElem;
    _size--;
}

#endif

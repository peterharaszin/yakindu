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
#include <avr/io.h>         // interface definitions for the AVR ATMEGA128
#include <stdlib.h>         // needed for malloc/new

#include "keyTask.h"
#include "keyEvent.h"

#include "trafficlightWaiting.h"   // interface for the state machine

using namespace KeyEvent;

KeyTask::KeyTask(Scheduler& _scheduler)
 : Task(_scheduler), debounce(10), oldValue(0), tl_handle(0)
{
  	timeout = Event(new Timeout(*this));
	setEvent(timeout);
}

KeyTask::~KeyTask()
{
}

void KeyTask::handleTimeout()
{

	uint8 buttonPressed(0x00);
	uint8 buttonDebounced;

	if ((PINC & 0x04) == 0x00)
	  buttonPressed |= 0x01;

	if ((PINC & 0x08) == 0x00)
	  buttonPressed |= 0x02;

	if ((PINC & 0x10) == 0x00)
	  buttonPressed |= 0x04;

	if ((PINC & 0x20) == 0x00)
	  buttonPressed |= 0x08;

	if ((PINC & 0x40) == 0x00)
	  buttonPressed |= 0x10;

	if ((PINC & 0x80) == 0x00)
	  buttonPressed |= 0x20;

    debounce.setValue(buttonPressed);
    debounce.trigger();
    buttonDebounced = debounce.getValue();

    if ((tl_handle) && (buttonDebounced != oldValue)) {

      if ((buttonDebounced & 0x01) == 0x01)
    	  trafficlightWaiting_raiseTrigger_keypress1(tl_handle);

/* Hier koennen die weiteren Verlinkungen vorgenommen werden
   (diese Verlinkungen muessen manuell eingepflegt werden)
      if ((buttonDebounced & 0x04) == 0x04)
    	  trafficlightWaiting_raiseTrigger_keypress3(tl_handle);

      if ((buttonDebounced & 0x08) == 0x08)
    	  trafficlightWaiting_raiseTrigger_keypress4(tl_handle);

      if ((buttonDebounced & 0x10) == 0x10)
    	  trafficlightWaiting_raiseTrigger_keypress5(tl_handle);

      if ((buttonDebounced & 0x20) == 0x20)
    	  trafficlightWaiting_raiseTrigger_keypress6(tl_handle);
*/
      oldValue = buttonDebounced;
    }

//   Taster soll alle 10 ms überprüft werden
  timeout.setTimeout(getTics()+(0.01*HZ));
  setEvent(timeout);

}

void KeyTask::setSMInterfaceHandle(TrafficlightWaiting_Handle* _tl_handle)
{
  tl_handle = _tl_handle;
}


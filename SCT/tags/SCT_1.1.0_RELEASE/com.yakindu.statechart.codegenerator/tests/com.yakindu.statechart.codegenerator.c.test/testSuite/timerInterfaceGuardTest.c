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
#include <stdlib.h>
#include <stdio.h>

#include "guardTest_timerIface.h"
#include "guardTest_Iface.h"
#include "definitions.h"

extern uint64 sys_time();

typedef struct TimerElement_t {

	struct TimerElement_t*       next;
	GuardTest_IfaceHandle*     ihandle;
	uint64                       timeout;
	GuardTest_TrgType          trigger;

} TimerElement;

static TimerElement Head;

void GuardTest_timerIface_raiseTimer(GuardTest_IfaceHandle* ihandle, GuardTest_TrgType trigger)
{
     guardTest_Iface_raiseTrigger(ihandle, trigger);
}

void GuardTest_timerIface_print()
{
	TimerElement *actElem;

	for(actElem=&Head; actElem->next != NULL; actElem = actElem->next) {
	  printf("Timer: %d  %d\n",(uint32)actElem->next->timeout, (uint32)actElem->next->trigger);
	}
}

void GuardTest_timerIface_installTimer(GuardTest_IfaceHandle* ihandle, GuardTest_TrgType trigger, uint64 time_ms)
{
	TimerElement* actElem = &Head;
	TimerElement* newElem = malloc(sizeof(TimerElement));

	newElem->ihandle = ihandle;
	newElem->timeout = sys_time() + time_ms;
	newElem->trigger = trigger;

	while ((actElem->next != NULL) && (actElem->next->timeout < newElem->timeout)) {
		actElem = actElem->next;
	}

	newElem->next = actElem->next;
	actElem->next = newElem;

/*	printf("Install\n");
	timerInterface_print();
	printf("\n");
*/
}

void GuardTest_timerIface_resetTimer(GuardTest_IfaceHandle* handle, GuardTest_TrgType trigger)
{
	TimerElement *actElem, *delElem;

	for(actElem=&Head; actElem->next != NULL; actElem = actElem->next) {
	  if (actElem->next->trigger == trigger) {
		  delElem = actElem->next;
		  actElem->next = actElem->next->next;
		  free(delElem);
		  break;
	  }
	}
}

void GuardTest_timerIface_trigger(uint64 tics)
{
	TimerElement* actElem = Head.next;

	if ((actElem != NULL) && (tics >= actElem->timeout)) {

/*		printf("Raise %d %d\n", (uint32)actElem->timeout, (uint32)actElem->trigger);
		timerInterface_print();
		printf("\n"); */

		GuardTest_timerIface_raiseTimer(actElem->ihandle, actElem->trigger);

		Head.next = actElem->next;
		free(actElem);
	}
}

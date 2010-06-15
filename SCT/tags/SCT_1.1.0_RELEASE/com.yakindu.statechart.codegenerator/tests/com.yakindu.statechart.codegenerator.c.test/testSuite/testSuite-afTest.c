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
/*
 * testSuite2.c
 *
 *  Created on: Mar 17, 2009
 *      Author: seger
 */
#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "definitions.h"
#include "afterTest.h"
#include "simElement.h"
#include "afterTest_timerIface.h"

extern void afterTest_timerIface_trigger(uint64 tics);

uint64 faketime = 0;

uint64 sys_time()
{
  return(faketime);
}

uint64 stepTime(uint64 addtime)
{
	return(faketime += addtime);
}

#define MAX_SIM_CYCLES   200000
#define CYCLE_TIME_MS    10

int main()
{
  uint32 i;
  SM_afterTest_Handle        sMachine;
  AfterTest_IfaceHandle*     interfaceHandle=0;
  uint32                     statesCount[ st_AfterTest_MAX];

  SimElement*          simListe = NULL;
  ResElement*          resListe = NULL;


  addSimElementVar(&simListe, 0, waitTime, 500);

  addResElementVar(&resListe, 480, st, 1);
  addResElementVar(&resListe, 500, st, 2);

  addSimElementTrig(&simListe, 600, trigger1);
  addResElementVar(&resListe, 600, st, 1);


  /* add Duration time (100) */
  addSimElementTrig(&simListe, 1000, key1);

  addResElementVar(&resListe, 1000, waitTime, 600);

  addResElementVar(&resListe, 1590, st, 1);
  addResElementVar(&resListe, 1600, st, 2);

  addSimElementVar(&simListe, 1700, waitTime, 1500);
  addSimElementTrig(&simListe,1700, trigger1);
  addResElementVar(&resListe, 1700, st, 1);

  /* add duration time */
  addSimElementTrig(&simListe, 1720, key1);
  addSimElementTrig(&simListe, 1740, key1);
  addSimElementTrig(&simListe, 1760, key1);
  addSimElementTrig(&simListe, 1780, key1);
  addSimElementTrig(&simListe, 1800, key1);

  addResElementTrig(&resListe, 1720, outputEvent1);
  addResElementTrig(&resListe, 1740, outputEvent1);
  addResElementTrig(&resListe, 1760, outputEvent1);
  addResElementTrig(&resListe, 1780, outputEvent1);

  addResElementVar(&resListe, 1800, waitTime, 2000);

  /* does duration stop at 2000 */
  addSimElementTrig(&simListe, 1820, key1);
  addSimElementTrig(&simListe, 1840, key1);
  addSimElementTrig(&simListe, 1860, key1);
  addSimElementTrig(&simListe, 1880, key1);
  addSimElementTrig(&simListe, 1900, key1);
  addResElementVar(&resListe, 1900, waitTime, 2000);

  addResElementVar(&resListe, 3790, st, 1);
  addResElementVar(&resListe, 3800, st, 2);


  /* carries the information, which state has been reached, and how often */
  for(i=0; i< st_AfterTest_MAX; ++i)
	  statesCount[i] = 0;

  afterTest_init(&sMachine, &interfaceHandle);

  afterTest_Iface_cleanVariables(interfaceHandle);

  for(i=0; i<MAX_SIM_CYCLES; ++i) {

	  BOOL        stateMachineFinished = FALSE;

	  installChange(simListe, interfaceHandle,  sys_time());

	  afterTest_timerIface_trigger(sys_time());

	  while (stateMachineFinished == FALSE) {
 		stateMachineFinished = afterTest_runCycle(&sMachine);
 		afterTest_Iface_cleanInputTriggers(interfaceHandle);
	  }

	  compareResults(resListe, interfaceHandle, sys_time());

	  afterTest_Iface_cleanTriggers(interfaceHandle);

      statesCount[sMachine.state]++;

#ifdef DEBUG
      printf("\r  %d     ", i);
#endif

/*      printf(" %d ", *stateIDVar); */

      stepTime(10); /* add 10ms for the next cycle */
  }

  printf("\n\nFinished\n\n");

  for(i=0; i< st_AfterTest_MAX; ++i) {
	  printf(" State No. %d   -> %d\n",i, statesCount[i]);
  }

  printStatistics(resListe);

  return(0);
}


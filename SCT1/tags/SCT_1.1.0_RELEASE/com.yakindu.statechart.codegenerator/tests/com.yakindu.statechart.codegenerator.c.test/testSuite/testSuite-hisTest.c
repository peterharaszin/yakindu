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
#include "historyTest.h"
#include "simElement.h"

extern void historyTest_timerIface_trigger(uint64 tics);

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
  SM_historyTest_Handle      sMachine;
  HistoryTest_IfaceHandle*   interfaceHandle=0;
  uint32                     statesCount[st_HistoryTest_MAX];

  SimElement*          simListe = NULL;
  ResElement*          resListe = NULL;



  /* Aim: this test creates the following Loop:
   * Initial, state1, state5, state4, state6, state1 */

  /* Loop 1: Simple Circle */
  addSimElementTrig(&simListe, 100, event1);
  addSimElementTrig(&simListe, 200, event2);
  addSimElementTrig(&simListe, 300, event3);
  addSimElementTrig(&simListe, 400, event4);


  /* Results loop 1*/
  addResElementVar(&resListe, 10, inState0, 0);
  addResElementVar(&resListe, 10, inState1, 1);
  addResElementVar(&resListe, 10, inState2, 0);
  addResElementVar(&resListe, 10, inState3, 0);
  addResElementVar(&resListe, 10, inState4, 0);
  addResElementVar(&resListe, 10, inState5, 0);
  addResElementVar(&resListe, 10, inState6, 0);

  /* event 1 happens here (at 100) */

  addResElementVar(&resListe, 100, inState0, 1);
  addResElementVar(&resListe, 100, inState1, 0);
  addResElementVar(&resListe, 100, inState2, 0);
  addResElementVar(&resListe, 100, inState3, 1);
  addResElementVar(&resListe, 100, inState4, 0);
  addResElementVar(&resListe, 100, inState5, 1);
  addResElementVar(&resListe, 100, inState6, 0);

  /* event 2 happens here (at 200) */

  addResElementVar(&resListe, 200, inState0, 1);
  addResElementVar(&resListe, 200, inState1, 0);
  addResElementVar(&resListe, 200, inState2, 0);
  addResElementVar(&resListe, 200, inState3, 1);
  addResElementVar(&resListe, 200, inState4, 1);
  addResElementVar(&resListe, 200, inState5, 0);
  addResElementVar(&resListe, 200, inState6, 0);

  /* event 3 happens here (at 300) */

  addResElementVar(&resListe, 300, inState0, 0);
  addResElementVar(&resListe, 300, inState1, 0);
  addResElementVar(&resListe, 300, inState2, 1);
  addResElementVar(&resListe, 300, inState3, 0);
  addResElementVar(&resListe, 300, inState4, 0);
  addResElementVar(&resListe, 300, inState5, 0);
  addResElementVar(&resListe, 300, inState6, 1);

  /* event 4 happens here (at 400) */

  addResElementVar(&resListe, 400, inState0, 0);
  addResElementVar(&resListe, 400, inState1, 1);
  addResElementVar(&resListe, 400, inState2, 0);
  addResElementVar(&resListe, 400, inState3, 0);
  addResElementVar(&resListe, 400, inState4, 0);
  addResElementVar(&resListe, 400, inState5, 0);
  addResElementVar(&resListe, 400, inState6, 0);

  /***************************************************/




  /* Loop 2: Entering substates */
  addSimElementTrig(&simListe, 500, event5);
  addSimElementTrig(&simListe, 600, event6);
  addSimElementTrig(&simListe, 700, event4);

  /* event 5 happens here (at 500) */

  addResElementVar(&resListe, 500, inState0, 1);
  addResElementVar(&resListe, 500, inState1, 0);
  addResElementVar(&resListe, 500, inState2, 0);
  addResElementVar(&resListe, 500, inState3, 1);
  addResElementVar(&resListe, 500, inState4, 1);
  addResElementVar(&resListe, 500, inState5, 0);
  addResElementVar(&resListe, 500, inState6, 0);

  /* event 6 happens here (at 600) */

  addResElementVar(&resListe, 600, inState0, 0);
  addResElementVar(&resListe, 600, inState1, 1);
  addResElementVar(&resListe, 600, inState2, 0);
  addResElementVar(&resListe, 600, inState3, 0);
  addResElementVar(&resListe, 600, inState4, 0);
  addResElementVar(&resListe, 600, inState5, 0);
  addResElementVar(&resListe, 600, inState6, 0);

  /* event 4 happens here (at 700) -> nothing happens */

  addResElementVar(&resListe, 700, inState0, 0);
  addResElementVar(&resListe, 700, inState1, 1);
  addResElementVar(&resListe, 700, inState2, 0);
  addResElementVar(&resListe, 700, inState3, 0);
  addResElementVar(&resListe, 700, inState4, 0);
  addResElementVar(&resListe, 700, inState5, 0);
  addResElementVar(&resListe, 700, inState6, 0);

  /***************************************************/





  /* Loop 3: Parallel Events, different state hierarchies */
  addSimElementTrig(&simListe, 800, event5);
  addSimElementTrig(&simListe, 900, event6);
  addSimElementTrig(&simListe, 900, event3);


  /* event 5 happens here (at 800) */

  addResElementVar(&resListe, 800, inState0, 1);
  addResElementVar(&resListe, 800, inState1, 0);
  addResElementVar(&resListe, 800, inState2, 0);
  addResElementVar(&resListe, 800, inState3, 1);
  addResElementVar(&resListe, 800, inState4, 1);
  addResElementVar(&resListe, 800, inState5, 0);
  addResElementVar(&resListe, 800, inState6, 0);

  /* event 6 and 3 happen here (at 900) -> event 6 is used */

  addResElementVar(&resListe, 900, inState0, 0);
  addResElementVar(&resListe, 900, inState1, 1);
  addResElementVar(&resListe, 900, inState2, 0);
  addResElementVar(&resListe, 900, inState3, 0);
  addResElementVar(&resListe, 900, inState4, 0);
  addResElementVar(&resListe, 900, inState5, 0);
  addResElementVar(&resListe, 900, inState6, 0);

  /***************************************************/





  /* Loop 4: Parallel Events, same state */
  addSimElementTrig(&simListe, 1000, event5);
  addSimElementTrig(&simListe, 1000, event1);
  addSimElementTrig(&simListe, 1100, event6);

  /* event 5 and 1 happen here (at 1000) -> event 1 is used */

  addResElementVar(&resListe, 1000, inState0, 1);
  addResElementVar(&resListe, 1000, inState1, 0);
  addResElementVar(&resListe, 1000, inState2, 0);
  addResElementVar(&resListe, 1000, inState3, 1);
  addResElementVar(&resListe, 1000, inState4, 0);
  addResElementVar(&resListe, 1000, inState5, 1);
  addResElementVar(&resListe, 1000, inState6, 0);

  /***************************************************/






  /* Loop 5: History Test 1: Shallow History */
  /* hier sollte kein Unterschied zur Deep history sein, da
   * wieder über Initial in state 4 gesprungen wird */
  addSimElementTrig(&simListe, 1200, event5);
  addSimElementTrig(&simListe, 1300, key1);

  addSimElementTrig(&simListe, 1400, event6);


  /* History Test1 */

  addResElementVar(&resListe, 1200, counter, 0);

  addResElementVar(&resListe, 1300, inState0, 1);
  addResElementVar(&resListe, 1300, inState1, 0);
  addResElementVar(&resListe, 1300, inState2, 0);
  addResElementVar(&resListe, 1300, inState3, 1);
  addResElementVar(&resListe, 1300, inState4, 1);
  addResElementVar(&resListe, 1300, inState5, 0);
  addResElementVar(&resListe, 1300, inState6, 0);

  addResElementVar(&resListe, 1300, counter, 1);







  /* Loop 6: History Test 2: Shallow History */
  addSimElementTrig(&simListe, 1500, event1);
  addSimElementTrig(&simListe, 1600, key1);

  addSimElementTrig(&simListe, 1700, event6);

  /* History Test */

  addResElementVar(&resListe, 1600, inState0, 1);
  addResElementVar(&resListe, 1600, inState1, 0);
  addResElementVar(&resListe, 1600, inState2, 0);
  addResElementVar(&resListe, 1600, inState3, 1);
  addResElementVar(&resListe, 1600, inState4, 1);
  addResElementVar(&resListe, 1600, inState5, 0);
  addResElementVar(&resListe, 1600, inState6, 0);

  addResElementVar(&resListe, 1600, counter, 2);






  /* Loop 7: History Test 2: Deep History */
  addSimElementTrig(&simListe, 1800, event1);
  addSimElementTrig(&simListe, 1900, key2);

  addSimElementTrig(&simListe, 2000, event6);

  /* History Test1 */

  addResElementVar(&resListe, 1900, inState0, 1);
  addResElementVar(&resListe, 1900, inState1, 0);
  addResElementVar(&resListe, 1900, inState2, 0);
  addResElementVar(&resListe, 1900, inState3, 1);
  addResElementVar(&resListe, 1900, inState4, 0);
  addResElementVar(&resListe, 1900, inState5, 1);
  addResElementVar(&resListe, 1900, inState6, 0);

  addResElementVar(&resListe, 1900, counter, 4);


  /* Testing self transition */
  addSimElementVar(&simListe, 2000, selfTrans, 0);
  addSimElementTrig(&simListe, 2100, event1);
  addSimElementTrig(&simListe, 2200, event4);

  addSimElementTrig(&simListe, 2300, event6);

  addResElementVar(&resListe, 2200, inState0, 1);
  addResElementVar(&resListe, 2200, inState1, 0);
  addResElementVar(&resListe, 2200, inState2, 0);
  addResElementVar(&resListe, 2200, inState3, 1);
  addResElementVar(&resListe, 2200, inState4, 0);
  addResElementVar(&resListe, 2200, inState5, 1);
  addResElementVar(&resListe, 2200, inState6, 0);

  addResElementVar(&resListe, 2000, selfTrans, 0);
  addResElementVar(&resListe, 2200, selfTrans, 2);

  /* Testing self transition on a state with nested states */
  addSimElementVar(&simListe, 2300, selfTrans, 0);
  addSimElementTrig(&simListe, 2400, event1);
  addSimElementTrig(&simListe, 2500, event7);

  addSimElementTrig(&simListe, 2700, event6);

  addResElementVar(&resListe, 2600, inState0, 1);
  addResElementVar(&resListe, 2600, inState1, 0);
  addResElementVar(&resListe, 2600, inState2, 0);
  addResElementVar(&resListe, 2600, inState3, 1);
  addResElementVar(&resListe, 2600, inState4, 1);
  addResElementVar(&resListe, 2600, inState5, 0);
  addResElementVar(&resListe, 2600, inState6, 0);

  addResElementVar(&resListe, 2400, selfTrans, 0);
  addResElementVar(&resListe, 2500, selfTrans, 1);


  /* carries the information, which state has been reached, and how often */
  for(i=0; i<st_HistoryTest_MAX; ++i)
	  statesCount[i] = 0;

  historyTest_init(&sMachine, &interfaceHandle);

  historyTest_Iface_cleanVariables(interfaceHandle);

  for(i=0; i<MAX_SIM_CYCLES; ++i) {

	  BOOL        stateMachineFinished = FALSE;

	  installChange(simListe, interfaceHandle,  sys_time());

	  historyTest_timerIface_trigger(sys_time());

	  while (stateMachineFinished == FALSE) {
 		stateMachineFinished = historyTest_runCycle(&sMachine);
 		historyTest_Iface_cleanInputTriggers(interfaceHandle);
	  }

	  compareResults(resListe, interfaceHandle, sys_time());

	  historyTest_Iface_cleanTriggers(interfaceHandle);

      statesCount[sMachine.state]++;

#ifdef DEBUG
      printf("\r  %d     ", i);
#endif

/*      printf(" %d ", *stateIDVar); */

      stepTime(10); /* add 10ms for the next cycle */
  }

  printf("\n\nFinished\n\n");

  for(i=0; i<st_HistoryTest_MAX; ++i) {
	  printf(" State No. %d   -> %d\n",i, statesCount[i]);
  }

  printStatistics(resListe);

  return(0);
}


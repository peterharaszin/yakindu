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
#include "guardTest.h"
#include "simElement.h"

uint64 faketime = 0;

uint64 sys_time()
{
  return(faketime);
}

uint64 stepTime(uint64 addtime)
{
	return(faketime += addtime);
}

#define MAX_SIM_CYCLES   20000
#define CYCLE_TIME_MS    10

int main()
{
  uint32 i;
  SM_guardTest_Handle      sMachine;
  GuardTest_IfaceHandle*   interfaceHandle=0;

  uint32                   statesCount[st_GuardTest_MAX];

  SimElement*          simListe = NULL;
  ResElement*          resListe = NULL;

  /* create some triggers */

  /* Loop 1: trigger1 is set and value is correct */
  addSimElementVar(&simListe, 100, gValue, 3);
  addSimElementVar(&simListe, 100, out, 0);
  addSimElementTrig(&simListe, 100, trigger1);

  /* back */
  addSimElementTrig(&simListe, 200, trigger4);

  addResElementVar(&resListe, 100, startState, 0);
  addResElementVar(&resListe, 100, state1, 1);
  addResElementVar(&resListe, 100, state2, 0);
  addResElementVar(&resListe, 100, state3, 0);
  addResElementVar(&resListe, 100, state4, 0);
  addResElementVar(&resListe, 100, state5, 0);
  addResElementVar(&resListe, 100, state6, 0);
  addResElementVar(&resListe, 100, out, 0);



  /* Loop 2: trigger1 is set value is 1 */
  addSimElementVar(&simListe, 300, gValue, 5);
  addSimElementVar(&simListe, 300, out, 0);
  addSimElementTrig(&simListe, 300, trigger1);

  /* back */
  addSimElementTrig(&simListe, 400, trigger4);

  addResElementVar(&resListe, 300, startState, 0);
  addResElementVar(&resListe, 300, state1, 0);
  addResElementVar(&resListe, 300, state2, 1);
  addResElementVar(&resListe, 300, state3, 0);
  addResElementVar(&resListe, 300, state4, 0);
  addResElementVar(&resListe, 300, state5, 0);
  addResElementVar(&resListe, 300, state6, 0);
  addResElementVar(&resListe, 300, out, 0);



  /* Loop 3: trigger1 is set, value is 1 */
  addSimElementVar(&simListe, 500, gValue, 1);
  addSimElementVar(&simListe, 500, out, 0);
  addSimElementTrig(&simListe, 500, trigger2);

  /* back */
  addSimElementTrig(&simListe, 600, trigger4);

  addResElementVar(&resListe, 500, startState, 0);
  addResElementVar(&resListe, 500, state1, 0);
  addResElementVar(&resListe, 500, state2, 0);
  addResElementVar(&resListe, 500, state3, 1);
  addResElementVar(&resListe, 500, state4, 0);
  addResElementVar(&resListe, 500, state5, 0);
  addResElementVar(&resListe, 500, state6, 0);
  addResElementVar(&resListe, 500, out, 4);


  /* Loop 4: trigger1 is set and value is correct */
  addSimElementVar(&simListe, 700, gValue, 3);
  addSimElementVar(&simListe, 700, out, 0);
  addSimElementTrig(&simListe, 700, trigger2);

  /* back */
  addSimElementTrig(&simListe, 800, trigger4);

  addResElementVar(&resListe, 700, startState, 0);
  addResElementVar(&resListe, 700, state1, 1);
  addResElementVar(&resListe, 700, state2, 0);
  addResElementVar(&resListe, 700, state3, 0);
  addResElementVar(&resListe, 700, state4, 0);
  addResElementVar(&resListe, 700, state5, 0);
  addResElementVar(&resListe, 700, state6, 0);
  addResElementVar(&resListe, 700, out, 1);



  /* Loop 5: trigger1 is set value is 1 */
  addSimElementVar(&simListe, 900, gValue, 5);
  addSimElementVar(&simListe, 900, out, 0);
  addSimElementTrig(&simListe, 900, trigger2);

  /* back */
  addSimElementTrig(&simListe, 1000, trigger4);

  addResElementVar(&resListe, 900, startState, 0);
  addResElementVar(&resListe, 900, state1, 0);
  addResElementVar(&resListe, 900, state2, 1);
  addResElementVar(&resListe, 900, state3, 0);
  addResElementVar(&resListe, 900, state4, 0);
  addResElementVar(&resListe, 900, state5, 0);
  addResElementVar(&resListe, 900, state6, 0);
  addResElementVar(&resListe, 900, out, 2);



  /* Loop 6: trigger1 is set, value is 1 */
  addSimElementVar(&simListe, 1100, gValue, 2);
  addSimElementVar(&simListe, 1100, out, 0);
  addSimElementTrig(&simListe, 1100, trigger3);

  /* back */
  addSimElementTrig(&simListe, 1200, trigger4);

  addResElementVar(&resListe, 1100, startState, 0);
  addResElementVar(&resListe, 1100, state1, 0);
  addResElementVar(&resListe, 1100, state2, 0);
  addResElementVar(&resListe, 1100, state3, 1);
  addResElementVar(&resListe, 1100, state4, 0);
  addResElementVar(&resListe, 1100, state5, 0);
  addResElementVar(&resListe, 1100, state6, 0);
  addResElementVar(&resListe, 1100, out, 3);



  /* Loop 7: Test for wrong triggers */
  addSimElementVar(&simListe, 1300, gValue, 0);
  addSimElementVar(&simListe, 1300, out, 0);
  addSimElementTrig(&simListe, 1300, trigger4);

  addResElementVar(&resListe, 1300, startState, 1);
  addResElementVar(&resListe, 1300, state1, 0);
  addResElementVar(&resListe, 1300, state2, 0);
  addResElementVar(&resListe, 1300, state3, 0);
  addResElementVar(&resListe, 1300, state4, 0);
  addResElementVar(&resListe, 1300, state5, 0);
  addResElementVar(&resListe, 1300, state6, 0);
  addResElementVar(&resListe, 1300, out, 0);



  /* Loop 8: Test for wrong triggers */
  addSimElementVar(&simListe, 1400, gValue, 0);
  addSimElementVar(&simListe, 1400, out, 0);
  addSimElementTrig(&simListe, 1400, trigger5);

  addResElementVar(&resListe, 1400, startState, 1);
  addResElementVar(&resListe, 1400, state1, 0);
  addResElementVar(&resListe, 1400, state2, 0);
  addResElementVar(&resListe, 1400, state3, 0);
  addResElementVar(&resListe, 1400, state4, 0);
  addResElementVar(&resListe, 1400, state5, 0);
  addResElementVar(&resListe, 1400, state6, 0);
  addResElementVar(&resListe, 1400, out, 0);


  /* Loop 9: Test for reachability of state4 */
  addSimElementVar(&simListe, 1600, value1, 11);
  addSimElementVar(&simListe, 1600, value2, 3);
  /* addSimElementTrig(&simListe, 1600, trigger1); */
  addSimElementTrig(&simListe, 1800, trigger4);

  addResElementVar(&resListe, 1700, startState, 0);
  addResElementVar(&resListe, 1700, state1, 0);
  addResElementVar(&resListe, 1700, state2, 0);
  addResElementVar(&resListe, 1700, state3, 0);
  addResElementVar(&resListe, 1700, state4, 1);
  addResElementVar(&resListe, 1700, state5, 0);
  addResElementVar(&resListe, 1700, state6, 0);

  /* does the state machine returns back after trigger */
  addResElementVar(&resListe, 1900, startState, 1);
  addResElementVar(&resListe, 1900, state1, 0);
  addResElementVar(&resListe, 1900, state2, 0);
  addResElementVar(&resListe, 1900, state3, 0);
  addResElementVar(&resListe, 1900, state4, 0);
  addResElementVar(&resListe, 1900, state5, 0);
  addResElementVar(&resListe, 1900, state6, 0);



  /* Loop 10: Test for unreachability of state4 */
  addSimElementVar(&simListe, 2000, value1, 10);
  addSimElementVar(&simListe, 2000, value2, 3);

  addResElementVar(&resListe, 2000, startState, 1);
  addResElementVar(&resListe, 2000, state1, 0);
  addResElementVar(&resListe, 2000, state2, 0);
  addResElementVar(&resListe, 2000, state3, 0);
  addResElementVar(&resListe, 2000, state4, 0);
  addResElementVar(&resListe, 2000, state5, 0);
  addResElementVar(&resListe, 2000, state6, 0);



  /* Loop 11: Test for unreachability of state4 */
  addSimElementVar(&simListe, 2100, value1, 11);
  addSimElementVar(&simListe, 2100, value2, 2);

  addResElementVar(&resListe, 2100, startState, 1);
  addResElementVar(&resListe, 2100, state1, 0);
  addResElementVar(&resListe, 2100, state2, 0);
  addResElementVar(&resListe, 2100, state3, 0);
  addResElementVar(&resListe, 2100, state4, 0);
  addResElementVar(&resListe, 2100, state5, 0);
  addResElementVar(&resListe, 2100, state6, 0);




  /* Loop 12: Test Choice first path ( value1 > 100 ) */
  addSimElementVar(&simListe, 2200, value1, 110);
  addSimElementVar(&simListe, 2200, value2, 10);

  addResElementVar(&resListe, 2200, startState, 0);
  addResElementVar(&resListe, 2200, state1, 0);
  addResElementVar(&resListe, 2200, state2, 0);
  addResElementVar(&resListe, 2200, state3, 0);
  addResElementVar(&resListe, 2200, state4, 0);
  addResElementVar(&resListe, 2200, state5, 1);
  addResElementVar(&resListe, 2200, state6, 0);




  /* Loop 13: Test for Junction back to state 1 */
  addSimElementTrig(&simListe, 2300, trigger4);
  addSimElementVar(&simListe, 2300, value2, 0); /* should not met the value again */

  addResElementVar(&resListe, 2300, startState, 1);
  addResElementVar(&resListe, 2300, state1, 0);
  addResElementVar(&resListe, 2300, state2, 0);
  addResElementVar(&resListe, 2300, state3, 0);
  addResElementVar(&resListe, 2300, state4, 0);
  addResElementVar(&resListe, 2300, state5, 0);
  addResElementVar(&resListe, 2300, state6, 0);




  /* Loop 12: Test Choice first path ( value1 < 100 ) */
  addSimElementVar(&simListe, 2400, value1, 80);
  addSimElementVar(&simListe, 2400, value2, 10);

  addResElementVar(&resListe, 2400, startState, 0);
  addResElementVar(&resListe, 2400, state1, 0);
  addResElementVar(&resListe, 2400, state2, 0);
  addResElementVar(&resListe, 2400, state3, 0);
  addResElementVar(&resListe, 2400, state4, 0);
  addResElementVar(&resListe, 2400, state5, 0);
  addResElementVar(&resListe, 2400, state6, 1);




  /* Loop 13: Test for Junction back to state 1 */
  addSimElementTrig(&simListe, 2500, trigger4);
  addSimElementVar(&simListe, 2500, value2, 0); /* should not met the value again */

  addResElementVar(&resListe, 2500, startState, 1);
  addResElementVar(&resListe, 2500, state1, 0);
  addResElementVar(&resListe, 2500, state2, 0);
  addResElementVar(&resListe, 2500, state3, 0);
  addResElementVar(&resListe, 2500, state4, 0);
  addResElementVar(&resListe, 2500, state5, 0);
  addResElementVar(&resListe, 2500, state6, 0);


  /* carries the information, which state has been reached, and how often */
  for(i=0; i<st_GuardTest_MAX; ++i)
	  statesCount[i] = 0;

  guardTest_init(&sMachine, &interfaceHandle);

  guardTest_Iface_cleanTriggers(interfaceHandle);
  guardTest_Iface_cleanVariables(interfaceHandle);


  for(i=0; i<MAX_SIM_CYCLES; ++i) {

	  BOOL        stateMachineFinished = FALSE;

	  installChange(simListe, interfaceHandle,  sys_time());

	  GuardTest_timerIface_trigger(sys_time());

	  while (stateMachineFinished == FALSE) {
 		  stateMachineFinished = guardTest_runCycle(&sMachine);
		  guardTest_Iface_cleanInputTriggers(interfaceHandle);
	  }

	  compareResults(resListe, interfaceHandle, sys_time());

	  guardTest_Iface_cleanTriggers(interfaceHandle);

      statesCount[sMachine.state]++;

#ifdef DEBUG
      printf("\r  %d     ", i);
#endif

/*      printf(" %d ", *stateIDVar); */

      stepTime(10); /* add 10ms for the next cycle */
  }

  printf("\n\nFinished\n\n");

  for(i=0; i<st_GuardTest_MAX; ++i) {
	  printf(" State No. %d   -> %d\n",i, statesCount[i]);
  }

  printStatistics(resListe);

  return(0);
}


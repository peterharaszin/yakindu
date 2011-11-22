/*
 * main.c
 *
 *  Created on: 16.11.2011
 *      Author: showcase
 */


#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include "Timer.h"
#include "DummyTimer.h"
#include "Test_HierarchyStatemachine.h"

/*@DTestSuite: Hierachy Statechart Test (Test_Hierarchy.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[6] = {"State1", "State2", "State3", "State4", "State5", "State6"};

void setupStatemachine(Test_HierarchyStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	eventPool_init_heap(eventPool, event_last, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_HierarchyStatemachine_init(machine, dummyTimer, eventPool);

}

void teardownStatemachine(Test_HierarchyStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	test_HierarchyStatemachine_exit(machine);
	timer_exit(dummyTimer);
	eventPool_exit(eventPool);

}

/*@Test: test_default_var1 test behavior of var1 in default interface */
int test_initialization()
{

	return 0;
}


/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int test_state9_state10_transition()
{
	Test_HierarchyStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: run the statechart for the first time (initially) */
	test_HierarchyStatemachine_runCycle(&machine);

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)]);
	assert( strcmp(stateName[statemachineBase_getState((StatemachineBase*)&machine, 0)], "State9") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int test_state1_state2_back_transition()
{
	Test_HierarchyStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: run an explicit cycle - without any waiting event (for initialization) */
	test_HierarchyStatemachine_runCycle(&machine);

	/*@Desc:  */


	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}






int main(int argc, char** argv)
{
	if (argc != 2)
		return -1;

	switch (atoi(argv[1])) {
	case 1:
		return test_state9_state10_transition();
	case 2:
		return test_state1_state2_back_transition();
	}

	return -1;

}

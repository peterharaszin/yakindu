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
#include "Test_ParallelRegionsStatemachine.h"

/*@DTestSuite: ParallelRegions Statechart Test (Test_ParallelRegions.sct) */

#define MAXEVENTSPERTYPE 4
const char* stateName[10] = {"State1", "State2", "State3", "State4", "State5", "State6", "State7", "State8", "State9", "noState"};
const int EnumTostateStr[10] = { _State1, _State2, _State3, _State4, _State5, _State6, _State7, _State8, _State9, last_state };

const char* getStateString(uint32_t index)
{
	int i;
	for (i=0; i<10; ++i)
		if (EnumTostateStr[i] == index)
			return stateName[i];
	return stateName[12];
}

void setupStatemachine(Test_ParallelRegionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_ParallelRegions_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_ParallelRegionsStatemachine_init(machine, dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_ParallelRegionsStatemachine_enter(machine);

}

void teardownStatemachine(Test_ParallelRegionsStatemachine* machine, Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_ParallelRegionsStatemachine_exit(machine);

	/* free all internal memory for this state machine */
	test_ParallelRegionsStatemachine_destruct(machine);

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: test_initialization test the initialization of the state vector */
int test_initialization()
{

	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "noState") == 0);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "noState") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}


/*@Test: test_state1_transition_event1 test the transition into Region1 and Region3 */
int test_state1_transition_event1()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "noState") == 0);

	/*@Desc: check the initial state at position 2 to be State7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State7") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state1_transition_and_back test behavior when jumping from state1 into parallel regions with state3 and 7 and from state3 back to state1 */
int test_state1_transition_and_back()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	/*@Desc: check the initial state at position 2 to be State7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State7") == 0);

	/*@Desc: raise event10 on default interface */
	test_ParallelRegions_if_raise_event10(&machine.interface);

	printf("run Cycle ..\n");

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "noState") == 0);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "noState") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state1_transition_and_back test behavior when jumping from state1 into parallel regions with state3 and 7 and from state3 back from state3 */
int test_state1_transition_and_back_from_state3()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	/*@Desc: check the initial state at position 2 to be State7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State7") == 0);

	/*@Desc: raise event9 on default interface */
	test_ParallelRegions_if_raise_event9(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "noState") == 0);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "noState") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state1_transition_and_back test behavior when jumping from state1 into parallel regions with state3 and 7 and from state7 back from state3 */
int test_state1_transition_and_back_from_state7()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	/*@Desc: check the initial state at position 2 to be State7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State7") == 0);

	/*@Desc: raise event9 on default interface */
	test_ParallelRegions_if_raise_event7(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "noState") == 0);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "noState") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state1_transition_to_State4 test the transition into Region2, Region3 and Region4 */
int test_state1_transition_to_State4()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: raise event2 on default interface */
	test_ParallelRegions_if_raise_event2(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State5 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State5") == 0);

	/*@Desc: check the initial state at position 1 to be State9 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "State9") == 0);

	/*@Desc: check the initial state at position 2 to be State7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State7") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_parallel_event3_handling_state5_state7 test event3 handling within state5 and event7 */
int test_parallel_event3_handling_state5_state7()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: raise event2 on default interface */
	test_ParallelRegions_if_raise_event2(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: raise event3 on default interface */
	test_ParallelRegions_if_raise_event3(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State6 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State6") == 0);

	/*@Desc: check the initial state at position 1 to be State9 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "State9") == 0);

	/*@Desc: check the initial state at position 2 to be State8 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State8") == 0);

	/*@Desc: teardown statemachine */
	teardownStatemachine(&machine, &dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_parallel_event3_handling_state5_state7 test event3 handling within state5 and event7 */
int test_preference_event3_leaving_state3_and_state7()
{
	Test_ParallelRegionsStatemachine machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&machine, &dummyTimer, &eventPool);

	/*@Desc: check the initial state at position 0 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: raise event1 on default interface */
	test_ParallelRegions_if_raise_event1(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check wether reg3 is set correctly to 7 */
	assert( test_ParallelRegions_if_get_reg3(&machine.interface) == 7);

	/*@Desc: check the initial state at position 0 to be State3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State3") == 0);

	/*@Desc: check the initial state at position 0 to be State7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "State7") == 0);

	/*@Desc: raise event3 on default interface */
	test_ParallelRegions_if_raise_event3(&machine.interface);

	/*@Desc: run an explicit cycle */
	test_ParallelRegionsStatemachine_runCycle(&machine);

	/*@Desc: check the initial state at position 0 to be State1 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 0)), "State1") == 0);

	/*@Desc: check the initial state at position 1 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 1)), "noState") == 0);

	/*@Desc: check the initial state at position 2 to be no State */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)&machine, 2)), "noState") == 0);

	/*@Desc: check wether reg3 is set correctly to -1 */
	assert( test_ParallelRegions_if_get_reg3(&machine.interface) == -1);

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
		return test_initialization();
	case 2:
		return test_state1_transition_event1();
	case 3:
		return test_state1_transition_and_back();
	case 4:
		return test_state1_transition_and_back_from_state3();
	case 5:
		return test_state1_transition_and_back_from_state7();
	case 6:
		return test_state1_transition_to_State4();
	case 7:
		return test_parallel_event3_handling_state5_state7();
	case 8:
		return test_preference_event3_leaving_state3_and_state7();
	}

	return -1;

}

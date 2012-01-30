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
const char* stateName[13] = {"State1", "State2", "State3", "State4", "State5", "State6", "State7", "State8", "State9", "State10", "State11", "State12", "none"};
const int EnumTostateStr[10] = { _State1, _State2, _State3, _State4, _State5, _State6, _State7, _State8, _State9, _State10 };

const char* getStateString(uint32_t index)
{
	int i;
	for (i=0; i<10; ++i)
		if (EnumTostateStr[i] == index)
			return stateName[i];
	return stateName[12];
}

void setupStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* set up dummy Timer */
	dummyTimer_init(dummyTimer);

	/* Set up Event Pool */
	test_Hierarchy_eventPool_init_heap(eventPool, MAXEVENTSPERTYPE);

	/* initialize state machine */
	test_HierarchyStatemachine_init(dummyTimer, eventPool);

	/* call all necessary enter functions */
	test_HierarchyStatemachine_enter();

}

void teardownStatemachine(Timer* dummyTimer, EventPool* eventPool)
{
	/* call all exit actions for this state machine */
	test_HierarchyStatemachine_exit();

	/* free all internal memory for this state machine */
	test_HierarchyStatemachine_destruct();

	/* free the timer */
	timer_exit(dummyTimer);

	/* free all events in the event pool */
	eventPool_exit(eventPool);

}

/*@Test: test_state9_state10_transition test behavior of var1 in default and other interface */
int test_state9_state10_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is still in initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event9 on default interface */
	test_Hierarchy_if_raise_event9();

	/*@Desc: run the statechart to trigger state change */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State10") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event10 on default interface */
	test_Hierarchy_if_raise_event10();

	/*@Desc: run the statechart to trigger state change */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state1_state2_back_transition test of event1 raised on default interface to enter state 3 */
int test_state1_state2_back_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 2 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event6 on default interface */
	test_Hierarchy_if_raise_event6();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_state1_state2_back_transition test of event1 raised on default interface to enter state 3 */
int test_state1_state2_back_with_event14_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 2 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event6 on default interface */
	test_Hierarchy_if_raise_event14();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}


/*@Test: test_traverse_to_State5_back_with_event6_transition tests whether transition to state5 and back to state9 works correct */
int test_traverse_to_State5_back_with_event6_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: raise event2 on default interface */
	test_Hierarchy_if_raise_event2();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State5") == 0);


	/*@Desc: check whether s2 is set to 3 as State 5 is in third hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 3 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event6 on default interface */
	test_Hierarchy_if_raise_event6();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	printf( " s2 = %d\n", test_Hierarchy_if_get_s2());
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}


/*@Test: test_default_var1 test behavior of var1 in default and other interface */
int test_traverse_to_State5_back_with_event15_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: raise event2 on default interface */
	test_Hierarchy_if_raise_event2();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State5") == 0);


	/*@Desc: check whether s2 is set to 3 as State 5 is in third hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 3 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event6 on default interface */
	test_Hierarchy_if_raise_event15();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State10") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	printf( " s2 = %d\n", test_Hierarchy_if_get_s2());
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_traverse_to_State7_back_with_event6_transition tests whether transition to state7 and back to state9 works correct */
int test_traverse_to_State7_back_with_event6_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: raise event2 on default interface */
	test_Hierarchy_if_raise_event2();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state5 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State5") == 0);

	/*@Desc: raise event2 on default interface */
	test_Hierarchy_if_raise_event3();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State7") == 0);

	/*@Desc: check whether s2 is set to 3 as State 7 is in 4th hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 4 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event6 on default interface */
	test_Hierarchy_if_raise_event6();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state9 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	printf( " s2 = %d\n", test_Hierarchy_if_get_s2());
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_traverse_to_State8_back_with_event6_transition tests whether transition to state8 and back to state9 works correct */
int test_traverse_to_State8_back_with_event6_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: raise event2 on default interface */
	test_Hierarchy_if_raise_event2();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state5 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State5") == 0);

	/*@Desc: raise event3 on default interface */
	test_Hierarchy_if_raise_event3();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State7") == 0);

	/*@Desc: raise event4 on default interface */
	test_Hierarchy_if_raise_event4();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state8 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State8") == 0);

	/*@Desc: check whether s2 is set to 3 as State 7 is in 4th hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 4 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event6 on default interface */
	test_Hierarchy_if_raise_event6();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state9 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	printf( " s2 = %d\n", test_Hierarchy_if_get_s2());
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

	return 0;
}

/*@Test: test_traverse_to_State8_back_with_event16_transition tests whether transition to state8 and back to state10 works correct */
int test_traverse_to_State8_back_with_event16_transition()
{
	Test_HierarchyStatemachine* machine;
	Timer dummyTimer;
	EventPool eventPool;

	/*@Desc: setup initial statemachine */
	setupStatemachine(&dummyTimer, &eventPool);

	/* get the handle only for getting the state name */
	machine = test_Hierarchy_get_handle();

	/*@Desc: check wether state is initial state (State9) */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State9") == 0);

	/*@Desc: check whether s1 is set to 2 as State 9 is in second hierarchy level */
	assert( test_Hierarchy_if_get_s1() == 2 );

	/*@Desc: raise event1 on default interface */
	test_Hierarchy_if_raise_event1();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state3 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State3") == 0);

	/*@Desc: raise event2 on default interface */
	test_Hierarchy_if_raise_event2();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state5 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State5") == 0);

	/*@Desc: raise event3 on default interface */
	test_Hierarchy_if_raise_event3();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state7 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State7") == 0);

	/*@Desc: raise event4 on default interface */
	test_Hierarchy_if_raise_event4();

	/*@Desc: run the statechart cycle */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state8 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State8") == 0);

	/*@Desc: check whether s2 is set to 3 as State 7 is in 4th hierarchy level */
	assert( test_Hierarchy_if_get_s2() == 4 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 0 );

	/*@Desc: raise event16 on default interface */
	test_Hierarchy_if_raise_event16();

	/*@Desc: run the statechart for the first time (just as dummy) */
	test_HierarchyStatemachine_runCycle();

	/*@Desc: check wether state is changed  to state10 */
	printf("%s\n", getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)));
	assert( strcmp(getStateString(statemachineBase_getState((StatemachineBase*)machine, 0)), "State10") == 0);

	/*@Desc: check whether s2 is set to 2 as State 3 is in second hierarchy level */
	printf( " s2 = %d\n", test_Hierarchy_if_get_s2());
	assert( test_Hierarchy_if_get_s2() == 0 );

	/*@Desc: check whether s1 is set to 0 as State 1 has been left */
	printf( " s1 = %d\n", test_Hierarchy_if_get_s1());
	assert( test_Hierarchy_if_get_s1() == 2 );


	/*@Desc: teardown statemachine */
	teardownStatemachine(&dummyTimer, &eventPool);

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
	case 3:
		return test_traverse_to_State5_back_with_event6_transition();
	case 4:
		return test_traverse_to_State5_back_with_event15_transition();
	case 5:
		return test_state1_state2_back_with_event14_transition();
	case 6:
		return test_traverse_to_State7_back_with_event6_transition();
	case 7:
		return test_traverse_to_State8_back_with_event6_transition();
	case 8:
		return test_traverse_to_State8_back_with_event16_transition();
	}


	return -1;

}

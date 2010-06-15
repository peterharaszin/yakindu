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
#include "afterTest.h"

#include <test-dept.h>

void specialInit(AfterTest_Handle* handle, AfterTest_StateType state)
{
	afterTest_init(handle);

	handle->state = state;
}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with the run to completion ability

This test set the state to st_afterTest_State3 and runs sm_afterTest_runCycle(). It is expected, that
at the first run the function returns FALSE to indicate that the statemachine has not entered a stable
state. As there is a unconditioned transition to state 1. This state is reached after the first run.
Therefor the variable st is set to 1. The variable waitTime is not touched in any kind, as the state 3
is not entered, nor is state 4 entered.

The second call of the function sm_afterTest_runCycle() returns TRUE, as there is no trigger for
a transition.
*/
void test_sm_afterTest_runCycle_inState3_RTC()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    /* run the state machine loop -> the state machine should be finished
       Return value is TRUE */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* run the state machine loop -> the state machine should be finished
       Return value is TRUE */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Testing for state machine behavior when trigger1 is raised

The test expects that state 3 is left to reach state 1 independent of the trigger, that is set.
As the trigger is not used for the transition. It is still set after the call to runCycle().

Furthermore the variable st is set to 1 and the variable waitTime is not touched.
*/
void test_sm_afterTest_runCycle_inState3_trigger1()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger1);

    /* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Testing for state machine behavior when trigger2 is raised

The test expects that state 3 is left to reach state 1 independent of the trigger, that is set.
As the trigger is not used for the transition. It is still set after the call to runCycle().

Furthermore the variable st is set to 1 and the variable waitTime is not touched.
*/
void test_sm_afterTest_runCycle_inState3_trigger2()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger2);

    /* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}


/**
#TEST: Testing for state machine behavior when key1 is raised

The test expects that state 3 is left to reach state 1 independent of the trigger, that is set.
As the trigger is not used for the transition. It is still set after the call to runCycle().

This test does not delete the trigger, therefore the state 1 is not the final state of this run, as key1 is the
Entry trigger for state 3 again, in case the variable waitTime is set to less 2000, what is true. State 3 is
therefore entered a second time and is left again due to the unconditioned transition.

Furthermore the variable st is set to 1 and the variable waitTime is set to 100.
*/
void test_sm_afterTest_runCycle_inState3_key1_uncleared()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key1);

    /* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));


	/* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State3, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));


    /* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));


	/* at this point, the run has not completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));
}

/**
#TEST: Testing for state machine behavior when key1 is raised and triggers are cleared after a call to runCycle()

The test expects that state 3 is left to reach state 1 independent of the trigger, that is set.
As the trigger is not used for the transition, it is still set after the call to runCycle(). However
all triggers are reseted after the call, a transition back to state 3 does not take place.

For that reason the variable st is set to 1 and the variable waitTime is set to 0 after the run to completion.
*/
void test_sm_afterTest_runCycle_inState3_key1_cleared()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key1);

    /* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

	afterTest_cleanUnusedTriggers(&handle);

	/* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Testing for state machine behavior when key2 is raised

The test expects that state 3 is left to reach state 1 independent of the trigger, that is set.
As the trigger is not used for the transition. It is still set after the call to runCycle().

Furthermore the variable st is set to 1 and the variable waitTime is not touched.

As the variable waitTime is smaller than 200, the transition to state 4 does not take place.
*/
void test_sm_afterTest_runCycle_inState3_key2()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key2);

    /* at this point, the run has not completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* at this point, the run has not completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));
}

/**
#TEST: Testing for state machine behavior when the timer is raised

The test expects that state 3 is left to reach state 1 independent of the trigger, that is set.
As the trigger is not used for the transition. It is still set after the call to runCycle().

Furthermore the variable st is set to 1 and the variable waitTime is not touched.

This Test is dangerous, as in a normal behavior the timer trigger will never be raised in state 3.
Therefore the whole behavior here is very strange. This test doesn't run to completion.
*/
void test_sm_afterTest_runCycle_inState3_timer1()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State3);

    afterTest_Iface_raiseTrigger(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1);

    /* at this point, the run has not been completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* at this point, the run has not been completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State2, handle.state);
	assert_equals(2, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

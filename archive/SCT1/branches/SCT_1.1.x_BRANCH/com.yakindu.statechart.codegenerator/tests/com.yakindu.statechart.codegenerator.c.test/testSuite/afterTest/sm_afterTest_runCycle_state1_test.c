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

This test set the state to st_afterTest_State1 and runs sm_afterTest_runCycle(). It is expected, that
the function returns TRUE to indicate that the statemachine entered a stable state. As the actual
state is state1 and there is actually no event given, the actual state is stable.
*/
void test_sm_afterTest_runCycle_inState1_RTC()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    /* run the state machine loop -> the state machine should be finished
       Return value is TRUE */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with trigger1 raised.

This test set the state to st_afterTest_State1, raises trigger1 and runs sm_afterTest_runCycle().
It is expected, that the trigger1 keeps raised, as it is not consumed and that state does not change.
Therfore the runCycle function returns TRUE to indicate that the statemachine entered a stable state.
As the state is state1 and there is actually no event given to trigger a transition.
*/
void test_sm_afterTest_runCycle_inState1_trigger1()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger1);

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with trigger1 raised.

This test set the state to st_afterTest_State1, raises trigger2 and runs sm_afterTest_runCycle().
It is expected, that the trigger2 keeps raised, as it is not consumed and that state does not change.
Therfore the runCycle function returns TRUE to indicate that the statemachine entered a stable state.
As the state is state1 and there is actually no event given to trigger a transition.
*/
void test_sm_afterTest_runCycle_inState1_trigger2()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 3 Fireing Event 'trigger2' in state 1 */
    /**********************************************************/
    /*DESCRIPTION: This should not harm the process at all, the state should keep the same*/

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger2);

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with key1 raised and variable waitTime is equal 2000.

This test set the state to st_afterTest_State1, raises key1 and runs sm_afterTest_runCycle().
It is expected that the key1 keeps raised, as it is not consumed and that state does not change.
Therfore the runCycle function returns TRUE to indicate that the statemachine entered a stable state.
As the state is state1 and there is actually no event given to trigger a transition.
*/
void test_sm_afterTest_runCycle_inState1T_key1_waitTime_eq_2000()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key1);
	handle.ihandle.waitTime = 2000;

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(2000, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with key1 raised and variable waitTime set smaller than 2000

This test set the state to st_afterTest_State1, raises key1 and runs sm_afterTest_runCycle().
It is expected, that the key1 is resetted, as it is consumed and that state changes to state3.

In this test it is also tested, if the run to completion works correctly. It is expected, that the
first call to runCycle returns FALSE, as the state may not be stable. During the entrence the variable
waitTime is incremented by 100.

The next call to runCycle explores the unconditioned transition back to state1 and follows that transition.
It is expected, that the state changes back to state 1 and the entry action, which changes the variable st to one is executed. As the state may still change, the return value of runCycle is set to FALSE.

The third call to runCycle returns TRUE, as there is no transition found to be taken.
*/
void test_sm_afterTest_runCycle_inState1_waitTime_st_2000()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key1);
	handle.ihandle.waitTime = 1000;

    /* at this point, the run has completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State3, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(1100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* at this point, the run has completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(1100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_getVar_st(&handle));
	assert_equals(1100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with key2 raised and variable waitTime is smaller than 200.

This test set the state to st_afterTest_State1, raises key2, set variable waitTime to 100 and runs sm_afterTest_runCycle().
It is expected that the key2 keeps raised, as it is not consumed and that state does not change.
Therfore the runCycle function returns TRUE to indicate that the statemachine entered a stable state.
As the state is state1 and there is actually no event given to trigger a transition.
*/
void test_sm_afterTest_runCycle_inState1_key2_waitTime_st_200()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key2);
	handle.ihandle.waitTime = 100;

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(100, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with key2 raised and variable waitTime set greater than 200.

This test set the state to st_afterTest_State1, raises key1 and runs sm_afterTest_runCycle().
It is expected, that the key1 is resetted, as it is consumed and that state changes to state3.

In this test it is also tested, if the run to completion works correctly. It is expected, that the
first call to runCycle returns FALSE, as the state may not be stable. During the entrence the variable
waitTime is incremented by 100.

The next call to runCycle explores the unconditioned transition back to state1 and follows that transition.
It is expected, that the state changes back to state 1 and the entry action, which changes the variable st to one is executed. As the state may still change, the return value of runCycle is set to FALSE.

The third call to runCycle returns TRUE, as there is no transition found to be taken.
*/
void test_sm_afterTest_runCycle_inState1_key2_waitTime_gt_200()
{
	AfterTest_Handle handle;

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key2);
	handle.ihandle.waitTime = 300;

    /* at this point, the run has completed */
    assert_equals(FALSE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State4, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(200, afterTest_getVar_waitTime(&handle));
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
	assert_equals(200, afterTest_getVar_waitTime(&handle));
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
	assert_equals(200, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));


}

/**
#TEST: Test for the validation of function sm_afterTest_runCycle() with timer raised.

This test set the state to st_afterTest_State1, raises the timer event and runs sm_afterTest_runCycle().
It is expected that the the timer Event is resetted, as it is consumed and that the state changes to state2.
While entering state2, the variable st is set to 2.

As with runCycle the state machine enters a new state. In this new state, the transition conditions must be checked as well. Therefor the runCycle function returns FALSE.

The second call to runCycle does not change anything as there is no event available triggering a transition. Therefor the function returns TRUE and the trigger and variable information keep the same.
*/
void test_sm_afterTest_runCycle_inState1_timer1()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 6 Fireing Event 'timer_afterTest_State1_TO_afterTest_State2_P1' in state initial */
    /***********************************************************************************************/
    /*DESCRIBTION: This tests the time triggered transition to state 2 */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State1);

    afterTest_Iface_raiseTrigger(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1);

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

    /* at this point, the run has not been completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

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

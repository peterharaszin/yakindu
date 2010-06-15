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

void test_sm_afterTest_runCycle_inState2_RTC()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 1 Run to Completion */
    /**********************************/
    /*DESCRIPTION: If there is no event given, the state 1 should not be left */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    /* run the state machine loop -> the state machine should be finished
       Return value is TRUE */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State2, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

void test_sm_afterTest_runCycle_inState2_trigger1()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 2 Fireing Event 'trigger1' in state 2 */
    /*******************************************************************/
    /*DESCRIPTION: This should not harm the process at all, the state should keep the same */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger1);

    /* at this point, the run has not completed */
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

void test_sm_afterTest_runCycle_inState2_trigger2()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 3 Fireing Event 'trigger2' in state 2 */
    /**********************************************************/
    /*DESCRIPTION: This should not harm the process at all, the state should keep the same*/

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger2);

    /* at this point, the run has not completed */
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

void test_sm_afterTest_runCycle_inState2_trigger1_trigger2()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 3 Fireing Event 'trigger2 and trigger1' in state 2 */
    /**********************************************************/
    /*DESCRIPTION: This should not harm the process at all, the state should keep the same*/

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger1);
    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger2);

    /* at this point, the run has completed */
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

void test_sm_afterTest_runCycle_inState2_key1()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 5 Fireing Event 'key1' in state 2 */
    /**********************************************************/
    /*DESCRIPTION: This test keeps track if the state machine identifies the transition to state3
     and back (as the state 3 imeditately returns to state 1) */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key1);

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State2, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

void test_sm_afterTest_runCycle_inState2_key2()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 6 Fireing Event 'key2' in state 2 */
    /**********************************************************/
    /*DESCRIPTION: This should not harm the process at all, as there is no transition listening
      on that trigger */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key2);

    /* at this point, the run has completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State2, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

void test_sm_afterTest_runCycle_inState2_timer1()
{
	AfterTest_Handle handle;

    /*TESTPART: Test Phase 6 Fireing Event 'timer_afterTest_State1_TO_afterTest_State2_P1' in state initial */
    /***********************************************************************************************/
    /*DESCRIBTION: This tests the time triggered transition to state 2 */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_State2);

    afterTest_Iface_raiseTrigger(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1);

    /* at this point, the run has not been completed */
    assert_equals(TRUE, sm_afterTest_runCycle(&handle.startHandle));

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State2, handle.state);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(TRUE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

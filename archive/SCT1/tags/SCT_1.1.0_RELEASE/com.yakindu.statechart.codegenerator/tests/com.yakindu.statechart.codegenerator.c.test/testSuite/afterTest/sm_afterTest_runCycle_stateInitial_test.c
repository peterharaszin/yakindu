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

void test_afterTest_runCycle_inStateInitial_RTC()
{
	AfterTest_Handle handle;

    /* Test Phase 1 Run to Completion */
    /**********************************/

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_Initial);

    /* run the state machine loop -> the state machine should not finish
       return value is FALSE, as the run is not completed */
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

void test_afterTest_runCycle_inStateInitial_trigger1()
{
	AfterTest_Handle handle;

    /* Test Phase 2 Fireing Event 'trigger1' in state initial */
    /**********************************************************/
    /* This should not harm the process at all, but the transition to state 1 should take place */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_Initial);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger1);

    /* at this point, the run has completed */
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


}
void test_afterTest_runCycle_inStateInitial_trigger2()
{
	AfterTest_Handle handle;

    /* Test Phase 3 Fireing Event 'trigger2' in state initial */
    /**********************************************************/
    /* This should not harm the process at all, but the transition to state 1 should take place */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_Initial);

    afterTest_Iface_raiseTrigger(&handle.ihandle, trigger2);

    /* at this point, the run has completed */
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

}

void test_afterTest_runCycle_inStateInitial_key1()
{
	AfterTest_Handle handle;

    /* Test Phase 4 Fireing Event 'key1' in state initial */
    /**********************************************************/
    /* This should not harm the process at all, but the transition to state 1 should take place */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_Initial);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key1);

    /* at this point, the run has completed */
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

}
void test_afterTest_runCycle_inStateInitial_key2()
{
	AfterTest_Handle handle;

    /* Test Phase 5 Fireing Event 'key2' in state initial */
    /**********************************************************/
    /* This should not harm the process at all, but the transition to state 1 should take place */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_Initial);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key2);

    /* at this point, the run has completed */
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

}

void test_afterTest_runCycle_inStateInitial_timer1()
{
	AfterTest_Handle handle;

    /* Test Phase 6 Fireing Event 'timer_afterTest_State1_TO_afterTest_State2_P1' in state initial */
    /***********************************************************************************************/
    /* This is very unlikely, however it should be tested */

    /* Initialize once and follow the different stages */
    specialInit(&handle, st_afterTest_Initial);

    afterTest_Iface_raiseTrigger(&handle.ihandle, key2);

    /* at this point, the run has completed */
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

}

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
#TEST: Test for the validation of function sm_afterTest_exit() with initial as the actual state

This test set the state to st_afterTest_Initial and runs sm_afterTest_exit.
For validation the variables and triggers arfe tested against the expected values.
*/
void test_afterTest_exit_in_intial()
{
    AfterTest_Handle handle;
    AfterTest_StateType oldState;

    /* Test for Initial state */
    /********************/
    specialInit(&handle, st_afterTest_State4);

    oldState = st_afterTest_Initial;

    /* run the function in question */
	sm_afterTest_exit(&handle.startHandle, oldState);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State4, handle.state);
	assert_equals(st_afterTest_Initial, oldState);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_exit() with state1 as the actual state

This test set the state to st_afterTest_State1 and runs sm_afterTest_exit.
For validation the variables and triggers are tested against the expected values.
*/
void test_afterTest_exit_in_state1()
{
	AfterTest_Handle handle;
    AfterTest_StateType oldState;

    /* Test for State 1 */
    /********************/
    specialInit(&handle, st_afterTest_State4);

    oldState = st_afterTest_State1;

    /* run the function in question */
	sm_afterTest_exit(&handle.startHandle, oldState);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State4, handle.state);
	assert_equals(st_afterTest_State1, oldState);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_exit() with state2 as the actual state

This test set the state to st_afterTest_State2 and runs sm_afterTest_exit.
For validation the variables and triggers are tested against the expected values.
*/
void test_afterTest_exit_in_state2()
{
	AfterTest_Handle handle;
    AfterTest_StateType oldState;

    /* Test for State 2 */
    /********************/
    specialInit(&handle, st_afterTest_State4);

    oldState = st_afterTest_State2;

    /* run the function in question */
	sm_afterTest_exit(&handle.startHandle, oldState);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State4, handle.state);
	assert_equals(st_afterTest_State2, oldState);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_exit() with state3 as the actual state

This test set the state to st_afterTest_State3 and runs sm_afterTest_exit.
For validation the variables and triggers are tested against the expected values.
*/
void test_afterTest_exit_in_state3()
{
	AfterTest_Handle handle;
    AfterTest_StateType oldState;

    /* Test for State 3 */
    /********************/
    specialInit(&handle, st_afterTest_State4);

    oldState = st_afterTest_State3;

    /* run the function in question */
	sm_afterTest_exit(&handle.startHandle, oldState);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State4, handle.state);
	assert_equals(st_afterTest_State3, oldState);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_exit() with state4 as the actual state

This test set the state to st_afterTest_State4 and runs sm_afterTest_exit.
For validation the variables and triggers are tested against the expected values.
*/
void test_afterTest_exit_in_state4()
{

	AfterTest_Handle handle;
    AfterTest_StateType oldState;

	/* Test for State 4 */
    /********************/
    specialInit(&handle, st_afterTest_State1);

    oldState = st_afterTest_State4;

    /* run the function in question */
	sm_afterTest_exit(&handle.startHandle, oldState);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(st_afterTest_State4, oldState);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST: Test for the validation of function sm_afterTest_exit() with wrong state as the actual state

This test set the state to st_AfterTest_MAX and runs sm_afterTest_exit.
For validation the variables and triggers are tested against the expected values.
*/
void test_afterTest_exit_in_state5()
{
	AfterTest_Handle handle;
    AfterTest_StateType oldState;

	/* Test for wrong State */
    /************************/
    specialInit(&handle, st_afterTest_State1);

    oldState = st_AfterTest_MAX;

    /* run the function in question */
	sm_afterTest_exit(&handle.startHandle, oldState);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(st_AfterTest_MAX, oldState);
	assert_equals(0, afterTest_getVar_st(&handle));
	assert_equals(0, afterTest_getVar_waitTime(&handle));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));


}

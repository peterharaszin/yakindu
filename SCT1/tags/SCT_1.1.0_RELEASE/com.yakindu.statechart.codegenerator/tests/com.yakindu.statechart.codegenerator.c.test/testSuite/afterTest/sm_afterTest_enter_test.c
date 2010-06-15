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

void specialInit(afterTest_Handle* handle, AfterTest_StateType state)
{
	afterTest_init(rhandle);

	handle->state = state;
}

/**
#TEST: Test for the validation of function sm_afterTest_enter() with initial as the actual state

This test set the state to st_afterTest_Initial and runs sm_afterTest_enter.
For validation the variables and triggers are tested against the expected values.
*/
void test_sm_afterTest_enter_in_initial()
{
	afterTest_Handle handle;

    /* Test for initial */
    /********************/
	specialInit(&handle, st_afterTest_Initial);

    /* run the function in question */
	sm_afterTest_enter(&handle);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_Initial, handle.state);
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, st));
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, waitTime));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST:Test for the validation of function sm_afterTest_enter() with state1 as the actual state

This test set the state to st_afterTest_State1 and runs sm_afterTest_enter.
For validation the variables and triggers are tested against the expected values.
*/
void test_sm_afterTest_enter_in_state1()
{
	SM_afterTest_Handle handle;

    /* Test for state 1 */
    /********************/
	specialInit(&handle, st_afterTest_State1);

    /* run the function in question */
	sm_afterTest_enter(&handle.startHandle);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State1, handle.state);
	assert_equals(1, afterTest_Iface_getVariable(&handle.ihandle, st));
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, waitTime));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST:Test for the validation of function sm_afterTest_enter() with state2 as the actual state

This test set the state to st_afterTest_State2 and runs sm_afterTest_enter.
For validation the variables and triggers are tested against the expected values.
*/
void test_sm_afterTest_enter_in_state2()
{
	SM_afterTest_Handle handle;

    /* Test for state 2 */
    /********************/
    specialInit(&handle, st_afterTest_State2);

    /* run the function in question */
	sm_afterTest_enter(&handle.startHandle);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State2, handle.state);
	assert_equals(2, afterTest_Iface_getVariable(&handle.ihandle, st));
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, waitTime));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST:Test for the validation of function sm_afterTest_enter() with state3 as the actual state

This test set the state to st_afterTest_State3 and runs sm_afterTest_enter.
For validation the variables and triggers are tested against the expected values.
*/
void test_sm_afterTest_enter_in_state3()
{
	SM_afterTest_Handle handle;

    /* Test for state 3 */
    /********************/
    specialInit(&handle, st_afterTest_State3);

    /* run the function in question */
	sm_afterTest_enter(&handle.startHandle);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State3, handle.state);
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, st));
	assert_equals(100, afterTest_Iface_getVariable(&handle.ihandle, waitTime));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST:Test for the validation of function sm_afterTest_enter() with state4 as the actual state

This test set the state to st_afterTest_State4 and runs sm_afterTest_enter.
For validation the variables and triggers are tested against the expected values.
*/
void test_sm_afterTest_enter_in_state4()
{
	SM_afterTest_Handle handle;

    /* Test for state 4 */
    /********************/
    specialInit(&handle, st_afterTest_State4);

    afterTest_Iface_setVariable(&handle.ihandle, waitTime, 500);

    /* run the function in question */
	sm_afterTest_enter(&handle.startHandle);

	/* test the results, state, all variables and all triggers */
	assert_equals(st_afterTest_State4, handle.state);
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, st));
	assert_equals(400, afterTest_Iface_getVariable(&handle.ihandle, waitTime));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}

/**
#TEST:Test for the validation of function sm_afterTest_enter() with a wrong stateID(stateMax) as the actual state

This test set the state to stateMax and runs sm_afterTest_enter.
For validation the variables and triggers are tested against the expected values. The actual state should be set
to st_afterTest_Initial
*/
void test_sm_afterTest_enter_in_wrongState()
{
	SM_afterTest_Handle handle;

    /* Test for wrong state */
    /************************/
    specialInit(&handle, st_AfterTest_MAX);

    /* run the function in question */
	sm_afterTest_enter(&handle.startHandle);

	/* test the results, state, all variables and all triggers */
	//assert_equals(st_afterTest_Initial, handle.state);
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, st));
	assert_equals(0, afterTest_Iface_getVariable(&handle.ihandle, waitTime));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, trigger2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key1));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, key2));
	assert_equals(FALSE, afterTest_Iface_isTriggerRaised(&handle.ihandle, timer_afterTest_State1_TO_afterTest_State2_P1));

}


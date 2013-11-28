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
 * afterTest.c
 *
 *  Created on: Apr 7, 2009
 *      Author: seger
 */

#include "afterTest.h"

#include <test-dept.h>

void specialInit(SM_afterTest_Handle* rhandle, AfterTest_StateType state) 
{
	AfterTest_IfaceHandle* iface;
	afterTest_init(rhandle, &iface);

	rhandle->state = state;
}

void test_isIn_afterTest()
{
	/* function under test */
	assert_equals(TRUE, isIn_afterTest(st_afterTest_State1));
	assert_equals(TRUE, isIn_afterTest(st_afterTest_State2));
	assert_equals(TRUE, isIn_afterTest(st_afterTest_State3));
	assert_equals(TRUE, isIn_afterTest(st_afterTest_Initial));
	assert_equals(TRUE, isIn_afterTest(st_afterTest_State4));
	assert_equals(FALSE, isIn_afterTest(stateMax));

}


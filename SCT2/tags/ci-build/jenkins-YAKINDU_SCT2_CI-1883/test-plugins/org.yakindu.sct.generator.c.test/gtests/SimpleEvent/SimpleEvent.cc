/**
* Copyright (c) 2013 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "SimpleEvent.h"

TEST(StatemachineTest, simpleEventTest) {
	SimpleEvent handle;
	simpleEvent_init(&handle);
	simpleEvent_enter(&handle);
	EXPECT_TRUE(simpleEvent_isActive(&handle, SimpleEvent_main_region_A));
	EXPECT_TRUE(5== 5);
	simpleEventIface_raise_event1(&handle);
	simpleEvent_runCycle(&handle);
	EXPECT_TRUE(simpleEvent_isActive(&handle, SimpleEvent_main_region_B));
}

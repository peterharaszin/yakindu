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
#include "ShallowHistory.h"

TEST(StatemachineTest, shallowHistoryTest) {
	ShallowHistory* statechart = new ShallowHistory();
	statechart->init();
	statechart->enter();
	statechart->raise_event1();
	statechart->runCycle();
	statechart->raise_event3();
	statechart->runCycle();
	statechart->raise_event5();
	statechart->runCycle();
	statechart->raise_event7();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State1));
	EXPECT_TRUE(statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	statechart->raise_event6();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	statechart->raise_event5();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8));
	EXPECT_TRUE(statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	statechart->raise_event2();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State1));
	statechart->raise_event1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(!statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State1));
	statechart->raise_event5();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(statechart->isActive(ShallowHistory::ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	delete statechart;
}

/**
* Copyright (c) 2014 committers of YAKINDU and others.
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
#include "EntryExitSelfTransition.h"

TEST(StatemachineTest, SelfTransitionToChildState) {
	EntryExitSelfTransition* statechart = new EntryExitSelfTransition();
	statechart->init();
	statechart->enter();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->get_entries()== 1);
	EXPECT_TRUE(statechart->isActive(EntryExitSelfTransition::B));
	statechart->getSCInterface()->set_entries(0);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->get_entries()== 1);
	EXPECT_TRUE(statechart->getSCInterface()->get_exits()== 1);
	EXPECT_TRUE(statechart->isActive(EntryExitSelfTransition::C));
	delete statechart;
}
TEST(StatemachineTest, SelfTransitionFromChildState) {
	EntryExitSelfTransition* statechart = new EntryExitSelfTransition();
	statechart->init();
	statechart->enter();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->get_entries()== 1);
	statechart->getSCInterface()->set_entries(0);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->get_entries()== 0);
	EXPECT_TRUE(statechart->getSCInterface()->get_exits()== 0);
	EXPECT_TRUE(statechart->isActive(EntryExitSelfTransition::C));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(EntryExitSelfTransition::B));
	EXPECT_TRUE(statechart->getSCInterface()->get_entries()== 1);
	EXPECT_TRUE(statechart->getSCInterface()->get_exits()== 1);
	delete statechart;
}

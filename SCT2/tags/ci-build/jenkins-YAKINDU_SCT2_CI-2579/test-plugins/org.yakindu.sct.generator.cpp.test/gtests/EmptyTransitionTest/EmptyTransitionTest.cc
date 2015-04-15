/**
* Copyright (c) 2015 committers of YAKINDU and others.
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
#include "EmptyTransition.h"

TEST(StatemachineTest, EmptyTransitionTest) {
	EmptyTransition* statechart = new EmptyTransition();
	statechart->init();
	statechart->enter();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(EmptyTransition::main_region_B));
	EXPECT_TRUE(statechart->isActive(EmptyTransition::main_region_A));
	delete statechart;
}

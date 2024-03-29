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
#include "StringExpressions.h"

TEST(StatemachineTest, StringExpressionsTest) {
	StringExpressions* statechart = new StringExpressions();
	statechart->init();
	EXPECT_TRUE(statechart->getSCInterface()->get_quotedString().compare("\"x\"") == 0);
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(StringExpressions::StringExpressions_main_region_StateA));
	EXPECT_TRUE(statechart->getSCInterface()->get_myString().compare("hello") == 0);
	EXPECT_TRUE(statechart->getSCInterface()->get_myString2().compare("world") == 0);
	EXPECT_TRUE(statechart->getSCInterface()->get_quotedString().compare("'y'") == 0);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(StringExpressions::StringExpressions_main_region_StateB));
	EXPECT_TRUE(statechart->getSCInterface()->get_equals()== false);
	EXPECT_TRUE(statechart->getSCInterface()->get_notEqual()== true);
	EXPECT_TRUE(statechart->getSCInterface()->get_quotedString().compare("\"z\"") == 0);
	delete statechart;
}

/**
* Copyright (c) 2012 committers of YAKINDU and others.
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
#include "BitExpressions.h"

TEST(StatemachineTest, BitExpressions) {
	BitExpressions handle;
	bitExpressions_init(&handle);
	bitExpressions_enter(&handle);
	EXPECT_TRUE(bitExpressions_isActive(&handle, BitExpressions_main_region_StateA));
	EXPECT_TRUE(bitExpressionsIface_get_myBit1(&handle)== 5);
	EXPECT_TRUE(bitExpressionsIface_get_myBit2(&handle)== 7);
	bitExpressionsIface_raise_e1(&handle);
	bitExpressions_runCycle(&handle);
	EXPECT_TRUE(bitExpressions_isActive(&handle, BitExpressions_main_region_StateB));
	EXPECT_TRUE(bitExpressionsIface_get_leftBitshift(&handle)== 10);
	EXPECT_TRUE(bitExpressionsIface_get_rightBitshift(&handle)== 2);
	EXPECT_TRUE(bitExpressionsIface_get_complementBitshift(&handle)== - 6 );
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseAnd(&handle)== 5);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseOr(&handle)== 7);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseXor(&handle)== 2);
}

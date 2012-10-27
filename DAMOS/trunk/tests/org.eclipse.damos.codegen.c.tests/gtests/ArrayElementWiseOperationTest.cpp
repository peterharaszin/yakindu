/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
#include "gtest/gtest.h"
#include "ArrayElementWiseOperationTest.h"

TEST(ArrayElementWiseOperationTest, ArrayElementWiseOperation) {
	Input input;
	Output output;

	initialize();

	input.inA = 4;
	input.inB = 3;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(7.0, output.out1[0]);
	EXPECT_DOUBLE_EQ(-0.9, output.out1[1]);
	EXPECT_DOUBLE_EQ(24.0, output.out1[2]);

	EXPECT_DOUBLE_EQ(7, output.out2[0][0]);
	EXPECT_DOUBLE_EQ(-0.9, output.out2[0][1]);
	EXPECT_DOUBLE_EQ(30, output.out2[1][0]);
	EXPECT_DOUBLE_EQ(40, output.out2[1][1]);
	EXPECT_DOUBLE_EQ(51, output.out2[2][0]);
	EXPECT_DOUBLE_EQ(62, output.out2[2][1]);
}

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
#include "ArrayTest.h"

TEST(ArrayTest, Array) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7;

	execute(&input, &output);

	EXPECT_EQ(3, output.out1[0]);
	EXPECT_EQ(7, output.out1[1]);
	EXPECT_EQ(16, output.out1[2]);
	EXPECT_EQ(21, output.out2[0]);
	EXPECT_EQ(15, output.out2[1]);
}

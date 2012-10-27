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
#include <math.h>

#include "gtest/gtest.h"
#include "IntegratorFixedPointTest.h"

TEST(IntegratorFixedPointTest, ZeroInput) {
	Input input;
	Output output;

	initialize();

	input.in = 0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0, output.out);
}

TEST(IntegratorFixedPointTest, OneInput) {
	Input input;
	Output output;

	initialize();

	input.in = 1 << 16;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(1 << 16, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(2 << 16, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(3 << 16, output.out);
}

TEST(IntegratorFixedPointTest, MinusOneInput) {
	Input input;
	Output output;

	initialize();

	input.in = -1 << 16;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(-1 << 16, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(-2 << 16, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(-3 << 16, output.out);
}

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
#include "ActionTest.h"

TEST(ActionTest, Action) {
	Input input;
	Output output;

	initialize();

	// Start with gain action
	input.value = 0.0;
	input.condition = 0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);

	input.value = 10.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(70.0, output.out);

	input.value = 1.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(7.0, output.out);

	// Switch to integrator action
	input.value = 1.0;
	input.condition = 1;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);

	execute(&input, &output);
	EXPECT_DOUBLE_EQ(1.0, output.out);

	execute(&input, &output);
	EXPECT_DOUBLE_EQ(2.0, output.out);

	execute(&input, &output);
	EXPECT_DOUBLE_EQ(3.0, output.out);

	input.value = -1.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(4.0, output.out);

	execute(&input, &output);
	EXPECT_DOUBLE_EQ(3.0, output.out);

	execute(&input, &output);
	EXPECT_DOUBLE_EQ(2.0, output.out);
}

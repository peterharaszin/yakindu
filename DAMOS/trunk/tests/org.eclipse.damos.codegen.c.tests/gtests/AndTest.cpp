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
#include "AndTest.h"

TEST(AndTest, And) {
	Input input;
	Output output;

	initialize();

	input.a = 0;
	input.b = 0;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);

	input.a = 1;
	input.b = 0;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);

	input.a = 0;
	input.b = 1;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);

	input.a = 1;
	input.b = 1;
	execute(&input, &output);
	EXPECT_EQ(1, output.out);
}

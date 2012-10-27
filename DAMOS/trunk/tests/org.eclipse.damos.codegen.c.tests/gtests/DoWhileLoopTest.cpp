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
#include "DoWhileLoopTest.h"

TEST(DoWhileLoopTest, DoWhileLoop) {
	Input input;
	Output output;

	initialize();

	input.initialValue = 10.0;
	input.increment = 1.5;
	input.upperLimit = 20.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(20.5, output.out);
}

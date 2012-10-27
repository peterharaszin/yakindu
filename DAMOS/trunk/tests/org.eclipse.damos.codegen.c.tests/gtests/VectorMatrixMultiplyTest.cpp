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
#include "VectorMatrixMultiplyTest.h"

TEST(VectorMatrixMultiplyTest, VectorMatrixMultiply) {
	Input input;
	Output output;

	initialize();

	input.inA = 2;
	input.inB = 8;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(45.0, output.out[0]);
	EXPECT_DOUBLE_EQ(51.1, output.out[1]);
}

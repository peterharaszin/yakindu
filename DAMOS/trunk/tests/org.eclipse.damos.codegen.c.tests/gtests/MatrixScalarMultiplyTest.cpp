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
#include "MatrixScalarMultiplyTest.h"

TEST(MatrixScalarMultiplyTest, MatrixScalarMultiply) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(11.9, output.out[0][0]);
	EXPECT_DOUBLE_EQ(23.8, output.out[0][1]);
	EXPECT_DOUBLE_EQ(35.7, output.out[1][0]);
	EXPECT_DOUBLE_EQ(47.6, output.out[1][1]);
	EXPECT_DOUBLE_EQ(59.5, output.out[2][0]);
	EXPECT_DOUBLE_EQ(71.4, output.out[2][1]);
}

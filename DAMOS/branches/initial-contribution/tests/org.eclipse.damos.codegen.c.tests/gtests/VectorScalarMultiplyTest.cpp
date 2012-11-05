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
#include "VectorScalarMultiplyTest.h"

TEST(VectorScalarMultiplyTest, VectorScalarMultiply) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(11.9, output.out1);
	EXPECT_DOUBLE_EQ(23.8, output.out2);
	EXPECT_DOUBLE_EQ(35.7, output.out3);
}

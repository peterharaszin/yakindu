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
#include "GainFixedPointTest.h"

TEST(GainFixedPointTest, Integer) {
	Input input;
	Output output;

	initialize();

	input.in = 0;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);
	input.in = 10 << 16;
	execute(&input, &output);
	EXPECT_EQ(5 << 16, output.out);
}

TEST(GainFixedPointTest, Fraction) {
	Input input;
	Output output;

	initialize();

	input.in = round(0.5 * pow(2, 16));
	execute(&input, &output);
	EXPECT_EQ(round(0.5 * 0.5 * pow(2, 16)), output.out);
}

TEST(GainFixedPointTest, NegativeFraction) {
	Input input;
	Output output;

	initialize();

	input.in = round(-0.5 * pow(2, 16));
	execute(&input, &output);
	EXPECT_EQ(round(-0.5 * 0.5 * pow(2, 16)), output.out);
}

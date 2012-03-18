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

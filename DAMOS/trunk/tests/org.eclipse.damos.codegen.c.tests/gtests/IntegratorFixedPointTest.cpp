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

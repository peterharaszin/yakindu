#include "gtest/gtest.h"
#include "IntegratorTest.h"

TEST(IntegratorTest, ZeroInput) {
	Input input;
	Output output;

	initialize();

	input.in = 0.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);
}

TEST(IntegratorTest, OneInput) {
	Input input;
	Output output;

	initialize();

	input.in = 1.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(1.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(2.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(3.0, output.out);
}

TEST(IntegratorTest, MinusOneInput) {
	Input input;
	Output output;

	initialize();

	input.in = -1.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(-1.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(-2.0, output.out);
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(-3.0, output.out);
}

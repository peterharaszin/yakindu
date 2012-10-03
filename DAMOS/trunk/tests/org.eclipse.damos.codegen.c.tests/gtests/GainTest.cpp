#include "gtest/gtest.h"
#include "GainTest.h"

TEST(GainTest, Integer) {
	Input input;
	Output output;

	initialize();

	input.in = 0.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(0.0, output.out);
	input.in = 10.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(100.0, output.out);
}

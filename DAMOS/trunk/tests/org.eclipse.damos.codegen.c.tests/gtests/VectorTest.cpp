#include "gtest/gtest.h"
#include "VectorTest.h"

TEST(VectorTest, Vector) {
	Input input;
	Output output;

	initialize();

	input.in[0] = 1;
	input.in[1] = 2;
	input.in[2] = 3;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(11.9, output.out[0]);
	EXPECT_DOUBLE_EQ(23.8, output.out[1]);
	EXPECT_DOUBLE_EQ(35.7, output.out[2]);
}

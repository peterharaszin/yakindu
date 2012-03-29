#include "gtest/gtest.h"
#include "VectorTest.h"

TEST(VectorTest, Vector) {
	Input input;
	Output output;

	initialize();

	input.in.data[0] = 1;
	input.in.data[1] = 2;
	input.in.data[2] = 3;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(11.9, output.out.data[0]);
	EXPECT_DOUBLE_EQ(23.8, output.out.data[1]);
	EXPECT_DOUBLE_EQ(35.7, output.out.data[2]);
}

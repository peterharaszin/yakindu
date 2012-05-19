#include "gtest/gtest.h"
#include "ArrayTest.h"

TEST(ArrayTest, Array) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7;

	execute(&input, &output);

	EXPECT_EQ(3, output.out1.data[0]);
	EXPECT_EQ(7, output.out1.data[1]);
	EXPECT_EQ(16, output.out1.data[2]);
	EXPECT_EQ(21, output.out2.data[0]);
	EXPECT_EQ(15, output.out2.data[1]);
}

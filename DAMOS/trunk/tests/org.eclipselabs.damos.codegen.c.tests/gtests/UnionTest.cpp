#include "gtest/gtest.h"
#include "UnionTest.h"

TEST(UnionTest, Union) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7;

	execute(&input, &output);

	EXPECT_EQ(0, output.out1.tag);
	EXPECT_EQ(30, output.out1.value.x);

	EXPECT_EQ(1, output.out2.tag);
	EXPECT_DOUBLE_EQ(140.0, output.out2.value.y);
}

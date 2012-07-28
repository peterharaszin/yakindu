#include "gtest/gtest.h"
#include "MapFunctionTest.h"

TEST(MapFunctionTest, MapFunction) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(7.0, output.out1[0]);
	EXPECT_DOUBLE_EQ(30.87, output.out1[1]);
	EXPECT_DOUBLE_EQ(63.0, output.out1[2]);

	EXPECT_DOUBLE_EQ(21.0, output.out2[0][0]);
	EXPECT_DOUBLE_EQ(49.0, output.out2[0][1]);
	EXPECT_DOUBLE_EQ(35.0, output.out2[0][2]);
	EXPECT_DOUBLE_EQ(63.0, output.out2[1][0]);
	EXPECT_DOUBLE_EQ(147.0, output.out2[1][1]);
	EXPECT_DOUBLE_EQ(105.0, output.out2[1][2]);
}

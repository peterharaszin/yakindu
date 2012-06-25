#include "gtest/gtest.h"
#include "MatrixMultiplyTest.h"

TEST(MatrixMultiplyTest, MatrixMultiply) {
	Input input;
	Output output;

	initialize();

	input.inA = 2;
	input.inB = 15;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(94.0, output.out.data[0][0]);
	EXPECT_DOUBLE_EQ(100.0, output.out.data[0][1]);
	EXPECT_DOUBLE_EQ(230.5, output.out.data[1][0]);
	EXPECT_DOUBLE_EQ(245.6, output.out.data[1][1]);
	EXPECT_DOUBLE_EQ(364.0, output.out.data[2][0]);
	EXPECT_DOUBLE_EQ(388.0, output.out.data[2][1]);
	EXPECT_DOUBLE_EQ(499.0, output.out.data[3][0]);
	EXPECT_DOUBLE_EQ(532.0, output.out.data[3][1]);
}

#include "gtest/gtest.h"
#include "MatrixVectorMultiplyTest.h"

TEST(MatrixVectorMultiplyTest, MatrixVectorMultiply) {
	Input input;
	Output output;

	initialize();

	input.inA = 4;
	input.inB = 3;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(23.3, output.out[0]);
	EXPECT_DOUBLE_EQ(38.0, output.out[1]);
	EXPECT_DOUBLE_EQ(48.0, output.out[2]);
}

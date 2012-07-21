#include "gtest/gtest.h"
#include "VectorMatrixMultiplyTest.h"

TEST(VectorMatrixMultiplyTest, VectorMatrixMultiply) {
	Input input;
	Output output;

	initialize();

	input.inA = 2;
	input.inB = 8;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(45.0, output.out[0]);
	EXPECT_DOUBLE_EQ(51.1, output.out[1]);
}

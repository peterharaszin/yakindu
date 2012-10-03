#include "gtest/gtest.h"
#include "VectorMultiplyTest.h"

TEST(VectorMultiplyTest, VectorMultiply) {
	Input input;
	Output output;

	initialize();

	input.inA = 2;
	input.inB = 8;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(35.3, output.out);
}

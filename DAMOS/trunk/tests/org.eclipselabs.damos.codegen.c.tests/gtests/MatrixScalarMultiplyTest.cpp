#include "gtest/gtest.h"
#include "MatrixScalarMultiplyTest.h"

TEST(MatrixScalarMultiplyTest, MatrixScalarMultiply) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(11.9, output.out[0][0]);
	EXPECT_DOUBLE_EQ(23.8, output.out[0][1]);
	EXPECT_DOUBLE_EQ(35.7, output.out[1][0]);
	EXPECT_DOUBLE_EQ(47.6, output.out[1][1]);
	EXPECT_DOUBLE_EQ(59.5, output.out[2][0]);
	EXPECT_DOUBLE_EQ(71.4, output.out[2][1]);
}

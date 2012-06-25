#include "gtest/gtest.h"
#include "MatrixScalarMultiplyTest.h"

TEST(MatrixScalarMultiplyTest, MatrixScalarMultiply) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(11.9, output.out.data[0][0]);
	EXPECT_DOUBLE_EQ(23.8, output.out.data[0][1]);
	EXPECT_DOUBLE_EQ(35.7, output.out.data[1][0]);
	EXPECT_DOUBLE_EQ(47.6, output.out.data[1][1]);
	EXPECT_DOUBLE_EQ(59.5, output.out.data[2][0]);
	EXPECT_DOUBLE_EQ(71.4, output.out.data[2][1]);
}

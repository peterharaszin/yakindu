#include "gtest/gtest.h"
#include "VectorScalarMultiplyTest.h"

TEST(VectorScalarMultiplyTest, VectorScalarMultiply) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(11.9, output.out1);
	EXPECT_DOUBLE_EQ(23.8, output.out2);
	EXPECT_DOUBLE_EQ(35.7, output.out3);
}

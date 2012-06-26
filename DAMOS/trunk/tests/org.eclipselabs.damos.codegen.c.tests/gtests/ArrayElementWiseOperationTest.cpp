#include "gtest/gtest.h"
#include "ArrayElementWiseOperationTest.h"

TEST(ArrayElementWiseOperationTest, ArrayElementWiseOperation) {
	Input input;
	Output output;

	initialize();

	input.inA = 4;
	input.inB = 3;

	execute(&input, &output);

	EXPECT_DOUBLE_EQ(7.0, output.out1.data[0]);
	EXPECT_DOUBLE_EQ(-0.9, output.out1.data[1]);
	EXPECT_DOUBLE_EQ(24.0, output.out1.data[2]);

	EXPECT_DOUBLE_EQ(7, output.out2.data[0][0]);
	EXPECT_DOUBLE_EQ(-0.9, output.out2.data[0][1]);
	EXPECT_DOUBLE_EQ(30, output.out2.data[1][0]);
	EXPECT_DOUBLE_EQ(40, output.out2.data[1][1]);
	EXPECT_DOUBLE_EQ(51, output.out2.data[2][0]);
	EXPECT_DOUBLE_EQ(62, output.out2.data[2][1]);
}

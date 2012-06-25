#include "gtest/gtest.h"
#include "MatrixTest.h"

TEST(MatrixTest, Matrix) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7;

	execute(&input, &output);

	EXPECT_EQ(3, output.out1.data[0][0]);
	EXPECT_EQ(7, output.out1.data[0][1]);
	EXPECT_EQ(16, output.out1.data[1][0]);
	EXPECT_EQ(7, output.out1.data[1][1]);
	EXPECT_EQ(3, output.out1.data[2][0]);
	EXPECT_EQ(19, output.out1.data[2][1]);

	EXPECT_EQ(21, output.out2.data[0][0]);
	EXPECT_EQ(15, output.out2.data[0][1]);
	EXPECT_EQ(13, output.out2.data[1][0]);
	EXPECT_EQ(18, output.out2.data[1][1]);
	EXPECT_EQ(34, output.out2.data[2][0]);
	EXPECT_EQ(47, output.out2.data[2][1]);
}

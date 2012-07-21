#include "gtest/gtest.h"
#include "StructTest.h"

TEST(StructTest, Struct) {
	Input input;
	Output output;

	initialize();

	input.in.x = 3;
	input.in.y = 7;

	execute(&input, &output);

	EXPECT_EQ(3, output.out.x);
	EXPECT_EQ(7, output.out.y);
	EXPECT_EQ(3, output.outX);
	EXPECT_EQ(2, output.outStructLiteral.x);
	EXPECT_EQ(5, output.outStructLiteral.y.a);
	EXPECT_EQ(7, output.outStructLiteral.y.b[0]);
	EXPECT_EQ(19, output.outStructLiteral.y.b[1]);
}

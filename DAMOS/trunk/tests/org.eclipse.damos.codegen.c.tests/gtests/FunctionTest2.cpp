#include "gtest/gtest.h"
#include "FunctionTest2.h"

TEST(FunctionTest2, Function2) {
	Input input;
	Output output;

	initialize();

	input.a = 1;
	input.b = 2;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(33.0, output.out);

	input.a = 2;
	input.b = 4;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(68.0, output.out);

	input.a = 1.5;
	input.b = 5.5;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(85.0, output.out);
}

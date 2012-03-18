#include "gtest/gtest.h"
#include "DoWhileLoopTest.h"

TEST(DoWhileLoopTest, DoWhileLoop) {
	Input input;
	Output output;

	initialize();

	input.initialValue = 10.0;
	input.increment = 1.5;
	input.upperLimit = 20.0;
	execute(&input, &output);
	EXPECT_DOUBLE_EQ(20.5, output.out);
}

#include "gtest/gtest.h"
#include "AndTest.h"

TEST(AndTest, And) {
	Input input;
	Output output;

	initialize();

	input.a = 0;
	input.b = 0;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);

	input.a = 1;
	input.b = 0;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);

	input.a = 0;
	input.b = 1;
	execute(&input, &output);
	EXPECT_EQ(0, output.out);

	input.a = 1;
	input.b = 1;
	execute(&input, &output);
	EXPECT_EQ(1, output.out);
}

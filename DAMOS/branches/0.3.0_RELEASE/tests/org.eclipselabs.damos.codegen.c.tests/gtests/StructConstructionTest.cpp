#include "gtest/gtest.h"
#include "StructConstructionTest.h"

TEST(StructConstructionTest, StructConstruction) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7.3;

	execute(&input, &output);

	EXPECT_EQ(3, output.out.x);
	EXPECT_EQ(7, output.out.y);
	EXPECT_EQ(19, output.out.z);
}

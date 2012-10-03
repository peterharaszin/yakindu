#include "gtest/gtest.h"
#include "OutportOnlyTest.h"

TEST(OutportOnlyTest, OutportOnly) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(3.2, output.out);
}

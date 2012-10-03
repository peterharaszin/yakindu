#include "gtest/gtest.h"
#include "InportOnlyTest.h"

TEST(InportOnlyTest, InportOnly) {
	Input input;

	initialize();

	input.in = 0.0;
	execute(&input);
}

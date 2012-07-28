#include "gtest/gtest.h"
#include "RecordTest.h"

TEST(RecordTest, Record) {
	Input input;
	Output output;

	initialize();

	input.in.x = 3;
	input.in.y = 7;

	execute(&input, &output);

	EXPECT_EQ(3, output.out.x);
	EXPECT_EQ(7, output.out.y);
	EXPECT_EQ(3, output.outX);
	EXPECT_EQ(2, output.outRecordLiteral.x);
	EXPECT_EQ(5, output.outRecordLiteral.y.a);
	EXPECT_EQ(7, output.outRecordLiteral.y.b[0]);
	EXPECT_EQ(19, output.outRecordLiteral.y.b[1]);
}

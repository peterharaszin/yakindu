#include "gtest/gtest.h"
#include "StringTest.h"

char *toCString(char *buffer, const String *src) {
	Damos_StringIterator it;
	int indentationBuffer[32];
	StringIterator_initialize(&it, src, indentationBuffer, 32);
	char c;
	char *b = buffer;
	do {
		c = it.next(&it);
		*b++ = c;
	} while (c != '\0');
	return buffer;
}

TEST(StringTest, String) {
	Input input;
	Output output;

	initialize();

	input.inA = 3;
	input.inB = 7;

	execute(&input, &output);

	char buffer[1024];

	EXPECT_STREQ("Hello, world!", toCString(buffer, &output.out1));
	EXPECT_STREQ("Hello, 3\n\t\"10\"\nworld! '7'\n", toCString(buffer, &output.out2));
	EXPECT_STREQ("<code>\n\tHello, world!\n\t<code/>\n\tHello, 3\n\t\t\"10\"\n\tworld! '7'\n</code>\n", toCString(buffer, &output.out3));
	EXPECT_STREQ("<code>\n\tHello, world!Hello, 3\n\t\t\"10\"\n\tworld! '7'\n</code>\n", toCString(buffer, &output.out4));
}

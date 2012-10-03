#include <unistd.h>
#include "gtest/gtest.h"
#include "CounterTestWithPrefix.h"

TEST(CounterTest, Counter) {
	CounterTest_Input input;
	CounterTest_Output output;

	CounterTest_initialize();

	for (int i = 0; i < COUNTERTEST_TASK_COUNT; ++i) {
		pthread_t thread;
		ASSERT_EQ(0, pthread_create(&thread, NULL, CounterTest_taskInfos[i].function, NULL));
	}

	input.a = 1;
	input.b = 0;
	CounterTest_execute(&input, &output);
	CounterTest_execute(&input, &output);
	CounterTest_execute(&input, &output);
	CounterTest_execute(&input, &output);
	CounterTest_execute(&input, &output);

	sleep(1);

	input.a = 0;
	input.b = 1;
	CounterTest_execute(&input, &output);
	CounterTest_execute(&input, &output);

	sleep(1);

	input.a = 0;
	input.b = 0;
	CounterTest_execute(&input, &output);

	EXPECT_EQ(6, output.out);
}

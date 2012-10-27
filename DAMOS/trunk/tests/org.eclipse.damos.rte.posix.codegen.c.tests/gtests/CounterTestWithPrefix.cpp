/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
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

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

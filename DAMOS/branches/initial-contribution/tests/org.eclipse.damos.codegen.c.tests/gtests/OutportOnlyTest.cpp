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
#include "OutportOnlyTest.h"

TEST(OutportOnlyTest, OutportOnly) {
	Output output;

	initialize();

	execute(&output);
	EXPECT_DOUBLE_EQ(3.2, output.out);
}

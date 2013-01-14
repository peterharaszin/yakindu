/**
* Copyright (c) 2012 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "AssignmentAsExpression.h"

TEST(StatemachineTest, simpleAssignment) {
	AssignmentAsExpression handle;
	assignmentAsExpression_init(&handle);
	assignmentAsExpression_enter(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_A));
	EXPECT_TRUE(assignmentAsExpressionIface_get_b(&handle)== 5);
	EXPECT_TRUE(assignmentAsExpressionIface_get_a(&handle)== 9);
}

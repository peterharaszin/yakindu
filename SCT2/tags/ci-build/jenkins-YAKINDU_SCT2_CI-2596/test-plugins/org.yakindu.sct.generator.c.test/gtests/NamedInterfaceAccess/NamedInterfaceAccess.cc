/**
* Copyright (c) 2015 committers of YAKINDU and others.
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
#include "NamedInterfaceAccess.h"


NamedInterfaceAccess handle;

TEST(StatemachineTest, SafeOpenSuccess) {
	namedInterfaceAccess_init(&handle);
	namedInterfaceAccess_enter(&handle);
	namedInterfaceAccess_runCycle(&handle);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&handle, 3l);
	namedInterfaceAccess_runCycle(&handle);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&handle, 7l);
	namedInterfaceAccess_runCycle(&handle);
	namedInterfaceAccessIfaceUser_raise_numberPressed(&handle, 5l);
	namedInterfaceAccess_runCycle(&handle);
	EXPECT_TRUE(namedInterfaceAccessIfaceSafe_israised_open(&handle));
}

		

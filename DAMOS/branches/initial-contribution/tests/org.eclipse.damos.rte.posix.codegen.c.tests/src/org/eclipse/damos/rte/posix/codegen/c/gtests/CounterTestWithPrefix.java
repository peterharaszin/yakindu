/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.rte.posix.codegen.c.gtests;

import org.eclipse.damos.codegen.c.test.GTest;
import org.eclipse.damos.dconfig.SimpleProperty;

/**
 * Right now generated code is invalid if no prefix is specified.
 * This should be fixed in the future.
 * 
 * @author Andreas Unger
 */
@GTest(sourceFile="gtests/CounterTestWithPrefix.cpp", program="gtests/CounterTestWithPrefix")
public class CounterTestWithPrefix extends CounterTest {

	@Override
	protected void createConfiguration() {
		super.createConfiguration();
		SimpleProperty prefixProperty = createSimpleProperty("damos.codegen.c.prefix", "\"CounterTest_\"");
		prefixProperty.setPropagate(true);
		configuration.getRootSystemConfiguration().getBody().getProperties().add(prefixProperty);
	}
	
}

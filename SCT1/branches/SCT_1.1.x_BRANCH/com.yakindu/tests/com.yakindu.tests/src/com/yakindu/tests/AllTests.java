/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.tests;

import junit.framework.TestSuite;

//@RunWith(value=Suite.class)
//@SuiteClasses(value={AllCoreTests.class, AllUITests.class})
public class AllTests extends TestSuite{

	public static TestSuite suite() {
		TestSuite ts = new TestSuite("All tests");
		ts.addTest(AllCoreTests.suite());
		ts.addTest(AllUITests.suite());
		return ts;    
	}
}

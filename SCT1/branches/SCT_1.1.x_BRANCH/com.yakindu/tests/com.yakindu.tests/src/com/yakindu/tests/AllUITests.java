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
//@SuiteClasses(value={
//		com.yakindu.simulation.engine.statechart.test.AllUITests.class
//		})
public class AllUITests {

	public static junit.framework.Test suite() {
		TestSuite ts = new TestSuite("All ui tests");
		ts.addTest(com.yakindu.statechart.transformation.uml2.tests.AllUITests.suite());
//		ts.addTestSuite(com.yakindu.simulation.engine.statechart.test.AllUITests.suite());
		return ts;    
	}
}

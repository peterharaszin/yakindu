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
//		com.yakindu.statechart.model.expressions.test.AllCoreTests.class,
//		com.yakindu.statechart.codegenerator.java.test.AllCoreTests.class,
//		com.yakindu.statechart.transformation.uml.test.AllCoreTests.class,
//		com.yakindu.statechart.model.expressions.runtime.test.AllTests.class,
//		com.yakindu.statechart.model.expressions.builder.test.AllTests.class
//		})
public class AllCoreTests extends TestSuite{

	public static junit.framework.Test suite() {
		TestSuite ts = new TestSuite("All core tests");
		ts.addTest(com.yakindu.statechart.model.expressions.test.AllCoreTests.suite());
		ts.addTest(com.yakindu.statechart.codegenerator.java.test.AllCoreTests.suite());
		ts.addTest(com.yakindu.statechart.runtime.test.AllTests.suite());
		ts.addTest(com.yakindu.statechart.runtime.builder.test.AllTests.suite());
		ts.addTest(com.yakindu.statechart.transformation.uml2.tests.AllCoreTests.suite());
		ts.addTest(com.yakindu.statechart.model.expressions.runtime.test.AllTests.suite());
		ts.addTest(com.yakindu.statechart.model.expressions.builder.test.AllTests.suite());
		return ts;    
	}
}

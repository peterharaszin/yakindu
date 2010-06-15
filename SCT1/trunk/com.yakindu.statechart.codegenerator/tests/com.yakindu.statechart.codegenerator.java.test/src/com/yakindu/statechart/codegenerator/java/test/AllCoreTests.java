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
package com.yakindu.statechart.codegenerator.java.test;

import junit.framework.TestSuite;
import junit.framework.Test;

//@RunWith(value = Suite.class)
//@SuiteClasses(value = { DefensiveCodeTest.class, StatesTest.class,
//		HistoryPseudostatesTest.class, ChoiceJunctionPseudostatesTest.class,
//		TimingTests.class, TransitionsTest.class })

public class AllCoreTests extends TestSuite {
    public static Test suite() {
        TestSuite mySuite = new TestSuite(AllCoreTests.class.getName());
        mySuite.addTestSuite(DefensiveCodeTest.class);
        mySuite.addTestSuite(StatesTest.class);
        mySuite.addTestSuite(HistoryPseudostatesTest.class);
        mySuite.addTestSuite(ChoiceJunctionPseudostatesTest.class);
        mySuite.addTestSuite(TimingTests.class);
        mySuite.addTestSuite(TransitionsTest.class);
        return mySuite;
    }


}

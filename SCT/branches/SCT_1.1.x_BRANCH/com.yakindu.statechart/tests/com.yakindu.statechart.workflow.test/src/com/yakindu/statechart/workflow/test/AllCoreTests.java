package com.yakindu.statechart.workflow.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllCoreTests extends TestSuite {
	public static Test suite() {
		TestSuite mySuite = new TestSuite(AllCoreTests.class.getName());
		mySuite.addTestSuite(TestStartWorkflow.class);
		return mySuite;
	}
}
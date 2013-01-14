/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	@author markus muehlbrandt - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java.runtime.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
		TestInterfaceTestCycleBasedStatemachine.class,
		TestLocalActionsCycleBasedStatemachine.class,
		TestExpressionCycleBasedStatemachine.class,
		TestHierarchyCycleBasedStatemachine.class,
		TestParallelRegionsCycleBasedStatemachine.class
		})

public class AllCycleBasedStatemachineTests {
}
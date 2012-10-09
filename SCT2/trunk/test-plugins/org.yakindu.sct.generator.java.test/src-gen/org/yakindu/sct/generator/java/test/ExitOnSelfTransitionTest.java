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
package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.exitonselftransition.ExitOnSelfTransitionStatemachine;
import org.yakindu.scr.exitonselftransition.ExitOnSelfTransitionStatemachine.State;
/**
 *  Unit TestCase for ExitOnSelfTransition
 */
@SuppressWarnings("all")
public class ExitOnSelfTransitionTest {

	private ExitOnSelfTransitionStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ExitOnSelfTransitionStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testExitOnSelfTransitionTest() {
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getEntryCount() == 1);
		assertTrue(statemachine.getExitCount() == 0);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.getEntryCount() == 2);
		assertTrue(statemachine.getExitCount() == 1);
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.getEntryCount() == 2);
		assertTrue(statemachine.getExitCount() == 2);
	}
}

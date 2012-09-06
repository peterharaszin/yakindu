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
import org.yakindu.scr.guardedexit.GuardedExitStatemachine;
import org.yakindu.scr.guardedexit.GuardedExitStatemachine.State;
/**
 *  Unit TestCase for GuardedExit
 */
@SuppressWarnings("all")
public class GuardedExitTest {

	private GuardedExitStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new GuardedExitStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testExitTaken() {
		assertTrue(statemachine.isStateActive(State.Main_region_A));
		assertTrue(!statemachine.getGuard());
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_B));
		assertTrue(!statemachine.getDone());
	}
	@Test
	public void testExitNotTaken() {
		assertTrue(statemachine.isStateActive(State.Main_region_A));
		statemachine.setGuard(true);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_B));
		assertTrue(statemachine.getDone());
	}
}

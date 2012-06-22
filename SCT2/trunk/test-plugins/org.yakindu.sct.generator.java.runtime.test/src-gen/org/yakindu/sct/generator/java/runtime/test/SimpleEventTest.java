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
package org.yakindu.sct.generator.java.runtime.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.simpleevent.SimpleEventStatemachine;
import org.yakindu.scr.simpleevent.SimpleEventStatemachine.State;
/**
 *  Unit TestCase for SimpleEvent
 */
@SuppressWarnings("all")
public class SimpleEventTest {

	private SimpleEventStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new SimpleEventStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testsimpleEventTest() {
		assertTrue(statemachine.isStateActive(State.Main_region_A));
		statemachine.raiseEvent1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_B));
	}
}

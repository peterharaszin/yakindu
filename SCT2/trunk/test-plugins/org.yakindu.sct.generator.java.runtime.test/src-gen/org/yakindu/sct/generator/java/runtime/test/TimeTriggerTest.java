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

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.scr.timetrigger.TimeTriggerStatemachine;
import org.yakindu.scr.timetrigger.TimeTriggerStatemachine.State;

/**
 * Unit TestCase for TimeTrigger
 */
@SuppressWarnings("all")
public class TimeTriggerTest {

	private TimeTriggerStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new TimeTriggerStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testtimeTriggerTest() {
		assertTrue(statemachine.isStateActive(State.MainRegion_StateA));
		assertTrue(statemachine.isStateActive(State.MainRegion_StateB));
		assertTrue(statemachine.isStateActive(State.MainRegion_StateA));
	}
}

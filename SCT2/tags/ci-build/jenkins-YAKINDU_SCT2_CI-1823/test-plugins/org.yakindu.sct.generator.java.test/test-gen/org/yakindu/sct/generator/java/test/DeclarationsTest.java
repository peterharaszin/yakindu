/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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
import org.yakindu.scr.declarations.DeclarationsStatemachine;
import org.yakindu.scr.declarations.DeclarationsStatemachine.State;
/**
 *  Unit TestCase for Declarations
 */
@SuppressWarnings("all")
public class DeclarationsTest {

	private DeclarationsStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new DeclarationsStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testdeclarationsTest() {
		statemachine.enter();
	}
}

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

import historypseudostatestest.HistoryPseudostatesTestStatechart;

public class DefensiveCodeTest extends AbstractStatechartTest {

	public void testEnterAssertBeforeRunCycle() {
		try {
			HistoryPseudostatesTestStatechart statechart = HistoryPseudostatesTestStatechart
					.createInstance();
			statechart.setEvent(HistoryPseudostatesTestStatechart.EVENT1);
			statechart.runCycle();
			fail("Expected IllegalArgumentException");
		} catch (IllegalStateException e) {
		}
	}
}

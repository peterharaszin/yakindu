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
package org.yakindu.sct.model.sexec.interpreter.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import com.google.inject.Inject;
import org.junit.Before;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import util.TestModels;
import static junit.framework.Assert.*;
/**
 *  Unit TestCase for HistoryWithoutInitialStep
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class HistoryWithoutInitialStepTest extends AbstractExecutionFlowTest {

	@Inject
	private TestModels models;

	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("HistoryWithoutInitialStep.sct");
		initInterpreter(flow);
	}
	@Test
	public void enterThroughInitialEntry() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(isActive("C"));
		raiseEvent("e2");
		interpreter.runCycle();
		assertTrue(isActive("D"));
	}
	@Test
	public void enterCThroughHistory() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(isActive("C"));
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(isActive("A"));
		raiseEvent("e2");
		interpreter.runCycle();
		assertTrue(isActive("C"));
	}
	@Test
	public void enterDThroughHistory() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("e1");
		interpreter.runCycle();
		raiseEvent("e2");
		interpreter.runCycle();
		assertTrue(isActive("D"));
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(isActive("A"));
		raiseEvent("e2");
		interpreter.runCycle();
		assertTrue(isActive("D"));
	}
}

package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.RuntimeService;
import org.yakindu.sct.runtime.java.test_expression.Test_ExpressionEventBasedStatemachine;

public class TestExpressionEventBasedStatemachine {

	private Test_ExpressionEventBasedStatemachine statemachine;

	private RuntimeService runtimeService;

	// Minimal cycletime
	private final long cyclePeriod = 1;

	@Before
	public void setUp() {
		statemachine = new Test_ExpressionEventBasedStatemachine();
		statemachine.enter();
		runtimeService = new RuntimeService(cyclePeriod);
		runtimeService.addStatemachine(statemachine);
	}

	@After
	public void tearDown() {
		runtimeService.removeStatemachine(statemachine);
		runtimeService.cancel();
		statemachine = null;
	}

	private void sleep(long time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCycles() {
		assertEquals("Var3 value not set correct: ", 2405.6, statemachine
				.getDefaultInterface().getVarVar3(), Math.pow(10, -8));

		statemachine.getDefaultInterface().raiseEvent1(0);
		sleep(5);
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1, statemachine
				.getDefaultInterface().getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3, statemachine
				.getDefaultInterface().getVarVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12, statemachine
				.getDefaultInterface().getVarVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 7, statemachine
				.getDefaultInterface().getVarVar1());

		// Trigger oncycle expression with event
		statemachine.getDefaultInterface().raiseEvent3();
		sleep(5);
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1, statemachine
				.getDefaultInterface().getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3, statemachine
				.getDefaultInterface().getVarVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12, statemachine
				.getDefaultInterface().getVarVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 8, statemachine
				.getDefaultInterface().getVarVar1());

		// Trigger oncycle expression with event
		statemachine.getDefaultInterface().raiseEvent3();
		sleep(5);
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1, statemachine
				.getDefaultInterface().getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3, statemachine
				.getDefaultInterface().getVarVar4(), Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12, statemachine
				.getDefaultInterface().getVarVar3(), Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 9, statemachine
				.getDefaultInterface().getVarVar1());

		statemachine.getDefaultInterface().raiseEvent1(0);
		sleep(5);
		assertEquals("Default.Var5 value not set correct: ", true, statemachine
				.getDefaultInterface().getVarVar5());
		assertEquals("Other.Var3 value not set correct: ", 962.24, statemachine
				.getDefaultInterface().getVarVar3(), Math.pow(10, -8));

		statemachine.getDefaultInterface().raiseEvent1(0);
		sleep(5);
		assertEquals("Other.Var3 value not set correct: ", 962.24, statemachine
				.getDefaultInterface().getVarVar3(), Math.pow(10, -8));

	}
}

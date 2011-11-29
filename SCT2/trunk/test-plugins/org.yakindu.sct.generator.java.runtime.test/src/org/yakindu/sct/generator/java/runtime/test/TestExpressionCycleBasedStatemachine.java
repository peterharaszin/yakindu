package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.test_expression.Test_ExpressionCyleBasedStatemachine;

public class TestExpressionCycleBasedStatemachine {
	
	private Test_ExpressionCyleBasedStatemachine statemachine;
	
	@Before
	public void setUp() {
		statemachine = new Test_ExpressionCyleBasedStatemachine();
		statemachine.enterSequenceStatechartTest_Expression();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testCycles() {
		assertEquals("Var3 value not set correct: ", 2405.6, statemachine
				.getInterfaceDefault().getVarVar3(),Math.pow(10, -8));
		
		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1, statemachine
				.getInterfaceDefault().getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3, statemachine
				.getInterfaceDefault().getVarVar4(),Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12, statemachine
				.getInterfaceDefault().getVarVar3(),Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 7, statemachine
				.getInterfaceDefault().getVarVar1());
		
		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1, statemachine
				.getInterfaceDefault().getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3, statemachine
				.getInterfaceDefault().getVarVar4(),Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12, statemachine
				.getInterfaceDefault().getVarVar3(),Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 8, statemachine
				.getInterfaceDefault().getVarVar1());
		
		statemachine.runCycle();
		assertEquals("Other.Var1 value not set correct: ", false, statemachine
				.getInterfaceOther().getVarVar1());
		assertEquals("Default.Var2 value not set correct: ", 1, statemachine
				.getInterfaceDefault().getVarVar2());
		assertEquals("Default.Var4 value not set correct: ", 22.3, statemachine
				.getInterfaceDefault().getVarVar4(),Math.pow(10, -8));
		assertEquals("Other.Var3 value not set correct: ", 481.12, statemachine
				.getInterfaceDefault().getVarVar3(),Math.pow(10, -8));
		assertEquals("Default.Var1 value not set correct: ", 9, statemachine
				.getInterfaceDefault().getVarVar1());
		
		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.runCycle();
		assertEquals("Default.Var5 value not set correct: ", true, statemachine
				.getInterfaceDefault().getVarVar5());
		assertEquals("Other.Var3 value not set correct: ", 962.24, statemachine
				.getInterfaceDefault().getVarVar3(),Math.pow(10, -8));
		
		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.runCycle();
		assertEquals("Other.Var3 value not set correct: ", 962.24, statemachine
				.getInterfaceDefault().getVarVar3(),Math.pow(10, -8));
		
	}
}

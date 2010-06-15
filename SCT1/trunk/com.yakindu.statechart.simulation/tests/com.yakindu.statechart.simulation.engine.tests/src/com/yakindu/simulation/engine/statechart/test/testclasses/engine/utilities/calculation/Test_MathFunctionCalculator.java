/**
 * Copyright (c) 2009 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.test.testclasses.engine.utilities.calculation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.MathFunctionCalculator;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;

/**
 * Defines test cases to check the functionality of the class {@link MathFunctionCalculator}.
 * 
 * @author Philipp Richter
 */
public class Test_MathFunctionCalculator {

	/** Defines the class to test. */
	MathFunctionCalculator calc = new MathFunctionCalculator();

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.MathFunctionCalculator#calculateMathFunction(String, double)}.
	 */
	@Test
	public void testCalculateMathFunction() throws ParserException {
		
		// --- Normal case ---

		assertEquals("Result is wrong!", 1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ABS, -1), 0.0);
		assertEquals("Result is wrong!", 1.57, calc.calculateMathFunction(MathFunctionCalculator.MATH_ACOS, 0), 0.001);
		assertEquals("Result is wrong!", 1.57, calc.calculateMathFunction(MathFunctionCalculator.MATH_ASIN, 1), 0.001);
		assertEquals("Result is wrong!", 0.785, calc.calculateMathFunction(MathFunctionCalculator.MATH_ATAN, 1), 0.0004);
		assertEquals("Result is wrong!", 0.54, calc.calculateMathFunction(MathFunctionCalculator.MATH_COS, 1), 0.001);
		assertEquals("Result is wrong!", 1.543, calc.calculateMathFunction(MathFunctionCalculator.MATH_COSH, 1), 0.0001);
		assertEquals("Result is wrong!", 114.59, calc.calculateMathFunction(MathFunctionCalculator.MATH_DEG, 2), 0.002);
		assertEquals("Result is wrong!", 7.389, calc.calculateMathFunction(MathFunctionCalculator.MATH_EXP, 2), 0.0001);
		assertEquals("Result is wrong!", 0.234, calc.calculateMathFunction(MathFunctionCalculator.MATH_FRAC, 1.234), 0.0);
		assertEquals("Result is wrong!", 11.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_INT, 11.234), 0.0);
		assertEquals("Result is wrong!", -11.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_INT, -11.234), 0.0);
		assertEquals("Result is wrong!", 3.091, calc.calculateMathFunction(MathFunctionCalculator.MATH_LN, 22), 0.0001);
		assertEquals("Result is wrong!", 0.301, calc.calculateMathFunction(MathFunctionCalculator.MATH_LOG, 2), 0.0001);
		assertEquals("Result is wrong!", 0.61, calc.calculateMathFunction(MathFunctionCalculator.MATH_RAD, 35), 0.001);
		assertEquals("Result is wrong!", -1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ROUND, -1.5), 0.0);
		assertEquals("Result is wrong!", 0.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ROUND, 0), 0.0);
		//For the blocksystem simulator (see MathFunctionCalculator.roundValue()):
		//assertEquals("Result is wrong!", 1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ROUND, 1.5));
		assertEquals("Result is wrong!", 2.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ROUND, 1.5), 0.0);
		assertEquals("Result is wrong!", 2.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ROUND, 1.6), 0.0);
		assertEquals("Result is wrong!", -2.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_ROUND, -1.6), 0.0);
		assertEquals("Result is wrong!", 1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_SIGN, 0.1), 0.0);
		assertEquals("Result is wrong!", 0.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_SIGN, 0), 0.0);
		assertEquals("Result is wrong!", -1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_SIGN, -0.1), 0.0);
		assertEquals("Result is wrong!", 1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_SIN, 1.57), 0.000001);
		assertEquals("Result is wrong!", 74.2, calc.calculateMathFunction(MathFunctionCalculator.MATH_SINH, 5), 0.01);
		assertEquals("Result is wrong!", 6.25, calc.calculateMathFunction(MathFunctionCalculator.MATH_SQR, 2.5), 0.0);
		assertEquals("Result is wrong!", 5.099, calc.calculateMathFunction(MathFunctionCalculator.MATH_SQRT, 26), 0.0001);
		assertEquals("Result is wrong!", 1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_STEP, 1), 0.0);
		assertEquals("Result is wrong!", 1.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_STEP, 0), 0.0);
		assertEquals("Result is wrong!", 0.0, calc.calculateMathFunction(MathFunctionCalculator.MATH_STEP, -1), 0.0);
		assertEquals("Result is wrong!", -2.185, calc.calculateMathFunction(MathFunctionCalculator.MATH_TAN, 2), 0.0001);
		assertEquals("Result is wrong!", 0.964, calc.calculateMathFunction(MathFunctionCalculator.MATH_TANH, 2), 0.0001);
		
		// --- Exceptional case ---

		// Unsupported function
		try {
			calc.calculateMathFunction("unsupportedfunction", 1.0);
			
			fail("The function is not supported, but no exception was thrown!");
		}
		catch (ParserException e) {}
		
		// Function is "null"
		try {
			calc.calculateMathFunction(null, 1.0);
			
			fail("The forbidden value was not checked (NaN!");
		}
		catch (ParserException e) {}
		
		// Value is NaN (Not A Number)
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_ABS, Double.NaN);
			
			fail("The forbidden value was not checked (NaN!");
		}
		catch (ParserException e) {}
		
		// Value is positive infinite
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_ABS, Double.POSITIVE_INFINITY);
			
			fail("The forbidden value was not checked (NaN!");
		}
		catch (ParserException e) {}
		
		// Value is negative infinite
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_ABS, Double.NEGATIVE_INFINITY);
			
			fail("The forbidden value was not checked (NaN!");
		}
		catch (ParserException e) {}
		
		// Limits of the function "ln"
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_LN, -0.1);
			
			fail("The forbidden value was not checked!");
		}
		catch (ParserException e) {}
		
		// Limits of the function "log"
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_LOG, -0.1);
			
			fail("The forbidden value was not checked!");
		}
		catch (ParserException e) {}
		
		// Limits of the function "sqrt"
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_SQRT, -0.1);
			
			fail("The forbidden value was not checked!");
		}
		catch (ParserException e) {}
		
		// Limits of the function "asin"
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_ASIN, 1.1);
			
			fail("The forbidden value was not checked!");
		}
		catch (ParserException e) {}
		
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_ASIN, -1.1);
			
			fail("The forbidden value was not checked!");
		}
		catch (ParserException e) {}
		
		// Limits of the function "acos"
		try {
			calc.calculateMathFunction(MathFunctionCalculator.MATH_ACOS, 1.1);
			
			fail("The forbidden value was not checked!");
		}
		catch (ParserException e) {}
		
		calc.calculateMathFunction(MathFunctionCalculator.MATH_ACOS, -1.0);		
	}

	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.utilities.calculation.MathFunctionCalculator#isMathFunction(java.lang.String)}.
	 */
	@Test
	public void testIsMathFunction() throws ArgumentIsNullException {
		
		// --- Normal case ---

		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_ABS));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_ACOS));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_ASIN));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_ATAN));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_COS));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_COSH));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_DEG));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_EXP));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_FRAC));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_INT));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_LN));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_LOG));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_RAD));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_ROUND));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_SIGN));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_SIN));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_SINH));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_SQR));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_SQRT));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_STEP));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_TAN));
		assertEquals("The instance report that function is not supported!", true, calc.isMathFunction(MathFunctionCalculator.MATH_TANH));
		
		assertEquals("The instance report that function is supported, but the function is not supported!", false, calc.isMathFunction("notsupportedfunction"));
		
		// --- Exceptional case ---

		try {
			boolean result = calc.isMathFunction(null);
			fail("The parameter is \"null\", but the method didn't report it (Result: " + result + ")!");
		} catch (ArgumentIsNullException e) {}
	}

}

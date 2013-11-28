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
package com.yakindu.simulation.engine.statechart.engine.utilities.calculation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashSet;

import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * This class provides an method to calculate simple mathematical functions. See
 * the public constants declared in this class for more informations about the
 * supported functions.
 * 
 * @author Philipp
 * 
 */
public class MathFunctionCalculator {

	// All supported mathematical functions.

	/** Defines the natural logarithm. */
	public static final String MATH_LN = "ln";
	/** Defines the 10 base logarithm. */
	public static final String MATH_LOG = "log";
	/** Defines the function to calculate the square of a value. */
	public static final String MATH_SQR = "sqr";
	/** Defines the function to calculate the square root. */
	public static final String MATH_SQRT = "sqrt";
	/** Defines the exponential function. */
	public static final String MATH_EXP = "exp";
	/** Defines the sine function (radian). */
	public static final String MATH_SIN = "sin";
	/** Defines the cosine function (radian). */
	public static final String MATH_COS = "cos";
	/** Defines the tangent function (radian). */
	public static final String MATH_TAN = "tan";
	/** Defines the arc sine function. */
	public static final String MATH_ASIN = "asin";
	/** Defines the arc cosine function. */
	public static final String MATH_ACOS = "acos";
	/** Defines the arc tangent function. */
	public static final String MATH_ATAN = "atan";
	/** Defines the hyperbolic sine function. */
	public static final String MATH_SINH = "sinh";
	/** Defines the hyperbolic cosine function. */
	public static final String MATH_COSH = "cosh";
	/** Defines the hyperbolic tangent function. */
	public static final String MATH_TANH = "tanh";
	/** Defines the function to calculate the absolute value. */
	public static final String MATH_ABS = "abs";
	/**
	 * Defines the function to convert an angle measured in radian to an angle
	 * measured in degrees.
	 */
	public static final String MATH_DEG = "deg";
	/**
	 * Defines the function to convert an angle measured in degrees to an angle
	 * measured in radian.
	 */
	public static final String MATH_RAD = "rad";
	/** Defines the function to calculate the integer part of a number. */
	public static final String MATH_INT = "int";
	/** Defines the function to calculate the decimal fraction of a number. */
	public static final String MATH_FRAC = "frac";
	/** Defines the rounding function. */
	public static final String MATH_ROUND = "round";
	/** Defines the function to identify the sign of the number. */
	public static final String MATH_SIGN = "sign";
	/** Defines the saltus function. */
	public static final String MATH_STEP = "step";

	/**
	 * Contains all functions, which supported by this class. This set is only
	 * needed for the method {@link #isMathFunction(String)}.
	 */
	private HashSet<String> mathFunctions = null;

	/**
	 * Default constructor.
	 */
	public MathFunctionCalculator() {

		mathFunctions = new HashSet<String>();

		mathFunctions.add(MATH_LN);
		mathFunctions.add(MATH_LOG);
		mathFunctions.add(MATH_SQR);
		mathFunctions.add(MATH_SQRT);
		mathFunctions.add(MATH_EXP);
		mathFunctions.add(MATH_SIN);
		mathFunctions.add(MATH_COS);
		mathFunctions.add(MATH_TAN);
		mathFunctions.add(MATH_ASIN);
		mathFunctions.add(MATH_ACOS);
		mathFunctions.add(MATH_ATAN);
		mathFunctions.add(MATH_SINH);
		mathFunctions.add(MATH_COSH);
		mathFunctions.add(MATH_TANH);
		mathFunctions.add(MATH_ABS);
		mathFunctions.add(MATH_DEG);
		mathFunctions.add(MATH_RAD);
		mathFunctions.add(MATH_INT);
		mathFunctions.add(MATH_FRAC);
		mathFunctions.add(MATH_ROUND);
		mathFunctions.add(MATH_SIGN);
		mathFunctions.add(MATH_STEP);
	}

	/**
	 * Calculates the new value with the respective mathematical function. All
	 * possible functions are declared as constants in this class.
	 * 
	 * @param function the function to calculate the new value
	 * @param value the current value
	 * 
	 * @return The result of the given mathematical function with the given
	 *         <code>value</code> as parameter.
	 * 
	 * @throws ParserException this exception will be thrown, if an invalid
	 *             value for the respective function is given.
	 * 
	 * @see #isMathFunction(String)
	 */
	public double calculateMathFunction(final String function, final double value)
			throws ParserException {

		double result = 0.0;

		if (function != null) {

			if (!Double.isNaN(value) && !Double.isInfinite(value)) {

				if (function.equals(MATH_LN)) {

					if (value > 0) {
						result = Math.log(value);
					} else {
						throw new ParserException(String.format(
							Messages.MathFunctionCalculator_log,
							value));
					}

				} else if (function.equals(MATH_LOG)) {

					if (value > 0) {
						result = Math.log10(value);
					} else {
						throw new ParserException(String.format(
							Messages.MathFunctionCalculator_log10,
							value));
					}

				} else if (function.equals(MATH_SQR)) {

					result = BigDecimal.valueOf(value).pow(2).doubleValue();

				} else if (function.equals(MATH_SQRT)) {

					if (value >= 0) {
						result = Math.sqrt(value);
					} else {
						throw new ParserException(String.format(
							Messages.MathFunctionCalculator_sqrt,
							value));
					}
				} else if (function.equals(MATH_EXP)) {

					result = Math.exp(value);
				} else if (function.equals(MATH_SIN)) {

					result = Math.sin(value);
				} else if (function.equals(MATH_COS)) {

					result = Math.cos(value);
				} else if (function.equals(MATH_TAN)) {

					result = Math.tan(value);
				} else if (function.equals(MATH_ASIN)) {

					if (Math.abs(value) <= 1) {
						result = Math.asin(value);
					} else {
						throw new ParserException(String.format(
							Messages.MathFunctionCalculator_arcsin,
							value));
					}
				} else if (function.equals(MATH_ACOS)) {

					if (Math.abs(value) <= 1) {
						result = Math.acos(value);
					} else {
						throw new ParserException(String.format(
							Messages.MathFunctionCalculator_arccos,
							value));
					}
				} else if (function.equals(MATH_ATAN)) {

					result = Math.atan(value);
				} else if (function.equals(MATH_SINH)) {

					result = Math.sinh(value);
				} else if (function.equals(MATH_COSH)) {

					result = Math.cosh(value);
				} else if (function.equals(MATH_TANH)) {

					result = Math.tanh(value);
				} else if (function.equals(MATH_ABS)) {

					result = Math.abs(value);
				} else if (function.equals(MATH_DEG)) {

					result = Math.toDegrees(value);
				} else if (function.equals(MATH_RAD)) {

					result = Math.toRadians(value);
				} else if (function.equals(MATH_INT)) {

					if (value >= 0) {
						result = Math.floor(value);
					} else {
						result = Math.ceil(value);
					}
				} else if (function.equals(MATH_FRAC)) {

					result =
							BigDecimal.valueOf(value).remainder(
								BigDecimal.ONE,
								MathContext.DECIMAL128).doubleValue();
				} else if (function.equals(MATH_ROUND)) {

					// result = roundValue(value);
					result = Math.round(value);

				} else if (function.equals(MATH_SIGN)) {

					result = Math.signum(value);
				} else if (function.equals(MATH_STEP)) {
					// 0: value < 0.0
					// 1: value >= 0.0
					result = value >= 0.0 ? 1.0 : 0.0;
				} else {
					throw new ParserException(String.format(
						Messages.MathFunctionCalculator_notsupported,
						function));
				}
			} else {
				throw new ParserException(String.format(
					Messages.MathFunctionCalculator_invalidvalue,
					value));
			}
		} else {
			throw new ParserException(
				Messages.MathFunctionCalculator_invalidfunction);
		}

		return result;
	}

	/**
	 * This method rounds a given value. The method is similar to the function
	 * <code>Math.round()</code>, but if 0.5 is given the result is 0 and only
	 * if the value is greater than 0.5 the result is 1.
	 * 
	 * @param value defines the value, which shall be rounded
	 * 
	 * @return The rounded value.
	 */
	/*
	 * private double roundValue(double value) {
	 * 
	 * double result = 0.0;
	 * 
	 * if(!Double.isNaN(value)) {
	 * 
	 * double roundedValue = Math.abs(value); double sign = Math.signum(value);
	 * 
	 * if(sign == 0) sign = 1;
	 * 
	 * if(roundedValue % 1 <= 0.5) { roundedValue = Math.floor(roundedValue);
	 * result = BigDecimal.valueOf(roundedValue).multiply(
	 * BigDecimal.valueOf(sign)).doubleValue(); } else { roundedValue =
	 * Math.floor(roundedValue); result = BigDecimal.valueOf(roundedValue).add(
	 * BigDecimal.ONE).multiply( BigDecimal.valueOf(sign)).doubleValue(); } }
	 * 
	 * return result; }
	 */

	/**
	 * Checks, if the given function is supported by this class. If yes, the
	 * result is <code>true</code>.
	 * 
	 * @param functionType the function type (e.g. "ln"); <b>HINT:</b> Use the
	 *            given constants by this class
	 * 
	 * @return If this class supports the function, the result is
	 *         <code>true</code>, otherwise <code>false</code>.
	 * 
	 * @throws ArgumentIsNullException will be thrown, if the function type is
	 *             "null"
	 */
	public boolean isMathFunction(final String functionType)
			throws ArgumentIsNullException {

		if (functionType == null) {
			throw new ArgumentIsNullException(
				Messages.MathFunctionCalculator_invalidfunction);
		}

		return mathFunctions.contains(functionType.trim().toLowerCase());
	}
}
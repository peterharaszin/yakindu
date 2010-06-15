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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.mda4e.simulation.core.event.EventDispatcher;

import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events.ParserEventFiredEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events.ParserValueChangedEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * The <code>Parser</code> allows the parsing and interpreting of actions,
 * expressions and functions. For more informations see the methods of this
 * class.
 * 
 * @author Philipp Richter, Christopher Brink
 */
public class Parser extends EventDispatcher {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(Parser.class);

	/**
	 * Defines the character which are removed from the expression of the
	 * transition.
	 */
	public static final String CNTRL_CHAR = "[\\p{Cntrl} ]";

	/** Defines the equation characters. */
	public static final String EQUAL = "==";
	/**
	 * Defines the characters which represents that to values are equal.
	 */
	public static final String UNEQUAL = "!=";
	/** Defines the "greater than" character. */
	public static final String GREATER = ">";
	/** Defines the "less than" character. */
	public static final String LESS = "<";
	/** Defines the "greater or equal" characters. */
	public static final String GREAT_EQ = ">=";
	/** Defines the "less or equal" characters. */
	public static final String LESS_EQ = "<=";
	/** Defines the "AND" characters. */
	public static final String AND = "&&";
	/** Defines the "OR" characters. */
	public static final String OR = "||";

	/** Defines the "true" characters. */
	public static final String TRUE = "true";
	/** Defines the "false" characters. */
	public static final String FALSE = "false";

	/** Defines the character of an addition. */
	public static final String ADD = "+";
	/** Defines the character of a subtraction. */
	public static final String SUB = "-";
	/** Defines the character of a multiplication. */
	public static final String MUL = "*";
	/** Defines the character of a division. */
	public static final String DIV = "/";
	/** Defines the character of a power. */
	public static final String POW = "^";

	/** Defines the character of the left parenthesis. */
	public static final String PAR_LEFT = "(";
	/** Defines the character of the right parenthesis. */
	public static final String PAR_RIGHT = ")";

	/** Defines the character of the open square bracket. */
	public static final String SQUAREBRACKET_LEFT = "[";
	/** Defines the character of the close square bracket. */
	public static final String SQUAREBRACKET_RIGHT = "]";

	/** Defines the character of the negative sign. */
	public static final String NEGATIVESIGN_STRING = "-";

	/**
	 * Defines the regular expression of allowed characters for the declaration
	 * of a variable or an event.
	 */
	public static final String VAR_CHARS = "[\\w_]+";

	/** Defines the character which indicates an assignment. */
	public static final String ASSIGN = "=";

	/**
	 * Defines the character of the character which cuts two behavior parts.
	 */
	public static final String BEHAV_TERMINATOR = ";";

	/** Defines the key of the send function ({@link #sendFunc}). */
	public static final String SEND = "send";
	/** Defines the start character of the send function ({@link #sendFunc}). */
	public static final String SEND_START = "(";
	/** Defines the end character of the send function ({@link #sendFunc}). */
	public static final String SEND_END = ")";

	/**
	 * Defines the allowed characters (except for relational operators) to
	 * define a guard.
	 * 
	 * @see #relOperators
	 */
	private static final String GUARD_CHAR = "[\\w_\\.\\+\\-\\*/^\\(\\)]+";

	/** Defines the allowed characters to define an action. */
	private static final String ACTION = "[\\w_\\.\\+\\-\\*/\\^=\\(\\)]+";

	/**
	 * Defines the regular expression to check whether the guard contains only
	 * "true" or "false" and no relational operator. The check is
	 * case-insensitive.
	 */
	// private static final String TRUE_FALSE = "((?i)((" + TRUE + ")|(" + FALSE
	// + "))(?i))";
	/**
	 * Defines the regular expression pattern which declares all allowed
	 * relational operators.
	 * <p>
	 * All possible operators are defined as constants in this class.
	 * </p>
	 */
	public static Pattern relOperators = null;
	/**
	 * Defines the regular expression pattern which declares all allowed
	 * calculation operators.
	 * <p>
	 * All possible operators are defined as constants in this class.
	 * </p>
	 */
	public static Pattern calcOperators = null;
	/**
	 * Defines the regular expression pattern which declares all allowed
	 * assignment operators.
	 * <p>
	 * All possible operators are defined as constants in this class.
	 * </p>
	 */
	public static Pattern assignOperators = null;
	/**
	 * Defines the regular expression pattern which declares all allowed group
	 * characters.
	 * <p>
	 * All possible characters are defined as constants in this class.
	 * </p>
	 */
	public static Pattern groupChars = null;
	/**
	 * Defines the regular expression pattern which declares the valid structure
	 * of an variable or event name.
	 */
	public static Pattern varChars = null;
	/**
	 * Defines the regular expression pattern which declares the valid structure
	 * of the method <code>send(event)</code>;
	 */
	public static Pattern sendFunc = null;
	/**
	 * Defines the regular expression to check whether the given expression is
	 * well-formed.
	 */
	public static Pattern validExpression = null;
	/**
	 * Defines the regular expression to check whether the given action is
	 * well-formed.
	 */
	public static Pattern validAction = null;
	/**
	 * Contains all supported relational and mathematical operators as well as
	 * assignment operators and group characters.
	 * <p>
	 * It combines the following <code>Pattern</code>s:
	 * <ul>
	 * <li>{@link #relOperators}</li>
	 * <li>{@link #calcOperators}</li>
	 * <li>{@link #assignOperators}</li>
	 * <li>{@link #groupChars}</li>
	 * </ul>
	 * </p>
	 */
	public static Pattern delimiters = null;

	static {

		relOperators =
				Pattern.compile("(\\Q" + EQUAL + "\\E|\\Q" + UNEQUAL
								+ "\\E|\\Q" + GREAT_EQ + "\\E|\\Q" + LESS_EQ
								+ "\\E|\\Q" + GREATER + "\\E|\\Q" + LESS
								+ "\\E|\\Q" + AND + "\\E|\\Q" + OR + "\\E)");

		calcOperators =
				Pattern.compile("(\\Q" + ADD + "\\E|\\Q" + SUB + "\\E|\\Q"
								+ MUL + "\\E|\\Q" + DIV + "\\E|\\Q" + POW
								+ "\\E)");

		assignOperators = Pattern.compile("(\\Q" + ASSIGN + "\\E)");

		groupChars =
				Pattern.compile("(\\Q" + PAR_LEFT + "\\E|\\Q" + PAR_RIGHT
								+ "\\E)");

		varChars = Pattern.compile("[\\w_]*[a-zA-Z_]+[\\w_]*");

		sendFunc =
				Pattern.compile("\\Q" + SEND + SEND_START + "\\E" + VAR_CHARS
								+ "\\Q" + SEND_END + "\\E");

		validExpression =
				Pattern.compile(GUARD_CHAR + relOperators.pattern()
								+ GUARD_CHAR + "(" + relOperators.pattern()
								+ GUARD_CHAR + ")*"); // |" + TRUE_FALSE + ")");

		validAction = Pattern.compile(ACTION + "(;" + ACTION + ")*" + ";?");

		delimiters =
				Pattern.compile("(" + relOperators.pattern() + "|"
								+ calcOperators.pattern() + "|"
								+ assignOperators + "|" + groupChars.pattern()
								+ ")");
	}

	/** The instance of the calculator for simple mathematical functions. */
	private MathFunctionCalculator functionCalc = null;

	/**
	 * Indicates whether an external variable which was submitted to a function
	 * as a parameter was changed.
	 */
	private boolean externalChanged = false;

	/**
	 * Creates an instance of the <code>Parser</code> with default
	 * configuration.
	 */
	public Parser() {

		functionCalc = new MathFunctionCalculator();
	}

	/**
	 * The method parses and interprets the expression and return the logical
	 * result.</br></br> <b>An example expression is:</b> </br>"[Variable1 &#060; (Variable2 - 25) && Variable3 * 3.4 &#062;= Variable4 * (5 - Input1) || Input2 == 5]"
	 * </br></br> <b>parenthesis are not allowed to encapsulates logical parts:
	 * </b>[2 &#062; Input1 || <b>(</b>2 &#062; Input2<b>)</b>]
	 * 
	 * @param expression the expression, which shall be calculated
	 * @param sourceElement defines the element which contains the expression
	 * @param varLists lists with all variables, which are used in the
	 *            expression (inputs, variables, outputs, ...)
	 * 
	 * @return The logical result of the expression.
	 * 
	 * @throws ParserException if an error occurs during the interpreting of the
	 *             expression
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	public boolean parseExpression(final String expression, final String sourceElement,
			final Map<String, Double>... varLists) throws ParserException,
			ArgumentIsNullException {

		String express = null;

		if (expression == null) {
			log.error("The expression is \"null\"!");
			throw new ArgumentIsNullException(
				Messages.Parser_expressionnotvalid);
		}

		try {

			express = expression.replaceAll(CNTRL_CHAR, "");

			// Cut [...] if exists
			if (express.startsWith(SQUAREBRACKET_LEFT)) {
				express = express.substring(1);
			}
			if (express.endsWith(SQUAREBRACKET_RIGHT)) {
				express = express.substring(0, express.length() - 1);
			}

			if (express.equals("")) {
				return true;
			}

			if (!validExpression.matcher(express).matches()) {
				throw new ParserException(Messages.Parser_expressionnotvalid);
			}

			// Splitting in tokens
			final List<String> tokenList = stringToToken(express);

			// Replacing variables by their values
			varToValue(tokenList, varLists);

			// Calculating the separate mathematical expressions
			int begin = 0;
			int tokenListSize = tokenList.size();

			for (int index = 0; index < tokenList.size(); index++) {

				if (relOperators.matcher(tokenList.get(index)).matches()) {

					// Expression at the beginning of the complete expression
					if (index - begin != 1) {
						calculate(tokenList.subList(begin, index));
						// Update the index into dependence of the new size of
						// the token list
						index = index - (tokenListSize - tokenList.size());
						tokenListSize = tokenList.size();
					}

					begin = index + 1;
				}

				// Expression at the end of the complete expression
				if (index == tokenList.size() - 1 && index - begin != 1) {
					calculate(tokenList.subList(begin, index + 1));
				}
			}

			// Interpreting the expression
			return interpretExpression(tokenList);

		} catch (final ParserException e) {

			throw new ParserException(createErrorMessage(
				Messages.Parser_expressioncouldnotsolve,
				e.getMessage(),
				express,
				sourceElement), e);
		}
	}

	/**
	 * This method parses one ore more actions and replaces used variables as
	 * well as inputs by the current values. After that, the action will be
	 * interpreted.</br> If more than an action is used, these get separated by
	 * a semicolon. Variables which are changed by an action are also updated in
	 * the lists. A send() trigger will be detected, too. In this case, the
	 * event <code>ParserEventFiredEvent</code> will be dispatched.</br></br>
	 * 
	 * <b>e.g.:</b>
	 * "Variable1 = 16 * Input1;Output1 = 0.5 - Variable2 * Input2;"
	 * 
	 * @param action defines the action to parse
	 * @param sourceElement defines the element which contains the action
	 * @param varLists specifies lists with all required variables
	 * 
	 * @throws ParserException if an error occurs during the processing of the
	 *             action
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	public void parseAction(final String action, final String sourceElement,
			final Map<String, Double>... varLists) throws ParserException,
			ArgumentIsNullException {

		boolean found = false;
		String act = action;

		if (act == null) {
			act = "";
		}

		if (varLists == null) {
			log
				.error("The list which contains the variable lists is \"null\"!");
			throw new ArgumentIsNullException(String.format(
				Messages.Parser_novariablesdefined,
				action));
		}

		try {

			act = act.replaceAll(CNTRL_CHAR, "");

			if (!act.equals("") && !validAction.matcher(act).matches()) {
				throw new ParserException(Messages.Parser_actionnotwellformed);
			}

			// Split actions (action1; action2)
			final List<String> actions = new ArrayList<String>();
			int pos = 0;

			while (act.length() != 0) {

				pos = act.indexOf(BEHAV_TERMINATOR);

				if (pos > 0) {
					actions.add(act.substring(0, pos));
					act = act.substring(pos + 1);
				}
				// Only one action without semicolon
				else if (pos == -1) {
					actions.add(act);
					act = "";
				}
			}

			// Define the target variable
			List<String> targets = null;
			int startPos = 0;
			pos = 0;

			for (String curAction : actions) {

				// Find events and activate them
				curAction = eventProcessing(curAction);

				if (curAction.length() > 0) {

					targets = new ArrayList<String>();

					startPos = 0;

					// var1=var2=3;
					while ((pos = curAction.indexOf(ASSIGN, startPos)) != -1) {

						targets.add(curAction.substring(startPos, pos));

						if (pos + 1 >= curAction.length()) {
							throw new ParserException(String.format(
								Messages.Parser_actionnotvalid,
								curAction));
						}

						startPos = pos + 1;
					}

					if (targets.size() == 0) {

						// No target found
						log.error("The action has no \"=\" (\"" + curAction
									+ "\")!");
						throw new ParserException(String.format(
							Messages.Parser_actionnotvalid,
							curAction));
					}

					curAction = curAction.substring(startPos);

					// Split string to tokens
					final List<String> tokenList = stringToToken(curAction);

					// Replace variables by their values
					varToValue(tokenList, varLists);

					// Interpreting the token list
					final Double newValue = calculate(tokenList);

					for (final String target : targets) {

						// Check, if the variable exist
						found = false;

						// TODO Use the same method to set variables which is
						// used for event firing
						for (final Map<String, Double> list : varLists) {

							if (list != null && list.containsKey(target)) {

								if (!list.get(target).equals(newValue)) {

									list.put(target, newValue);

									// TODO Possibly add the list hash code to
									// the event properties
									setExternalChanged();
									fireEvent(new ParserValueChangedEvent<Double>(
										target,
										newValue));

								}

								found = true;
								break;
							}
						}

						if (!found) {
							throw new ParserException(String.format(
								Messages.Parser_variablenotfound,
								target));
						}
					}
				}
			}
		} catch (final ParserException e) {

			throw new ParserException(createErrorMessage(
				Messages.Parser_actioncouldnotsolve,
				e.getMessage(),
				action,
				sourceElement), e);
		}
	}

	/**
	 * Allows to activate the variable change property. That means, if a
	 * external variable was changed which was submitted to a function of this
	 * class as a parameter the change property is set to <code>true</code>.
	 */
	private void setExternalChanged() {

		externalChanged = true;

		if (log.isDebugEnabled()) {
			log
				.debug("A value was changed: externalChanged is marked as \"true\"");
		}
	}

	/**
	 * Creates a meaningful message to describe the error.
	 * 
	 * <p>
	 * <b>Example:</b><br>
	 * <br>
	 * <i>The action could not solve: "action1"!</i><br>
	 * <br>
	 * <i>Error message...</i><br>
	 * <br>
	 * <i>Source: State1 -> "action1; action2; action3"</i><br>
	 * <i>(Source: "action1; action2; action3) // if the source has no name</i>
	 * </p>
	 * 
	 * @param infoMessage describes the current context
	 * @param errorMessage defines the error message
	 * @param action defines the source string why the exception was thrown
	 * @param element defines the element which contains the action
	 * 
	 * @return The created message to describe the problem.
	 */
	private String createErrorMessage(final String infoMessage, final String errorMessage,
			final String action, final String element) {

		final StringBuffer message = new StringBuffer();
		final StringBuffer source = new StringBuffer();

		if (element != null && !element.equals("")) {
			source.append(element);
			source.append(" -> ");
		}

		source.append("\"");
		source.append(action);
		source.append("\"");

		// Create error message
		message.append(infoMessage);
		message.append("\n\n");
		message.append(errorMessage);
		message.append("\n\n");
		message.append(String.format(Messages.Parser_source, source));

		return message.toString();
	}

	/**
	 * This method detects all <code>send()</code> events and fires the
	 * respective event to inform the listeners.
	 * 
	 * @param action defines the action to check
	 * 
	 * @return The result is the given action without all <code>send()</code>
	 *         actions.
	 */
	private String eventProcessing(final String action) {

		int startPos = 0;
		int endPos = 0;
		String event = null;

		String act = action;

		if (act != null) {

			if (sendFunc.matcher(act.toLowerCase()).matches()) {

				startPos = act.indexOf(SEND_START);
				endPos = act.indexOf(SEND_END);

				event = act.substring(startPos + 1, endPos);
				act = "";

				setExternalChanged();
				fireEvent(new ParserEventFiredEvent(event));
			}
		}

		return act;
	}

	/**
	 * This method solves a mathematical function and replaces the given input
	 * variables by the values.
	 * 
	 * @param function the function, which shall be solved
	 * @param sourceElement defines the element which contains the function
	 * @param varLists the variable lists with the current variables and their
	 *            values
	 * 
	 * @return The result of the mathematical function.
	 * 
	 * @throws ParserException if an error occurs during calculation of the
	 *             function
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	public double parseFunction(final String function, final String sourceElement,
			final Map<String, Double>... varLists) throws ParserException,
			ArgumentIsNullException {

		String func = function;

		try {

			if (func == null) {
				log.error("The function is \"null\"!");
				throw new ArgumentIsNullException(
					Messages.Parser_expressionnotvalid);
			}

			func = func.replaceAll(CNTRL_CHAR, "");

			if (func.equals("")) {
				log.error("The function is empty (\"\")!");
				throw new ParserException(Messages.Parser_expressionnotvalid);
			}

			// Splitting the function into separate tokens
			final List<String> tokenList = stringToToken(func);

			// Replacing variables by their values
			varToValue(tokenList, varLists);

			// Interpreting the token list
			return calculate(tokenList);

		} catch (final ParserException e) {

			throw new ParserException(createErrorMessage(
				Messages.Parser_functioncouldnotsolve,
				e.getMessage(),
				func,
				sourceElement), e);
		}
	}

	/**
	 * Solves a mathematical function with one variable. For more informations
	 * see <code>parseFunction(String, Map...)</code>.
	 * 
	 * 
	 * @param function the mathematical function to solve
	 * @param sourceElement defines the element which contains the expression
	 * @param variable defines the variable name (can be <code>null</code>)
	 * @param value defines the value of the given variable
	 * 
	 * @return The result of the mathematical function.
	 * 
	 * @throws ParserException if an error occurs during the calculation of the
	 *             function, this exception will be thrown
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	@SuppressWarnings("unchecked")
	public double parseFunction(final String function, final String sourceElement,
			final String variable, final double value) throws ParserException,
			ArgumentIsNullException {

		final Map<String, Double> list = new HashMap<String, Double>();

		list.put(variable, value);

		return parseFunction(function, sourceElement, list);
	}

	/**
	 * Interprets the token list and calculates the result of the function.<br>
	 * <p>
	 * Supported operators: +, -, *, /, ^
	 * </p>
	 * <p>
	 * <b>Example:</b><br>
	 * token list:
	 * <ul>
	 * <i>[0] 2</i><br>
	 * <i>[1] *</i><br>
	 * <i>[2] 2</i><br>
	 * <i>[3] -</i><br>
	 * <i>[4] 1.4</i>
	 * </ul>
	 * Result: 2.6
	 * </p>
	 * 
	 * @param tokenList contains all function tokens in form of a list
	 * 
	 * @return The result is the mathematical value of the function represented
	 *         by the token list.
	 * 
	 * @throws ParserException if an error occurs during the parsing
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	private Double calculate(final List<String> tokenList) throws ParserException,
			ArgumentIsNullException {

		Double tokenSum = 0.0;

		try {

			if (tokenList.size() > 0) {

				// 1. Detecting of (nested) parenthesis
				solveParenthesis(tokenList);

				// 2. Joining values with their possibly existing negative signs
				filterNegativeSign(tokenList);

				// 3. Calculating powers
				calculatePower(tokenList);

				// 4. Calculating multiplications and divisions
				calculateMulDiv(tokenList);

				// 5. Calculating additions and subtractions
				calculateAddSub(tokenList);

				if (tokenList.size() > 1) {
					log.error("The function/expression could not be solved (\""
								+ listToString(tokenList) + "\")!");
					throw new ParserException(String.format(
						Messages.Parser_exporfunccouldnotsolve,
						listToString(tokenList)));
				}

				try {

					// Saving the result
					tokenSum = Double.parseDouble(tokenList.get(0));

				} catch (final NumberFormatException e) {

					log.error("An unknown variable (" + listToString(tokenList)
								+ ") could not be converted into a number!", e);
					throw new ParserException(String.format(
						Messages.Parser_unknownvariable,
						listToString(tokenList)), e);
				}
			}

		} catch (final ParserException e) {
			throw new ParserException(e.getMessage(), e);
		} catch (final ArgumentIsNullException e) {
			throw new ArgumentIsNullException(e.getMessage(), e);
		} catch (final Exception e) {

			log
				.error(
					"During the calculation an unknown error was occured!",
					e);
			throw new ParserException(Messages.Parser_unknownerror + " "
										+ e.getMessage(), e);
		}

		return tokenSum;
	}

	/**
	 * Allows to create a normal string without ", " as delimiter between each
	 * token.
	 * 
	 * @param tokenList defines the token list
	 * 
	 * @return Returns a normal string like "[2=2]".
	 */
	private String listToString(final List<String> tokenList) {

		final StringBuffer result = new StringBuffer();

		for (final String token : tokenList) {
			result.append(token);
		}

		return result.toString();
	}

	/**
	 * This method solves the parenthesis and calculates the function according
	 * the mathematical rules.
	 * 
	 * @param tokenList specifies the function whose parenthesis shall be solved
	 * 
	 * @throws ParserException if an error during the parsing occurs
	 * @throws ArgumentIsNullException will be thrown, if the function type is
	 *             "null"
	 */
	private void solveParenthesis(final List<String> tokenList)
			throws ParserException, ArgumentIsNullException {

		int begin = 0;
		int end = 0;
		int openParenthesis = 0;
		int i = 0;

		while (i != tokenList.size()) {

			// Open parenthesis
			if (tokenList.get(i).equals(PAR_LEFT)) {

				openParenthesis++;

				if (openParenthesis == 1) {
					begin = i;
				}
			}

			// Close parenthesis
			if (tokenList.get(i).equals(PAR_RIGHT)) {

				openParenthesis--;

				if (openParenthesis == 0) {

					end = i;

					/*
					 * If the parenthesis belong to a mathematical function,
					 * calculate the function ("log(2)")
					 */
					if (begin > 0
						&& functionCalc
							.isMathFunction(tokenList.get(begin - 1))) {

						calculateMathFunction(tokenList.subList(
							begin - 1,
							end + 1));
						i = begin - 1;
					}
					// Calculating the part which is enclosed by parenthesis
					else {

						// Remove the parenthesis
						tokenList.remove(begin);
						tokenList.remove(end - 1);

						calculate(tokenList.subList(begin, end - 1));

						i = begin;
					}
				}
			}

			i++;
		}

		if (openParenthesis != 0) {
			log
				.error("The number of open and close parentheses of the function or expression are not equal!");
			throw new ParserException(Messages.Parser_wrongnumberparenthesis);
		}
	}

	/**
	 * Allows the calculation of mathematical functions based on the class
	 * <code>MathFunctionCalculator</code>.</br>
	 * 
	 * An example could look that way: [ ln,(,(,3,+,4,),*5,) ]
	 * 
	 * @param tokenList defines the list of tokens which represents the function
	 * 
	 * @throws ParserException if an error during the parsing occurs or the
	 *             mathematical functions is not supported
	 * @throws ArgumentIsNullException will be thrown, if the function type is
	 *             "null"
	 */
	private void calculateMathFunction(final List<String> tokenList)
			throws ParserException, ArgumentIsNullException {

		Double result = 0.0;

		calculate(tokenList.subList(2, tokenList.size() - 1));

		try {

			if (tokenList.size() != 4) {
				throw new NumberFormatException();
			}

			result =
					functionCalc.calculateMathFunction(tokenList.get(0), Double
						.valueOf(tokenList.get(2)));

		} catch (final NumberFormatException e) {
			throw new ParserException(String.format(
				Messages.Parser_functionpartwrong,
				listToString(tokenList)), e);
		}

		tokenList.clear();
		tokenList.add(result.toString());
	}

	/**
	 * This method filters out negative signs (-) and sets the signs to the
	 * specific values. If the value is already negative, it is replaced by his
	 * negative (value * -1).
	 * 
	 * @param tokenList defines the list of tokens which represents the function
	 * 
	 * @throws ParserException if an error during the parsing occurs or the
	 *             mathematical functions is not supported
	 */
	private void filterNegativeSign(final List<String> tokenList)
			throws ParserException {

		Double value = 0.0;

		if (tokenList.size() > 1) {

			/*
			 * First step:
			 * 
			 * Case: "{-, 2, +, 2}"
			 * 
			 * Result: "{-2, +, 2}"
			 * 
			 * Combine negative signs with the respective values, if those are
			 * at the beginning.
			 */
			if (tokenList.get(0).equals(NEGATIVESIGN_STRING)) {

				try {

					value = Double.valueOf(tokenList.get(1));

				} catch (final NumberFormatException e) {
					throw new ParserException(String.format(
						Messages.Parser_exporfunccouldnotsolve,
						listToString(tokenList)), e);
				}

				if (value.doubleValue() >= 0.0) {
					tokenList.set(0, NEGATIVESIGN_STRING + value);
				} else {
					tokenList.set(0, String.valueOf(Math.abs(value)));
				}

				tokenList.remove(1);
			}

			/*
			 * Second step:
			 * 
			 * Combine all negative signs with the respective values.
			 */
			for (int index = 1; index < tokenList.size() - 1; index++) {

				if (calcOperators.matcher(tokenList.get(index)).matches()
					&& tokenList.get(index + 1).equals(NEGATIVESIGN_STRING)) {

					// After the negative sign a value must follow
					if (index + 2 < tokenList.size()) {

						try {

							value = Double.valueOf(tokenList.get(index + 2));

						} catch (final NumberFormatException e) {
							throw new ParserException(String.format(
								Messages.Parser_exporfunccouldnotsolve,
								listToString(tokenList)), e);
						}

						// "-, 2" -> "-2"
						if (value.doubleValue() >= 0.0) {
							tokenList.set(index + 1, NEGATIVESIGN_STRING
														+ value);
						}

						/*
						 * If the value is negative, too: -- = + "-, -2" -> "2"
						 */
						else {
							tokenList.set(index + 1, String.valueOf(Math
								.abs(value)));
						}

						tokenList.remove(index + 2);

						// Error: token list look like this: "{2, *, 2, /, -}"
					} else {

						throw new ParserException(String.format(
							Messages.Parser_exporfunccouldnotsolve,
							listToString(tokenList)));
					}
				}
			}
		}
	}

	/**
	 * Calculates powers (^) if those exist in the token list.</br> An example
	 * could look that way: (..., -2, ^, 2, ...) -> -2^2 = -4.
	 * 
	 * @param tokenList defines the list of tokens which represents the function
	 * 
	 * @throws ParserException will be thrown, if a token could not be converted
	 *             into a <code>Double</code>
	 */
	private void calculatePower(final List<String> tokenList) throws ParserException {

		Double result = 0.0;
		Double base = 0.0;
		Double exponent = 0.0;

		for (int index = 0; index < tokenList.size() - 1; index++) {

			if (tokenList.get(index).equals(POW)) {

				try {
					base = Double.valueOf(tokenList.get(index - 1));
					exponent = Double.valueOf(tokenList.get(index + 1));

					result = Math.pow(base, exponent);

				} catch (final NumberFormatException e) {
					throw new ParserException(
						String.format(
							Messages.Parser_powercannotsolve,
							listToString(tokenList
								.subList(index - 1, index + 2))),
						e);
				}

				tokenList.set(index - 1, result.toString());
				tokenList.remove(index);
				tokenList.remove(index);
			}
		}
	}

	/**
	 * This method allows the calculation of multiplications and divisions.</br>
	 * An example could look that way: (..., 2, *, -2, ...) -> 2*-2 = 4.
	 * 
	 * @param tokenList defines the function in form of a list of tokens
	 * 
	 * @throws ParserException will be thrown, if a token could not be converted
	 *             into a <code>Double</code>
	 */
	private void calculateMulDiv(final List<String> tokenList) throws ParserException {

		Double result = null;

		for (int index = 1; index < tokenList.size() - 1; index++) {

			// Multiplication
			if (tokenList.get(index).equals(MUL)) {

				try {

					result =
							Double.parseDouble(tokenList.get(index - 1))
									* Double.parseDouble(tokenList
										.get(index + 1));

				} catch (final NumberFormatException e) {
					throw new ParserException(
						String.format(
							Messages.Parser_functionpartwrong,
							listToString(tokenList
								.subList(index - 1, index + 1))),
						e);
				}

				tokenList.set(index - 1, result.toString());

				tokenList.remove(index);
				tokenList.remove(index);

				index--;

				// Division
			} else if (tokenList.get(index).equals(DIV)) {

				try {

					result =
							Double.parseDouble(tokenList.get(index - 1))
									/ Double.parseDouble(tokenList
										.get(index + 1));

				} catch (final NumberFormatException e) {
					throw new ParserException(
						String.format(
							Messages.Parser_functionpartwrong,
							listToString(tokenList
								.subList(index - 1, index + 1))),
						e);
				}

				tokenList.set(index - 1, result.toString());

				tokenList.remove(index);
				tokenList.remove(index);

				index--;
			}
		}
	}

	/**
	 * This method allows the calculation of additions and subtractions.</br> An
	 * example could look that way: (..., 2, +, -2, ...) -> 2+-2 = 0.
	 * 
	 * @param tokenList defines the function in form of a list of tokens
	 * 
	 * @throws ParserException will be thrown, if a token could not be converted
	 *             into a <code>Double</code>
	 */
	private void calculateAddSub(final List<String> tokenList) throws ParserException {

		Double result = null;

		for (int index = 1; index < tokenList.size() - 1; index++) {

			// Addition
			if (tokenList.get(index).equals(ADD)) {

				try {

					result =
							Double.parseDouble(tokenList.get(index - 1))
									+ Double.parseDouble(tokenList
										.get(index + 1));

				} catch (final NumberFormatException e) {
					throw new ParserException(String.format(
						Messages.Parser_functionpartwrong,
						listToString(tokenList.subList(index - 1, index + 1))));
				}

				tokenList.set(index - 1, result.toString());

				tokenList.remove(index);
				tokenList.remove(index);

				index--;

				// Subtraction
			} else if (tokenList.get(index).equals(SUB)) {

				try {

					result =
							Double.parseDouble(tokenList.get(index - 1))
									- Double.parseDouble(tokenList
										.get(index + 1));

				} catch (final NumberFormatException e) {
					throw new ParserException(String.format(
						Messages.Parser_functionpartwrong,
						listToString(tokenList.subList(index - 1, index + 1))));
				}

				tokenList.set(index - 1, result.toString());

				tokenList.remove(index);
				tokenList.remove(index);

				index--;
			}
		}
	}

	/**
	 * The method uses an expression as base and produces out of it a list of
	 * separate tokens which represent the expression.
	 * 
	 * <p>
	 * Supported operators: ==, !=, >=, <=, &&, ||, +, -, *, /, (, ), <, >, =
	 * </p>
	 * 
	 * @param expression defines the expression
	 * 
	 * @return The result is a list of tokens with all operators ,variables and
	 *         so on.
	 */
	private List<String> stringToToken(final String expression) {

		final List<String> tokenList = new ArrayList<String>();

		if (expression != null) {

			final StringBuffer expr = new StringBuffer(expression);

			if (expr.length() > 1) {

				final StringBuffer part = new StringBuffer();
				CharSequence op1 = null;
				CharSequence op2 = null;
				int partLen = 0;

				// Initialize variables
				part.append(expr.charAt(0));
				expr.deleteCharAt(0);

				while (expr.length() > 0) {

					part.append(expr.charAt(0));
					expr.deleteCharAt(0);

					partLen = part.length();

					// Read the last two characters
					op2 = part.subSequence(partLen - 2, partLen);

					// Read The second to the last character
					op1 = part.subSequence(partLen - 2, partLen - 1);

					// Check operators with two characters ("==")
					if (delimiters.matcher(op2).matches()) {

						if (partLen > 2) {
							// Add operand
							tokenList.add(part.substring(0, partLen - 2));
						}
						// Add operator or parenthesis
						tokenList.add(op2.toString());

						part.setLength(0);

						if (expr.length() > 0) {
							part.append(expr.charAt(0));
							expr.deleteCharAt(0);
						}

						// Check operators with one character ("+")
					} else if (delimiters.matcher(op1).matches()) {

						if (partLen > 2) {
							// Add operand
							tokenList.add(part.substring(0, partLen - 2));
						}
						// Add operator or parenthesis
						tokenList.add(op1.toString());

						part.delete(0, partLen - 1);
					}
				}

				partLen = part.length();

				/*
				 * Check operator with one character:
				 * 
				 * The last character of the expression must be checked
				 * separately, because within the loop this character is not
				 * checked.
				 * 
				 * Example: Last two characters are: "7)"
				 * 
				 * The last character is not a value or a variable, so the last
				 * two characters must be cut.
				 */
				if (partLen > 0) {

					op1 = part.subSequence(partLen - 1, partLen);

					if (delimiters.matcher(op1).matches()) {

						if (partLen > 1) {
							tokenList.add(part.substring(0, partLen - 1));
						}
						tokenList.add(op1.toString());
					} else {
						tokenList.add(part.toString());
					}
				}
			} else {
				// Only one character found ("1") -> Splitting not required
				tokenList.add(expr.toString());
			}
		} else {
			log.warn("The given expression was \"null\"!");
		}

		return tokenList;
	}

	/**
	 * This method allows the replacing of all variables by their values. In
	 * their function the variable list and input list are equal. It is only a
	 * facilitation.
	 * 
	 * <p>
	 * Supported operators: +, -, *, /, (, ), <, >, >=, <=, ==, !=, &&, ||
	 * </p>
	 * 
	 * @param tokenList defines the function in form of a list of tokens
	 * @param varLists defines lists with the variables and their values
	 * 
	 * @throws ParserException if an error occurs during the replacement
	 */
	private void varToValue(final List<String> tokenList,
			final Map<String, Double>... varLists) throws ParserException {

		Double value = null;

		if (varLists != null) {

			for (final String curToken : tokenList) {

				if (varChars.matcher(curToken).matches()) {

					for (final Map<String, Double> variables : varLists) {

						// Replacing the variable by their value
						if (variables != null
							&& variables.containsKey(curToken)) {

							value = variables.get(curToken);

							if (value == null) {
								throw new ParserException(String.format(
									Messages.Parser_variablevalueisnull,
									curToken));
							}

							tokenList.set(tokenList.indexOf(curToken), String
								.valueOf(value));
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Interprets an expression and returns the boolean value.
	 * 
	 * @param tokenList defines the expression in form of a list of tokens
	 * 
	 * @return The result is the boolean value of the expression.
	 * 
	 * @throws ParserException if an error occurs during the parsing
	 */
	private boolean interpretExpression(final List<String> tokenList)
			throws ParserException {

		boolean expressionResult = false;

		int begin = 0;

		// Interprets each part of the expression (2>1 && 1<2 -> true && true)
		for (int index = 0; index < tokenList.size(); index++) {

			if (tokenList.get(index).equals(OR)
				|| tokenList.get(index).equals(AND)) {

				// Interpreting a expression part
				interpretExpressionPart(tokenList.subList(begin, index));

				// Adjusting the index and the new start index
				index = index - 2;
				begin = index + 1;
			}

			// Interpreting the last expression part
			if (index == tokenList.size() - 1) {
				interpretExpressionPart(tokenList.subList(begin, index + 1));
			}
		}

		// Interpret && (true && true || false -> true || false)
		for (int index = 1; index < tokenList.size() - 1; index++) {

			if (tokenList.get(index).equals(AND)) {

				if (Boolean.parseBoolean(tokenList.get(index - 1))
					&& Boolean.parseBoolean(tokenList.get(index + 1))) {

					tokenList.set(index - 1, TRUE);

				} else {

					tokenList.set(index - 1, FALSE);
				}

				tokenList.remove(index);
				tokenList.remove(index);
				index = 0;
			}
		}

		// Interpret || (true || false -> true)
		for (int index = 1; index < tokenList.size() - 1; index++) {

			if (tokenList.get(index).equals(OR)) {

				if (Boolean.parseBoolean(tokenList.get(index - 1))
					|| Boolean.parseBoolean(tokenList.get(index + 1))) {

					tokenList.set(index - 1, TRUE);

				} else {

					tokenList.set(index - 1, FALSE);
				}

				tokenList.remove(index);
				tokenList.remove(index);
				index = 0;
			}
		}

		if (tokenList.size() > 1) {
			log.error("The expression could not be solved (\""
						+ listToString(tokenList) + "\")!");
			throw new ParserException(String.format(
				Messages.Parser_exporfunccouldnotsolve,
				listToString(tokenList)));
		}

		expressionResult = Boolean.parseBoolean(tokenList.get(0));

		return expressionResult;
	}

	/**
	 * Interprets a simple expression with three tokens and returns the boolean
	 * value.</br> For example: 2 > 1 or 2 == 2.
	 * 
	 * @param tokenList defines the expression in form of a list of three tokens
	 * 
	 * @return The boolean result of the expression.
	 * 
	 * @throws ParserException if an error occurs during the parsing
	 */
	private boolean interpretExpressionPart(final List<String> tokenList)
			throws ParserException {

		boolean expressionPartResult = false;

		try {

			if (tokenList.get(1).equals(EQUAL)) {

				if (Double.parseDouble(tokenList.get(0)) == Double
					.parseDouble(tokenList.get(2))) {

					expressionPartResult = true;
					tokenList.set(0, TRUE);
				} else {

					expressionPartResult = false;
					tokenList.set(0, FALSE);
				}
			} else if (tokenList.get(1).equals(UNEQUAL)) {

				if (Double.parseDouble(tokenList.get(0)) != Double
					.parseDouble(tokenList.get(2))) {

					expressionPartResult = true;
					tokenList.set(0, TRUE);
				} else {

					expressionPartResult = false;
					tokenList.set(0, FALSE);
				}
			} else if (tokenList.get(1).equals(LESS)) {

				if (Double.parseDouble(tokenList.get(0)) < Double
					.parseDouble(tokenList.get(2))) {

					expressionPartResult = true;
					tokenList.set(0, TRUE);
				} else {

					expressionPartResult = false;
					tokenList.set(0, FALSE);
				}
			} else if (tokenList.get(1).equals(GREATER)) {

				if (Double.parseDouble(tokenList.get(0)) > Double
					.parseDouble(tokenList.get(2))) {

					expressionPartResult = true;
					tokenList.set(0, TRUE);
				} else {

					expressionPartResult = false;
					tokenList.set(0, FALSE);
				}
			} else if (tokenList.get(1).equals(GREAT_EQ)) {

				if (Double.parseDouble(tokenList.get(0)) >= Double
					.parseDouble(tokenList.get(2))) {

					expressionPartResult = true;
					tokenList.set(0, TRUE);
				} else {

					expressionPartResult = false;
					tokenList.set(0, FALSE);
				}
			} else if (tokenList.get(1).equals(LESS_EQ)) {

				if (Double.parseDouble(tokenList.get(0)) <= Double
					.parseDouble(tokenList.get(2))) {

					expressionPartResult = true;
					tokenList.set(0, TRUE);
				} else {

					expressionPartResult = false;
					tokenList.set(0, FALSE);
				}
			} else {

				log
					.error("During the parsing an unvalid or not supported relational operator (\""
							+ tokenList.get(1) + "\") was found!");
				throw new ParserException(String.format(
					Messages.Parser_wrongoperator,
					tokenList.get(1)));
			}

			tokenList.remove(1);
			tokenList.remove(1);

		} catch (final NumberFormatException e) {

			log.error("During the parsing a specific part (\""
						+ tokenList.get(0)
						+ "\") could not be converted into a number: ", e);
			throw new ParserException(String.format(
				Messages.Parser_wrongexpressionpart,
				tokenList.get(0)), e);
		}

		return expressionPartResult;
	}

	/**
	 * If at least one external variable was changed which was submitted to a
	 * function of this class as a parameter (<code>Map</code>), the return
	 * value is <code>true</code>. If no changes were done the result of this
	 * method is <code>false</code>.
	 * 
	 * @return The result is <code>true</code> if at least one external variable
	 *         was changed by a function of this class, otherwise
	 *         <code>false</code>.
	 */
	public boolean isExternalChanged() {

		return externalChanged;
	}

	/**
	 * Allows to disable the change state which indicates that an external
	 * variable was changed.
	 */
	public void resetExternalChanged() {

		externalChanged = false;
	}
}
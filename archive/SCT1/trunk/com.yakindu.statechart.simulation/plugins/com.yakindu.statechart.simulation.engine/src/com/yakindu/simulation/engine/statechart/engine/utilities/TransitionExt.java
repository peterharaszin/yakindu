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
package com.yakindu.simulation.engine.statechart.engine.utilities;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import statemachine.Node;
import statemachine.PseudoTypes;
import statemachine.Pseudostate;
import statemachine.Transition;

import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * The class <code>TransitionExt</code> extends the class {@link Transition} so
 * that the direct access to the trigger list, the guard constraint and the
 * behavior expression is possible.
 * 
 * @author Philipp Richter
 *
 */
public class TransitionExt {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(TransitionExt.class);

	/**
	 * Defines the characters which are removed from the expression of the
	 * transition.
	 */
	private static final String CNTRL_CHAR = "[\\p{Cntrl} ]";

	
	/** Keyword of the time trigger. */
	private static final String TIME_TRIGGER_KEYWORD = "after";

	private static final String TIME_UNIT_SECOND = "s";
	private static final String TIME_UNIT_MILLISECOND = "ms";
	private static final String TIME_UNIT_NANOSECOND = "ns";
	
	private static final String TIME_TRIGGER_PATTERN = 
		TIME_TRIGGER_KEYWORD + "\\(([\\d]+(\\.[\\d]+)?)(" + TIME_UNIT_SECOND + "|" + TIME_UNIT_MILLISECOND + "|" + TIME_UNIT_NANOSECOND + ")?\\)";
	private static final int TIME_TRIGGER_PATTERN_GROUP_VALUE = 1;
	private static final int TIME_TRIGGER_PATTERN_GROUP_UNIT = 3;
	
	
	
	/** Defines the allowed characters to define a trigger. */
	private static final String TRIGGER = "[\\w_]+";
	/**
	 * Defines the allowed characters (except for relational operators) to
	 * define a guard.
	 * 
	 * @see #GUARD_OP allowed relational operators
	 */
	private static final String GUARD_CHAR = "[\\w_\\.\\+\\-\\*/\\^\\(\\)]+";
	/**
	 * Defines the allowed relational operators which can be used to define a
	 * guard condition.
	 */
	private static final String GUARD_OP = "(==|!=|>=|<=|>|<|\\&\\&|\\|\\|)";
	/** Defines the allowed characters to define a behavior of the transition. */
	private static final String BEHAVIOR = "[\\w_\\.\\+\\-\\*/\\^=\\(\\)]+";
	/**
	 * Defines the regular expression to check whether the guard contains only
	 * "true" or "false" and no relational operator. The check is
	 * case-insensitive.
	 */
	private static final String TRUE_FALSE = "((?i)((true)|(false))(?i))";


	/** Defines the start character of the transition functionality. */
	private static final char START_FUNC = '[';
	/** Defines the end character of the transition functionality. */
	private static final char END_FUNC = ']';
	/** Defines the start character of the guard. */
	private static final char START_GUARD = '[';
	/** Defines the end character of the guard. */
	private static final char END_GUARD = ']';
	/** Defines the separator between two triggers. */
	private static final char TRIG_SEPARATOR = ',';
	/** Defines the begin of the behavior, if an behavior exists. */
	private static final char BEHAVIOR_BEGIN = '/';

	/** Defines pattern to check a trigger whether it is a time trigger. */
	public static Pattern patternTimeTrigger = null;

	/** The pattern to check the expression. */
	public static Pattern patternTransition = null;

	/**
	 * Defines a <code>Pattern</code> to check if the string contains "true" or
	 * "false". It is not case sensitive.
	 */
	public static Pattern patternTrueFalse = null;

	/** Defines all supported relational operators. */
	public static Pattern relOperators = null;

	
	static {

		// Definition of a time trigger
//		final String timeTrig =
//			TIME_TRIGGER_KEYWORD + "\\" + START_TIME + "([\\d]+(\\" + TIME_SEPARATOR
//			+ "[\\d]+)?)(s|ms|ns)?\\" + END_TIME;

		patternTimeTrigger = Pattern.compile(TIME_TRIGGER_PATTERN);

		patternTransition =
				Pattern.compile(

				"((" + TRIGGER + "|" + TIME_TRIGGER_PATTERN + ")(" + TRIG_SEPARATOR + "("
						+ TRIGGER + "|"
						+ TIME_TRIGGER_PATTERN
						+ "))*)?"
						+ // Trigger

						"(\\" + START_GUARD + "((" + GUARD_CHAR + GUARD_OP
						+ GUARD_CHAR + "(" + GUARD_OP + GUARD_CHAR + ")*)|"
						+ TRUE_FALSE + ")\\" + END_GUARD + ")?"
						+ // Guard

						"(" + BEHAVIOR_BEGIN + BEHAVIOR + "(;" + BEHAVIOR
						+ ")*" + ";?)?"); // Behavior

		relOperators = Pattern.compile("\\[.*" + GUARD_OP + ".*\\]");

		patternTrueFalse =
				Pattern.compile(
					"\\[" + TRUE_FALSE + "\\]",
					Pattern.CASE_INSENSITIVE);

	}

	/** Defines the transition which is extended by object of this class. */
	private Transition basicTransition = null;

	/** Contains all triggers of the transition. */
	private Set<String> triggers = null;
	/** Contains the guard condition of the transition. */
	private String guard = "";
	/** Contains the behavior of the transition. */
	private String behavior = "";
	/** Defines whether the transition has a time trigger. */
	private boolean hasTimeTrigger = false;
	/**
	 * Defines the time delay of the time trigger. If no time trigger exists the
	 * delay is -1.
	 */
	private double timeDelay = -1;

	/**
	 * Indicates whether the transition is activated and that the transition
	 * shall be executed by the simulator.
	 */
	private boolean active = false;

	/**
	 * @param basicTransition defines the basic transition which shall be
	 *            extended
	 * 
	 * @throws ArgumentIsNullException if one of the required properties of the
	 *             parameter or the parameter itself is <code>null</code>
	 */
	public TransitionExt(final Transition basicTransition) throws ArgumentIsNullException {

		if (basicTransition == null) {
			log.warn("A given base transition is null!");
			throw new ArgumentIsNullException(
				Messages.TransitionExt_basictransisnull);
		}

		if (basicTransition.getSourceNode() == null) {
			log.warn("The source state of the transition (ID: "
						+ basicTransition.getId() + ", Expression: "
						+ basicTransition.getExpression() + ") is null!");
			throw new ArgumentIsNullException(String.format(
				Messages.TransitionExt_nosourcestate,
				basicTransition.getId(),
				basicTransition.getExpression()));
		}

		if (basicTransition.getTargetNode() == null) {
			log.warn("The target state of the transition (ID: "
						+ basicTransition.getId() + ", Expression: "
						+ basicTransition.getExpression() + ") is null!");
			throw new ArgumentIsNullException(String.format(
				Messages.TransitionExt_notargetstate,
				basicTransition.getId(),
				basicTransition.getExpression()));
		}

		this.basicTransition = basicTransition;

		triggers = new HashSet<String>();
	}

	/**
	 * The method <code>setProperties</code> extracts the triggers, the guard
	 * constraint and the behavior from the expression. The expression is equal
	 * to the result of the method <code>getExpression</code>.
	 * 
	 * @throws ParserException if the expression of the transition is not valid
	 *             this exception will be thrown
	 */
	public void setProperties() throws ParserException {

		/*
		 * UML2 transition notation: <transition> ::= [<trigger> [�,�
		 * <trigger>]* [�[� <guard-constraint>�]�] [�/�
		 * <behavior-expression>]]
		 */

		int startPos = 0;
		int endPos = 0;
		final StringBuffer triggerlist = new StringBuffer();

		String functionality = basicTransition.getExpression();

		if (functionality != null && functionality.length() > 0) {

			if (log.isDebugEnabled()) {
				log.debug(String.format("Transition (ID: %s) expression: "
										+ functionality, getId()));
			}

			functionality = functionality.replaceAll(CNTRL_CHAR, "");

			// 1. Cut off the "[...]" around the functionality expression.

			/*
			 * 1. Check: Does the expression have two opening square brackets
			 * and is the first one at the beginning of the expression? ->
			 * "[trigger[guard]] 2. Check: Does the expression have two closing
			 * square brackets and is the second at the end of the expression?
			 * -> "[trigger[guard]]" 3. Check: Exceptional case:
			 * 
			 * If only a trigger and/or a behavior is declared the expression
			 * look like "[trigger/action]" or "[trigger]". If only a guard is
			 * defined the expression look like "[guard]", too.
			 * 
			 * In this case the characters between the squared brackets must be
			 * checked.
			 * 
			 * If at least one relational operator (not "=") exists the
			 * expression is a guard and the squared brackets must not be
			 * deleted.
			 */
			// Only if the expression of the transition look like "[...]"
			if (functionality.startsWith(String.valueOf(START_FUNC))
				&& functionality.endsWith(String.valueOf(END_FUNC))) {

				// 1., 2. and 3. Check
				if ((functionality.lastIndexOf(START_GUARD) > 0 && functionality
					.indexOf(END_GUARD) < functionality.length() - 1)
					||

					(!relOperators.matcher(functionality).matches() && !patternTrueFalse
						.matcher(functionality)
						.matches())) {

					if (functionality.length() > 2) {
						functionality =
								functionality.substring(1, functionality
									.length() - 1);
					}
				}
			}

			// Testing the expression on validity
			if (!patternTransition.matcher(functionality).matches()) {
				throw new ParserException(String.format(
					Messages.TransitionExt_invalidexpression,
					basicTransition.getId(),
					getStateName(getSourceNode()),
					getStateName(getTargetNode()),
					functionality));
			}

			// --- First step: Extract the triggers ---

			endPos = functionality.lastIndexOf(START_GUARD);

			/*
			 * If endPos == 0 -> no triggers are defined ([2<3]; "[" == position
			 * 0)
			 */
			if (endPos > 0) {
				// A guard was found.
				triggerlist.append(functionality.substring(0, endPos));
			} else if (endPos == -1) {
				// Does a behavior expression exist?
				endPos = functionality.indexOf(BEHAVIOR_BEGIN);

				if (endPos > -1) {
					// An behavior does exist.

					// Only if the length is greater than 0
					if (endPos > 0) {
						triggerlist.append(functionality.substring(0, endPos));
					}
				} else {
					triggerlist.append(functionality);
					functionality = "";
				}
			}

			String newTrigger = null;
			final String trigSeparator = String.valueOf(TRIG_SEPARATOR);

			// Splitting triggers
			while (triggerlist.length() != 0) {

				endPos = triggerlist.indexOf(trigSeparator);

				if (endPos != -1) {
					newTrigger = triggerlist.substring(0, endPos);
				} else {
					newTrigger = triggerlist.toString();
				}

				if (endPos != -1 && triggerlist.length() > endPos + 1) {
					triggerlist.delete(0, endPos + 1);
				} else {
					triggerlist.setLength(0);
				}

				if (newTrigger.length() > 0) {

					// A trigger may be assigned to a transition only once
					if (triggers.contains(newTrigger)) {
						throw new ParserException(String.format(
							Messages.TransitionExt_twotriggershavesamename,
							newTrigger,
							getId(),
							getStateName(getSourceNode()),
							getStateName(getTargetNode())));
					}

					triggers.add(newTrigger);
				}
			}

			// Checks if a time trigger like "after(5s)" exists
			checkTimeTrigger();

			// --- Second step: Extract the guard constraint ---

			startPos = functionality.lastIndexOf(START_GUARD);
			endPos = functionality.indexOf(END_GUARD);

			if (startPos != -1 && endPos != -1 && endPos > startPos + 1) {

				guard = functionality.substring(startPos + 1, endPos);

			} else if (startPos != -1 && endPos == -1 || startPos == -1
						&& endPos != -1) {
				log
					.warn("The transition which connects the states \""
							+ getSourceNode().getName()
							+ "\" and \""
							+ getTargetNode().getName()
							+ "\" has an error in the guard. A squared bracket is missing : \""
							+ functionality + "\"!");
				throw new ParserException(String.format(
					Messages.TransitionExt_invalidexpressionsquarebracket,
					basicTransition.getId(),
					getStateName(getSourceNode()),
					getStateName(getTargetNode()),
					functionality));
			}

			// --- Third step: Extract the behavior expression ---

			startPos = functionality.indexOf(BEHAVIOR_BEGIN);

			if (startPos != -1 && functionality.length() > startPos + 1) {
				behavior = functionality.substring(startPos + 1);
			}

			if (log.isDebugEnabled()) {
				final String transName = "Transition (ID: " + getId() + "): ";
				log.debug(transName + "Trigger: " + triggers.toString());
				log.debug(transName + "Guard: " + guard);
				log.debug(transName + "Behavior: " + behavior);
			}
		} else {
			if (log.isDebugEnabled()) {
				final String transName = "Transition (ID: " + getId() + "): ";
				log.debug(transName + "No expression defined!");
			}
		}
	}

	/**
	 * This method checks, whether a time trigger is defined. If a time trigger
	 * could be found, the delay time is set and if the source state is active,
	 * this transition must be informed to start the timer.
	 * 
	 * <b>Attention:</b> Only one time trigger is allowed.
	 * 
	 * @throws ParserException will be thrown, if the time is not valid
	 */
	private void checkTimeTrigger() throws ParserException {

		boolean timeTriggerFound = false;

		for (final String trigger : triggers) {

			// trigger must not have the time trigger key as name
			if (trigger.toLowerCase().equals(TIME_TRIGGER_KEYWORD.toLowerCase())) {
				throw new ParserException(String.format(
					Messages.TransitionExt_timetriggerasname,
					TIME_TRIGGER_KEYWORD,
					getId(),
					getStateName(getSourceNode()),
					getStateName(getTargetNode())));
			}

			Matcher m = patternTimeTrigger.matcher(trigger);
			if (m.matches()) {

				if (timeTriggerFound) {
					throw new ParserException(String.format(
						Messages.TransitionExt_onlyonetimetrigger,
						getId(),
						getStateName(getSourceNode()),
						getStateName(getTargetNode())));
				}

				timeTriggerFound = true;

				String timeWithoutUnit = m.group(TIME_TRIGGER_PATTERN_GROUP_VALUE);
				String unit = m.group(TIME_TRIGGER_PATTERN_GROUP_UNIT);
				
				try {

					double timeValue = Double.parseDouble(timeWithoutUnit.toString());
					double timeScale = 1;
					
					if (TIME_UNIT_SECOND.equals(unit)) timeScale = 1000.0;
					else if ( TIME_UNIT_NANOSECOND.equals(unit) ) timeScale = 0.000001;
					
					timeDelay = (long) (timeValue * timeScale);

					hasTimeTrigger = true;

				} catch (final NumberFormatException e) {
					log
						.warn("The time of the after() event could not be parsed: "
								+ timeWithoutUnit + "!");
					throw new ParserException(String.format(
						Messages.TransitionExt_invalidafterevent,
						timeWithoutUnit));
				}

			}
		}
	}

	/**
	 * Provides the name of the given {@link Node} instance. If the argument or
	 * the name is <code>null</code> or if the name is "", the result is a
	 * placeholder which indicates that the name is not defined.
	 * 
	 * @param state defines the <code>Node</code> instance whose name is sought.
	 * 
	 * @return The name or if no name was found a placeholder which indicates
	 *         that the name is not defined.
	 */
	public static synchronized String getStateName(final Node state) {

		String name = null;

		if (state != null) {

			name = state.getName();

			if (name == null || name.equals("")) {

				if (state instanceof Pseudostate) {
					name =
							Messages.General_pseudostate
									+ ": "
									+ ((PseudoTypes) state.eGet(state
										.eClass()
										.getEStructuralFeature("pseudoType")))
										.getName();
				} else {
					name = Messages.General_unknown;
				}
			}
		} else {
			log.warn("The argument \"state\" was \"null\"!");
			name = Messages.General_unknown;
		}

		return name;
	}

	/**
	 * If the transition has no triggers and no guard constraint the result of
	 * this method is <code>true</code>, otherwise <code>false</code>.
	 * 
	 * @return The result is <code>true</code>, if the transition can fired
	 *         directly.
	 */
	public boolean fireDirectly() {

		return triggers.isEmpty() && guard.length() == 0;
	}

	/**
	 * If this transition has a time based trigger the result is
	 * <code>true</code>, if not the result is <code>false</code>.
	 * 
	 * @return The result is <code>true</code>, if this transition has an time
	 *         trigger.
	 */
	public boolean hasTimeTrigger() {

		return hasTimeTrigger;
	}

	/**
	 * Returns the triggers of the transition.
	 * 
	 * @return The trigger list, if no triggers exist the list is empty.
	 */
	public Set<String> getTriggers() {

		return triggers;
	}

	/**
	 * Checks whether the given trigger is a trigger of this transition.
	 * 
	 * @param trigger defines the searched trigger
	 * 
	 * @return The result is <code>true</code>, if the trigger was found in the
	 *         trigger list of the transition, otherwise <code>false</code>.
	 */
	public boolean hasTrigger(final String trigger) {

		boolean result = false;

		if (trigger != null) {
			result = triggers.contains(trigger);
		}

		return result;
	}

	/**
	 * Returns the guard constraint of the transition.
	 * 
	 * @return The guard of the transition, if no guard exist the result is "".
	 */
	public String getGuard() {

		return guard;
	}

	/**
	 * Returns the behavior of the transition.
	 * 
	 * @return The behavior of the transition, if no behavior exist the result
	 *         is "".
	 */
	public String getBehavior() {

		return behavior;
	}

	/**
	 * Returns the expression of the transition with triggers, the guard and the
	 * behavior expression. The result is equal to
	 * {@link Transition#getExpression()}.
	 * 
	 * @return The expression of the transition.
	 */
	public String getExpression() {

		return basicTransition.getExpression();
	}

	/**
	 * Returns the priority of the transition. The result is equal to
	 * {@link Transition#getPriority()}.
	 * 
	 * @return The priority.
	 */
	public int getPriority() {

		return basicTransition.getPriority();
	}

	/**
	 * Returns the source node of the transition. The result is equal to
	 * {@link Transition#getSourceNode()}.
	 * 
	 * @return The source node.
	 */
	public Node getSourceNode() {

		return basicTransition.getSourceNode();
	}

	/**
	 * Returns the target node of the transition. The result is equal to
	 * {@link Transition#getTargetNode()}.
	 * 
	 * @return The target node.
	 */
	public Node getTargetNode() {

		return basicTransition.getTargetNode();
	}

	/**
	 * Returns the ID of the transition. The result is equal to
	 * {@link Transition#getId()}.
	 * 
	 * @return The transition ID.
	 */
	public int getId() {

		return basicTransition.getId();
	}

	/**
	 * Returns the transition which was extended by this class.
	 * 
	 * @return The basic transition.
	 */
	public Transition getBasicTransition() {

		return basicTransition;
	}

	/**
	 * Returns the state of the transition. If one of the triggers was activated
	 * e.g. by a time event the result is <code>true</code>, otherwise
	 * <code>false</code>. <b>Attention:</b> This method does not check the
	 * guard constraint ({@link #getGuard()}) of this transition! Whether the
	 * transition must be fired, the guard have to be checked separately.
	 * 
	 * @return If one of the triggers was activated, for example by an event or
	 *         the transition has no triggers the result is <code>true</code>,
	 *         otherwise the result is <code>false</code>.
	 */
	public boolean isActive() {

		boolean result = false;

		if (active || getTriggers().isEmpty()) {
			result = true;
		}

		return result;
	}

	/**
	 * Disposes this transition.
	 */
	public void dispose() {

	}

	/**
	 * Allows to activate the transition, so the transition will be fired next
	 * time. If the transition is deactivated and a timer trigger is available,
	 * it is deactivated.
	 * 
	 * @param active defines the new state
	 */
	public void setActive(final boolean active) {

		this.active = active;
	}

	/**
	 * Provides the time duration of the time trigger of this transition, if one
	 * is defined.
	 * 
	 * @return The delay of the time trigger. If no time trigger is defined and
	 *         consequently no time delay is available, the result is -1.
	 */
	public double getTimeTriggerDelay() {

		return timeDelay;
	}
}
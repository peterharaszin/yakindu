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
package com.yakindu.simulation.engine.statechart.engine;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.nls.Messages;

import statemachine.DataElement;
import statemachine.DataTypes;
import statemachine.Event;
import statemachine.Node;
import statemachine.PseudoTypes;
import statemachine.Pseudostate;
import statemachine.Region;
import statemachine.State;
import statemachine.Statechart;
import statemachine.Transition;
import statemachine.TriggerTypes;
import statemachine.Variable;

/**
 * This class allows to verify that a specific statechart is supported by the
 * <code>SCSimulator</code>. The <code>SCSupportVerifier</code> guarantees that
 * all elements of the statechart are supported by the simulator.<br>
 * The tests of e.g. expressions or actions is not the job of this class!
 * 
 * @author Philipp Richter
 */
public class SCSupportVerifier {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(SCSupportVerifier.class);

	/**
	 * Contains the results of the verification. All unsupported elements will
	 * be added to this list with a short message.
	 */
	private HashSet<String> results = null;

	/**
	 * Default constructor.
	 */
	public SCSupportVerifier() {

		results = new HashSet<String>();
	}

	/**
	 * Checks the support of the statechart. All elements in all levels will be
	 * verified.
	 * 
	 * @param statechart defines the statechart to verify
	 * 
	 * @return The result is a list with all elements, which are not supported.
	 *         If the list length is 0 the statechart is completely supported.
	 * 
	 * @throws UnableToParseStatechart will be thrown, if the statechart is
	 *             <code>null</code> or an exception during the verification
	 *             occurs.
	 */
	public HashSet<String> checkSupport(final Statechart statechart)
			throws UnableToParseStatechart {

		results.clear();

		if (statechart != null) {

			try {

				String statechartName = statechart.getName();

				if (statechartName == null || statechartName.equals("")) {
					addToResults(Messages.SCSimulator_noname);
					statechartName = Messages.General_unknown;
				}

				if (statechart.getUUID() == null
					|| statechart.getUUID().equals("")) {
					addToResults(Messages.SCSimulator_nouuid);
				}

				if (statechart.getRegion().isEmpty()) {
					addToResults(Messages.StatechartSupportVerifier_statecharthasnoregion);
				}

				// Verifying states and pseudo states
				verifyRegions(statechart.getRegion(), statechartName);

				verifyTransitions(statechart.getTransition());

				verifyDataElement(statechart.getDataElement());

			} catch (final Exception e) {

				if (log.isDebugEnabled()) {
					log.debug("An exception occured: " + e.getMessage(), e);
				}
				throw new UnableToParseStatechart(
					Messages.StatechartSupportVerifier_verifiererror + " "
							+ e.getMessage(),
					e);
			}

		} else {
			if (log.isDebugEnabled()) {
				log
					.debug("The statechart is not initialized (=\"null\"! The support check can not be executed!");
			}
			throw new UnableToParseStatechart(
				Messages.StatechartSupportVerifier_statechartnotinit);
		}

		return results;
	}

	/**
	 * This method verifies that the elements in the given region are supported.
	 * 
	 * @param regionList defines the list of regions
	 * @param parent defines the name of the container object of the regions.
	 *            The is only needed for the support messages
	 * 
	 * @throws Exception will be thrown, if an exception during the verification
	 *             occurs
	 */
	private void verifyRegions(final EList<Region> regionList, final String parent)
			throws Exception {

		try {

			EList<Node> statelist = null;
			State state = null;
			PseudoTypes type = null;

			if (regionList.size() > 1) {
				addToResults(String.format(
					Messages.StatechartSupportVerifier_tomuchregions,
					parent));
			}

			for (final Region r : regionList) {

				statelist = r.getState();

				for (final Node node : statelist) {

					// Pseudo state
					if (node.eClass().getName().equalsIgnoreCase("pseudostate")) {

						type =
								(PseudoTypes) node.eGet(node
									.eClass()
									.getEStructuralFeature("pseudoType"));

						if (log.isDebugEnabled()) {
							log.debug("Pseudo state found: " + type.getName()
										+ ", literal: " + type.getLiteral());
						}

						verifyPseudoState(type);

						// State
					} else if (node
						.eClass()
						.getName()
						.equalsIgnoreCase("state")) {

						state = (State) node;

						if (log.isDebugEnabled()) {
							log.debug("State found: " + state.getName()
										+ ", entry: \"" + state.getEntry()
										+ "\", do: \"" + state.getDo()
										+ "\", exit: \"" + state.getExit()
										+ "\"");
						}

						if (state.getRegion().size() > 0) {
							verifyRegions(state.getRegion(), state.getName());
						}

						// Final state
					} else if (node.eClass().getName().equalsIgnoreCase(
						"finalstate")) {

						if (log.isDebugEnabled()) {
							log.debug("Final state found: "
										+ ((State) node).getName());
						}

						// Unknown element
					} else {

						if (log.isDebugEnabled()) {
							log.debug("An unknown element was found: \""
										+ node.eClass().getName() + "\"!");
						}
						addToResults(String.format(
							Messages.StatechartSupportVerifier_unknownelement,
							node.eClass().getName()));
					}
				}
			}
		} catch (final Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	/**
	 * Checks whether all transitions are supported by the
	 * <code>SCSimulator</code>.
	 * <p>
	 * <b>Checks all transitions for:</b><br>
	 * - source and target transition must be in the same region
	 * </p>
	 * 
	 * @param transitions defines all transitions in the statechart which is
	 *            checked
	 */
	private void verifyTransitions(final EList<Transition> transitions) {

		boolean statesNull = false;

		for (final Transition transition : transitions) {

			// Source "null"
			if (transition.getSourceNode() == null) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_sourceisnull,
					transition.getTargetNode() != null ? transition
						.getTargetNode()
						.getName() : Messages.General_unknown));
				statesNull = true;
			}

			// Target "null"
			if (transition.getTargetNode() == null) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_targetisnull,
					transition.getSourceNode() != null ? transition
						.getSourceNode()
						.getName() : Messages.General_unknown));
				statesNull = true;
			}

			// Wrong target or invalid transition
			if (!statesNull) {

				String sourceState = transition.getSourceNode().getName();
				String targetState = transition.getTargetNode().getName();

				if (sourceState == null || sourceState.equals("")) {

					if (transition.getSourceNode() instanceof Pseudostate) {
						sourceState =
								Messages.General_pseudostate
										+ ": "
										+ ((PseudoTypes) transition
											.getSourceNode()
											.eGet(
												transition
													.getSourceNode()
													.eClass()
													.getEStructuralFeature(
														"pseudoType")))
											.getName();
					} else {
						sourceState = Messages.General_unknown;
					}
				}

				if (targetState == null || targetState.equals("")) {

					// Defining the target state type
					if (transition.getTargetNode() instanceof Pseudostate) {
						targetState =
								Messages.General_pseudostate
										+ ": "
										+ ((PseudoTypes) transition
											.getTargetNode()
											.eGet(
												transition
													.getTargetNode()
													.eClass()
													.getEStructuralFeature(
														"pseudoType")))
											.getName();
					} else {
						targetState = Messages.General_unknown;
					}
				}

				// Check whether the target state is an initial state
				if (transition.getTargetNode() instanceof Pseudostate
					&& ((Pseudostate) transition.getTargetNode())
						.getPseudoType() == PseudoTypes.INITIAL) {

					addToResults(String.format(
						Messages.StatechartSupportVerifier_initialastarget,
						sourceState));
				}

				// Check whether the source and target state are in the same
				// region
				if (!transition.getSourceNode().eContainer().equals(
					transition.getTargetNode().eContainer())) {

					addToResults(String
						.format(
							Messages.StatechartSupportVerifier_sourcetargetnotsameregion,
							sourceState,
							targetState));
				}
			}
		}
	}

	/**
	 * This method verifies the given pseudo state.
	 * 
	 * @param type the current pseudo state
	 * 
	 * @throws Exception will be thrown, if an exception during the verification
	 *             occurs
	 */
	private void verifyPseudoState(final PseudoTypes type) throws Exception {

		try {

			// Choice
			if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.CHOICE.getLiteral())) {

				// addToResults("The pseudo state \"" + type.getName() +
				// "\" (literal: \"" + type.getLiteral() +
				// "\") is not supported!");
				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Deep history
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.DEEP_HISTORY.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Entry point
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.ENTRY_POINT.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Exit point
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.EXIT_POINT.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Fork
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.FORK.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Initial
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.INITIAL.getLiteral())) {

				// supported!

				// Join
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.JOIN.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Junction
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.JUNCTION.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Shallow history
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.SHALLOW_HISTORY.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Terminate
			} else if (type.getLiteral().equalsIgnoreCase(
				PseudoTypes.TERMINATE.getLiteral())) {

				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));

				// Unknown pseudo state
			} else {

				if (log.isDebugEnabled()) {
					log.debug("An unknown pseudo state was found: \""
								+ type.getName() + "\" (literal: \""
								+ type.getLiteral() + "\")!");
				}
				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknownpseudostate,
					type.getName(),
					type.getLiteral()));
			}
		} catch (final Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	/**
	 * This method checks the given list of data elements, whether all elements
	 * are supported.
	 * 
	 * @param elementList defines the list of data elements
	 * 
	 * @throws Exception will be thrown, if an exception during the verification
	 *             occurs
	 */
	private void verifyDataElement(final EList<DataElement> elementList)
			throws Exception {

		Variable var = null;
		Event event = null;

		try {

			for (final DataElement element : elementList) {

				// Variable
				if (element.eClass().getName().equalsIgnoreCase("variable")) {

					var = (Variable) element;

					if (log.isDebugEnabled()) {
						log.debug("Variable found: " + var.getName()
									+ ", data type: " + var.getDataType()
									+ ", port: " + var.getPort()
									+ ", io type: " + var.getIoType());
					}

					verifyDataType(var.getDataType());

					// Event
				} else if (element.eClass().getName().equalsIgnoreCase("event")) {

					event = (Event) element;

					if (log.isDebugEnabled()) {
						log.debug("Event found: " + event.getName()
									+ ", port: " + event.getPort()
									+ ", io type: " + event.getIoType()
									+ ", trigger: " + event.getTrigger());
					}

					verifyTrigger(event.getTrigger());

					// Unknown data element
				} else {

					if (log.isDebugEnabled()) {
						log.debug("An unknown data element was found: \""
									+ element.getName() + "\"!");
					}
					addToResults(String.format(
						Messages.StatechartSupportVerifier_unknownelement,
						element.getName()));
				}
			}
		} catch (final Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	/**
	 * This method checks the given trigger, whether the type of the trigger is
	 * supported.
	 * 
	 * @param trigger defines the trigger
	 * 
	 * @throws Exception will be thrown, if an exception during the verification
	 *             occurs
	 */
	private void verifyTrigger(final TriggerTypes trigger) throws Exception {

		try {

			// Either
			if (trigger.getLiteral().equalsIgnoreCase(
				TriggerTypes.EITHER.getLiteral())) {

				// supported!

				// addToResults("The trigger \"" + trigger.getName() +
				// "\" (literal: \"" + trigger.getLiteral() +
				// "\") is not supported!");

				// Falling
			} else if (trigger.getLiteral().equalsIgnoreCase(
				TriggerTypes.FALLING.getLiteral())) {

				// supported!

				// Function call
			} else if (trigger.getLiteral().equalsIgnoreCase(
				TriggerTypes.FUNCTION_CALL.getLiteral())) {

				// supported!

				// Rising
			} else if (trigger.getLiteral().equalsIgnoreCase(
				TriggerTypes.RISING.getLiteral())) {

				// supported!

				// Unknown data element
			} else {

				if (log.isDebugEnabled()) {
					log.debug("A unknown trigger was found: \""
								+ trigger.getName() + "\"!");
				}
				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknowntrigger,
					trigger.getName(),
					trigger.getLiteral()));
			}
		} catch (final Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	/**
	 * This method checks whether the given data type is supported.
	 * 
	 * @param dataType defines the data type
	 * 
	 * @throws Exception will be thrown, if an exception during the verification
	 *             occurs
	 */
	private void verifyDataType(final DataTypes dataType) throws Exception {

		try {

			// Boolean
			if (dataType.getLiteral().equalsIgnoreCase(
				DataTypes.BOOLEAN.getLiteral())) {

				// supported!

				// Double
			} else if (dataType.getLiteral().equalsIgnoreCase(
				DataTypes.DOUBLE.getLiteral())) {

				// supported!

				// Int
			} else if (dataType.getLiteral().equalsIgnoreCase(
				DataTypes.INT.getLiteral())) {

				// supported!

				// Unknown data type
			} else {

				if (log.isDebugEnabled()) {
					log.debug("A unknown data type was found: \""
								+ dataType.getName() + "\"!");
				}
				addToResults(String.format(
					Messages.StatechartSupportVerifier_unknowndatatype,
					dataType.getName(),
					dataType.getLiteral()));
			}
		} catch (final Exception e) {

			throw new Exception(e.getMessage(), e);
		}
	}

	/**
	 * This method adds the messages with the unsupported elements to the result
	 * list. Each message can be added only once.
	 * 
	 * @param message defines the message
	 */
	private void addToResults(final String message) {

		if (!results.contains(message)) {
			log.warn(message);
			results.add(message);
		}
	}
}

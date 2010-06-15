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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.simulation.statemachine.event.StatemachineEvent.StatemachineEventTypes;

import com.yakindu.simulation.engine.statechart.engine.utilities.TransitionExt;
import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.Parser;
import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events.ParserEventFiredEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events.ParserValueChangedEvent;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ArgumentIsNullException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ChangeConfigurationException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ObjectDisposedException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.ParserException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.PseudostateNotImplemented;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.StatechartNotValid;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.SupportException;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.ITimeEventScheduler;
import com.yakindu.simulation.engine.statechart.engine.utilities.scheduling.TimeEvent;
import com.yakindu.simulation.engine.statechart.nls.Messages;

import statemachine.DataElement;
import statemachine.Event;
import statemachine.IOTypes;
import statemachine.Node;
import statemachine.Pseudostate;
import statemachine.Region;
import statemachine.State;
import statemachine.Statechart;
import statemachine.StatemachinePackage;
import statemachine.Transition;
import statemachine.Variable;

/**
 * <p>
 * The <code>SCSimulator</code> enables the simulation of statecharts which can
 * be read via statemachine files.
 * </p>
 * <p>
 * The following paragraph describes the rules of the simulator.
 * 
 * <p>
 * <b>Transition:</b>
 * 
 * <pre>
 *   - a transition will be fired, if ...
 * 	   
 *     - the source state is in the active state configuration
 *     - the guard condition is true (if the guard is empty the condition is true) 
 *     - an event was fired which equals to a trigger of the transition
 *     - or no triggers exist
 *     - if the transition has the highest priority of all active transitions of the current active state
 *     
 *   - the behavior of the transition is executed, if the transition is fired
 * </pre>
 * 
 * </p>
 * <p>
 * <b>State:</b>
 * 
 * <pre>
 *   - entry-Action is executed, if the state is entered
 *   - do-Action is executed until the state is active
 *   - exit-Action is executed, if the state is left
 * </pre>
 * 
 * </p>
 * 
 * @author Philipp Richter, Christopher Brink
 */
public class SCSimulator extends EventDispatcher implements IEventListener {

	/** Defines the instance to log informations and errors. */
	private static final Logger log = Logger.getLogger(SCSimulator.class);

	/** Defines the allowed syntax of a variable or event name. */
	public static Pattern patternVarChars = null;

	static {
		patternVarChars = Pattern.compile("[\\w_]*[a-zA-Z_]+[\\w_]*");
	}

	/** Scheduler to organize all time based events. */
	private ITimeEventScheduler scheduler;

	/**
	 * This object is used to synchronize all <code>wait()</code> and
	 * <code>notify()</code> calls.
	 */
	private Object lockObj = null;

	/**
	 * If it is not null an parser exception was occurred and the simulation
	 * must be stopped.
	 */
	private ParserException parserError = null;

	/** Specifies the name of the statechart. */
	private String name = null;
	/** Defines the UUID of the statechart instance. */
	private String uUID = null;
	/**
	 * Specifies the instance identifier of the statechart. For example, the
	 * instance number is greater than one, if multiple instances of the same
	 * statechart will be used in the same blocksystem.
	 */
	private int instance = 1;
	/** The statechart instance, which shall be simulated. */
	private Statechart statechart = null;
	/** The start node of the statechart. */
	private TransitionExt startTransition = null;
	/** Defines, whether the final state was achieved. */
	private boolean endState = false;

	/** Used to detect the first run */
	private boolean firstRun = true;

	// /** Indicates that all timers are paused, if the simulation was paused.
	// */
	// boolean timerPaused = false;

	/** List of all transitions in the statemachine. */
	private Map<Integer, TransitionExt> transitions = null;
	/** List with all active regions. */
	private List<Region> activeRegions = null;
	/** List with all active states. */
	private List<State> activeStates = null;

	/** Defines the transition which must be fired. */
	private TransitionExt transToFire = null;

	/** Parser for all expressions and actions. */
	private Parser statechartParser = null;

	/**
	 * Contains all <code>DataElement</code>s and allows the search via hash
	 * code, so it is faster and easier to find a specific object. This list is
	 * needed if a new event shall be sent and a corresponding object is needed.
	 */
	private Map<String, DataElement> dataElementList = null;
	/** List with all events of the statemachine. */
	private Map<String, Boolean> eventList = null;
	/** List with all local variables. */
	private Map<String, Double> varList = null;
	/** List with all inputs of the statechart. */
	private Map<String, Double> inputList = null;
	/** List with all outputs of the statechart. */
	private Map<String, Double> outputList = null;

	/** Indicates whether the statemachine is loaded and initialized. */
	private boolean isInitialized = false;
	/**
	 * Indicates whether at least one variable or event was changed by the user
	 * when the simulation was paused.
	 */
	private boolean stateConfigurationChanged = false;

	/** Indicates that this instance is disposed. */
	private boolean disposed = false;

	/**
	 * Creates an instance of this class with the given time scheduler.
	 * 
	 * @param scheduler defines the time event scheduler which allows triggering
	 *            of time events of the state chart.
	 */
	public SCSimulator(ITimeEventScheduler scheduler) {

		this.scheduler = scheduler;
		scheduler.addEventListener(getTimeEventListener());

		lockObj = new Object();

		statechartParser = new Parser();
		statechartParser.addEventListener(this);
	}

	/**
	 * Reserves all necessary resources and initializes the statemachine which
	 * shall be simulated.
	 * 
	 * @param path the absolute path of the statechart file
	 * 
	 * @throws StatechartNotValid will be thrown, if the statechart is not valid
	 * @throws ParserException if an error occurs during the parsing or
	 *             interpreting of transition expressions, this exception will
	 *             be thrown
	 * @throws UnableToParseStatechart will be thrown, if the statechart can not
	 *             be read or parsed
	 * @throws ArgumentIsNullException will be thrown, if the argument or a part
	 *             of it is "null"
	 * @throws SupportException if one or more elements of the statechart are
	 *             not supported, this exception will be thrown
	 * @throws ObjectDisposedException will be thrown, if the simulator is
	 *             disposed
	 */
	public void initializeStatemachine(final String path)
			throws StatechartNotValid, ParserException,
			UnableToParseStatechart, ArgumentIsNullException, SupportException,
			ObjectDisposedException {

		if (disposed) {
			throw new ObjectDisposedException(Messages.SCSimulator_disposed);
		}

		isInitialized = false;

		try {

			// Reading of the statechart file
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
			final ResourceSet resourceSet = new ResourceSetImpl();
			// The file extension is: "statemachine"
			resourceSet.getPackageRegistry().put(
				"statemachine",
				StatemachinePackage.eINSTANCE);
			final URI fileURI = URI.createURI("file:///" + path);

			final Resource resource = resourceSet.getResource(fileURI, true);
			statechart = (Statechart) resource.getContents().get(0);

		} catch (final Exception e) {
			throw new UnableToParseStatechart(String.format(
				Messages.SCSimulator_unabletoparse,
				path), e);
		}

		// Reading the statechart informations
		uUID = statechart.getUUID();
		name = statechart.getName();

		if (uUID == null || uUID.equals("")) {
			throw new StatechartNotValid(Messages.SCSimulator_nouuid);
		}

		if (name == null || name.equals("")) {
			throw new StatechartNotValid(Messages.SCSimulator_noname);
		}

		// Checking whether the simulator supports the statechart
		final SCSupportVerifier verifier = new SCSupportVerifier();
		final HashSet<String> results = verifier.checkSupport(statechart);

		if (!results.isEmpty()) {
			throw new SupportException(Messages.SCSimulator_supporterrors
										+ createMessage(results));
		}

		// Initialize all lists
		transitions = new HashMap<Integer, TransitionExt>();
		activeRegions = new ArrayList<Region>();
		activeStates = new ArrayList<State>();

		dataElementList = new HashMap<String, DataElement>();
		eventList = new HashMap<String, Boolean>();
		varList = new HashMap<String, Double>();
		inputList = new HashMap<String, Double>();
		outputList = new HashMap<String, Double>();

		// Instantiate variables and events
		setIOElements();

		activeRegions.add(statechart.getRegion().get(0));

		Node startNode = null;

		// Identify the initial state of the region with the highest priority.
		for (final Node n : activeRegions.get(0).getState()) {
			// Checking, if initial pseudo state
			if (n.eClass().getName().equalsIgnoreCase("Pseudostate")
				&& n
					.eGet(n.eClass().getEStructuralFeature("pseudoType"))
					.toString()
					.equalsIgnoreCase("initial")) {

				startNode = n;
				break;
			}
		}

		if (startNode == null) {
			throw new StatechartNotValid(Messages.SCSimulator_noinitialstate);
		}

		TransitionExt transExt = null;

		// Load all transitions of the statechart and find the first state.
		for (final Transition transition : statechart.getTransition()) {
			// Create, initialize and add the transition to the transition list
			transExt = new TransitionExt(transition);
			transExt.setProperties();

			// Check whether all triggers of the transitions are defined in the
			// statechart definition
			for (final String trigger : transExt.getTriggers()) {

				// If it is not a time trigger and does not exist
				if (!TransitionExt.patternTimeTrigger
					.matcher(trigger)
					.matches()
					&& !eventList.containsKey(trigger)) {
					throw new StatechartNotValid(String.format(
						Messages.SCSimulator_triggernotdefined,
						trigger,
						transExt.getId(),
						TransitionExt.getStateName(transExt.getSourceNode()),
						TransitionExt.getStateName(transExt.getTargetNode())));
				}
			}

			transitions.put(transExt.getId(), transExt);

			if (transition.getSourceNode().equals(startNode)) {

				if (transExt.getGuard().length() == 0
					&& transExt.getTriggers().isEmpty()) {

					if (transition
						.getTargetNode()
						.eClass()
						.getName()
						.equalsIgnoreCase("State")) {

						// Set the start node.
						startTransition = transExt;

					} else {

						// Exception, target node is not a state.
						throw new StatechartNotValid(String.format(
							Messages.SCSimulator_initialstatewrongconnected
									+ " "
									+ transition.getTargetNode().getName()
									+ "!",
							transition.getTargetNode().getId()));
					}
				} else {

					// Error, the transition of the initial state has an
					// expression.
					throw new StatechartNotValid(String.format(
						Messages.SCSimulator_initialstatetranshasexpression,
						transition.getExpression()));
				}
			}
		}

		isInitialized = true;
	}

	/**
	 * This method helps to create one message out of a set of messages. The
	 * result is listing with rows like " - message".
	 * 
	 * @param messages defines the set of messages
	 * 
	 * @return The result is a listing of all messages as one
	 *         <code>String</code>.
	 */
	private String createMessage(final Set<String> messages) {

		final StringBuffer result = new StringBuffer(250);

		for (final String message : messages) {

			result.append(" - " + message + "\n\n");
		}

		result.trimToSize();

		if (result.length() > 2) {
			result.deleteCharAt(result.length() - 1);
		}

		return result.toString();
	}

	/**
	 * Resets the simulation configuration. After that the simulation has the
	 * same state as after calling the {@link #initializeStatemachine(String)}
	 * method.
	 * 
	 * @throws StatechartNotValid will be thrown, if the statemachine was not
	 *             initialized by calling the method
	 *             <code>initializeStatemachine(String)</code>
	 * @throws ObjectDisposedException will be thrown, if the simulator is
	 *             disposed
	 */
	public void resetStatemachine() throws StatechartNotValid,
			ObjectDisposedException {

		if (disposed) {
			throw new ObjectDisposedException(Messages.SCSimulator_disposed);
		}

		if (!isInitialized) {
			throw new StatechartNotValid(
				Messages.SCSimulator_statemachinenotinitialized);
		}

		// Reset simulation state
		endState = false;
		firstRun = true;
		// timerPaused = false;
		parserError = null;

		// Reset transitions
		for (final TransitionExt transition : transitions.values()) {
			transition.setActive(false);
		}

		// Reset active regions
		activeRegions.clear();
		activeRegions.add(statechart.getRegion().get(0));

		// Reset active states
		activeStates.clear();

		// Reset variables
		for (final String input : inputList.keySet()) {
			inputList.put(input, 0.0);
		}
		for (final String variable : varList.keySet()) {
			varList.put(variable, 0.0);
		}
		for (final String output : outputList.keySet()) {
			outputList.put(output, 0.0);
		}

		// Reset events
		for (final String event : eventList.keySet()) {
			eventList.put(event, false);
		}
	}

	/**
	 * Returns the unique identifier of the statechart (UUID).
	 * 
	 * @return The uuid of the system which is simulated by this simulator. If
	 *         the simulator is not initialized the result is <code>null</code>.
	 */
	public String getUUID() {

		return uUID;
	}

	/**
	 * Returns the name of the statechart.
	 * 
	 * @return The name of the statechart. If the simulator is not initialized,
	 *         the result is <code>null</code>.
	 */
	public String getName() {

		return name;
	}

	/**
	 * Returns the value of the given variable of the current statemachine. The
	 * variable can be an input, output or a variable of the statechart.
	 * 
	 * @param name defines the name of the variable whose value is sought
	 * 
	 * @return The value of the given variable, if the variable could not be
	 *         found or the simulator was not initialized, the result is
	 *         <code>null</code>.
	 */
	public Double getVariable(final String name) {

		Double result = null;

		if (varList != null) {
			result = varList.get(name);
		}

		if (result == null && inputList != null) {
			result = inputList.get(name);
		}

		if (result == null && outputList != null) {
			result = outputList.get(name);
		}

		return result;
	}

	/**
	 * Returns the state of the given event of the current statemachine.
	 * 
	 * @param name defines the name of the variable whose value is sought
	 * 
	 * @return The state of the given event, if the event could not be found or
	 *         the simulator was not initialized or was disposed, the result is
	 *         <code>null</code>.
	 */
	public Boolean getEvent(final String name) {

		Boolean result = null;

		if (eventList != null) {

			result = eventList.get(name);
		}

		return result;
	}

	/**
	 * Returns the list with all events of the current statemachine.
	 * 
	 * @return The list of all events.
	 */
	public Map<Event, Boolean> getEventList() {

		final Map<Event, Boolean> events = new HashMap<Event, Boolean>();

		if (eventList != null && dataElementList != null) {

			for (final String variable : eventList.keySet()) {

				events.put((Event) dataElementList.get(variable), eventList
					.get(variable));
			}
		}

		return events;
	}

	/**
	 * Returns the list with all variables of the current statemachine.
	 * 
	 * @return The list of all variables.
	 */
	public Map<Variable, Double> getVariableList() {

		final Map<Variable, Double> variables = new HashMap<Variable, Double>();

		if (varList != null && dataElementList != null) {

			for (final String variable : varList.keySet()) {

				variables.put((Variable) dataElementList.get(variable), varList
					.get(variable));
			}
		}

		return variables;
	}

	/**
	 * Returns the list with all inputs of the current statemachine.
	 * 
	 * @return The list of all inputs.
	 */
	public Map<Variable, Double> getInputList() {

		final Map<Variable, Double> inputs = new HashMap<Variable, Double>();

		if (inputList != null && dataElementList != null) {

			for (final String variable : inputList.keySet()) {

				inputs.put((Variable) dataElementList.get(variable), inputList
					.get(variable));
			}
		}

		return inputs;
	}

	/**
	 * Returns the list with all outputs of the current statemachine.
	 * 
	 * @return The list of all outputs.
	 */
	public Map<Variable, Double> getOutputList() {

		final Map<Variable, Double> outputs = new HashMap<Variable, Double>();

		if (outputList != null && dataElementList != null) {

			for (final String variable : outputList.keySet()) {

				outputs.put(
					(Variable) dataElementList.get(variable),
					outputList.get(variable));
			}
		}

		return outputs;
	}

	/**
	 * Calculates and processes the next step of the simulation.
	 * 
	 * <p>
	 * <b>Tasks of this method are for example:</b>
	 * <ul>
	 * <li>State changes</li>
	 * <li>Region changes</li>
	 * <li>Expression interpreting</li>
	 * <li>Action processing</li>
	 * </ul>
	 * </p>
	 * 
	 * @throws PseudostateNotImplemented will be thrown, if a pseudo state has
	 *             not been implemented
	 * @throws ChangeConfigurationException if an error occurs during the next
	 *             step process
	 * @throws ParserException this exception will be thrown, if an error occurs
	 *             during the parsing or interpreting of an action or an
	 *             expression
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 * @throws ObjectDisposedException will be thrown, if the simulator is
	 *             disposed
	 */
	@SuppressWarnings("unchecked")
	public void changeStateConfiguration() throws ParserException,
			ArgumentIsNullException, ChangeConfigurationException,
			PseudostateNotImplemented, ObjectDisposedException {

		if (disposed) {
			throw new ObjectDisposedException(Messages.SCSimulator_disposed);
		}

		if (activeStates == null) {
			throw new ChangeConfigurationException(
				Messages.SCSimulator_changestatenotinitialized);
		}

		synchronized (lockObj) {

			// If the final state is not active...
			if (!endState) {

				// // Continuing all time triggers, if they are paused.
				// if (timerPaused) {
				//
				// final long currentTime = System.currentTimeMillis();
				// for (final TransitionExt transition : transitions.values()) {
				// transition.resumeTimeTrigger(currentTime);
				// }
				// timerPaused = false;
				// }

				List<TransitionExt> transToDeactivate = null;

				if (firstRun) {

					transToFire = startTransition;

					firstRun = false;

				} else {

					// Check whether anything is to do
					checkActivity();

					// Process all active events
					processEvents();

					// Define the transition to fire and all transitions which
					// must be deactivated
					transToDeactivate = getTransToFire();
				}

				if (transToFire == null) {

					// State will not changed -> execute do-action.
					for (int i = 0; i < activeStates.size(); i++) {
						if (activeStates.get(i).getDo() != null) {
							// Calculating the do-action and changing the
							// outputs as well as the variables.
							statechartParser.parseAction(
								activeStates.get(i).getDo(),
								activeStates.get(i).getName(),
								inputList,
								outputList,
								varList);
						}
					}
				} else {
					// state will be changed.

					// Mark the state configuration as changed
					setStateConfigurationChanged(true);

					// Deactivate all transitions and sub transitions of the
					// state which must be deactivated
					deactivateTransitions(transToDeactivate);

					// Removing old states and executing their exit-action.
					int numberOfStates = 0;

					// Deactivating all state, begun by the undermost state
					// until the state was found which is the source
					// state of the active transition.
					for (int i = activeStates.size() - 1; i >= 0; i--) {

						// Process the exit action
						statechartParser.parseAction(
							activeStates.get(i).getExit(),
							activeStates.get(i).getName(),
							inputList,
							outputList,
							varList);

						// Fire event to inform the listeners.
						fireEvent(new StatemachineEvent(
							StatemachineEventTypes.StateDisabled,
							activeStates.get(i),
							uUID,
							instance));

						// Is the state the source state of the active
						// transition?
						if (!activeStates.get(i).equals(
							transToFire.getSourceNode())) {

							if (activeRegions.size() > 1) {
								activeRegions
									.remove((activeRegions.size() - 1));
							}

							activeStates.remove(i);

						} else {
							// It is the source state of the active transition

							activeStates.remove(i);

							// Saving the number of states.
							numberOfStates = i;
							break;
						}
					}

					// Execute the behavior expression of the transition
					statechartParser.parseAction(
						transToFire.getBehavior(),
						null,
						inputList,
						outputList,
						varList);

					// Transition is active: Fire event to inform the listeners.
					fireEvent(new StatemachineEvent(
						StatemachineEventTypes.TransitionFired,
						transToFire.getBasicTransition(),
						uUID,
						instance));

					// Define the new active state
					Node target = transToFire.getTargetNode();

					int numberOfCycles = 0;

					while (target != null) {

						// security check to avoid a infinite loop
						if (numberOfCycles > 2000) {
							log.error("An infinite loop is occured during the "
										+ "detection of the new states!");
							throw new ChangeConfigurationException(
								Messages.SCSimulator_infiniteloop);
						}

						numberOfCycles++;

						if (target.eClass().getName().equalsIgnoreCase(
							"Pseudostate")) {

							target = checkPseudostate(target);

						} else if (target.eClass().getName().equalsIgnoreCase(
							"FinalState")) {
							// Step is finished.

							target = null;

							activeRegions.remove(activeRegions.size() - 1);

							// Checking, if the final state is in a sub state.
							if (activeRegions.size() == 0) {
								setFinished();
							}

						} else if (target.eClass().getName().equalsIgnoreCase(
							"State")) {
							// Founded node is a state.

							final State activeState = activateState(target);

							// Check whether the state has sub states.
							target = activateSubStates(activeState);
						}
					}

					// Executing the actions of the active states which were not
					// exited.
					for (int i = 0; i < numberOfStates; i++) {
						statechartParser.parseAction(
							activeStates.get(i).getDo(),
							activeStates.get(i).getName(),
							inputList,
							outputList,
							varList);
					}
				}
			}

			// Check whether an parser exception was occurred
			if (parserError != null) {
				throw parserError;
			}
		}
	}

	/**
	 * Disables all given transitions. In normal case this method is called, if
	 * a particular state is deactivated and all transitions of it and of all
	 * sub states must be deactivated, if they have for example a time trigger.
	 * 
	 * @param transToDeactivate defines all transitions which must be
	 *            deactivated
	 */
	private void deactivateTransitions(List<TransitionExt> transToDeactivate) {

		if (transToDeactivate != null) {
			for (TransitionExt transition : transToDeactivate) {

				// Remove time event task of this transition
				if (Level.DEBUG.equals(log.getLevel())) {
					log.debug("Timer (id: "
								+ transition.getId()
								+ ") removed: "
								+ scheduler.removeTimeEventTask(String
									.valueOf(transition.getId())));
				} else {
					scheduler.removeTimeEventTask(String.valueOf(transition
						.getId()));
				}

				// Disable transition
				transition.setActive(false);
			}
		}
	}

	/**
	 * Sets the change state of the state configuration.
	 * 
	 * @param state defines the new change state of the configuration
	 */
	private void setStateConfigurationChanged(final boolean state) {

		stateConfigurationChanged = state;

		if (log.isDebugEnabled()) {
			if (state) {
				log.debug("The state configuration was changed!");
			} else {
				log
					.debug("The change state of the state configuration was reset!");
			}
		}
	}

	/**
	 * If neither the state configuration nor a variable or an event was changed
	 * during the last step this thread waits until the user changes a variable
	 * value or fires an event or a time trigger activates (notifies) the
	 * thread.
	 */
	private void checkActivity() {

		synchronized (lockObj) {

			while (!stateConfigurationChanged
				&& !statechartParser.isExternalChanged()) {
				// No state was changed, no variable or event was changed

				if (log.isDebugEnabled()) {
					log.debug("Simulator wait until a change was done...");
				}

				try {
					// Wait until the thread is woken up
					lockObj.wait();
				} catch (final InterruptedException e) {
				}

				if (log.isDebugEnabled()) {
					log
						.debug("A change was detected and the simulation is continued!");
				}
			} 
			
			// Reset change states
			setStateConfigurationChanged(false);
			statechartParser.resetExternalChanged();
		}
	}

	// /**
	// * Pauses all available timers of the statemachine, if the simulation
	// shall
	// * be paused. The method must be invoked explicitly, otherwise the timers
	// * would work too inaccurately.
	// */
	// public void pauseTimers() {
	//
	// if (!disposed && transitions != null) {
	//
	// timerPaused = true;
	//
	// // Continuing all time triggers.
	// final long currentTime = System.currentTimeMillis();
	// for (final TransitionExt transition : transitions.values()) {
	// transition.pauseTimeTrigger(currentTime);
	// }
	// }
	// }

	/**
	 * This method adds the given state to the active states and activates the
	 * state with all needed tasks like executing the entry and do actions.
	 * 
	 * @param state defines the state which shall be activated
	 * 
	 * @return Returns the <code>State</code> instance which represents the
	 *         given <code>Node</code> instance.
	 * 
	 * @throws ParserException this exception will be thrown, if an error occurs
	 *             during the parsing or interpreting of an action or an
	 *             expression
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	@SuppressWarnings("unchecked")
	private State activateState(final Node state) throws ParserException,
			ArgumentIsNullException {

		// Defining the active state
		final State activeState =
				(State) activeRegions
					.get(activeRegions.size() - 1)
					.eContents()
					.get(
						activeRegions
							.get(activeRegions.size() - 1)
							.eContents()
							.indexOf(state));

		// Add the new state to the list of the active states.
		activeStates.add(activeState);

		// Fire event to inform the listeners.
		fireEvent(new StatemachineEvent(
			StatemachineEventTypes.StateEnabled,
			activeState,
			uUID,
			instance));
		
		// Inform outgoing transitions to start e.g. time triggers.
		startTimeTriggers(activeState);

		// Processing the entry action.
		statechartParser.parseAction(activeState.getEntry(), activeState
			.getName(), inputList, outputList, varList);

		return activeState;
	}

	/**
	 * The method checks whether the active state has sub states and returns the
	 * initial sub pseudo state.
	 * 
	 * @param activeState defines the state whose sub states shall be activated
	 * 
	 * @return The initial pseudo state of the sub states. If the state has no
	 *         sub states the result is <code>null</code>.
	 * 
	 * @throws ChangeConfigurationException if an error occurs during the next
	 *             step process
	 */
	private Node activateSubStates(final State activeState)
			throws ChangeConfigurationException {

		Node target = null;

		// Simple state or composite state?
		if (activeState.getRegion().size() > 0) {

			activeRegions.add(activeState.getRegion().get(0));

			// Searching the start state of the sub states.
			for (final Node n : activeState.getRegion().get(0).getState()) {

				// Searching the initial pseudo state
				if (n.eClass().getName().equalsIgnoreCase("Pseudostate")
					&& n
						.eGet(n.eClass().getEStructuralFeature("pseudoType"))
						.toString()
						.equalsIgnoreCase("initial")) {

					target = n;
					break;
				}
			}

			if (target == null) {
				throw new ChangeConfigurationException(String.format(
					Messages.SCSimulator_nosubstate,
					activeState.getName(),
					activeState.getId()));
			}
		}

		return target;
	}

	/**
	 * This method checks whether the given pseudo state is an initial pseudo
	 * state. If it is true the method detects the following state and returns
	 * this one.
	 * 
	 * @param pseudostate defines the pseudo state to check
	 * 
	 * @return The result is the following state of the initial state.
	 * 
	 * @throws PseudostateNotImplemented will be thrown, if a pseudo state has
	 *             not been implemented
	 * 
	 * @throws ArgumentIsNullException will be thrown, if an argument is
	 *             <code>null</code>
	 * @throws ParserException will be thrown, if the behavior is not valid
	 * @throws ChangeConfigurationException will be thrown, if the pseudo state
	 *             is not connected to another state
	 */
	@SuppressWarnings("unchecked")
	private Node checkPseudostate(final Node pseudostate)
			throws PseudostateNotImplemented, ParserException,
			ArgumentIsNullException, ChangeConfigurationException {

		Node target = null;

		// Checking the type of the pseudo state.
		final Pseudostate pstate =
				(Pseudostate) activeRegions
					.get(activeRegions.size() - 1)
					.eContents()
					.get(
						activeRegions
							.get(activeRegions.size() - 1)
							.eContents()
							.indexOf(pseudostate));

		if (pstate.getPseudoType().getName().equalsIgnoreCase("initial")) {

			// Finding out the first state after the pseudo state.
			for (final TransitionExt transition : transitions.values()) {

				if (transition.getSourceNode().equals(pstate)) {

					if (!transition.fireDirectly()) {

						// Error, the transition of the initial state has an
						// expression.
						throw new ParserException(
							String
								.format(
									Messages.SCSimulator_initialstatetranshasexpression,
									transition.getExpression()));
					}

					target = transition.getTargetNode();

					// Execute the behavior expression of the transition
					statechartParser.parseAction(
						transition.getBehavior(),
						null,
						inputList,
						outputList,
						varList);

					// Transition is active: Fire event to inform the listeners.
					fireEvent(new StatemachineEvent(
						StatemachineEventTypes.TransitionFired,
						transition,
						uUID,
						instance));
					break;
				}
			}
		} else {

			// A not implemented pseudo state.
			throw new PseudostateNotImplemented(pstate
				.getPseudoType()
				.getName());
		}

		if (target == null) {
			throw new ChangeConfigurationException(String.format(
				Messages.SCSimulator_initialstatenotconnected,
				pseudostate.getId()));
		}

		return target;
	}

	/**
	 * With the help of this method it is possible to reset all lists of
	 * variables and events and set the end state on <code>true</code>.
	 */
	private void setFinished() {

		// Final state is achieved.
		endState = true;
	}

	/**
	 * Creates an instance of the class <code>Entry</code> with the given
	 * parameters as properties.
	 * 
	 * @param element defines the key of the <code>Entry</code> instance
	 * @param value defines the value of the <code>Entry</code> instance
	 * 
	 * @return The created <code>Entry</code> instance.
	 */
	public Entry<DataElement, Object> createEntry(final DataElement element,
			final Object value) {

		return new Entry<DataElement, Object>() {

			public DataElement getKey() {

				return element;
			}

			public Object getValue() {

				return value;
			}

			public Object setValue(final Object value) {

				return value;
			}
		};
	}

	/**
	 * Informs the transitions, which has the given state as source node, so
	 * e.g. it is possible to start the time controlled trigger.
	 * 
	 * @param state the current active state
	 */
	private void startTimeTriggers(final State state) {

		for (final TransitionExt transition : transitions.values()) {

			if (transition.getSourceNode().equals(state)
				&& transition.hasTimeTrigger()) {

				scheduler.addTimeEventTask(
					String.valueOf(transition.getId()),
					transition.getTimeTriggerDelay());
			}
		}

	}

	/**
	 * Provides a listener which receives all time based events if they has
	 * passed and activates the particular transitions. At last the simulator
	 * will be notified to resume the simulation.
	 * 
	 * @return The listener which receive all time based events.
	 */
	private IEventListener getTimeEventListener() {

		return new IEventListener() {

			public void receiveEvent(IEvent event) {

				if (event != null) {

					if (event instanceof TimeEvent) {

						try {
							transitions
								.get(
									Integer
										.parseInt((String) event.getSource()))
								.setActive(true);

							notifySimulator();
						} catch (Exception e) {
							System.err.println(e);
						}
					}
				} else {
					log.warn("An event was received which was \"null\"!");
				}
			}
		};
	}

	/**
	 * This method allows to define the transition, which shall be fired and
	 * saves the transition with the help of the object variable
	 * <code>transToFire</code>.</br></br> <b>Attention:</b> At the moment, only
	 * one region is allowed, so there is at most one transition to fire. If
	 * more than one orthogonal region is allowed, it is required that one
	 * transition in each region is fired, if an event activates transitions in
	 * more than one region.</br>If more than one transition of one state is
	 * active the transition with the highest priority will be selected.
	 * 
	 * 
	 * @return Returns a list with all active transitions which must be
	 *         deactivated.
	 * 
	 * @throws ParserException this exception will be thrown, if an error occurs
	 *             during the parsing or interpreting of an action or an
	 *             expression
	 * @throws ArgumentIsNullException will be thrown, if an argument is "null"
	 */
	@SuppressWarnings("unchecked")
	private List<TransitionExt> getTransToFire() throws ParserException,
			ArgumentIsNullException {

		Integer priority = null;

		final List<TransitionExt> transToDeactivate =
				new ArrayList<TransitionExt>();

		TransitionExt curTrans = null;

		Node activeState = null;

		for (int i = activeStates.size() - 1; i >= 0; i--) {
			activeState = activeStates.get(i);

			for (final TransitionExt t : transitions.values()) {
				/*
				 * Requests to check if the transition is active:
				 * 
				 * Transition must have the highest priority No triggers and no
				 * guard(, only behavior): [/a=2] One or more triggers active:
				 * [active_event[2>3]/a=2] Guard is unequal to null or "" and is
				 * true: [not_activated_event[2>1]/a=2]
				 */
				if (t.getSourceNode().equals(activeState)) {

					if (statechartParser.parseExpression(
						t.getGuard(),
						null,
						inputList,
						varList,
						outputList)
						&& (t.isActive())) {

						// initial priority is "null"
						if (priority == null || t.getPriority() < priority) {

							curTrans = t;
							priority = t.getPriority();

						}
					}

					transToDeactivate.add(t);
				}
			}

			// At the moment, only one transition is allowed. See method
			// description for more informations.
			if (curTrans != null) {
				break;
			}
		}

		if (curTrans == null) {
			transToFire = null;
			transToDeactivate.clear();
		} else {
			transToFire = curTrans;
		}

		return transToDeactivate;
	}

	/**
	 * The result is <code>true</code>, if the method
	 * {@link #initializeStatemachine(String)} of this instance was called.
	 * 
	 * @return The result is <code>true</code> if the statemachine is
	 *         initialized and <code>false</code> if the statechart which shall
	 *         be simulated is not defined and no resources are reserved.
	 */
	public boolean isInitialized() {

		return isInitialized;
	}

	/**
	 * If the end state of the respective statemachine was activated, this
	 * method returns true.
	 * 
	 * @return The result is <code>true</code>, if the end state of the
	 *         statemachine is active, otherwise <code>false</code>.
	 */
	public boolean isFinished() {

		return endState;
	}

	/**
	 * Allows to update the value of an input, output or a variable as well as
	 * the state of an event. If the state of an event shall be changed a value
	 * equal to zero can be used to deactivate the event (active =
	 * <code>false</code>) and a value unequal to zero can be used to activate
	 * the event (active = <code>true</code>).
	 * 
	 * @param name defines the name of the item (input, output, variable or
	 *            event)
	 * @param value defines the new value (event: 0.0 = <code>false</code>,
	 *            otherwise <code>true</code>)
	 * 
	 * @return The result is <code>true</code> if the update was successful,
	 *         otherwise <code>false</code>.
	 * 
	 * @throws ArgumentIsNullException this exception will be thrown, if an
	 *             argument is <code>null</code>
	 */
	public boolean setItem(final String name, final Double value)
			throws ArgumentIsNullException {

		boolean result = false;
		Double oldValue = null;
		DataElement element = null;

		if (name == null) {
			log.error("The given name of the item is \"null\"!");
			throw new ArgumentIsNullException(Messages.SCSimulator_itemnamenull);
		}

		if (value == null) {
			log.error("The given value of the item \"" + name
						+ "\" is \"null\"!");
			throw new ArgumentIsNullException(String.format(
				Messages.SCSimulator_itemvaluenull,
				name));
		}

		if (!disposed) {

			element = dataElementList.get(name);

			if (element != null) {

				if (element instanceof Variable) {

					if (element.getIoType() == IOTypes.INPUT
						&& inputList.containsKey(element.getName())) {
						oldValue = inputList.put(element.getName(), value);
					} else if (element.getIoType() == IOTypes.LOCAL
								&& varList.containsKey(element.getName())) {
						oldValue = varList.put(element.getName(), value);
					} else if (element.getIoType() == IOTypes.OUTPUT
								&& outputList.containsKey(element.getName())) {
						oldValue = outputList.put(element.getName(), value);
					}

					if (oldValue != null) {

						if (!value.equals(oldValue)) {

							fireEvent(new StatemachineEvent(
								StatemachineEventTypes.VariableChanged,
								createEntry(element, value),
								getUUID(),
								getInstance()));
						}

						result = true;
					}
				} else if (element instanceof Event) {

					final boolean newValue = value.equals(0.0d) ? false : true;

					result = activateEvent(element.getName(), newValue);
				}
			}

			if (result) {
				// Wake up the simulator
				notifySimulator();
			}
		}

		return result;
	}

	/**
	 * Reads all defined <code>DataElement</code>s of the statechart and assigns
	 * them to the specific list. A <code>DataElement</code> can be a variable,
	 * an input or an output.
	 * 
	 * @throws StatechartNotValid will be thrown, if a wrong variable or event
	 *             name was found
	 */
	private void setIOElements() throws StatechartNotValid {

		String name = null;

		for (final DataElement dataElement : statechart.getDataElement()) {

			name = dataElement.getName();

			if (name == null || name.equals("")) {
				throw new StatechartNotValid(
					Messages.SCSimulator_emptyelementfound);
			}

			if (!patternVarChars.matcher(name).matches()) {
				throw new StatechartNotValid(String.format(
					Messages.SCSimulator_notvalidelementname,
					name));
			}

			if (name.toLowerCase().equals(Parser.SEND.toLowerCase())) {
				throw new StatechartNotValid(String.format(
					Messages.SCSimulator_functionaselementname,
					name,
					Parser.SEND + "()"));
			}

			// Add element to the list with all DataElements; Needed for the
			// event dispatching.
			dataElementList.put(dataElement.getName(), dataElement);

			if (dataElement instanceof Variable) {

				final Variable variable = (Variable) dataElement;

				final Double value = 0.0;

				if (variable.getIoType() == IOTypes.LOCAL) {

					varList.put(variable.getName(), value);

				} else if (variable.getIoType() == IOTypes.INPUT) {

					inputList.put(variable.getName(), value);

				} else if (variable.getIoType() == IOTypes.OUTPUT) {

					outputList.put(variable.getName(), value);
				}

			} else if (dataElement instanceof Event) {

				eventList.put(dataElement.getName(), false);
			}
		}
	}

	/**
	 * Returns the instance number.
	 * 
	 * @return The instance number.
	 */
	public int getInstance() {

		return instance;
	}

	/**
	 * Sets the instance number.
	 * 
	 * @param instance defines instance number
	 */
	public void setInstance(final int instance) {

		this.instance = instance;
	}

	/**
	 * Allows the synchronization of the active states. First, the simulation is
	 * paused before the active state events are sent. The simulation is then
	 * continued.
	 * 
	 * @return The result is a list with all active state of the current state
	 *         configuration of the simulated statemachine. If the simulation
	 *         was not initialized the result is <code>null</code>.
	 */
	public List<State> getActiveStates() {

		return activeStates;
	}

	/**
	 * Receives all events which e.g. fired by the <code>Parser</code>.
	 */
	public void receiveEvent(final IEvent event) {

		if (!disposed && event != null) {

			if (event instanceof ParserValueChangedEvent) {

				final ParserValueChangedEvent<?> parserEvent =
						(ParserValueChangedEvent<?>) event;

				final DataElement element =
						dataElementList.get(parserEvent.getSource());

				if (element != null && element instanceof Variable
					&& parserEvent.getValue() instanceof Double) {

					if (element.getIoType() == IOTypes.INPUT
						|| element.getIoType() == IOTypes.OUTPUT
						|| element.getIoType() == IOTypes.LOCAL) {

						fireEvent(new StatemachineEvent(
							StatemachineEventTypes.VariableChanged,
							createEntry(element, parserEvent.getValue()),
							getUUID(),
							getInstance()));

					} else {

						log
							.warn("The parser found an event which is declared as an in-/output or as a variable: "
									+ element.getName());
					}
				} else {

					if (element == null) {
						log
							.error("The element which was changed by the parser could not be found!");
					} else if (!(element instanceof Variable)) {
						log
							.warn("The type of the element which was changed by the parser is not supported: "
									+ element.getClass().getName() + "!");
					} else {
						if (parserEvent.getValue() != null) {
							log
								.warn("The data type of the element which was changed by the parser is not supported: "
										+ parserEvent
											.getValue()
											.getClass()
											.getSimpleName() + "!");
						} else {
							log
								.warn("The data type of the element which was changed by the parser could not specified, "
										+ "becaus it is \"null\"!");
						}

					}
				}
			} else if (event instanceof ParserEventFiredEvent) {

				if (event.getSource() != null) {

					final String eventName = (String) event.getSource();

					// Activate the event in the event list
					if (!activateEvent(eventName, true)) {
						parserError =
								new ParserException(String.format(
									Messages.Parser_unknownevent,
									eventName));
					}
				} else {
					log.warn("An event was received which was \"null\"!");
				}
			}
		} else {
			if (!disposed) {
				log
					.warn("An event was received whose getSource() method provides \"null\"!");
			}
		}
	}

	/**
	 * Allows the change of a event state.
	 * 
	 * @param name defines the name of the event
	 * @param value defines the new state of the event
	 * 
	 * @return The result is <code>true</code> if the activation was successful,
	 *         if the event doesn't exist the result is <code>false</code>.
	 */
	private boolean activateEvent(final String name, final boolean value) {

		boolean result = false;

		if (eventList.containsKey(name)) {

			final boolean oldValue = eventList.put(name, value);

			if (oldValue != value) {

				// Informing about the changed event state.
				fireEvent(new StatemachineEvent(
					StatemachineEventTypes.EventChanged,
					createEntry(dataElementList.get(name), value),
					getUUID(),
					getInstance()));
			}

			result = true;
		}

		return result;
	}

	/**
	 * Activates all transitions which have an active trigger.
	 * 
	 * @throws ParserException if an error occurs during the parsing
	 * @throws ArgumentIsNullException this exception will be thrown, if an
	 *             argument or an attribute of it is <code>null</code>
	 */
	@SuppressWarnings("unchecked")
	private void processEvents() throws ParserException,
			ArgumentIsNullException {

		for (final Entry<String, Boolean> event : eventList.entrySet()) {

			if (event.getValue()) {
				// The event is active

				// Transitions with this event as trigger will be activated
				for (final TransitionExt transitionExt : transitions.values()) {

					if (activeStates.contains(transitionExt.getSourceNode())
						&& transitionExt.hasTrigger(event.getKey())
						&& statechartParser.parseExpression(transitionExt
							.getGuard(), null, inputList, varList, outputList)) {

						transitionExt.setActive(true);
					}
				}

				// Deactivate the event
				eventList.put(event.getKey(), false);

				// TODO: Implementation of "Deferred Events": Firing the event
				// with "true"!

				// Informing about the changed event state.
				fireEvent(new StatemachineEvent(
					StatemachineEventTypes.EventChanged,
					createEntry(dataElementList.get(event.getKey()), false),
					getUUID(),
					getInstance()));
			}
		}
	}

	/**
	 * This method allows the de-/activation of a specific event of the current
	 * statemachine.
	 * 
	 * @param name defines the name of the event
	 * @param activate specifies whether the event shall be de-/activated
	 * 
	 * @return If the update is successful the result is <code>true</code>. If
	 *         the event can't be found the result is <code>false</code>.
	 * 
	 * @throws ArgumentIsNullException this exception will be thrown, if an
	 *             argument or an attribute of it is <code>null</code>
	 */
	public boolean setEvent(final String name, final boolean activate)
			throws ArgumentIsNullException {

		boolean result = false;

		if (name == null) {
			log.error("The name of the given event is \"null\"");
			throw new ArgumentIsNullException(
				Messages.SCSimulator_eventnamenull);
		}

		if (eventList != null) {

			result = activateEvent(name, activate);
		}

		if (result) {
			// Wake up the simulator
			notifySimulator();
		}

		return result;
	}

	/**
	 * Allows to notify the simulator thread and marks the state configuration
	 * as changed.
	 */
	public void notifySimulator() {

		if (!disposed) {

			synchronized (lockObj) {

				setStateConfigurationChanged(true);
				lockObj.notify();

				if (log.isDebugEnabled()) {
					log.debug("Simulator thread notified!");
				}
			}
		}
	}

	/**
	 * Provides the <code>Statechart</code> instance which is currently
	 * simulated by the simulation engine.
	 * 
	 * @return The <code>Statechart</code> instance which is currently simulated
	 *         by the simulation engine, if the simulator is not initialized the
	 *         result is <code>null</code>.
	 */
	public Statechart getStatechart() {

		return statechart;
	}

	/**
	 * Clears all reserved resources.
	 */
	public void dispose() {

		if (!disposed) {

			disposed = true;

			synchronized (lockObj) {

				if (activeRegions != null) {
					activeRegions.clear();
				}
				activeRegions = null;

				if (activeStates != null) {
					activeStates.clear();
				}
				activeStates = null;

				if (dataElementList != null) {
					dataElementList.clear();
				}
				dataElementList = null;

				if (eventList != null) {
					eventList.clear();
				}
				eventList = null;

				if (varList != null) {
					varList.clear();
				}
				varList = null;

				if (inputList != null) {
					inputList.clear();
				}
				inputList = null;

				if (outputList != null) {
					outputList.clear();
				}
				outputList = null;

				statechart = null;
				statechartParser = null;

				if (transitions != null) {
					for (final TransitionExt transition : transitions.values()) {
						// Disable all timer threads
						transition.dispose();
					}
					transitions.clear();
				}
				transitions = null;
			}
		}
	}
}
package choicejunctionpseudostatestest;

import java.util.HashSet;

import com.yakindu.statechart.AbstractStatechart;
import com.yakindu.statechart.Action;
import com.yakindu.statechart.Event;
import com.yakindu.statechart.Guard;
import com.yakindu.statechart.Pseudostate;
import com.yakindu.statechart.PseudostateKind;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.SignalEvent;
import com.yakindu.statechart.SimpleState;
import com.yakindu.statechart.TimingService;
import com.yakindu.statechart.Transition;

/** 
 * Implementation generated for Statechart ChoiceJunctionPseudostatesTest
 */
public class ChoiceJunctionPseudostatesTestStatechart
		extends
			AbstractStatechart {

	// ------------------------------------------------------------------------
	// EVENT INTERFACE
	// ------------------------------------------------------------------------

	// declare event constants for signal events

	public static final SignalEvent EVENT1 = new SignalEvent("event1");

	public static final SignalEvent EVENT2 = new SignalEvent("event2");

	public void setEvent(Event event) {

		super.setEvent(event);
	}

	// declare time events (as fields, as variable time events have to be dynamically initialized to 
	// access the statechart's variables)

	// ------------------------------------------------------------------------
	// VARIABLES INTERFACE
	// ------------------------------------------------------------------------

	// declare variable fields    

	private boolean decision;

	// declare getter/setter for variables

	public boolean getDecision() {
		return decision;
	}

	public void setDecision(boolean value) {
		this.decision = value;
	}

	// ------------------------------------------------------------------------
	// INITIALIZATION
	// ------------------------------------------------------------------------

	/**
	 * Protected constructor. Use the createInstance() method to instantiate this class.
	 */
	protected ChoiceJunctionPseudostatesTestStatechart(String id) {
		super(id);
	}

	/**
	 * Protected constructor. Use the createInstance(TimingService) method to instantiate this class.
	 */
	protected ChoiceJunctionPseudostatesTestStatechart(String id,
			TimingService timingService) {
		super(id, timingService);
	}

	/**
	 * Factory method to create an initialized instance of this class
	 */
	public static final ChoiceJunctionPseudostatesTestStatechart createInstance() {
		final ChoiceJunctionPseudostatesTestStatechart instance = new ChoiceJunctionPseudostatesTestStatechart(
				"STATECHART_ChoiceJunctionPseudostatesTest");

		initializeInstance(instance);

		return instance;
	}

	/**
	 * Same as createInstance(), additionally passing timing service to state chart instance.
	 */
	public static final ChoiceJunctionPseudostatesTestStatechart createInstance(
			TimingService timingService) {
		final ChoiceJunctionPseudostatesTestStatechart instance = new ChoiceJunctionPseudostatesTestStatechart(
				"STATECHART_ChoiceJunctionPseudostatesTest", timingService);

		initializeInstance(instance);

		return instance;
	}

	private static void initializeInstance(
			final ChoiceJunctionPseudostatesTestStatechart STATECHART_ChoiceJunctionPseudostatesTest) {

		// initialize time events

		Region STATECHART_ChoiceJunctionPseudostatesTest_REGION_0 = new Region(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0", 0,
				STATECHART_ChoiceJunctionPseudostatesTest);

		Pseudostate STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_initial_0 = new Pseudostate(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_initial_0",
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0,
				PseudostateKind.INITIAL);

		Pseudostate STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_choice_3 = new Pseudostate(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_choice_3",
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0,
				PseudostateKind.CHOICE);

		Pseudostate STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_junction_5 = new Pseudostate(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_junction_5",
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0,
				PseudostateKind.JUNCTION);

		SimpleState STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState1 = new SimpleState(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState1",
				"SimpleState1",
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0, null, null,
				null);

		SimpleState STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState2 = new SimpleState(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState2",
				"SimpleState2",
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0, null, null,
				null);

		SimpleState STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState3 = new SimpleState(
				"STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState3",
				"SimpleState3",
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0, null, null,
				null);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_6 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_6", 1,
				null, null,

				null

				,
				new Action() {
					public void execute() {
						STATECHART_ChoiceJunctionPseudostatesTest
								.setDecision(true);
					}
				},
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_initial_0,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState1);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_7 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_7",
				1,
				null,
				new HashSet<SignalEvent>() {
					{
						add(EVENT1);
					}
				},

				null

				,
				null,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState1,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_choice_3);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_9 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_9", 1,
				null, null,
				new Guard() {
					public boolean evaluate() {
						return !STATECHART_ChoiceJunctionPseudostatesTest
								.getDecision();
					}
				}, null,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_choice_3,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState3);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_10 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_10",
				1,
				null,
				new HashSet<SignalEvent>() {
					{
						add(EVENT2);
					}
				},

				null

				,
				null,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState2,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_junction_5);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_11 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_11",
				1,
				null,
				new HashSet<SignalEvent>() {
					{
						add(EVENT2);
					}
				},

				null

				,
				null,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState3,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_junction_5);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_12 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_12",
				1,
				null,
				null,

				null

				,
				new Action() {
					public void execute() {
						STATECHART_ChoiceJunctionPseudostatesTest
								.setDecision(STATECHART_ChoiceJunctionPseudostatesTest
										.getDecision() ? false : true);
					}
				},
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_junction_5,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState1);

		Transition STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_8 = new Transition(
				"STATECHART_ChoiceJunctionPseudostatesTest_TRANSITION_8", 2,
				null, null,
				new Guard() {
					public boolean evaluate() {
						return STATECHART_ChoiceJunctionPseudostatesTest
								.getDecision();
					}
				}, null,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_choice_3,
				STATECHART_ChoiceJunctionPseudostatesTest_REGION_0_STATE_SimpleState2);

		// finalize initialization (no changes to configuration can be done after this)
		STATECHART_ChoiceJunctionPseudostatesTest.finalizeInitialization();

	}

}

package historypseudostatestest;

import java.util.HashSet;

import com.yakindu.statechart.AbstractStatechart;
import com.yakindu.statechart.CompoundState;
import com.yakindu.statechart.Event;
import com.yakindu.statechart.Pseudostate;
import com.yakindu.statechart.PseudostateKind;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.SignalEvent;
import com.yakindu.statechart.SimpleState;
import com.yakindu.statechart.TimingService;
import com.yakindu.statechart.Transition;

/** 
 * Implementation generated for Statechart HistoryPseudostatesTest
 */
public class HistoryPseudostatesTestStatechart extends AbstractStatechart {

	// ------------------------------------------------------------------------
	// EVENT INTERFACE
	// ------------------------------------------------------------------------

	// declare event constants for signal events

	public static final SignalEvent EVENT1 = new SignalEvent("event1");

	public static final SignalEvent EVENT2 = new SignalEvent("event2");

	public static final SignalEvent COMPOUNDSTATE1TOSIMPLESTATE1 = new SignalEvent(
			"CompoundState1ToSimpleState1");

	public static final SignalEvent SIMPLESTATE1TOCOMPOUNDSTATE1DEEPHISTORY = new SignalEvent(
			"SimpleState1ToCompoundState1DeepHistory");

	public static final SignalEvent SIMPLESTATE1TOCOMPOUNDSTATE1SHALLOWHISTORY = new SignalEvent(
			"SimpleState1ToCompoundState1ShallowHistory");

	public void setEvent(Event event) {

		super.setEvent(event);
	}

	// declare time events (as fields, as variable time events have to be dynamically initialized to 
	// access the statechart's variables)

	// ------------------------------------------------------------------------
	// VARIABLES INTERFACE
	// ------------------------------------------------------------------------

	// declare variable fields    

	// declare getter/setter for variables

	// ------------------------------------------------------------------------
	// INITIALIZATION
	// ------------------------------------------------------------------------

	/**
	 * Protected constructor. Use the createInstance() method to instantiate this class.
	 */
	protected HistoryPseudostatesTestStatechart(String id) {
		super(id);
	}

	/**
	 * Protected constructor. Use the createInstance(TimingService) method to instantiate this class.
	 */
	protected HistoryPseudostatesTestStatechart(String id,
			TimingService timingService) {
		super(id, timingService);
	}

	/**
	 * Factory method to create an initialized instance of this class
	 */
	public static final HistoryPseudostatesTestStatechart createInstance() {
		final HistoryPseudostatesTestStatechart instance = new HistoryPseudostatesTestStatechart(
				"STATECHART_HistoryPseudostatesTest");

		initializeInstance(instance);

		return instance;
	}

	/**
	 * Same as createInstance(), additionally passing timing service to state chart instance.
	 */
	public static final HistoryPseudostatesTestStatechart createInstance(
			TimingService timingService) {
		final HistoryPseudostatesTestStatechart instance = new HistoryPseudostatesTestStatechart(
				"STATECHART_HistoryPseudostatesTest", timingService);

		initializeInstance(instance);

		return instance;
	}

	private static void initializeInstance(
			final HistoryPseudostatesTestStatechart STATECHART_HistoryPseudostatesTest) {

		// initialize time events

		Region STATECHART_HistoryPseudostatesTest_REGION_0 = new Region(
				"STATECHART_HistoryPseudostatesTest_REGION_0", 0,
				STATECHART_HistoryPseudostatesTest);

		Pseudostate STATECHART_HistoryPseudostatesTest_REGION_0_initial_9 = new Pseudostate(
				"STATECHART_HistoryPseudostatesTest_REGION_0_initial_9",
				STATECHART_HistoryPseudostatesTest_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1 = new SimpleState(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1",
				"SimpleState1", STATECHART_HistoryPseudostatesTest_REGION_0,
				null, null, null);

		CompoundState STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1 = new CompoundState(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1",
				"CompoundState1", STATECHART_HistoryPseudostatesTest_REGION_0,
				null, null);

		Region STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0 = new Region(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0",
				0,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1);

		Pseudostate STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_deepHistory_1 = new Pseudostate(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_deepHistory_1",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0,
				PseudostateKind.DEEPHISTORY);

		Pseudostate STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_shallowHistory_7 = new Pseudostate(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_shallowHistory_7",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0,
				PseudostateKind.SHALLOWHISTORY);

		Pseudostate STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_initial_8 = new Pseudostate(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_initial_8",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2 = new SimpleState(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2",
				"SimpleState2",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0,
				null, null, null);

		CompoundState STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2 = new CompoundState(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2",
				"CompoundState2",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0,
				null, null);

		Region STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0 = new Region(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0",
				0,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2);

		Pseudostate STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_initial_5 = new Pseudostate(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_initial_5",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState3 = new SimpleState(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState3",
				"SimpleState3",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0,
				null, null, null);

		SimpleState STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState4 = new SimpleState(
				"STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState4",
				"SimpleState4",
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0,
				null, null, null);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_11 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_11", 1, null,
				null,

				null

				, null, STATECHART_HistoryPseudostatesTest_REGION_0_initial_9,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_12 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_12",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_deepHistory_1,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_13 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_13",
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
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_14 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_14",
				1,
				null,
				new HashSet<SignalEvent>() {
					{
						add(COMPOUNDSTATE1TOSIMPLESTATE1);
					}
				},

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_15 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_15",
				1,
				null,
				new HashSet<SignalEvent>() {
					{
						add(SIMPLESTATE1TOCOMPOUNDSTATE1DEEPHISTORY);
					}
				},

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_deepHistory_1);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_16 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_16",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_initial_5,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState3);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_17 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_17",
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
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState3,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_CompoundState2_REGION_0_STATE_SimpleState4);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_18 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_18",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_shallowHistory_7,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_20 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_20",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_initial_8,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_STATE_SimpleState2);

		Transition STATECHART_HistoryPseudostatesTest_TRANSITION_19 = new Transition(
				"STATECHART_HistoryPseudostatesTest_TRANSITION_19",
				2,
				null,
				new HashSet<SignalEvent>() {
					{
						add(SIMPLESTATE1TOCOMPOUNDSTATE1SHALLOWHISTORY);
					}
				},

				null

				,
				null,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_SimpleState1,
				STATECHART_HistoryPseudostatesTest_REGION_0_STATE_CompoundState1_REGION_0_shallowHistory_7);

		// finalize initialization (no changes to configuration can be done after this)
		STATECHART_HistoryPseudostatesTest.finalizeInitialization();

	}

}

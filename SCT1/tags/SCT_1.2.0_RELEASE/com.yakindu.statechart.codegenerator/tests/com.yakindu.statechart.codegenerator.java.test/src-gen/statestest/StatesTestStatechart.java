package statestest;

import java.util.HashSet;

import com.yakindu.statechart.AbstractStatechart;
import com.yakindu.statechart.Action;
import com.yakindu.statechart.Event;
import com.yakindu.statechart.FinalState;
import com.yakindu.statechart.Pseudostate;
import com.yakindu.statechart.PseudostateKind;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.SignalEvent;
import com.yakindu.statechart.SimpleState;
import com.yakindu.statechart.TimingService;
import com.yakindu.statechart.Transition;

/** 
 * Implementation generated for Statechart StatesTest
 */
public class StatesTestStatechart extends AbstractStatechart {

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

	private boolean entryExecuted;

	private boolean doExecuted;

	private boolean exitExecuted;

	// declare getter/setter for variables

	public boolean getEntryExecuted() {
		return entryExecuted;
	}

	public void setEntryExecuted(boolean value) {
		this.entryExecuted = value;
	}

	public boolean getDoExecuted() {
		return doExecuted;
	}

	public void setDoExecuted(boolean value) {
		this.doExecuted = value;
	}

	public boolean getExitExecuted() {
		return exitExecuted;
	}

	public void setExitExecuted(boolean value) {
		this.exitExecuted = value;
	}

	// ------------------------------------------------------------------------
	// INITIALIZATION
	// ------------------------------------------------------------------------

	/**
	 * Protected constructor. Use the createInstance() method to instantiate this class.
	 */
	protected StatesTestStatechart(String id) {
		super(id);
	}

	/**
	 * Protected constructor. Use the createInstance(TimingService) method to instantiate this class.
	 */
	protected StatesTestStatechart(String id, TimingService timingService) {
		super(id, timingService);
	}

	/**
	 * Factory method to create an initialized instance of this class
	 */
	public static final StatesTestStatechart createInstance() {
		final StatesTestStatechart instance = new StatesTestStatechart(
				"STATECHART_StatesTest");

		initializeInstance(instance);

		return instance;
	}

	/**
	 * Same as createInstance(), additionally passing timing service to state chart instance.
	 */
	public static final StatesTestStatechart createInstance(
			TimingService timingService) {
		final StatesTestStatechart instance = new StatesTestStatechart(
				"STATECHART_StatesTest", timingService);

		initializeInstance(instance);

		return instance;
	}

	private static void initializeInstance(
			final StatesTestStatechart STATECHART_StatesTest) {

		// initialize time events

		Region STATECHART_StatesTest_REGION_0 = new Region(
				"STATECHART_StatesTest_REGION_0", 0, STATECHART_StatesTest);

		Pseudostate STATECHART_StatesTest_REGION_0_initial_0 = new Pseudostate(
				"STATECHART_StatesTest_REGION_0_initial_0",
				STATECHART_StatesTest_REGION_0, PseudostateKind.INITIAL);

		SimpleState STATECHART_StatesTest_REGION_0_STATE_SimpleState2 = new SimpleState(
				"STATECHART_StatesTest_REGION_0_STATE_SimpleState2",
				"SimpleState2", STATECHART_StatesTest_REGION_0, new Action() {
					public void execute() {
						STATECHART_StatesTest.setEntryExecuted(true);
					}
				}, new Action() {
					public void execute() {
						STATECHART_StatesTest.setDoExecuted(true);
					}
				}, new Action() {
					public void execute() {
						STATECHART_StatesTest.setExitExecuted(true);
					}
				});

		SimpleState STATECHART_StatesTest_REGION_0_STATE_SimpleState1 = new SimpleState(
				"STATECHART_StatesTest_REGION_0_STATE_SimpleState1",
				"SimpleState1", STATECHART_StatesTest_REGION_0, null, null,
				null);

		FinalState STATECHART_StatesTest_REGION_0_STATE_FinalState = new FinalState(
				"STATECHART_StatesTest_REGION_0_STATE_FinalState",
				STATECHART_StatesTest_REGION_0);

		Transition STATECHART_StatesTest_TRANSITION_4 = new Transition(
				"STATECHART_StatesTest_TRANSITION_4", 1, null, null,

				null

				, new Action() {
					public void execute() {
						STATECHART_StatesTest.setDoExecuted(false);
						STATECHART_StatesTest.setEntryExecuted(false);
						STATECHART_StatesTest.setExitExecuted(false);
					}
				}, STATECHART_StatesTest_REGION_0_initial_0,
				STATECHART_StatesTest_REGION_0_STATE_SimpleState1);

		Transition STATECHART_StatesTest_TRANSITION_5 = new Transition(
				"STATECHART_StatesTest_TRANSITION_5", 1, null,
				new HashSet<SignalEvent>() {
					{
						add(EVENT2);
					}
				},

				null

				, null, STATECHART_StatesTest_REGION_0_STATE_SimpleState2,
				STATECHART_StatesTest_REGION_0_STATE_FinalState);

		Transition STATECHART_StatesTest_TRANSITION_6 = new Transition(
				"STATECHART_StatesTest_TRANSITION_6", 1, null,
				new HashSet<SignalEvent>() {
					{
						add(EVENT1);
					}
				},

				null

				, null, STATECHART_StatesTest_REGION_0_STATE_SimpleState1,
				STATECHART_StatesTest_REGION_0_STATE_SimpleState2);

		// finalize initialization (no changes to configuration can be done after this)
		STATECHART_StatesTest.finalizeInitialization();

	}

}

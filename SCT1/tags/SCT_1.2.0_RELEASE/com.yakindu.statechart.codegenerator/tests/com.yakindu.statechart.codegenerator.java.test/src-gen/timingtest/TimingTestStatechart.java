package timingtest;

import java.util.HashSet;

import com.yakindu.statechart.AbstractStatechart;
import com.yakindu.statechart.Action;
import com.yakindu.statechart.ConstantTimeEvent;
import com.yakindu.statechart.Event;
import com.yakindu.statechart.FinalState;
import com.yakindu.statechart.Pseudostate;
import com.yakindu.statechart.PseudostateKind;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.SignalEvent;
import com.yakindu.statechart.SimpleState;
import com.yakindu.statechart.TimeEvent;
import com.yakindu.statechart.TimingService;
import com.yakindu.statechart.Transition;

/** 
 * Implementation generated for Statechart TimingTest
 */
public class TimingTestStatechart extends AbstractStatechart {

	// ------------------------------------------------------------------------
	// EVENT INTERFACE
	// ------------------------------------------------------------------------

	// declare event constants for signal events

	public static final SignalEvent ABORT = new SignalEvent("abort");

	public void setEvent(Event event) {

		super.setEvent(event);
	}

	// declare time events (as fields, as variable time events have to be dynamically initialized to 
	// access the statechart's variables)

	protected TimeEvent TIMER6 = null;

	protected TimeEvent TIMER5 = null;

	// ------------------------------------------------------------------------
	// VARIABLES INTERFACE
	// ------------------------------------------------------------------------

	// declare variable fields    

	private int returnTime;

	// declare getter/setter for variables

	public int getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(int value) {
		this.returnTime = value;
	}

	// ------------------------------------------------------------------------
	// INITIALIZATION
	// ------------------------------------------------------------------------

	/**
	 * Protected constructor. Use the createInstance() method to instantiate this class.
	 */
	protected TimingTestStatechart(String id) {
		super(id);
	}

	/**
	 * Protected constructor. Use the createInstance(TimingService) method to instantiate this class.
	 */
	protected TimingTestStatechart(String id, TimingService timingService) {
		super(id, timingService);
	}

	/**
	 * Factory method to create an initialized instance of this class
	 */
	public static final TimingTestStatechart createInstance() {
		final TimingTestStatechart instance = new TimingTestStatechart(
				"STATECHART_TimingTest");

		initializeInstance(instance);

		return instance;
	}

	/**
	 * Same as createInstance(), additionally passing timing service to state chart instance.
	 */
	public static final TimingTestStatechart createInstance(
			TimingService timingService) {
		final TimingTestStatechart instance = new TimingTestStatechart(
				"STATECHART_TimingTest", timingService);

		initializeInstance(instance);

		return instance;
	}

	private static void initializeInstance(
			final TimingTestStatechart STATECHART_TimingTest) {

		// initialize time events

		STATECHART_TimingTest.TIMER6 = new TimeEvent("6") {
			public long getDuration() {
				return STATECHART_TimingTest.getReturnTime();
			}
		};

		STATECHART_TimingTest.TIMER5 = new ConstantTimeEvent("5", 1000);

		Region STATECHART_TimingTest_REGION_0 = new Region(
				"STATECHART_TimingTest_REGION_0", 0, STATECHART_TimingTest);

		Pseudostate STATECHART_TimingTest_REGION_0_initial_0 = new Pseudostate(
				"STATECHART_TimingTest_REGION_0_initial_0",
				STATECHART_TimingTest_REGION_0, PseudostateKind.INITIAL);

		SimpleState STATECHART_TimingTest_REGION_0_STATE_SimpleState1 = new SimpleState(
				"STATECHART_TimingTest_REGION_0_STATE_SimpleState1",
				"SimpleState1", STATECHART_TimingTest_REGION_0, null, null,
				null);

		SimpleState STATECHART_TimingTest_REGION_0_STATE_SimpleState2 = new SimpleState(
				"STATECHART_TimingTest_REGION_0_STATE_SimpleState2",
				"SimpleState2", STATECHART_TimingTest_REGION_0, null, null,
				null);

		FinalState STATECHART_TimingTest_REGION_0_STATE_FinalState = new FinalState(
				"STATECHART_TimingTest_REGION_0_STATE_FinalState",
				STATECHART_TimingTest_REGION_0);

		Transition STATECHART_TimingTest_TRANSITION_4 = new Transition(
				"STATECHART_TimingTest_TRANSITION_4", 1, null, null,

				null

				, new Action() {
					public void execute() {
						STATECHART_TimingTest.setReturnTime(3000);
					}
				}, STATECHART_TimingTest_REGION_0_initial_0,
				STATECHART_TimingTest_REGION_0_STATE_SimpleState1);

		Transition STATECHART_TimingTest_TRANSITION_5 = new Transition(
				"STATECHART_TimingTest_TRANSITION_5", 1,
				STATECHART_TimingTest.TIMER5, null,

				null

				, null, STATECHART_TimingTest_REGION_0_STATE_SimpleState1,
				STATECHART_TimingTest_REGION_0_STATE_SimpleState2);

		Transition STATECHART_TimingTest_TRANSITION_6 = new Transition(
				"STATECHART_TimingTest_TRANSITION_6", 1,
				STATECHART_TimingTest.TIMER6, null,

				null

				, null, STATECHART_TimingTest_REGION_0_STATE_SimpleState2,
				STATECHART_TimingTest_REGION_0_STATE_SimpleState1);

		Transition STATECHART_TimingTest_TRANSITION_7 = new Transition(
				"STATECHART_TimingTest_TRANSITION_7", 2, null,
				new HashSet<SignalEvent>() {
					{
						add(ABORT);
					}
				},

				null

				, null, STATECHART_TimingTest_REGION_0_STATE_SimpleState2,
				STATECHART_TimingTest_REGION_0_STATE_FinalState);

		// finalize initialization (no changes to configuration can be done after this)
		STATECHART_TimingTest.finalizeInitialization();

	}

}

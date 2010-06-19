package transitionstest;

import java.util.HashSet;

import com.yakindu.statechart.AbstractStatechart;
import com.yakindu.statechart.Action;
import com.yakindu.statechart.CompoundState;
import com.yakindu.statechart.ConstantTimeEvent;
import com.yakindu.statechart.Event;
import com.yakindu.statechart.Pseudostate;
import com.yakindu.statechart.PseudostateKind;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.SignalEvent;
import com.yakindu.statechart.SimpleState;
import com.yakindu.statechart.TimeEvent;
import com.yakindu.statechart.TimingService;
import com.yakindu.statechart.Transition;

/** 
 * Implementation generated for Statechart TransitionsTest
 */
public class TransitionsTestStatechart extends AbstractStatechart {

	// ------------------------------------------------------------------------
	// EVENT INTERFACE
	// ------------------------------------------------------------------------

	// declare event constants for signal events

	public static final SignalEvent EVENT1 = new SignalEvent("event1");

	public void setEvent(Event event) {

		super.setEvent(event);
	}

	// declare time events (as fields, as variable time events have to be dynamically initialized to 
	// access the statechart's variables)

	protected TimeEvent TIMER11 = null;

	// ------------------------------------------------------------------------
	// VARIABLES INTERFACE
	// ------------------------------------------------------------------------

	// declare variable fields    

	private boolean composite1Entered;

	private boolean composite1Exited;

	private boolean simple1Entered;

	private boolean simple1Exited;

	private boolean composite2Entered;

	private boolean composite2Exited;

	private boolean simple2Entered;

	private boolean simple2Exited;

	// declare getter/setter for variables

	public boolean getComposite1Entered() {
		return composite1Entered;
	}

	public void setComposite1Entered(boolean value) {
		this.composite1Entered = value;
	}

	public boolean getComposite1Exited() {
		return composite1Exited;
	}

	public void setComposite1Exited(boolean value) {
		this.composite1Exited = value;
	}

	public boolean getSimple1Entered() {
		return simple1Entered;
	}

	public void setSimple1Entered(boolean value) {
		this.simple1Entered = value;
	}

	public boolean getSimple1Exited() {
		return simple1Exited;
	}

	public void setSimple1Exited(boolean value) {
		this.simple1Exited = value;
	}

	public boolean getComposite2Entered() {
		return composite2Entered;
	}

	public void setComposite2Entered(boolean value) {
		this.composite2Entered = value;
	}

	public boolean getComposite2Exited() {
		return composite2Exited;
	}

	public void setComposite2Exited(boolean value) {
		this.composite2Exited = value;
	}

	public boolean getSimple2Entered() {
		return simple2Entered;
	}

	public void setSimple2Entered(boolean value) {
		this.simple2Entered = value;
	}

	public boolean getSimple2Exited() {
		return simple2Exited;
	}

	public void setSimple2Exited(boolean value) {
		this.simple2Exited = value;
	}

	// ------------------------------------------------------------------------
	// INITIALIZATION
	// ------------------------------------------------------------------------

	/**
	 * Protected constructor. Use the createInstance() method to instantiate this class.
	 */
	protected TransitionsTestStatechart(String id) {
		super(id);
	}

	/**
	 * Protected constructor. Use the createInstance(TimingService) method to instantiate this class.
	 */
	protected TransitionsTestStatechart(String id, TimingService timingService) {
		super(id, timingService);
	}

	/**
	 * Factory method to create an initialized instance of this class
	 */
	public static final TransitionsTestStatechart createInstance() {
		final TransitionsTestStatechart instance = new TransitionsTestStatechart(
				"STATECHART_TransitionsTest");

		initializeInstance(instance);

		return instance;
	}

	/**
	 * Same as createInstance(), additionally passing timing service to state chart instance.
	 */
	public static final TransitionsTestStatechart createInstance(
			TimingService timingService) {
		final TransitionsTestStatechart instance = new TransitionsTestStatechart(
				"STATECHART_TransitionsTest", timingService);

		initializeInstance(instance);

		return instance;
	}

	private static void initializeInstance(
			final TransitionsTestStatechart STATECHART_TransitionsTest) {

		// initialize time events

		STATECHART_TransitionsTest.TIMER11 = new ConstantTimeEvent("11", 20000);

		Region STATECHART_TransitionsTest_REGION_0 = new Region(
				"STATECHART_TransitionsTest_REGION_0", 0,
				STATECHART_TransitionsTest);

		Pseudostate STATECHART_TransitionsTest_REGION_0_initial_0 = new Pseudostate(
				"STATECHART_TransitionsTest_REGION_0_initial_0",
				STATECHART_TransitionsTest_REGION_0, PseudostateKind.INITIAL);

		CompoundState STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1 = new CompoundState(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1",
				"CompositeState1", STATECHART_TransitionsTest_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setComposite1Entered(true);
					}
				}, new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setComposite1Exited(true);
					}
				});

		Region STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0 = new Region(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0",
				0, STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1);

		Pseudostate STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_initial_3 = new Pseudostate(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_initial_3",
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_STATE_SimpleState1 = new SimpleState(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_STATE_SimpleState1",
				"SimpleState1",
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setSimple1Entered(true);
					}
				}, null, new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setSimple1Exited(true);
					}
				});

		CompoundState STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2 = new CompoundState(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2",
				"CompositeState2", STATECHART_TransitionsTest_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setComposite2Entered(true);
					}
				}, new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setComposite2Exited(true);
					}
				});

		Region STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0 = new Region(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0",
				0, STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2);

		Pseudostate STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_initial_5 = new Pseudostate(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_initial_5",
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_STATE_SimpleState2 = new SimpleState(
				"STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_STATE_SimpleState2",
				"SimpleState2",
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setSimple2Entered(true);
					}
				}, null, new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setSimple2Exited(true);
					}
				});

		Transition STATECHART_TransitionsTest_TRANSITION_7 = new Transition(
				"STATECHART_TransitionsTest_TRANSITION_7", 1, null, null,

				null

				, new Action() {
					public void execute() {
						STATECHART_TransitionsTest.setComposite1Entered(false);
						STATECHART_TransitionsTest.setComposite1Exited(false);
						STATECHART_TransitionsTest.setComposite2Entered(false);
						STATECHART_TransitionsTest.setComposite2Exited(false);
						STATECHART_TransitionsTest.setSimple1Entered(false);
						STATECHART_TransitionsTest.setSimple1Exited(false);
						STATECHART_TransitionsTest.setSimple2Entered(false);
						STATECHART_TransitionsTest.setSimple2Exited(false);
					}
				}, STATECHART_TransitionsTest_REGION_0_initial_0,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1);

		Transition STATECHART_TransitionsTest_TRANSITION_8 = new Transition(
				"STATECHART_TransitionsTest_TRANSITION_8",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_initial_3,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_STATE_SimpleState1);

		Transition STATECHART_TransitionsTest_TRANSITION_9 = new Transition(
				"STATECHART_TransitionsTest_TRANSITION_9",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_initial_5,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_STATE_SimpleState2);

		Transition STATECHART_TransitionsTest_TRANSITION_10 = new Transition(
				"STATECHART_TransitionsTest_TRANSITION_10",
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
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1_REGION_0_STATE_SimpleState1,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2_REGION_0_STATE_SimpleState2);

		Transition STATECHART_TransitionsTest_TRANSITION_11 = new Transition(
				"STATECHART_TransitionsTest_TRANSITION_11", 1,
				STATECHART_TransitionsTest.TIMER11, null,

				null

				, null,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState1,
				STATECHART_TransitionsTest_REGION_0_STATE_CompositeState2);

		// finalize initialization (no changes to configuration can be done after this)
		STATECHART_TransitionsTest.finalizeInitialization();

	}

}

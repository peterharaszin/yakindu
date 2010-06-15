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
package trafficlightwaiting;

import java.util.HashSet;

import com.yakindu.statechart.Action;
import com.yakindu.statechart.CompoundState;
import com.yakindu.statechart.Guard;
import com.yakindu.statechart.Pseudostate;
import com.yakindu.statechart.PseudostateKind;
import com.yakindu.statechart.Region;
import com.yakindu.statechart.SignalEvent;
import com.yakindu.statechart.SimpleState;
import com.yakindu.statechart.FinalState;
import com.yakindu.statechart.AbstractStatechart;
import com.yakindu.statechart.TimeEvent;
import com.yakindu.statechart.TimingService;
import com.yakindu.statechart.ConstantTimeEvent;
import com.yakindu.statechart.Transition;

/** 
 * Implementation generated for Statechart TrafficlightWaiting
 */
public class TrafficlightWaitingStatechart extends AbstractStatechart {

	// ------------------------------------------------------------------------
	// EVENT INTERFACE
	// ------------------------------------------------------------------------

	// declare event constants for signal events

	public static final SignalEvent KEYPRESS2 = new SignalEvent("keypress2");

	public static final SignalEvent KEYPRESS1 = new SignalEvent("keypress1");

	public static final SignalEvent KEYPRESS3 = new SignalEvent("keypress3");

	public static final SignalEvent KEYPRESS4 = new SignalEvent("keypress4");

	public static final SignalEvent KEYPRESS5 = new SignalEvent("keypress5");

	public static final SignalEvent KEYPRESS6 = new SignalEvent("keypress6");

	// declare time events (as fields, as variable time events have to be dynamically initialized to 
	// access the statechart's variables)

	protected TimeEvent TIMER21 = null;

	protected TimeEvent TIMER22 = null;

	protected TimeEvent TIMER24 = null;

	protected TimeEvent TIMER29 = null;

	protected TimeEvent TIMER26 = null;

	protected TimeEvent TIMER28 = null;

	protected TimeEvent TIMER23 = null;

	protected TimeEvent TIMER27 = null;

	// ------------------------------------------------------------------------
	// VARIABLES INTERFACE
	// ------------------------------------------------------------------------

	// declare variable fields    

	private int tl_red;

	private int tl_green;

	private int tl_yellow;

	private int ped_request;

	private int ped_green;

	private int ped_red;

	private int stateID;

	private int ped_blinking_rate;

	private boolean dutch;

	// declare getter/setter for variables

	public int getTl_red() {
		return tl_red;
	}

	public void setTl_red(int value) {
		this.tl_red = value;
	}

	public int getTl_green() {
		return tl_green;
	}

	public void setTl_green(int value) {
		this.tl_green = value;
	}

	public int getTl_yellow() {
		return tl_yellow;
	}

	public void setTl_yellow(int value) {
		this.tl_yellow = value;
	}

	public int getPed_request() {
		return ped_request;
	}

	public void setPed_request(int value) {
		this.ped_request = value;
	}

	public int getPed_green() {
		return ped_green;
	}

	public void setPed_green(int value) {
		this.ped_green = value;
	}

	public int getPed_red() {
		return ped_red;
	}

	public void setPed_red(int value) {
		this.ped_red = value;
	}

	public int getStateID() {
		return stateID;
	}

	public void setStateID(int value) {
		this.stateID = value;
	}

	public int getPed_blinking_rate() {
		return ped_blinking_rate;
	}

	public void setPed_blinking_rate(int value) {
		this.ped_blinking_rate = value;
	}

	public boolean getDutch() {
		return dutch;
	}

	public void setDutch(boolean value) {
		this.dutch = value;
	}

	// ------------------------------------------------------------------------
	// INITIALIZATION
	// ------------------------------------------------------------------------

	/**
	 * Protected constructor. Use the createInstance() method to instantiate this class.
	 */
	protected TrafficlightWaitingStatechart(String id) {
		super(id);
	}

	/**
	 * Protected constructor. Use the createInstance(TimingService) method to instantiate this class.
	 */
	protected TrafficlightWaitingStatechart(String id,
			TimingService timingService) {
		super(id, timingService);
	}

	/**
	 * Factory method to create an initialized instance of this class
	 */
	public static final TrafficlightWaitingStatechart createInstance() {
		final TrafficlightWaitingStatechart instance = new TrafficlightWaitingStatechart(
				"STATECHART_TrafficlightWaiting");

		initializeInstance(instance);

		return instance;
	}

	/**
	 * Same as createInstance(), additionally passing timing service to state chart instance.
	 */
	public static final TrafficlightWaitingStatechart createInstance(
			TimingService timingService) {
		final TrafficlightWaitingStatechart instance = new TrafficlightWaitingStatechart(
				"STATECHART_TrafficlightWaiting", timingService);

		initializeInstance(instance);

		return instance;
	}

	private static void initializeInstance(
			final TrafficlightWaitingStatechart STATECHART_TrafficlightWaiting) {

		// initialize time events

		STATECHART_TrafficlightWaiting.TIMER21 = new ConstantTimeEvent("21",
				2000);

		STATECHART_TrafficlightWaiting.TIMER22 = new ConstantTimeEvent("22",
				2000);

		STATECHART_TrafficlightWaiting.TIMER24 = new TimeEvent("24") {
			public long getDuration() {
				return STATECHART_TrafficlightWaiting.getPed_blinking_rate();
			}
		};

		STATECHART_TrafficlightWaiting.TIMER29 = new ConstantTimeEvent("29",
				2000);

		STATECHART_TrafficlightWaiting.TIMER26 = new TimeEvent("26") {
			public long getDuration() {
				return STATECHART_TrafficlightWaiting.getPed_blinking_rate();
			}
		};

		STATECHART_TrafficlightWaiting.TIMER28 = new ConstantTimeEvent("28",
				3000);

		STATECHART_TrafficlightWaiting.TIMER23 = new ConstantTimeEvent("23",
				7000);

		STATECHART_TrafficlightWaiting.TIMER27 = new ConstantTimeEvent("27",
				10000);

		Region STATECHART_TrafficlightWaiting_REGION_0 = new Region(
				"STATECHART_TrafficlightWaiting_REGION_0", 12,
				STATECHART_TrafficlightWaiting);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_initial_17 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_initial_17",
				STATECHART_TrafficlightWaiting_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_off = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_off", "off",
				STATECHART_TrafficlightWaiting_REGION_0, null, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_freeze = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_freeze",
				"freeze", STATECHART_TrafficlightWaiting_REGION_0, null, null,
				null);

		CompoundState STATECHART_TrafficlightWaiting_REGION_0_STATE_on = new CompoundState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on", "on",
				STATECHART_TrafficlightWaiting_REGION_0, null, null);

		Region STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0 = new Region(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0", 0,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_shallowHistory_11 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_shallowHistory_11",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				PseudostateKind.SHALLOWHISTORY);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_deepHistory_12 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_deepHistory_12",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				PseudostateKind.DEEPHISTORY);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_choice_13 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_choice_13",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				PseudostateKind.CHOICE);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_junction_14 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_junction_14",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				PseudostateKind.JUNCTION);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_initial_15 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_initial_15",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen",
				"StreetGreen",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setTl_red(0);
						STATECHART_TrafficlightWaiting.setTl_green(1);
						STATECHART_TrafficlightWaiting.setTl_yellow(0);
						STATECHART_TrafficlightWaiting.setPed_red(1);
						STATECHART_TrafficlightWaiting.setPed_green(0);
						STATECHART_TrafficlightWaiting.setPed_request(0);
						STATECHART_TrafficlightWaiting.setStateID(1);
					}
				}, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetPrepare = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetPrepare",
				"StreetPrepare",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setTl_red(1);
						STATECHART_TrafficlightWaiting.setTl_yellow(1);
						STATECHART_TrafficlightWaiting.setTl_green(0);
						STATECHART_TrafficlightWaiting.setStateID(7);
					}
				}, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedRed = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedRed",
				"PedRed",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setPed_red(1);
						STATECHART_TrafficlightWaiting.setPed_green(0);
						STATECHART_TrafficlightWaiting.setStateID(6);
					}
				}, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedGreen = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedGreen",
				"PedGreen",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setPed_red(0);
						STATECHART_TrafficlightWaiting.setPed_green(1);
						STATECHART_TrafficlightWaiting.setStateID(5);
					}
				}, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetRed = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetRed",
				"StreetRed",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setTl_red(1);
						STATECHART_TrafficlightWaiting.setTl_green(0);
						STATECHART_TrafficlightWaiting.setTl_yellow(0);
						STATECHART_TrafficlightWaiting.setStateID(4);
					}
				}, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetAmber = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetAmber",
				"StreetAmber",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setTl_red(0);
						STATECHART_TrafficlightWaiting.setTl_green(0);
						STATECHART_TrafficlightWaiting.setTl_yellow(1);
						STATECHART_TrafficlightWaiting.setStateID(3);
					}
				}, null, null);

		CompoundState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting = new CompoundState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting",
				"PedWaiting",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setStateID(2);
					}
				}, null);

		Region STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0 = new Region(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0",
				11,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting);

		Pseudostate STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_initial_10 = new Pseudostate(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_initial_10",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0,
				PseudostateKind.INITIAL);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOn = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOn",
				"waitOn",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setPed_request(1);
					}
				}, null, null);

		SimpleState STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOff = new SimpleState(
				"STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOff",
				"waitOff",
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setPed_request(0);
					}
				}, null, null);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_19 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_19",
				0,
				null,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_shallowHistory_11,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_21 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_21",
				0,
				STATECHART_TrafficlightWaiting.TIMER21,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetAmber,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetRed);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_22 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_22",
				0,
				STATECHART_TrafficlightWaiting.TIMER22,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetRed,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedGreen);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_20 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_20",
				1,
				null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS1);
					}
				},

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_23 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_23",
				1,
				STATECHART_TrafficlightWaiting.TIMER23,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedGreen,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedRed);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_24 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_24",
				1,
				STATECHART_TrafficlightWaiting.TIMER24,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOn,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOff);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_25 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_25",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_initial_10,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOn);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_26 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_26",
				1,
				STATECHART_TrafficlightWaiting.TIMER26,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOff,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting_REGION_0_STATE_waitOn);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_28 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_28",
				1,
				STATECHART_TrafficlightWaiting.TIMER28,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedRed,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_choice_13);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_29 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_29",
				1,
				STATECHART_TrafficlightWaiting.TIMER29,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetPrepare,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_junction_14);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_30 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_30", 1, null, null,

				null

				, new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting
								.setPed_blinking_rate(500);
						STATECHART_TrafficlightWaiting.setDutch(false);
					}
				}, STATECHART_TrafficlightWaiting_REGION_0_initial_17,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_31 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_31", 1, null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS2);
					}
				},

				null

				, null, STATECHART_TrafficlightWaiting_REGION_0_STATE_off,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_shallowHistory_11);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_32 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_32", 1, null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS2);
					}
				},

				null

				, null, STATECHART_TrafficlightWaiting_REGION_0_STATE_on,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_off);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_33 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_33",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_deepHistory_12,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_35 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_35", 1, null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS3);
					}
				},

				null

				, null, STATECHART_TrafficlightWaiting_REGION_0_STATE_freeze,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_deepHistory_12);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_38 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_38",
				1,
				null,
				null,
				new Guard() {
					public boolean evaluate() {
						return STATECHART_TrafficlightWaiting.getDutch() == false;
					}
				},
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_choice_13,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetPrepare);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_39 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_39",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_junction_14,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_42 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_42",
				1,
				null,
				null,

				null

				,
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_initial_15,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetGreen);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_27 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_27",
				2,
				STATECHART_TrafficlightWaiting.TIMER27,
				null,

				null

				,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting.setPed_request(0);
					}
				},
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_PedWaiting,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_STATE_StreetAmber);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_34 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_34", 2, null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS3);
					}
				},

				null

				, null, STATECHART_TrafficlightWaiting_REGION_0_STATE_on,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_freeze);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_40 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_40",
				2,
				null,
				null,
				new Guard() {
					public boolean evaluate() {
						return STATECHART_TrafficlightWaiting.getDutch() == true;
					}
				},
				null,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_choice_13,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on_REGION_0_junction_14);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_36 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_36",
				3,
				null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS4);
					}
				},

				null

				,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting
								.setPed_blinking_rate(STATECHART_TrafficlightWaiting
										.getPed_blinking_rate() + (500));
					}
				}, STATECHART_TrafficlightWaiting_REGION_0_STATE_on,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_37 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_37",
				4,
				null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS5);
					}
				},

				null

				,
				new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting
								.setPed_blinking_rate(STATECHART_TrafficlightWaiting
										.getPed_blinking_rate() >= 1000
										? STATECHART_TrafficlightWaiting
												.getPed_blinking_rate() - 500
										: 500);
					}
				}, STATECHART_TrafficlightWaiting_REGION_0_STATE_on,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on);

		Transition STATECHART_TrafficlightWaiting_TRANSITION_41 = new Transition(
				"STATECHART_TrafficlightWaiting_TRANSITION_41", 5, null,
				new HashSet<SignalEvent>() {
					{
						add(KEYPRESS6);
					}
				},

				null

				, new Action() {
					public void execute() {
						STATECHART_TrafficlightWaiting
								.setDutch(STATECHART_TrafficlightWaiting
										.getDutch() ? false : true);
					}
				}, STATECHART_TrafficlightWaiting_REGION_0_STATE_on,
				STATECHART_TrafficlightWaiting_REGION_0_STATE_on);

	}

}

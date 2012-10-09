package org.yakindu.scr.statechartlocalreactions;

public class StatechartLocalReactionsStatemachine
		implements
			IStatechartLocalReactionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int myInt;

		public int getMyInt() {
			return myInt;
		}

		public void setMyInt(int value) {
			this.myInt = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_S1, main_region_S2, region2_a, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public StatechartLocalReactionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_S1;

		nextStateIndex = 1;
		stateVector[1] = State.region2_a;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_S1 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_S2 :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case region2_a :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_S1 :
				return stateVector[0] == State.main_region_S1;
			case main_region_S2 :
				return stateVector[0] == State.main_region_S2;
			case region2_a :
				return stateVector[1] == State.region2_a;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public int getMyInt() {
		return sCIDefault.getMyInt();
	}

	public void setMyInt(int value) {
		sCIDefault.setMyInt(value);
	}

	private boolean checkLr0() {
		return true;
	}

	private void effectLr0() {
		sCIDefault.myInt += 1;
	}

	/* Entry action for statechart 'StatechartLocalReactions'. */
	private void entryAction() {
	}

	/* Exit action for state 'StatechartLocalReactions'. */
	private void exitAction() {
	}

	/* The reactions of state S1. */
	private void reactMain_region_S1() {
		effectLr0();

		if (true) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_S2;
		}
	}

	/* The reactions of state S2. */
	private void reactMain_region_S2() {
		effectLr0();

		if (true) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_S1;
		}
	}

	/* The reactions of state a. */
	private void reactRegion2_a() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_S1 :
					reactMain_region_S1();
					break;
				case main_region_S2 :
					reactMain_region_S2();
					break;
				case region2_a :
					reactRegion2_a();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

package org.yakindu.scr.ineventlifecycle;

public class InEventLifeCycleStatemachine
		implements
			IInEventLifeCycleStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private int i;

		public int getI() {
			return i;
		}

		public void setI(int value) {
			this.i = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public InEventLifeCycleStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.i = 0;
	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}

	public int getI() {
		return sCIDefault.getI();
	}

	public void setI(int value) {
		sCIDefault.setI(value);
	}

	/* Entry action for statechart 'InEventLifeCycle'. */
	private void entryAction() {
	}

	/* Exit action for state 'InEventLifeCycle'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
		if (sCIDefault.e) {
			sCIDefault.i += 1;
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					reactMain_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

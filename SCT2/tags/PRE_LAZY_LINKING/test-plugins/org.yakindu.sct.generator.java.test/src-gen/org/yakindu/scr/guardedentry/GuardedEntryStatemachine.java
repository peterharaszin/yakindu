package org.yakindu.scr.guardedentry;

public class GuardedEntryStatemachine implements IGuardedEntryStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e;

		public void raiseE() {
			e = true;
		}

		private boolean guard = false;

		public boolean getGuard() {
			return guard;
		}

		public void setGuard(boolean value) {
			this.guard = value;
		}

		private boolean done = false;

		public boolean getDone() {
			return done;
		}

		public void setDone(boolean value) {
			this.done = value;
		}

		public void clearEvents() {
			e = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_A, Main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public GuardedEntryStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_A :
				return stateVector[0] == State.Main_region_A;

			case Main_region_B :
				return stateVector[0] == State.Main_region_B;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE() {
		sCIDefault.raiseE();
	}

	public boolean getGuard() {
		return sCIDefault.getGuard();
	}

	public void setGuard(boolean value) {
		sCIDefault.setGuard(value);
	}
	public boolean getDone() {
		return sCIDefault.getDone();
	}

	public void setDone(boolean value) {
		sCIDefault.setDone(value);
	}

	public void enter() {
		sCIDefault.guard = false;

		sCIDefault.done = false;

		entryActionGuardedEntry();
		sCIDefault.done = true;

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_A;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_A :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_B :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionGuardedEntry();
	}

	private void entryActionGuardedEntry() {

	}

	private void exitActionGuardedEntry() {

	}

	private void reactMain_region_A() {
		if (sCIDefault.e) {
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_B;

		}

	}
	private void reactMain_region_B() {
		if (sCIDefault.e) {
			stateVector[0] = State.$NullState$;

			sCIDefault.done = true;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_A;

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_A :
					reactMain_region_A();
					break;
				case Main_region_B :
					reactMain_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

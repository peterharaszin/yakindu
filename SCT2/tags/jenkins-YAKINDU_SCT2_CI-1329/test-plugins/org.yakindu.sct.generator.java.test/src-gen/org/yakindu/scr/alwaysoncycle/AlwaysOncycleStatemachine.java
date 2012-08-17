package org.yakindu.scr.alwaysoncycle;

public class AlwaysOncycleStatemachine implements IAlwaysOncycleStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_StateA, Main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AlwaysOncycleStatemachine() {

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

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_StateA :
				return stateVector[0] == State.Main_region_StateA;

			case Main_region_StateB :
				return stateVector[0] == State.Main_region_StateB;

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

	public int getValue() {
		return sCIDefault.getValue();
	}

	public void setValue(int value) {
		sCIDefault.setValue(value);
	}

	public void enter() {
		entryActionAlwaysOncycle();
		sCIDefault.value = 0;

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_StateA;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_StateA :
				stateVector[0] = State.$NullState$;
				sCIDefault.value = 0;

				break;

			case Main_region_StateB :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionAlwaysOncycle();
	}

	private void entryActionAlwaysOncycle() {

	}

	private void exitActionAlwaysOncycle() {

	}

	private void reactMain_region_StateA() {
		if ((sCIDefault.value == 5)) {
			stateVector[0] = State.$NullState$;
			sCIDefault.value = 0;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_StateB;

		} else {
			sCIDefault.value += 1;

		}

	}
	private void reactMain_region_StateB() {
		if ((sCIDefault.value == 5)) {
			stateVector[0] = State.$NullState$;

			sCIDefault.value = 0;

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_StateA;

		} else {
			sCIDefault.value += 1;

		}

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_StateA :
					reactMain_region_StateA();
					break;
				case Main_region_StateB :
					reactMain_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

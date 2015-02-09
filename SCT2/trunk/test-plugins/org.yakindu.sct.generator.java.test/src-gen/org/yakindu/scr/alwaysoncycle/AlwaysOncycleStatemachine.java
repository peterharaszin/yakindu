package org.yakindu.scr.alwaysoncycle;

public class AlwaysOncycleStatemachine implements IAlwaysOncycleStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private long value;
		public long getValue() {
			return value;
		}

		public void setValue(long value) {
			this.value = value;
		}

		private boolean v2;
		public boolean getV2() {
			return v2;
		}

		public void setV2(boolean value) {
			this.v2 = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AlwaysOncycleStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.value = 0;

		sCInterface.v2 = false;
	}

	public void enter() {
		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getValue() {
		return sCInterface.getValue();
	}

	public void setValue(long value) {
		sCInterface.setValue(value);
	}
	public boolean getV2() {
		return sCInterface.getV2();
	}

	public void setV2(boolean value) {
		sCInterface.setV2(value);
	}

	private boolean check_main_region_StateA_tr0() {
		return sCInterface.value == 5;
	}

	private boolean check_main_region_StateA_lr1() {
		return true;
	}

	private boolean check_main_region_StateB_tr0() {
		return sCInterface.value == 5;
	}

	private boolean check_main_region_StateB_lr0() {
		return true;
	}

	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();

		enterSequence_main_region_StateB_default();
	}

	private void effect_main_region_StateA_lr1() {
		sCInterface.value += 1;
	}

	private void effect_main_region_StateB_tr0() {
		exitSequence_main_region_StateB();

		enterSequence_main_region_StateA_default();
	}

	private void effect_main_region_StateB_lr0() {
		sCInterface.value += 1;
	}

	/* Entry action for statechart 'AlwaysOncycle'. */
	private void entryAction() {
	}

	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_StateA() {
		sCInterface.value = 0;
	}

	/* Exit action for state 'AlwaysOncycle'. */
	private void exitAction() {
	}

	/* Exit action for state 'StateA'. */
	private void exitAction_main_region_StateA() {
		sCInterface.value = 0;
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		entryAction_main_region_StateA();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_StateA();
	}

	/* Default exit sequence for state StateB */
	private void exitSequence_main_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_StateA :
				exitSequence_main_region_StateA();
				break;

			case main_region_StateB :
				exitSequence_main_region_StateB();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
		if (check_main_region_StateA_tr0()) {
			effect_main_region_StateA_tr0();
		} else {
			effect_main_region_StateA_lr1();
		}
	}

	/* The reactions of state StateB. */
	private void react_main_region_StateB() {
		if (check_main_region_StateB_tr0()) {
			effect_main_region_StateB_tr0();
		} else {
			effect_main_region_StateB_lr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					react_main_region_StateA();
					break;
				case main_region_StateB :
					react_main_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

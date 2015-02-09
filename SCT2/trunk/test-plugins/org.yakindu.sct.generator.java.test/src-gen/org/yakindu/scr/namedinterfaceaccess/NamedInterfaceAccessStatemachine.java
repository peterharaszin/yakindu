package org.yakindu.scr.namedinterfaceaccess;

public class NamedInterfaceAccessStatemachine
		implements
			INamedInterfaceAccessStatemachine {

	static {
	}

	private final class SCISafeImpl implements SCISafe {

		private boolean open;

		public boolean isRaisedOpen() {
			return open;
		}

		private void raiseOpen() {
			open = true;
		}

		private boolean close;

		public boolean isRaisedClose() {
			return close;
		}

		private void raiseClose() {
			close = true;
		}

		public void clearEvents() {
		}

		public void clearOutEvents() {
			open = false;
			close = false;
		}
	}

	private SCISafeImpl sCISafe;
	private final class SCIUserImpl implements SCIUser {

		private boolean numberPressed;

		private long numberPressedValue;

		public void raiseNumberPressed(long value) {
			numberPressed = true;
			numberPressedValue = value;
		}

		private long getNumberPressedValue() {
			if (!numberPressed)
				throw new IllegalStateException(
						"Illegal event value acces. Event NumberPressed is not raised!");
			return numberPressedValue;
		}

		private boolean reset;

		public void raiseReset() {
			reset = true;
		}

		public void clearEvents() {
			numberPressed = false;
			reset = false;
		}

	}

	private SCIUserImpl sCIUser;

	public enum State {
		region_1_Idle, region_1_Number1Pressed, region_1_Number2Pressed, region_1_Number3Pressed, _region1_Closed, _region1_Open, $NullState$
	};

	private long number1;
	private long number2;
	private long number3;

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public NamedInterfaceAccessStatemachine() {

		sCISafe = new SCISafeImpl();
		sCIUser = new SCIUserImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		number1 = 3;

		number2 = 7;

		number3 = 5;
	}

	public void enter() {
		entryAction();

		enterSequence_region_1_default();

		enterSequence__region1_default();
	}

	public void exit() {
		exitSequence_region_1();

		exitSequence__region1();

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCISafe.clearEvents();
		sCIUser.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCISafe.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case region_1_Idle :
				return stateVector[0] == State.region_1_Idle;
			case region_1_Number1Pressed :
				return stateVector[0] == State.region_1_Number1Pressed;
			case region_1_Number2Pressed :
				return stateVector[0] == State.region_1_Number2Pressed;
			case region_1_Number3Pressed :
				return stateVector[0] == State.region_1_Number3Pressed;
			case _region1_Closed :
				return stateVector[1] == State._region1_Closed;
			case _region1_Open :
				return stateVector[1] == State._region1_Open;
			default :
				return false;
		}
	}

	public SCISafe getSCISafe() {
		return sCISafe;
	}
	public SCIUser getSCIUser() {
		return sCIUser;
	}

	private boolean check_region_1_Idle_tr0() {
		return (sCIUser.numberPressed) && sCIUser.numberPressedValue == number1;
	}

	private boolean check_region_1_Number1Pressed_tr0() {
		return (sCIUser.numberPressed) && sCIUser.numberPressedValue == number2;
	}

	private boolean check_region_1_Number1Pressed_tr1() {
		return sCIUser.numberPressed;
	}

	private boolean check_region_1_Number2Pressed_tr0() {
		return (sCIUser.numberPressed) && sCIUser.numberPressedValue == number3;
	}

	private boolean check_region_1_Number2Pressed_tr1() {
		return sCIUser.numberPressed;
	}

	private boolean check_region_1_Number3Pressed_tr0() {
		return sCIUser.numberPressed;
	}

	private boolean check__region1_Closed_tr0() {
		return sCISafe.open;
	}

	private boolean check__region1_Open_tr0() {
		return sCISafe.close;
	}

	private void effect_region_1_Idle_tr0() {
		exitSequence_region_1_Idle();

		enterSequence_region_1_Number1Pressed_default();
	}

	private void effect_region_1_Number1Pressed_tr0() {
		exitSequence_region_1_Number1Pressed();

		enterSequence_region_1_Number2Pressed_default();
	}

	private void effect_region_1_Number1Pressed_tr1() {
		exitSequence_region_1_Number1Pressed();

		enterSequence_region_1_Idle_default();
	}

	private void effect_region_1_Number2Pressed_tr0() {
		exitSequence_region_1_Number2Pressed();

		enterSequence_region_1_Number3Pressed_default();
	}

	private void effect_region_1_Number2Pressed_tr1() {
		exitSequence_region_1_Number2Pressed();

		enterSequence_region_1_Idle_default();
	}

	private void effect_region_1_Number3Pressed_tr0() {
		exitSequence_region_1_Number3Pressed();

		enterSequence_region_1_Idle_default();
	}

	private void effect__region1_Closed_tr0() {
		exitSequence__region1_Closed();

		enterSequence__region1_Open_default();
	}

	private void effect__region1_Open_tr0() {
		exitSequence__region1_Open();

		enterSequence__region1_Closed_default();
	}

	/* Entry action for statechart 'NamedInterfaceAccess'. */
	private void entryAction() {
	}

	/* Entry action for state 'Idle'. */
	private void entryAction_region_1_Idle() {
		sCISafe.raiseClose();
	}

	/* Entry action for state 'Number3Pressed'. */
	private void entryAction_region_1_Number3Pressed() {
		sCISafe.raiseOpen();
	}

	/* Exit action for state 'NamedInterfaceAccess'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Idle */
	private void enterSequence_region_1_Idle_default() {
		entryAction_region_1_Idle();

		nextStateIndex = 0;
		stateVector[0] = State.region_1_Idle;
	}

	/* 'default' enter sequence for state Number1Pressed */
	private void enterSequence_region_1_Number1Pressed_default() {
		nextStateIndex = 0;
		stateVector[0] = State.region_1_Number1Pressed;
	}

	/* 'default' enter sequence for state Number2Pressed */
	private void enterSequence_region_1_Number2Pressed_default() {
		nextStateIndex = 0;
		stateVector[0] = State.region_1_Number2Pressed;
	}

	/* 'default' enter sequence for state Number3Pressed */
	private void enterSequence_region_1_Number3Pressed_default() {
		entryAction_region_1_Number3Pressed();

		nextStateIndex = 0;
		stateVector[0] = State.region_1_Number3Pressed;
	}

	/* 'default' enter sequence for state Closed */
	private void enterSequence__region1_Closed_default() {
		nextStateIndex = 1;
		stateVector[1] = State._region1_Closed;
	}

	/* 'default' enter sequence for state Open */
	private void enterSequence__region1_Open_default() {
		nextStateIndex = 1;
		stateVector[1] = State._region1_Open;
	}

	/* 'default' enter sequence for region region 1 */
	private void enterSequence_region_1_default() {
		react_region_1__entry_Default();
	}

	/* 'default' enter sequence for region null */
	private void enterSequence__region1_default() {
		react__region1__entry_Default();
	}

	/* Default exit sequence for state Idle */
	private void exitSequence_region_1_Idle() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Number1Pressed */
	private void exitSequence_region_1_Number1Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Number2Pressed */
	private void exitSequence_region_1_Number2Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Number3Pressed */
	private void exitSequence_region_1_Number3Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Closed */
	private void exitSequence__region1_Closed() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Open */
	private void exitSequence__region1_Open() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region region 1 */
	private void exitSequence_region_1() {
		switch (stateVector[0]) {
			case region_1_Idle :
				exitSequence_region_1_Idle();
				break;

			case region_1_Number1Pressed :
				exitSequence_region_1_Number1Pressed();
				break;

			case region_1_Number2Pressed :
				exitSequence_region_1_Number2Pressed();
				break;

			case region_1_Number3Pressed :
				exitSequence_region_1_Number3Pressed();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequence__region1() {
		switch (stateVector[1]) {
			case _region1_Closed :
				exitSequence__region1_Closed();
				break;

			case _region1_Open :
				exitSequence__region1_Open();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Idle. */
	private void react_region_1_Idle() {
		if (check_region_1_Idle_tr0()) {
			effect_region_1_Idle_tr0();
		}
	}

	/* The reactions of state Number1Pressed. */
	private void react_region_1_Number1Pressed() {
		if (check_region_1_Number1Pressed_tr0()) {
			effect_region_1_Number1Pressed_tr0();
		} else {
			if (check_region_1_Number1Pressed_tr1()) {
				effect_region_1_Number1Pressed_tr1();
			}
		}
	}

	/* The reactions of state Number2Pressed. */
	private void react_region_1_Number2Pressed() {
		if (check_region_1_Number2Pressed_tr0()) {
			effect_region_1_Number2Pressed_tr0();
		} else {
			if (check_region_1_Number2Pressed_tr1()) {
				effect_region_1_Number2Pressed_tr1();
			}
		}
	}

	/* The reactions of state Number3Pressed. */
	private void react_region_1_Number3Pressed() {
		if (check_region_1_Number3Pressed_tr0()) {
			effect_region_1_Number3Pressed_tr0();
		}
	}

	/* The reactions of state Closed. */
	private void react__region1_Closed() {
		if (check__region1_Closed_tr0()) {
			effect__region1_Closed_tr0();
		}
	}

	/* The reactions of state Open. */
	private void react__region1_Open() {
		if (check__region1_Open_tr0()) {
			effect__region1_Open_tr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_region_1__entry_Default() {
		enterSequence_region_1_Idle_default();
	}

	/* Default react sequence for initial entry  */
	private void react__region1__entry_Default() {
		enterSequence__region1_Closed_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case region_1_Idle :
					react_region_1_Idle();
					break;
				case region_1_Number1Pressed :
					react_region_1_Number1Pressed();
					break;
				case region_1_Number2Pressed :
					react_region_1_Number2Pressed();
					break;
				case region_1_Number3Pressed :
					react_region_1_Number3Pressed();
					break;
				case _region1_Closed :
					react__region1_Closed();
					break;
				case _region1_Open :
					react__region1_Open();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

package org.yakindu.scr.parenthesis;

public class ParenthesisStatemachine implements IParenthesisStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private long erg;

		public long getErg() {
			return erg;
		}

		public void setErg(long value) {
			this.erg = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		mainRegion_A, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public ParenthesisStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.erg = 0;
	}

	public void enter() {
		entryAction();

		sCInterface.erg = 4 * (3 - 1);

		nextStateIndex = 0;
		stateVector[0] = State.mainRegion_A;
	}

	public void exit() {
		switch (stateVector[0]) {
			case mainRegion_A :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

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
			case mainRegion_A :
				return stateVector[0] == State.mainRegion_A;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getErg() {
		return sCInterface.getErg();
	}

	public void setErg(long value) {
		sCInterface.setErg(value);
	}

	/* Entry action for statechart 'Parenthesis'. */
	private void entryAction() {
	}

	/* Exit action for state 'Parenthesis'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMainRegion_A() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mainRegion_A :
					reactMainRegion_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

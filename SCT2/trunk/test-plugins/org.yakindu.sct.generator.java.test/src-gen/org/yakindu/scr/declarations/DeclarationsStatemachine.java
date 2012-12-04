package org.yakindu.scr.declarations;

public class DeclarationsStatemachine implements IDeclarationsStatemachine {

	private boolean evInA;

	private boolean evInB;

	private boolean evInC;

	private boolean evInCValue;
	private boolean evInD;

	private int evInDValue;
	private boolean evInE;

	private double evInEValue;
	private boolean evInF;

	private String evInFValue;

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean evA;

		public void raiseEvA() {
			evA = true;
		}

		private boolean evB;

		public boolean isRaisedEvB() {
			return evB;
		}

		private void raiseEvB() {
			evB = true;
		}

		private boolean evC;

		private boolean evCValue;

		public void raiseEvC(boolean value) {
			evC = true;
			evCValue = value;
		}

		private boolean getEvCValue() {
			if (!evC)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvC is not raised!");
			return evCValue;
		}

		private boolean evD;

		private int evDValue;

		public boolean isRaisedEvD() {
			return evD;
		}

		private void raiseEvD(int value) {
			evD = true;
			evDValue = value;
		}

		public int getEvDValue() {
			if (!evD)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvD is not raised!");
			return evDValue;
		}

		private boolean evE;

		private double evEValue;

		public void raiseEvE(double value) {
			evE = true;
			evEValue = value;
		}

		private double getEvEValue() {
			if (!evE)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvE is not raised!");
			return evEValue;
		}

		private boolean evF;

		private String evFValue;

		public boolean isRaisedEvF() {
			return evF;
		}

		private void raiseEvF(String value) {
			evF = true;
			evFValue = value;
		}

		public String getEvFValue() {
			if (!evF)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvF is not raised!");
			return evFValue;
		}

		private boolean varA;

		public boolean getVarA() {
			return varA;
		}

		public void setVarA(boolean value) {
			this.varA = value;
		}

		private int varB;

		public int getVarB() {
			return varB;
		}

		public void setVarB(int value) {
			this.varB = value;
		}

		private double varC;

		public double getVarC() {
			return varC;
		}

		public void setVarC(double value) {
			this.varC = value;
		}

		private String varD;

		public String getVarD() {
			return varD;
		}

		public void setVarD(String value) {
			this.varD = value;
		}

		public void clearEvents() {
			evA = false;
			evC = false;
			evE = false;
		}

		public void clearOutEvents() {
			evB = false;
			evD = false;
			evF = false;
		}
	}

	private SCIDefaultImpl sCIDefault;
	private final class SCIIfAImpl implements SCIIfA {

		private boolean evA;

		public void raiseEvA() {
			evA = true;
		}

		private boolean evB;

		public boolean isRaisedEvB() {
			return evB;
		}

		private void raiseEvB() {
			evB = true;
		}

		private boolean evC;

		private boolean evCValue;

		public void raiseEvC(boolean value) {
			evC = true;
			evCValue = value;
		}

		private boolean getEvCValue() {
			if (!evC)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvC is not raised!");
			return evCValue;
		}

		private boolean evD;

		private int evDValue;

		public boolean isRaisedEvD() {
			return evD;
		}

		private void raiseEvD(int value) {
			evD = true;
			evDValue = value;
		}

		public int getEvDValue() {
			if (!evD)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvD is not raised!");
			return evDValue;
		}

		private boolean evE;

		private double evEValue;

		public void raiseEvE(double value) {
			evE = true;
			evEValue = value;
		}

		private double getEvEValue() {
			if (!evE)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvE is not raised!");
			return evEValue;
		}

		private boolean evF;

		private String evFValue;

		public boolean isRaisedEvF() {
			return evF;
		}

		private void raiseEvF(String value) {
			evF = true;
			evFValue = value;
		}

		public String getEvFValue() {
			if (!evF)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvF is not raised!");
			return evFValue;
		}

		private boolean varA;

		public boolean getVarA() {
			return varA;
		}

		public void setVarA(boolean value) {
			this.varA = value;
		}

		private int varB;

		public int getVarB() {
			return varB;
		}

		public void setVarB(int value) {
			this.varB = value;
		}

		private double varC;

		public double getVarC() {
			return varC;
		}

		public void setVarC(double value) {
			this.varC = value;
		}

		private String varD;

		public String getVarD() {
			return varD;
		}

		public void setVarD(String value) {
			this.varD = value;
		}

		public void clearEvents() {
			evA = false;
			evC = false;
			evE = false;
		}

		public void clearOutEvents() {
			evB = false;
			evD = false;
			evF = false;
		}
	}

	private SCIIfAImpl sCIIfA;

	public enum State {
		main_region_A, $NullState$
	};

	private boolean varInA;
	private int varInB;
	private double varInC;
	private String varInD;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public DeclarationsStatemachine() {

		sCIDefault = new SCIDefaultImpl();
		sCIIfA = new SCIIfAImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.varA = false;

		sCIDefault.varB = 1;

		sCIDefault.varC = 1.0;

		sCIDefault.varD = "myString";

		sCIIfA.varA = false;

		sCIIfA.varB = 1;

		sCIIfA.varC = 1.0;

		sCIIfA.varD = "myString";

		varInA = false;

		varInB = 1;

		varInC = 1.0;

		varInD = "myString";
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
		sCIIfA.clearEvents();
		evInA = false;
		evInB = false;
		evInC = false;
		evInD = false;
		evInE = false;
		evInF = false;

	}

	protected void clearOutEvents() {
		sCIDefault.clearOutEvents();
		sCIIfA.clearOutEvents();
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
	public SCIIfA getSCIIfA() {
		return sCIIfA;
	}

	private void raiseEvInA() {
		evInA = true;
	}

	private void raiseEvInB() {
		evInB = true;
	}

	private void raiseEvInC(boolean value) {
		evInCValue = value;
		evInC = true;
	}

	private boolean getEvInCValue() {
		if (!evInC)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInC is not raised!");
		return evInCValue;
	}
	private void raiseEvInD(int value) {
		evInDValue = value;
		evInD = true;
	}

	private int getEvInDValue() {
		if (!evInD)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInD is not raised!");
		return evInDValue;
	}
	private void raiseEvInE(double value) {
		evInEValue = value;
		evInE = true;
	}

	private double getEvInEValue() {
		if (!evInE)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInE is not raised!");
		return evInEValue;
	}
	private void raiseEvInF(String value) {
		evInFValue = value;
		evInF = true;
	}

	private String getEvInFValue() {
		if (!evInF)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInF is not raised!");
		return evInFValue;
	}

	public void raiseEvA() {
		sCIDefault.raiseEvA();
	}
	public boolean isRaisedEvB() {
		return sCIDefault.isRaisedEvB();
	}
	public void raiseEvC(boolean value) {
		sCIDefault.raiseEvC(value);
	}
	public boolean isRaisedEvD() {
		return sCIDefault.isRaisedEvD();
	}
	public int getEvDValue() {
		return sCIDefault.getEvDValue();
	}
	public void raiseEvE(double value) {
		sCIDefault.raiseEvE(value);
	}
	public boolean isRaisedEvF() {
		return sCIDefault.isRaisedEvF();
	}
	public String getEvFValue() {
		return sCIDefault.getEvFValue();
	}

	public boolean getVarA() {
		return sCIDefault.getVarA();
	}

	public void setVarA(boolean value) {
		sCIDefault.setVarA(value);
	}
	public int getVarB() {
		return sCIDefault.getVarB();
	}

	public void setVarB(int value) {
		sCIDefault.setVarB(value);
	}
	public double getVarC() {
		return sCIDefault.getVarC();
	}

	public void setVarC(double value) {
		sCIDefault.setVarC(value);
	}
	public String getVarD() {
		return sCIDefault.getVarD();
	}

	public void setVarD(String value) {
		sCIDefault.setVarD(value);
	}

	/* Entry action for statechart 'Declarations'. */
	private void entryAction() {
	}

	/* Exit action for state 'Declarations'. */
	private void exitAction() {
	}

	/* The reactions of state A. */
	private void reactMain_region_A() {
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

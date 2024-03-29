package org.yakindu.scr.assignmentasexpression;

public class AssignmentAsExpressionStatemachine
		implements
			IAssignmentAsExpressionStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private long a;

		public long getA() {
			return a;
		}

		public void setA(long value) {
			this.a = value;
		}

		private long b;

		public long getB() {
			return b;
		}

		public void setB(long value) {
			this.b = value;
		}

		private long c;

		public long getC() {
			return c;
		}

		public void setC(long value) {
			this.c = value;
		}

		private long d;

		public long getD() {
			return d;
		}

		public void setD(long value) {
			this.d = value;
		}

		private long e;

		public long getE() {
			return e;
		}

		public void setE(long value) {
			this.e = value;
		}

		private long f;

		public long getF() {
			return f;
		}

		public void setF(long value) {
			this.f = value;
		}

		private long g;

		public long getG() {
			return g;
		}

		public void setG(long value) {
			this.g = value;
		}

		private long h;

		public long getH() {
			return h;
		}

		public void setH(long value) {
			this.h = value;
		}

		private long i;

		public long getI() {
			return i;
		}

		public void setI(long value) {
			this.i = value;
		}

		private long i1;

		public long getI1() {
			return i1;
		}

		public void setI1(long value) {
			this.i1 = value;
		}

		private long j;

		public long getJ() {
			return j;
		}

		public void setJ(long value) {
			this.j = value;
		}

		private long j1;

		public long getJ1() {
			return j1;
		}

		public void setJ1(long value) {
			this.j1 = value;
		}

		private long k;

		public long getK() {
			return k;
		}

		public void setK(long value) {
			this.k = value;
		}

		private long k1;

		public long getK1() {
			return k1;
		}

		public void setK1(long value) {
			this.k1 = value;
		}

		private long l;

		public long getL() {
			return l;
		}

		public void setL(long value) {
			this.l = value;
		}

		private long m;

		public long getM() {
			return m;
		}

		public void setM(long value) {
			this.m = value;
		}

		private long n;

		public long getN() {
			return n;
		}

		public void setN(long value) {
			this.n = value;
		}

		private long p;

		public long getP() {
			return p;
		}

		public void setP(long value) {
			this.p = value;
		}

		private long r;

		public long getR() {
			return r;
		}

		public void setR(long value) {
			this.r = value;
		}

		private long t;

		public long getT() {
			return t;
		}

		public void setT(long value) {
			this.t = value;
		}

		private long u;

		public long getU() {
			return u;
		}

		public void setU(long value) {
			this.u = value;
		}

		private long v;

		public long getV() {
			return v;
		}

		public void setV(long value) {
			this.v = value;
		}

		private long w;

		public long getW() {
			return w;
		}

		public void setW(long value) {
			this.w = value;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_Add, main_region_Multiply, main_region_Divide, main_region_Modulo, main_region_Shift, main_region_boolean_And, main_region_boolean_Or, main_region_boolean_Xor, main_region_Subtract, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AssignmentAsExpressionStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.a = 0;

		sCInterface.b = 0;

		sCInterface.c = 0;

		sCInterface.d = 0;

		sCInterface.e = 1;

		sCInterface.f = 1;

		sCInterface.g = 4;

		sCInterface.h = 32;

		sCInterface.i = 7;

		sCInterface.i1 = 7;

		sCInterface.j = 8;

		sCInterface.j1 = 2;

		sCInterface.k = 8;

		sCInterface.k1 = 4;

		sCInterface.l = 3;

		sCInterface.m = 7;

		sCInterface.n = 5;

		sCInterface.p = 0;

		sCInterface.r = 7;

		sCInterface.t = 10;

		sCInterface.u = 6;

		sCInterface.v = 13;

		sCInterface.w = 7;
	}

	public void enter() {
		entryAction();

		sCInterface.a = (sCInterface.b = 5) + 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Add;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Add :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Multiply :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Divide :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Modulo :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Shift :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_boolean_And :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_boolean_Or :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_boolean_Xor :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Subtract :
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
			case main_region_Add :
				return stateVector[0] == State.main_region_Add;
			case main_region_Multiply :
				return stateVector[0] == State.main_region_Multiply;
			case main_region_Divide :
				return stateVector[0] == State.main_region_Divide;
			case main_region_Modulo :
				return stateVector[0] == State.main_region_Modulo;
			case main_region_Shift :
				return stateVector[0] == State.main_region_Shift;
			case main_region_boolean_And :
				return stateVector[0] == State.main_region_boolean_And;
			case main_region_boolean_Or :
				return stateVector[0] == State.main_region_boolean_Or;
			case main_region_boolean_Xor :
				return stateVector[0] == State.main_region_boolean_Xor;
			case main_region_Subtract :
				return stateVector[0] == State.main_region_Subtract;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getA() {
		return sCInterface.getA();
	}

	public void setA(long value) {
		sCInterface.setA(value);
	}
	public long getB() {
		return sCInterface.getB();
	}

	public void setB(long value) {
		sCInterface.setB(value);
	}
	public long getC() {
		return sCInterface.getC();
	}

	public void setC(long value) {
		sCInterface.setC(value);
	}
	public long getD() {
		return sCInterface.getD();
	}

	public void setD(long value) {
		sCInterface.setD(value);
	}
	public long getE() {
		return sCInterface.getE();
	}

	public void setE(long value) {
		sCInterface.setE(value);
	}
	public long getF() {
		return sCInterface.getF();
	}

	public void setF(long value) {
		sCInterface.setF(value);
	}
	public long getG() {
		return sCInterface.getG();
	}

	public void setG(long value) {
		sCInterface.setG(value);
	}
	public long getH() {
		return sCInterface.getH();
	}

	public void setH(long value) {
		sCInterface.setH(value);
	}
	public long getI() {
		return sCInterface.getI();
	}

	public void setI(long value) {
		sCInterface.setI(value);
	}
	public long getI1() {
		return sCInterface.getI1();
	}

	public void setI1(long value) {
		sCInterface.setI1(value);
	}
	public long getJ() {
		return sCInterface.getJ();
	}

	public void setJ(long value) {
		sCInterface.setJ(value);
	}
	public long getJ1() {
		return sCInterface.getJ1();
	}

	public void setJ1(long value) {
		sCInterface.setJ1(value);
	}
	public long getK() {
		return sCInterface.getK();
	}

	public void setK(long value) {
		sCInterface.setK(value);
	}
	public long getK1() {
		return sCInterface.getK1();
	}

	public void setK1(long value) {
		sCInterface.setK1(value);
	}
	public long getL() {
		return sCInterface.getL();
	}

	public void setL(long value) {
		sCInterface.setL(value);
	}
	public long getM() {
		return sCInterface.getM();
	}

	public void setM(long value) {
		sCInterface.setM(value);
	}
	public long getN() {
		return sCInterface.getN();
	}

	public void setN(long value) {
		sCInterface.setN(value);
	}
	public long getP() {
		return sCInterface.getP();
	}

	public void setP(long value) {
		sCInterface.setP(value);
	}
	public long getR() {
		return sCInterface.getR();
	}

	public void setR(long value) {
		sCInterface.setR(value);
	}
	public long getT() {
		return sCInterface.getT();
	}

	public void setT(long value) {
		sCInterface.setT(value);
	}
	public long getU() {
		return sCInterface.getU();
	}

	public void setU(long value) {
		sCInterface.setU(value);
	}
	public long getV() {
		return sCInterface.getV();
	}

	public void setV(long value) {
		sCInterface.setV(value);
	}
	public long getW() {
		return sCInterface.getW();
	}

	public void setW(long value) {
		sCInterface.setW(value);
	}

	/* Entry action for statechart 'AssignmentAsExpression'. */
	private void entryAction() {
	}

	/* Exit action for state 'AssignmentAsExpression'. */
	private void exitAction() {
	}

	/* The reactions of state Add. */
	private void reactMain_region_Add() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.d -= (sCInterface.c -= 5) - 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Subtract;
	}

	/* The reactions of state Multiply. */
	private void reactMain_region_Multiply() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.g /= (sCInterface.h /= 2) / 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divide;
	}

	/* The reactions of state Divide. */
	private void reactMain_region_Divide() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.i %= (sCInterface.i1 %= 4) % 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Modulo;
	}

	/* The reactions of state Modulo. */
	private void reactMain_region_Modulo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.j <<= (sCInterface.j1 >>= 1);

		sCInterface.k >>= (sCInterface.k1 >>= 2);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Shift;
	}

	/* The reactions of state Shift. */
	private void reactMain_region_Shift() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.l &= (sCInterface.n &= sCInterface.m);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_And;
	}

	/* The reactions of state boolean And. */
	private void reactMain_region_boolean_And() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.p |= (sCInterface.r |= sCInterface.t);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Or;
	}

	/* The reactions of state boolean Or. */
	private void reactMain_region_boolean_Or() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.u ^= (sCInterface.v ^= sCInterface.w);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Xor;
	}

	/* The reactions of state boolean Xor. */
	private void reactMain_region_boolean_Xor() {
	}

	/* The reactions of state Subtract. */
	private void reactMain_region_Subtract() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.e *= (sCInterface.f *= 5) * 3;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Multiply;
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Add :
					reactMain_region_Add();
					break;
				case main_region_Multiply :
					reactMain_region_Multiply();
					break;
				case main_region_Divide :
					reactMain_region_Divide();
					break;
				case main_region_Modulo :
					reactMain_region_Modulo();
					break;
				case main_region_Shift :
					reactMain_region_Shift();
					break;
				case main_region_boolean_And :
					reactMain_region_boolean_And();
					break;
				case main_region_boolean_Or :
					reactMain_region_boolean_Or();
					break;
				case main_region_boolean_Xor :
					reactMain_region_boolean_Xor();
					break;
				case main_region_Subtract :
					reactMain_region_Subtract();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}

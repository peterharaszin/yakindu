package org.yakindu.sct.generator.java.runtime.cyclebased.test_transition;

import java.util.List;
import org.yakindu.sct.generator.java.runtime.cyclebased.IStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.ITimedStatemachine;

public interface ITest_transitionStatemachine
		extends
			ITimedStatemachine,
			IStatemachine {

	public interface InterfaceA {
		public void raiseEvent1(int value);

		public void raiseEvent2();

		public void raiseEvent3();

		public void raiseEvent4();
		public boolean isRaisedEvent5();

		public List<InterfaceAListener> getListeners();
	}

	public interface InterfaceAListener {

		public void onEvent5Raised();
	}

	public interface DefaultInterface {
		public void raiseEvent5(boolean value);

		public void raiseEvent6();
		public boolean isRaisedEvent7();

		public int getI();
		public void setI(int value);
		public double getJ();
		public void setJ(double value);

		public List<DefaultInterfaceListener> getListeners();
	}

	public interface DefaultInterfaceListener {

		public void onEvent7Raised();
	}

	public InterfaceA getInterfaceA();

	public DefaultInterface getDefaultInterface();

}

package org.yakindu.scr.historywithoutinitialstep;
import org.yakindu.scr.IStatemachine;

public interface IHistoryWithoutInitialStepStatemachine extends IStatemachine {

	public interface SCIDefault {
		public void raiseE1();
		public void raiseE2();

	}

	public SCIDefault getSCIDefault();

}

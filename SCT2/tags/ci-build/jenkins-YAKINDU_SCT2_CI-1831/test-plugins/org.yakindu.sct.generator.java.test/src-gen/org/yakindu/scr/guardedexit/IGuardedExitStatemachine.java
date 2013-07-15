package org.yakindu.scr.guardedexit;
import org.yakindu.scr.IStatemachine;

public interface IGuardedExitStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public boolean getGuard();
		public void setGuard(boolean value);
		public boolean getDone();
		public void setDone(boolean value);

	}

	public SCInterface getSCInterface();

}

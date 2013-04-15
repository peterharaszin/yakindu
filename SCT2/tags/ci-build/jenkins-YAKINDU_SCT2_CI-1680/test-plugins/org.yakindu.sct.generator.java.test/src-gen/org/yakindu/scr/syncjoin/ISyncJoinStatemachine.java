package org.yakindu.scr.syncjoin;
import org.yakindu.scr.IStatemachine;

public interface ISyncJoinStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public void raiseJc();
		public void raiseJd();

	}

	public SCInterface getSCInterface();

}

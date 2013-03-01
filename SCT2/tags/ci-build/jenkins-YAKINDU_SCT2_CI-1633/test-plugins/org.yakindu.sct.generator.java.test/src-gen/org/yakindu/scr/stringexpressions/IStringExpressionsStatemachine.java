package org.yakindu.scr.stringexpressions;
import org.yakindu.scr.IStatemachine;

public interface IStringExpressionsStatemachine extends IStatemachine {

	public interface SCIDefault {
		public void raiseE1();
		public String getMyString();
		public void setMyString(String value);
		public String getMyString2();
		public void setMyString2(String value);
		public boolean getEquals();
		public void setEquals(boolean value);
		public boolean getNotEqual();
		public void setNotEqual(boolean value);

	}

	public SCIDefault getSCIDefault();

}

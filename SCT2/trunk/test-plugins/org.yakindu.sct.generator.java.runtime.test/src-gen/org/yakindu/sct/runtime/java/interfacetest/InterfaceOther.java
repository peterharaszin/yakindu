/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.runtime.java.interfacetest;

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.INotificationSender;


public interface InterfaceOther extends INotificationSender {
	
	public void raiseEvent3();
	public boolean isRaisedEvent4();
		
	public Event getEventEvent4();
	
	
	public int getVarV1();
	public void setVarV1(int value);	
}

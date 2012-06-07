/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.util;

import java.util.EventObject;

/**
 * @author Andreas Unger
 *
 */
public class ConnectionEvent extends EventObject {

	public static final int CONNECTED = 0;
	public static final int DISCONNECTED = 1;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int eventType;

	/**
	 * @param source
	 */
	public ConnectionEvent(Object source, int eventType) {
		super(source);
		this.eventType = eventType;
	}

	/**
	 * @return the eventType
	 */
	public int getEventType() {
		return eventType;
	}

}

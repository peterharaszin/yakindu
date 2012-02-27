/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.rte;

import org.eclipselabs.damos.codegen.c.rte.IMessageQueueInfo;

/**
 * @author  Andreas Unger
 */
public class MessageQueueInfo implements IMessageQueueInfo {

	private String capacity;
	private String elementSize;

	public MessageQueueInfo(String capacity, String elementSize) {
		this.capacity = capacity;
		this.elementSize = elementSize;
	}

	/**
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * @return the elementSize
	 */
	public String getElementSize() {
		return elementSize;
	}

}
/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.codegen.c.internal.rte;

import org.eclipse.damos.codegen.c.rte.ISemaphoreInfo;

/**
 * @author Andreas Unger
 *
 */
public class SemaphoreInfo implements ISemaphoreInfo {

	private String maximumCount;
	private String initialCount;
	
	/**
	 * @param maximumCount
	 * @param initialCount
	 */
	public SemaphoreInfo(String maximumCount, String initialCount) {
		super();
		this.maximumCount = maximumCount;
		this.initialCount = initialCount;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.internal.rte.ISemaphoreDescriptor#getMaximumCount()
	 */
	public String getMaximumCount() {
		return maximumCount;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.internal.rte.ISemaphoreDescriptor#getInitialCount()
	 */
	public String getInitialCount() {
		return initialCount;
	}
	
}

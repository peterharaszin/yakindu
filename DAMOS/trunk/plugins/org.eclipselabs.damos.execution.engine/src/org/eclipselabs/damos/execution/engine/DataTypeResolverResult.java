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

package org.eclipselabs.damos.execution.engine;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolverResult {

	private Map<Component, IComponentSignature> signatures = new HashMap<Component, IComponentSignature>();
	private IStatus status = Status.OK_STATUS;

	public Map<Component, IComponentSignature> getSignatures() {
		return signatures;
	}
	
	/**
	 * @return the status
	 */
	public IStatus getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(IStatus status) {
		this.status = status;
	}
	
}

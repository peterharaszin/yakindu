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

package org.eclipse.damos.execution.transform;

import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.damos.execution.Node;

/**
 * @author Andreas Unger
 *
 */
public class DeadlockStatus extends Status {

	private List<Node> backlog;
	
	/**
	 * 
	 */
	public DeadlockStatus(int severity, String pluginId, int code, String message, Throwable exception, List<Node> backlog) {
		super(severity, pluginId, code, message, exception);
		this.backlog = backlog;
	}
	
	/**
	 * @return the backlog
	 */
	public List<Node> getBacklog() {
		return backlog;
	}
	
}

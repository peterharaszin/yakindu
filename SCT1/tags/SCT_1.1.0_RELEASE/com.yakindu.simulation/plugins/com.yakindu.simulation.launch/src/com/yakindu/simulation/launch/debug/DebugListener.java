/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.launch.debug;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public class DebugListener implements IDebugElement {

	private IDebugTarget debugTarget;
	private ILaunch launch;
	private String identifier;

	public DebugListener(final IDebugTarget debugTarget, final String identifier) {
		this.debugTarget = debugTarget;
		this.identifier = identifier;
	}

	public IDebugTarget getDebugTarget() {
		return debugTarget;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public String getModelIdentifier() {
		return identifier;
	}

	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}

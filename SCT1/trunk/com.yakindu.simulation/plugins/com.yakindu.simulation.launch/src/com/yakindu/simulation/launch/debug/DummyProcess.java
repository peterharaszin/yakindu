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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

public class DummyProcess implements IProcess {

	private final ILaunch launch;
	private Map<String, String> keys = new HashMap<String, String>();

	public DummyProcess(final ILaunch launch) {
		this.launch = launch;
	}

	public String getAttribute(final String key) {
		return keys.get(key);
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	public String getLabel() {
		return "Dummy Process";
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public void setAttribute(final String key, final String value) {
		keys.put(key, value);
	}

	public Object getAdapter(final Class adapter) {
		return null;
	}

	private boolean terminated = false;

	public boolean canTerminate() {
		return true;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		terminated = true;
	}

}

/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGraphSimulationSessionRegistry {

	public static final SGraphSimulationSessionRegistry INSTANCE = new SGraphSimulationSessionRegistry();

	private List<ISimulationSessionListener> sessionListener;

	private List<ISGraphSimulationSession> sessions;

	private SGraphSimulationSessionRegistry() {
		sessionListener = new ArrayList<ISimulationSessionListener>();
		sessions = new ArrayList<ISGraphSimulationSession>();
	}

	public void registerSimulationSession(ISGraphSimulationSession session) {
		session.getListeners().addAll(getListeners());
		sessions.add(session);
	}

	public void unregisterSimulationSession(ISGraphSimulationSession session) {
		session.getListeners().clear();
		sessions.remove(session);
	}

	public List<ISimulationSessionListener> getListeners() {
		return sessionListener;
	}

	public ISGraphSimulationSession getActiveSession() {
		// TODO
		if (sessions.isEmpty())
			return null;
		return sessions.get(0);
	}

}

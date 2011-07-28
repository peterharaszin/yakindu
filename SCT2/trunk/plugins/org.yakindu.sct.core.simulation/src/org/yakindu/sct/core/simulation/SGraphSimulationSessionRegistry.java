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
package org.yakindu.sct.core.simulation;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.core.simulation.extensions.Extensions;
import org.yakindu.sct.core.simulation.extensions.IExtensionPoints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGraphSimulationSessionRegistry implements IExtensionPoints {

	public static final SGraphSimulationSessionRegistry INSTANCE = new SGraphSimulationSessionRegistry();

	private List<SGraphSimulationSession> sessions;

	private SGraphSimulationSessionRegistry() {
		sessions = new ArrayList<SGraphSimulationSession>();
	}

	public void registerSimulationSession(SGraphSimulationSession session) {
		session.getListeners().addAll(getListeners());
		sessions.add(session);
	}

	public void unregisterSimulationSession(SGraphSimulationSession session) {
		session.getListeners().clear();
		sessions.remove(session);
	}

	protected List<ISimulationSessionListener> getListeners() {
		Extensions<ISimulationSessionListener> extensions = new Extensions<ISimulationSessionListener>(
				SESSION_LISTENER);
		return extensions.getExtensions();
	}

	public SGraphSimulationSession getActiveSession() {
		//TODO
		if (sessions.isEmpty())
			return null;
		return sessions.get(0);
	}

}

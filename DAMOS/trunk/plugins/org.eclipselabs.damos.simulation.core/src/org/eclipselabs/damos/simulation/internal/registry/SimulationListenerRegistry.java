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

package org.eclipselabs.damos.simulation.internal.registry;

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.simulation.ISimulationListener;

/**
 * @author Andreas Unger
 *
 */
public class SimulationListenerRegistry {

	private static final SimulationListenerRegistry INSTANCE = new SimulationListenerRegistry();

	private List<ISimulationListener> listeners = new ArrayList<ISimulationListener>();
	
	/**
	 * 
	 */
	private SimulationListenerRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static SimulationListenerRegistry getInstance() {
		return INSTANCE;
	}
	
	public List<ISimulationListener> getListeners() {
		return listeners;
	}
		
	public void register(ISimulationListener listener) {
		listeners.add(listener);
	}
	
	public void unregister(ISimulationListener listener) {
		listeners.remove(listener);
	}

	private void initializeFromStorage() {
		SimulationListenerRegistryReader reader = new SimulationListenerRegistryReader();
		reader.registerListeners(this);
	}
	
}

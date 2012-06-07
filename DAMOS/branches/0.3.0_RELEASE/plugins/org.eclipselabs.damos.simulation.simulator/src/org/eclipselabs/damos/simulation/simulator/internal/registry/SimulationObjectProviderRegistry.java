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

package org.eclipselabs.damos.simulation.simulator.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider;

/**
 * @author Andreas Unger
 *
 */
public class SimulationObjectProviderRegistry {

	private static final SimulationObjectProviderRegistry INSTANCE = new SimulationObjectProviderRegistry();

	private List<ISimulationObjectProvider> providers = new ArrayList<ISimulationObjectProvider>();
	
	/**
	 * 
	 */
	private SimulationObjectProviderRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static SimulationObjectProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	public ISimulationObject createSimulationObject(ComponentNode node) {
		for (ISimulationObjectProvider provider : providers) {
			ISimulationObject simulationObject = provider.createSimulationObject(node);
			if (simulationObject != null) {
				return simulationObject;
			}
		}
		return null;
	}
		
	public Collection<ISimulationObjectProvider> getProviders() {
		return providers;
	}

	public void register(ISimulationObjectProvider provider) {
		providers.add(provider);
	}
	
	public void unregister(ISimulationObjectProvider provider) {
		providers.remove(provider);
	}

	private void initializeFromStorage() {
		SimulationObjectProviderRegistryReader reader = new SimulationObjectProviderRegistryReader();
		reader.registerProviders(this);
	}
	
}

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

package org.eclipselabs.damos.simulation.engine.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObjectProvider;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSimulationObjectProviderRegistry {

	private static final ComponentSimulationObjectProviderRegistry INSTANCE = new ComponentSimulationObjectProviderRegistry();

	private List<IComponentSimulationObjectProvider> providers = new ArrayList<IComponentSimulationObjectProvider>();
	
	/**
	 * 
	 */
	private ComponentSimulationObjectProviderRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static ComponentSimulationObjectProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	public IComponentSimulationObject createSimulationObject(Component component) {
		for (IComponentSimulationObjectProvider provider : providers) {
			IComponentSimulationObject simulationObject = provider.createSimulationObject(component);
			if (simulationObject != null) {
				return simulationObject;
			}
		}
		return null;
	}
		
	public Collection<IComponentSimulationObjectProvider> getProviders() {
		return providers;
	}

	public void register(IComponentSimulationObjectProvider provider) {
		providers.add(provider);
	}
	
	public void unregister(IComponentSimulationObjectProvider provider) {
		providers.remove(provider);
	}

	private void initializeFromStorage() {
		ComponentSimulationObjectProviderRegistryReader reader = new ComponentSimulationObjectProviderRegistryReader();
		reader.registerProviders(this);
	}
	
}

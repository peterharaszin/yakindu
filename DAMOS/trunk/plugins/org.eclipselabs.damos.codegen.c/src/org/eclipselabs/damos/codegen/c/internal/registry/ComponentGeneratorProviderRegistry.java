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

package org.eclipselabs.damos.codegen.c.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorProviderRegistry {

	private static final ComponentGeneratorProviderRegistry INSTANCE = new ComponentGeneratorProviderRegistry();

	private List<IComponentGeneratorProvider> providers = new ArrayList<IComponentGeneratorProvider>();
	
	/**
	 * 
	 */
	private ComponentGeneratorProviderRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static ComponentGeneratorProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	public IComponentGenerator createGenerator(Component component) {
		for (IComponentGeneratorProvider provider : providers) {
			IComponentGenerator generator = provider.createGenerator(component);
			if (generator != null) {
				return generator;
			}
		}
		return null;
	}
		
	public Collection<IComponentGeneratorProvider> getProviders() {
		return providers;
	}

	public void register(IComponentGeneratorProvider provider) {
		providers.add(provider);
	}
	
	public void unregister(IComponentGeneratorProvider provider) {
		providers.remove(provider);
	}

	private void initializeFromStorage() {
		ComponentGeneratorProviderRegistryReader reader = new ComponentGeneratorProviderRegistryReader();
		reader.registerProviders(this);
	}
	
}

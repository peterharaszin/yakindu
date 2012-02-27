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

package org.eclipselabs.damos.execution.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.IComponentSignaturePolicyProvider;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignaturePolicyProviderRegistry {

	private static final ComponentSignaturePolicyProviderRegistry INSTANCE = new ComponentSignaturePolicyProviderRegistry();

	private List<IComponentSignaturePolicyProvider> providers = new ArrayList<IComponentSignaturePolicyProvider>();
	
	/**
	 * 
	 */
	private ComponentSignaturePolicyProviderRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static ComponentSignaturePolicyProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	public IComponentSignaturePolicy createPolicy(Component component) {
		for (IComponentSignaturePolicyProvider provider : providers) {
			IComponentSignaturePolicy policy = provider.createPolicy(component);
			if (policy != null) {
				return policy;
			}
		}
		return null;
	}
		
	public Collection<IComponentSignaturePolicyProvider> getProviders() {
		return providers;
	}

	public void register(IComponentSignaturePolicyProvider provider) {
		providers.add(provider);
	}
	
	public void unregister(IComponentSignaturePolicyProvider provider) {
		providers.remove(provider);
	}

	private void initializeFromStorage() {
		ComponentSignaturePolicyProviderRegistryReader reader = new ComponentSignaturePolicyProviderRegistryReader();
		reader.registerProviders(this);
	}
	
}

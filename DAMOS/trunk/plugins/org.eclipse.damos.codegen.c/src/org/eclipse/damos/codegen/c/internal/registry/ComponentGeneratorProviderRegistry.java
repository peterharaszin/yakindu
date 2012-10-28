/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.codegen.c.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipse.damos.execution.ComponentNode;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Andreas Unger
 *
 */
@Singleton
public class ComponentGeneratorProviderRegistry {

	@Inject
	private ComponentGeneratorProviderRegistryReader registryReader;
	
	private List<IComponentGeneratorProvider> providers;
	
	public IComponentGenerator createGenerator(ComponentNode node) {
		for (IComponentGeneratorProvider provider : getProviders()) {
			IComponentGenerator generator = provider.createGenerator(node);
			if (generator != null) {
				return generator;
			}
		}
		return null;
	}
		
	public Collection<IComponentGeneratorProvider> getProviders() {
		if (providers == null) {
			providers = new ArrayList<IComponentGeneratorProvider>();
			registryReader.registerProviders(this);
		}
		return providers;
	}

	public void register(IComponentGeneratorProvider provider) {
		getProviders().add(provider);
	}
	
	public void unregister(IComponentGeneratorProvider provider) {
		getProviders().remove(provider);
	}
	
}

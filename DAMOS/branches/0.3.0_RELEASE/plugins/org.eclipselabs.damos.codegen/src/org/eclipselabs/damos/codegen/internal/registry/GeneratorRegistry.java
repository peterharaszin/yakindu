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

package org.eclipselabs.damos.codegen.internal.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.codegen.registry.IGeneratorDescriptor;
import org.eclipselabs.damos.codegen.registry.IGeneratorRegistry;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorRegistry implements IGeneratorRegistry {

	private Map<String, IGeneratorDescriptor> generators = new HashMap<String, IGeneratorDescriptor>();
	
	/**
	 * 
	 */
	public GeneratorRegistry() {
		initializeFromStorage();
	}
	
	public Collection<IGeneratorDescriptor> getGenerators() {
		return generators.values();
	}
	
	public IGeneratorDescriptor getGenerator(String id) {
		return generators.get(id);
	}

	public void register(GeneratorDescriptor generator) {
		generators.put(generator.getId(), generator);
	}
	
	public void unregister(GeneratorDescriptor generator) {
		generators.remove(generator.getId());
	}

	private void initializeFromStorage() {
		GeneratorRegistryReader reader = new GeneratorRegistryReader();
		reader.registerProviders(this);
	}
	
}

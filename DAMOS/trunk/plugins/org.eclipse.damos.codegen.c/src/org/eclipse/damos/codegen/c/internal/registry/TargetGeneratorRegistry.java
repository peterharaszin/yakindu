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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public class TargetGeneratorRegistry {

	private static final TargetGeneratorRegistry INSTANCE = new TargetGeneratorRegistry();
	
	private Map<String, TargetGeneratorDescriptor> generators = new HashMap<String, TargetGeneratorDescriptor>();
	
	/**
	 * 
	 */
	public TargetGeneratorRegistry() {
		initializeFromStorage();
	}
	
	/**
	 * @return the instance
	 */
	public static TargetGeneratorRegistry getInstance() {
		return INSTANCE;
	}
	
	public Collection<TargetGeneratorDescriptor> getGenerators() {
		return generators.values();
	}
	
	public TargetGeneratorDescriptor getGenerator(String id) {
		return generators.get(id);
	}

	public void register(TargetGeneratorDescriptor generator) {
		generators.put(generator.getTargetId(), generator);
	}
	
	public void unregister(TargetGeneratorDescriptor generator) {
		generators.remove(generator.getTargetId());
	}

	private void initializeFromStorage() {
		TargetGeneratorRegistryReader reader = new TargetGeneratorRegistryReader();
		reader.registerProviders(this);
	}
	
}

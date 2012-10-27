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

package org.eclipse.damos.codegen.targets.arduino.internal.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public class ShieldGeneratorRegistry {

	private static final ShieldGeneratorRegistry INSTANCE = new ShieldGeneratorRegistry();
	
	private Map<String, ShieldGeneratorDescriptor> generators = new HashMap<String, ShieldGeneratorDescriptor>();
	
	/**
	 * 
	 */
	public ShieldGeneratorRegistry() {
		initializeFromStorage();
	}
	
	/**
	 * @return the instance
	 */
	public static ShieldGeneratorRegistry getInstance() {
		return INSTANCE;
	}
	
	public Collection<ShieldGeneratorDescriptor> getGenerators() {
		return generators.values();
	}
	
	public ShieldGeneratorDescriptor getGenerator(String id) {
		return generators.get(id);
	}

	public void register(ShieldGeneratorDescriptor generator) {
		generators.put(generator.getShieldId(), generator);
	}
	
	public void unregister(ShieldGeneratorDescriptor generator) {
		generators.remove(generator.getShieldId());
	}

	private void initializeFromStorage() {
		ShieldGeneratorRegistryReader reader = new ShieldGeneratorRegistryReader();
		reader.registerProviders(this);
	}
	
}

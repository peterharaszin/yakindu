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

package org.eclipselabs.damos.dml.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.internal.registry.BlockTypeRegistryReader;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeRegistry {

	private static final BlockTypeRegistry INSTANCE = new BlockTypeRegistry();

	private Map<String, IBlockTypeDescriptor> descriptors = new HashMap<String, IBlockTypeDescriptor>();
	
	/**
	 * 
	 */
	private BlockTypeRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static BlockTypeRegistry getInstance() {
		return INSTANCE;
	}
		
	public Collection<IBlockTypeDescriptor> getDescriptors() {
		return descriptors.values();
	}

	public IBlockTypeDescriptor getDescriptor(String qualifiedName) {
		return descriptors.get(qualifiedName);
	}
	
	public void register(IBlockTypeDescriptor descriptor) {
		descriptors.put(descriptor.getQualifiedName(), descriptor);
	}
	
	public void unregister(IBlockTypeDescriptor descriptor) {
		descriptors.remove(descriptor.getQualifiedName());
	}

	private void initializeFromStorage() {
		BlockTypeRegistryReader reader = new BlockTypeRegistryReader();
		reader.registerBlockTypes(this);
	}
	
}

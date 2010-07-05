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

import org.eclipselabs.damos.dml.internal.registry.BlockGroupRegistryReader;

/**
 * @author Andreas Unger
 *
 */
public class BlockGroupRegistry {

	public static final BlockGroupRegistry INSTANCE = new BlockGroupRegistry();

	private Map<String, IBlockGroupDescriptor> descriptors = new HashMap<String, IBlockGroupDescriptor>();
	
	/**
	 * 
	 */
	private BlockGroupRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static BlockGroupRegistry getInstance() {
		return INSTANCE;
	}
		
	public Collection<IBlockGroupDescriptor> getDescriptors() {
		return descriptors.values();
	}

	public IBlockGroupDescriptor getDescriptor(String id) {
		return descriptors.get(id);
	}
	
	public void register(IBlockGroupDescriptor descriptor) {
		descriptors.put(descriptor.getId(), descriptor);
	}
	
	public void unregister(IBlockGroupDescriptor descriptor) {
		descriptors.remove(descriptor.getId());
	}

	private void initializeFromStorage() {
		BlockGroupRegistryReader reader = new BlockGroupRegistryReader();
		reader.registerBlockGroups(this);
	}
	
}

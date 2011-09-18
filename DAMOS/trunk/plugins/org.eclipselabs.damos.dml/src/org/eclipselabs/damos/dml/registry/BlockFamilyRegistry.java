/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.internal.registry.BlockFamilyRegistryReader;

/**
 * @author Andreas Unger
 *
 */
public class BlockFamilyRegistry {

	private static final BlockFamilyRegistry INSTANCE = new BlockFamilyRegistry();

	private Map<String, IBlockFamilyDescriptor> blockFamilies = new HashMap<String, IBlockFamilyDescriptor>();
	
	/**
	 * 
	 */
	private BlockFamilyRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static BlockFamilyRegistry getInstance() {
		return INSTANCE;
	}
		
	public Collection<IBlockFamilyDescriptor> getBlockFamilies() {
		return Collections.unmodifiableCollection(blockFamilies.values());
	}

	public IBlockFamilyDescriptor getBlockFamily(String id) {
		return blockFamilies.get(id);
	}
	
	public void register(IBlockFamilyDescriptor blockFamily) {
		blockFamilies.put(blockFamily.getId(), blockFamily);
	}
	
	public void unregister(IBlockFamilyDescriptor blockFamily) {
		blockFamilies.remove(blockFamily.getId());
	}

	private void initializeFromStorage() {
		BlockFamilyRegistryReader reader = new BlockFamilyRegistryReader();
		reader.registerBlockFamilies(this);
	}

}

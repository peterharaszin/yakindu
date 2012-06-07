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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.internal.registry.BlockGroupRegistryReader;
import org.eclipselabs.damos.dml.internal.registry.BlockTypeRegistryReader;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeRegistry {

	private static final BlockTypeRegistry INSTANCE = new BlockTypeRegistry();

	private Map<String, IBlockGroupDescriptor> blockGroups = new HashMap<String, IBlockGroupDescriptor>();
	private Map<String, IBlockTypeDescriptor> blockTypes = new HashMap<String, IBlockTypeDescriptor>();
	
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
		
	public Collection<IBlockGroupDescriptor> getBlockGroups() {
		return Collections.unmodifiableCollection(blockGroups.values());
	}

	public IBlockGroupDescriptor getBlockGroup(String id) {
		return blockGroups.get(id);
	}
	
	public void register(IBlockGroupDescriptor blockGroup) {
		blockGroups.put(blockGroup.getId(), blockGroup);
	}
	
	public void unregister(IBlockGroupDescriptor blockGroup) {
		blockGroups.remove(blockGroup.getId());
	}

	public Collection<IBlockTypeDescriptor> getBlockTypes() {
		return Collections.unmodifiableCollection(blockTypes.values());
	}

	public IBlockTypeDescriptor getBlockType(String qualifiedName) {
		return blockTypes.get(qualifiedName);
	}
	
	public void register(IBlockTypeDescriptor blockType) {
		blockTypes.put(blockType.getQualifiedName(), blockType);
	}
	
	public void unregister(IBlockTypeDescriptor blockType) {
		blockTypes.remove(blockType.getQualifiedName());
	}

	private void initializeFromStorage() {
		new BlockGroupRegistryReader().registerBlockGroups(this);
		new BlockTypeRegistryReader().registerBlockTypes(this);
	}
	
}

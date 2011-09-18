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

package org.eclipselabs.damos.dml.internal.registry;

import org.eclipselabs.damos.common.registry.IExecutableExtensionProvider;
import org.eclipselabs.damos.dml.registry.IBlockFamilyDescriptor;
import org.eclipselabs.damos.dml.registry.IBlockTypeFactory;

/**
 * @author Andreas Unger
 *
 */
public class BlockFamilyDescriptor implements IBlockFamilyDescriptor {

	private String id;
	private String name;
	private IExecutableExtensionProvider<IBlockTypeFactory> blockTypeFactoryProvider;
	private IBlockTypeFactory blockTypeFactory;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.registry.IBlockFamilyDescriptor#getId()
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.registry.IBlockFamilyDescriptor#getName()
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param blockTypeFactoryProvider the blockTypeFactoryProvider to set
	 */
	public void setBlockTypeFactoryProvider(IExecutableExtensionProvider<IBlockTypeFactory> blockTypeFactoryProvider) {
		this.blockTypeFactoryProvider = blockTypeFactoryProvider;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.registry.IBlockFamilyDescriptor#getBlockTypeFactory()
	 */
	public IBlockTypeFactory getBlockTypeFactory() {
		if (blockTypeFactory == null && blockTypeFactoryProvider != null) {
			blockTypeFactory = blockTypeFactoryProvider.createExecutableExtension();
		}
		return blockTypeFactory;
	}
	
}

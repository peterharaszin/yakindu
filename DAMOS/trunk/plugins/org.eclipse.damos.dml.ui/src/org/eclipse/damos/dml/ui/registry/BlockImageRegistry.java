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

package org.eclipse.damos.dml.ui.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.dml.ui.internal.registry.BlockImageRegistryReader;

/**
 * @author Andreas Unger
 *
 */
public class BlockImageRegistry {

	private static final BlockImageRegistry INSTANCE = new BlockImageRegistry();

	private Map<String, IBlockImageDescriptor> blockImages = new HashMap<String, IBlockImageDescriptor>();
	
	/**
	 * 
	 */
	private BlockImageRegistry() {
		initializeFromStorage();
	}
	
	/**
	 * @return the instance
	 */
	public static BlockImageRegistry getInstance() {
		return INSTANCE;
	}

	public IBlockImageDescriptor getBlockImage(String blockType) {
		IBlockImageDescriptor blockImage = blockImages.get(blockType);
		if (blockImage != null) {
			return blockImage;
		}
		return null;
	}
	
	public void register(IBlockImageDescriptor blockImage) {
		blockImages.put(blockImage.getBlockTypeQualifiedName(), blockImage);
	}
	
	public void unregister(IBlockImageDescriptor blockImage) {
		blockImages.remove(blockImage.getBlockTypeQualifiedName());
	}

	private void initializeFromStorage() {
		BlockImageRegistryReader reader = new BlockImageRegistryReader();
		reader.registerBlockImages(this);
	}

}

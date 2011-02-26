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

package org.eclipselabs.damos.diagram.ui.internal.registry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public class BlockImageRegistry {

	private static final BlockImageRegistry INSTANCE = new BlockImageRegistry();

	private Map<String, BlockImageDescriptor> descriptors = new HashMap<String, BlockImageDescriptor>();
	
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

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.execution.engine.IComponentSignaturePolicyProvider#createPolicy(org.eclipselabs.damos.dml.Component)
	 */
	public BlockImageDescriptor getDescriptor(String blockTypeQualifiedName) {
		BlockImageDescriptor descriptor = descriptors.get(blockTypeQualifiedName);
		if (descriptor != null) {
			return descriptor;
		}
		return null;
	}
	
	public void register(BlockImageDescriptor descriptor) {
		descriptors.put(descriptor.getBlockTypeQualifiedName(), descriptor);
	}
	
	public void unregister(BlockImageDescriptor descriptor) {
		descriptors.remove(descriptor.getBlockTypeQualifiedName());
	}

	private void initializeFromStorage() {
		BlockImageRegistryReader reader = new BlockImageRegistryReader();
		reader.registerDescriptors(this);
	}

}

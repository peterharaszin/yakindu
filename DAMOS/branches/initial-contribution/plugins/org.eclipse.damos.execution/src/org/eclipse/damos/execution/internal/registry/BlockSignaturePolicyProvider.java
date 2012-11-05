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

package org.eclipse.damos.execution.internal.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.execution.datatype.IComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.IComponentSignaturePolicyProvider;

/**
 * @author Andreas Unger
 *
 */
public class BlockSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	private Map<String, BlockSignaturePolicyDescriptor> descriptors = new HashMap<String, BlockSignaturePolicyDescriptor>();
	
	/**
	 * 
	 */
	public BlockSignaturePolicyProvider() {
		initializeFromStorage();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.execution.IComponentSignaturePolicyProvider#createPolicy(org.eclipse.damos.dml.Component)
	 */
	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Block) {
			BlockType blockType = ((Block) component).getType();
			BlockSignaturePolicyDescriptor descriptor = descriptors.get(blockType.getQualifiedName());
			if (descriptor != null) {
				return descriptor.createObject();
			}
		}
		return null;
	}
	
	public void register(BlockSignaturePolicyDescriptor descriptor) {
		descriptors.put(descriptor.getBlockTypeQualifiedName(), descriptor);
	}
	
	public void unregister(BlockSignaturePolicyDescriptor descriptor) {
		descriptors.remove(descriptor.getBlockTypeQualifiedName());
	}

	private void initializeFromStorage() {
		BlockSignaturePolicyRegistryReader reader = new BlockSignaturePolicyRegistryReader();
		reader.registerDescriptors(this);
	}

}

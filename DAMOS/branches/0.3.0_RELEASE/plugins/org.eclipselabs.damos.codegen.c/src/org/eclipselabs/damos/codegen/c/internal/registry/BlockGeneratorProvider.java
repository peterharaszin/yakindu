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

package org.eclipselabs.damos.codegen.c.internal.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.codegen.c.IComponentGenerator;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.execution.ComponentNode;

/**
 * @author Andreas Unger
 *
 */
public class BlockGeneratorProvider implements IComponentGeneratorProvider {

	private Map<String, BlockGeneratorDescriptor> descriptors = new HashMap<String, BlockGeneratorDescriptor>();
	
	/**
	 * 
	 */
	public BlockGeneratorProvider() {
		initializeFromStorage();
	}

	public IComponentGenerator createGenerator(ComponentNode node) {
		if (node.getComponent() instanceof Block) {
			BlockType blockType = ((Block) node.getComponent()).getType();
			BlockGeneratorDescriptor descriptor = descriptors.get(blockType.getQualifiedName());
			if (descriptor != null) {
				return descriptor.createObject();
			}
		}
		return null;
	}
	
	public void register(BlockGeneratorDescriptor descriptor) {
		descriptors.put(descriptor.getBlockTypeQualifiedName(), descriptor);
	}
	
	public void unregister(BlockGeneratorDescriptor descriptor) {
		descriptors.remove(descriptor.getBlockTypeQualifiedName());
	}

	private void initializeFromStorage() {
		BlockGeneratorRegistryReader reader = new BlockGeneratorRegistryReader();
		reader.registerDescriptors(this);
	}

}

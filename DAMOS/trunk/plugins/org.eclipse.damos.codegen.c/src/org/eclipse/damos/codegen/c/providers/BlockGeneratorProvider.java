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

package org.eclipse.damos.codegen.c.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipse.damos.codegen.c.internal.registry.BlockGeneratorDescriptor;
import org.eclipse.damos.codegen.c.internal.registry.BlockGeneratorRegistryReader;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.execution.ComponentNode;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class BlockGeneratorProvider implements IComponentGeneratorProvider {

	@Inject
	private BlockGeneratorRegistryReader registryReader;

	private Map<String, BlockGeneratorDescriptor> descriptors;
	
	public IComponentGenerator createGenerator(ComponentNode node) {
		if (node.getComponent() instanceof Block) {
			BlockType blockType = ((Block) node.getComponent()).getType();
			BlockGeneratorDescriptor descriptor = getDescriptors().get(blockType.getQualifiedName());
			if (descriptor != null) {
				return descriptor.createGenerator();
			}
		}
		return null;
	}
	
	public void register(BlockGeneratorDescriptor descriptor) {
		getDescriptors().put(descriptor.getBlockTypeQualifiedName(), descriptor);
	}
	
	public void unregister(BlockGeneratorDescriptor descriptor) {
		getDescriptors().remove(descriptor.getBlockTypeQualifiedName());
	}
	
	private Map<String, BlockGeneratorDescriptor> getDescriptors() {
		if (descriptors == null) {
			descriptors = new HashMap<String, BlockGeneratorDescriptor>();
			registryReader.registerDescriptors(this);
		}
		return descriptors;
	}

}

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

package org.eclipselabs.damos.simulation.simulator.internal.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.simulation.simulator.ISimulationObject;
import org.eclipselabs.damos.simulation.simulator.ISimulationObjectProvider;

/**
 * @author Andreas Unger
 *
 */
public class BlockSimulationObjectProvider implements ISimulationObjectProvider {

	private Map<String, BlockSimulationObjectDescriptor> descriptors = new HashMap<String, BlockSimulationObjectDescriptor>();
	
	/**
	 * 
	 */
	public BlockSimulationObjectProvider() {
		initializeFromStorage();
	}

	public ISimulationObject createSimulationObject(ComponentNode node) {
		if (node.getComponent() instanceof Block) {
			BlockType blockType = ((Block) node.getComponent()).getType();
			BlockSimulationObjectDescriptor descriptor = descriptors.get(blockType.getQualifiedName());
			if (descriptor != null) {
				return descriptor.createObject();
			}
		}
		return null;
	}
	
	public void register(BlockSimulationObjectDescriptor descriptor) {
		descriptors.put(descriptor.getBlockTypeQualifiedName(), descriptor);
	}
	
	public void unregister(BlockSimulationObjectDescriptor descriptor) {
		descriptors.remove(descriptor.getBlockTypeQualifiedName());
	}

	private void initializeFromStorage() {
		BlockSimulationObjectRegistryReader reader = new BlockSimulationObjectRegistryReader();
		reader.registerDescriptors(this);
	}

}

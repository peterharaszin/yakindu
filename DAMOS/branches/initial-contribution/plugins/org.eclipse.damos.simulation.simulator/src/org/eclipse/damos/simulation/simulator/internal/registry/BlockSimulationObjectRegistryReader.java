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

package org.eclipse.damos.simulation.simulator.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.common.registry.IRegistryConstants;
import org.eclipse.damos.simulation.simulator.internal.SimulatorPlugin;

/**
 * @author Andreas Unger
 *
 */
public class BlockSimulationObjectRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "blockSimulationObjects";
	
	private static final String TAG = "simulationObject";
	private static final String ATT_BLOCK_TYPE = "blockType";

	private BlockSimulationObjectProvider provider;
	
	public void registerDescriptors(BlockSimulationObjectProvider provider) {
		this.provider = provider;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return SimulatorPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return SimulatorPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG)) {
			return false;
		}

		String blockTypeQualifiedName = getRequiredAttribute(element, ATT_BLOCK_TYPE);
		String className = getRequiredAttribute(element, IRegistryConstants.ATT_CLASS);
		
		BlockSimulationObjectDescriptor descriptor = new BlockSimulationObjectDescriptor();
		descriptor.setBlockTypeQualifiedName(blockTypeQualifiedName);
		descriptor.setClassName(className);
		descriptor.setConfigurationElement(element);
		provider.register(descriptor);

		return true;
	}

}

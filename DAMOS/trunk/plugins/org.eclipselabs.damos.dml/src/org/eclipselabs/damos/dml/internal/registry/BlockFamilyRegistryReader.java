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

package org.eclipselabs.damos.dml.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;
import org.eclipselabs.damos.dml.DMLPlugin;
import org.eclipselabs.damos.dml.registry.BlockFamilyRegistry;
import org.eclipselabs.damos.dml.registry.IBlockTypeFactory;

/**
 * @author Andreas Unger
 *
 */
public class BlockFamilyRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "blockFamilies";

	private static final String TAG_BLOCK_FAMILY = "blockFamily";
	private static final String ATT_BLOCK_TYPE_FACTORY = "blockTypeFactory";
	
	private BlockFamilyRegistry registry;
	
	public void registerBlockFamilies(BlockFamilyRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DMLPlugin.PLUGIN_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DMLPlugin.getPlugin().getLog();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_BLOCK_FAMILY)) {
			return false;
		}

		String id = getRequiredAttribute(element, IRegistryConstants.ATT_ID);
		String name = getRequiredAttribute(element, IRegistryConstants.ATT_NAME);
		String blockTypeFactory = getRequiredAttribute(element, ATT_BLOCK_TYPE_FACTORY);

		BlockFamilyDescriptor blockFamily = new BlockFamilyDescriptor();
		blockFamily.setId(id);
		blockFamily.setName(name);
		if (blockTypeFactory != null && blockTypeFactory.trim().length() > 0) {
			blockFamily.setBlockTypeFactoryProvider(getExecutableExtensionProviderFor(element, ATT_BLOCK_TYPE_FACTORY, IBlockTypeFactory.class));
		}
		registry.register(blockFamily);

		return true;
	}
	
}

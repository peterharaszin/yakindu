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

package org.eclipse.damos.codegen.c.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.codegen.c.CodegenCPlugin;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class BlockGeneratorRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "blockGenerators";
	
	private static final String TAG = "generator";
	private static final String ATT_BLOCK_TYPE = "blockType";

	private BlockGeneratorProvider provider;
	
	public void registerDescriptors(BlockGeneratorProvider provider) {
		this.provider = provider;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return CodegenCPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return CodegenCPlugin.getDefault().getLog();
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
		
		BlockGeneratorDescriptor descriptor = new BlockGeneratorDescriptor();
		descriptor.setBlockTypeQualifiedName(blockTypeQualifiedName);
		descriptor.setClassName(className);
		descriptor.setConfigurationElement(element);
		provider.register(descriptor);

		return true;
	}

}

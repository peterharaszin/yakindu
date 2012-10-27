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

package org.eclipse.damos.dml.ui.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.dml.ui.DMLUIPlugin;
import org.eclipse.damos.dml.ui.registry.BlockImageRegistry;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BlockImageRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "blockImages";
	
	private static final String TAG = "image";
	private static final String ATT_BLOCK_TYPE = "blockType";
	private static final String ATT_ICON16 = "icon16";
	private static final String ATT_ICON24 = "icon24";

	private BlockImageRegistry registry;
	
	public void registerBlockImages(BlockImageRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DMLUIPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DMLUIPlugin.getPlugin().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG)) {
			return false;
		}

		String blockType = getRequiredAttribute(element, ATT_BLOCK_TYPE);		
		String image16Path = getRequiredAttribute(element, ATT_ICON16);
		String image24Path = getRequiredAttribute(element, ATT_ICON24);

		if (blockType == null || image16Path == null || image24Path == null) {
			return false;
		}

		BlockImageDescriptor blockImage = new BlockImageDescriptor();
		blockImage.setBlockTypeQualifiedName(blockType);

		ImageDescriptor icon16 = DMLUIPlugin.Implementation.imageDescriptorFromPlugin(element.getNamespaceIdentifier(), image16Path);
		if (icon16 == null) {
			return false;
		}
		blockImage.setIcon16ImageDescriptor(icon16);

		ImageDescriptor icon24 = DMLUIPlugin.Implementation.imageDescriptorFromPlugin(element.getNamespaceIdentifier(), image24Path);
		if (icon24 == null) {
			return false;
		}
		blockImage.setIcon24ImageDescriptor(icon24);

		registry.register(blockImage);

		return true;
	}

}

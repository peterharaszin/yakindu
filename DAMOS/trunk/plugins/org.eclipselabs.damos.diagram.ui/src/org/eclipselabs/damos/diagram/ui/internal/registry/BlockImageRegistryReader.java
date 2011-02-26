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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;

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

	private BlockImageRegistry provider;
	
	public void registerDescriptors(BlockImageRegistry provider) {
		this.provider = provider;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DiagramUIPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DiagramUIPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG)) {
			return false;
		}

		String blockTypeQualifiedName = getRequiredAttribute(element, ATT_BLOCK_TYPE);		
		String image16Path = getRequiredAttribute(element, ATT_ICON16);
		String image24Path = getRequiredAttribute(element, ATT_ICON24);

		if (blockTypeQualifiedName == null || image16Path == null || image24Path == null) {
			return false;
		}

		BlockImageDescriptor descriptor = new BlockImageDescriptor();
		descriptor.setBlockTypeQualifiedName(blockTypeQualifiedName);

		ImageDescriptor icon16 = DiagramUIPlugin.imageDescriptorFromPlugin(element.getNamespaceIdentifier(), image16Path);
		if (icon16 == null) {
			return false;
		}
		descriptor.setIcon16ImageDescriptor(icon16);

		ImageDescriptor icon24 = DiagramUIPlugin.imageDescriptorFromPlugin(element.getNamespaceIdentifier(), image24Path);
		if (icon24 == null) {
			return false;
		}
		descriptor.setIcon24ImageDescriptor(icon24);

		provider.register(descriptor);

		return true;
	}

}

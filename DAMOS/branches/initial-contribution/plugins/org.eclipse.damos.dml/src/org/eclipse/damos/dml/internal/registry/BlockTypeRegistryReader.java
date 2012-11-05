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

package org.eclipse.damos.dml.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.common.registry.IRegistryConstants;
import org.eclipse.damos.dml.DMLPlugin;
import org.eclipse.damos.dml.registry.BlockTypeRegistry;
import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 */
public class BlockTypeRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "blockTypes";

	private static final String TAG_BLOCK_TYPE = "blockType";
	private static final String ATT_QUALIFIED_NAME = "qualifiedName";
	private static final String ATT_URI = "uri";
	private static final String ATT_GROUP = "group";
	
	private BlockTypeRegistry registry;
	
	public void registerBlockTypes(BlockTypeRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DMLPlugin.PLUGIN_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DMLPlugin.getPlugin().getLog();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_BLOCK_TYPE)) {
			return false;
		}

		String qualifiedName = getRequiredAttribute(element, ATT_QUALIFIED_NAME);
		String name = getRequiredAttribute(element, IRegistryConstants.ATT_NAME);
		String uriString = getRequiredAttribute(element, ATT_URI);
		String groupString = getRequiredAttribute(element, ATT_GROUP);

		URI uri;
		try {
			uri = URI.createURI(uriString);
		} catch (IllegalArgumentException e) {
			logError(element, "Invalid URI '" + uriString + "'");
			return true;
		}

		BlockGroupDescriptor group = (BlockGroupDescriptor) registry.getBlockGroup(groupString);
		if (group == null) {
			logError(element, "Block group '" + groupString + "' not found");
			return true;
		}

		BlockTypeDescriptor blockType = new BlockTypeDescriptor();
		blockType.setQualifiedName(qualifiedName);
		blockType.setName(name);
		blockType.setURI(uri);
		blockType.setGroup(group);
		registry.register(blockType);

		return true;
	}
	
}

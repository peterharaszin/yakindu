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
import org.eclipse.damos.dml.registry.LanguageRegistry;

/**
 * @author Andreas Unger
 *
 */
public class LanguageRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "languages";

	private static final String TAG_LANGUAGE = "language";
	private static final String ATT_EXTENSION = "extension";
	
	private LanguageRegistry registry;
	
	public void registerBlockFamilies(LanguageRegistry registry) {
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
        if (!element.getName().equals(TAG_LANGUAGE)) {
			return false;
		}

		String id = getRequiredAttribute(element, IRegistryConstants.ATT_ID);
		String name = getRequiredAttribute(element, IRegistryConstants.ATT_NAME);
		String extension = getRequiredAttribute(element, ATT_EXTENSION);

		LanguageDescriptor language = new LanguageDescriptor();
		language.setId(id);
		language.setName(name);
		language.setExtension(extension);
		registry.register(language);

		return true;
	}
	
}

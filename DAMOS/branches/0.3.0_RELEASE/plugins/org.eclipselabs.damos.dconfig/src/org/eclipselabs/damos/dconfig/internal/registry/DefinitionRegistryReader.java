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

package org.eclipselabs.damos.dconfig.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.dconfig.internal.DconfigPlugin;

class DefinitionRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "definitions";

	private static final String TAG_RESOURCE = "resource";
	
	private DefinitionRegistry registry;
	
	public void registerProviders(DefinitionRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.registry.InjectorProviderRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DconfigPlugin.PLUGIN_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.registry.InjectorProviderRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DconfigPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_RESOURCE)) {
			return false;
		}

		registry.registerDefinitionResourceURI(URI.createURI(getRequiredAttribute(element, "uri")));

		return true;
	}
	
}
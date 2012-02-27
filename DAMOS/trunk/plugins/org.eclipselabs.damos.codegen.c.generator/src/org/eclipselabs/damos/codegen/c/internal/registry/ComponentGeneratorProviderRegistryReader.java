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

package org.eclipselabs.damos.codegen.c.internal.registry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipselabs.damos.codegen.c.CodegenCGeneratorPlugin;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorProvider;
import org.eclipselabs.damos.common.registry.AbstractRegistryReader;
import org.eclipselabs.damos.common.registry.IRegistryConstants;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorProviderRegistryReader extends AbstractRegistryReader {

	private static final String EXTENSION_POINT_NAME = "componentGeneratorProviders";

	private static final String TAG_PROVIDER = "provider";

	private ComponentGeneratorProviderRegistry registry;
	
	public void registerProviders(ComponentGeneratorProviderRegistry registry) {
		this.registry = registry;
		readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return CodegenCGeneratorPlugin.PLUGIN_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#getLog()
	 */
	@Override
	protected ILog getLog() {
		return CodegenCGeneratorPlugin.getDefault().getLog();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
	 */
	@Override
	protected boolean readElement(IConfigurationElement element) {
        if (!element.getName().equals(TAG_PROVIDER)) {
			return false;
		}

        IComponentGeneratorProvider provider = createExecutableExtension(element, IRegistryConstants.ATT_CLASS, IComponentGeneratorProvider.class);
        if (provider != null) {
        	registry.register(provider);
        }
        
        return true;
	}

}

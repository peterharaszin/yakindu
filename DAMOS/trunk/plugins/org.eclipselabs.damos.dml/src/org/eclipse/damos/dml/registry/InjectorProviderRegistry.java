/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.registry;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.damos.common.registry.AbstractRegistryReader;
import org.eclipse.damos.common.registry.IExecutableExtensionProxy;
import org.eclipse.damos.dml.DMLPlugin;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public class InjectorProviderRegistry {

	private static final InjectorProviderRegistry INSTANCE = new InjectorProviderRegistry();

	private Map<String, IExecutableExtensionProxy<IInjectorProvider>> providers = new HashMap<String, IExecutableExtensionProxy<IInjectorProvider>>();
	
	/**
	 * 
	 */
	protected InjectorProviderRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static InjectorProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	public Injector getInjector(EObject eObject) {
		return getInjector(eObject, null);
	}
	
	public Injector getInjector(EObject eObject, EClass context) {
		ILanguageDescriptor language = DMLUtil.getLanguage(eObject);
		if (language != null) {
			IExecutableExtensionProxy<IInjectorProvider> provider = providers.get(language.getId());
			if (provider != null) {
				return provider.get().getInjector(context);
			}
		}
		return null;
	}

	public IInjectorProvider getProvider(String languageId) {
		IExecutableExtensionProxy<IInjectorProvider> provider = providers.get(languageId);
		return provider != null ? provider.get() : null;
	}
	
	public void register(String languageId, IExecutableExtensionProxy<IInjectorProvider> provider) {
		providers.put(languageId, provider);
	}
	
	public void unregister(String languageId) {
		providers.remove(languageId);
	}

	private void initializeFromStorage() {
		InjectorProviderRegistryReader reader = new InjectorProviderRegistryReader();
		reader.registerInjectorProviders(this);
	}

	protected String getPluginId() {
		return DMLPlugin.PLUGIN_ID;
	}
	
	protected ILog getLog() {
		return DMLPlugin.getPlugin().getLog();
	}

	private class InjectorProviderRegistryReader extends AbstractRegistryReader {

		private static final String EXTENSION_POINT_NAME = "injectorProviders";

		private static final String TAG_FACTORY = "provider";
		private static final String ATT_LANGUAGE = "language";
		private static final String ATT_CLASS = "class";
		
		private InjectorProviderRegistry registry;
		
		public void registerInjectorProviders(InjectorProviderRegistry registry) {
			this.registry = registry;
			readRegistry(Platform.getExtensionRegistry(), EXTENSION_POINT_NAME);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.damos.dml.internal.registry.InjectorProviderRegistryReader#getPluginId()
		 */
		@Override
		protected String getPluginId() {
			return InjectorProviderRegistry.this.getPluginId();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.dml.internal.registry.InjectorProviderRegistryReader#getLog()
		 */
		@Override
		protected ILog getLog() {
			return InjectorProviderRegistry.this.getLog();
		}

		/* (non-Javadoc)
		 * @see org.eclipse.damos.common.registry.AbstractRegistryReader#readElement(org.eclipse.core.runtime.IConfigurationElement)
		 */
		@Override
		protected boolean readElement(IConfigurationElement element) {
	        if (!element.getName().equals(TAG_FACTORY)) {
				return false;
			}

			String languageId = getRequiredAttribute(element, ATT_LANGUAGE);
			registry.register(languageId, getExecutableExtensionFor(element, ATT_CLASS, IInjectorProvider.class));

			return true;
		}
		
	}

}

/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.codegen.c.internal.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.esmp.dsm.codegen.c.DSMCodegenCPlugin;
import org.esmp.dsm.codegen.c.BlockCGenerator;
import org.esmp.dsm.codegen.c.services.BlockCGeneratorProvider;

/**
 * @author Andreas Unger
 *
 */
public class BlockCGeneratorService {
	
	private static final String EXTENSION_POINT_NAME = "generatorProviders";
	private static final String GENERATOR_PROVIDER_ELEMENT = "generatorProvider";
	private static final String CLASS_NAME_ATTRIBUTE = "class";

	private static BlockCGeneratorService instance;
	private List<BlockCGeneratorProvider> providers;
	
	/**
	 * 
	 */
	private BlockCGeneratorService() {
	}
	
	/**
	 * @return the instance
	 */
	public static BlockCGeneratorService getInstance() {
		if (instance == null) {
			instance = new BlockCGeneratorService();
		}
		return instance;
	}
	
	public BlockCGenerator createCCodeGenerator(URI blockTypeURI) {
		if (providers == null) {
			loadProviders();
		}
		for (BlockCGeneratorProvider p : providers) {
			BlockCGenerator generator = p.createGenerator(blockTypeURI, null);
			if (generator != null) {
				return generator;
			}
		}
		return null;
	}
	
	private void loadProviders() {
		providers = new ArrayList<BlockCGeneratorProvider>();

		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				DSMCodegenCPlugin.PLUGIN_ID, EXTENSION_POINT_NAME);

		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				if (GENERATOR_PROVIDER_ELEMENT.equals(configurationElement.getName())) {
					try {
						String className = getRequiredAttribute(configurationElement, CLASS_NAME_ATTRIBUTE);
						String nsid = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
						Class<?> clazz = Platform.getBundle(nsid).loadClass(className);
						BlockCGeneratorProvider provider = (BlockCGeneratorProvider) clazz.newInstance();
						providers.add(provider);
					} catch (Exception e) {
						DSMCodegenCPlugin.getDefault().getLog().log(
								new Status(IStatus.ERROR, DSMCodegenCPlugin.PLUGIN_ID,
										"Failed to load block state provider in plug-in '"
										+ extension.getContributor().getName()
										+ "' in extension of '"
										+ extensionPoint.getUniqueIdentifier()
										+ "'", e));
					}
				}
			}
		}

	}
	
	private String getRequiredAttribute(IConfigurationElement configurationElement, String name) {
		String value = configurationElement.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException("Missing '" + name + "' attribute");
		}
		return value;
	}
	
}

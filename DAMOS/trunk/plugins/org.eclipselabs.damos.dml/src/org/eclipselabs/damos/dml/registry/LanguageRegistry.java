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

package org.eclipselabs.damos.dml.registry;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.internal.registry.LanguageRegistryReader;

/**
 * @author Andreas Unger
 *
 */
public class LanguageRegistry {

	private static final LanguageRegistry INSTANCE = new LanguageRegistry();

	private Map<String, ILanguageDescriptor> languages = new HashMap<String, ILanguageDescriptor>();
	private Map<String, ILanguageDescriptor> extensionToLanguageMap = new HashMap<String, ILanguageDescriptor>();
	
	/**
	 * 
	 */
	private LanguageRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static LanguageRegistry getInstance() {
		return INSTANCE;
	}
		
	public Collection<ILanguageDescriptor> getLanguages() {
		return Collections.unmodifiableCollection(languages.values());
	}

	public ILanguageDescriptor getLanguage(String id) {
		return languages.get(id);
	}
	
	public ILanguageDescriptor getLanguageByExtension(String extension) {
		return extensionToLanguageMap.get(extension);
	}

	public void register(ILanguageDescriptor language) {
		languages.put(language.getId(), language);
		extensionToLanguageMap.put(language.getExtension(), language);
	}
	
	private void initializeFromStorage() {
		LanguageRegistryReader reader = new LanguageRegistryReader();
		reader.registerBlockFamilies(this);
	}

}

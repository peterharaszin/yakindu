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

package org.eclipse.damos.dconfig.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 */
public class DefinitionRegistry {

	private static final DefinitionRegistry INSTANCE = new DefinitionRegistry();

	private List<URI> definitionResourceURIs = new ArrayList<URI>();
	
	/**
	 * 
	 */
	protected DefinitionRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static DefinitionRegistry getInstance() {
		return INSTANCE;
	}
	
	/**
	 * @return the providers
	 */
	public Collection<URI> getDefinitionResourceURIs() {
		return definitionResourceURIs;
	}
	
	public void registerDefinitionResourceURI(URI uri) {
		definitionResourceURIs.add(uri);
	}
	
	public void unregisterDefinitionResourceURI(URI uri) {
		definitionResourceURIs.remove(uri);
	}

	private void initializeFromStorage() {
		DefinitionRegistryReader reader = new DefinitionRegistryReader();
		reader.registerProviders(this);
	}

}

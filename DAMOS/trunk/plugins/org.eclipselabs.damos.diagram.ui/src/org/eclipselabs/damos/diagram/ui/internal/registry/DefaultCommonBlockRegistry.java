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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Andreas Unger
 *
 */
public class DefaultCommonBlockRegistry {

	private static final DefaultCommonBlockRegistry INSTANCE = new DefaultCommonBlockRegistry();

	private Collection<String> blockTypes = new ArrayList<String>();
	
	/**
	 * 
	 */
	private DefaultCommonBlockRegistry() {
		initializeFromStorage();
	}
	
	/**
	 * @return the instance
	 */
	public static DefaultCommonBlockRegistry getInstance() {
		return INSTANCE;
	}

	/**
	 * @return the descriptors
	 */
	public Collection<String> getBlockTypes() {
		return Collections.unmodifiableCollection(blockTypes);
	}
	
	public void register(String blockType) {
		blockTypes.add(blockType);
	}
	
	public void unregister(String blockType) {
		blockTypes.remove(blockType);
	}

	private void initializeFromStorage() {
		DefaultCommonBlockRegistryReader reader = new DefaultCommonBlockRegistryReader();
		reader.registerBlockTypes(this);
	}

}

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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.codegen.c.rte.IRuntimeEnvironmentAPI;

/**
 * @author Andreas Unger
 *
 */
public class RuntimeEnvironmentAPIRegistry {

	private static final RuntimeEnvironmentAPIRegistry INSTANCE = new RuntimeEnvironmentAPIRegistry();

	private Map<String, IRuntimeEnvironmentAPI> runtimeEnvironmentAPIs = new HashMap<String, IRuntimeEnvironmentAPI>();
	
	/**
	 * 
	 */
	private RuntimeEnvironmentAPIRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static RuntimeEnvironmentAPIRegistry getInstance() {
		return INSTANCE;
	}

	public IRuntimeEnvironmentAPI getRuntimeEnvironmentAPI(String runtimeEnvironmentId) {
		return runtimeEnvironmentAPIs.get(runtimeEnvironmentId);
	}

	public void register(String runtimeEnvironmentId, IRuntimeEnvironmentAPI runtimeEnvironmentAPI) {
		runtimeEnvironmentAPIs.put(runtimeEnvironmentId, runtimeEnvironmentAPI);
	}
	
	public void unregister(String runtimeEnvironmentId) {
		runtimeEnvironmentAPIs.remove(runtimeEnvironmentId);
	}

	private void initializeFromStorage() {
		RuntimeEnvironmentAPIRegistryReader reader = new RuntimeEnvironmentAPIRegistryReader();
		reader.registerProviders(this);
	}
	
}

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

package org.eclipse.damos.mscript.codegen.c;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public class CModuleSet {

	private Map<String, CModule> modules = new HashMap<String, CModule>();
	private boolean resolved;

	/**
	 * @return the modules
	 */
	public Collection<CModule> getModules() {
		resolveEntries();
		return modules.values();
	}
	
	public CModule getModule(String name) {
		resolveEntries();
		return modules.get(name);
	}
	
	public CModule createModule(String name) {
		CModule module = new CModule(this, name);
		modules.put(name, module);
		resolved = false;
		return module;
	}
	
	private void resolveEntries() {
		if (!resolved) {
			for (CModule module : modules.values()) {
				module.resolveEntries();
			}
			resolved = true;
		}
	}
	
}

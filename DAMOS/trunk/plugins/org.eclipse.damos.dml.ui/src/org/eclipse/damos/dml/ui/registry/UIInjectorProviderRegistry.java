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

package org.eclipse.damos.dml.ui.registry;

import org.eclipse.core.runtime.ILog;
import org.eclipse.damos.dml.registry.InjectorProviderRegistry;
import org.eclipse.damos.dml.ui.DMLUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class UIInjectorProviderRegistry extends InjectorProviderRegistry {

	private static final UIInjectorProviderRegistry INSTANCE = new UIInjectorProviderRegistry();
	
	/**
	 * @return the instance
	 */
	public static UIInjectorProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.registry.InjectorProviderRegistry#getPluginId()
	 */
	@Override
	protected String getPluginId() {
		return DMLUIPlugin.PLUGIN_ID;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.registry.InjectorProviderRegistry#getLog()
	 */
	@Override
	protected ILog getLog() {
		return DMLUIPlugin.getPlugin().getLog();
	}
	
}

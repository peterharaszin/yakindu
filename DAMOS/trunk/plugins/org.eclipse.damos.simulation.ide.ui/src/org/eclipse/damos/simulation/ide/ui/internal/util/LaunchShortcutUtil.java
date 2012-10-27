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

package org.eclipse.damos.simulation.ide.ui.internal.util;

import java.util.Collection;

import org.eclipse.debug.core.ILaunchConfiguration;

/**
 * @author Andreas Unger
 *
 */
public class LaunchShortcutUtil {

	public static ILaunchConfiguration[] toArray(Collection<ILaunchConfiguration> launchConfigurations) {
		return launchConfigurations.isEmpty() ? null : launchConfigurations.toArray(new ILaunchConfiguration[launchConfigurations.size()]);
	}
	
}

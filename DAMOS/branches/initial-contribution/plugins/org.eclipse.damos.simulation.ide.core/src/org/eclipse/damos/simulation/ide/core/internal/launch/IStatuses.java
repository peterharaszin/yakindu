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

package org.eclipse.damos.simulation.ide.core.internal.launch;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.simulation.ide.core.SimulationIDECorePlugin;

/**
 * @author Andreas Unger
 *
 */
public interface IStatuses {

	IStatus GENERIC_STATUS = new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, 200, "", null);
	IStatus OVERFLOW_STATUS = new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, 201, "", null);
	
}

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

package org.eclipse.damos.library.vi.simulation;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.library.vi.util.UDPSourceConstants;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
class UDPSimulationObject extends AbstractBlockSimulationObject {

	protected int getNetworkPort() throws CoreException {
		int port;

		String portString = getComponent().getArgumentStringValue(UDPSourceConstants.PARAMETER__PORT);
		if (portString != null && portString.trim().length() > 0) {
			try {
				port = Integer.parseInt(portString);
				if (port < 0 || port > 0xffff) {
					throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "Port number must be between 0 and 65535"));
				}
			} catch (NumberFormatException e) {
				throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "Invalid port number specified"));
			}
		} else {
			throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "No port number specified"));
		}
		
		return port;
	}

}

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

package org.eclipselabs.damos.library.vi.signatures.communication;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.execution.AbstractComponentSignaturePolicy;
import org.eclipselabs.damos.library.vi.LibraryVIPlugin;
import org.eclipselabs.damos.library.vi.util.communication.UDPSourceConstants;

/**
 * @author Andreas Unger
 *
 */
abstract class UDPSignaturePolicy extends AbstractComponentSignaturePolicy {
	
	/**
	 * @param block
	 * @return
	 */
	protected void checkNetworkPortParameter(Block block, MultiStatus multiStatus) {
		String portString = block.getArgumentStringValue(UDPSourceConstants.PARAMETER__PORT);
		if (portString != null && portString.trim().length() > 0) {
			try {
				int port = Integer.parseInt(portString);
				if (port < 0 || port > 0xffff) {
					multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Port number must be between 0 and 65535"));
				}
			} catch (NumberFormatException e) {
				multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "Invalid port number specified"));
			}
		} else {
			multiStatus.add(new Status(IStatus.ERROR, LibraryVIPlugin.PLUGIN_ID, "No port number specified"));
		}
	}

}

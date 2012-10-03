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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.library.vi.util.UDPSourceConstants;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class UDPSinkSimulationObject extends UDPSimulationObject {

	private volatile int portCount;

	private IValue[] inputValues;

	private InetSocketAddress socketAddress;
	private DatagramSocket socket;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		portCount = getComponent().getPrimaryInputPorts().size();
		
		inputValues = new IValue[portCount];
		
		String host = getComponent().getArgumentStringValue(UDPSourceConstants.PARAMETER__HOST);
		if (host == null || host.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "No host specified"));
		}
		int port = getNetworkPort();

		try {
			socket = new DatagramSocket();
			socketAddress = new InetSocketAddress(host, port);
			if (socketAddress.isUnresolved()) {
				throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "Specified host could not be resolved"));
			}
		} catch (SocketException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "Socket error occurred", e));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipse.damos.mscript.computation.core.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		inputValues[portIndex] = value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#update(double)
	 */
	@Override
	public void update(double t) {
		StringBuilder sb = new StringBuilder();
		for (IValue value : inputValues) {
			if (value instanceof ISimpleNumericValue) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				sb.append(((ISimpleNumericValue) value).doubleValue());
			}
		}
		
		byte[] buffer = sb.toString().getBytes();
		try {
			DatagramPacket p = new DatagramPacket(buffer, buffer.length, socketAddress);
			socket.send(p);
		} catch (IOException e) {
			LibraryVISimulationPlugin.getDefault().getLog()
					.log(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "IO error occurred", e));
		}
	}
	
}

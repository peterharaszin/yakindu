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
import java.net.SocketTimeoutException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.library.vi.util.UDPSourceConstants;
import org.eclipse.damos.mscript.NumericType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.simulation.ISimulationMonitor;
import org.eclipse.damos.simulation.simulator.ISimulationClock;

/**
 * @author Andreas Unger
 *
 */
public class UDPSourceSimulationObject extends UDPSimulationObject {

	/**
	 * 
	 */
	private static final int BLOCKING_QUEUE_CAPACITY = 1000;

	/**
	 * 
	 */
	private static final int TIME_OUT = 1000;
	
	private static final Pattern COMMA_PATTERN = Pattern.compile(",");

	private volatile int portCount;

	private IValue[] outputValues;

	private Type[] outputDataTypes;
	
	private DatagramSocket socket;
	
	private BlockingQueue<double[]> queue = new ArrayBlockingQueue<double[]>(BLOCKING_QUEUE_CAPACITY);
	
	private UDPThread udpThread;
	
	private long nanoSampleTime;
	
	private volatile boolean disposed;

	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		portCount = getComponent().getPrimaryOutputPorts().size();
		
		{
			int i = 0;
			outputDataTypes = new Type[portCount];
			for (OutputPort outputPort: getComponent().getPrimaryOutputPorts()) {
				outputDataTypes[i++] = getComponentSignature().getOutputDataType(outputPort);
			}
		}
		
		outputValues = new IValue[portCount];
		for (int i = 0; i < outputValues.length; ++i) {
			outputValues[i] = Values.valueOf(getComputationContext(), (NumericType) outputDataTypes[i], 0);
		}
		
		int port = getNetworkPort();
		try {
			String host = getComponent().getArgumentStringValue(UDPSourceConstants.PARAMETER__HOST);
			if (host != null && host.trim().length() > 0) {
				InetSocketAddress socketAddress = new InetSocketAddress(host, port);
				if (socketAddress.isUnresolved()) {
					throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "Specified host could not be resolved"));
				}
				socket = new DatagramSocket(socketAddress);
			} else {
				socket = new DatagramSocket(port);
			}
			socket.setSoTimeout(TIME_OUT);
		} catch (SocketException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "Socket error occurred", e));
		}
		
		nanoSampleTime = Math.round(getNode().getSampleInterval().sampleTime() * 1e9);
		
		udpThread = new UDPThread();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#getClock()
	 */
	@Override
	public ISimulationClock getClock() {
		return udpThread;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues(double)
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		double[] values = null;
		try {
			do {
				if (monitor.isCanceled()) {
					return;
				}
				values = queue.poll(TIME_OUT, TimeUnit.MILLISECONDS);
			} while (values == null);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
		
		for (int i = 0; i < portCount; ++i) {
			outputValues[i] = Values.valueOf(getComputationContext(), (NumericType) outputDataTypes[i], values[i]);
		}
	}

	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValues[portIndex];
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#dispose()
	 */
	@Override
	public void dispose() {
		disposed = true;
	}
	
	private class UDPThread extends Thread implements ISimulationClock {
		
		private volatile long nanoTimeOffset;
		private volatile long packetCount;
		private double[] values;
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.simulation.simulator.ISimulationClock#getNanoTime()
		 */
		public long getNanoTime() {
			synchronized (this) {
				long d = System.nanoTime() - nanoTimeOffset;
				if (d > nanoSampleTime) {
					d = nanoSampleTime;
				}
				return packetCount * nanoSampleTime + d;
			}
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#start()
		 */
		public void start(ISimulationMonitor monitor) throws CoreException {
			nanoTimeOffset = 0;
			packetCount = 0;
			values = new double[portCount];
			disposed = false;

			boolean received;
			do {
				try {
					if (monitor.isCanceled()) {
						socket.close();
						return;
					}
					received = receive();
				} catch (IOException e) {
					socket.close();
					throw new CoreException(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "IO error occurred", e));
				}
			} while (!received);
			
			start();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				for (;;) {
					boolean received;
					do {
						if (disposed) {
							return;
						}
						received = receive();
					} while (!received);
					
					synchronized (this) {
						nanoTimeOffset = System.nanoTime();
						++packetCount;
					}
				}
			} catch (IOException e) {
				LibraryVISimulationPlugin.getDefault().getLog()
						.log(new Status(IStatus.ERROR, LibraryVISimulationPlugin.PLUGIN_ID, "IO error occurred", e));
			} finally {
				socket.close();
			}
		}

		/**
		 * @return
		 */
		private boolean receive() throws IOException {
			byte[] buffer = new byte[64];
			DatagramPacket p = new DatagramPacket(buffer, buffer.length);
			try {
				socket.receive(p);
				String[] valuesStrings = COMMA_PATTERN.split(new String(p.getData(), 0, p.getLength()));
				int length = Math.min(values.length, valuesStrings.length);
				for (int i = 0; i < length; ++i) {
					try {
						values[i] = Double.parseDouble(valuesStrings[i]);
					} catch (NumberFormatException e) {
						// ignore invalid numbers, fall back to previous value
					}
				}
				double[] newValues = new double[portCount];
				System.arraycopy(values, 0, newValues, 0, portCount);
				queue.offer(newValues);
			} catch (SocketTimeoutException e) {
				return false;
			}
			return true;
		}
		
	}
	
}

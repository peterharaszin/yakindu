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

package org.eclipse.damos.library.vi.simulation;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * @author Andreas Unger
 *
 */
class UDPSourceTest {

	private static final int FS = 100;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DatagramSocket socket = new DatagramSocket();
			long nextTime = 0;
			long timeOffset = System.nanoTime();
			InetSocketAddress address = new InetSocketAddress("localhost", 39999);
			
			for (;;) {
				String s = String.format("%d,%f", nextTime, nextTime / 3.0);
				byte[] buffer = s.getBytes();
				socket.send(new DatagramPacket(buffer, buffer.length, address));
	
				long nextTimeNanos = nextTime * 1000000000L / FS;
				long currentTime = System.nanoTime() - timeOffset;
				if (nextTimeNanos > currentTime) {
					try {
						long d = nextTimeNanos - currentTime;
						Thread.sleep(d / 1000000, (int) (d % 1000000));
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
				
				++nextTime;
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

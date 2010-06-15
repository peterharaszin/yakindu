/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.simulation.core.event;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>EventDispatcher</code> provides methods to send events to 
 * registered listeners.
 */
public class EventDispatcher {
	
	/** Defines the list of all current registered listeners. */
	private List <IEventListener> listeners = null;
	/** Indicates if the the method <code>fireEvent</code> is running. */
	private boolean isBlocked;
	
	/**
	 * Creates an instance of the <code>EventDispatcher</code>.
	 */
	public EventDispatcher(){
		listeners = new ArrayList<IEventListener>();
		isBlocked=false;
	}
	
	/**
	 * Registers the <code>IEventListener</code> as an observer.
	 *  
	 * @param listener	defines the new observer
	 */
	public synchronized void addEventListener(IEventListener listener){
		while (isBlocked) {
			Thread.yield();
		}
		if (!listeners.contains(listener))
			listeners.add(listener);
	}
	
	/**
	 * Removes the registered <code>IEventListener</code>. The listener
	 * The observer gets no more events.
	 * 
	 * @param listener	defines the listener which shall be removed
	 */
	public synchronized void removeEventListener(IEventListener listener){
		while (isBlocked) {
			Thread.yield();
		}
		listeners.remove(listener);
	}
	
	/**
	 * This method allows to send the given <code>IEvent</code> to all registered
	 * listeners.
	 * 
	 * @param event		defines the <code></code> which shall be sent
	 */
	public synchronized void fireEvent(final IEvent event){
		isBlocked=true;
		for (int i=0;i<listeners.size();i++){
			listeners.get(i).receiveEvent(event);
			/*final int index = i;
			new Thread(){
				public void run(){
					synchronized (listeners.get(index)) {
						listeners.get(index).receiveEvent(event);
					}
				}
			}.start();*/
		}
		isBlocked=false;
	}
}

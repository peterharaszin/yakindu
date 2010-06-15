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

/**
 * The interface <code>IEventListener</code> must be implemented by listeners
 * which will act as observer of <code>EventDispatcher</code> instances.
 */
public interface IEventListener {

	/**
	 * Defines the method which will be called by the subject class, if an event
	 * is occurred.
	 * 
	 * @param event defines the occurred <code>IEvent</code> instance.
	 */
	public void receiveEvent(IEvent event);
}

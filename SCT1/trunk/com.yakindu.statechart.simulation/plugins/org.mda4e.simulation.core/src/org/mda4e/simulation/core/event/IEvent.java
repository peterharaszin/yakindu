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
 * <code>IEvent</code> defines the structure of an valid event which can be used
 * for the class <code>IEventDispatcher</code>.
 *
 * @see EventDispatcher
 * @see IEventListener
 * @see SimulationEvent
 */
public interface IEvent {
	
	/**
	 * This method returns the object to which the event refers.
	 * For example, if a variable was changed, the variable is 
	 * the source object.
	 * 
	 * @return	The object why the <code>IEvent</code> was triggered.
	 */
	public Object getSource();
}

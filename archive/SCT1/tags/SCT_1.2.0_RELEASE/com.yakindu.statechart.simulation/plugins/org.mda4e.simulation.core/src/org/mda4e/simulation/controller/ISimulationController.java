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
package org.mda4e.simulation.controller;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.mda4e.simulation.controller.event.ControllerEvent;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEventListener;

/**
 * The interface <code>ISimulationController</code> is implemented by classes which
 * acts as a (passive) controller of simulation engines (<code>ISimulationEngine</code>).
 * The characteristics of a controller are that it is able to react to events, to control
 * the simulation engine and to read simulation specific informations. An example for
 * a passive controller is a visualization tool that displays the simulation state.
 * Another example is a plug-in which acts as simulation controller to start and stop
 * the simulation.
 * 
 * <p>
 * <b>Note:</b> The implementation of the interface {@link EventDispatcher} allows a
 * controller to signals the execution unit that an error was occurred. For more
 * informations see: {@link ControllerEvent}. 
 * </p>
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 */
public interface ISimulationController extends IEventListener {
	
	/** The definition of the extension point. */
	public static final String CONTROLLER_EXTENSION_POINT = "org.mda4e.simulation.controller";

	/**
	 * This method is called to retrieve the control group of the specific controller,
	 * if the controller needs controls.
	 * 
	 * @param parent 	defines the container of the control group
	 * 
	 * @return 	The result is a control <code>Group</code> with all controller specific controls.
	 * 			If the controller doesn't need controls the result is <code>null</code>.
	 */
	public Group createControlGroup(Composite parent);

	/**
	 * Allows to add an event listener to receive all events which
	 * are sent by the simulation engine.
	 * 
	 * @param listener	defines the new listener of the simulation engine
	 */
	public void addEventListener(IEventListener listener);
	
	/**
	 * Removes the given <code>listener</code> from the listener list, so
	 * this listener gets no longer events of the simulation engine.
	 * 
	 * @param listener	defines the listener which shall be removed
	 */
	public void removeEventListener(IEventListener listener);
	
	/**
	 * Provides the name of this simulation engine controller.
	 * 
	 * @return The name of this controller.
	 */
	public String getControllerName();
}

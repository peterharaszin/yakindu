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
package org.mda4e.simulation.controller.event;

import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;

/**
 * The <code>ControllerEvent</code> allows an instance of {@link ISimulationController}
 * to send an event to the executing unit, for example, if an error was occurred. There
 * a two different types available. For more informations about the types see: {@link
 * ControllerEventTypes}.
 *
 * <p>
 * <b>Possible types are:</b>
 * 	<ul>
 * 		<li>{@link ControllerEventTypes#ConWarn ConWarn} indicates a non critical error</li>
 * 		<li>{@link ControllerEventTypes#ConError ConError} indicates that the controller must be disposed</li>
 * 	</ul>
 * </p>
 * 
 * @author Philipp Richter
 */
public class ControllerEvent implements IEvent {

	/**
	 * Defines the possible event types of the 
	 * <code>ControllerEvent</code>.
	 * <p>
	 * 	<ul>
	 * 		<li>{@link #ConWarn} indicates a non critical error</li>
	 * 		<li>{@link #ConError} indicates that the controller must be disposed</li>
	 * 	</ul>
	 * </p>
	 * 
	 * @author Philipp Richter
	 * 
	 * @see ControllerEvent
	 */
	public enum ControllerEventTypes {
		
		/**
		 * Defines that a {@link ISimulationController} has indicated
		 * a problem, but the fault is not critical and furthermore
		 * the controller can carry out its task.
		 */
		ConWarn,
		
		/**
		 * Defines that a {@link ISimulationController} has indicated
		 * a critical problem and it is saver for the simulation to
		 * dispose the controller. So the simulation can be continued
		 * without this controller.
		 */
		ConError
	}
	
	/**
	 * Defines the event type of this event.
	 * 
	 * @see SimulationEventTypes
	 */
	private ControllerEventTypes eventType = null;
	
	/**
	 * Indicates the simulation controller instance why this <code>ControllerEvent</code>
	 * is triggered.
	 * 
	 * @see ISimulationController
	 */
	private ISimulationController simulationController = null;
	
	/**
	 * Defines the exception of the controller which describes the problem why the
	 * problem was occurred.
	 */
	private Exception exception = null;
	
	/**
	 * Instantiates a new <code>ControllerEvent</code> object with the specified
	 * <code>eventType</code> and without an exception declaration.
	 * 
	 * <p>
	 * <b>NOTE:</b> The parameters <b>must not</b> be <code>null</code> and the exception
	 * should include a <b>meaningful</b> message. 
	 * </p>
	 * 
	 * @param eventType		defines the type of this event ({@link ControllerEventTypes})
	 * @param controller	defines the instance to which the event refers
	 * @param exception 	defines the thrown exception or a created exception with
	 * 						meaningful description of the problem 						
	 */
	public ControllerEvent(ControllerEventTypes eventType, ISimulationController controller, Exception exception) {
		
		if(eventType == null) {
			new NullPointerException("The argument \"eventType\" must not be \"null\"!");
		}
		
		if(controller == null) {
			new NullPointerException("The argument \"controller\" must not be \"null\"!");			
		}
		
		if(exception == null) {
			exception = new Exception("An unknown error is occurred! The simulation engine could not specify the reason for the exception occurrence!");
		}
		
		this.eventType = eventType;
		this.simulationController = controller;
		this.exception = exception;
	}

	/**
	 * Returns the specified {@link ControllerEventTypes} which indicates
	 * the kind of this event.
	 * 
	 * @return 	The <code>ControllerEventTypes</code> of this event.
	 */
	public ControllerEventTypes getEventType() {
		return eventType;
	}

	/**
	 * Provides the declared exception which contains the description
	 * of the problem of the {@link ISimulationController}.
	 * 
	 * @return 	The exception the problem description.
	 * 
	 */
	public Exception getException() {
		return exception;
	}
	
	/*
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {
		return simulationController;
	}

}

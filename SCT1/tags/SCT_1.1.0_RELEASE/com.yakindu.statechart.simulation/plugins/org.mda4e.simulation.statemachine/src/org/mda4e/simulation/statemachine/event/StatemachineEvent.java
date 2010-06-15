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
package org.mda4e.simulation.statemachine.event;

import org.mda4e.simulation.core.event.IEvent;

/**
 * The <code>StatemachineEvent</code> is a statemachine specific event. It
 * has informations of the "uuid" and of the underlying statechart and the
 * instance number which indicates the respective engine object. The
 * instance number is only required, if more than one instance of the same
 * statechart in one simulation engine exists.
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 * @author Benjamin Schwertfeger
 */
public class StatemachineEvent implements IEvent {
	
	/**
	 * This enumeration defines the types which can be
	 * used to show that the state of the statemachine
	 * was changed.
	 * 
	 * <p>
	 * <b>Possible Types:</b>
	 * 	<ul>
	 * 		<li>{@link #StateEnabled}</li>
	 * 		<li>{@link #StateDisabled}</li>
	 * 		<li>{@link #TransitionFired}</li>
	 * 		<li>{@link #VariableChanged}</li>
	 * 		<li>{@link #EventChanged}</li>
	 * 	</ul>
	 * </p>
	 * 
	 * @author Markus M�hlbrandt, Philipp Richter
	 * @author Benjamin Schwertfeger
	 */
	public enum StatemachineEventTypes {
		
		/**
		 * Indicates that the state was enabled. The state must be
		 * active before the entry action of the state is
		 * processed.
		 */
		StateEnabled,
		
		/**
		 * Indicates that the state is disabled. The state is no
		 * longer active, if the exit action was processed.
		 */
		StateDisabled,
		
		/**
		 * Specifies the firing of a transition. In the normal
		 * case this event type is sent, after the
		 * {@link #StateDisabled} type was sent.
		 */
		TransitionFired,
		
		/**
		 * Indicates that a variable value was changed. For example,
		 * if the value of a local variable was updated.
		 */
		VariableChanged,
		
		/**
		 * Indicates that an event state was changed. For example,
		 * if an event was fired.
		 */
		EventChanged
	}
	
	/**
	 * Defines the current {@link StatemachineEventTypes}. This
	 * type indicates the action which was executed with respect
	 * to the given object.
	 */
	private StatemachineEventTypes eventType;
	
	/**
	 * Defines the object whose state was changed. For example,
	 * if a variable value was changed, the variable is source
	 * object.
	 */
	private Object source;
	

	/**
	 * Indicates the unique identifier of the statechart which
	 * contains the current source object.
	 */
	protected String uUID = null;
	
	/** 
	 * Indicates the instance number of the statechart. This is
	 * required, if more than one instance of the same statechart
	 * in one simulation engine exists.
	 */
	protected int instance = -1;
	
	/**
	 * Creates an instance of <code>StatemachineEvent</code> with the
	 * given properties.
	 * 
	 * @param eventType		specifies the {@link StatemachineEventTypes}
	 * @param source		defines the object whose state was changed.
	 * 						For example, if a variable value was changed,
	 * 						the variable is source object.	
	 * @param UUID			defines the unique identifier of the statechart,
	 * 						which contains the <code>source</code> object
	 * @param instance		indicates the instance number, if more than one
	 * 						instance of the same statechart in one 
	 * 						simulation engine exists.
	 * 
	 * @throws NullPointerException		will be thrown if one of the parameters is <code>null</code>
	 */
	public StatemachineEvent(StatemachineEventTypes eventType, Object source, String UUID, int instance) {
		
		if(eventType == null) {
			throw new NullPointerException("The argument \"eventType\" must not be \"null\"!");
		}
		
		if(source == null) {
			throw new NullPointerException("The argument \"source\" must not be \"null\"!");
		}
		
		if(UUID == null) {
			throw new NullPointerException("The argument \"UUID\" must not be \"null\"!");
		}
		
		this.eventType = eventType;
		this.source = source;
		this.uUID = UUID;
		this.instance = instance;
	}
	
	/**
	 * Returns the object whose state was changed. For example, if
	 * a variable value was changed, the variable is source object.
	 */
	public Object getSource() {
		return source;
	}
	
	/**
	 * Returns the current event type which indicates the current action
	 * which was executed with respect to the given object.
	 * 
	 * @return 	The type which indicates the current action which was
	 * 			executed by the simulation engine.
	 */
	public StatemachineEventTypes getEventType() {
		return eventType;
	}
	
	/**
	 * This method returns the unique identifier of the statechart which
	 * contains the <code>source</code> object
	 * 
	 * @return The unique identifier of the statechart.
	 */
	public String getUUID() {
		return uUID;
	}
	
	/**
	 * Returns the instance number which indicates the statechart which
	 * contains the <code>source</code> object, if more than one instance
	 * of the same statechart in one simulation engine exists.
	 * 
	 * @return The statechart instance number.
	 */
	public int getInstance() {
		return instance;
	}
}

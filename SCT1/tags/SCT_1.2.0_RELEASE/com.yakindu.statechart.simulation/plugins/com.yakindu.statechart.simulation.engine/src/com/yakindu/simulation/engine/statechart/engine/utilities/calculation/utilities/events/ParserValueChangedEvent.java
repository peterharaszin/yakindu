/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.engine.utilities.calculation.utilities.events;

import org.mda4e.simulation.core.event.IEvent;

/**
 * This event allows to inform listeners about change of a value of a specific item.
 * 
 * @param <VType>	specifies the data type of the item value
 *  
 * @author Philipp Richter
 */
public class ParserValueChangedEvent<VType> implements IEvent {

	/** 
	 * The <code>item</code> defines the name of the changed item.
	 */
	private String item = null;
	/**
	 * The <code>value</code> represents the new value of the
	 * <code>item</code>.
	 */
	private VType value = null;
	
	/**
	 * @param item			defines the item name
	 * @param value			defines the new value of the given item
	 */
	public ParserValueChangedEvent(String item, VType value) {
		this.item  = item;
		this.value = value;
	}
	
	/**
	 * @see org.mda4e.simulation.core.event.IEvent#getSource()
	 */
	public Object getSource() {
		return item;
	}
	
	/**
	 * Returns the generic value of the changed item.
	 * 
	 * @return	The result is the value of the changed item. 
	 */
	public VType getValue() {
		return value;
	}
}

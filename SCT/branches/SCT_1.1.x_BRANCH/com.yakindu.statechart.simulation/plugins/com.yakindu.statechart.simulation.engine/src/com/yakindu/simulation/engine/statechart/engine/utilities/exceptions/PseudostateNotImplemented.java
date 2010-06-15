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
package com.yakindu.simulation.engine.statechart.engine.utilities.exceptions;

import com.yakindu.simulation.engine.statechart.nls.Messages;

/**
 * This exception will be thrown, if during the simulation a pseudo state will
 * be found, which is not implemented.
 * 
 * @author Christopher Brink, Philipp Richter
 */
public class PseudostateNotImplemented extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = 268787367930254939L;

	/**
	 * @param state 	defines the not implemented pseudo state
	 */
	public PseudostateNotImplemented(String state) {
		this(state, null);
	}
	
	/**
	 * @param state 	defines the not implemented pseudo state
	 * @param cause		specifies the prior thrown exception
	 */
	public PseudostateNotImplemented(String state, Exception cause) {
		super(String.format(Messages.PseudostateNotImplemented_errormessage, state), cause);
	}
	
}

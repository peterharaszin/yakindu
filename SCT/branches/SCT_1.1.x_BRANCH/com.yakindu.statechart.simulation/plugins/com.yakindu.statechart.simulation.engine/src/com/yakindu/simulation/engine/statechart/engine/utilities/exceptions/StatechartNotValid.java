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

/**
 * This Exception indicates that the current statechart is not valid.
 * 
 * @author Christopher Brink, Philipp Richter
 */
public class StatechartNotValid extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = -3309771540939940799L;

	/**
	 * @param message	defines the error message
	 */
	public StatechartNotValid(String message) {
		this(message, null);
	}
	
	/**
	 * @param message	defines the error message
	 * @param cause		specifies the cause exception
	 */
	public StatechartNotValid(String message, Exception cause) {
		super(message, cause);
	}
}

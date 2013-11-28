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
 * This Exception can be used if an error occurs during the change of the state configuration.
 * 
 * @author Christopher Brink ,Philipp Richter
 *
 */
public class ChangeConfigurationException extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = 2755917912851085369L;

	/**
	 * @param message	defines the error message
	 */
	public ChangeConfigurationException(String message) {
		this(message, null);
	}

	/**
	 * @param message	defines the error message
	 * @param cause		specifies the cause exception
	 */
	public ChangeConfigurationException(String message, Exception cause) {
		super(message, cause);
	}
}

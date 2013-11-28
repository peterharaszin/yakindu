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
 * This exception can be used, if an argument of a method is <code>null</code>.
 * 
 * @author Philipp Richter
 */
public class ArgumentIsNullException extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = 748536580073094559L;

	/**
	 * @param message	defines the error message
	 */
	public ArgumentIsNullException(String message) {
		this(message, null);
	}
	
	/**
	 * @param message	defines the error message
	 * @param cause		specifies the cause exception
	 */
	public ArgumentIsNullException(String message, Exception cause) {
		super(message, cause);
	}
}

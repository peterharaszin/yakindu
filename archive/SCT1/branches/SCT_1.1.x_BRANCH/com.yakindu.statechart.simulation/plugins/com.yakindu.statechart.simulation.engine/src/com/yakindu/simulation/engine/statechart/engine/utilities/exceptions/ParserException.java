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
 * This Exception can be used to indicate that an error is occurred during the
 * parsing or interpreting of actions and expressions. If a mathematical 
 * calculation is carried out, this exception will be thrown, too.
 * 
 * @author Christopher Brink, Philipp Richter
 *
 */
public class ParserException extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = 9013122226858147067L;

	/**
	 * @param message 	defines the error message
	 */
	public ParserException(String message) {
		this(message, null);
	}
	
	/**
	 * @param message	defines the error message
	 * @param cause		specifies the cause error
	 */
	public ParserException(String message, Exception cause) {
		super(message, cause);
	}
}

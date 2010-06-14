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
 * Indicates that the accessed object was disposed.
 * 
 * @author Philipp Richter
 */
public class ObjectDisposedException extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = -532949920180413375L;

	/**
	 * @param message	defines the error message
	 */
	public ObjectDisposedException(String message) {
		super(message);
	}
	
	/**
	 * @param message	defines the error message
	 * @param cause		specifies the cause exception
	 */
	public ObjectDisposedException(String message, Exception cause) {
		super(message, cause);
	}
}

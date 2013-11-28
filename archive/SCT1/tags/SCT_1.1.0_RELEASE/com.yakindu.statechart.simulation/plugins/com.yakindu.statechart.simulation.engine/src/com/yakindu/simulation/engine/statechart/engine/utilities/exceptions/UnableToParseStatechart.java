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
 * This Exception can be used if the given statechart can not be read or
 * parsed.
 * 
 * @author Christopher Brink, Philipp Richter
 */
public class UnableToParseStatechart extends Exception {

	/**
	 * Defines the unique identifier of this class.
	 */
	private static final long serialVersionUID = -2559331370215508430L;

	/**
	 * @param path 	defines the path of the statechart file
	 */
	public UnableToParseStatechart(String path) {
		this(path, null);
	}
	
	/**
	 * @param path		defines the path of the statechart file
	 * @param cause		specifies the cause exception
	 */
	public UnableToParseStatechart(String path, Exception cause) {
		super(path, cause);
	}
}

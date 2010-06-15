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
package org.mda4e.simulation.core;

/**
 * This exception declaration is used for the {@link ISimulationEngine} interface.
 * It extends the class {@link Throwable} by the method {@link #getSource()} which
 * returns the respective source object which throws the exception.
 * 
 * @author Markus M�hlbrandt
 * @author Philipp Richter
 */
public class SimulationException extends Exception {
	
	/**
	 * Defines the current version id of the <code>SimulationException</code> class.
	 */
	private static final long serialVersionUID = -8757875677986798489L;

	/**
	 * Contains the object which throws the specified exception.
	 */
	private Object source = null;
	
	/**
	 * Instantiates a <code>SimulationException</code> without a cause exception.
	 * 
	 * @param source	defines the object which occurs the exception
	 * @param message	defines the error message, which describes the problem
	 */
	public SimulationException(Object source, String message) {
		this(source, message, null);
	}

	/**
	 * Instantiates a <code>SimulationException</code> with a cause exception.
	 * 
	 * @param source	defines the object which occurs the exception
	 * @param message	defines the error message, which describes the problem
	 * @param cause 	defines the prior thrown exception 
	 */
	public SimulationException(Object source, String message, Throwable cause) {
		super(message, cause);
		this.source = source;
	}
	
	public SimulationException(String msg, Exception e) {
		super(msg, e);
	}

	/**
	 * Provides the object which throws the specified exception. In the default
	 * case the simulation engine itself is the source object.
	 *  
	 * @return	The source object of the exception.
	 */
	public Object getSource() {
		return source;
	}
}

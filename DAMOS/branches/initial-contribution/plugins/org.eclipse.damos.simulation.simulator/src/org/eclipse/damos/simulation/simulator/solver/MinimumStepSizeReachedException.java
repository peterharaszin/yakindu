/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation.simulator.solver;

/**
 * @author Andreas Unger
 *
 */
public class MinimumStepSizeReachedException extends Exception {

	private double requiredStepSize;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 */
	public MinimumStepSizeReachedException(double requiredStepSize) {
		this.requiredStepSize = requiredStepSize;
	}
	
	/**
	 * @return the requiredStepSize
	 */
	public double getRequiredStepSize() {
		return requiredStepSize;
	}

}

/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation;

import java.util.EventObject;

/**
 * @author Andreas Unger
 *
 */
public class SimulationEvent extends EventObject {

	public static final int START = 0;
	public static final int STEP = 1;
	public static final int ASYNCHRONOUS = 2;
	public static final int FINISH = 3;
	public static final int CANCEL = 4;
	public static final int OVERFLOW = 5;
	
	private ISimulation simulation;
	
	private int kind;
	private double time;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimulationEvent(Object source, ISimulation simulation, int kind) {
		this(source, simulation, kind, Double.NaN);
	}

	/**
	 * @param source
	 */
	public SimulationEvent(Object source, ISimulation simulation, int kind, double time) {
		super(source);
		this.simulation = simulation;
		this.kind = kind;
		this.time = time;
	}
	
	/**
	 * @return the simulation
	 */
	public ISimulation getSimulation() {
		return simulation;
	}
	
	/**
	 * @return the kind
	 */
	public int getKind() {
		return kind;
	}
	
	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	
	public boolean isDone() {
		return kind == FINISH || kind == CANCEL;
	}

}

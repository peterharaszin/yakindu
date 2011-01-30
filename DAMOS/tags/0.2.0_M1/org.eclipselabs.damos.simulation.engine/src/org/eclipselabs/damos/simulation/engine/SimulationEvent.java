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

package org.eclipselabs.damos.simulation.engine;

import java.util.EventObject;

/**
 * @author Andreas Unger
 *
 */
public class SimulationEvent extends EventObject {

	public static final int START = 0;
	public static final int STEP = 1;
	public static final int FINISH = 2;
	public static final int CANCEL = 3;
	
	private ISimulationContext context;
	
	private int kind;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param source
	 */
	public SimulationEvent(Object source, ISimulationContext context, int kind) {
		super(source);
		this.context = context;
		this.kind = kind;
	}
	
	/**
	 * @return the context
	 */
	public ISimulationContext getContext() {
		return context;
	}
	
	/**
	 * @return the kind
	 */
	public int getKind() {
		return kind;
	}
	
	public boolean isDone() {
		return kind == FINISH || kind == CANCEL;
	}

}

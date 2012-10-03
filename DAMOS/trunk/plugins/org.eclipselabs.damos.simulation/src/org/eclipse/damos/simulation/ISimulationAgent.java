/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.simulation;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.mscript.interpreter.IComputationContext;

/**
 * @author Andreas Unger
 *
 */
public interface ISimulationAgent extends IAdaptable {

	Component getComponent();
	
	ISimulationTracePoint[] getTracePoints();
	
	ISimulationVariationPoint[] getVariationPoints();

	/**
	 * Return the {@link IComputationContext} that will be used to
	 * create variation point values. If no variation points exist,
	 * <code>null</code> should be returned.
	 * 
	 * @return the {@link IComputationContext}, or <code>null</code>
	 */
	IComputationContext getComputationContext();

}

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

package org.eclipse.damos.simulation.simulator.solver;

import org.eclipse.damos.simulation.simulator.ISimulationObject;


/**
 * @author  Andreas Unger
 */
public class RungeKuttaIntegrationData extends AbstractIntegrationData {

	public double[] y;

	public double[] yTmps;

	public int k;

	public double[][] yDotKs;

	/**
	 * 
	 */
	public RungeKuttaIntegrationData(ISimulationObject simulationObject, int stageCount) {
		super(simulationObject);
		y = simulationObject.getStateVector();
		
		yDotKs = new double[stageCount][];
		for (int i = 0; i < stageCount; ++i) {
			yDotKs[i] = new double[y.length];
		}
		yTmps = new double[y.length];
	}
		
	
}

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

package org.eclipselabs.damos.simulation.simulator;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.library.base.util.continuous.TransferFunctionConstants;
import org.eclipselabs.damos.library.base.util.sources.StepConstants;
import org.eclipselabs.damos.simulation.ISimulation;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class TransferFunctionTest extends AbstractSimulationTest {

	@Test
	public void stepResponse() {
		Block step = createBlock(STEP, "Step");
		setArgument(step, StepConstants.PARAMETER__STEP_TIME, "0{s}");
		
		Block transferFunction = createBlock(TRANSFER_FUNCTION, "TransferFunction");
		setArgument(transferFunction, TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS, "{ 2, 3 }");
		setArgument(transferFunction, TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS, "{ 1, 0.4, 1 }");

		Block scope = createBlock(SCOPE, "Scope");

		connect(step, transferFunction);
		connect(transferFunction, scope);

		ISimulation simulation = simulate();
		
		compareChartData(simulation, scope, "TransferFunctionTest", 0.002);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationTest#getSimulationTime()
	 */
	@Override
	protected String getSimulationTime() {
		return "30{s}";
	}

}

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

package org.eclipse.damos.simulation.simulator;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.library.base.util.StepConstants;
import org.eclipse.damos.library.base.util.TransferFunctionConstants;
import org.eclipse.damos.simulation.ISimulation;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class TransferFunctionTest extends AbstractSimulationTest {

	@Inject
	private ILinker linker;
	
	@Test
	public void stepResponse() {
		Block step = createBlock(STEP, "Step");
		setArgument(step, StepConstants.PARAMETER__STEP_TIME, "0(s)");
		
		Block transferFunction = createBlock(TRANSFER_FUNCTION, "TransferFunction");
		setArgument(transferFunction, TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS, "{ 2, 3 }");
		setArgument(transferFunction, TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS, "{ 1, 0.4, 1 }");

		Block scope = createBlock(SCOPE, "Scope");

		connect(step, transferFunction);
		connect(transferFunction, scope);
		
		linker.linkModel(system, new ListBasedDiagnosticConsumer());

		ISimulation simulation = simulate();
		
		compareChartData(simulation, scope, "TransferFunctionTest", 0.002);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationTest#getSimulationTime()
	 */
	@Override
	protected String getSimulationTime() {
		return "30(s)";
	}

}

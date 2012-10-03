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

import static junit.framework.Assert.assertEquals;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.library.base.util.sources.ConstantConstants;
import org.eclipse.damos.simulation.ISimulation;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class FunctionTest extends AbstractSimulationTest {

	@Test
	public void function() {
		Block in = createBlock(CONSTANT, "In");
		setSynchronousTimingConstraint(in, 1);
		setArgument(in, ConstantConstants.PARAMETER__VALUE, "1");
		
		Block block = createTestBlock("FunctionTest", "FunctionTest");

		Block out = createBlock(SCOPE, "Out");
		
		connect(in, block);
		connect(block, out);

		ISimulation simulation = simulate();
		double[][] result = getChartData(simulation, out).getYValues();
		assertEquals(0.0, result[0][0], 1e-10);
		assertEquals(4.5, result[0][1], 1e-10);
		assertEquals(9.0, result[0][2], 1e-10);
		assertEquals(13.5, result[0][3], 1e-10);
	}

}

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

import static junit.framework.Assert.assertEquals;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.library.base.util.sources.ConstantConstants;
import org.eclipselabs.damos.simulation.ISimulation;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class VectorScalarMultiplyTest extends AbstractSimulationTest {

	@Test
	public void vectorScalarMultiply() {
		Block constant = createBlock(CONSTANT, "Constant");
		setSynchronousTimingConstraint(constant, 1);
		setArgument(constant, ConstantConstants.PARAMETER__VALUE, "{ 1, 2, 3 }");
		
		Block arrayScalarMultiply = createTestBlock("VectorScalarMultiply", "VectorScalarMultiply");
		Block demux = createTestBlock("DemuxThree", "DemuxThree");
		
		Block out1 = createBlock(SCOPE, "Out1");
		Block out2 = createBlock(SCOPE, "Out2");
		Block out3 = createBlock(SCOPE, "Out3");
		
		connect(constant, arrayScalarMultiply);
		connect(arrayScalarMultiply, demux);
		connect(demux, 0, out1);
		connect(demux, 1, out2);
		connect(demux, 2, out3);

		ISimulation simulation = simulate();
		assertEquals(11.9, getChartData(simulation, out1).getYValues()[0][0], 1e-6);
		assertEquals(23.8, getChartData(simulation, out2).getYValues()[0][0], 1e-6);
		assertEquals(35.7, getChartData(simulation, out3).getYValues()[0][0], 1e-6);
	}

}

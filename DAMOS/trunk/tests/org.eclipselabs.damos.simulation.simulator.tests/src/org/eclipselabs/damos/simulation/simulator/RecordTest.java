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
public class RecordTest extends AbstractSimulationTest {

	@Test
	public void record() {
		Block in = createBlock(CONSTANT, "In");
		setSynchronousTimingConstraint(in, 1);
		setArgument(in, ConstantConstants.PARAMETER__VALUE, "{ x = 3, y = 7 }");
		Block structTest = createTestBlock("RecordTest", "RecordTest");
		Block structExtractXY = createTestBlock("RecordExtractXY", "RecordExtractXY");
		Block structExtractMember = createTestBlock("RecordExtractMember", "RecordExtractMember");
		Block out1X = createBlock(SCOPE, "Out1X");
		Block out1Y = createBlock(SCOPE, "Out1Y");
		Block out2X = createBlock(SCOPE, "Out2X");
		Block out2A = createBlock(SCOPE, "Out2A");
		Block out2B0 = createBlock(SCOPE, "Out2B0");
		Block out2B1 = createBlock(SCOPE, "Out2B1");
		
		connect(in, structTest);
		connect(structTest, 0, structExtractXY);
		connect(structTest, 1, structExtractMember);
		connect(structExtractXY, 0, out1X);
		connect(structExtractXY, 1, out1Y);
		connect(structExtractMember, 0, out2X);
		connect(structExtractMember, 1, out2A);
		connect(structExtractMember, 2, out2B0);
		connect(structExtractMember, 3, out2B1);

		ISimulation simulation = simulate();
		assertEquals(3.0, getChartData(simulation, out1X).getYValues()[0][0], 1e-6);
		assertEquals(7.0, getChartData(simulation, out1Y).getYValues()[0][0], 1e-6);
		assertEquals(2.0, getChartData(simulation, out2X).getYValues()[0][0], 1e-6);
		assertEquals(5.0, getChartData(simulation, out2A).getYValues()[0][0], 1e-6);
		assertEquals(7.0, getChartData(simulation, out2B0).getYValues()[0][0], 1e-6);
		assertEquals(19.0, getChartData(simulation, out2B1).getYValues()[0][0], 1e-6);
	}

}

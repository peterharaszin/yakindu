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
import org.eclipse.damos.library.base.util.ConstantConstants;
import org.eclipse.damos.simulation.ISimulation;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class VectorTest extends AbstractSimulationTest {

	@Test
	public void vector() {
		Block in = createBlock(CONSTANT, "In");
		setSynchronousTimingConstraint(in, 1);
		setArgument(in, ConstantConstants.PARAMETER__VALUE, "{ 1, 2, 3 }");
		Block arrayScalarMultiply = createTestBlock("VectorScalarMultiply", "VectorScalarMultiply");
		Block vector3Extract = createTestBlock("Vector3Extract", "Vector3Extract");
		Block out1 = createBlock(SCOPE, "Out1");
		Block out2 = createBlock(SCOPE, "Out2");
		Block out3 = createBlock(SCOPE, "Out3");
		
		connect(in, arrayScalarMultiply);
		connect(arrayScalarMultiply, vector3Extract);
		connect(vector3Extract, 0, out1);
		connect(vector3Extract, 1, out2);
		connect(vector3Extract, 2, out3);

		ISimulation simulation = simulate();
		assertEquals(11.9, getChartData(simulation, out1).getYValues()[0][0], 1e-6);
		assertEquals(23.8, getChartData(simulation, out2).getYValues()[0][0], 1e-6);
		assertEquals(35.7, getChartData(simulation, out3).getYValues()[0][0], 1e-6);
	}

}

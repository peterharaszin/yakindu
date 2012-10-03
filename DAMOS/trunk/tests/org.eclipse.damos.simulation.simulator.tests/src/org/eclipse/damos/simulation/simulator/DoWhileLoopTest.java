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
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.library.base.util.CompareConstants;
import org.eclipse.damos.library.base.util.ConstantConstants;
import org.eclipse.damos.simulation.ISimulation;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class DoWhileLoopTest extends AbstractSimulationTest {

	@Test
	public void doWhileLoop() {
		Block initialValue = createBlock(CONSTANT, "InitialValue");
		setSynchronousTimingConstraint(initialValue, 1);
		Block upperLimit = createBlock(CONSTANT, "UpperLimit");
		setSynchronousTimingConstraint(upperLimit, 1);
		Block increment = createBlock(CONSTANT, "Increment");
		setSynchronousTimingConstraint(increment, 1);

		Block scope = createBlock(SCOPE, "Scope");

		Block sum = createBlock(SUM, "Sum");
		Block compare = createBlock(COMPARE, "Compare");
		setArgument(compare, CompareConstants.PARAMETER__OPERATOR, 2);
		Memory memory = createMemory("Memory");
		
		WhileLoop whileLoop = createWhileLoop(sum, memory, compare);
		
		connect(initialValue, memory, 0);
		connect(increment, sum, 0);
		connect(memory, sum, 1);
		connect(sum, memory, 1);

		connect(memory, scope);
		connect(memory, compare, 0);
		connect(upperLimit, compare, 1);
		connect(compare, whileLoop.getCondition());
		
		setArgument(initialValue, ConstantConstants.PARAMETER__VALUE, 10.0);
		setArgument(increment, ConstantConstants.PARAMETER__VALUE, 1.5);
		setArgument(upperLimit, ConstantConstants.PARAMETER__VALUE, 20.0);
		
		ISimulation simulation = simulate();
		double[] yValues = getChartData(simulation, scope).getYValues()[0];
		assertEquals(20.5, yValues[0], 1e-6);
	}
	
}

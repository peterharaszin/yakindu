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

import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.library.base.util.logic.CompareConstants;
import org.eclipse.damos.library.base.util.math.GainConstants;
import org.eclipse.damos.library.base.util.sources.ConstantConstants;
import org.eclipse.damos.simulation.ISimulation;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopTest extends AbstractSimulationTest {

	private Block preconditionBlock;
	private Block scope;

	@Before
	public void setUp() {
		super.setUp();
		
		preconditionBlock = createBlock(CONSTANT, "Precondition");
		setSynchronousTimingConstraint(preconditionBlock, 1);
		Block initialValueBlock = createBlock(CONSTANT, "InitialValue");
		setSynchronousTimingConstraint(initialValueBlock, 1);
		Block upperLimitBlock = createBlock(CONSTANT, "UpperLimit");
		setSynchronousTimingConstraint(upperLimitBlock, 1);
		Block incrementBlock = createBlock(CONSTANT, "Increment");
		setSynchronousTimingConstraint(incrementBlock, 1);

		scope = createBlock(SCOPE, "Scope");
		
		Choice choice = createChoice("Choice");

		Block gain = createBlock(GAIN, "Gain");
		setArgument(gain, GainConstants.PARAMETER__GAIN, 7);
		Block sum = createBlock(SUM, "Sum");
		Block compare = createBlock(COMPARE, "Compare");
		setArgument(compare, CompareConstants.PARAMETER__OPERATOR, 2);
		Memory memory = createMemory("Memory");
		Join join = createJoin("Join", 2);
		
		Action action = createAction(gain);
		WhileLoop whileLoop = createWhileLoop(sum, memory, compare);
		
		createActionLink(choice, action, false);
		createActionLink(choice, whileLoop, true);
		
		connect(preconditionBlock, choice);
		connect(initialValueBlock, gain);
		
		connect(initialValueBlock, memory, 0);
		connect(incrementBlock, sum, 0);
		connect(memory, sum, 1);
		connect(sum, memory, 1);
		
		connect(gain, join, 0);
		connect(memory, join, 1);

		connect(join, scope);
		connect(memory, compare, 0);
		connect(upperLimitBlock, compare, 1);
		connect(compare, whileLoop.getCondition());

		setArgument(initialValueBlock, ConstantConstants.PARAMETER__VALUE, 10.0);
		setArgument(incrementBlock, ConstantConstants.PARAMETER__VALUE, 1.5);
		setArgument(upperLimitBlock, ConstantConstants.PARAMETER__VALUE, 20.0);
	}
	
	@Test
	public void preconditionFalse() {
		setArgument(preconditionBlock, ConstantConstants.PARAMETER__VALUE, false);

		ISimulation simulation = simulate();
		double[] yValues = getChartData(simulation, scope).getYValues()[0];
		assertEquals(70.0, yValues[0], 1e-6);
	}

	@Test
	public void preconditionTrue() {
		setArgument(preconditionBlock, ConstantConstants.PARAMETER__VALUE, true);
		
		ISimulation simulation = simulate();
		double[] yValues = getChartData(simulation, scope).getYValues()[0];
		assertEquals(20.5, yValues[0], 1e-6);
	}

}

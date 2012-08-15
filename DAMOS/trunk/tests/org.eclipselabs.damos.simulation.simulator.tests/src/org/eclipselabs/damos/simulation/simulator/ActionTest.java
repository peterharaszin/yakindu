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

import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.library.base.util.math.GainConstants;
import org.eclipselabs.damos.library.base.util.sources.ConstantConstants;
import org.eclipselabs.damos.simulation.ISimulation;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andreas Unger
 *
 */
public class ActionTest extends AbstractSimulationTest {

	private Block valueBlock;
	private Block conditionBlock;
	private Block scope;

	@Before
	public void setUp() {
		super.setUp();
		
		Block gain = createBlock(GAIN, "gain");
		setArgument(gain, GainConstants.PARAMETER__GAIN, getGain());
		
		Block integrator = createBlock(DISCRETE_INTEGRATOR, "Integrator");

		valueBlock = createBlock(CONSTANT, "Value");
		setSynchronousTimingConstraint(valueBlock, 0.01);
		conditionBlock = createBlock(CONSTANT, "Condition");
		setSynchronousTimingConstraint(conditionBlock, 0.01);

		scope = createBlock(SCOPE, "Scope");
		
		Action onTrue = createAction(integrator);
		Action onFalse = createAction(gain);
		
		Choice choice = createChoice("Choice");
		createActionLink(choice, onTrue, true);
		createActionLink(choice, onFalse, false);
		
		Join join = createJoin("Join", 2);
		
		connect(valueBlock, integrator);
		connect(valueBlock, gain);
		connect(conditionBlock, choice);
		connect(integrator, join, 0);
		connect(gain, join, 1);
		connect(join, scope);
	}
	
	@Test
	public void gainAction0() {
		setArgument(valueBlock, ConstantConstants.PARAMETER__VALUE, 0.0);
		setArgument(conditionBlock, ConstantConstants.PARAMETER__VALUE, false);
		
		ISimulation simulation = simulate();
		assertEquals(0.0, getChartData(simulation, scope).getYValues()[0][0], 1e-6);
	}

	@Test
	public void gainAction1() {
		setArgument(valueBlock, ConstantConstants.PARAMETER__VALUE, 1.0);
		setArgument(conditionBlock, ConstantConstants.PARAMETER__VALUE, false);
		
		ISimulation simulation = simulate();
		assertEquals(7.0, getChartData(simulation, scope).getYValues()[0][0], 1e-6);
	}

	@Test
	public void gainAction10() {
		setArgument(valueBlock, ConstantConstants.PARAMETER__VALUE, 10.0);
		setArgument(conditionBlock, ConstantConstants.PARAMETER__VALUE, false);
		
		ISimulation simulation = simulate();
		assertEquals(70.0, getChartData(simulation, scope).getYValues()[0][0], 1e-6);
	}

	@Test
	public void integratorAction() {
		setArgument(valueBlock, ConstantConstants.PARAMETER__VALUE, 1.0);
		setArgument(conditionBlock, ConstantConstants.PARAMETER__VALUE, true);
		
		ISimulation simulation = simulate();
		double[] yValues = getChartData(simulation, scope).getYValues()[0];
		assertEquals(1.99, yValues[yValues.length - 1], 1e-6);
	}

	/**
	 * @return
	 */
	protected double getGain() {
		return 7;
	}
	
	@Override
	protected String getSimulationTime() {
		return "2.0{s}";
	}

}

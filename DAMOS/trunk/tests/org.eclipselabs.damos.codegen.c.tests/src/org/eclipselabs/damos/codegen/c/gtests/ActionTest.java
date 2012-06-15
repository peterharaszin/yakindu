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

package org.eclipselabs.damos.codegen.c.gtests;

import org.eclipselabs.damos.codegen.c.test.AbstractGeneratorGTest;
import org.eclipselabs.damos.codegen.c.test.GTest;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.library.base.util.math.GainConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/ActionTest.cpp", program="gtests/ActionTest")
public class ActionTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block gain = createBlock(GAIN, "gain");
		setArgument(gain, GainConstants.PARAMETER__GAIN, getGain());
		
		Block integrator = createBlock(DISCRETE_INTEGRATOR, "Integrator");

		Inport value = createInport("Value", createRealTypeSpecification(), 1);
		Inport condition = createInport("Condition", createBooleanTypeSpecification(), 1);

		Outport outport = createOutport("Out", createRealTypeSpecification());
		
		Action onTrue = createAction(integrator);
		Action onFalse = createAction(gain);
		
		Choice choice = createChoice("Choice");
		createActionLink(choice, onTrue, true);
		createActionLink(choice, onFalse, false);
		
		Join join = createJoin("Join", 2);
		
		connect(value, integrator);
		connect(value, gain);
		connect(condition, choice);
		connect(integrator, join, 0);
		connect(gain, join, 1);
		connect(join, outport);

		generateAndCompile();
	}

	/**
	 * @return
	 */
	protected double getGain() {
		return 7;
	}

}

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
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.library.base.util.logic.CompareConstants;
import org.eclipselabs.damos.library.base.util.math.GainConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/WhileLoopTest.cpp", program="gtests/WhileLoopTest")
public class WhileLoopTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Inport precondition = createInport("Precondition", createBooleanTypeSpecification(), 1);
		Inport initialValue = createInport("InitialValue", createRealTypeSpecification(), 1);
		Inport upperLimit = createInport("UpperLimit", createRealTypeSpecification(), 1);
		Inport increment = createInport("Increment", createRealTypeSpecification(), 1);

		Outport outport = createOutport("Out", createRealTypeSpecification());
		
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
		
		connect(precondition, choice);
		connect(initialValue, gain);
		
		connect(initialValue, memory, 0);
		connect(increment, sum, 0);
		connect(memory, sum, 1);
		connect(sum, memory, 1);
		
		connect(gain, join, 0);
		connect(memory, join, 1);

		connect(join, outport);
		connect(memory, compare, 0);
		connect(upperLimit, compare, 1);
		connect(compare, whileLoop.getCondition());

		generateAndCompile();
	}

}

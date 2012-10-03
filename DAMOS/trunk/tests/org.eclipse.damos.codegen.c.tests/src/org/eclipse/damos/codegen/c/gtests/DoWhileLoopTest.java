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

package org.eclipse.damos.codegen.c.gtests;

import org.eclipse.damos.codegen.c.test.AbstractGeneratorGTest;
import org.eclipse.damos.codegen.c.test.GTest;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Inport;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.library.base.util.CompareConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/DoWhileLoopTest.cpp", program="gtests/DoWhileLoopTest")
public class DoWhileLoopTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Inport initialValue = createInport("InitialValue", createRealTypeSpecification(), 1);
		Inport upperLimit = createInport("UpperLimit", createRealTypeSpecification(), 1);
		Inport increment = createInport("Increment", createRealTypeSpecification(), 1);

		Outport outport = createOutport("Out", createRealTypeSpecification());

		Block sum = createBlock(SUM, "Sum");
		Block compare = createBlock(COMPARE, "Compare");
		setArgument(compare, CompareConstants.PARAMETER__OPERATOR, 2);
		Memory memory = createMemory("Memory");
		
		WhileLoop whileLoop = createWhileLoop(sum, memory, compare);
		
		connect(initialValue, memory, 0);
		connect(increment, sum, 0);
		connect(memory, sum, 1);
		connect(sum, memory, 1);

		connect(memory, outport);
		connect(memory, compare, 0);
		connect(upperLimit, compare, 1);
		connect(compare, whileLoop.getCondition());

		generateAndCompile();
	}

}

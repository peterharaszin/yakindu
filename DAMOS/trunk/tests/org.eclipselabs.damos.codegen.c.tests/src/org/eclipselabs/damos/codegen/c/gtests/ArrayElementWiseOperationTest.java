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
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/ArrayElementWiseOperationTest.cpp", program="gtests/ArrayElementWiseOperationTest")
public class ArrayElementWiseOperationTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Inport inA = createInport("InA", createIntegerTypeSpecification(), 1);
		Inport inB = createInport("InB", createIntegerTypeSpecification(), 1);
		Block arrayTest = createTestBlock("ArrayElementWiseOperationTest", "ArrayElementWiseOperationTest");
		Outport outport1 = createOutport("Out1", createDataTypeSpecification("real[3]"));
		Outport outport2 = createOutport("Out2", createDataTypeSpecification("real[3, 2]"));
		
		connect(inA, arrayTest, 0);
		connect(inB, arrayTest, 1);
		connect(arrayTest, 0, outport1);
		connect(arrayTest, 1, outport2);

		generateAndCompile();
	}

}

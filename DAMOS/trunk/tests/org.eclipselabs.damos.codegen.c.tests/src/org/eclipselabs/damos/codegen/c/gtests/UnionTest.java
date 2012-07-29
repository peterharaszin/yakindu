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
@GTest(sourceFile="gtests/UnionTest.cpp", program="gtests/UnionTest")
public class UnionTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Inport inA = createInport("InA", createIntegerTypeSpecification(), 1);
		Inport inB = createInport("InB", createIntegerTypeSpecification(), 1);
		Block unionTest = createTestBlock("UnionTest", "UnionTest");
		
		Block inspectTest1 = createTestBlock("InspectTest", "InspectTest1");
		Block inspectTest2 = createTestBlock("InspectTest", "InspectTest2");

		Outport outport1 = createOutport("Out1", createDataTypeSpecification("union { int x; real y }"));
		Outport outport2 = createOutport("Out2", createDataTypeSpecification("union { int x; real y }"));
		
		connect(inA, unionTest, 0);
		connect(inB, unionTest, 1);
		connect(unionTest, 0, inspectTest1);
		connect(unionTest, 1, inspectTest2);
		connect(inspectTest1, outport1);
		connect(inspectTest2, outport2);

		generateAndCompile();
	}

}

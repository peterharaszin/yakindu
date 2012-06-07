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
@GTest(sourceFile="gtests/ArrayTest.cpp", program="gtests/ArrayTest")
public class ArrayTest extends AbstractGeneratorGTest {

	@Before
	public void setUp() {
		setUpInjector();
		
		createConfiguration();
		
		Inport inA = createInport("InA", createIntegerTypeSpecification(), 1);
		Inport inB = createInport("InB", createIntegerTypeSpecification(), 1);
		Block structConstructionTest = createTestBlock("ArrayTest", "ArrayTest");
		Outport outport1 = createOutport("Out1", createDataTypeSpecification("int[3]"));
		Outport outport2 = createOutport("Out2", createDataTypeSpecification("int[2]"));
		
		connect(inA, structConstructionTest, 0);
		connect(inB, structConstructionTest, 1);
		connect(structConstructionTest, 0, outport1);
		connect(structConstructionTest, 1, outport2);

		generateAndCompile();
	}

}

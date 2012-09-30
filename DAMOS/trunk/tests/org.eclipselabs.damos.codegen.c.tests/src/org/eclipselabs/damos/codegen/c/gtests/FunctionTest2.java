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
@GTest(sourceFile="gtests/FunctionTest2.cpp", program="gtests/FunctionTest2")
public class FunctionTest2 extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block block = createTestBlock("FunctionTest2", "FunctionTest2");
		
		Inport a = createInport("A", createRealTypeSpecification(), 1);
		Inport b = createInport("B", createRealTypeSpecification(), 1);
		Outport outport = createOutport("Out", createRealTypeSpecification());
		
		connect(a, block, 0);
		connect(b, block, 1);
		connect(block, outport);

		generateAndCompile();
	}

}

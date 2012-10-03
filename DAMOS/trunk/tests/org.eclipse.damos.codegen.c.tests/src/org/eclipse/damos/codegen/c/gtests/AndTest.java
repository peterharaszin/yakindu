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
import org.eclipse.damos.dml.Outport;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/AndTest.cpp", program="gtests/AndTest")
public class AndTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block and = createBlock(AND, "And");
		
		Inport a = createInport("A", createBooleanTypeSpecification(), 1);
		Inport b = createInport("B", createBooleanTypeSpecification(), 1);
		Outport outport = createOutport("Out", createBooleanTypeSpecification());
		
		connect(a, and, 0);
		connect(b, and, 1);
		connect(and, outport);

		generateAndCompile();
	}

}

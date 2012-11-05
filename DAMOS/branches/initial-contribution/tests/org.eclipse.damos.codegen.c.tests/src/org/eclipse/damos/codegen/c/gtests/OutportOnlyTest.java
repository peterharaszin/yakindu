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
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.library.base.util.ConstantConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/OutportOnlyTest.cpp", program="gtests/OutportOnlyTest")
public class OutportOnlyTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block constant = createBlock(CONSTANT, "Constant");
		setSynchronousTimingConstraint(constant, 1);
		setArgument(constant, ConstantConstants.PARAMETER__VALUE, 3.2);
		
		Outport outport = createOutport("Out", createRealTypeSpecification());
		
		connect(constant, outport);

		generateAndCompile();
	}

}

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
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.library.base.util.sources.ConstantConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/VectorScalarMultiplyTest.cpp", program="gtests/VectorScalarMultiplyTest")
public class VectorScalarMultiplyTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block constant = createBlock(CONSTANT, "Constant");
		setSynchronousTimingConstraint(constant, 1);
		setArgument(constant, ConstantConstants.PARAMETER__VALUE, "{ 1, 2, 3 }");
		
		Block arrayScalarMultiply = createTestBlock("VectorScalarMultiply", "VectorScalarMultiply");
		Block demux = createTestBlock("DemuxThree", "DemuxThree");
		
		Outport outport1 = createOutport("Out1", createRealTypeSpecification());
		Outport outport2 = createOutport("Out2", createRealTypeSpecification());
		Outport outport3 = createOutport("Out3", createRealTypeSpecification());
		
		connect(constant, arrayScalarMultiply);
		connect(arrayScalarMultiply, demux);
		connect(demux, 0, outport1);
		connect(demux, 1, outport2);
		connect(demux, 2, outport3);

		generateAndCompile();
	}

}

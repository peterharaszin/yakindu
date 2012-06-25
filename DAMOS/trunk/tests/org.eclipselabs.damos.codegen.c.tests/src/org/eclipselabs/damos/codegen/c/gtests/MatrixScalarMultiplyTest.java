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
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/MatrixScalarMultiplyTest.cpp", program="gtests/MatrixScalarMultiplyTest")
public class MatrixScalarMultiplyTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block constant = createBlock(CONSTANT, "Constant");
		setSynchronousTimingConstraint(constant, 1);
		setArgument(constant, ConstantConstants.PARAMETER__VALUE, "{ { 1, 2 }, { 3, 4 }, { 5, 6 } }");
		
		Block arrayScalarMultiply = createTestBlock("MatrixScalarMultiply", "MatrixScalarMultiply");
		
		Outport outport = createOutport("Out", createArrayTypeSpecification(TypeUtil.createRealType(), 3, 2));
		
		connect(constant, arrayScalarMultiply);
		connect(arrayScalarMultiply, outport);

		generateAndCompile();
	}

}

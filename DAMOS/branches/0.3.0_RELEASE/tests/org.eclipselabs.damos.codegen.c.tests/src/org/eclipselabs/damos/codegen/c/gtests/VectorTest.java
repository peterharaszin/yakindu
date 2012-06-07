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
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/VectorTest.cpp", program="gtests/VectorTest")
public class VectorTest extends AbstractGeneratorGTest {

	@Before
	public void setUp() {
		setUpInjector();
		
		createConfiguration();
		
		Inport inport = createInport("In", createArrayTypeSpecification(TypeUtil.createRealType(), 3), 1);
		Block arrayScalarMultiply = createTestBlock("VectorScalarMultiply", "VectorScalarMultiply");
		Outport outport = createOutport("Out", createArrayTypeSpecification(TypeUtil.createRealType(), 3));
		
		connect(inport, arrayScalarMultiply);
		connect(arrayScalarMultiply, outport);

		generateAndCompile();
	}

}

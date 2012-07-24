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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.test.AbstractGeneratorGTest;
import org.eclipselabs.damos.codegen.c.test.GTest;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/StructTest.cpp", program="gtests/StructTest")
public class StructTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		MscriptDataTypeSpecification structTypeSpecification = createDataTypeSpecification("{ int x; int y }");

		Inport inport = createInport("In", structTypeSpecification, 1);
		Block structTest = createTestBlock("StructTest", "StructTest");
		Block structExtractX = createTestBlock("StructExtractX", "StructExtractX");
		Outport outport = createOutport("Out", EcoreUtil.copy(structTypeSpecification));
		Outport outportX = createOutport("OutX", createIntegerTypeSpecification());
		Outport outportStructLiteral = createOutport("OutStructLiteral", createDataTypeSpecification("{ int x; { int a; int[2] b } y }"));
		
		connect(inport, structTest);
		connect(structTest, 0, outport);
		connect(structTest, 0, structExtractX);
		connect(structExtractX, outportX);
		connect(structTest, 1, outportStructLiteral);

		generateAndCompile();
	}

}

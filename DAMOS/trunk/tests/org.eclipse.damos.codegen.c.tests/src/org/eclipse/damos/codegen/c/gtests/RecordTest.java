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
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/RecordTest.cpp", program="gtests/RecordTest")
public class RecordTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		DscriptDataTypeSpecification structTypeSpecification = createDataTypeSpecification("{ int x; int y }");

		Inport inport = createInport("In", structTypeSpecification, 1);
		Block recordTest = createTestBlock("RecordTest", "RecordTest");
		Block recordExtractX = createTestBlock("RecordExtractX", "RecordExtractX");
		Outport outport = createOutport("Out", EcoreUtil.copy(structTypeSpecification));
		Outport outportX = createOutport("OutX", createIntegerTypeSpecification());
		Outport outportRecordLiteral = createOutport("OutRecordLiteral", createDataTypeSpecification("{ int x; { int a; int[2] b } y }"));
		
		connect(inport, recordTest);
		connect(recordTest, 0, outport);
		connect(recordTest, 0, recordExtractX);
		connect(recordExtractX, outportX);
		connect(recordTest, 1, outportRecordLiteral);

		generateAndCompile();
	}

}

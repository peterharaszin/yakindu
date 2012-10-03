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
import org.eclipse.damos.library.base.util.CompareConstants;
import org.eclipse.damos.library.base.util.ConstantConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/StringTest.cpp", program="gtests/StringTest")
public class StringTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Inport inA = createInport("InA", createIntegerTypeSpecification(), 1);
		Inport inB = createInport("InB", createIntegerTypeSpecification(), 1);
		
		Block constantEqual = createBlock(CONSTANT, "ConstantEqual");
		setArgument(constantEqual, ConstantConstants.PARAMETER__VALUE, "\"Hello, 3 world!\"");
		Block constantNotEqual = createBlock(CONSTANT, "ConstantNotEqual");
		setArgument(constantNotEqual, ConstantConstants.PARAMETER__VALUE, "\"Hello, 3 Xorld!\"");
		
		Block compareEqual = createBlock(COMPARE, "CompareEqual");
		setArgument(compareEqual, CompareConstants.PARAMETER__OPERATOR, 0);
		
		Block compareNotEqual = createBlock(COMPARE, "CompareNotEqual");
		setArgument(compareNotEqual, CompareConstants.PARAMETER__OPERATOR, 1);
		
		Block stringTest = createTestBlock("StringTest", "StringTest");
		Block stringTest2 = createTestBlock("StringTest2", "StringTest2");
		
		Outport outport1 = createOutport("Out1", createDataTypeSpecification("string"));
		Outport outport2 = createOutport("Out2", createDataTypeSpecification("string"));
		Outport outport3 = createOutport("Out3", createDataTypeSpecification("string"));
		Outport outport4 = createOutport("Out4", createDataTypeSpecification("string"));
		Outport outportEqual = createOutport("OutEqual", createBooleanTypeSpecification());
		Outport outportNotEqual = createOutport("OutNotEqual", createBooleanTypeSpecification());
		
		connect(inA, stringTest, 0);
		connect(inB, stringTest, 1);
		connect(stringTest, 0, outport1);
		connect(stringTest, 1, outport2);
		connect(stringTest, 0, stringTest2, 0);
		connect(stringTest, 1, stringTest2, 1);
		connect(stringTest2, 0, outport3);
		connect(stringTest2, 1, outport4);
		
		connect(stringTest, 0, compareEqual, 0);
		connect(constantEqual, compareEqual, 1);
		connect(compareEqual, outportEqual);

		connect(stringTest, 0, compareNotEqual, 0);
		connect(constantNotEqual, compareNotEqual, 1);
		connect(compareNotEqual, outportNotEqual);

		generateAndCompile();
	}

}

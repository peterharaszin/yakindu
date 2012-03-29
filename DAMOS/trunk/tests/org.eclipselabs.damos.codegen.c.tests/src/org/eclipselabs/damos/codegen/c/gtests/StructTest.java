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
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.StructMember;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/StructTest.cpp", program="gtests/StructTest")
public class StructTest extends AbstractGeneratorGTest {

	@Before
	public void setUp() {
		setUpInjector();
		
		createConfiguration();
		
		MscriptDataTypeSpecification structTypeSpecification = DMLTextFactory.eINSTANCE.createMscriptDataTypeSpecification();
		DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		StructType structType = MscriptFactory.eINSTANCE.createStructType();
		dataTypeSpecifier.setType(structType);
		structTypeSpecification.setSpecifier(dataTypeSpecifier);

		StructMember x = MscriptFactory.eINSTANCE.createStructMember();
		x.setName("x");
		DataTypeSpecifier xDataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		xDataTypeSpecifier.setType(TypeUtil.createIntegerType());
		x.setTypeSpecifier(xDataTypeSpecifier);
		structType.getMembers().add(x);

		StructMember y = MscriptFactory.eINSTANCE.createStructMember();
		y.setName("y");
		DataTypeSpecifier yDataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		yDataTypeSpecifier.setType(TypeUtil.createIntegerType());
		y.setTypeSpecifier(yDataTypeSpecifier);
		structType.getMembers().add(y);

		Inport inport = createInport("In", structTypeSpecification, 1);
		Block structTest = createTestBlock("StructTest", "StructTest");
		Outport outport = createOutport("Out", EcoreUtil.copy(structTypeSpecification));
		Outport outportX = createOutport("OutX", createIntegerTypeSpecification());
		
		Block structExtractX = createTestBlock("StructExtractX", "StructExtractX");
		
		connect(inport, structTest);
		connect(structTest, outport);
		connect(structTest, structExtractX);
		connect(structExtractX, outportX);

		generateAndCompile();
	}

}

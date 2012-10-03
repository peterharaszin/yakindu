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
import org.eclipse.damos.library.base.util.math.GainConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/GainTest.cpp", program="gtests/GainTest")
public class GainTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		Block gain = createBlock(GAIN, "Gain");
		setArgument(gain, GainConstants.PARAMETER__GAIN, getGain());
		
		Inport inport = createInport("In", createRealTypeSpecification(), 1);
		Outport outport = createOutport("Out", createRealTypeSpecification());
		
		connect(inport, gain);
		connect(gain, outport);

		generateAndCompile();
	}

	/**
	 * @return
	 */
	protected double getGain() {
		return 10;
	}

}

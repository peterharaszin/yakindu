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

package org.eclipselabs.damos.rte.posix.codegen.c.gtests;

import org.eclipselabs.damos.codegen.c.test.AbstractGeneratorGTest;
import org.eclipselabs.damos.codegen.c.test.GTest;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.library.base.util.math.GainConstants;
import org.junit.Before;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/CounterTest.cpp", program="gtests/CounterTest")
public class CounterTest extends AbstractGeneratorGTest {

	@Before
	@Override
	public void setUp() {
		super.setUp();
		
		configuration.getProperties().add(createSelectionProperty("damos.rte.runtime", "damos.rte.runtimes.Posix"));
		
		Block inverterA1 = createBlock(INVERTER, "InverterA1");
		Block inverterA2 = createBlock(INVERTER, "InverterA2");
		Block inverterB1 = createBlock(INVERTER, "InverterB1");
		Block inverterB2 = createBlock(INVERTER, "InverterB2");
		Block counter = createBlock(COUNTER, "Counter");
		Latch latch = createLatch("Latch", 0);
		Block gain = createBlock(GAIN, "Gain");
		setArgument(gain, GainConstants.PARAMETER__GAIN, 2);
		setSynchronousTimingConstraint(gain, 1);
		
		setSynchronousTimingConstraint(inverterA1, 1);
		inverterA2.setTimingConstraint(DMLFactory.eINSTANCE.createAsynchronousTimingConstraint());
		setSynchronousTimingConstraint(inverterB1, 1);
		inverterB2.setTimingConstraint(DMLFactory.eINSTANCE.createAsynchronousTimingConstraint());

		counter.setTimingConstraint(DMLFactory.eINSTANCE.createAsynchronousTimingConstraint());
		
		Inport a = createInport("A", createBooleanTypeSpecification(), 1);
		Inport b = createInport("B", createBooleanTypeSpecification(), 1);
		Outport outport = createOutport("Out", createIntegerTypeSpecification());
		
		connect(a, inverterA1);
		connect(inverterA1, inverterA2);
		connect(inverterA2, counter, 0);

		connect(b, inverterB1);
		connect(inverterB1, inverterB2);
		connect(inverterB2, counter, 1);

		connect(counter, latch);
		connect(latch, gain);
		connect(gain, outport);

		generateAndCompile();
	}

}

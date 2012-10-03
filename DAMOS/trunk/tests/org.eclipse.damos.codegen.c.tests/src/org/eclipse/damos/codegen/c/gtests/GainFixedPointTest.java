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

import org.eclipse.damos.codegen.c.test.GTest;
import org.eclipse.damos.mscript.computation.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/GainFixedPointTest.cpp", program="gtests/GainFixedPointTest")
public class GainFixedPointTest extends GainTest {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.tests.basic.GainTest#getGain()
	 */
	@Override
	protected double getGain() {
		return 0.5;
	}
	
	@Override
	protected ComputationModel createSystemComputationModel() {
		return createSystemComputationModel(16, 16);
	}

}

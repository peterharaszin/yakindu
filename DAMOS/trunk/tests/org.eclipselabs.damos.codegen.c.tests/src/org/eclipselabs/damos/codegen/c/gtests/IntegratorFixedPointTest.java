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

import org.eclipselabs.damos.codegen.c.test.GTest;
import org.eclipselabs.damos.mscript.computation.ComputationModel;

/**
 * @author Andreas Unger
 *
 */
@GTest(sourceFile="gtests/IntegratorFixedPointTest.cpp", program="gtests/IntegratorFixedPointTest")
public class IntegratorFixedPointTest extends IntegratorTest {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.tests.util.AbstractGeneratorGTest#createSystemComputationModel()
	 */
	@Override
	protected ComputationModel createSystemComputationModel() {
		return createSystemComputationModel(16, 16);
	}
	
}

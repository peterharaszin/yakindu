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

package org.eclipselabs.damos.codegen.c;

import org.eclipselabs.damos.codegen.c.gtests.ActionTest;
import org.eclipselabs.damos.codegen.c.gtests.AndTest;
import org.eclipselabs.damos.codegen.c.gtests.ArrayTest;
import org.eclipselabs.damos.codegen.c.gtests.DoWhileLoopTest;
import org.eclipselabs.damos.codegen.c.gtests.GainFixedPointTest;
import org.eclipselabs.damos.codegen.c.gtests.GainTest;
import org.eclipselabs.damos.codegen.c.gtests.InportOnlyTest;
import org.eclipselabs.damos.codegen.c.gtests.IntegratorFixedPointTest;
import org.eclipselabs.damos.codegen.c.gtests.IntegratorTest;
import org.eclipselabs.damos.codegen.c.gtests.OutportOnlyTest;
import org.eclipselabs.damos.codegen.c.gtests.StructConstructionTest;
import org.eclipselabs.damos.codegen.c.gtests.StructTest;
import org.eclipselabs.damos.codegen.c.gtests.VectorScalarMultiplyTest;
import org.eclipselabs.damos.codegen.c.gtests.VectorTest;
import org.eclipselabs.damos.codegen.c.gtests.WhileLoopTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Andreas Unger
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	InportOnlyTest.class,
	OutportOnlyTest.class,
	AndTest.class,
	GainTest.class,
	GainFixedPointTest.class,
	IntegratorTest.class,
	IntegratorFixedPointTest.class,
	ActionTest.class,
	DoWhileLoopTest.class,
	WhileLoopTest.class,
	ArrayTest.class,
	VectorTest.class,
	VectorScalarMultiplyTest.class,
	StructTest.class,
	StructConstructionTest.class
})
public class CodegenCTests {

}

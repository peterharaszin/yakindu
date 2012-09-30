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
import org.eclipselabs.damos.codegen.c.gtests.ArrayElementWiseOperationTest;
import org.eclipselabs.damos.codegen.c.gtests.ArrayTest;
import org.eclipselabs.damos.codegen.c.gtests.DoWhileLoopTest;
import org.eclipselabs.damos.codegen.c.gtests.FunctionTest2;
import org.eclipselabs.damos.codegen.c.gtests.GainFixedPointTest;
import org.eclipselabs.damos.codegen.c.gtests.GainTest;
import org.eclipselabs.damos.codegen.c.gtests.InportOnlyTest;
import org.eclipselabs.damos.codegen.c.gtests.IntegratorFixedPointTest;
import org.eclipselabs.damos.codegen.c.gtests.IntegratorTest;
import org.eclipselabs.damos.codegen.c.gtests.MapFunctionTest;
import org.eclipselabs.damos.codegen.c.gtests.MatrixMultiplyTest;
import org.eclipselabs.damos.codegen.c.gtests.MatrixScalarMultiplyTest;
import org.eclipselabs.damos.codegen.c.gtests.MatrixTest;
import org.eclipselabs.damos.codegen.c.gtests.MatrixVectorMultiplyTest;
import org.eclipselabs.damos.codegen.c.gtests.OutportOnlyTest;
import org.eclipselabs.damos.codegen.c.gtests.RecordConstructionTest;
import org.eclipselabs.damos.codegen.c.gtests.RecordTest;
import org.eclipselabs.damos.codegen.c.gtests.StringTest;
import org.eclipselabs.damos.codegen.c.gtests.UnionTest;
import org.eclipselabs.damos.codegen.c.gtests.VectorMatrixMultiplyTest;
import org.eclipselabs.damos.codegen.c.gtests.VectorMultiplyTest;
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
	StringTest.class,
	ArrayTest.class,
	ArrayElementWiseOperationTest.class,
	VectorTest.class,
	VectorMatrixMultiplyTest.class,
	VectorMultiplyTest.class,
	MatrixTest.class,
	MatrixMultiplyTest.class,
	MatrixVectorMultiplyTest.class,
	VectorScalarMultiplyTest.class,
	MatrixScalarMultiplyTest.class,
	RecordTest.class,
	RecordConstructionTest.class,
	UnionTest.class,
	MapFunctionTest.class,
	FunctionTest2.class
})
public class CodegenCTests {

}

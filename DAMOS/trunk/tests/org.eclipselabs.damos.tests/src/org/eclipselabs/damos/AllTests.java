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

package org.eclipselabs.damos;

import org.eclipselabs.damos.codegen.c.CodegenCTests;
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorTests;
import org.eclipselabs.damos.rte.posix.codegen.c.RTEPosixCodegenCTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Andreas Unger
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	MscriptGeneratorTests.class,
	CodegenCTests.class,
	RTEPosixCodegenCTests.class
})
public class AllTests {

}

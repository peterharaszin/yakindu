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

package org.eclipse.damos.rte.posix.codegen.c;

import org.eclipse.damos.rte.posix.codegen.c.gtests.CounterTestWithPrefix;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Andreas Unger
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
	CounterTestWithPrefix.class
})
public class RTEPosixCodegenCTests {

}

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

import org.eclipselabs.damos.codegen.c.test.GTest;
import org.eclipselabs.damos.dconfig.DconfigFactory;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.StringLiteral;

/**
 * Right now generated code is invalid if no prefix is specified.
 * This should be fixed in the future.
 * 
 * @author Andreas Unger
 */
@GTest(sourceFile="gtests/CounterTestWithPrefix.cpp", program="gtests/CounterTestWithPrefix")
public class CounterTestWithPrefix extends CounterTest {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.test.AbstractGeneratorGTest#createConfiguration()
	 */
	@Override
	protected void createConfiguration() {
		super.createConfiguration();
		PropertyDeclaration prefixPropertyDeclaration = new PropertyEnumerationHelper().getPropertyDeclaration("damos.codegen.c.prefix");
		SimpleProperty prefixProperty = DconfigFactory.eINSTANCE.createSimpleProperty();
		prefixProperty.setDeclaration((SimplePropertyDeclaration) prefixPropertyDeclaration);
		StringLiteral prefix = MscriptFactory.eINSTANCE.createStringLiteral();
		prefix.setValue("CounterTest_");
		prefixProperty.setValue(prefix);
		prefixProperty.setPropagate(true);
		configuration.getRootSystemConfiguration().getBody().getProperties().add(prefixProperty);
	}
	
}

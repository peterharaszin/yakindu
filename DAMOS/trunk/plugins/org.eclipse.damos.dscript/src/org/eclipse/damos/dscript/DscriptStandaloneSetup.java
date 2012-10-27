/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dscript;

import org.eclipse.damos.dscript.DscriptStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DscriptStandaloneSetup extends DscriptStandaloneSetupGenerated{

	public static void doSetup() {
		new DscriptStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
}


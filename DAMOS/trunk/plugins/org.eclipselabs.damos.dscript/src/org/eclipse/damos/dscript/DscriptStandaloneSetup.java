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


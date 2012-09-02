package org.eclipselabs.damos.dscript;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DscriptStandaloneSetup extends DscriptStandaloneSetupGenerated{

	public static void doSetup() {
		new DscriptStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
	
}


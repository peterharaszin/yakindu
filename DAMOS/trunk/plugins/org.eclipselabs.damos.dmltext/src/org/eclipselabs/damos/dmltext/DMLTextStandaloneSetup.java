
package org.eclipselabs.damos.dmltext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DMLTextStandaloneSetup extends DMLTextStandaloneSetupGenerated{

	public static void doSetup() {
		new DMLTextStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipselabs.damos.dconfig;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class DconfigStandaloneSetup extends DconfigStandaloneSetupGenerated{

	public static void doSetup() {
		new DconfigStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


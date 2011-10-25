
package org.eclipselabs.damos.mscript.computationmodel;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ComputationModelStandaloneSetup extends ComputationModelStandaloneSetupGenerated{

	public static void doSetup() {
		new ComputationModelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipselabs.damos.codegen.c.cgenmodel;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class CGenModelStandaloneSetup extends CGenModelStandaloneSetupGenerated{

	public static void doSetup() {
		new CGenModelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}



package org.eclipselabs.damos.execution.executionmodel;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExecutionModelStandaloneSetup extends ExecutionModelStandaloneSetupGenerated{

	public static void doSetup() {
		new ExecutionModelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


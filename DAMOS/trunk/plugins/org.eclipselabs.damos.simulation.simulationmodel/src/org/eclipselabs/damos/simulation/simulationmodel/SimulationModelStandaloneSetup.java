
package org.eclipselabs.damos.simulation.simulationmodel;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SimulationModelStandaloneSetup extends SimulationModelStandaloneSetupGenerated{

	public static void doSetup() {
		new SimulationModelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


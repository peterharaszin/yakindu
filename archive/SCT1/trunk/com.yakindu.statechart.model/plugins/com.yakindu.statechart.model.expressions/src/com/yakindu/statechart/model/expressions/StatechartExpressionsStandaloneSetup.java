
package com.yakindu.statechart.model.expressions;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class StatechartExpressionsStandaloneSetup extends StatechartExpressionsStandaloneSetupGenerated{

	public static void doSetup() {
		new StatechartExpressionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


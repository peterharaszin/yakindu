
package org.eclipse.damos.mscript;

import org.eclipse.damos.mscript.MscriptStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MscriptStandaloneSetup extends MscriptStandaloneSetupGenerated{

	public static void doSetup() {
		new MscriptStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}


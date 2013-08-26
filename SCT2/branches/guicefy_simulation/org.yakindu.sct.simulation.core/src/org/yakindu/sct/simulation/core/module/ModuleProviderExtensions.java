package org.yakindu.sct.simulation.core.module;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.google.inject.Module;

public class ModuleProviderExtensions {

	private static final String SIMULATION_EXTENSION = "org.yakindu.sct.simulation.core.extension";

	private static final String ATTR_CLASS = "class";

	protected ModuleProviderExtensions() {
	}

	public static Module getOverridingModule() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				SIMULATION_EXTENSION);
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				IModuleProvider provider = (IModuleProvider) configurationElement.createExecutableExtension(ATTR_CLASS);
				return provider.getModule();
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return new IModuleProvider.NullImpl().getModule();
	}
}

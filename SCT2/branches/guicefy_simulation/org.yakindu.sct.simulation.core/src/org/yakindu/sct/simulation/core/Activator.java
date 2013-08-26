package org.yakindu.sct.simulation.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.yakindu.sct.simulation.core.hmr.SCTHotModelReplacementManager;
import org.yakindu.sct.simulation.core.module.ModuleProviderExtensions;
import org.yakindu.sct.simulation.core.module.SimulationModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static final String PLUGIN_ID = "org.yakindu.sct.simulation.core";

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		SCTHotModelReplacementManager.INSTANCE.startup();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		SCTHotModelReplacementManager.INSTANCE.tearDown();
	}

	private static Injector injector = null;

	public static Injector getInjector() {
		if (injector == null) {
			// TODO: Use override
			injector = Guice.createInjector(new SimulationModule(), ModuleProviderExtensions.getOverridingModule());
		}
		return injector;
	}
}

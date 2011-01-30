package org.eclipselabs.damos.simulation.ide.core;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class SimulationIDECorePlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.simulation.ide.core";

	// The shared instance
	private static SimulationIDECorePlugin plugin;
	
	/**
	 * The constructor
	 */
	public SimulationIDECorePlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SimulationIDECorePlugin getDefault() {
		return plugin;
	}

}

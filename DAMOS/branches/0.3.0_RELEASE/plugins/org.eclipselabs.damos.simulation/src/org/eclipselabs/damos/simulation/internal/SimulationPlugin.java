package org.eclipselabs.damos.simulation.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class SimulationPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.simulation";

	// The shared instance
	private static SimulationPlugin plugin;
	
	/**
	 * The constructor
	 */
	public SimulationPlugin() {
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
	public static SimulationPlugin getDefault() {
		return plugin;
	}

}

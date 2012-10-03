package org.eclipse.damos.simulation.simulator;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class SimulatorTestsPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.damos.simulation.simulator.tests";

	// The shared instance
	private static SimulatorTestsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public SimulatorTestsPlugin() {
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
	public static SimulatorTestsPlugin getDefault() {
		return plugin;
	}

}

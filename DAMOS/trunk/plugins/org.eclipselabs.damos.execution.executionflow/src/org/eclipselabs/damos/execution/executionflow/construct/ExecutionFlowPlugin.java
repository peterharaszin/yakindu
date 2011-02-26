package org.eclipselabs.damos.execution.executionflow.construct;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class ExecutionFlowPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.executionflow";

	// The shared instance
	private static ExecutionFlowPlugin plugin;
	
	/**
	 * The constructor
	 */
	public ExecutionFlowPlugin() {
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
	public static ExecutionFlowPlugin getDefault() {
		return plugin;
	}

}

package org.eclipselabs.damos.codegen.c;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class CodegenCTestsPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.codegen.c.tests";

	// The shared instance
	private static CodegenCTestsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public CodegenCTestsPlugin() {
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
	public static CodegenCTestsPlugin getDefault() {
		return plugin;
	}

}

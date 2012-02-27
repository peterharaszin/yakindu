package org.eclipselabs.damos.codegen.c;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class CodegenCGeneratorPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipselabs.damos.codegen.c";

	// The shared instance
	private static CodegenCGeneratorPlugin plugin;
	
	/**
	 * The constructor
	 */
	public CodegenCGeneratorPlugin() {
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
	public static CodegenCGeneratorPlugin getDefault() {
		return plugin;
	}

}

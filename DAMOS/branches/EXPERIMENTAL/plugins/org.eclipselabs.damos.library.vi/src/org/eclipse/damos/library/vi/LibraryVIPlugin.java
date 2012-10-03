package org.eclipse.damos.library.vi;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class LibraryVIPlugin extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.damos.library.vi";

	// The shared instance
	private static LibraryVIPlugin plugin;
	
	/**
	 * The constructor
	 */
	public LibraryVIPlugin() {
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
	public static LibraryVIPlugin getDefault() {
		return plugin;
	}

}

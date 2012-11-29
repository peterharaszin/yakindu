package org.kieler.synccharts.editor;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.kieler.synccharts.editor.module.KielerModule;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Activator extends AbstractUIPlugin implements BundleActivator {


	private static Activator plugin;
	
	private Injector injector;

	public Activator() {
		injector = Guice.createInjector(new KielerModule());
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		plugin = this;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
	}

	public static Activator getDefault() {
		return plugin;
	}
	
	public Injector getInjector() {
		return injector;
	}

}

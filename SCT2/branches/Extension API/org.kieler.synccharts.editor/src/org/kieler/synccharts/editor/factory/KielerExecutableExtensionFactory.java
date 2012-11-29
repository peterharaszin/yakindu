package org.kieler.synccharts.editor.factory;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.kieler.synccharts.editor.Activator;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

public class KielerExecutableExtensionFactory extends
		AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return Activator.getDefault().getInjector();
	}

}

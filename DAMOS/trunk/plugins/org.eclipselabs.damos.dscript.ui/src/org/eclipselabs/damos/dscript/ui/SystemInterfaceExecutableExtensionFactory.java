package org.eclipselabs.damos.dscript.ui;

import static com.google.inject.util.Modules.override;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipselabs.damos.dscript.SystemInterfaceRuntimeModule;
import org.eclipselabs.damos.dscript.ui.internal.DscriptActivator;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class SystemInterfaceExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return DscriptActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(override(override(new SystemInterfaceRuntimeModule()).with(new SharedStateModule()))
				.with(new SystemInterfaceUiModule(DscriptActivator.getInstance())));
	}
	
}

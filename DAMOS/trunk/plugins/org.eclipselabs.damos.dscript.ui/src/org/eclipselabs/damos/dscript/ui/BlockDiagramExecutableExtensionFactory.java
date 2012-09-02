package org.eclipselabs.damos.dscript.ui;

import static com.google.inject.util.Modules.override;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipselabs.damos.dscript.BlockDiagramRuntimeModule;
import org.eclipselabs.damos.dscript.ui.internal.DscriptActivator;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BlockDiagramExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return DscriptActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(override(override(new BlockDiagramRuntimeModule()).with(new SharedStateModule()))
				.with(new BlockDiagramUiModule(DscriptActivator.getInstance())));
	}
	
}

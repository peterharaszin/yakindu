/*
 * generated by Xtext
 */
package org.yakindu.sct.generator.genmodel.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SGenExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.yakindu.sct.generator.genmodel.ui.internal.SGenActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.yakindu.sct.generator.genmodel.ui.internal.SGenActivator.getInstance().getInjector("org.yakindu.sct.generator.genmodel.SGen");
	}
	
}

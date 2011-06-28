package org.yakindu.sct.ui.integration.stext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.extensions.IExpressionsProvider;
import org.yakindu.sct.ui.integration.stext.modules.StateRuntimeModule;
import org.yakindu.sct.ui.integration.stext.modules.StateUIModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * 
 * @author muelder
 * 
 */
public class StateExpressionProvider implements IExpressionsProvider {

	
	public boolean isProviderFor(EObject semanticElement) {
		return SGraphPackage.STATE == semanticElement.eClass()
				.getClassifierID();
	}

	
	public Injector getInjector() {
		return Guice.createInjector(Modules.override(
				Modules.override(new StateRuntimeModule()).with(
						new StateUIModule(ExtensionsActivator.getDefault()))).with(
				new SharedStateModule()));
	}


	public int getStyle() {
		return SWT.MULTI;
	}

	
}

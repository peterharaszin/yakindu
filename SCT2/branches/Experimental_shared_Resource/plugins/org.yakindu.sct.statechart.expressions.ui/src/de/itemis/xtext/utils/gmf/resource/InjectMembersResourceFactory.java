package de.itemis.xtext.utils.gmf.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.statechart.ui.internal.ExpressionsActivator;

import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class InjectMembersResourceFactory extends XMIResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		InjectMembersResource resource = new InjectMembersResource(uri);
		Injector injector = ExpressionsActivator.getInstance().getInjector(
				"org.yakindu.sct.statechart.Expressions");
		// Add a Transition service
		TransitionInjectionService transitionService = new TransitionInjectionService();
		injector.injectMembers(transitionService);
		resource.getServices().add(transitionService);
		// Add a State service
		StateInjectionService stateService = new StateInjectionService();
		injector.injectMembers(stateService);
		resource.getServices().add(stateService);
		// Add a Statechart service
		StatechartInjectionService statechartService = new StatechartInjectionService();
		injector.injectMembers(statechartService);
		resource.getServices().add(statechartService);
		return resource;
	}
}

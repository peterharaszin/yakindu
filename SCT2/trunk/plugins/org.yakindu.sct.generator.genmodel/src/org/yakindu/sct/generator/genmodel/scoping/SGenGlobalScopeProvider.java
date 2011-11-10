package org.yakindu.sct.generator.genmodel.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.yakindu.sct.generator.genmodel.extensions.LibraryExtensions;
import org.yakindu.sct.generator.genmodel.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private ResourceSet resourceSet;

	@Inject
	private Injector injector;

	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			final EClass type, Predicate<IEObjectDescription> filter) {
		IScope defaultScope = super
				.getScope(resource, ignoreCase, type, filter);
		Iterable<IEObjectDescription> allElements = defaultScope
				.getAllElements();
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptor();
		for (LibraryDescriptor desc : libraryDescriptor) {
			Resource library = resourceSet.getResource(desc.getURI(), true);
			FeatureResourceDescription description = new FeatureResourceDescription(library);
			injector.injectMembers(description);
			allElements = Iterables.concat(allElements,
					description.getExportedObjectsByType(type));
		}
		return new SimpleScope(allElements);
	}
}

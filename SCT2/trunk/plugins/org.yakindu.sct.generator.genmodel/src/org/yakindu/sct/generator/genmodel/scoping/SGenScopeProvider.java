/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.scoping;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.FilteringScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SGenScopeProvider extends XbaseScopeProvider {

	@Inject
	private XtextResourceSet resourceSet;

	@Inject
	private Injector injector;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (reference.getName().equals("type")) {
			return scope_Type(context, reference);
		}
		if (reference.getName().equals("parameter")) {
			return scope_Parameter(context, reference);
		}
		return super.getScope(context, reference);
	}

	private IScope scope_Parameter(final EObject context, EReference reference) {
		IScope libraryScope = getLibraryScope(context.eResource());
		return new FilteringScope(libraryScope,
				new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						if (!input.getEClass().equals(
								SGenPackage.Literals.FEATURE_PARAMETER)) {
							return false;
						}
						// Only allow references to FeatureParameters defined by
						// enclosing Feature
						FeatureConfiguration configuration = EcoreUtil2
								.getContainerOfType(context,
										FeatureConfiguration.class);
						String featureName = configuration.getType().getName();
						if (featureName == null) {
							return false;
						}
						return featureName.equals(input
								.getUserData(FeatureResourceDescription.FEATURE_CONTAINER));

					}
				});
	}

	private IScope scope_Type(EObject context, EReference reference) {
		IScope libraryScope = getLibraryScope(context.eResource());
		return new FilteringScope(libraryScope,
				new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						return input.getEClass().equals(
								SGenPackage.Literals.FEATURE_TYPE);
					}
				});
	}

	private SimpleScope getLibraryScope(Resource resource) {
		GeneratorModel generatorModel = (GeneratorModel) EcoreUtil
				.getObjectByType(resource.getContents(),
						SGenPackage.Literals.GENERATOR_MODEL);
		Assert.isNotNull(generatorModel);
		String generatorId = generatorModel.getGeneratorId();

		Iterable<IEObjectDescription> allElements = Lists.newArrayList();
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptor(generatorId);
		for (LibraryDescriptor desc : libraryDescriptor) {
			Resource library = resourceSet.getResource(desc.getURI(), true);
			FeatureResourceDescription description = new FeatureResourceDescription(
					library);
			injector.injectMembers(description);
			allElements = Iterables.concat(allElements,
					description.getExportedObjects());
		}
		return new SimpleScope(allElements);
	}

}

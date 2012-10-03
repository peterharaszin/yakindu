/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.mscript.TopLevelDeclaration;
import org.eclipse.damos.mscript.UnitDeclaration;
import org.eclipse.damos.mscript.UnitSymbol;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	public static final URI MSCRIPT_LANG_UNITS_URI = URI.createURI("http://www.eclipse.org/damos/mscript/library/mscript_lang_units.mscript");
	
	/**
	 * 
	 */
	private static final URI[] LIBRARY_URIS = {
		URI.createURI("http://www.eclipse.org/damos/mscript/library/mscript_lang.xmi"),
		URI.createURI("http://www.eclipse.org/damos/mscript/library/mscript_lang.mscript"),
		URI.createURI("http://www.eclipse.org/damos/mscript/library/mscript_lang_math.xmi"),
		URI.createURI("http://www.eclipse.org/damos/mscript/library/mscript_lang_math.mscript"),
		MSCRIPT_LANG_UNITS_URI
	};

	@Inject
	private ResourceSet resourceSet;
	
	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	private static volatile List<IEObjectDescription> eObjectDescriptions;

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider#getScope(org.eclipse.emf.ecore.resource.Resource, boolean, org.eclipse.emf.ecore.EClass, com.google.common.base.Predicate)
	 */
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		IScope parentScope = super.getScope(resource, ignoreCase, type, filter);
		return new AbstractScope(parentScope, ignoreCase) {
			
			@Override
			protected Iterable<IEObjectDescription> getAllLocalElements() {
				return getEObjectDescriptions();
			}
			
		};
	}
	
	private List<IEObjectDescription> getEObjectDescriptions() {
		if (eObjectDescriptions != null) {
			return eObjectDescriptions;
		}
		synchronized (MscriptGlobalScopeProvider.class) {
			if (eObjectDescriptions == null) {
				eObjectDescriptions = new ArrayList<IEObjectDescription>();
				for (URI uri : LIBRARY_URIS) {
					Resource resource = resourceSet.getResource(uri, true);
					for (EObject eObject : resource.getContents().get(0).eContents()) {
						if (eObject instanceof TopLevelDeclaration) {
							TopLevelDeclaration topLevelDeclaration = (TopLevelDeclaration) eObject;
							eObjectDescriptions.add(EObjectDescription.create(qualifiedNameProvider.getFullyQualifiedName(eObject), eObject));
							if (topLevelDeclaration instanceof UnitDeclaration) {
								UnitDeclaration unitDeclaration = (UnitDeclaration) topLevelDeclaration;
								for (UnitSymbol unitSymbol : unitDeclaration.getSymbols()) {
									eObjectDescriptions.add(EObjectDescription.create(qualifiedNameProvider.getFullyQualifiedName(unitSymbol), unitSymbol));
								}
							}
						}
					}
					resource.unload();
				}
			}
		}
		return eObjectDescriptions;
	}
	
}

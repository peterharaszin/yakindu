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

package org.eclipselabs.damos.mscript.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipselabs.damos.mscript.Declaration;
import org.eclipselabs.damos.mscript.UnitDeclaration;
import org.eclipselabs.damos.mscript.UnitSymbol;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	/**
	 * 
	 */
	public static final String LIBRARY_URI = "http://www.eclipselabs.org/damos/mscript/library/Standard.xmi";

	@Inject
	private ResourceSet resourceSet;
	
	private static volatile List<IEObjectDescription> eObjectDescriptions;

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider#getScope(org.eclipse.emf.ecore.resource.Resource, boolean, org.eclipse.emf.ecore.EClass, com.google.common.base.Predicate)
	 */
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		return new AbstractScope(super.getScope(resource, ignoreCase, type, filter), ignoreCase) {
			
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
				URI uri = URI.createURI(LIBRARY_URI, true);
				Resource resource = resourceSet.getResource(uri, true);
				for (EObject eObject : resource.getContents().get(0).eContents()) {
					if (eObject instanceof Declaration) {
						Declaration declaration = (Declaration) eObject;
						eObjectDescriptions.add(EObjectDescription.create(declaration.getName(), eObject));
						if (declaration instanceof UnitDeclaration) {
							UnitDeclaration unitDeclaration = (UnitDeclaration) declaration;
							for (UnitSymbol unitSymbol : unitDeclaration.getSymbols()) {
								eObjectDescriptions.add(EObjectDescription.create(unitSymbol.getName(), unitSymbol));
							}
						}
					}
				}
				resource.unload();
			}
		}
		return eObjectDescriptions;
	}
	
}

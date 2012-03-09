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

package org.eclipselabs.damos.dconfig.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
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
import org.eclipselabs.damos.dconfig.ConfigurationDefinition;
import org.eclipselabs.damos.dconfig.ConfigurationDefinitionMember;
import org.eclipselabs.damos.dconfig.internal.DconfigPlugin;
import org.eclipselabs.damos.dconfig.internal.registry.DefinitionRegistry;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DconfigGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
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
		synchronized (DconfigGlobalScopeProvider.class) {
			if (eObjectDescriptions == null) {
				List<IEObjectDescription> eObjectDescriptions = new ArrayList<IEObjectDescription>();
				for (URI uri : DefinitionRegistry.getInstance().getDefinitionResourceURIs()) {
					Resource resource = resourceSet.getResource(uri, true);
					if (resource == null) {
						DconfigPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, DconfigPlugin.PLUGIN_ID, "Resource not found: " + uri.toString()));
						continue;
					}
					for (TreeIterator<EObject> it = resource.getAllContents(); it.hasNext();) {
						EObject next = it.next();
						if (next instanceof ConfigurationDefinitionMember) {
							eObjectDescriptions.add(EObjectDescription.create(qualifiedNameProvider.getFullyQualifiedName(next), next));
						}
						if (!(next instanceof ConfigurationDefinition)) {
							it.prune();
						}
					}
					resource.unload();
				}
				DconfigGlobalScopeProvider.eObjectDescriptions = eObjectDescriptions;
			}
		}
		return eObjectDescriptions;
	}
	
}

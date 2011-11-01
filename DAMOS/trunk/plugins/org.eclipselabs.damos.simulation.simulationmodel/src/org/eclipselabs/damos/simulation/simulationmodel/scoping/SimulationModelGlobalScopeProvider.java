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

package org.eclipselabs.damos.simulation.simulationmodel.scoping;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipselabs.damos.simulation.simulationmodel.SolverType;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeDescriptor;
import org.eclipselabs.damos.simulation.simulationmodel.registry.ISolverTypeRegistry;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class SimulationModelGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	@Inject
	private ResourceSet resourceSet;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
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
		synchronized (SimulationModelGlobalScopeProvider.class) {
			if (eObjectDescriptions == null) {
				eObjectDescriptions = new ArrayList<IEObjectDescription>();
				for (ISolverTypeDescriptor solverType : ISolverTypeRegistry.INSTANCE.getSolverTypes()) {
					Resource resource = resourceSet.getResource(solverType.getURI(), true);
					for (EObject eObject : resource.getContents()) {
						String qualifiedName = ((SolverType) eObject).getQualifiedName();
						eObjectDescriptions.add(EObjectDescription.create(qualifiedNameConverter.toQualifiedName(qualifiedName), eObject));
					}
					resource.unload();
				}
			}
		}
		return eObjectDescriptions;
	}
	
}

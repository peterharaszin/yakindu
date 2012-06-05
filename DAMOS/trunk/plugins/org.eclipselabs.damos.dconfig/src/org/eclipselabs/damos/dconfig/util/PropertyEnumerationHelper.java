/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dconfig.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;
import org.eclipselabs.damos.dconfig.internal.DconfigPlugin;
import org.eclipselabs.damos.dconfig.internal.registry.DefinitionRegistry;

/**
 * @author Andreas Unger
 *
 */
public class PropertyEnumerationHelper {

	private ResourceSet resourceSet;
	private String[] propertyIds;
	private Map<String, PropertyDeclaration> propertyDeclarations;
	private Map<String, Map<String, SelectionPropertyOption>> selectionPropertyOption;
	
	/**
	 * 
	 */
	public PropertyEnumerationHelper(String... propertyIds) {
		this(new ResourceSetImpl(), propertyIds);
	}
	
	public PropertyEnumerationHelper(ResourceSet resourceSet, String... propertyIds) {
		this.resourceSet = resourceSet;
		this.propertyIds = propertyIds;
	}

	public void initialize() {
		propertyDeclarations = new HashMap<String, PropertyDeclaration>();
		
		selectionPropertyOption = new HashMap<String, Map<String, SelectionPropertyOption>>();
		for (String propertyId : propertyIds) {
			selectionPropertyOption.put(propertyId, new HashMap<String, SelectionPropertyOption>());
		}
		
		for (URI uri : DefinitionRegistry.getInstance().getDefinitionResourceURIs()) {
			try {
				Resource resource = resourceSet.getResource(uri, true);
				for (TreeIterator<EObject> it = resource.getAllContents(); it.hasNext();) {
					EObject next = it.next();
					if (next instanceof PropertyDeclaration) {
						PropertyDeclaration propertyDeclaration = (PropertyDeclaration) next;
						propertyDeclarations.put(propertyDeclaration.getQualifiedName(), propertyDeclaration);
					} else if (next instanceof SelectionPropertyOption) {
						SelectionPropertyOption option = (SelectionPropertyOption) next;
						Map<String, SelectionPropertyOption> optionMap = selectionPropertyOption.get(option.getTarget().getQualifiedName());
						if (optionMap != null) {
							optionMap.put(option.getQualifiedName(), option);
						}
						it.prune();
					}
				}
			} catch (RuntimeException e) {
				DconfigPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, DconfigPlugin.PLUGIN_ID, "Error loading resource " + uri.toString(), e));
			}
		}
	}
	
	public PropertyDeclaration getPropertyDeclaration(String qualifiedName) {
		if (propertyDeclarations == null) {
			initialize();
		}
		return propertyDeclarations.get(qualifiedName);
	}

	public Collection<SelectionPropertyOption> getSelectionPropertyOption(String propertyId) {
		if (selectionPropertyOption == null) {
			initialize();
		}
		Map<String, SelectionPropertyOption> optionMap = selectionPropertyOption.get(propertyId);
		return optionMap != null ? optionMap.values() : null;
	}
	
	public SelectionPropertyOption getSelectionPropertyOption(String propertyId, String qualifiedName) {
		if (selectionPropertyOption == null) {
			initialize();
		}
		Map<String, SelectionPropertyOption> optionMap = selectionPropertyOption.get(propertyId);
		return optionMap != null ? optionMap.get(qualifiedName) : null;
	}
	
	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
}

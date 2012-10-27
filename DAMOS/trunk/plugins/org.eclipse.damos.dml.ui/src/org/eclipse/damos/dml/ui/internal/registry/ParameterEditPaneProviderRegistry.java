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

package org.eclipse.damos.dml.ui.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.damos.common.inject.Default;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.ui.editpane.IParameterEditPaneProvider;
import org.eclipse.damos.dml.ui.editpane.IValueSpecificationEditPane;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Andreas Unger
 *
 */
@Singleton
public class ParameterEditPaneProviderRegistry {

	private final IParameterEditPaneProvider defaultProvider;
	
	private List<IParameterEditPaneProvider> providers = new ArrayList<IParameterEditPaneProvider>();
	
	/**
	 * 
	 */
	@Inject
	ParameterEditPaneProviderRegistry(@Default IParameterEditPaneProvider defaultProvider) {
		this.defaultProvider = defaultProvider;
		initializeFromStorage();
	}

	public IValueSpecificationEditPane createEditPane(Parameter parameter) {
		for (IParameterEditPaneProvider provider : providers) {
			IValueSpecificationEditPane editPane = provider.createEditPane(parameter);
			if (editPane != null) {
				return editPane;
			}
		}
		return defaultProvider.createEditPane(parameter);
	}
		
	public Collection<IParameterEditPaneProvider> getProviders() {
		return providers;
	}

	public void register(IParameterEditPaneProvider provider) {
		providers.add(provider);
	}
	
	public void unregister(IParameterEditPaneProvider provider) {
		providers.remove(provider);
	}

	private void initializeFromStorage() {
		ParameterEditPaneProviderRegistryReader reader = new ParameterEditPaneProviderRegistryReader();
		reader.registerProviders(this);
	}
	
}

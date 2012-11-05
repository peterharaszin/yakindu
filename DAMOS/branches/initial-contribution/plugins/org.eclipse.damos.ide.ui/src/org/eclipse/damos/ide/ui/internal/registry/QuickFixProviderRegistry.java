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

package org.eclipse.damos.ide.ui.internal.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.damos.ide.ui.quickfix.IQuickFixProvider;

/**
 * @author Andreas Unger
 *
 */
public class QuickFixProviderRegistry {
	
	private static final QuickFixProviderRegistry INSTANCE = new QuickFixProviderRegistry();

	private List<IQuickFixProvider> providers = new ArrayList<IQuickFixProvider>();
	
	/**
	 * 
	 */
	private QuickFixProviderRegistry() {
		initializeFromStorage();
	}

	/**
	 * @return the instance
	 */
	public static QuickFixProviderRegistry getInstance() {
		return INSTANCE;
	}
	
	public Collection<IQuickFixProvider> getProviders() {
		return providers;
	}
	
	public Collection<IQuickFix> getQuickFixes(Problem problem) {
		List<IQuickFix> allQuickFixes = Collections.emptyList();
		for (IQuickFixProvider provider : providers) {
			Collection<IQuickFix> quickFixes = provider.getQuickFixes(problem);
			if (quickFixes != null && !quickFixes.isEmpty()) {
				if (allQuickFixes.isEmpty()) {
					allQuickFixes = new ArrayList<IQuickFix>();
				}
				allQuickFixes.addAll(quickFixes);
			}
		}
		return allQuickFixes;
	}

	public void register(IQuickFixProvider provider) {
		providers.add(provider);
	}
	
	public void unregister(IQuickFixProvider provider) {
		providers.remove(provider);
	}

	private void initializeFromStorage() {
		QuickFixProviderRegistryReader reader = new QuickFixProviderRegistryReader();
		reader.registerProviders(this);
	}
	
}

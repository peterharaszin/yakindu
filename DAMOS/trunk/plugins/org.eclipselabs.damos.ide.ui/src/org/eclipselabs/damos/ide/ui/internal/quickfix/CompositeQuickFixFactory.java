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

package org.eclipselabs.damos.ide.ui.internal.quickfix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class CompositeQuickFixFactory extends AbstractQuickFixFactory implements IQuickFixFactory {

	private final List<IQuickFixFactory> quickFixFactories = new ArrayList<IQuickFixFactory>();
	
	public void add(IQuickFixFactory factory) {
		quickFixFactories.add(factory);
	}
	
	public Collection<IQuickFix> createQuickFixes(Problem problem, TransactionalEditingDomain editingDomain) throws InstantiationException, IllegalAccessException {
		List<IQuickFix> allQuickFixes = Collections.emptyList();
		for (IQuickFixFactory factory : quickFixFactories) {
			Collection<IQuickFix> quickFixes = factory.createQuickFixes(problem, editingDomain);
			if (quickFixes != null && !quickFixes.isEmpty()) {
				if (allQuickFixes.isEmpty()) {
					allQuickFixes = new ArrayList<IQuickFix>();
				}
				allQuickFixes.addAll(quickFixes);
			}
		}
		return allQuickFixes;
	}

}

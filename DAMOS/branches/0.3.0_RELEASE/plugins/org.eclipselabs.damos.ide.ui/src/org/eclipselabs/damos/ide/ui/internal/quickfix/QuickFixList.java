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
import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.quickfix.IQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class QuickFixList implements IQuickFixFactory {

	private List<IQuickFix> quickFixes = new ArrayList<IQuickFix>();
	
	public void add(IQuickFix quickFix) {
		quickFixes.add(quickFix);
	}
	
	public static QuickFixList singleton(IQuickFix quickFix) {
		QuickFixList list = new QuickFixList();
		list.add(quickFix);
		return list;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.internal.quickfix.IQuickFixFactory#createQuickFixes(org.eclipselabs.damos.ide.core.validation.Problem)
	 */
	public Collection<IQuickFix> createQuickFixes(Problem problem) throws InstantiationException,
			IllegalAccessException {
		return quickFixes;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.internal.quickfix.IQuickFixFactory#createQuickFixes(org.eclipselabs.damos.ide.core.validation.Problem, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	public Collection<IQuickFix> createQuickFixes(Problem problem, TransactionalEditingDomain editingDomain)
			throws InstantiationException, IllegalAccessException {
		return quickFixes;
	}

}

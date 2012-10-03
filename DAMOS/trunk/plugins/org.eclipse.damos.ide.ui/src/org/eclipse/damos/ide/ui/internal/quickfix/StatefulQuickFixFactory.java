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

package org.eclipse.damos.ide.ui.internal.quickfix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Andreas Unger
 *
 */
public class StatefulQuickFixFactory extends AbstractQuickFixFactory {

	private final List<Class<? extends IStatefulQuickFix>> quickFixClasses = new ArrayList<Class<? extends IStatefulQuickFix>>();
	
	public void add(Class<? extends IStatefulQuickFix> clazz) {
		quickFixClasses.add(clazz);
	}

	public Collection<IQuickFix> createQuickFixes(Problem problem, TransactionalEditingDomain editingDomain) throws InstantiationException, IllegalAccessException {
		List<IQuickFix> quickFixes = new ArrayList<IQuickFix>();
		for (Class<? extends IStatefulQuickFix> clazz : quickFixClasses) {
			IStatefulQuickFix quickFix = clazz.newInstance();
			if (quickFix.initialize(problem, editingDomain)) {
				quickFixes.add(quickFix);
			}
		}
		return quickFixes;
	}
	
}

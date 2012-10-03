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

import java.util.Collection;

import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.internal.util.IDEUtil;
import org.eclipse.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipse.damos.ide.ui.quickfix.IQuickFix;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractQuickFixFactory implements IQuickFixFactory {

	public Collection<IQuickFix> createQuickFixes(Problem problem) throws InstantiationException, IllegalAccessException {
		URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
		if (uri == null) {
			return null;
		}
		
		TransactionalEditingDomain editingDomain = IDEUtil.findEditorEditingDomain(uri);
		if (editingDomain != null) {
			return createQuickFixes(problem, editingDomain);
		}
		
		editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		Collection<IQuickFix> quickFixes = createQuickFixes(problem, editingDomain);
		editingDomain.dispose();
		
		return quickFixes;
	}

}
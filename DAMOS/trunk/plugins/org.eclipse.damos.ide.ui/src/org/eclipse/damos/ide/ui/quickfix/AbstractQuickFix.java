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

package org.eclipse.damos.ide.ui.quickfix;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.IDEUIPlugin;
import org.eclipse.damos.ide.ui.internal.util.IDEUtil;
import org.eclipse.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractQuickFix implements IQuickFix {
	
	public final void run(Problem problem) {
		URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
		if (uri == null) {
			return;
		}
		
		TransactionalEditingDomain editingDomain = IDEUtil.findEditorEditingDomain(uri);
		if (editingDomain != null) {
			run(problem, editingDomain);
		} else {
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();

			run(problem, editingDomain);
			
			ResourceSet resourceSet = editingDomain.getResourceSet();
			Resource resource = resourceSet.getResource(uri.trimFragment(), true);
			try {
				resource.save(Collections.emptyMap());
			} catch (IOException e) {
				IDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, IDEUIPlugin.PLUGIN_ID, "Quick fix '" + getLabel() + "' failed", e));
			}
			
			editingDomain.dispose();
		}
	}

	protected abstract void run(Problem problem, TransactionalEditingDomain editingDomain);

}

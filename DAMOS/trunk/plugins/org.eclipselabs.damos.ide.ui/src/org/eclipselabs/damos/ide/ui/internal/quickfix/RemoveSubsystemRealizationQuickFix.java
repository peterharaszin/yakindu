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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.graphics.Image;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix;

/**
 * @author Andreas Unger
 *
 */
public class RemoveSubsystemRealizationQuickFix extends AbstractQuickFix {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getImage()
	 */
	public Image getImage() {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.IQuickFix#getLabel()
	 */
	public String getLabel() {
		return "Remove subsystem realization";
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.ide.ui.quickfix.AbstractQuickFix#run(org.eclipselabs.damos.ide.core.validation.Problem, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	protected void run(Problem problem, TransactionalEditingDomain editingDomain) {
		URI uri = ProblemUtil.getPlatformResourceElementURI(problem);
		if (uri == null) {
			return;
		}
		
		final SubsystemRealization realization = (SubsystemRealization) editingDomain.getResourceSet().getEObject(uri, true);
		if (realization == null) {
			return;
		}

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Remove Subsystem Realization") {
			
			@Override
			protected void doExecute() {
				EcoreUtil.remove(realization);
			}
			
		});
	}

}

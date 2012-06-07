/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

public abstract class AbstractPopupMenuContributionPolicy implements IPopupMenuContributionPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.IPopupMenuContributionPolicy#appliesTo(org.eclipse.jface.viewers.ISelection, org.eclipse.core.runtime.IConfigurationElement)
	 */
	public final boolean appliesTo(ISelection selection, IConfigurationElement configuration) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
				Object next = it.next();
				if (!(next instanceof IGraphicalEditPart && appliesTo((IGraphicalEditPart) next))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	protected abstract boolean appliesTo(IGraphicalEditPart editPart);

}

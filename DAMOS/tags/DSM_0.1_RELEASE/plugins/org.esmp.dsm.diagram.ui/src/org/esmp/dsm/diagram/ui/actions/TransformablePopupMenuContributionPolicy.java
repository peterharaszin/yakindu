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

package org.esmp.dsm.diagram.ui.actions;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.esmp.dsm.diagram.ui.editpolicies.EditPolicyRoles;

public class TransformablePopupMenuContributionPolicy extends AbstractPopupMenuContributionPolicy {

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.actions.AbstractPopupMenuContributionPolicy#appliesTo(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	protected boolean appliesTo(IGraphicalEditPart editPart) {
		return editPart.getEditPolicy(EditPolicyRoles.TRANSFORM_ROLE) != null;
	}
	
}

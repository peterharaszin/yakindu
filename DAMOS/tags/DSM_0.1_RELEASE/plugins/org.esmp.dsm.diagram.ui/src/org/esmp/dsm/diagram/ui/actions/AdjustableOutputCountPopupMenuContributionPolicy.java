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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.esmp.dsm.diagram.ui.editpolicies.EditPolicyRoles;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.IOSpecification;
import org.esmp.dsm.semantic.blockdiagram.Output;

public class AdjustableOutputCountPopupMenuContributionPolicy extends AbstractPopupMenuContributionPolicy {

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.actions.AbstractPopupMenuContributionPolicy#appliesTo(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	protected boolean appliesTo(IGraphicalEditPart editPart) {
		EditPolicy editPolicy = editPart.getEditPolicy(EditPolicyRoles.ADJUST_OUTPUT_COUNT_ROLE);
		if (editPolicy == null) {
			return false;
		}
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof Block) {
			Block block = (Block) o;
			List<Output> outputs = block.getOutputs();
			if (outputs.size() == 1) {
				IOSpecification ioSpecification = outputs.get(0).getSpecification();
				if (ioSpecification.getMinimumPortCount() != ioSpecification.getMaximumPortCount()) {
					return true;
				}
			}
		}
		return false;
	}
	
}

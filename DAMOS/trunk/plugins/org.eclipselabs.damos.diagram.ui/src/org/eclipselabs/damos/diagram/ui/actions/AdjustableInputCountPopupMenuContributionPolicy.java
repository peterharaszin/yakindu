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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputDefinition;

public class AdjustableInputCountPopupMenuContributionPolicy extends AbstractPopupMenuContributionPolicy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.actions.AbstractPopupMenuContributionPolicy#appliesTo(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	protected boolean appliesTo(IGraphicalEditPart editPart) {
		EditPolicy editPolicy = editPart.getEditPolicy(IEditPolicyRoles.ADJUST_INPUT_COUNT_ROLE);
		if (editPolicy == null) {
			return false;
		}
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof Component) {
			Component component = (Component) o;
			List<Input> inputs = component.getInputs();
			if (inputs.size() == 1) {
				Input input = inputs.get(0);
				if (input instanceof BlockInput) {
					InputDefinition definition = ((BlockInput) input).getDefinition();
					if (definition.getMinimumPortCount() != definition.getMaximumPortCount()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}

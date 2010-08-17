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
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputDefinition;

public class OutputPortCountPopupMenuContributionPolicy extends AbstractPopupMenuContributionPolicy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.actions.AbstractPopupMenuContributionPolicy#appliesTo(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart)
	 */
	protected boolean appliesTo(IGraphicalEditPart editPart) {
		EditPolicy editPolicy = editPart.getEditPolicy(IEditPolicyRoles.OUTPUT_PORT_COUNT_ROLE);
		if (editPolicy == null) {
			return false;
		}
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof Component) {
			Component component = (Component) o;
			List<Output> outputs = component.getOutputs();
			if (outputs.size() == 1) {
				Output output = outputs.get(0);
				if (output instanceof BlockOutput) {
					OutputDefinition definition = ((BlockOutput) output).getDefinition();
					if (definition.getMinimumPortCount() != definition.getMaximumPortCount()) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
}

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

package org.esmp.dsm.diagram.ui.editparts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editpolicies.EditPolicyRoles;
import org.esmp.dsm.diagram.ui.editpolicies.TerminalEditPolicy;
import org.esmp.dsm.diagram.ui.internal.editparts.ParameterNotificationHelper;
import org.esmp.dsm.semantic.blockdiagram.Port;

public abstract class PortEditPart extends ShapeNodeEditPart {

	private ParameterNotificationHelper parameterNotificationHelper = new ParameterNotificationHelper(this);
	
	public PortEditPart(View view) {
		super(view);
	}

	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicyRoles.TERMINAL_ROLE, new TerminalEditPolicy());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#addSemanticListeners()
	 */
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = resolveSemanticElement();
		if (o instanceof Port) {
			parameterNotificationHelper.addSemanticListeners(((Port) o).getParameters());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeSemanticListeners()
	 */
	protected void removeSemanticListeners() {
		parameterNotificationHelper.removeSemanticListeners();
		super.removeSemanticListeners();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#isSelectable()
	 */
	public boolean isSelectable() {
		return false;
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart#refreshBounds()
	 */
	protected void refreshBounds() {
		// Do nothing
	}
	
}
